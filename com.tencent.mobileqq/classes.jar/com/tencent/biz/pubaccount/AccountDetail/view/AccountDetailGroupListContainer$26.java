package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.widget.Switch;

class AccountDetailGroupListContainer$26
  implements DialogInterface.OnClickListener
{
  AccountDetailGroupListContainer$26(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((3 == this.a.g) && (this.a.f == 0)) {
        this.d.a(this.a, true ^ this.b);
      }
      this.d.a(this.a, this.c);
      return;
    }
    if (paramInt == 1) {
      this.d.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.26
 * JD-Core Version:    0.7.0.1
 */