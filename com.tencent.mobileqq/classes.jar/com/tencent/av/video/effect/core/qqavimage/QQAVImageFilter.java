package com.tencent.av.video.effect.core.qqavimage;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.Scanner;

public class QQAVImageFilter
{
  public static final String NO_FILTER_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
  public static final String NO_FILTER_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
  protected FloatBuffer cubeBuffer;
  private final String mFragmentShader;
  protected int mGLAttribPosition;
  protected int mGLAttribTextureCoordinate;
  protected int mGLProgId;
  protected int mGLUniformTexture;
  private boolean mIsInitialized = false;
  public int mOutputHeight;
  public int mOutputWidth;
  protected String mQQAVEffectID = null;
  protected String mQQAVEffectName = null;
  protected int mQQAVEffectType;
  private final LinkedList<Runnable> mRunOnDraw = new LinkedList();
  private final String mVertexShader;
  protected FloatBuffer textureBuffer;
  
  public QQAVImageFilter()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    this.mQQAVEffectType = -1;
    setBufferCubeTexture();
  }
  
  public QQAVImageFilter(String paramString)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", paramString);
    this.mQQAVEffectType = -1;
    setBufferCubeTexture();
  }
  
  public QQAVImageFilter(String paramString1, String paramString2)
  {
    this.mVertexShader = paramString1;
    this.mFragmentShader = paramString2;
    this.mQQAVEffectType = -1;
    setBufferCubeTexture();
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    paramInputStream = new Scanner(paramInputStream).useDelimiter("\\A");
    if (paramInputStream.hasNext()) {
      return paramInputStream.next();
    }
    return "";
  }
  
  public static String loadShader(String paramString, Context paramContext)
  {
    try
    {
      paramString = paramContext.getAssets().open(paramString);
      paramContext = convertStreamToString(paramString);
      paramString.close();
      return paramContext;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public final void destroy()
  {
    this.mIsInitialized = false;
    GLES20.glDeleteProgram(this.mGLProgId);
    onDestroy();
  }
  
  public int getAttribPosition()
  {
    return this.mGLAttribPosition;
  }
  
  public int getAttribTextureCoordinate()
  {
    return this.mGLAttribTextureCoordinate;
  }
  
  public int getOutputHeight()
  {
    return this.mOutputHeight;
  }
  
  public int getOutputWidth()
  {
    return this.mOutputWidth;
  }
  
  public int getProgram()
  {
    return this.mGLProgId;
  }
  
  public String getQQAVEffectID()
  {
    return this.mQQAVEffectID;
  }
  
  public String getQQAVEffectName()
  {
    return this.mQQAVEffectName;
  }
  
  public int getQQAVEffectType()
  {
    return this.mQQAVEffectType;
  }
  
  public int getUniformTexture()
  {
    return this.mGLUniformTexture;
  }
  
  public final void init()
  {
    if (!this.mIsInitialized)
    {
      onInit();
      this.mIsInitialized = true;
      onInitialized();
    }
  }
  
  public boolean isInitialized()
  {
    return this.mIsInitialized;
  }
  
  public void onDestroy() {}
  
  public void onDraw(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    GLES20.glUseProgram(this.mGLProgId);
    runPendingOnDrawTasks();
    if (!this.mIsInitialized) {
      return;
    }
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
    if (paramInt != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glUniform1i(this.mGLUniformTexture, 0);
    }
    onDrawArraysPre();
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
    GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
    onDrawArraysAfter();
    GLES20.glBindTexture(3553, 0);
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == -1) || (paramInt1 == -1)) {
      return;
    }
    GLES20.glBindFramebuffer(36160, paramInt2);
    GLES20.glViewport(0, 0, getOutputWidth(), getOutputHeight());
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    onDraw(paramInt1, this.cubeBuffer, this.textureBuffer);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  protected void onDrawArraysAfter() {}
  
  protected void onDrawArraysPre() {}
  
  public void onInit()
  {
    this.mGLProgId = OpenGlUtils.loadProgram(this.mVertexShader, this.mFragmentShader);
    this.mGLAttribPosition = GLES20.glGetAttribLocation(this.mGLProgId, "position");
    this.mGLUniformTexture = GLES20.glGetUniformLocation(this.mGLProgId, "inputImageTexture");
    this.mGLAttribTextureCoordinate = GLES20.glGetAttribLocation(this.mGLProgId, "inputTextureCoordinate");
    this.mIsInitialized = true;
  }
  
  public void onInitialized() {}
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    if ((this.mOutputWidth != paramInt1) || (this.mOutputHeight != paramInt2))
    {
      this.mOutputWidth = paramInt1;
      this.mOutputHeight = paramInt2;
    }
  }
  
  protected void runOnDraw(Runnable paramRunnable)
  {
    synchronized (this.mRunOnDraw)
    {
      this.mRunOnDraw.addLast(paramRunnable);
      return;
    }
  }
  
  protected void runPendingOnDrawTasks()
  {
    while (!this.mRunOnDraw.isEmpty()) {
      ((Runnable)this.mRunOnDraw.removeFirst()).run();
    }
  }
  
  public void setBitmap(int paramInt, Bitmap paramBitmap) {}
  
  public void setBufferCubeTexture()
  {
    this.cubeBuffer = ByteBuffer.allocateDirect(OpenGlUtils.CUBE8.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.cubeBuffer.put(OpenGlUtils.CUBE8).position(0);
    this.textureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.textureBuffer.put(TextureRotationUtil.TEXTURE_NO_ROTATION2).position(0);
  }
  
  public void setFloat(int paramInt, float paramFloat)
  {
    runOnDraw(new QQAVImageFilter.2(this, paramInt, paramFloat));
  }
  
  public void setInteger(int paramInt1, int paramInt2)
  {
    runOnDraw(new QQAVImageFilter.1(this, paramInt1, paramInt2));
  }
  
  public void setPoint(int paramInt, PointF paramPointF)
  {
    runOnDraw(new QQAVImageFilter.3(this, paramPointF, paramInt));
  }
  
  public void setQQAVEffectID(String paramString)
  {
    this.mQQAVEffectID = paramString;
  }
  
  public void setQQAVEffectName(String paramString)
  {
    this.mQQAVEffectName = paramString;
  }
  
  public void setQQAVEffectType(int paramInt)
  {
    this.mQQAVEffectType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
 * JD-Core Version:    0.7.0.1
 */