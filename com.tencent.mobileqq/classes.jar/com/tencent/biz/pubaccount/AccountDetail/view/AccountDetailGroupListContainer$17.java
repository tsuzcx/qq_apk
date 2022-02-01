package com.tencent.biz.pubaccount.accountdetail.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.widget.Switch;

class AccountDetailGroupListContainer$17
  implements CompoundButton.OnCheckedChangeListener
{
  AccountDetailGroupListContainer$17(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.c.o)
    {
      this.c.o = true;
      return;
    }
    if (this.a.i == 1) {
      this.c.a(this.a, paramBoolean);
    } else if (this.a.i == 2)
    {
      if (paramBoolean) {
        this.c.a(this.a, this.b, paramBoolean);
      } else {
        this.c.a(this.a, paramBoolean);
      }
    }
    else if (this.a.i == 3)
    {
      if (!paramBoolean) {
        this.c.a(this.a, this.b, paramBoolean);
      } else {
        this.c.a(this.a, paramBoolean);
      }
    }
    else {
      this.c.a(this.a, paramBoolean);
    }
    AccountDetailGroupListContainer.a(this.c, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.17
 * JD-Core Version:    0.7.0.1
 */