package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ServerApi$RspUpdateDownCountRecmd
  extends MessageMicro<RspUpdateDownCountRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "err_info", "download_num" }, new Object[] { null, Integer.valueOf(0) }, RspUpdateDownCountRecmd.class);
  public final PBUInt32Field download_num = PBField.initUInt32(0);
  public ServerApi.ErrorInfo err_info = new ServerApi.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.ServerApi.RspUpdateDownCountRecmd
 * JD-Core Version:    0.7.0.1
 */