package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryPublishInfo
  extends MessageMicro<StoryPublishInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_bigv = PBField.initUInt32(0);
  public final PBUInt32Field publish_time = PBField.initUInt32(0);
  public final PBUInt64Field publish_uid = PBField.initUInt64(0L);
  public final PBBytesField share_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field share_type = PBField.initUInt32(0);
  public final PBBytesField share_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_del = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 64 }, new String[] { "publish_uid", "publish_time", "is_bigv", "union_id", "video_del", "share_name", "share_union_id", "share_type" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localByteStringMicro3, localInteger }, StoryPublishInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryPublishInfo
 * JD-Core Version:    0.7.0.1
 */