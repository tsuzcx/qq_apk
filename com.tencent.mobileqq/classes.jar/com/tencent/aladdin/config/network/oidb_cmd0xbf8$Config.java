package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbf8$Config
  extends MessageMicro<Config>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  public final PBUInt32Field wipe_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "id", "version", "wipe_flag", "content" }, new Object[] { localInteger, localInteger, localInteger, "" }, Config.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.Config
 * JD-Core Version:    0.7.0.1
 */