package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SecSharedInfo$SharedInfoPacket
  extends MessageMicro<SharedInfoPacket>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public SecSharedInfo.FileInfo file_info = new SecSharedInfo.FileInfo();
  public final PBUInt32Field qq_version = PBField.initUInt32(0);
  public final PBRepeatMessageField<SecSharedInfo.SendInfo> send_info = PBField.initRepeatMessage(SecSharedInfo.SendInfo.class);
  public final PBStringField str_brand = PBField.initString("");
  public final PBStringField str_model = PBField.initString("");
  public final PBStringField str_sysversion = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(1);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 64, 74, 82 }, new String[] { "version", "type", "bytes_guid", "uint32_appid", "str_sysversion", "str_brand", "str_model", "qq_version", "send_info", "file_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro, Integer.valueOf(0), "", "", "", Integer.valueOf(0), null, null }, SharedInfoPacket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ims.SecSharedInfo.SharedInfoPacket
 * JD-Core Version:    0.7.0.1
 */