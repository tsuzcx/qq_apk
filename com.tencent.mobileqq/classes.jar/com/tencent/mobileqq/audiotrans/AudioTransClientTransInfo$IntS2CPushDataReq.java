package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AudioTransClientTransInfo$IntS2CPushDataReq
  extends MessageMicro<IntS2CPushDataReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_key = PBField.initString("");
  public final PBBytesField translate_result = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "translate_result", "str_key" }, new Object[] { localByteStringMicro, "" }, IntS2CPushDataReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntS2CPushDataReq
 * JD-Core Version:    0.7.0.1
 */