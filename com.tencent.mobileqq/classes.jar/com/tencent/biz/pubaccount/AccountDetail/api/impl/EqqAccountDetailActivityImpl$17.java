package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class EqqAccountDetailActivityImpl$17
  extends NewPublicAccountObserver.ResponseResultListener
{
  EqqAccountDetailActivityImpl$17(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt1, int paramInt2) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      paramObject = ((ArrayList)paramObject).iterator();
      while (paramObject.hasNext())
      {
        Object localObject = paramObject.next();
        if (((localObject instanceof AppletItem)) && (((AppletItem)localObject).f().equals(this.d.uin)))
        {
          this.a.f = this.b;
          this.d.setAccountData();
          if (this.a.g == 6) {
            if (this.c == 1)
            {
              this.d.setShowMsgFlag(1);
              ReportController.b(this.d.app, "P_CliOper", "Pb_account_lifeservice", this.d.uin, "mp_msg_ziliao_2", "share_click", 0, 0, "", "", "", "");
              ReportController.b(this.d.app, "P_CliOper", "Pb_account_lifeservice", this.d.uin, "0X8004F05", "0X8004F05", 0, 0, "", "", "", "");
            }
            else
            {
              ReportController.b(this.d.app, "P_CliOper", "Pb_account_lifeservice", this.d.uin, "0X8004F07", "0X8004F07", 0, 0, "", "", "", "");
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.d.TAG, 2, String.valueOf(this.c));
          }
          this.d.saveAccountDetailInSubThread();
          if (QLog.isColorLevel()) {
            QLog.d(this.d.TAG, 2, "状态切换成功");
          }
          this.d.setStatusText(this.a);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = this.d.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("success:");
      localStringBuilder.append(paramBoolean);
      QLog.d(paramObject, 2, localStringBuilder.toString());
    }
    this.d.removeLoading();
  }
  
  public void b(Object paramObject)
  {
    this.d.displayToast(2131892951);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    paramObject = this.d;
    paramObject.waitingCount -= 1;
    if (this.d.waitingCount == 0) {
      this.d.removeLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.17
 * JD-Core Version:    0.7.0.1
 */