package com.tencent.biz.pubaccount.accountdetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.qphone.base.util.QLog;

class AccountDetailCustomModuleBaseWrapper$1
  implements View.OnClickListener
{
  AccountDetailCustomModuleBaseWrapper$1(AccountDetailCustomModuleBaseWrapper paramAccountDetailCustomModuleBaseWrapper) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof IPublicAccountConfigAttr.PaConfigInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailCustomModuleBaseWrapper", 2, "click!");
      }
      paramView = (IPublicAccountConfigAttr.PaConfigInfo)paramView;
      if (this.a.a != null) {
        this.a.a.a(paramView);
      }
      this.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailCustomModuleBaseWrapper.1
 * JD-Core Version:    0.7.0.1
 */