package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WebSsoBody$WebSsoRequestBody
  extends MessageMicro<WebSsoRequestBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField data = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  public final PBStringField webData = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "version", "type", "data", "webData" }, new Object[] { localInteger, localInteger, "", "" }, WebSsoRequestBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody
 * JD-Core Version:    0.7.0.1
 */