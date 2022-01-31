package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$EnvParamPacket
  extends MessageMicro<EnvParamPacket>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_androidid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_imei = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_imsi = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_cpuarch = PBField.initString("");
  public final PBStringField str_rominfo = PBField.initString("");
  public final PBStringField str_sysversion = PBField.initString("");
  public final PBStringField str_wifimac = PBField.initString("");
  public final PBUInt32Field u32_appid = PBField.initUInt32(0);
  public final PBUInt32Field u32_network = PBField.initUInt32(0);
  public final PBUInt32Field u32_platform = PBField.initUInt32(0);
  public final PBUInt32Field u32_root = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 56, 64, 74, 82, 90, 98 }, new String[] { "u32_platform", "str_sysversion", "u32_appid", "bytes_guid", "bytes_imei", "bytes_androidid", "u32_network", "u32_root", "bytes_imsi", "str_wifimac", "str_cpuarch", "str_rominfo" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, "", "", "" }, EnvParamPacket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.EnvParamPacket
 * JD-Core Version:    0.7.0.1
 */