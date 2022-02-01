package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_group$RspGetGroupList
  extends MessageMicro<RspGetGroupList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "result", "group_list", "mask_group_list" }, new Object[] { null, null, null }, RspGetGroupList.class);
  public final PBRepeatMessageField<qqstory_group.GroupInfo> group_list = PBField.initRepeatMessage(qqstory_group.GroupInfo.class);
  public final PBRepeatMessageField<qqstory_group.GroupInfo> mask_group_list = PBField.initRepeatMessage(qqstory_group.GroupInfo.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupList
 * JD-Core Version:    0.7.0.1
 */