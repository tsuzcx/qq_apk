package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$DateVideoCollection
  extends MessageMicro<DateVideoCollection>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField address = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field collection_id = PBField.initUInt32(0);
  public final PBUInt64Field collection_time = PBField.initUInt64(0L);
  public final PBUInt32Field collection_type = PBField.initUInt32(0);
  public final PBUInt32Field collection_video_count = PBField.initUInt32(0);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field share_to_discover = PBField.initUInt32(0);
  public final PBUInt32Field total_view_count = PBField.initUInt32(0);
  public final PBUInt32Field total_view_times = PBField.initUInt32(0);
  public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<qqstory_struct.StoryVideoSimpleInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoSimpleInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 72, 80, 90, 96 }, new String[] { "collection_id", "collection_type", "collection_time", "collection_video_count", "video_list", "vid_list", "label", "address", "total_view_count", "total_view_times", "feed_id", "share_to_discover" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, DateVideoCollection.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.DateVideoCollection
 * JD-Core Version:    0.7.0.1
 */