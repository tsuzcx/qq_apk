package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl;
import com.tencent.util.Pair;

class SubAccountUgActivity$1$1
  implements DialogInterface.OnClickListener
{
  SubAccountUgActivity$1$1(SubAccountUgActivity.1 param1, SubAccountControlServiceImpl paramSubAccountControlServiceImpl, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.cancelHintDialog((String)this.b.first, ((Integer)this.b.second).intValue(), true);
    if (!SubAccountControllUtil.b(this.c.a.app))
    {
      this.c.a.setTitle("");
      SubAccountAssistantForward.a(this.c.a.app, this.c.a, null);
    }
    this.c.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity.1.1
 * JD-Core Version:    0.7.0.1
 */