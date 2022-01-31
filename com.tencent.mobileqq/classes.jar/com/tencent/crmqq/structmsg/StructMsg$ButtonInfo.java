package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class StructMsg$ButtonInfo
  extends MessageMicro<ButtonInfo>
{
  public static final int AUTH_NONE = 0;
  public static final int AUTH_SID = 1;
  public static final int AUTH_VKEY = 2;
  public static final int CLICK = 1;
  public static final int EVENT = 3;
  public static final int URL = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 64, 74, 80, 88 }, new String[] { "id", "name", "key", "url", "auth_type", "type", "sub_button", "event_id", "event_param", "is_need_lbs", "item_id" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(1), null, Integer.valueOf(1), null, Boolean.valueOf(false), Integer.valueOf(0) }, ButtonInfo.class);
  public final PBEnumField auth_type = PBField.initEnum(0);
  public final PBEnumField event_id = PBField.initEnum(1);
  public final PBRepeatMessageField<StructMsg.ButtonInfo_EventInfoParam> event_param = PBField.initRepeatMessage(StructMsg.ButtonInfo_EventInfoParam.class);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBBoolField is_need_lbs = PBField.initBool(false);
  public final PBUInt32Field item_id = PBField.initUInt32(0);
  public final PBStringField key = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBRepeatMessageField<ButtonInfo> sub_button = PBField.initRepeatMessage(ButtonInfo.class);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.crmqq.structmsg.StructMsg.ButtonInfo
 * JD-Core Version:    0.7.0.1
 */