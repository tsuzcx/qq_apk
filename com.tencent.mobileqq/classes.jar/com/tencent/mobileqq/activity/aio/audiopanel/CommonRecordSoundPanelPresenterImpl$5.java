package com.tencent.mobileqq.activity.aio.audiopanel;

class CommonRecordSoundPanelPresenterImpl$5
  implements Runnable
{
  CommonRecordSoundPanelPresenterImpl$5(CommonRecordSoundPanelPresenterImpl paramCommonRecordSoundPanelPresenterImpl, ICommonRecordSoundPanelView paramICommonRecordSoundPanelView, String paramString) {}
  
  public void run()
  {
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = this.a;
    if (localICommonRecordSoundPanelView != null)
    {
      localICommonRecordSoundPanelView.b(this.b);
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.5
 * JD-Core Version:    0.7.0.1
 */