package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;

class SubLoginActivity$9$1
  implements Runnable
{
  SubLoginActivity$9$1(SubLoginActivity.9 param9, String paramString) {}
  
  public void run()
  {
    ISubAccountService localISubAccountService = (ISubAccountService)this.jdField_a_of_type_ComTencentMobileqqActivitySubLoginActivity$9.a.app.getRuntimeService(ISubAccountService.class, "");
    if (localISubAccountService != null) {
      localISubAccountService.updateServerError(this.jdField_a_of_type_JavaLangString, 0, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.9.1
 * JD-Core Version:    0.7.0.1
 */