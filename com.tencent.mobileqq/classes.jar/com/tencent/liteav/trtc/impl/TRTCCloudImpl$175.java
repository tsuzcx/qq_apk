package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;

class TRTCCloudImpl$175
  implements Runnable
{
  TRTCCloudImpl$175(TRTCCloudImpl paramTRTCCloudImpl, TRTCStatistics paramTRTCStatistics, TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList paramArrayList) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    if (localTRTCCloudListener != null)
    {
      localTRTCCloudListener.onStatistics(this.val$statistics);
      localTRTCCloudListener.onNetworkQuality(this.val$localQuality, this.val$remoteQualityArray);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.175
 * JD-Core Version:    0.7.0.1
 */