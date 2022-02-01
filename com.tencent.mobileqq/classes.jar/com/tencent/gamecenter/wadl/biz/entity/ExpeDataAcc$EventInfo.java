package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ExpeDataAcc$EventInfo
  extends MessageMicro<EventInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 64, 74, 82, 162, 170, 178, 186 }, new String[] { "eventId", "eventTimestamp", "eventType", "eventType2", "eventType3", "eventResult", "eventErrCode", "actTimes", "eventType4", "eventType5", "page", "pageModule", "fromPage", "eventCode" }, new Object[] { "", Long.valueOf(0L), "", "", "", "", "", Long.valueOf(0L), "", "", "", "", "", "" }, EventInfo.class);
  public final PBInt64Field actTimes = PBField.initInt64(0L);
  public final PBStringField eventCode = PBField.initString("");
  public final PBStringField eventErrCode = PBField.initString("");
  public final PBStringField eventId = PBField.initString("");
  public final PBStringField eventResult = PBField.initString("");
  public final PBInt64Field eventTimestamp = PBField.initInt64(0L);
  public final PBStringField eventType = PBField.initString("");
  public final PBStringField eventType2 = PBField.initString("");
  public final PBStringField eventType3 = PBField.initString("");
  public final PBStringField eventType4 = PBField.initString("");
  public final PBStringField eventType5 = PBField.initString("");
  public final PBStringField fromPage = PBField.initString("");
  public final PBStringField page = PBField.initString("");
  public final PBStringField pageModule = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.EventInfo
 * JD-Core Version:    0.7.0.1
 */