package com.tencent.avcore.jni.render;

public abstract interface IRenderTextureProxy
{
  public abstract boolean canRender();
  
  public abstract void flush(boolean paramBoolean);
  
  public abstract int getCaptureFrameHeight();
  
  public abstract byte[] getCaptureFrameTexture();
  
  public abstract int getCaptureFrameWidth();
  
  public abstract byte[] getFaceFeature();
  
  public abstract byte[] getFrameTexture();
  
  public abstract int getImgAngle();
  
  public abstract int getImgHeight();
  
  public abstract int getImgWidth();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract boolean updateCurFrame();
  
  public abstract int uploadContent(int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.render.IRenderTextureProxy
 * JD-Core Version:    0.7.0.1
 */