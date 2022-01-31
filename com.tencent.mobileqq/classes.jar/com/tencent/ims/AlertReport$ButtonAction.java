package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AlertReport$ButtonAction
  extends MessageMicro<ButtonAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_cmd", "uint32_button_id", "str_package_name", "uint32_app_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, ButtonAction.class);
  public final PBStringField str_package_name = PBField.initString("");
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_button_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.AlertReport.ButtonAction
 * JD-Core Version:    0.7.0.1
 */