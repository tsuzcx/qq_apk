package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$RspGetGroupVideoList
  extends MessageMicro<RspGetGroupVideoList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBUInt32Field next = PBField.initUInt32(0);
  public final PBRepeatMessageField<qqstory_group.GroupStoryItem> node_list = PBField.initRepeatMessage(qqstory_group.GroupStoryItem.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt32Field seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50 }, new String[] { "result", "is_end", "next", "seq", "group_id", "node_list" }, new Object[] { null, localInteger, localInteger, localInteger, Long.valueOf(0L), null }, RspGetGroupVideoList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupVideoList
 * JD-Core Version:    0.7.0.1
 */