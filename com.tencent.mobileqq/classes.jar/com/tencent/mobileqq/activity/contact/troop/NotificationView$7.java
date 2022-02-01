package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class NotificationView$7
  implements View.OnClickListener
{
  NotificationView$7(NotificationView paramNotificationView) {}
  
  public void onClick(View paramView)
  {
    NotificationAdapter.ViewHolder localViewHolder = (NotificationAdapter.ViewHolder)paramView.getTag();
    Object localObject;
    if (localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
    {
      localObject = TroopInfoActivity.a(String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), (Bundle)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.d(this.a.a())) {
        break;
      }
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131694457), 0).b(this.a.a());
    }
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    NotificationView.a(this.a, (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), localViewHolder.c);
    String str2 = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str3 = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    label249:
    int i;
    label276:
    String str1;
    if (localViewHolder.b < this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int)
    {
      localObject = "1";
      i = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label433;
      }
      i = 0;
      if (i == 0) {
        break label438;
      }
      str1 = "0";
      label284:
      if ((str2 != null) && (!"".equals(str2))) {
        break label771;
      }
      if (localViewHolder.jdField_a_of_type_Int != 82) {
        break label445;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "focus_notice", 0, 0, "", "", "", localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      NotificationView.a(this.a, localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
    }
    label771:
    for (;;)
    {
      NotificationView.c(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131719050);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      break;
      localObject = "0";
      break label249;
      label433:
      i = 1;
      break label276;
      label438:
      str1 = "1";
      break label284;
      label445:
      if (localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NotificationView", 2, "doCheckPayTroopReq start: " + str3);
        }
        TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback);
        TroopReportor.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "1" });
      }
      else
      {
        NotificationView.a(this.a, 1, (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
        if ((localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has())) {
          ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(str3, localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
        }
        if (localViewHolder.jdField_a_of_type_Int == 1)
        {
          TroopReportor.a("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str3, localObject, str1, "1" });
        }
        else if (localViewHolder.jdField_a_of_type_Int == 2)
        {
          TroopReportor.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "1" });
          continue;
          NotificationView.a(this.a, 0, (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
          if (localViewHolder.jdField_a_of_type_Int == 1) {
            TroopReportor.a("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str3, localObject, str1, "1" });
          } else if (localViewHolder.jdField_a_of_type_Int == 2) {
            TroopReportor.a("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str3, localObject, str1, "1" });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotificationView.7
 * JD-Core Version:    0.7.0.1
 */