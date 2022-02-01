package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$DetectConditionPacket
  extends MessageMicro<DetectConditionPacket>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field u32_androidVersion = PBField.initUInt32(0);
  public final PBUInt32Field u32_iOSVersion = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u32_iOSVersion", "u32_androidVersion" }, new Object[] { localInteger, localInteger }, DetectConditionPacket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.DetectConditionPacket
 * JD-Core Version:    0.7.0.1
 */