package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbf8$CPU
  extends MessageMicro<CPU>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "model", "cores", "frequency" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, CPU.class);
  public final PBUInt32Field cores = PBField.initUInt32(0);
  public final PBUInt32Field frequency = PBField.initUInt32(0);
  public final PBStringField model = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.CPU
 * JD-Core Version:    0.7.0.1
 */