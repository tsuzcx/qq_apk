package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WebSsoBody$WebSsoResponseBody
  extends MessageMicro<WebSsoResponseBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public WebSsoBody.WebSsoControlData controlData = new WebSsoBody.WebSsoControlData();
  public final PBStringField data = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "version", "type", "ret", "data", "controlData" }, new Object[] { localInteger, localInteger, localInteger, "", null }, WebSsoResponseBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody
 * JD-Core Version:    0.7.0.1
 */