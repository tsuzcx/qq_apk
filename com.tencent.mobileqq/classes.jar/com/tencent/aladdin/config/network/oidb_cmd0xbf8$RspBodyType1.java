package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xbf8$RspBodyType1
  extends MessageMicro<RspBodyType1>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cache = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField cookie = PBField.initString("");
  public final PBStringField msg = PBField.initString("");
  public final PBRepeatMessageField<oidb_cmd0xbf8.Config> rpt_config_list = PBField.initRepeatMessage(oidb_cmd0xbf8.Config.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rpt_config_list", "msg", "cookie", "cache" }, new Object[] { null, "", "", localByteStringMicro }, RspBodyType1.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.RspBodyType1
 * JD-Core Version:    0.7.0.1
 */