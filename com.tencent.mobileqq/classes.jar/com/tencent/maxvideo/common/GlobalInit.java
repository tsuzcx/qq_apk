package com.tencent.maxvideo.common;

import com.tencent.video.decode.ShortVideoSoLoad;

public class GlobalInit
{
  public static int loadLibraryWithFullPath(String paramString)
  {
    return ShortVideoSoLoad.LoadExtractedShortVideo(paramString);
  }
  
  public static native boolean nativeAsyncProcessMsg(MessageStruct paramMessageStruct, Object paramObject);
  
  public static native boolean nativeSyncProcessMsg(MessageStruct paramMessageStruct1, MessageStruct paramMessageStruct2, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.maxvideo.common.GlobalInit
 * JD-Core Version:    0.7.0.1
 */