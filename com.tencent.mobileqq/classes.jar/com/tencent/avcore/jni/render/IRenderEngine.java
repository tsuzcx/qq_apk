package com.tencent.avcore.jni.render;

public abstract interface IRenderEngine
{
  public abstract void clearCameraFrames();
  
  public abstract String findConfigValue(String paramString1, String paramString2, String paramString3);
  
  public abstract void flushGlRender(String paramString);
  
  public abstract long getRecvDecoderFrameFunctionPtr();
  
  public abstract void onUinChanged(String paramString1, String paramString2);
  
  public abstract int sendCameraFrame(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, boolean paramBoolean, float[] paramArrayOfFloat, byte[] paramArrayOfByte2, int paramInt6, int paramInt7);
  
  public abstract int sendCameraFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean);
  
  public abstract void setAccountUin(String paramString);
  
  public abstract void setBeautyFlag(int paramInt);
  
  public abstract void setBeautyOrFaceConfig(int paramInt1, int paramInt2);
  
  public abstract void setFocusConfig(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2);
  
  public abstract void setFocusDetectCallback(FocusDetectCallback paramFocusDetectCallback);
  
  public abstract void setGlRender2Native(String paramString, RenderTextureJni paramRenderTextureJni);
  
  public abstract void setIsFocusing(boolean paramBoolean);
  
  public abstract void setLowlightAndVideoDenoiseInfo(int[] paramArrayOfInt);
  
  public abstract void setProcessEncodeFrameFunctionPtr(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.render.IRenderEngine
 * JD-Core Version:    0.7.0.1
 */