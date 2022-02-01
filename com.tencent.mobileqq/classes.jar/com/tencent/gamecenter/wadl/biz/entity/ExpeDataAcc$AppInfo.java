package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ExpeDataAcc$AppInfo
  extends MessageMicro<AppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "appVersion", "qua", "productId", "appid" }, new Object[] { "", "", "", "" }, AppInfo.class);
  public final PBStringField appVersion = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public final PBStringField productId = PBField.initString("");
  public final PBStringField qua = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.AppInfo
 * JD-Core Version:    0.7.0.1
 */