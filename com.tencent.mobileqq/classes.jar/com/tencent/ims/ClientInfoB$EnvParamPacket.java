package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ClientInfoB$EnvParamPacket
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_qqversion = PBField.initString("");
  public final PBStringField str_safeversion = PBField.initString("");
  public final PBStringField str_sysversion = PBField.initString("");
  public final PBStringField str_uin = PBField.initString("");
  public final PBUInt32Field u32_appid = PBField.initUInt32(0);
  public final PBUInt32Field u32_platform = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58 }, new String[] { "u32_platform", "str_sysversion", "u32_appid", "str_uin", "str_qqversion", "str_safeversion", "bytes_guid" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", localByteStringMicro }, EnvParamPacket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.ClientInfoB.EnvParamPacket
 * JD-Core Version:    0.7.0.1
 */