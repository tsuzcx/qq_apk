package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class NewerGuideBannerViewModel$3
  implements Runnable
{
  NewerGuideBannerViewModel$3(NewerGuideBannerViewModel paramNewerGuideBannerViewModel, String paramString, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "[onContactsWebJump] allow");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("&ab_auth=1");
    localObject = ((StringBuilder)localObject).toString();
    this.this$0.b(this.b, (String)localObject);
    NewerGuideBannerViewModel.a(this.this$0, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.3
 * JD-Core Version:    0.7.0.1
 */