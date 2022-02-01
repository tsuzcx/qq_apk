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
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelView;
    if (localICommonRecordSoundPanelView != null)
    {
      QQToast.a(localICommonRecordSoundPanelView.a().getApp(), 2131689978, 1).b(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTitleBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelView.a()));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelView.b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.4
 * JD-Core Version:    0.7.0.1
 */