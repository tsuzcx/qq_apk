package com.tencent.avcore.jni.render;

public abstract interface GLRenderListener
{
  public abstract void onFaceFeatureUpdate(byte[] paramArrayOfByte);
  
  public abstract void onRenderFlush();
  
  public abstract void onRenderFrame();
  
  public abstract void onRenderInfoNotify(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onRenderReset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.render.GLRenderListener
 * JD-Core Version:    0.7.0.1
 */