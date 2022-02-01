package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class PublicAccountChatPie$44
  extends NewPublicAccountObserver.ResponseResultListener
{
  boolean a;
  
  PublicAccountChatPie$44(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.b.c, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.b.d, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.b.ah.b, "", "", "", false);
      paramObject = (IPublicAccountDataManager)this.b.d.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (paramObject != null)
      {
        paramObject = paramObject.findAccountDetailInfo(this.b.ah.b);
        if (paramObject != null)
        {
          if (this.b.bo == null)
          {
            PublicAccountChatPie localPublicAccountChatPie = this.b;
            localPublicAccountChatPie.bo = ((IPublicAccountHandler)localPublicAccountChatPie.d.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
          }
          this.b.bo.onFollowPublicAccount(paramObject);
        }
        else
        {
          this.b.bH();
          this.a = false;
        }
      }
      else
      {
        this.b.bH();
        this.a = false;
      }
      paramObject = this.b;
      paramObject.bn = true;
      paramObject.bB = true;
      paramObject.bA();
      if (this.b.cB)
      {
        paramObject = (PlusPanel)PublicAccountChatPie.z(this.b).d(8);
        if (paramObject != null) {
          paramObject.a();
        }
      }
      paramObject = this.b;
      paramObject.d(paramObject.f.getIntent());
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    this.a = true;
  }
  
  public void b(Object paramObject)
  {
    this.b.t(2131892951);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (this.a) {
      this.b.bz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.44
 * JD-Core Version:    0.7.0.1
 */