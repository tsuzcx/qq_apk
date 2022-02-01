package com.tencent.mobileqq.activity.bless;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class BlessSelectMemberActivity$2
  implements DialogInterface.OnClickListener
{
  BlessSelectMemberActivity$2(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(this.a.getApplicationContext())) {
      QQToast.a(this.a, 2131694730, 1).a();
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity.2
 * JD-Core Version:    0.7.0.1
 */