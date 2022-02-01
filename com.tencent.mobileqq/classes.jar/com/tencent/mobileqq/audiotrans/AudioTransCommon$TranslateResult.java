package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransCommon$TranslateResult
  extends MessageMicro<TranslateResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_src_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tar_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_end_seq = PBField.initInt32(0);
  public final PBInt32Field int32_start_seq = PBField.initInt32(0);
  public final PBInt32Field int32_status = PBField.initInt32(0);
  public final PBInt32Field int32_type = PBField.initInt32(0);
  public final PBUInt32Field uint32_rel_ts = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56 }, new String[] { "int32_end_seq", "int32_start_seq", "bytes_src_text", "bytes_tar_text", "int32_status", "int32_type", "uint32_rel_ts" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localInteger }, TranslateResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransCommon.TranslateResult
 * JD-Core Version:    0.7.0.1
 */