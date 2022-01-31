package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class QQAVImageThreeInputFilter
  extends QQAVImageFilter
{
  public int filterInputTextureUniform2;
  public int filterInputTextureUniform3;
  public int filterSourceTexture2 = -1;
  public int filterSourceTexture3 = -1;
  public int filterTextureCoordinateAttribute2;
  public int filterTextureCoordinateAttribute3;
  private Bitmap mBitmap2;
  private Bitmap mBitmap3;
  private ByteBuffer mTextureCoordinatesBuffer2;
  private ByteBuffer mTextureCoordinatesBuffer3;
  
  public QQAVImageThreeInputFilter(String paramString)
  {
    this(String.valueOf(13), paramString);
  }
  
  public QQAVImageThreeInputFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    setRotation(0, false, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    GLES20.glDeleteTextures(1, new int[] { this.filterSourceTexture2 }, 0);
    this.filterSourceTexture2 = -1;
    GLES20.glDeleteTextures(1, new int[] { this.filterSourceTexture3 }, 0);
    this.filterSourceTexture3 = -1;
  }
  
  protected void onDrawArraysPre()
  {
    GLES20.glEnableVertexAttribArray(this.filterTextureCoordinateAttribute2);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, this.filterSourceTexture2);
    GLES20.glUniform1i(this.filterInputTextureUniform2, 3);
    GLES20.glEnableVertexAttribArray(this.filterTextureCoordinateAttribute3);
    GLES20.glActiveTexture(33989);
    GLES20.glBindTexture(3553, this.filterSourceTexture3);
    GLES20.glUniform1i(this.filterInputTextureUniform3, 5);
    this.mTextureCoordinatesBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.filterTextureCoordinateAttribute2, 2, 5126, false, 0, this.mTextureCoordinatesBuffer2);
    this.mTextureCoordinatesBuffer3.position(0);
    GLES20.glVertexAttribPointer(this.filterTextureCoordinateAttribute3, 2, 5126, false, 0, this.mTextureCoordinatesBuffer3);
  }
  
  public void onInit()
  {
    super.onInit();
    this.filterTextureCoordinateAttribute2 = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate2");
    this.filterInputTextureUniform2 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture2");
    GLES20.glEnableVertexAttribArray(this.filterTextureCoordinateAttribute2);
    this.filterTextureCoordinateAttribute3 = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate3");
    this.filterInputTextureUniform3 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture3");
    GLES20.glEnableVertexAttribArray(this.filterTextureCoordinateAttribute3);
    if ((this.mBitmap2 != null) && (this.mBitmap3 != null)) {
      setBitmap(this.mBitmap2, this.mBitmap3);
    }
  }
  
  public void setBitmap(final Bitmap paramBitmap1, final Bitmap paramBitmap2)
  {
    this.mBitmap2 = paramBitmap1;
    this.mBitmap3 = paramBitmap2;
    runOnDraw(new Runnable()
    {
      public void run()
      {
        if (QQAVImageThreeInputFilter.this.filterSourceTexture2 == -1)
        {
          GLES20.glActiveTexture(33987);
          QQAVImageThreeInputFilter.this.filterSourceTexture2 = OpenGlUtils.loadTexture(paramBitmap1, -1, false);
        }
        if (QQAVImageThreeInputFilter.this.filterSourceTexture3 == -1)
        {
          GLES20.glActiveTexture(33989);
          QQAVImageThreeInputFilter.this.filterSourceTexture3 = OpenGlUtils.loadTexture(paramBitmap2, -1, false);
        }
      }
    });
  }
  
  public void setRotation(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    float[] arrayOfFloat = TextureRotationUtil.getRotation(paramInt, paramBoolean1, paramBoolean2);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(arrayOfFloat);
    localFloatBuffer.flip();
    this.mTextureCoordinatesBuffer2 = localByteBuffer;
    this.mTextureCoordinatesBuffer3 = localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageThreeInputFilter
 * JD-Core Version:    0.7.0.1
 */