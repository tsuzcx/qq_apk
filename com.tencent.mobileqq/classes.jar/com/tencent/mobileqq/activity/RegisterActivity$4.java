package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;

class RegisterActivity$4
  implements DialogInterface.OnClickListener
{
  RegisterActivity$4(RegisterActivity paramRegisterActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131910821));
    localStringBuilder.append(HardCodeUtil.a(2131910842));
    localStringBuilder.append(this.a);
    localStringBuilder.append(HardCodeUtil.a(2131910820));
    localStringBuilder.append(this.b);
    localStringBuilder.append(HardCodeUtil.a(2131910813));
    RegisterActivity.a(paramDialogInterface, localStringBuilder.toString());
    RegisterActivity.a(this.c);
    RegisterActivity.a(this.c, 60000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.4
 * JD-Core Version:    0.7.0.1
 */