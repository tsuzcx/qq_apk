package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class BnrReport$ExtInfo
  extends MessageMicro
{
  public static final int APP_VER_FIELD_NUMBER = 1;
  public static final int SYS_VER_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "app_ver", "sys_ver" }, new Object[] { "", "" }, ExtInfo.class);
  public final PBStringField app_ver = PBField.initString("");
  public final PBStringField sys_ver = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bnr.BnrReport.ExtInfo
 * JD-Core Version:    0.7.0.1
 */