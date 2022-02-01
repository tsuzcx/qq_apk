package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_group$RspGetGroupMemberCardInfo
  extends MessageMicro<RspGetGroupMemberCardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "info_list" }, new Object[] { null, null }, RspGetGroupMemberCardInfo.class);
  public final PBRepeatMessageField<qqstory_group.MemberCardInfo> info_list = PBField.initRepeatMessage(qqstory_group.MemberCardInfo.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupMemberCardInfo
 * JD-Core Version:    0.7.0.1
 */