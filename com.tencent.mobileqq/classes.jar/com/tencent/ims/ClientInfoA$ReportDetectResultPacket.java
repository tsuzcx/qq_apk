package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ClientInfoA$ReportDetectResultPacket
  extends MessageMicro<ReportDetectResultPacket>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_buffer2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public ClientInfoA.EnvParamPacket envParam = new ClientInfoA.EnvParamPacket();
  public final PBStringField str_qqmd5 = PBField.initString("");
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_cmd", "envParam", "bytes_buffer", "bytes_buffer2", "str_qqmd5" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, "" }, ReportDetectResultPacket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.ClientInfoA.ReportDetectResultPacket
 * JD-Core Version:    0.7.0.1
 */