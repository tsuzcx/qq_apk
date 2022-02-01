package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$ReqAddGroupVideo
  extends MessageMicro<ReqAddGroupVideo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "group_video_list", "ts" }, new Object[] { null, Long.valueOf(0L) }, ReqAddGroupVideo.class);
  public final PBRepeatMessageField<qqstory_group.GroupVideo> group_video_list = PBField.initRepeatMessage(qqstory_group.GroupVideo.class);
  public final PBUInt64Field ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.ReqAddGroupVideo
 * JD-Core Version:    0.7.0.1
 */