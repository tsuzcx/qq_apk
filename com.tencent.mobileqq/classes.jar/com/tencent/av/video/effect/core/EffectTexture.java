package com.tencent.av.video.effect.core;

public class EffectTexture
{
  public static final int NO_FBO = -1;
  public static final int NO_TEXTURE = -1;
  int mFbo = -1;
  int mHeight;
  int mTextureId = -1;
  int mWidth;
  
  public EffectTexture() {}
  
  public EffectTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mTextureId = paramInt1;
    this.mFbo = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  public int getFbo()
  {
    return this.mFbo;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getTextureId()
  {
    return this.mTextureId;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public void setFbo(int paramInt)
  {
    this.mFbo = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setTextureId(int paramInt)
  {
    this.mTextureId = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.core.EffectTexture
 * JD-Core Version:    0.7.0.1
 */