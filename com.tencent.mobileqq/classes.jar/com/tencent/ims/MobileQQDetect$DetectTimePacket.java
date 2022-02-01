package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$DetectTimePacket
  extends MessageMicro<DetectTimePacket>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u32_baseline", "u32_delay" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, DetectTimePacket.class);
  public final PBUInt32Field u32_baseline = PBField.initUInt32(0);
  public final PBUInt32Field u32_delay = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.DetectTimePacket
 * JD-Core Version:    0.7.0.1
 */