package com.tencent.maxvideo.mediaplay;

import com.tencent.maxvideo.common.MessageStruct;

public class TMMNativeVideoPlayer
{
  public long nativeAddr;
  
  public native void init(Object paramObject);
  
  public native void nativeChangeSize(int paramInt1, int paramInt2);
  
  public native boolean nativeIsLooping();
  
  public native boolean nativeIsPlaying();
  
  public native void nativePause();
  
  public native void nativePlayAudio();
  
  public native void nativeProcessMsg(MessageStruct paramMessageStruct);
  
  public native void nativeRelease();
  
  public native void nativeRenderScene();
  
  public native void nativeReset();
  
  public native void nativeSeekTo(int paramInt);
  
  public native void nativeSetAudioPath(String paramString);
  
  public native void nativeSetFilter(int paramInt);
  
  public native void nativeSetLooping(boolean paramBoolean);
  
  public native void nativeSetPlayOrder(int paramInt);
  
  public native void nativeSetPlaySpeed(int paramInt);
  
  public native void nativeSetPlayingAudio(boolean paramBoolean);
  
  public native void nativeSetVideoPath(String paramString);
  
  public native void nativeSetVideoURI(String paramString);
  
  public native void nativeSetupScene();
  
  public native void nativeShutdownScene();
  
  public native void nativeStart();
  
  public native void nativeStartRealFps(int paramInt1, int paramInt2);
  
  public native void nativeStop();
  
  public native void nativeStopAudio();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.maxvideo.mediaplay.TMMNativeVideoPlayer
 * JD-Core Version:    0.7.0.1
 */