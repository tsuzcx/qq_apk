package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public abstract class QQAVImageColorFilter
  extends QQAVImageFilter
{
  protected int[] GL_TEXTURES = { 33987, 33988, 33989, 33990, 33991, 33992 };
  protected Bitmap[] bitmaps;
  protected int[] coordinateAttributes;
  protected FloatBuffer[] coordinatesBuffers;
  protected int[] inputTextureUniforms;
  protected int[] sourceTextures;
  protected int textureNum;
  
  public QQAVImageColorFilter(String paramString, int paramInt)
  {
    this(String.valueOf(15), paramString, paramInt);
  }
  
  public QQAVImageColorFilter(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1, paramString2);
    this.textureNum = paramInt;
    this.coordinateAttributes = new int[this.textureNum];
    this.inputTextureUniforms = new int[this.textureNum];
    this.sourceTextures = new int[this.textureNum];
    paramInt = 0;
    while (paramInt < this.textureNum)
    {
      this.sourceTextures[paramInt] = -1;
      paramInt += 1;
    }
    this.coordinatesBuffers = new FloatBuffer[this.textureNum];
    this.bitmaps = new Bitmap[this.textureNum];
    setRotation(0, false, false);
  }
  
  private void loadBitmap(int paramInt, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramBitmap.isRecycled())) {}
    while ((paramBitmap == null) || (paramBitmap == null) || (paramBitmap.isRecycled()) || (this.sourceTextures[paramInt] != -1)) {
      return;
    }
    GLES20.glActiveTexture(this.GL_TEXTURES[paramInt]);
    this.sourceTextures[paramInt] = OpenGlUtils.loadTexture(paramBitmap, -1, false);
  }
  
  public void onDestroy()
  {
    int i = 0;
    super.onDestroy();
    if (this.textureNum > 0) {
      try
      {
        GLES20.glDeleteTextures(1, this.sourceTextures, 0);
        while (i < this.textureNum)
        {
          this.sourceTextures[i] = -1;
          if ((this.bitmaps[i] != null) && (!this.bitmaps[i].isRecycled()))
          {
            this.bitmaps[i].recycle();
            this.bitmaps[i] = null;
          }
          i += 1;
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  protected void onDrawArraysPre()
  {
    int i = 0;
    while (i < this.textureNum)
    {
      if (this.coordinateAttributes[i] != -1)
      {
        GLES20.glEnableVertexAttribArray(this.coordinateAttributes[i]);
        this.coordinatesBuffers[i].position(0);
        GLES20.glVertexAttribPointer(this.coordinateAttributes[i], 2, 5126, false, 0, this.coordinatesBuffers[i]);
      }
      if (this.inputTextureUniforms[i] != -1)
      {
        GLES20.glActiveTexture(this.GL_TEXTURES[i]);
        GLES20.glBindTexture(3553, this.sourceTextures[i]);
        GLES20.glUniform1i(this.inputTextureUniforms[i], i + 3);
      }
      i += 1;
    }
  }
  
  public void onInit()
  {
    super.onInit();
    int i = 0;
    while (i < this.textureNum)
    {
      int j = i + 2;
      this.coordinateAttributes[i] = GLES20.glGetAttribLocation(getProgram(), String.format("inputTextureCoordinate%d", new Object[] { Integer.valueOf(j) }));
      this.inputTextureUniforms[i] = GLES20.glGetUniformLocation(getProgram(), String.format("inputImageTexture%d", new Object[] { Integer.valueOf(j) }));
      i += 1;
    }
  }
  
  public void setBitmap(int paramInt, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramBitmap.isRecycled())) {}
    do
    {
      do
      {
        return;
      } while (paramBitmap == null);
      this.bitmaps[paramInt] = paramBitmap;
    } while ((this.bitmaps[paramInt] == null) || (this.bitmaps[paramInt].isRecycled()));
    loadBitmap(paramInt, this.bitmaps[paramInt]);
  }
  
  public void setRotation(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt = 0;
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(OpenGlUtils.CUBE8.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(OpenGlUtils.CUBE8).position(0);
    while (paramInt < this.textureNum)
    {
      this.coordinatesBuffers[paramInt] = localFloatBuffer;
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageColorFilter
 * JD-Core Version:    0.7.0.1
 */