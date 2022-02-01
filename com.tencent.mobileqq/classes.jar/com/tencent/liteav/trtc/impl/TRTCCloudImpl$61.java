package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$61
  implements Runnable
{
  TRTCCloudImpl$61(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    int j = this.val$intervalMs;
    int i;
    if (j > 0)
    {
      i = j;
      if (j < 100) {
        i = 100;
      }
    }
    else
    {
      i = 0;
    }
    if (i == this.this$0.mAudioVolumeEvalInterval) {
      return;
    }
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableAudioVolumeEvaluation ");
    localStringBuilder.append(i);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    localTRTCCloudImpl = this.this$0;
    localTRTCCloudImpl.mAudioVolumeEvalInterval = i;
    if (localTRTCCloudImpl.mAudioVolumeEvalInterval > 0)
    {
      this.this$0.startVolumeLevelCal(true);
      return;
    }
    this.this$0.startVolumeLevelCal(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.61
 * JD-Core Version:    0.7.0.1
 */