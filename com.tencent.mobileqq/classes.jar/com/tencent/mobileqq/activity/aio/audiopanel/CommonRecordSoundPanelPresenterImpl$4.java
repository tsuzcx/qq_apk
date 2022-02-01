package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class CommonRecordSoundPanelPresenterImpl$4
  implements Runnable
{
  CommonRecordSoundPanelPresenterImpl$4(CommonRecordSoundPanelPresenterImpl paramCommonRecordSoundPanelPresenterImpl, ICommonRecordSoundPanelView paramICommonRecordSoundPanelView, String paramString) {}
  
  public void run()
  {
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = this.a;
    if (localICommonRecordSoundPanelView != null)
    {
      QQToast.makeText(localICommonRecordSoundPanelView.getApp().getApp(), 2131886620, 1).show(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTitleBarHeight(this.a.getViewContext()));
      this.a.b(this.b);
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.4
 * JD-Core Version:    0.7.0.1
 */