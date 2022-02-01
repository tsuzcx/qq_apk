package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryVideoInfo
  extends MessageMicro<StoryVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field author_uid = PBField.initUInt64(0L);
  public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_bigv = PBField.initUInt32(0);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_time = PBField.initUInt32(0);
  public final PBBytesField vote_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58 }, new String[] { "vid", "cover_url", "author_uid", "video_time", "is_bigv", "union_id", "vote_attr" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, StoryVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryVideoInfo
 * JD-Core Version:    0.7.0.1
 */