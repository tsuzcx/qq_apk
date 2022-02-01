package com.tencent.avcore.jni.render;

public class RenderProxy
  implements IRenderEngine
{
  private final RenderEngineJni renderJni = new RenderEngineJni();
  
  public void clearCameraFrames()
  {
    this.renderJni.clearCameraFrames();
  }
  
  public String findConfigValue(String paramString1, String paramString2, String paramString3)
  {
    return this.renderJni.findConfigValue(paramString1, paramString2, paramString3);
  }
  
  public void flushGlRender(String paramString)
  {
    this.renderJni.flushGlRender(paramString);
  }
  
  public long getRecvDecoderFrameFunctionPtr()
  {
    return this.renderJni.getRecvDecoderFrameFunctionPtr();
  }
  
  public void onUinChanged(String paramString1, String paramString2)
  {
    this.renderJni.onUinChanged(paramString1, paramString2);
  }
  
  public int sendCameraFrame(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, boolean paramBoolean, float[] paramArrayOfFloat, byte[] paramArrayOfByte2, int paramInt6, int paramInt7)
  {
    if ((!paramBoolean) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3)) {
      return this.renderJni.sendCameraFrame2Native(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramBoolean, paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfByte2, paramInt6, paramInt7);
    }
    return this.renderJni.sendCameraFrame2Native(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramBoolean, 0.0F, 0.0F, 0.0F, paramArrayOfByte2, paramInt6, paramInt7);
  }
  
  public int sendCameraFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
  {
    return this.renderJni.sendCameraFrame2Native(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramLong, paramBoolean, 0.0F, 0.0F, 0.0F, null, 0, 0);
  }
  
  public void setAccountUin(String paramString)
  {
    this.renderJni.setAccountUin(paramString);
  }
  
  public void setBeautyFlag(int paramInt)
  {
    this.renderJni.setBeautyFlag(paramInt);
  }
  
  public void setBeautyOrFaceConfig(int paramInt1, int paramInt2)
  {
    this.renderJni.setBeautyOrFaceConfig(paramInt1, paramInt2);
  }
  
  public void setFocusConfig(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    this.renderJni.setFocusConfig(paramBoolean, paramLong, paramInt1, paramInt2);
  }
  
  public void setFocusDetectCallback(FocusDetectCallback paramFocusDetectCallback)
  {
    this.renderJni.setFocusDetectCallback(paramFocusDetectCallback);
  }
  
  public void setGlRender2Native(String paramString, RenderTextureJni paramRenderTextureJni)
  {
    this.renderJni.setGlRender(paramString, paramRenderTextureJni);
  }
  
  public void setIsFocusing(boolean paramBoolean)
  {
    this.renderJni.setIsFocusing(paramBoolean);
  }
  
  public void setLowlightAndVideoDenoiseInfo(int[] paramArrayOfInt)
  {
    this.renderJni.setLowlightAndVideoDenoiseInfo(paramArrayOfInt);
  }
  
  public void setProcessEncodeFrameFunctionPtr(long paramLong)
  {
    this.renderJni.setProcessEncodeFrameFunctionPtr(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.render.RenderProxy
 * JD-Core Version:    0.7.0.1
 */