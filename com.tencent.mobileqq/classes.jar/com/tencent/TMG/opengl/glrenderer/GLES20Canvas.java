package com.tencent.TMG.opengl.glrenderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.TMG.opengl.texture.BasicTexture;
import com.tencent.TMG.opengl.utils.IntArray;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class GLES20Canvas
  implements GLCanvas
{
  private static final String ALPHA_UNIFORM = "uAlpha";
  private static final float[] BOUNDS_COORDINATES = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private static final float[] BOX_COORDINATES;
  private static final String COLOR_UNIFORM = "uColor";
  private static final int COORDS_PER_VERTEX = 2;
  private static final int COUNT_FILL_VERTEX = 4;
  private static final int COUNT_LINE_VERTEX = 2;
  private static final int COUNT_RECT_VERTEX = 4;
  private static final String DRAW_FRAGMENT_SHADER = "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n  gl_FragColor = uColor;\n}\n";
  private static final String DRAW_VERTEX_SHADER = "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n}\n";
  private static final int FLOAT_SIZE = 4;
  private static final int INDEX_ALPHA = 2;
  private static final int INDEX_COLOR = 2;
  private static final int INDEX_MATRIX = 1;
  private static final int INDEX_POSITION = 0;
  private static final int INDEX_TEXTURE_COORD = 2;
  private static final int INDEX_TEXTURE_MATRIX = 3;
  private static final int INDEX_TEXTURE_SAMPLER0 = 4;
  private static final int INDEX_TEXTURE_SAMPLER1 = 5;
  private static final int INDEX_TEXTURE_SAMPLER2 = 6;
  private static final int INITIAL_RESTORE_STATE_SIZE = 8;
  private static final int MATRIX_SIZE = 16;
  private static final String MATRIX_UNIFORM = "uMatrix";
  private static final String MESH_VERTEX_SHADER = "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nattribute vec2 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = aTextureCoordinate;\n}\n";
  private static final String OES_TEXTURE_FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform samplerExternalOES uTextureSampler0;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);\n  gl_FragColor *= uAlpha;\n}\n";
  private static final int OFFSET_DRAW_LINE = 4;
  private static final int OFFSET_DRAW_RECT = 6;
  private static final int OFFSET_FILL_RECT = 0;
  private static final float OPAQUE_ALPHA = 0.95F;
  private static final String POSITION_ATTRIBUTE = "aPosition";
  private static final String TAG = GLES20Canvas.class.getSimpleName();
  private static final String TEXTURE_COORD_ATTRIBUTE = "aTextureCoordinate";
  private static final String TEXTURE_FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler0;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);\n  gl_FragColor *= uAlpha;\n}\n";
  private static final String TEXTURE_MATRIX_UNIFORM = "uTextureMatrix";
  private static final String TEXTURE_SAMPLER_UNIFORM0 = "uTextureSampler0";
  private static final String TEXTURE_SAMPLER_UNIFORM1 = "uTextureSampler1";
  private static final String TEXTURE_SAMPLER_UNIFORM2 = "uTextureSampler2";
  private static final String TEXTURE_VERTEX_SHADER = "uniform mat4 uMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = (uTextureMatrix * pos).xy;\n}\n";
  private static final int VERTEX_STRIDE = 8;
  private static final String YUV_TEXTURE_FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler0;\nuniform sampler2D uTextureSampler1;\nuniform sampler2D uTextureSampler2;\nconst vec3 matYUVRGB1 = vec3(1.0,  0.0,   1.402);\nconst vec3 matYUVRGB2 = vec3(1.0, -0.344, -0.714);\nconst vec3 matYUVRGB3 = vec3(1.0,  1.772,  0.0);\nvoid main() {\n  vec3 yuvData;\n  vec3 rgbData;\n  yuvData.x = texture2D(uTextureSampler0, vTextureCoord).x;\n  yuvData.y = texture2D(uTextureSampler1, vTextureCoord).x-0.5;\n  yuvData.z = texture2D(uTextureSampler2, vTextureCoord).x-0.5;\n  rgbData.x = dot(yuvData, matYUVRGB1);\n  rgbData.y = dot(yuvData, matYUVRGB2);\n  rgbData.z = dot(yuvData, matYUVRGB3);\n  gl_FragColor = vec4(rgbData, 1.0) * uAlpha;\n}\n";
  private static final GLId mGLId = new GLES20Id();
  private float[] mAlphas = new float[8];
  private int mBoxCoordinates;
  private int mCountDrawLine = 0;
  private int mCountDrawMesh = 0;
  private int mCountFillRect = 0;
  private int mCountTextureRect = 0;
  private int mCurrentAlphaIndex = 0;
  private int mCurrentMatrixIndex = 0;
  private final IntArray mDeleteBuffers = new IntArray();
  GLES20Canvas.ShaderParameter[] mDrawParameters = { new GLES20Canvas.AttributeShaderParameter("aPosition"), new GLES20Canvas.UniformShaderParameter("uMatrix"), new GLES20Canvas.UniformShaderParameter("uColor") };
  private int mDrawProgram;
  private int mHeight;
  private float[] mMatrices = new float[''];
  GLES20Canvas.ShaderParameter[] mMeshParameters = { new GLES20Canvas.AttributeShaderParameter("aPosition"), new GLES20Canvas.UniformShaderParameter("uMatrix"), new GLES20Canvas.UniformShaderParameter("uAlpha"), new GLES20Canvas.AttributeShaderParameter("aTextureCoordinate"), new GLES20Canvas.UniformShaderParameter("uTextureSampler0") };
  private int mMeshProgram;
  GLES20Canvas.ShaderParameter[] mOesTextureParameters = { new GLES20Canvas.AttributeShaderParameter("aPosition"), new GLES20Canvas.UniformShaderParameter("uMatrix"), new GLES20Canvas.UniformShaderParameter("uAlpha"), new GLES20Canvas.UniformShaderParameter("uTextureMatrix"), new GLES20Canvas.UniformShaderParameter("uTextureSampler0") };
  private int mOesTextureProgram;
  private float[] mProjectionMatrix = new float[16];
  private IntArray mSaveFlags = new IntArray();
  private final float[] mTempColor = new float[4];
  private final int[] mTempIntArray = new int[1];
  private final float[] mTempMatrix = new float[32];
  private final RectF mTempSourceRect = new RectF();
  private final RectF mTempTargetRect = new RectF();
  private final float[] mTempTextureMatrix = new float[16];
  GLES20Canvas.ShaderParameter[] mTextureParameters = { new GLES20Canvas.AttributeShaderParameter("aPosition"), new GLES20Canvas.UniformShaderParameter("uMatrix"), new GLES20Canvas.UniformShaderParameter("uAlpha"), new GLES20Canvas.UniformShaderParameter("uTextureMatrix"), new GLES20Canvas.UniformShaderParameter("uTextureSampler0") };
  private int mTextureProgram;
  private final IntArray mUnboundTextures = new IntArray();
  private int mWidth;
  GLES20Canvas.ShaderParameter[] mYUVTextureParameters = { new GLES20Canvas.AttributeShaderParameter("aPosition"), new GLES20Canvas.UniformShaderParameter("uMatrix"), new GLES20Canvas.UniformShaderParameter("uAlpha"), new GLES20Canvas.UniformShaderParameter("uTextureMatrix"), new GLES20Canvas.UniformShaderParameter("uTextureSampler0"), new GLES20Canvas.UniformShaderParameter("uTextureSampler1"), new GLES20Canvas.UniformShaderParameter("uTextureSampler2") };
  private int mYUVTextureProgram;
  
  static
  {
    BOX_COORDINATES = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  }
  
  public GLES20Canvas()
  {
    Matrix.setIdentityM(this.mTempTextureMatrix, 0);
    Matrix.setIdentityM(this.mMatrices, this.mCurrentMatrixIndex);
    this.mAlphas[this.mCurrentAlphaIndex] = 1.0F;
    this.mBoxCoordinates = uploadBuffer(createBuffer(BOX_COORDINATES));
    int i = loadShader(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n}\n");
    int j = loadShader(35633, "uniform mat4 uMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = (uTextureMatrix * pos).xy;\n}\n");
    int k = loadShader(35633, "uniform mat4 uMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = (uTextureMatrix * pos).xy;\n}\n");
    int m = loadShader(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nattribute vec2 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = aTextureCoordinate;\n}\n");
    int n = loadShader(35632, "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n  gl_FragColor = uColor;\n}\n");
    int i1 = loadShader(35632, "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler0;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);\n  gl_FragColor *= uAlpha;\n}\n");
    int i2 = loadShader(35632, "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler0;\nuniform sampler2D uTextureSampler1;\nuniform sampler2D uTextureSampler2;\nconst vec3 matYUVRGB1 = vec3(1.0,  0.0,   1.402);\nconst vec3 matYUVRGB2 = vec3(1.0, -0.344, -0.714);\nconst vec3 matYUVRGB3 = vec3(1.0,  1.772,  0.0);\nvoid main() {\n  vec3 yuvData;\n  vec3 rgbData;\n  yuvData.x = texture2D(uTextureSampler0, vTextureCoord).x;\n  yuvData.y = texture2D(uTextureSampler1, vTextureCoord).x-0.5;\n  yuvData.z = texture2D(uTextureSampler2, vTextureCoord).x-0.5;\n  rgbData.x = dot(yuvData, matYUVRGB1);\n  rgbData.y = dot(yuvData, matYUVRGB2);\n  rgbData.z = dot(yuvData, matYUVRGB3);\n  gl_FragColor = vec4(rgbData, 1.0) * uAlpha;\n}\n");
    int i3 = loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform samplerExternalOES uTextureSampler0;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);\n  gl_FragColor *= uAlpha;\n}\n");
    this.mDrawProgram = assembleProgram(i, n, this.mDrawParameters);
    this.mTextureProgram = assembleProgram(j, i1, this.mTextureParameters);
    this.mYUVTextureProgram = assembleProgram(k, i2, this.mYUVTextureParameters);
    this.mOesTextureProgram = assembleProgram(j, i3, this.mOesTextureParameters);
    this.mMeshProgram = assembleProgram(m, i1, this.mMeshParameters);
    GLES20.glBlendFunc(1, 771);
    checkError();
  }
  
  private int assembleProgram(int paramInt1, int paramInt2, GLES20Canvas.ShaderParameter[] paramArrayOfShaderParameter)
  {
    int i = 0;
    int j = GLES20.glCreateProgram();
    checkError();
    if (j == 0) {
      throw new RuntimeException("Cannot create GL program: " + GLES20.glGetError());
    }
    GLES20.glAttachShader(j, paramInt1);
    checkError();
    GLES20.glAttachShader(j, paramInt2);
    checkError();
    GLES20.glLinkProgram(j);
    checkError();
    int[] arrayOfInt = this.mTempIntArray;
    GLES20.glGetProgramiv(j, 35714, arrayOfInt, 0);
    paramInt1 = j;
    paramInt2 = i;
    if (arrayOfInt[0] != 1)
    {
      Log.e(TAG, "Could not link program: ");
      Log.e(TAG, GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
      paramInt1 = 0;
      paramInt2 = i;
    }
    while (paramInt2 < paramArrayOfShaderParameter.length)
    {
      paramArrayOfShaderParameter[paramInt2].loadHandle(paramInt1);
      paramInt2 += 1;
    }
    return paramInt1;
  }
  
  public static void checkError()
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      Throwable localThrowable = new Throwable();
      Log.e(TAG, "GL error: " + i, localThrowable);
    }
  }
  
  private static void convertCoordinate(RectF paramRectF1, RectF paramRectF2, BasicTexture paramBasicTexture)
  {
    int i = paramBasicTexture.getTextureWidth();
    int j = paramBasicTexture.getTextureHeight();
    paramRectF1.left /= i;
    paramRectF1.right /= i;
    paramRectF1.top /= j;
    paramRectF1.bottom /= j;
  }
  
  private static void copyTextureCoordinates(BasicTexture paramBasicTexture, RectF paramRectF)
  {
    int i = paramBasicTexture.getSourceLeft();
    int j = paramBasicTexture.getSourceTop();
    int k = paramBasicTexture.getSourceWidth();
    int m = paramBasicTexture.getSourceHeight();
    paramRectF.set(i, j, k + i, m + j);
  }
  
  private static FloatBuffer createBuffer(float[] paramArrayOfFloat)
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(paramArrayOfFloat, 0, paramArrayOfFloat.length).position(0);
    return localFloatBuffer;
  }
  
  private void draw(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, float paramFloat5)
  {
    prepareDraw(paramInt2, paramInt4, paramFloat5);
    draw(this.mDrawParameters, paramInt1, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  private void draw(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    draw(paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramGLPaint.getColor(), paramGLPaint.getLineWidth());
  }
  
  private void draw(GLES20Canvas.ShaderParameter[] paramArrayOfShaderParameter, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setMatrix(paramArrayOfShaderParameter, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    int i = paramArrayOfShaderParameter[0].handle;
    GLES20.glEnableVertexAttribArray(i);
    checkError();
    GLES20.glDrawArrays(paramInt1, 0, paramInt2);
    checkError();
    GLES20.glDisableVertexAttribArray(i);
    checkError();
  }
  
  private void drawTextureRect(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2)
  {
    setTextureMatrix(paramRectF1);
    drawTextureRect(paramBasicTexture, this.mTempTextureMatrix, paramRectF2);
  }
  
  private void drawTextureRect(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, RectF paramRectF)
  {
    GLES20Canvas.ShaderParameter[] arrayOfShaderParameter = prepareTexture(paramBasicTexture);
    setPosition(arrayOfShaderParameter, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].handle, 1, false, paramArrayOfFloat, 0);
    checkError();
    if (paramBasicTexture.isFlippedVertically())
    {
      save(2);
      translate(0.0F, paramRectF.centerY());
      scale(1.0F, -1.0F, 1.0F);
      translate(0.0F, -paramRectF.centerY());
    }
    draw(arrayOfShaderParameter, 5, 4, paramRectF.left, paramRectF.top, paramRectF.width(), paramRectF.height());
    if (paramBasicTexture.isFlippedVertically()) {
      restore();
    }
    this.mCountTextureRect += 1;
  }
  
  private void enableBlending(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      checkError();
      return;
    }
    GLES20.glDisable(3042);
    checkError();
  }
  
  private float[] getColor(int paramInt)
  {
    float f1 = (paramInt >>> 24 & 0xFF) / 255.0F * getAlpha();
    float f2 = (paramInt >>> 16 & 0xFF) / 255.0F;
    float f3 = (paramInt >>> 8 & 0xFF) / 255.0F;
    float f4 = (paramInt & 0xFF) / 255.0F;
    this.mTempColor[0] = (f2 * f1);
    this.mTempColor[1] = (f3 * f1);
    this.mTempColor[2] = (f4 * f1);
    this.mTempColor[3] = f1;
    return this.mTempColor;
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    checkError();
    GLES20.glCompileShader(paramInt);
    checkError();
    return paramInt;
  }
  
  private void prepareDraw(int paramInt1, int paramInt2, float paramFloat)
  {
    GLES20.glUseProgram(this.mDrawProgram);
    checkError();
    if (paramFloat > 0.0F)
    {
      GLES20.glLineWidth(paramFloat);
      checkError();
    }
    float[] arrayOfFloat = getColor(paramInt2);
    if (arrayOfFloat[3] < 1.0F) {}
    for (boolean bool = true;; bool = false)
    {
      enableBlending(bool);
      if (bool)
      {
        GLES20.glBlendColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
        checkError();
      }
      GLES20.glUniform4fv(this.mDrawParameters[2].handle, 1, arrayOfFloat, 0);
      setPosition(this.mDrawParameters, paramInt1);
      checkError();
      return;
    }
  }
  
  private void prepareTexture(BasicTexture paramBasicTexture, int paramInt, GLES20Canvas.ShaderParameter[] paramArrayOfShaderParameter)
  {
    int i = 0;
    GLES20.glUseProgram(paramInt);
    checkError();
    if ((!paramBasicTexture.isOpaque()) || (getAlpha() < 0.95F)) {}
    for (boolean bool = true;; bool = false)
    {
      enableBlending(bool);
      paramBasicTexture.onBind(this);
      int[] arrayOfInt = paramBasicTexture.getId();
      paramInt = i;
      while (paramInt < arrayOfInt.length)
      {
        GLES20.glActiveTexture(33984 + paramInt);
        checkError();
        GLES20.glBindTexture(paramBasicTexture.getTarget(), arrayOfInt[paramInt]);
        checkError();
        GLES20.glUniform1i(paramArrayOfShaderParameter[(paramInt + 4)].handle, paramInt);
        checkError();
        paramInt += 1;
      }
    }
    GLES20.glUniform1f(paramArrayOfShaderParameter[2].handle, getAlpha());
    checkError();
  }
  
  private GLES20Canvas.ShaderParameter[] prepareTexture(BasicTexture paramBasicTexture)
  {
    GLES20Canvas.ShaderParameter[] arrayOfShaderParameter;
    int i;
    if (paramBasicTexture.getTarget() == 3553) {
      if (paramBasicTexture.getFormatType() == 1)
      {
        arrayOfShaderParameter = this.mYUVTextureParameters;
        i = this.mYUVTextureProgram;
      }
    }
    for (;;)
    {
      prepareTexture(paramBasicTexture, i, arrayOfShaderParameter);
      return arrayOfShaderParameter;
      arrayOfShaderParameter = this.mTextureParameters;
      i = this.mTextureProgram;
      continue;
      arrayOfShaderParameter = this.mOesTextureParameters;
      i = this.mOesTextureProgram;
    }
  }
  
  private static void printMatrix(String paramString, float[] paramArrayOfFloat, int paramInt)
  {
    paramString = new StringBuilder(paramString);
    int i = 0;
    while (i < 16)
    {
      paramString.append(' ');
      if (i % 4 == 0) {
        paramString.append('\n');
      }
      paramString.append(paramArrayOfFloat[(paramInt + i)]);
      i += 1;
    }
    Log.v(TAG, paramString.toString());
  }
  
  private void setMatrix(GLES20Canvas.ShaderParameter[] paramArrayOfShaderParameter, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix.translateM(this.mTempMatrix, 0, this.mMatrices, this.mCurrentMatrixIndex, paramFloat1, paramFloat2, 0.0F);
    Matrix.scaleM(this.mTempMatrix, 0, paramFloat3, paramFloat4, 1.0F);
    Matrix.multiplyMM(this.mTempMatrix, 16, this.mProjectionMatrix, 0, this.mTempMatrix, 0);
    GLES20.glUniformMatrix4fv(paramArrayOfShaderParameter[1].handle, 1, false, this.mTempMatrix, 16);
    checkError();
  }
  
  private void setPosition(GLES20Canvas.ShaderParameter[] paramArrayOfShaderParameter, int paramInt)
  {
    GLES20.glBindBuffer(34962, this.mBoxCoordinates);
    checkError();
    GLES20.glVertexAttribPointer(paramArrayOfShaderParameter[0].handle, 2, 5126, false, 8, paramInt * 8);
    checkError();
    GLES20.glBindBuffer(34962, 0);
    checkError();
  }
  
  private void setTextureMatrix(RectF paramRectF)
  {
    this.mTempTextureMatrix[0] = paramRectF.width();
    this.mTempTextureMatrix[5] = paramRectF.height();
    this.mTempTextureMatrix[12] = paramRectF.left;
    this.mTempTextureMatrix[13] = paramRectF.top;
  }
  
  private int uploadBuffer(Buffer paramBuffer, int paramInt)
  {
    mGLId.glGenBuffers(1, this.mTempIntArray, 0);
    checkError();
    int i = this.mTempIntArray[0];
    GLES20.glBindBuffer(34962, i);
    checkError();
    GLES20.glBufferData(34962, paramBuffer.capacity() * paramInt, paramBuffer, 35044);
    checkError();
    return i;
  }
  
  public void clearBuffer()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    checkError();
    GLES20.glClear(16384);
    checkError();
  }
  
  public void clearBuffer(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    GLES20.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    checkError();
    GLES20.glClear(16384);
    checkError();
  }
  
  public void deleteBuffer(int paramInt)
  {
    synchronized (this.mUnboundTextures)
    {
      this.mDeleteBuffers.add(paramInt);
      return;
    }
  }
  
  public void deleteRecycledResources()
  {
    synchronized (this.mUnboundTextures)
    {
      IntArray localIntArray2 = this.mUnboundTextures;
      if (this.mUnboundTextures.size() > 0)
      {
        mGLId.glDeleteTextures(null, localIntArray2.size(), localIntArray2.getInternalArray(), 0);
        localIntArray2.clear();
      }
      localIntArray2 = this.mDeleteBuffers;
      if (localIntArray2.size() > 0)
      {
        mGLId.glDeleteBuffers(null, localIntArray2.size(), localIntArray2.getInternalArray(), 0);
        localIntArray2.clear();
      }
      return;
    }
  }
  
  public void drawLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    draw(3, 4, 2, paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2, paramGLPaint);
    this.mCountDrawLine += 1;
  }
  
  public void drawMesh(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    prepareTexture(paramBasicTexture, this.mMeshProgram, this.mMeshParameters);
    GLES20.glBindBuffer(34963, paramInt5);
    checkError();
    GLES20.glBindBuffer(34962, paramInt3);
    checkError();
    paramInt3 = this.mMeshParameters[0].handle;
    GLES20.glVertexAttribPointer(paramInt3, 2, 5126, false, 8, 0);
    checkError();
    GLES20.glBindBuffer(34962, paramInt4);
    checkError();
    paramInt4 = this.mMeshParameters[2].handle;
    GLES20.glVertexAttribPointer(paramInt4, 2, 5126, false, 8, 0);
    checkError();
    GLES20.glBindBuffer(34962, 0);
    checkError();
    GLES20.glEnableVertexAttribArray(paramInt3);
    checkError();
    GLES20.glEnableVertexAttribArray(paramInt4);
    checkError();
    setMatrix(this.mMeshParameters, paramInt1, paramInt2, 1.0F, 1.0F);
    GLES20.glDrawElements(5, paramInt6, 5121, 0);
    checkError();
    GLES20.glDisableVertexAttribArray(paramInt3);
    checkError();
    GLES20.glDisableVertexAttribArray(paramInt4);
    checkError();
    GLES20.glBindBuffer(34963, 0);
    checkError();
    this.mCountDrawMesh += 1;
  }
  
  public void drawMixed(BasicTexture paramBasicTexture, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    copyTextureCoordinates(paramBasicTexture, this.mTempSourceRect);
    this.mTempTargetRect.set(paramInt2, paramInt3, paramInt2 + paramInt4, paramInt3 + paramInt5);
    drawMixed(paramBasicTexture, paramInt1, paramFloat, this.mTempSourceRect, this.mTempTargetRect);
  }
  
  public void drawMixed(BasicTexture paramBasicTexture, int paramInt, float paramFloat, RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF2.width() <= 0.0F) || (paramRectF2.height() <= 0.0F)) {
      return;
    }
    save(1);
    float f = getAlpha();
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    setAlpha((1.0F - paramFloat) * f);
    drawTexture(paramBasicTexture, paramRectF1, paramRectF2);
    setAlpha(f * paramFloat);
    fillRect(paramRectF2.left, paramRectF2.top, paramRectF2.width(), paramRectF2.height(), paramInt);
    restore();
  }
  
  public void drawRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    draw(2, 6, 4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramGLPaint);
    this.mCountDrawLine += 1;
  }
  
  public void drawTexture(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    copyTextureCoordinates(paramBasicTexture, this.mTempSourceRect);
    this.mTempTargetRect.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    convertCoordinate(this.mTempSourceRect, this.mTempTargetRect, paramBasicTexture);
    drawTextureRect(paramBasicTexture, this.mTempSourceRect, this.mTempTargetRect);
  }
  
  public void drawTexture(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF2.width() <= 0.0F) || (paramRectF2.height() <= 0.0F)) {
      return;
    }
    this.mTempSourceRect.set(paramRectF1);
    this.mTempTargetRect.set(paramRectF2);
    convertCoordinate(this.mTempSourceRect, this.mTempTargetRect, paramBasicTexture);
    drawTextureRect(paramBasicTexture, this.mTempSourceRect, this.mTempTargetRect);
  }
  
  public void drawTexture(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    this.mTempTargetRect.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    drawTextureRect(paramBasicTexture, paramArrayOfFloat, this.mTempTargetRect);
  }
  
  public void dumpStatisticsAndClear()
  {
    String str = String.format("MESH:%d, TEX_RECT:%d, FILL_RECT:%d, LINE:%d", new Object[] { Integer.valueOf(this.mCountDrawMesh), Integer.valueOf(this.mCountTextureRect), Integer.valueOf(this.mCountFillRect), Integer.valueOf(this.mCountDrawLine) });
    this.mCountDrawMesh = 0;
    this.mCountTextureRect = 0;
    this.mCountFillRect = 0;
    this.mCountDrawLine = 0;
    Log.d(TAG, str);
  }
  
  public void fillRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    draw(5, 0, 4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, 0.0F);
    this.mCountFillRect += 1;
  }
  
  public float getAlpha()
  {
    return this.mAlphas[this.mCurrentAlphaIndex];
  }
  
  public void getBounds(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Matrix.translateM(this.mTempMatrix, 0, this.mMatrices, this.mCurrentMatrixIndex, paramInt1, paramInt2, 0.0F);
    Matrix.scaleM(this.mTempMatrix, 0, paramInt3, paramInt4, 1.0F);
    Matrix.multiplyMV(this.mTempMatrix, 16, this.mTempMatrix, 0, BOUNDS_COORDINATES, 0);
    Matrix.multiplyMV(this.mTempMatrix, 20, this.mTempMatrix, 0, BOUNDS_COORDINATES, 4);
    paramRect.left = Math.round(this.mTempMatrix[16]);
    paramRect.right = Math.round(this.mTempMatrix[20]);
    paramRect.top = Math.round(this.mTempMatrix[17]);
    paramRect.bottom = Math.round(this.mTempMatrix[21]);
    paramRect.sort();
  }
  
  public GLId getGLId()
  {
    return mGLId;
  }
  
  public void initializeTexture(BasicTexture paramBasicTexture, Bitmap paramBitmap)
  {
    int j = paramBasicTexture.getTarget();
    int[] arrayOfInt = paramBasicTexture.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramBasicTexture.getId()[i]);
      i += 1;
    }
    checkError();
    GLUtils.texImage2D(j, 0, paramBitmap, 0);
  }
  
  public void initializeTextureSize(BasicTexture paramBasicTexture, int paramInt1, int paramInt2)
  {
    int j = paramBasicTexture.getTarget();
    int[] arrayOfInt = paramBasicTexture.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramBasicTexture.getId()[i]);
      i += 1;
    }
    checkError();
    GLES20.glTexImage2D(j, 0, paramInt1, paramBasicTexture.getTextureWidth(), paramBasicTexture.getTextureHeight(), 0, paramInt1, paramInt2, null);
  }
  
  public void multiplyAlpha(float paramFloat)
  {
    setAlpha(getAlpha() * paramFloat);
  }
  
  public void multiplyMatrix(float[] paramArrayOfFloat, int paramInt)
  {
    float[] arrayOfFloat1 = this.mTempMatrix;
    float[] arrayOfFloat2 = this.mMatrices;
    int i = this.mCurrentMatrixIndex;
    Matrix.multiplyMM(arrayOfFloat1, 0, arrayOfFloat2, i, paramArrayOfFloat, paramInt);
    System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, i, 16);
  }
  
  public void recoverFromLightCycle()
  {
    GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
    GLES20.glDisable(2929);
    GLES20.glBlendFunc(1, 771);
    checkError();
  }
  
  public void restore()
  {
    int j = 1;
    int k = this.mSaveFlags.removeLast();
    if ((k & 0x1) == 1)
    {
      i = 1;
      if (i != 0) {
        this.mCurrentAlphaIndex -= 1;
      }
      if ((k & 0x2) != 2) {
        break label63;
      }
    }
    label63:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        this.mCurrentMatrixIndex -= 16;
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 == 0.0F) {
      return;
    }
    float[] arrayOfFloat1 = this.mTempMatrix;
    Matrix.setRotateM(arrayOfFloat1, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    float[] arrayOfFloat2 = this.mMatrices;
    int i = this.mCurrentMatrixIndex;
    Matrix.multiplyMM(arrayOfFloat1, 16, arrayOfFloat2, i, arrayOfFloat1, 0);
    System.arraycopy(arrayOfFloat1, 16, arrayOfFloat2, i, 16);
  }
  
  public void save()
  {
    save(-1);
  }
  
  public void save(int paramInt)
  {
    int j = 1;
    if ((paramInt & 0x1) == 1)
    {
      i = 1;
      if (i != 0)
      {
        float f = getAlpha();
        this.mCurrentAlphaIndex += 1;
        if (this.mAlphas.length <= this.mCurrentAlphaIndex) {
          this.mAlphas = Arrays.copyOf(this.mAlphas, this.mAlphas.length * 2);
        }
        this.mAlphas[this.mCurrentAlphaIndex] = f;
      }
      if ((paramInt & 0x2) != 2) {
        break label163;
      }
    }
    label163:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        i = this.mCurrentMatrixIndex;
        this.mCurrentMatrixIndex += 16;
        if (this.mMatrices.length <= this.mCurrentMatrixIndex) {
          this.mMatrices = Arrays.copyOf(this.mMatrices, this.mMatrices.length * 2);
        }
        System.arraycopy(this.mMatrices, i, this.mMatrices, this.mCurrentMatrixIndex, 16);
      }
      this.mSaveFlags.add(paramInt);
      return;
      i = 0;
      break;
    }
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.mMatrices, this.mCurrentMatrixIndex, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setAlpha(float paramFloat)
  {
    this.mAlphas[this.mCurrentAlphaIndex] = paramFloat;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
    checkError();
    Matrix.setIdentityM(this.mMatrices, this.mCurrentMatrixIndex);
    Matrix.orthoM(this.mProjectionMatrix, 0, 0.0F, paramInt1, 0.0F, paramInt2, -1.0F, 1.0F);
    Matrix.translateM(this.mMatrices, this.mCurrentMatrixIndex, 0.0F, paramInt2, 0.0F);
    Matrix.scaleM(this.mMatrices, this.mCurrentMatrixIndex, 1.0F, -1.0F, 1.0F);
  }
  
  public void setTextureParameters(BasicTexture paramBasicTexture)
  {
    int j = paramBasicTexture.getTarget();
    int[] arrayOfInt = paramBasicTexture.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramBasicTexture.getId()[i]);
      i += 1;
    }
    checkError();
    GLES20.glTexParameteri(j, 10242, 33071);
    GLES20.glTexParameteri(j, 10243, 33071);
    GLES20.glTexParameterf(j, 10241, 9729.0F);
    GLES20.glTexParameterf(j, 10240, 9729.0F);
  }
  
  public void texSubImage2D(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    int j = paramBasicTexture.getTarget();
    int[] arrayOfInt = paramBasicTexture.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramBasicTexture.getId()[i]);
      i += 1;
    }
    checkError();
    GLUtils.texSubImage2D(j, 0, paramInt1, paramInt2, paramBitmap, paramInt3, paramInt4);
  }
  
  public void translate(float paramFloat1, float paramFloat2)
  {
    int i = this.mCurrentMatrixIndex;
    float[] arrayOfFloat = this.mMatrices;
    int j = i + 12;
    arrayOfFloat[j] += arrayOfFloat[(i + 0)] * paramFloat1 + arrayOfFloat[(i + 4)] * paramFloat2;
    j = i + 13;
    arrayOfFloat[j] += arrayOfFloat[(i + 1)] * paramFloat1 + arrayOfFloat[(i + 5)] * paramFloat2;
    j = i + 14;
    arrayOfFloat[j] += arrayOfFloat[(i + 2)] * paramFloat1 + arrayOfFloat[(i + 6)] * paramFloat2;
    j = i + 15;
    float f1 = arrayOfFloat[j];
    float f2 = arrayOfFloat[(i + 3)];
    arrayOfFloat[j] = (arrayOfFloat[(i + 7)] * paramFloat2 + f2 * paramFloat1 + f1);
  }
  
  public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.translateM(this.mMatrices, this.mCurrentMatrixIndex, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public boolean unloadTexture(BasicTexture paramBasicTexture)
  {
    boolean bool = paramBasicTexture.isLoaded();
    if (bool) {}
    for (;;)
    {
      synchronized (this.mUnboundTextures)
      {
        paramBasicTexture = paramBasicTexture.getId();
        if (paramBasicTexture != null) {
          break label68;
        }
        return bool;
        if (i < paramBasicTexture.length)
        {
          this.mUnboundTextures.add(paramBasicTexture[i]);
          i += 1;
          continue;
        }
        return bool;
      }
      return bool;
      label68:
      int i = 0;
    }
  }
  
  public int uploadBuffer(ByteBuffer paramByteBuffer)
  {
    return uploadBuffer(paramByteBuffer, 1);
  }
  
  public int uploadBuffer(FloatBuffer paramFloatBuffer)
  {
    return uploadBuffer(paramFloatBuffer, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLES20Canvas
 * JD-Core Version:    0.7.0.1
 */