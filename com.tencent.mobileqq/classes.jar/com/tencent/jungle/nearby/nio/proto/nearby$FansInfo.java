package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby$FansInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_fans_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_follows_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_fans_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_follows_num = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_fans_num", "bytes_fans_url", "uint32_follows_num", "bytes_follows_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, FansInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.jungle.nearby.nio.proto.nearby.FansInfo
 * JD-Core Version:    0.7.0.1
 */