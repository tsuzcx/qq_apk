package com.tencent.avcore.jni.render;

public abstract interface IGLRenderTexture
  extends GLRenderListener
{
  public static final int MSG_FLUSH = 1;
  public static final int MSG_INFO_CHANGE = 4;
  public static final int MSG_RENDER = 0;
  public static final int MSG_RESET = 2;
  public static final int MSG_SHOW = 3;
  
  public abstract void markForPerf(int paramInt);
  
  public abstract void nativeFrameDataUpdate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.render.IGLRenderTexture
 * JD-Core Version:    0.7.0.1
 */