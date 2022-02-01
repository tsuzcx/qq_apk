package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_group$HotVideoCard
  extends MessageMicro<HotVideoCard>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "video_item_list" }, new Object[] { null }, HotVideoCard.class);
  public final PBRepeatMessageField<qqstory_group.HotVideoItem> video_item_list = PBField.initRepeatMessage(qqstory_group.HotVideoItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.HotVideoCard
 * JD-Core Version:    0.7.0.1
 */