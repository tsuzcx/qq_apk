package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WebSsoBody$WebSsoRequestBody
  extends MessageMicro
{
  public static final int DATA_FIELD_NUMBER = 3;
  public static final int TYPE_FIELD_NUMBER = 2;
  public static final int VERSION_FIELD_NUMBER = 1;
  public static final int WEBDATA_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "version", "type", "data", "webData" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "" }, WebSsoRequestBody.class);
  public final PBStringField data = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  public final PBStringField webData = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody
 * JD-Core Version:    0.7.0.1
 */