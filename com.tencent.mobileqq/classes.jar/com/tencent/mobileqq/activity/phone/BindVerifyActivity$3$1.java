package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class BindVerifyActivity$3$1
  implements Runnable
{
  BindVerifyActivity$3$1(BindVerifyActivity.3 param3) {}
  
  public void run()
  {
    this.a.this$0.mPhoneContactService.uploadPhoneContact();
    this.a.this$0.mPhoneContactService.setNeedUploadResultTip(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity.3.1
 * JD-Core Version:    0.7.0.1
 */