package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ServerApi$ErrorInfo
  extends MessageMicro<ErrorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "err_msg", "jump_url" }, new Object[] { Integer.valueOf(0), "", "" }, ErrorInfo.class);
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.ServerApi.ErrorInfo
 * JD-Core Version:    0.7.0.1
 */