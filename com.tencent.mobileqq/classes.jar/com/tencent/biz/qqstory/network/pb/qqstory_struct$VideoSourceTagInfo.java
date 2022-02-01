package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$VideoSourceTagInfo
  extends MessageMicro<VideoSourceTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field source_tag_type = PBField.initUInt32(0);
  public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "source_tag_type", "jump_url", "wording" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, VideoSourceTagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSourceTagInfo
 * JD-Core Version:    0.7.0.1
 */