package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xbf8$ReqBodyType1
  extends MessageMicro<ReqBodyType1>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "device_info", "app_version", "rpt_config_list", "app_id" }, new Object[] { null, "", null, "" }, ReqBodyType1.class);
  public final PBStringField app_id = PBField.initString("");
  public final PBStringField app_version = PBField.initString("");
  public oidb_cmd0xbf8.DeviceInfo device_info = new oidb_cmd0xbf8.DeviceInfo();
  public final PBRepeatMessageField<oidb_cmd0xbf8.ConfigSeq> rpt_config_list = PBField.initRepeatMessage(oidb_cmd0xbf8.ConfigSeq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.ReqBodyType1
 * JD-Core Version:    0.7.0.1
 */