package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RspGroupVideoInviteMember$MemberInfo
  extends MessageMicro<MemberInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_member_uin", "uint32_invite_timestamp" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, MemberInfo.class);
  public final PBUInt32Field uint32_invite_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.RspGroupVideoInviteMember.MemberInfo
 * JD-Core Version:    0.7.0.1
 */