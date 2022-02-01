package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ServerApi$ReqJumpCheckRecmd
  extends MessageMicro<ReqJumpCheckRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "uin", "source", "platform", "pkg_name", "scheme", "url", "action", "extra_info", "ref_source" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", "", "", "" }, ReqJumpCheckRecmd.class);
  public final PBStringField action = PBField.initString("");
  public final PBStringField extra_info = PBField.initString("");
  public final PBRepeatField<String> pkg_name = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField platform = PBField.initString("");
  public final PBStringField ref_source = PBField.initString("");
  public final PBStringField scheme = PBField.initString("");
  public final PBStringField source = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.ServerApi.ReqJumpCheckRecmd
 * JD-Core Version:    0.7.0.1
 */