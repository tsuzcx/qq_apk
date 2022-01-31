package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$RspPublishVideo
  extends MessageMicro<RspPublishVideo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_group.GroupFeed> group_feed_list = PBField.initRepeatMessage(qqstory_group.GroupFeed.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field video_index = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 56, 66 }, new String[] { "result", "create_time", "feed_id", "date", "story_id", "group_feed_list", "video_index", "vid" }, new Object[] { null, Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, null, Long.valueOf(0L), localByteStringMicro3 }, RspPublishVideo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspPublishVideo
 * JD-Core Version:    0.7.0.1
 */