package com.tencent.mobileqq.activity;

import azqs;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class ChatSettingForTroop$23$1
  implements Runnable
{
  ChatSettingForTroop$23$1(ChatSettingForTroop.23 param23, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$23.this$0.e != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$23.this$0.e.iterator();
      while (localIterator.hasNext())
      {
        oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)localIterator.next();
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localmemberlist.uint64_member_uin.get() + "")) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localmemberlist.uint64_member_uin.get() + "");
        }
      }
    }
    ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$23.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$23.this$0.a.troopUin, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$23.this$0.a.isOwnerOrAdim(), this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$23.this$0.a("Grp", "Clk_invite_new", "0");
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$23.this$0.app, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.23.1
 * JD-Core Version:    0.7.0.1
 */