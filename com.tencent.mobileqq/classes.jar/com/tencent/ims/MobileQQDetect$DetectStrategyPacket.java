package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$DetectStrategyPacket
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "u32_uid", "u32_frequency", "u32_platform", "arr_projects" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, DetectStrategyPacket.class);
  public final PBRepeatMessageField arr_projects = PBField.initRepeatMessage(MobileQQDetect.DetectProjectPacket.class);
  public final PBUInt32Field u32_frequency = PBField.initUInt32(0);
  public final PBUInt32Field u32_platform = PBField.initUInt32(0);
  public final PBUInt32Field u32_uid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.DetectStrategyPacket
 * JD-Core Version:    0.7.0.1
 */