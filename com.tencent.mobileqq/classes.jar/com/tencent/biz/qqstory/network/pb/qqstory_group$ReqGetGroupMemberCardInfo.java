package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$ReqGetGroupMemberCardInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "uin_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqGetGroupMemberCardInfo.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBRepeatField uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupMemberCardInfo
 * JD-Core Version:    0.7.0.1
 */