package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_group$ReqWatchGroupVideoBatch
  extends MessageMicro<ReqWatchGroupVideoBatch>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "video_list" }, new Object[] { null }, ReqWatchGroupVideoBatch.class);
  public final PBRepeatMessageField<qqstory_group.WatchGroupVideo> video_list = PBField.initRepeatMessage(qqstory_group.WatchGroupVideo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.ReqWatchGroupVideoBatch
 * JD-Core Version:    0.7.0.1
 */