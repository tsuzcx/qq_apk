package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopSuspiciousFragment$5
  implements View.OnClickListener
{
  TroopSuspiciousFragment$5(TroopSuspiciousFragment paramTroopSuspiciousFragment, structmsg.SystemMsg paramSystemMsg) {}
  
  public void onClick(View paramView)
  {
    TroopMemberCardUtils.a(TroopSuspiciousFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopSuspiciousFragment), this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopSuspiciousFragment.getActivity(), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsg.group_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsg.action_uin.get()), -1, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment.5
 * JD-Core Version:    0.7.0.1
 */