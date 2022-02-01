package com.tencent.ilivesdk.avplayerbuilderservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceInterface;

public abstract interface AVPlayerBuilderServiceInterface
  extends ServiceBaseInterface, AVPlayerServiceInterface
{
  public static final int AV_INIT_FAILED_EVENT = 4;
  public static final int AV_INIT_SUCCESS_EVENT = 3;
  public static final int LOGIN_FAILED_EVENT = 2;
  public static final int LOGIN_SUCCESS_EVENT = 1;
  
  public abstract String[] getSupportFormat();
  
  public abstract boolean isSupportFormat(AVPlayerBuilderServiceInterface.VideoFormat paramVideoFormat);
  
  public abstract void onLoginEvent(int paramInt, String paramString);
  
  public abstract void setBuilderAdapter(AVPlayerServiceBuilderAdapter paramAVPlayerServiceBuilderAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface
 * JD-Core Version:    0.7.0.1
 */