package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQProtectUpdate$UpdateQueryResponse
  extends MessageMicro<UpdateQueryResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56 }, new String[] { "uint32_sec_cmd", "int32_status", "uint32_file_id", "uint32_file_version", "string_file_hash", "string_file_url", "uint32_zip_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, UpdateQueryResponse.class);
  public final PBInt32Field int32_status = PBField.initInt32(0);
  public final PBStringField string_file_hash = PBField.initString("");
  public final PBStringField string_file_url = PBField.initString("");
  public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_zip_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ims.QQProtectUpdate.UpdateQueryResponse
 * JD-Core Version:    0.7.0.1
 */