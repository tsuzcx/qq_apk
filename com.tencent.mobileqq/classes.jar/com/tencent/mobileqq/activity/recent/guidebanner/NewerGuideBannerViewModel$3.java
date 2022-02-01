package com.tencent.mobileqq.activity.recent.guidebanner;

import alkp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class NewerGuideBannerViewModel$3
  implements Runnable
{
  public NewerGuideBannerViewModel$3(alkp paramalkp, String paramString, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "[onContactsWebJump] allow");
    }
    String str = this.jdField_a_of_type_JavaLangString + "&ab_auth=1";
    alkp.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str);
    alkp.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.3
 * JD-Core Version:    0.7.0.1
 */