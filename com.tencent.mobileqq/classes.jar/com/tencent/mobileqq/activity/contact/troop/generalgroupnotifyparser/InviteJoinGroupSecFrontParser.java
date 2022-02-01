package com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser;

import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.general_group_notify.general_group_notify.GroupNotify;
import tencent.im.oidb.general_group_notify.general_group_notify.InviteJoinGroupSecFront;

public class InviteJoinGroupSecFrontParser
  extends GeneralGroupNotifyParser
{
  protected InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo a(general_group_notify.GroupNotify paramGroupNotify)
  {
    InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo localInviteJoinGroupSecFrontInfo = new InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo();
    int i = paramGroupNotify.opt_uint32_msg_type.get();
    localInviteJoinGroupSecFrontInfo.b = i;
    if ((i == 2) && (paramGroupNotify.opt_st_sec_front_info.has()))
    {
      paramGroupNotify = (general_group_notify.InviteJoinGroupSecFront)paramGroupNotify.opt_st_sec_front_info.get();
      if (paramGroupNotify != null) {
        localInviteJoinGroupSecFrontInfo.a = paramGroupNotify.opt_uint32_index.get();
      }
    }
    return localInviteJoinGroupSecFrontInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.InviteJoinGroupSecFrontParser
 * JD-Core Version:    0.7.0.1
 */