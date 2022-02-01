package com.tencent.mobileqq.activity;

import aokv;
import biik;
import bmup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

class QQSettingMe$24
  implements Runnable
{
  QQSettingMe$24(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    boolean bool = QQSettingMe.e(this.this$0);
    String str1 = this.this$0.a.getCurrentAccountUin();
    String str2 = ((TicketManager)this.this$0.a.getManager(2)).getSkey(str1);
    long l1 = biik.a(this.this$0.a, "setting_me_get_vip_info_sequence", 1562146740L);
    if (QLog.isColorLevel()) {
      QLog.d("QVipSettingMe.", 2, "updateVipInfo request:" + l1);
    }
    long l2 = biik.a(this.this$0.a, "key_long_setting_me_vip_medal_list_record", 0L);
    int i;
    int j;
    if (bmup.a().a() > 0)
    {
      i = 1;
      if ((l2 & 1L) != 1L) {
        break label159;
      }
      j = 1;
      label129:
      if (j == i) {
        break label191;
      }
      QLog.e("QVipSettingMe.", 1, "updateVipInfo request immediate");
      l1 = 1562146741L;
      bool = true;
    }
    label159:
    label191:
    for (;;)
    {
      if (!bool)
      {
        return;
        i = 0;
        break;
        j = 0;
        break label129;
      }
      ((aokv)this.this$0.a.a(27)).a(str2, str1, l1, "vip_drawer");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.24
 * JD-Core Version:    0.7.0.1
 */