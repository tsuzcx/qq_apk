package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$DetectStrategyPacket
  extends MessageMicro<DetectStrategyPacket>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<MobileQQDetect.DetectProjectPacket> arr_projects = PBField.initRepeatMessage(MobileQQDetect.DetectProjectPacket.class);
  public final PBUInt32Field u32_frequency = PBField.initUInt32(0);
  public final PBUInt32Field u32_platform = PBField.initUInt32(0);
  public final PBUInt32Field u32_uid = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "u32_uid", "u32_frequency", "u32_platform", "arr_projects" }, new Object[] { localInteger, localInteger, localInteger, null }, DetectStrategyPacket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.DetectStrategyPacket
 * JD-Core Version:    0.7.0.1
 */