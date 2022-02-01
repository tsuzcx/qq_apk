package com.tencent.mobileqq.activity.aio.core;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class TroopChatPie$15
  implements DialogInterface.OnClickListener
{
  TroopChatPie$15(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (ITroopMngHandler)this.a.d.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
    if ((NetworkUtil.isNetSupport(this.a.d.getApp().getApplicationContext())) && (paramDialogInterface != null))
    {
      if (((TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.a.ah.b).isTroopOwner(this.a.d.getCurrentAccountUin())) {
        paramDialogInterface.b(this.a.ah.b);
      } else {
        paramDialogInterface.a(this.a.ah.b);
      }
    }
    else if (paramDialogInterface != null) {
      QQToast.makeText(this.a.f, 1, 2131892157, 0).show();
    } else {
      QQToast.makeText(this.a.f, 1, 2131889057, 0).show();
    }
    new ReportTask(this.a.d).a("dc00899").b("Grp_banned").c("Grp_AIO").d("clk_quitgrp").a(new String[] { this.a.ah.b }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.15
 * JD-Core Version:    0.7.0.1
 */