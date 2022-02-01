package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Crm$LightTalkMsg
  extends MessageMicro<LightTalkMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cuin = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_client_headurl = PBField.initString("");
  public final PBStringField str_client_nickname = PBField.initString("");
  public final PBStringField str_mobile_number = PBField.initString("");
  public final PBUInt32Field uint32_call_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_model_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_duration = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end_timestap = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_start_timestap = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_virtual_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 56, 64, 72, 82, 90, 96 }, new String[] { "bytes_cuin", "uint64_virtual_uin", "str_mobile_number", "uint32_model_type", "uint32_call_type", "uint32_call_result", "uint64_start_timestap", "uint64_end_timestap", "uint64_duration", "str_client_headurl", "str_client_nickname", "uint32_mobile_source" }, new Object[] { localByteStringMicro, localLong, "", localInteger, localInteger, localInteger, localLong, localLong, localLong, "", "", localInteger }, LightTalkMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.Crm.LightTalkMsg
 * JD-Core Version:    0.7.0.1
 */