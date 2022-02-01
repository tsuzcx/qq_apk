package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspWatchVideoBatch
  extends MessageMicro<RspWatchVideoBatch>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "succ_video_list" }, new Object[] { null, null }, RspWatchVideoBatch.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_service.VideoItem> succ_video_list = PBField.initRepeatMessage(qqstory_service.VideoItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideoBatch
 * JD-Core Version:    0.7.0.1
 */