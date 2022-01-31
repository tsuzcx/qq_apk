package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$ReqDetectSrategyPacket
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "u32_version", "u32_lastTime", "u32_lastUid", "envParam" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ReqDetectSrategyPacket.class);
  public MobileQQDetect.EnvParamPacket envParam = new MobileQQDetect.EnvParamPacket();
  public final PBUInt32Field u32_lastTime = PBField.initUInt32(0);
  public final PBUInt32Field u32_lastUid = PBField.initUInt32(0);
  public final PBUInt32Field u32_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.ReqDetectSrategyPacket
 * JD-Core Version:    0.7.0.1
 */