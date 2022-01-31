package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQProtectCommon$QQProtectQueryHead
  extends MessageMicro<QQProtectQueryHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field app_id = PBField.initUInt32(0);
  public final PBStringField brand_info = PBField.initString("");
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_imei = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField cpu_arch = PBField.initString("");
  public final PBStringField manufacturer = PBField.initString("");
  public final PBUInt32Field os_version = PBField.initUInt32(0);
  public final PBStringField package_name = PBField.initString("");
  public final PBUInt32Field qq_version = PBField.initUInt32(0);
  public final PBStringField rom_info = PBField.initString("");
  public final PBUInt32Field root = PBField.initUInt32(0);
  public final PBStringField string_uin = PBField.initString("");
  public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 66, 72, 82, 90, 98, 104 }, new String[] { "uint32_sec_cmd", "bytes_imei", "bytes_guid", "string_uin", "os_version", "qq_version", "cpu_arch", "rom_info", "root", "brand_info", "manufacturer", "package_name", "app_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, QQProtectQueryHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ims.QQProtectCommon.QQProtectQueryHead
 * JD-Core Version:    0.7.0.1
 */