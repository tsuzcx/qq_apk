package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$EmoticonPack
  extends MessageMicro<EmoticonPack>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField config = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField download_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field pack_id = PBField.initUInt32(0);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 66, 74 }, new String[] { "pack_id", "icon", "name", "download_url", "type", "md5", "version", "download_icon", "config" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(1), localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6 }, EmoticonPack.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.EmoticonPack
 * JD-Core Version:    0.7.0.1
 */