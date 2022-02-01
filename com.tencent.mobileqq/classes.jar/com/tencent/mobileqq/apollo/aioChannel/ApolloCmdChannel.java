package com.tencent.mobileqq.apollo.aioChannel;

import android.graphics.Bitmap;

public abstract class ApolloCmdChannel
{
  protected native void callbackEngine(long paramLong, int paramInt, String paramString1, String paramString2);
  
  protected native void callbackEngineOld(long paramLong, int paramInt, String paramString1, String paramString2);
  
  protected abstract void getAccountInfo(long paramLong, String paramString, int paramInt);
  
  protected abstract int getDeviceHeight();
  
  protected abstract int getDeviceWidth();
  
  protected abstract int getDispalyDpi();
  
  protected abstract int getMusicCurPos(int paramInt);
  
  protected abstract int getMusicDuration(int paramInt);
  
  protected abstract int getMusicSwitch();
  
  protected abstract String getNickname(int paramInt, String paramString1, String paramString2);
  
  protected abstract void getOpenApiHead(long paramLong, String paramString);
  
  protected abstract void getOpenApiNick(long paramLong, String paramString);
  
  public native void nativeGetHeadCallback(Bitmap paramBitmap, String paramString, int paramInt, long paramLong);
  
  public native void nativeGetNickCallback(String paramString1, String paramString2, int paramInt, long paramLong);
  
  protected native void nativeOpenApiGetHeadCallBack(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  protected native void nativeOpenApiGetNickCallBack(long paramLong, String paramString1, int paramInt, String paramString2);
  
  public native void nativeSetAudioHash(long paramLong, int paramInt);
  
  protected native void nativeSetDataChannelObj(ApolloCmdChannel paramApolloCmdChannel);
  
  protected abstract void openWebview(String paramString);
  
  protected abstract void operateNativeUI(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4);
  
  protected abstract void pauseMusic(int paramInt, String paramString);
  
  protected abstract void playMusic(long paramLong, int paramInt1, int paramInt2, String paramString);
  
  protected abstract void playMusic(long paramLong, int paramInt1, int paramInt2, String paramString, float paramFloat, int paramInt3, int paramInt4);
  
  protected abstract String requestData(long paramLong, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  protected abstract void resumeMusic(int paramInt, String paramString);
  
  protected abstract void seekTo(int paramInt1, int paramInt2);
  
  protected abstract void setMusicSwitch(int paramInt);
  
  protected abstract void stopMusic(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel
 * JD-Core Version:    0.7.0.1
 */