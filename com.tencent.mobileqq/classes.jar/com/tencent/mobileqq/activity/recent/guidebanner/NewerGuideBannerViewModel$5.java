package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import mqq.app.AppRuntime;

class NewerGuideBannerViewModel$5
  implements Runnable
{
  NewerGuideBannerViewModel$5(NewerGuideBannerViewModel paramNewerGuideBannerViewModel, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.a.getAppRuntime().getRuntimeService(IPhoneContactService.class, "");
    localIPhoneContactService.uploadOrUpdateContact();
    localIPhoneContactService.setNeedUploadResultTip(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.5
 * JD-Core Version:    0.7.0.1
 */