package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class ServerApi$RspDownloadCheckRecmd
  extends MessageMicro<RspDownloadCheckRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "err_info", "check_pass" }, new Object[] { null, Boolean.valueOf(true) }, RspDownloadCheckRecmd.class);
  public final PBBoolField check_pass = PBField.initBool(true);
  public ServerApi.ErrorInfo err_info = new ServerApi.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.ServerApi.RspDownloadCheckRecmd
 * JD-Core Version:    0.7.0.1
 */