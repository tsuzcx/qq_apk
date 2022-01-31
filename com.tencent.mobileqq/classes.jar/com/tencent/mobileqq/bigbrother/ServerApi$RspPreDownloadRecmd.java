package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ServerApi$RspPreDownloadRecmd
  extends MessageMicro<RspPreDownloadRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58 }, new String[] { "err_info", "start_time", "end_time", "interval", "daily_num", "quota_num", "download_url" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RspPreDownloadRecmd.class);
  public final PBUInt32Field daily_num = PBField.initUInt32(0);
  public final PBStringField download_url = PBField.initString("");
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public ServerApi.ErrorInfo err_info = new ServerApi.ErrorInfo();
  public final PBUInt32Field interval = PBField.initUInt32(0);
  public final PBUInt32Field quota_num = PBField.initUInt32(0);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.ServerApi.RspPreDownloadRecmd
 * JD-Core Version:    0.7.0.1
 */