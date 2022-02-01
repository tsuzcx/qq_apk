package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ServerApi$ReqUpdateDownCountRecmd
  extends MessageMicro<ReqUpdateDownCountRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uin", "source", "pkg_name", "scene" }, new Object[] { Long.valueOf(0L), "", "", "" }, ReqUpdateDownCountRecmd.class);
  public final PBStringField pkg_name = PBField.initString("");
  public final PBStringField scene = PBField.initString("");
  public final PBStringField source = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.ServerApi.ReqUpdateDownCountRecmd
 * JD-Core Version:    0.7.0.1
 */