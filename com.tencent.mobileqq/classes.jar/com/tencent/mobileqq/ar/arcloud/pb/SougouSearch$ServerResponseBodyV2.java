package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SougouSearch$ServerResponseBodyV2
  extends MessageMicro<ServerResponseBodyV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "cards", "request_class", "container_properties", "is_recommended", "session_id" }, new Object[] { null, "", null, Boolean.valueOf(false), Long.valueOf(0L) }, ServerResponseBodyV2.class);
  public final PBRepeatMessageField<SougouSearch.CardV2> cards = PBField.initRepeatMessage(SougouSearch.CardV2.class);
  public final PBRepeatMessageField<SougouSearch.MapItem> container_properties = PBField.initRepeatMessage(SougouSearch.MapItem.class);
  public final PBBoolField is_recommended = PBField.initBool(false);
  public final PBStringField request_class = PBField.initString("");
  public final PBInt64Field session_id = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.SougouSearch.ServerResponseBodyV2
 * JD-Core Version:    0.7.0.1
 */