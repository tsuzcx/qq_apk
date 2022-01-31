package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQProtectRisks$QQProtectRisksRequest
  extends MessageMicro<QQProtectRisksRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_sec_cmd", "str_package_name", "uint32_app_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, QQProtectRisksRequest.class);
  public final PBStringField str_package_name = PBField.initString("");
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ims.QQProtectRisks.QQProtectRisksRequest
 * JD-Core Version:    0.7.0.1
 */