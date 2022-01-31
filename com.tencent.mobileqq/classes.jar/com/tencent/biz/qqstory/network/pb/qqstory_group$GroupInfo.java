package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$GroupInfo
  extends MessageMicro<GroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GroupInfo.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.GroupInfo
 * JD-Core Version:    0.7.0.1
 */