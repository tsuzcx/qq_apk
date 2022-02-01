package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$RspGetUserGroupList
  extends MessageMicro<RspGetUserGroupList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "result", "group_list", "total_unshow", "seq" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L) }, RspGetUserGroupList.class);
  public final PBRepeatMessageField<qqstory_group.UserGroupVideoItem> group_list = PBField.initRepeatMessage(qqstory_group.UserGroupVideoItem.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt32Field total_unshow = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetUserGroupList
 * JD-Core Version:    0.7.0.1
 */