package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class QQAVImageTwoInputFilter
  extends QQAVImageFilter
{
  private Bitmap mBitmap;
  public int mFilterInputTextureUniform2;
  public int mFilterSecondTextureCoordinateAttribute;
  public int mFilterSourceTexture2 = -1;
  private ByteBuffer mTexture2CoordinatesBuffer;
  
  public QQAVImageTwoInputFilter(String paramString)
  {
    this(String.valueOf(24), paramString);
  }
  
  public QQAVImageTwoInputFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    setRotation(0, false, false);
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    GLES20.glDeleteTextures(1, new int[] { this.mFilterSourceTexture2 }, 0);
    this.mFilterSourceTexture2 = -1;
  }
  
  protected void onDrawArraysAfter()
  {
    if (this.mFilterSecondTextureCoordinateAttribute != -1) {
      GLES20.glDisableVertexAttribArray(this.mFilterSecondTextureCoordinateAttribute);
    }
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, 0);
    GLES20.glActiveTexture(33984);
  }
  
  protected void onDrawArraysPre()
  {
    if (this.mFilterSecondTextureCoordinateAttribute != -1)
    {
      GLES20.glEnableVertexAttribArray(this.mFilterSecondTextureCoordinateAttribute);
      this.mTexture2CoordinatesBuffer.position(0);
      GLES20.glVertexAttribPointer(this.mFilterSecondTextureCoordinateAttribute, 2, 5126, false, 0, this.mTexture2CoordinatesBuffer);
    }
    if (this.mFilterInputTextureUniform2 != -1)
    {
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, this.mFilterSourceTexture2);
      GLES20.glUniform1i(this.mFilterInputTextureUniform2, 3);
    }
  }
  
  public void onInit()
  {
    super.onInit();
    this.mFilterSecondTextureCoordinateAttribute = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate2");
    this.mFilterInputTextureUniform2 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture2");
    GLES20.glEnableVertexAttribArray(this.mFilterSecondTextureCoordinateAttribute);
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      setBitmap(this.mBitmap);
    }
  }
  
  public void recycleBitmap()
  {
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
  }
  
  public void setBitmap(final Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramBitmap.isRecycled())) {}
    do
    {
      return;
      this.mBitmap = paramBitmap;
    } while (this.mBitmap == null);
    runOnDraw(new Runnable()
    {
      public void run()
      {
        if ((QQAVImageTwoInputFilter.this.mFilterSourceTexture2 != -1) || (paramBitmap == null) || (paramBitmap.isRecycled())) {
          return;
        }
        GLES20.glActiveTexture(33987);
        QQAVImageTwoInputFilter.this.mFilterSourceTexture2 = OpenGlUtils.loadTexture(paramBitmap, -1, false);
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
    this.mTexture2CoordinatesBuffer = localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter
 * JD-Core Version:    0.7.0.1
 */