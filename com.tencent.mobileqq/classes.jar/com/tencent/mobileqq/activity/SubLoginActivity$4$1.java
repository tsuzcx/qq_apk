package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;

class SubLoginActivity$4$1
  implements Runnable
{
  SubLoginActivity$4$1(SubLoginActivity.4 param4, String paramString) {}
  
  public void run()
  {
    ISubAccountService localISubAccountService = (ISubAccountService)this.b.a.app.getRuntimeService(ISubAccountService.class, "");
    if (localISubAccountService != null) {
      localISubAccountService.updateServerError(this.a, 0, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.4.1
 * JD-Core Version:    0.7.0.1
 */