package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.PayRuleCfg;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSuperMemberPayButtonBean;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

class DrawerBizFacade$1$3
  implements Runnable
{
  DrawerBizFacade$1$3(DrawerBizFacade.1 param1, Object paramObject, QQSettingMeSuperMemberProcessor paramQQSettingMeSuperMemberProcessor) {}
  
  public void run()
  {
    int i = ((Bundle)this.a).getInt("type");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VipInfoHandler paySuccess ");
    ((StringBuilder)localObject).append(i);
    QLog.e("QQSettingRedesign", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if ((localObject != null) && (((QQSettingMeSuperMemberProcessor)localObject).l().d != null) && (this.b.l().d.payHide == 1))
    {
      this.b.l().d.enable = 0;
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler paySuccess clear bubble");
      VipInfoHandler.a(this.c.a.a.getCurrentUin(), this.b.l().d);
      ThreadManagerV2.getUIHandlerV2().post(new DrawerBizFacade.1.3.1(this));
    }
    QVipConfigManager.b(this.c.a.a, "last_pull_pay_rule", 0L);
    localObject = ((TicketManager)this.c.a.a.getManager(2)).getSkey(this.c.a.a.getCurrentAccountUin());
    ((VipInfoHandler)((QQAppInterface)this.c.a.a).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a((String)localObject, this.c.a.a.getCurrentUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.1.3
 * JD-Core Version:    0.7.0.1
 */