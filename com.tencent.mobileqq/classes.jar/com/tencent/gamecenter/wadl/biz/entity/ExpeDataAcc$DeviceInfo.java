package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ExpeDataAcc$DeviceInfo
  extends MessageMicro<DeviceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "platform", "brand", "model", "version", "deviceInfo", "mac", "idfa", "idfv", "imei" }, new Object[] { "", "", "", "", "", "", "", "", "" }, DeviceInfo.class);
  public final PBStringField brand = PBField.initString("");
  public final PBStringField deviceInfo = PBField.initString("");
  public final PBStringField idfa = PBField.initString("");
  public final PBStringField idfv = PBField.initString("");
  public final PBStringField imei = PBField.initString("");
  public final PBStringField mac = PBField.initString("");
  public final PBStringField model = PBField.initString("");
  public final PBStringField platform = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */