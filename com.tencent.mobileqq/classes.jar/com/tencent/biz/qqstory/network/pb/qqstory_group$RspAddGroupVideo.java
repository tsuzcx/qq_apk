package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_group$RspAddGroupVideo
  extends MessageMicro<RspAddGroupVideo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "group_feed_list" }, new Object[] { null, null }, RspAddGroupVideo.class);
  public final PBRepeatMessageField<qqstory_group.GroupFeed> group_feed_list = PBField.initRepeatMessage(qqstory_group.GroupFeed.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspAddGroupVideo
 * JD-Core Version:    0.7.0.1
 */