package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$ReportDetectResultPacket
  extends MessageMicro<ReportDetectResultPacket>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_buffer", "ret" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReportDetectResultPacket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.ReportDetectResultPacket
 * JD-Core Version:    0.7.0.1
 */