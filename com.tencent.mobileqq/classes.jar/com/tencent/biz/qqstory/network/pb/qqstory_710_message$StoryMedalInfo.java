package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryMedalInfo
  extends MessageMicro<StoryMedalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_bigv = PBField.initUInt32(0);
  public final PBUInt64Field official_uin = PBField.initUInt64(0L);
  public final PBUInt32Field push_time = PBField.initUInt32(0);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50 }, new String[] { "official_uin", "is_bigv", "union_id", "push_time", "content", "cover_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, StoryMedalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMedalInfo
 * JD-Core Version:    0.7.0.1
 */