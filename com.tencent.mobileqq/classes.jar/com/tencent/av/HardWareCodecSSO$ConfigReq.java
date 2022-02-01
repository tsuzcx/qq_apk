package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class HardWareCodecSSO$ConfigReq
  extends MessageMicro<ConfigReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "app_id", "app_ver", "chip", "mobile", "os_version" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, ConfigReq.class);
  public final PBUInt32Field app_id = PBField.initUInt32(0);
  public final PBStringField app_ver = PBField.initString("");
  public final PBStringField chip = PBField.initString("");
  public final PBStringField mobile = PBField.initString("");
  public final PBUInt32Field os_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.HardWareCodecSSO.ConfigReq
 * JD-Core Version:    0.7.0.1
 */