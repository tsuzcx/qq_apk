package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect$DetectItemPacket
  extends MessageMicro<DetectItemPacket>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_targetJson = PBField.initString("");
  public final PBUInt32Field u32_platform = PBField.initUInt32(0);
  public final PBUInt32Field u32_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "u32_type", "u32_platform", "str_targetJson" }, new Object[] { localInteger, localInteger, "" }, DetectItemPacket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.DetectItemPacket
 * JD-Core Version:    0.7.0.1
 */