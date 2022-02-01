package com.tencent.mobileqq.activity.phone;

import android.os.Handler;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

class BindVerifyActivity$2
  extends ContactBindObserver
{
  BindVerifyActivity$2(BindVerifyActivity paramBindVerifyActivity) {}
  
  protected void onVerifyBindSms(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVerifyBindSms [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("BindVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    BindVerifyActivity.a(this.a, false);
    BindVerifyActivity.b(this.a).removeMessages(4);
    this.a.dismissProgressDialog();
    if (!paramBoolean)
    {
      this.a.a("dc00898", "0X8009F19", 0);
      localObject = this.a;
      ((BindVerifyActivity)localObject).showToast(1, ((BindVerifyActivity)localObject).getString(2131915700));
    }
    else if ((paramInt != 0) && (paramInt != 106))
    {
      if (paramInt == 213)
      {
        this.a.a("dc00898", "0X8009F19", 0);
        this.a.showToast(1, HardCodeUtil.a(2131899374));
        BindVerifyActivity.c(this.a).setEnabled(true);
      }
      else
      {
        this.a.a("dc00898", "0X8009F19", 0);
        localObject = HardCodeUtil.a(2131899369);
        if (paramInt == 107) {
          localObject = HardCodeUtil.a(2131899371);
        }
        this.a.showConfirmFinish(HardCodeUtil.a(2131899375), (String)localObject);
      }
    }
    else
    {
      this.a.b();
    }
    this.a.app.unRegistObserver(BindVerifyActivity.d(this.a));
    BindVerifyActivity.b(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity.2
 * JD-Core Version:    0.7.0.1
 */