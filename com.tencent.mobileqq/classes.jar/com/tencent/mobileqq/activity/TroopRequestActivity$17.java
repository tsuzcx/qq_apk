package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopRequestActivity$17
  implements View.OnClickListener
{
  TroopRequestActivity$17(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.c > 0L) && (l - TroopRequestActivity.c < 800L))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    TroopRequestActivity.c = l;
    Bundle localBundle = TroopInfoActivity.a(this.a.jdField_a_of_type_JavaLangString, 4);
    localBundle.putInt("t_s_f", 1001);
    int i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    label97:
    QQAppInterface localQQAppInterface;
    String str2;
    if ((i == 2) || (i == 10) || (i == 12))
    {
      i = 1;
      localQQAppInterface = this.a.app;
      str2 = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
      if (i == 0) {
        break label193;
      }
    }
    label193:
    for (String str1 = "0";; str1 = "1")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str2, str1, "", "");
      TroopUtils.a(this.a, localBundle, 2);
      break;
      i = 0;
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.17
 * JD-Core Version:    0.7.0.1
 */