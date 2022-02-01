package com.tencent.aekit.openrender.internal;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.util.RenderMonitor;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VideoFilterBase
  extends AEChainI
  implements AEFilterI
{
  private static final String BASIC_VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 tMat;\nvoid main(void)\n{\n   gl_Position = Projection * Modelview *position;\n   vec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\n   textureCoordinate = tmp.xy;\n}";
  public static final String DefaultFragmentShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
  private static boolean mDumpFilterParams = false;
  public String dataPath;
  private String fragmentShader;
  protected int height;
  private Map<String, AttributeParam> mAttrParams;
  private int mCoordNum;
  private AEOpenRenderConfig.DRAW_MODE mDrawMode;
  protected double mFaceDetScale;
  protected int mFilterProjHandle;
  protected float[] mFilterProjMat = new float[16];
  protected int mFilterViewHandle;
  protected float[] mFilterViewMat = new float[16];
  private Map<String, UniformParam> mParamList;
  private int mRenderMode;
  protected int mSTextureHandle;
  protected float[] mTMat = new float[16];
  protected int mTMatHandle;
  protected Shader shader;
  private int srcTexture = 0;
  private String vertexShader;
  protected int width;
  
  public VideoFilterBase(Shader paramShader)
  {
    this(paramShader.getVertexShaderSource(), paramShader.getFragmentShaderSource());
  }
  
  public VideoFilterBase(String paramString)
  {
    this("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 tMat;\nvoid main(void)\n{\n   gl_Position = Projection * Modelview *position;\n   vec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\n   textureCoordinate = tmp.xy;\n}", paramString);
  }
  
  public VideoFilterBase(String paramString1, String paramString2)
  {
    initFilter();
    this.vertexShader = paramString1;
    this.fragmentShader = paramString2;
  }
  
  private void checkInputOutputValid(VideoFilterBase paramVideoFilterBase, Frame paramFrame, int paramInt)
  {
    if (paramInt == paramFrame.getTextureId())
    {
      Log.e("VideoFilterBase", "input and output texture is same!");
      if (AEOpenRenderConfig.isEnableLog()) {
        paramFrame.printBackTracing();
      }
    }
    paramVideoFilterBase = paramVideoFilterBase.mParamList.values().iterator();
    while (paramVideoFilterBase.hasNext())
    {
      UniformParam localUniformParam = (UniformParam)paramVideoFilterBase.next();
      if (((localUniformParam instanceof UniformParam.TextureParam)) && (((UniformParam.TextureParam)localUniformParam).texture[0] == paramFrame.getTextureId()))
      {
        Log.e("VideoFilterBase", "input and output texture is same!");
        if (AEOpenRenderConfig.isEnableLog()) {
          paramFrame.printBackTracing();
        }
      }
    }
  }
  
  private void flipX(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFilterViewMat[0] = (-this.mFilterViewMat[0]);
      this.mFilterViewMat[1] = (-this.mFilterViewMat[1]);
      this.mFilterViewMat[2] = (-this.mFilterViewMat[2]);
      this.mFilterViewMat[3] = (-this.mFilterViewMat[3]);
    }
  }
  
  private void flipY(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFilterViewMat[4] = (-this.mFilterViewMat[4]);
      this.mFilterViewMat[5] = (-this.mFilterViewMat[5]);
      this.mFilterViewMat[6] = (-this.mFilterViewMat[6]);
      this.mFilterViewMat[7] = (-this.mFilterViewMat[7]);
    }
  }
  
  private void initFilter()
  {
    this.mAttrParams = new HashMap();
    this.mParamList = new HashMap();
    this.mSTextureHandle = -1;
    this.mFilterProjHandle = -1;
    this.mFilterViewHandle = -1;
    this.mTMatHandle = -1;
    Matrix.setIdentityM(this.mFilterProjMat, 0);
    Matrix.setIdentityM(this.mFilterViewMat, 0);
    Matrix.setIdentityM(this.mTMat, 0);
    this.mCoordNum = 4;
    this.mDrawMode = AEOpenRenderConfig.DRAW_MODE.TRIANGLE_FAN;
    this.mRenderMode = AEOpenRenderConfig.glMode;
  }
  
  private void rotate(int paramInt)
  {
    Matrix.setIdentityM(this.mFilterViewMat, 0);
    float f1 = (float)Math.cos(paramInt * 3.1415926D / 180.0D);
    float f2 = (float)Math.sin(paramInt * 3.1415926D / 180.0D);
    this.mFilterViewMat[0] = f1;
    this.mFilterViewMat[1] = (-f2);
    this.mFilterViewMat[4] = f2;
    this.mFilterViewMat[5] = f1;
  }
  
  public static void setDumpFilterParams(boolean paramBoolean)
  {
    mDumpFilterParams = paramBoolean;
  }
  
  public void ApplyGLSLFilter()
  {
    initAttribParams();
    this.shader = new Shader(this.vertexShader, this.fragmentShader);
    this.shader.compile();
    AEOpenRenderConfig.checkStrictMode(isValid(), "filter is not valid");
    if (this.shader == null) {
      return;
    }
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).initialParams(this.shader.getShaderProgram());
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).initialParams(this.shader.getShaderProgram());
    }
    this.mSTextureHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "inputImageTexture");
    this.mFilterProjHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "Projection");
    this.mFilterViewHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "Modelview");
    this.mTMatHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "tMat");
  }
  
  public void OnDrawFrameGLSL()
  {
    boolean bool;
    if (this.shader != null)
    {
      bool = true;
      AEOpenRenderConfig.checkStrictMode(bool, "shader == null");
      if (this.shader != null) {
        break label28;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label28:
      this.shader.bind();
      Iterator localIterator = this.mParamList.values().iterator();
      while (localIterator.hasNext()) {
        ((UniformParam)localIterator.next()).setParams(this.shader.getShaderProgram());
      }
      localIterator = this.mAttrParams.values().iterator();
      while (localIterator.hasNext())
      {
        AttributeParam localAttributeParam = (AttributeParam)localIterator.next();
        if ((localAttributeParam.handle >= 0) && (this.shader != null)) {
          localAttributeParam.setParams(this.shader.getShaderProgram());
        }
      }
    }
  }
  
  public void OnDrawFrameGLSLSuper()
  {
    boolean bool;
    if (this.shader != null)
    {
      bool = true;
      AEOpenRenderConfig.checkStrictMode(bool, "shader == null");
      if (this.shader != null) {
        break label28;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label28:
      this.shader.bind();
      Iterator localIterator = this.mParamList.values().iterator();
      while (localIterator.hasNext()) {
        ((UniformParam)localIterator.next()).setParams(this.shader.getShaderProgram());
      }
    }
  }
  
  public Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    beforeRender(paramInt1, paramInt2, paramInt3);
    Frame localFrame = FrameBufferCache.getInstance().get(paramInt2, paramInt3);
    localFrame.bindFrame(-1, paramInt2, paramInt3, 0.0D);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    checkInputOutputValid(this, localFrame, paramInt1);
    return localFrame;
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return render(paramFrame);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    beforeRender(paramInt1, paramInt2, paramInt3);
    paramFrame.bindFrame(paramInt4, paramInt2, paramInt3, paramDouble);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void addAttribParam(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam == null) {
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramAttributeParam.name);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramAttributeParam.name, paramAttributeParam.vertices, paramAttributeParam.perVertexFloat, false);
      if (this.shader != null) {
        localAttributeParam1.initialParams(this.shader.getShaderProgram());
      }
      this.mAttrParams.put(paramAttributeParam.name, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramAttributeParam.vertices);
    localAttributeParam1.perVertexFloat = paramAttributeParam.perVertexFloat;
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat)
  {
    addAttribParam(paramString, paramArrayOfFloat, false);
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramString);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramString, paramArrayOfFloat, paramBoolean);
      if (this.shader != null) {
        localAttributeParam1.initialParams(this.shader.getShaderProgram());
      }
      this.mAttrParams.put(paramString, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramArrayOfFloat);
  }
  
  public void addParam(UniformParam paramUniformParam)
  {
    if (paramUniformParam == null) {}
    UniformParam localUniformParam;
    do
    {
      return;
      localUniformParam = (UniformParam)this.mParamList.get(paramUniformParam.name);
      if (localUniformParam != null) {
        break;
      }
      this.mParamList.put(paramUniformParam.name, paramUniformParam);
    } while (this.shader == null);
    paramUniformParam.initialParams(this.shader.getShaderProgram());
    return;
    paramUniformParam.handle = localUniformParam.handle;
    this.mParamList.put(paramUniformParam.name, paramUniformParam);
  }
  
  public void apply()
  {
    ApplyGLSLFilter();
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean canUseBlendMode()
  {
    return false;
  }
  
  public void clearGLSLSelf()
  {
    if (this.shader != null) {
      this.shader.clear();
    }
    this.shader = null;
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).clear();
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).clear();
    }
  }
  
  public String dump()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("class = %s\n", new Object[] { getClass().getName() }));
    localStringBuilder.append(String.format("uniform inputImageTexture = %s\n", new Object[] { String.valueOf(this.srcTexture) }));
    localStringBuilder.append(String.format("uniform Projection = %s\n", new Object[] { Arrays.toString(this.mFilterProjMat) }));
    localStringBuilder.append(String.format("uniform Modelview = %s\n", new Object[] { Arrays.toString(this.mFilterViewMat) }));
    localStringBuilder.append(String.format("uniform tMat = %s\n", new Object[] { Arrays.toString(this.mTMat) }));
    Object localObject = this.mAttrParams.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(String.format("attribute %s\n", new Object[] { ((AttributeParam)((Iterator)localObject).next()).toString() }));
    }
    localObject = this.mParamList.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(String.format("uniform %s \n", new Object[] { ((UniformParam)((Iterator)localObject).next()).toString() }));
    }
    localObject = new boolean[1];
    GLES20.glGetBooleanv(3042, (boolean[])localObject, 0);
    localStringBuilder.append(String.format("blend enable = " + localObject[0] + "\n", new Object[0]));
    GLES20.glGetBooleanv(2929, (boolean[])localObject, 0);
    localStringBuilder.append(String.format("depth test enable = " + localObject[0] + "\n", new Object[0]));
    return localStringBuilder.toString();
  }
  
  public AttributeParam getAttribParam(String paramString)
  {
    return (AttributeParam)this.mAttrParams.get(paramString);
  }
  
  public int getProgramIds()
  {
    return this.shader.getShaderProgram();
  }
  
  public void initAttribParams()
  {
    if (this.mAttrParams.get("position") == null) {
      setPositions(AEOpenRenderConfig.ORIGIN_POSITION_COORDS);
    }
    if (this.mAttrParams.get("inputTextureCoordinate") == null) {
      setTexCords(AEOpenRenderConfig.ORIGIN_TEX_COORDS);
    }
  }
  
  public void initParams() {}
  
  public boolean isValid()
  {
    return (this.shader != null) && (this.shader.getShaderProgram() > 0);
  }
  
  public Frame render(Frame paramFrame)
  {
    return RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    this.srcTexture = paramInt1;
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.mSTextureHandle, 0);
    GLES20.glUniformMatrix4fv(this.mFilterProjHandle, 1, false, FloatBuffer.wrap(this.mFilterProjMat));
    GLES20.glUniformMatrix4fv(this.mFilterViewHandle, 1, false, FloatBuffer.wrap(this.mFilterViewMat));
    GLES20.glUniformMatrix4fv(this.mTMatHandle, 1, false, FloatBuffer.wrap(this.mTMat));
    if (mDumpFilterParams) {
      RenderMonitor.record(getClass().getSimpleName(), dump());
    }
    if (this.mDrawMode == AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP)
    {
      GLES20.glDrawArrays(5, 0, this.mCoordNum);
      if (this.mRenderMode != 0) {
        break label284;
      }
      GLES20.glFinish();
    }
    label284:
    while (this.mRenderMode != 1)
    {
      return true;
      if (this.mDrawMode == AEOpenRenderConfig.DRAW_MODE.TRIANGLES)
      {
        GLES20.glDrawArrays(4, 0, this.mCoordNum);
        break;
      }
      if (this.mDrawMode == AEOpenRenderConfig.DRAW_MODE.TRIANGLE_FAN)
      {
        GLES20.glDrawArrays(6, 0, this.mCoordNum);
        break;
      }
      if (this.mDrawMode == AEOpenRenderConfig.DRAW_MODE.LINES)
      {
        GLES20.glDrawArrays(1, 0, this.mCoordNum);
        break;
      }
      if (this.mDrawMode == AEOpenRenderConfig.DRAW_MODE.LINES_STRIP)
      {
        GLES20.glDrawArrays(3, 0, this.mCoordNum);
        break;
      }
      if (this.mDrawMode != AEOpenRenderConfig.DRAW_MODE.POINTS) {
        break;
      }
      GLES20.glDrawArrays(0, 0, this.mCoordNum);
      break;
    }
    GLES20.glFlush();
    return true;
  }
  
  public boolean setCoordNum(int paramInt)
  {
    this.mCoordNum = paramInt;
    return true;
  }
  
  public void setDrawMode(AEOpenRenderConfig.DRAW_MODE paramDRAW_MODE)
  {
    this.mDrawMode = paramDRAW_MODE;
  }
  
  public boolean setGrayCords(float[] paramArrayOfFloat)
  {
    addAttribParam("inputGrayTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat);
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    addAttribParam("position", paramArrayOfFloat, paramBoolean);
    return true;
  }
  
  public boolean setRenderMode(int paramInt)
  {
    this.mRenderMode = paramInt;
    return true;
  }
  
  public void setRotationAndFlip(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    rotate(paramInt);
    flipX(paramBoolean1);
    flipY(paramBoolean2);
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat, paramBoolean);
    return true;
  }
  
  public void updateFilterShader(Shader paramShader)
  {
    this.vertexShader = paramShader.getVertexShaderSource();
    this.fragmentShader = paramShader.getFragmentShaderSource();
  }
  
  public void updateFilterShader(String paramString1, String paramString2)
  {
    this.vertexShader = paramString1;
    this.fragmentShader = paramString2;
  }
  
  public boolean updateMatrix(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 16)) {
      return false;
    }
    this.mTMat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    return true;
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updatePreview(Object paramObject, int paramInt1, int paramInt2) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.mFaceDetScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.internal.VideoFilterBase
 * JD-Core Version:    0.7.0.1
 */