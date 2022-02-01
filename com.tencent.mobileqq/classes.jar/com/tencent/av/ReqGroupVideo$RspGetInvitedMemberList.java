package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReqGroupVideo$RspGetInvitedMemberList
  extends MessageMicro<RspGetInvitedMemberList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "result", "uint64_group", "uint64_room_id", "rpt_member_list" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), null }, RspGetInvitedMemberList.class);
  public common.ErrorInfo result = new common.ErrorInfo();
  public final PBRepeatMessageField<ReqGroupVideo.MemberInfo> rpt_member_list = PBField.initRepeatMessage(ReqGroupVideo.MemberInfo.class);
  public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.RspGetInvitedMemberList
 * JD-Core Version:    0.7.0.1
 */