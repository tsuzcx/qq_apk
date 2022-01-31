package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$DetectProjectResultPacket
  extends MessageMicro<DetectProjectResultPacket>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58 }, new String[] { "envParam", "u32_version", "u32_id", "u32_business", "result", "str_trunk", "str_extra" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, "", "" }, DetectProjectResultPacket.class);
  public MobileQQDetect.EnvParamPacket envParam = new MobileQQDetect.EnvParamPacket();
  public final PBRepeatMessageField<MobileQQDetect.DetectItemResultPacket> result = PBField.initRepeatMessage(MobileQQDetect.DetectItemResultPacket.class);
  public final PBStringField str_extra = PBField.initString("");
  public final PBStringField str_trunk = PBField.initString("");
  public final PBUInt32Field u32_business = PBField.initUInt32(0);
  public final PBUInt32Field u32_id = PBField.initUInt32(0);
  public final PBUInt32Field u32_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.DetectProjectResultPacket
 * JD-Core Version:    0.7.0.1
 */