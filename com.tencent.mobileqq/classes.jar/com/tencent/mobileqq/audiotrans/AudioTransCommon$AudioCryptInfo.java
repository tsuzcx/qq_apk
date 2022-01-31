package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransCommon$AudioCryptInfo
  extends MessageMicro<AudioCryptInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_key_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_crypt_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_key_len = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "enum_crypt_type", "uint32_key_len", "bytes_key_buf" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro }, AudioCryptInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransCommon.AudioCryptInfo
 * JD-Core Version:    0.7.0.1
 */