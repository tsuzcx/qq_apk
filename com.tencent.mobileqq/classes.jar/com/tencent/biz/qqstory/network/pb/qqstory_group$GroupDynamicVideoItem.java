package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$GroupDynamicVideoItem
  extends MessageMicro<GroupDynamicVideoItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "group_id", "total", "story_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, GroupDynamicVideoItem.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<qqstory_group.GroupVideoItem> story_list = PBField.initRepeatMessage(qqstory_group.GroupVideoItem.class);
  public final PBUInt32Field total = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.GroupDynamicVideoItem
 * JD-Core Version:    0.7.0.1
 */