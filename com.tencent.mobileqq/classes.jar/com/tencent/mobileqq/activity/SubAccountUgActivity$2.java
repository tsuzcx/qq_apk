package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.util.Pair;

class SubAccountUgActivity$2
  implements DialogInterface.OnClickListener
{
  SubAccountUgActivity$2(SubAccountUgActivity paramSubAccountUgActivity, ISubAccountControlService paramISubAccountControlService, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.cancelHintDialog((String)this.b.first, ((Integer)this.b.second).intValue(), true);
    if (!SubAccountControllUtil.b(this.c.app))
    {
      this.c.setTitle("");
      SubAccountAssistantForward.a(this.c.app, this.c, null);
    }
    this.c.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity.2
 * JD-Core Version:    0.7.0.1
 */