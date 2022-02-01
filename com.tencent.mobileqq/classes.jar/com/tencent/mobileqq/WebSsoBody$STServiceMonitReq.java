package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WebSsoBody$STServiceMonitReq
  extends MessageMicro<STServiceMonitReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "list" }, new Object[] { null }, STServiceMonitReq.class);
  public final PBRepeatMessageField<WebSsoBody.STServiceMonitItem> list = PBField.initRepeatMessage(WebSsoBody.STServiceMonitItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.WebSsoBody.STServiceMonitReq
 * JD-Core Version:    0.7.0.1
 */