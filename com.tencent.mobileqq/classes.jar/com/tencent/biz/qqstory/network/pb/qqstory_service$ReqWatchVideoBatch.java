package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$ReqWatchVideoBatch
  extends MessageMicro<ReqWatchVideoBatch>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "video_list" }, new Object[] { null }, ReqWatchVideoBatch.class);
  public final PBRepeatMessageField<qqstory_service.VideoItem> video_list = PBField.initRepeatMessage(qqstory_service.VideoItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqWatchVideoBatch
 * JD-Core Version:    0.7.0.1
 */