package com.tencent.TMG.sdk;

public class AVEndpoint
{
  public int nativeObj = 0;
  
  public native String getId();
  
  public native AVEndpoint.Info getInfo();
  
  public native boolean hasAudio();
  
  public native boolean hasCameraVideo();
  
  public native boolean hasMediaVideo();
  
  public native boolean hasScreenVideo();
  
  public native boolean isLinkedRoomUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVEndpoint
 * JD-Core Version:    0.7.0.1
 */