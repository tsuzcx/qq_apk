package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class PublicAccountChatPie$10
  implements Runnable
{
  PublicAccountChatPie$10(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    Object localObject2 = (IPublicAccountDataManager)this.this$0.d.getRuntimeService(IPublicAccountDataManager.class, "all");
    Object localObject1;
    if (localObject2 != null) {
      localObject1 = (PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfo(this.this$0.ah.b);
    } else {
      localObject1 = null;
    }
    boolean bool1;
    if (localObject1 == null)
    {
      boolean bool2 = this.this$0.bI();
      this.this$0.bH();
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(this.this$0.bs))
        {
          bool1 = bool2;
          if (localObject2 != null)
          {
            localObject1 = ((IPublicAccountDataManager)localObject2).findAccountDetailInfo(this.this$0.ah.b);
            bool1 = bool2;
            if (localObject1 != null)
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(((IPublicAccountDetail)localObject1).getSummary()))
              {
                this.this$0.bs = ((IPublicAccountDetail)localObject1).getSummary();
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
    else
    {
      bool1 = false;
    }
    if ((!bool1) && (!PublicAccountChatPie.h(this.this$0)))
    {
      if (!PublicAccountChatPie.i(this.this$0)) {
        this.this$0.bi.init(this.this$0.f, this.this$0.d, this.this$0.d.getAccount(), this.this$0.ah.b, new PublicAccountChatPie.10.1(this));
      }
    }
    else
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.this$0.d, "CliOper", "", "", "0X8004EFB", "0X8004EFB", 0, 0, "", "", "", "", false);
      localObject1 = this.this$0;
      ((PublicAccountChatPie)localObject1).bp = true;
      ((PublicAccountChatPie)localObject1).ce.sendEmptyMessage(3);
    }
    if (bool1) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("PublicAccountChatPie :CliOper|");
      ((StringBuilder)localObject2).append(this.this$0.ah.b);
      ((StringBuilder)localObject2).append("|0X8005619|0X8005619");
      ((StringBuilder)localObject2).append(0);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(0);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(Long.toString(l));
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("struct_log_tag", 2, ((StringBuilder)localObject2).toString());
    }
    ReportController.b(this.this$0.d, "CliOper", "", this.this$0.ah.b, "0X8005619", "0X8005619", 0, 0, Long.toString(l), (String)localObject1, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.10
 * JD-Core Version:    0.7.0.1
 */