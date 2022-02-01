package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$RspGetUserVideoList
  extends MessageMicro<RspGetUserVideoList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public qqstory_struct.LiveVideoDes live_video_des = new qqstory_struct.LiveVideoDes();
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt64Field story_video_list_total_time = PBField.initUInt64(0L);
  public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
  public final PBUInt32Field video_list_total_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58, 64 }, new String[] { "result", "video_list", "is_end", "next_cookie", "story_video_list_total_time", "video_list_total_count", "live_video_des", "seq" }, new Object[] { null, null, localInteger, localByteStringMicro, Long.valueOf(0L), localInteger, null, localInteger }, RspGetUserVideoList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserVideoList
 * JD-Core Version:    0.7.0.1
 */