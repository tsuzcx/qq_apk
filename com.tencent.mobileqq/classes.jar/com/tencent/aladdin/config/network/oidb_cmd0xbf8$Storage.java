package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbf8$Storage
  extends MessageMicro<Storage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field builtin = PBField.initUInt64(0L);
  public final PBUInt64Field external = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "builtin", "external" }, new Object[] { localLong, localLong }, Storage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.Storage
 * JD-Core Version:    0.7.0.1
 */