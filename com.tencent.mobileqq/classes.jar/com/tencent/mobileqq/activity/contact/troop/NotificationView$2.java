package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class NotificationView$2
  implements View.OnClickListener
{
  NotificationView$2(NotificationView paramNotificationView) {}
  
  public void onClick(View paramView)
  {
    NotificationAdapter.ViewHolder localViewHolder = (NotificationAdapter.ViewHolder)paramView.getTag();
    if (localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 2)
    {
      this.a.a(localViewHolder);
      if (localViewHolder.jdField_a_of_type_Int == 82) {
        ReportController.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "Clk_notice", 0, 0, "", "", "", localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotificationView.2
 * JD-Core Version:    0.7.0.1
 */