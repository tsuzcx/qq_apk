package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;

class NewerGuideBannerViewModel$2
  implements Runnable
{
  NewerGuideBannerViewModel$2(NewerGuideBannerViewModel paramNewerGuideBannerViewModel, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((IWebProcessManagerService)this.a.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(-1, null);
    this.this$0.a.c(this.a.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.2
 * JD-Core Version:    0.7.0.1
 */