package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WebSsoBody$STServiceMonitItem
  extends MessageMicro<STServiceMonitItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "cmd", "url", "errcode", "cost", "src" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, STServiceMonitItem.class);
  public final PBStringField cmd = PBField.initString("");
  public final PBUInt32Field cost = PBField.initUInt32(0);
  public final PBInt32Field errcode = PBField.initInt32(0);
  public final PBUInt32Field src = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.WebSsoBody.STServiceMonitItem
 * JD-Core Version:    0.7.0.1
 */