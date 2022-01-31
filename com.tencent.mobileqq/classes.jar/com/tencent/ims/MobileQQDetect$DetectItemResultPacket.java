package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$DetectItemResultPacket
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u32_type", "str_result" }, new Object[] { Integer.valueOf(0), "" }, DetectItemResultPacket.class);
  public final PBStringField str_result = PBField.initString("");
  public final PBUInt32Field u32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.DetectItemResultPacket
 * JD-Core Version:    0.7.0.1
 */