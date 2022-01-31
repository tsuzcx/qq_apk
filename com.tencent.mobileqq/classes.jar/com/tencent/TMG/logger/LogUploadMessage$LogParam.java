package com.tencent.TMG.logger;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class LogUploadMessage$LogParam
  extends MessageMicro<LogParam>
{
  public static final int ALL = 3;
  public static final int APP = 2;
  public static final int BOTH = 8;
  public static final int LTE = 2;
  public static final int SDK = 1;
  public static final int WIFI = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "url", "authorization", "apn", "begin_at", "end_at", "log_type", "sdkappid", "tinyid", "seq" }, new Object[] { "", "", Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, LogParam.class);
  public final PBEnumField apn = PBField.initEnum(1);
  public final PBStringField authorization = PBField.initString("");
  public final PBUInt32Field begin_at = PBField.initUInt32(0);
  public final PBUInt32Field end_at = PBField.initUInt32(0);
  public final PBEnumField log_type = PBField.initEnum(3);
  public final PBUInt64Field sdkappid = PBField.initUInt64(0L);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.logger.LogUploadMessage.LogParam
 * JD-Core Version:    0.7.0.1
 */