package com.tencent.mobileqq.activity.contact.troop;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopSuspiciousFragment$7
  implements View.OnClickListener
{
  TroopSuspiciousFragment$7(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (SuspiciousHolder)paramView.getTag();
    if (((SuspiciousHolder)localObject).a.msg.group_msg_type.get() == 80)
    {
      localObject = TroopInfoActivity.a(String.valueOf(((SuspiciousHolder)localObject).a.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.getActivity(), (Bundle)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.d(this.a.getActivity())) {
        break;
      }
      QQToast.a(this.a.a, this.a.getActivity().getString(2131694457), 0).b(this.a.a());
    }
    ((FriendListHandler)TroopSuspiciousFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(String.valueOf(((SuspiciousHolder)localObject).a.req_uin.get()));
    TroopSuspiciousHelper.a((structmsg.StructMsg)((SuspiciousHolder)localObject).a.get());
    TroopSuspiciousFragment.a(this.a, (structmsg.StructMsg)((SuspiciousHolder)localObject).a.get(), ((SuspiciousHolder)localObject).c);
    String str1 = ((SuspiciousHolder)localObject).a.msg.group_info.msg_alert.get();
    String str2 = ((SuspiciousHolder)localObject).a.msg.group_code.get() + "";
    if ((str1 == null) || ("".equals(str1)))
    {
      TroopSuspiciousFragment.a(this.a, 1, (structmsg.StructMsg)((SuspiciousHolder)localObject).a.get());
      if ((((SuspiciousHolder)localObject).a.msg.has()) && (((SuspiciousHolder)localObject).a.msg.req_uin_nick.has())) {
        ((TroopManager)TroopSuspiciousFragment.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).a(str2, ((SuspiciousHolder)localObject).a.req_uin.get() + "", ((SuspiciousHolder)localObject).a.msg.req_uin_nick.get());
      }
      TroopSuspiciousHelper.a(((SuspiciousHolder)localObject).a, "unnormal_join");
    }
    for (;;)
    {
      TroopSuspiciousFragment.c(this.a);
      TroopSuspiciousFragment.a(this.a).c(2131719050);
      TroopSuspiciousFragment.a(this.a).show();
      break;
      TroopSuspiciousFragment.a(this.a, 0, (structmsg.StructMsg)((SuspiciousHolder)localObject).a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment.7
 * JD-Core Version:    0.7.0.1
 */