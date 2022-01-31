package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$HotTopicPack
  extends MessageMicro<HotTopicPack>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_join = PBField.initUInt32(0);
  public final PBUInt32Field topic_color = PBField.initUInt32(0);
  public final PBBytesField topic_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField topic_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field topic_id = PBField.initUInt64(0L);
  public final PBBytesField topic_logo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56 }, new String[] { "topic_id", "topic_name", "topic_cover", "topic_color", "topic_logo", "topic_desc", "is_join" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, HotTopicPack.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.HotTopicPack
 * JD-Core Version:    0.7.0.1
 */