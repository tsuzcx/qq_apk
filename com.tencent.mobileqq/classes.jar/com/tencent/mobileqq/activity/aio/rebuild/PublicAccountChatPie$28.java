package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class PublicAccountChatPie$28
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountChatPie$28(PublicAccountChatPie paramPublicAccountChatPie, String paramString) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.b.c, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      Object localObject = this.b;
      PublicAccountChatPie.a((PublicAccountChatPie)localObject, PublicAccountChatPie.o((PublicAccountChatPie)localObject));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.b.d, "P_CliOper", "Pb_account_lifeservice", this.a, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
      StructLongMessageDownloadProcessor.deleteTask(this.b.d, this.a);
      ((TroopBindPublicAccountMgr)this.b.d.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.b.ah.b);
      PublicAccountChatPie.b(this.b, false);
      if (this.b.ah != null)
      {
        localObject = this.b.ah.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.appid.get());
        localStringBuilder.append("");
        if (((String)localObject).equals(localStringBuilder.toString()))
        {
          this.b.f(1);
          return;
        }
      }
      paramObject = this.b;
      paramObject.d(paramObject.f.getIntent());
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    this.b.t(2131892951);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    PublicAccountChatPie.p(this.b);
    if (PublicAccountChatPie.q(this.b) == 0) {
      this.b.bz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.28
 * JD-Core Version:    0.7.0.1
 */