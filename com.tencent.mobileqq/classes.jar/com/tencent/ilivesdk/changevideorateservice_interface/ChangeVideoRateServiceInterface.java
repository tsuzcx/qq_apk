package com.tencent.ilivesdk.changevideorateservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.changevideorateservice_interface.model.AudNetworkDetectListener;
import com.tencent.ilivesdk.changevideorateservice_interface.model.VideoRateServiceListener;

public abstract interface ChangeVideoRateServiceInterface
  extends ServiceBaseInterface
{
  public static final int NETWORK_QUALITY_LEVEL_BAD = 1;
  public static final int NETWORK_QUALITY_LEVEL_GOOD = 3;
  public static final int NETWORK_QUALITY_LEVEL_NORMAL = 2;
  public static final int NETWORK_QUALITY_LEVEL_UNKNOWN = 0;
  
  public abstract void doAudNetWorkDetection(int[] paramArrayOfInt, AudNetworkDetectListener paramAudNetworkDetectListener);
  
  public abstract int getAudNetworkQuality();
  
  public abstract int getAudSuggestBitrate(int[] paramArrayOfInt);
  
  public abstract void setAdapter(ChangeVideoRateServiceAdapter paramChangeVideoRateServiceAdapter);
  
  public abstract void setVideoRateServiceListener(VideoRateServiceListener paramVideoRateServiceListener);
  
  public abstract void stopAudNetWordDetection();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.changevideorateservice_interface.ChangeVideoRateServiceInterface
 * JD-Core Version:    0.7.0.1
 */