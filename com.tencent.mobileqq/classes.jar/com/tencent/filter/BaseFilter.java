package com.tencent.filter;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.SoInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseFilter
  extends AEChainI
{
  public static final String DefaultFragmentShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
  private static final String TAG = "BaseFilter";
  protected String glslProgramShader;
  protected String glslVertextShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 textureMat; \nuniform mat4 tMat;\nvoid main(void)\n{\ngl_Position = Projection * Modelview *position;\nvec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\ntextureCoordinate = tmp.xy;\n}";
  private long mGlFilterId = 0L;
  protected boolean mIsGPU = true;
  protected boolean mIsPreviewFilter;
  private BaseFilter mNextFilter;
  protected ParamHelper mParamHelper = null;
  private Map<String, UniformParam> mParamList = new HashMap();
  private int mProgramIds;
  private int[] mTextureIndexMap;
  public boolean needFlipBlend = false;
  private boolean needReleaseFrame = false;
  private float outPutScaleFactor = 1.0F;
  public float scaleFact = 1.0F;
  protected int srcTextureIndex = -1;
  
  public BaseFilter(String paramString)
  {
    this.glslProgramShader = paramString;
  }
  
  public BaseFilter(String paramString1, String paramString2)
  {
    this.glslVertextShader = paramString1;
    this.glslProgramShader = paramString2;
  }
  
  private void applyInternal()
  {
    setRenderMode(AEOpenRenderConfig.glMode);
    this.mProgramIds = nativeApplyFilter(this.mGlFilterId, 0L);
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).initialParams(this.mProgramIds);
    }
  }
  
  private void checkInputOutputValid(BaseFilter paramBaseFilter, Frame paramFrame, int paramInt)
  {
    Object localObject;
    if (paramInt == paramFrame.getTextureId())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("input and output texture is same! Same texture id is ");
      ((StringBuilder)localObject).append(paramFrame.getTextureId());
      Log.e("BaseFilter", ((StringBuilder)localObject).toString());
      AEOpenRenderConfig.isEnableLog();
    }
    paramBaseFilter = paramBaseFilter.mParamList.values().iterator();
    while (paramBaseFilter.hasNext())
    {
      localObject = (UniformParam)paramBaseFilter.next();
      if (((localObject instanceof UniformParam.TextureParam)) && (((UniformParam.TextureParam)localObject).texture[0] == paramFrame.getTextureId()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("input and output texture is same! Same texture id is ");
        ((StringBuilder)localObject).append(paramFrame.getTextureId());
        Log.e("BaseFilter", ((StringBuilder)localObject).toString());
        AEOpenRenderConfig.isEnableLog();
      }
    }
  }
  
  private Frame findFrame(Frame paramFrame, int paramInt)
  {
    while (paramFrame != null)
    {
      if (paramInt == 0) {
        return paramFrame;
      }
      paramFrame = paramFrame.nextFrame;
      paramInt -= 1;
    }
    return null;
  }
  
  public static String getFilterShader(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 1;
    }
    try
    {
      String str = nativeGetFilterShader(i, paramInt);
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogUtils.e(TAG, localUnsatisfiedLinkError.toString());
    }
    return "";
  }
  
  public static String getFragmentShader(int paramInt)
  {
    return getFilterShader(true, paramInt);
  }
  
  public static int getVersionCode()
  {
    return nativeGetVersion();
  }
  
  public static String getVertexShader(int paramInt)
  {
    return getFilterShader(false, paramInt);
  }
  
  private void initFilterShader(int paramInt)
  {
    String str1 = this.glslProgramShader;
    if (str1 != null)
    {
      String str2 = this.glslVertextShader;
      if (str2 != null) {
        try
        {
          this.mGlFilterId = nativeInitialWithString(this.mGlFilterId, paramInt, str2, str1);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          LogUtils.e(TAG, localUnsatisfiedLinkError.toString());
        }
      }
    }
  }
  
  @SoInfo(libName="image_filter_common")
  private native int nativeApplyFilter(long paramLong1, long paramLong2);
  
  @SoInfo(libName="image_filter_common")
  private native boolean nativeClear(long paramLong);
  
  @SoInfo(libName="image_filter_common")
  public static native String nativeDecrypt(String paramString);
  
  @SoInfo(libName="image_filter_gpu")
  private static native String nativeGetFilterShader(int paramInt1, int paramInt2);
  
  @SoInfo(libName="image_filter_common")
  private static native int nativeGetVersion();
  
  @SoInfo(libName="image_filter_common")
  private native long nativeInitialWithString(long paramLong, int paramInt, String paramString1, String paramString2);
  
  @SoInfo(libName="image_filter_common")
  private native boolean nativeRenderTexture(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  @SoInfo(libName="image_filter_common")
  private native boolean nativeSetGlobalTextureMatrix(long paramLong, float[] paramArrayOfFloat);
  
  @SoInfo(libName="image_filter_common")
  private native boolean nativeSetPositions(long paramLong, float[] paramArrayOfFloat);
  
  @SoInfo(libName="image_filter_common")
  private native boolean nativeSetRenderMode(long paramLong, int paramInt);
  
  @SoInfo(libName="image_filter_common")
  private native boolean nativeSetRotationAndFlip(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  @SoInfo(libName="image_filter_common")
  private native boolean nativeSetTexCords(long paramLong, float[] paramArrayOfFloat);
  
  @SoInfo(libName="image_filter_common")
  private native boolean nativeUpdateMatrix(long paramLong, float[] paramArrayOfFloat);
  
  public void OnDrawFrameGLSL()
  {
    GLES20.glUseProgram(this.mProgramIds);
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).setParams(this.mProgramIds);
    }
  }
  
  public Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    return RenderProcess(paramInt1, paramInt2, paramInt3, paramInt2, paramInt3);
  }
  
  public Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = new Frame();
    int i = 0;
    Object localObject2 = this;
    Frame localFrame;
    while (localObject2 != null)
    {
      if (localObject2 == this) {
        ((BaseFilter)localObject2).beforeRender(paramInt1, paramInt2, paramInt3);
      } else {
        ((BaseFilter)localObject2).beforeRender(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height);
      }
      ((Frame)localObject1).needReleaseFrame = ((BaseFilter)localObject2).needReleaseFrame;
      float f1;
      float f2;
      int j;
      int k;
      if (((BaseFilter)localObject2).mNextFilter == null)
      {
        f1 = paramInt4;
        f2 = ((BaseFilter)localObject2).scaleFact;
        float f3 = this.outPutScaleFactor;
        j = (int)(f1 * f2 * f3);
        k = (int)(paramInt5 * f2 * f3);
      }
      else
      {
        f1 = paramInt4;
        f2 = ((BaseFilter)localObject2).scaleFact;
        j = (int)(f1 * f2);
        k = (int)(paramInt5 * f2);
      }
      localFrame = FrameBufferCache.getInstance().get(j, k);
      localFrame.bindFrame(-1, j, k, 0.0D);
      localHashMap.put(Integer.valueOf(i), localFrame);
      ((BaseFilter)localObject2).OnDrawFrameGLSL();
      Object localObject3 = ((BaseFilter)localObject2).mTextureIndexMap;
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        j = 0;
        for (;;)
        {
          localObject3 = ((BaseFilter)localObject2).mTextureIndexMap;
          if (j >= localObject3.length) {
            break;
          }
          if (localObject3[j] < 0)
          {
            ((BaseFilter)localObject2).setTextureParam(paramInt1, j);
          }
          else
          {
            localObject3 = (Frame)localHashMap.get(Integer.valueOf(localObject3[j]));
            if (localObject3 != null) {
              ((BaseFilter)localObject2).setTextureParam(((Frame)localObject3).getTextureId(), j);
            } else {
              Log.e(TAG, "frame not found!");
            }
          }
          j += 1;
        }
      }
      if (localObject2 == this)
      {
        ((BaseFilter)localObject2).renderTexture(paramInt1, paramInt2, paramInt3);
        j = paramInt1;
      }
      else
      {
        k = ((Frame)localObject1).getTextureId();
        ((BaseFilter)localObject2).renderTexture(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height);
        j = k;
        if (((Frame)localObject1).needReleaseFrame)
        {
          ((Frame)localObject1).clearSelf();
          j = k;
        }
      }
      checkInputOutputValid((BaseFilter)localObject2, localFrame, j);
      localObject2 = ((BaseFilter)localObject2).mNextFilter;
      localObject1 = localFrame;
      i += 1;
    }
    localObject2 = localHashMap.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localFrame = (Frame)((Iterator)localObject2).next();
      if (localFrame != localObject1) {
        FrameBufferCache.getInstance().put(localFrame);
      }
    }
    return localObject1;
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    RenderProcess(paramInt1, paramInt2, paramInt3, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, Frame paramFrame)
  {
    if (paramFrame == null) {
      return;
    }
    Object localObject4 = this;
    Object localObject2 = paramFrame;
    Object localObject1 = localObject2;
    Object localObject3 = localObject2;
    localObject2 = localObject4;
    while (localObject2 != null)
    {
      if (localObject2 == this) {
        ((BaseFilter)localObject2).beforeRender(paramInt1, paramInt2, paramInt3);
      } else {
        ((BaseFilter)localObject2).beforeRender(localObject3.getTextureId(), localObject3.width, localObject3.height);
      }
      ((Frame)localObject1).needReleaseFrame = ((BaseFilter)localObject2).needReleaseFrame;
      float f1;
      float f2;
      if (((BaseFilter)localObject2).mNextFilter == null)
      {
        f1 = paramInt4;
        f2 = ((BaseFilter)localObject2).scaleFact;
        float f3 = this.outPutScaleFactor;
        ((Frame)localObject1).bindFrame(paramInt6, (int)(f1 * f2 * f3), (int)(paramInt5 * f2 * f3), paramDouble);
      }
      else
      {
        f1 = paramInt4;
        f2 = ((BaseFilter)localObject2).scaleFact;
        ((Frame)localObject1).bindFrame(-1, (int)(f1 * f2), (int)(paramInt5 * f2), paramDouble);
      }
      ((BaseFilter)localObject2).OnDrawFrameGLSL();
      localObject4 = ((BaseFilter)localObject2).mTextureIndexMap;
      int i;
      if ((localObject4 != null) && (localObject4.length > 0))
      {
        i = 0;
        for (;;)
        {
          localObject4 = ((BaseFilter)localObject2).mTextureIndexMap;
          if (i >= localObject4.length) {
            break;
          }
          if (localObject4[i] < 0)
          {
            ((BaseFilter)localObject2).setTextureParam(paramInt1, i);
          }
          else
          {
            localObject4 = findFrame(paramFrame, localObject4[i]);
            if (localObject4 != null) {
              ((BaseFilter)localObject2).setTextureParam(((Frame)localObject4).getTextureId(), i);
            } else {
              Log.e(TAG, "frame not found!");
            }
          }
          i += 1;
        }
      }
      if (localObject2 == this)
      {
        ((BaseFilter)localObject2).renderTexture(paramInt1, paramInt2, paramInt3);
        i = paramInt1;
        localObject4 = localObject3;
      }
      else
      {
        i = localObject3.getTextureId();
        ((BaseFilter)localObject2).renderTexture(localObject3.getTextureId(), localObject3.width, localObject3.height);
        if (localObject3.needReleaseFrame) {
          localObject3.clearSelf();
        }
        localObject4 = localObject1;
      }
      if (paramInt6 != 0) {
        checkInputOutputValid((BaseFilter)localObject2, (Frame)localObject1, i);
      }
      BaseFilter localBaseFilter = ((BaseFilter)localObject2).mNextFilter;
      localObject2 = localBaseFilter;
      localObject3 = localObject4;
      if (localBaseFilter != null)
      {
        if (((Frame)localObject1).nextFrame == null) {
          ((Frame)localObject1).nextFrame = new Frame();
        }
        localObject1 = ((Frame)localObject1).nextFrame;
        localObject2 = localBaseFilter;
        localObject3 = localObject4;
      }
    }
  }
  
  public BaseFilter addParam(UniformParam paramUniformParam)
  {
    if (paramUniformParam == null) {
      return this;
    }
    UniformParam localUniformParam = (UniformParam)this.mParamList.get(paramUniformParam.name);
    if (localUniformParam == null)
    {
      this.mParamList.put(paramUniformParam.name, paramUniformParam);
      return this;
    }
    paramUniformParam.handle = localUniformParam.handle;
    localUniformParam.clear();
    this.mParamList.put(paramUniformParam.name, paramUniformParam);
    return this;
  }
  
  public void addParams(HashMap<String, String> paramHashMap)
  {
    ParamHelper localParamHelper = this.mParamHelper;
    if (localParamHelper != null) {
      localParamHelper.processParams(paramHashMap);
    }
  }
  
  public void apply()
  {
    if (!isValid())
    {
      initFilterShader(0);
      applyInternal();
      AEOpenRenderConfig.checkStrictMode(isValid(), "filter is not valid");
    }
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.mIsPreviewFilter = paramBoolean;
    if (!isValid()) {
      apply();
    }
    BaseFilter localBaseFilter = this.mNextFilter;
    if (localBaseFilter != null) {
      localBaseFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public void applyForOES()
  {
    initFilterShader(1);
    applyInternal();
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void clearGLSL()
  {
    clearGLSLSelf();
    BaseFilter localBaseFilter = this.mNextFilter;
    if (localBaseFilter != null) {
      localBaseFilter.clearGLSL();
    }
  }
  
  public void clearGLSLSelf()
  {
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((UniformParam)localIterator.next()).clear();
    }
    this.mParamList.clear();
    nativeClear(this.mGlFilterId);
    this.mGlFilterId = 0L;
    this.mProgramIds = 0;
  }
  
  public UniformParam getAndRemoveParam(String paramString)
  {
    return (UniformParam)this.mParamList.remove(paramString);
  }
  
  public BaseFilter getLastFilter()
  {
    BaseFilter localBaseFilter;
    for (Object localObject = this;; localObject = localBaseFilter)
    {
      localBaseFilter = ((BaseFilter)localObject).mNextFilter;
      if (localBaseFilter == null) {
        break;
      }
    }
    return localObject;
  }
  
  public int getLastFilterID()
  {
    return getTheFilterIndex(getLastFilter());
  }
  
  public UniformParam getParam(String paramString)
  {
    return (UniformParam)this.mParamList.get(paramString);
  }
  
  public int getProgramIds()
  {
    return this.mProgramIds;
  }
  
  public float getScaleFactor()
  {
    return this.scaleFact;
  }
  
  protected int getTheFilterIndex(BaseFilter paramBaseFilter)
  {
    int i = 0;
    for (BaseFilter localBaseFilter = this; (localBaseFilter != null) && (localBaseFilter != paramBaseFilter); localBaseFilter = localBaseFilter.mNextFilter) {
      i += 1;
    }
    if (localBaseFilter == paramBaseFilter) {
      return i;
    }
    return -1;
  }
  
  public BaseFilter getmNextFilter()
  {
    return this.mNextFilter;
  }
  
  public boolean isAdjustFilter()
  {
    return false;
  }
  
  public boolean isGPUProcess()
  {
    return this.mIsGPU;
  }
  
  protected boolean isValid()
  {
    return this.mProgramIds > 0;
  }
  
  public Frame render(Frame paramFrame)
  {
    return RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return nativeRenderTexture(this.mGlFilterId, paramInt1, paramInt2, paramInt3);
  }
  
  public void setAdjustParam(float paramFloat) {}
  
  public void setEffectIndex(int paramInt) {}
  
  protected void setGlobalTextureMatrix(float[] paramArrayOfFloat)
  {
    nativeSetGlobalTextureMatrix(this.mGlFilterId, paramArrayOfFloat);
    BaseFilter localBaseFilter = this.mNextFilter;
    if (localBaseFilter != null) {
      localBaseFilter.setGlobalTextureMatrix(paramArrayOfFloat);
    }
  }
  
  public void setNextFilter(BaseFilter paramBaseFilter, int[] paramArrayOfInt)
  {
    this.mNextFilter = paramBaseFilter;
    if (paramBaseFilter != null) {
      paramBaseFilter.mTextureIndexMap = paramArrayOfInt;
    }
  }
  
  public void setParamHelper(ParamHelper paramParamHelper)
  {
    this.mParamHelper = paramParamHelper;
  }
  
  public void setParameterDic(Map<String, Object> paramMap) {}
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    return nativeSetPositions(this.mGlFilterId, paramArrayOfFloat);
  }
  
  public boolean setRenderMode(int paramInt)
  {
    return nativeSetRenderMode(this.mGlFilterId, paramInt);
  }
  
  public boolean setRotationAndFlip(int paramInt1, int paramInt2, int paramInt3)
  {
    return nativeSetRotationAndFlip(this.mGlFilterId, paramInt1, paramInt2, paramInt3);
  }
  
  public void setScaleFactor(float paramFloat)
  {
    this.scaleFact = paramFloat;
  }
  
  public void setSrcFilterIndex(int paramInt)
  {
    this.srcTextureIndex = paramInt;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    return nativeSetTexCords(this.mGlFilterId, paramArrayOfFloat);
  }
  
  public void setTextureParam(int paramInt1, int paramInt2)
  {
    GLES20.glUseProgram(this.mProgramIds);
    paramInt2 += 2;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("inputImageTexture");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    int i = GLES20.glGetUniformLocation(this.mProgramIds, (String)localObject);
    if (i >= 0)
    {
      GLES20.glActiveTexture(33984 + paramInt2);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(i, paramInt2);
    }
  }
  
  public void updateFilterShader(String paramString1, String paramString2)
  {
    this.glslVertextShader = paramString1;
    this.glslProgramShader = paramString2;
  }
  
  public void updateFragmentShader(String paramString)
  {
    this.glslProgramShader = paramString;
  }
  
  public boolean updateMatrix(float[] paramArrayOfFloat)
  {
    return nativeUpdateMatrix(this.mGlFilterId, paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.BaseFilter
 * JD-Core Version:    0.7.0.1
 */