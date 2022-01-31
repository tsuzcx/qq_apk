package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WebSsoBody$WebSsoResponseBody
  extends MessageMicro
{
  public static final int CONTROLDATA_FIELD_NUMBER = 5;
  public static final int DATA_FIELD_NUMBER = 4;
  public static final int RET_FIELD_NUMBER = 3;
  public static final int TYPE_FIELD_NUMBER = 2;
  public static final int VERSION_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "version", "type", "ret", "data", "controlData" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null }, WebSsoResponseBody.class);
  public WebSsoBody.WebSsoControlData controlData = new WebSsoBody.WebSsoControlData();
  public final PBStringField data = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody
 * JD-Core Version:    0.7.0.1
 */