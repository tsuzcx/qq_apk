package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.qroute.QRoute;

class CommonRecordSoundPanelPresenterImpl$8
  implements Runnable
{
  CommonRecordSoundPanelPresenterImpl$8(CommonRecordSoundPanelPresenterImpl paramCommonRecordSoundPanelPresenterImpl, int paramInt, double paramDouble) {}
  
  public void run()
  {
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = this.this$0.a();
    if (localICommonRecordSoundPanelView != null)
    {
      localICommonRecordSoundPanelView.b(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getVolumeLevel(this.a));
      localICommonRecordSoundPanelView.setRecordTime(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.b));
      this.this$0.b = this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.8
 * JD-Core Version:    0.7.0.1
 */