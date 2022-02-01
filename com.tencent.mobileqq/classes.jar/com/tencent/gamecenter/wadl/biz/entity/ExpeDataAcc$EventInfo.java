package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ExpeDataAcc$EventInfo
  extends MessageMicro<EventInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 64, 74, 82, 162, 170, 178, 186 }, new String[] { "event_id", "event_timestamp", "event_type", "event_type2", "event_type3", "event_result", "event_err_code", "act_times", "event_type4", "event_type5", "page", "page_module", "from_page", "event_code" }, new Object[] { "", Long.valueOf(0L), "", "", "", "", "", Long.valueOf(0L), "", "", "", "", "", "" }, EventInfo.class);
  public final PBInt64Field act_times = PBField.initInt64(0L);
  public final PBStringField event_code = PBField.initString("");
  public final PBStringField event_err_code = PBField.initString("");
  public final PBStringField event_id = PBField.initString("");
  public final PBStringField event_result = PBField.initString("");
  public final PBInt64Field event_timestamp = PBField.initInt64(0L);
  public final PBStringField event_type = PBField.initString("");
  public final PBStringField event_type2 = PBField.initString("");
  public final PBStringField event_type3 = PBField.initString("");
  public final PBStringField event_type4 = PBField.initString("");
  public final PBStringField event_type5 = PBField.initString("");
  public final PBStringField from_page = PBField.initString("");
  public final PBStringField page = PBField.initString("");
  public final PBStringField page_module = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.EventInfo
 * JD-Core Version:    0.7.0.1
 */