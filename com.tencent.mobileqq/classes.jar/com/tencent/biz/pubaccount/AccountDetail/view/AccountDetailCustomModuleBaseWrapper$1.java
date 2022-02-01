package com.tencent.biz.pubaccount.AccountDetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountDetailCustomModuleBaseWrapper$1
  implements View.OnClickListener
{
  AccountDetailCustomModuleBaseWrapper$1(AccountDetailCustomModuleBaseWrapper paramAccountDetailCustomModuleBaseWrapper) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof PaConfigAttr.PaConfigInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailCustomModuleBaseWrapper", 2, "click!");
      }
      localObject = (PaConfigAttr.PaConfigInfo)localObject;
      if (this.a.a != null) {
        this.a.a.a((PaConfigAttr.PaConfigInfo)localObject);
      }
      this.a.a((PaConfigAttr.PaConfigInfo)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailCustomModuleBaseWrapper.1
 * JD-Core Version:    0.7.0.1
 */