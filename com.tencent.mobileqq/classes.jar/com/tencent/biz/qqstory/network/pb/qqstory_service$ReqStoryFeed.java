package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqStoryFeed
  extends MessageMicro<ReqStoryFeed>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "feed_id_list", "date" }, new Object[] { null, Integer.valueOf(0) }, ReqStoryFeed.class);
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBRepeatMessageField<qqstory_struct.FeedSeqInfo> feed_id_list = PBField.initRepeatMessage(qqstory_struct.FeedSeqInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeed
 * JD-Core Version:    0.7.0.1
 */