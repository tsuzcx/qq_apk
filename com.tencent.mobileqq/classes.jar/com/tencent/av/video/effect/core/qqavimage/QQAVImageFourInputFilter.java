package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class QQAVImageFourInputFilter
  extends QQAVImageFilter
{
  public int mFilterInputTextureUniform2;
  public int mFilterInputTextureUniform3;
  public int mFilterInputTextureUniform4;
  public int mFilterSourceTexture2 = -1;
  public int mFilterSourceTexture3 = -1;
  public int mFilterSourceTexture4 = -1;
  public int mFilterTextureCoordinateAttribute2;
  public int mFilterTextureCoordinateAttribute3;
  public int mFilterTextureCoordinateAttribute4;
  private ByteBuffer mTextureCoordinatesBuffer2;
  private ByteBuffer mTextureCoordinatesBuffer3;
  private ByteBuffer mTextureCoordinatesBuffer4;
  
  public QQAVImageFourInputFilter(String paramString)
  {
    this(String.valueOf(29), paramString);
  }
  
  public QQAVImageFourInputFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    setRotation(0, false, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    GLES20.glDeleteTextures(1, new int[] { this.mFilterSourceTexture2 }, 0);
    this.mFilterSourceTexture2 = -1;
    GLES20.glDeleteTextures(1, new int[] { this.mFilterSourceTexture3 }, 0);
    this.mFilterSourceTexture3 = -1;
    GLES20.glDeleteTextures(1, new int[] { this.mFilterSourceTexture4 }, 0);
    this.mFilterSourceTexture4 = -1;
  }
  
  protected void onDrawArraysPre()
  {
    GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute2);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, this.mFilterSourceTexture2);
    GLES20.glUniform1i(this.mFilterInputTextureUniform2, 3);
    GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute3);
    GLES20.glActiveTexture(33988);
    GLES20.glBindTexture(3553, this.mFilterSourceTexture3);
    GLES20.glUniform1i(this.mFilterInputTextureUniform3, 4);
    GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute4);
    GLES20.glActiveTexture(33989);
    GLES20.glBindTexture(3553, this.mFilterSourceTexture4);
    GLES20.glUniform1i(this.mFilterInputTextureUniform4, 5);
    this.mTextureCoordinatesBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute2, 2, 5126, false, 0, this.mTextureCoordinatesBuffer2);
    this.mTextureCoordinatesBuffer3.position(0);
    GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute3, 2, 5126, false, 0, this.mTextureCoordinatesBuffer3);
    this.mTextureCoordinatesBuffer4.position(0);
    GLES20.glVertexAttribPointer(this.mFilterTextureCoordinateAttribute4, 2, 5126, false, 0, this.mTextureCoordinatesBuffer4);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mFilterTextureCoordinateAttribute2 = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate2");
    this.mFilterInputTextureUniform2 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture2");
    GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute2);
    this.mFilterTextureCoordinateAttribute3 = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate3");
    this.mFilterInputTextureUniform3 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture3");
    GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute3);
    this.mFilterTextureCoordinateAttribute4 = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate4");
    this.mFilterInputTextureUniform4 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture4");
    GLES20.glEnableVertexAttribArray(this.mFilterTextureCoordinateAttribute4);
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
    this.mTextureCoordinatesBuffer4 = localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageFourInputFilter
 * JD-Core Version:    0.7.0.1
 */