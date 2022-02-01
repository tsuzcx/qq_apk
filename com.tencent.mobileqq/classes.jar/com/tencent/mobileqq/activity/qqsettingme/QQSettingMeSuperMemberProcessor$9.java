package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.QZoneVipInfoManager;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

class QQSettingMeSuperMemberProcessor$9
  implements Runnable
{
  QQSettingMeSuperMemberProcessor$9(QQSettingMeSuperMemberProcessor paramQQSettingMeSuperMemberProcessor) {}
  
  public void run()
  {
    boolean bool = QQSettingMeSuperMemberProcessor.b(this.this$0);
    String str1 = this.this$0.c.getCurrentAccountUin();
    String str2 = ((TicketManager)this.this$0.c.getManager(2)).getSkey(str1);
    long l1 = QVipConfigManager.a(this.this$0.c, "setting_me_get_vip_info_sequence", 1562146740L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateVipInfo request:");
      localStringBuilder.append(l1);
      QLog.d("QVipSettingMe.", 2, localStringBuilder.toString());
    }
    long l2 = QVipConfigManager.a(this.this$0.c, "key_long_setting_me_vip_medal_list_record", 0L);
    int i = QZoneVipInfoManager.a().b();
    int j = 0;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((l2 & 1L) == 1L) {
      j = 1;
    }
    if (j != i)
    {
      QLog.e("QVipSettingMe.", 1, "updateVipInfo request immediate");
      l1 = 1562146741L;
      bool = true;
    }
    if (!bool) {
      return;
    }
    ((VipInfoHandler)((QQAppInterface)this.this$0.c).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(str2, str1, l1, "vip_drawer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor.9
 * JD-Core Version:    0.7.0.1
 */