package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ServerApi$ReqDownloadCheckRecmd
  extends MessageMicro<ReqDownloadCheckRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uin", "source", "platform", "pkg_name", "scheme", "url", "extra_info", "ref_source" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", "", "" }, ReqDownloadCheckRecmd.class);
  public final PBStringField extra_info = PBField.initString("");
  public final PBStringField pkg_name = PBField.initString("");
  public final PBStringField platform = PBField.initString("");
  public final PBStringField ref_source = PBField.initString("");
  public final PBStringField scheme = PBField.initString("");
  public final PBStringField source = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.ServerApi.ReqDownloadCheckRecmd
 * JD-Core Version:    0.7.0.1
 */