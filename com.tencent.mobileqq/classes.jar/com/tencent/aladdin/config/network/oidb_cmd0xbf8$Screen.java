package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbf8$Screen
  extends MessageMicro<Screen>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field dpi = PBField.initUInt32(0);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "width", "height", "dpi" }, new Object[] { localInteger, localInteger, localInteger }, Screen.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.Screen
 * JD-Core Version:    0.7.0.1
 */