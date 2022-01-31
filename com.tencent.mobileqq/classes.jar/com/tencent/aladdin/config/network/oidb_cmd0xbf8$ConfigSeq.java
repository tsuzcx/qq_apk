package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbf8$ConfigSeq
  extends MessageMicro<ConfigSeq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "id", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ConfigSeq.class);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.ConfigSeq
 * JD-Core Version:    0.7.0.1
 */