package com.tencent.mobileqq.activity.contact.troop;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopSuspiciousFragment$6
  implements View.OnClickListener
{
  TroopSuspiciousFragment$6(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject2;
    if ((paramView.getTag() instanceof SuspiciousHolder))
    {
      localObject2 = (SuspiciousHolder)paramView.getTag();
      if (localObject2 != null) {
        break label32;
      }
    }
    label32:
    Object localObject3;
    int i;
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject3 = ((SuspiciousHolder)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      i = ((SuspiciousHolder)localObject2).jdField_a_of_type_Int;
      if (TroopNotificationUtils.a(i) == 0)
      {
        localObject1 = TroopInfoActivity.a(String.valueOf(((SuspiciousHolder)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
        ((Bundle)localObject1).putInt("t_s_f", 1001);
        TroopUtils.a(this.a.getActivity(), (Bundle)localObject1, 2);
        if ((i == 2) || (i == 10) || (i == 12))
        {
          i = 1;
          label117:
          localObject3 = TroopSuspiciousFragment.a(this.a);
          localObject2 = ((SuspiciousHolder)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
          if (i == 0) {
            break label201;
          }
        }
        label201:
        for (localObject1 = "0";; localObject1 = "1")
        {
          ReportController.b((AppRuntime)localObject3, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject2, (String)localObject1, "", "");
          break;
          i = 0;
          break label117;
        }
      }
      if ((((SuspiciousHolder)localObject2).jdField_a_of_type_Int != 2) || (!TroopInfo.isQidianPrivateTroop(((SuspiciousHolder)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())))
      {
        if (((SuspiciousHolder)localObject2).jdField_a_of_type_Int != 82) {
          break;
        }
        localObject1 = new ActivityURIRequest(this.a.a, "/pubaccount/detail");
        ((ActivityURIRequest)localObject1).extra().putString("uin", ((SuspiciousHolder)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
        ((ActivityURIRequest)localObject1).extra().putInt("source", 112);
        QRoute.startUri((URIRequest)localObject1, null);
      }
    }
    long l = ((structmsg.StructMsg)localObject3).req_uin.get();
    switch (TroopNotificationUtils.a(i))
    {
    default: 
      localObject1 = String.valueOf(l);
      label370:
      if (((FriendsManager)TroopSuspiciousFragment.a(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject1)) {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
      }
      break;
    }
    for (;;)
    {
      l = ((structmsg.StructMsg)localObject3).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l);
      i = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + i + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
      }
      if ((bool) && (i == 2)) {
        break;
      }
      ProfileActivity.b(this.a.getActivity(), (ProfileActivity.AllInOne)localObject1);
      ReportController.b(TroopSuspiciousFragment.a(this.a), "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((SuspiciousHolder)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", "3", "", "");
      break;
      localObject1 = ((SuspiciousHolder)localObject2).jdField_a_of_type_JavaLangString;
      break label370;
      localObject1 = String.valueOf(((SuspiciousHolder)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label370;
      if ((((structmsg.StructMsg)localObject3).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject3).msg.sub_type.get() == 3))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 26);
        ((ProfileActivity.AllInOne)localObject1).d = 1;
      }
      else
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 24);
        TroopUtils.a((structmsg.StructMsg)localObject3, (ProfileActivity.AllInOne)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment.6
 * JD-Core Version:    0.7.0.1
 */