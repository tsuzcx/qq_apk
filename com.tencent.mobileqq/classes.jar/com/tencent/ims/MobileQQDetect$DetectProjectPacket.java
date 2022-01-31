package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$DetectProjectPacket
  extends MessageMicro<DetectProjectPacket>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "u32_id", "u32_ttl", "u32_business", "condition", "time", "arr_items" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null }, DetectProjectPacket.class);
  public final PBRepeatMessageField<MobileQQDetect.DetectItemPacket> arr_items = PBField.initRepeatMessage(MobileQQDetect.DetectItemPacket.class);
  public MobileQQDetect.DetectConditionPacket condition = new MobileQQDetect.DetectConditionPacket();
  public MobileQQDetect.DetectTimePacket time = new MobileQQDetect.DetectTimePacket();
  public final PBUInt32Field u32_business = PBField.initUInt32(0);
  public final PBUInt32Field u32_id = PBField.initUInt32(0);
  public final PBUInt32Field u32_ttl = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.DetectProjectPacket
 * JD-Core Version:    0.7.0.1
 */