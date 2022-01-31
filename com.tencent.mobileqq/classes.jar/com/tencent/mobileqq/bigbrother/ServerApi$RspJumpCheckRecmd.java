package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ServerApi$RspJumpCheckRecmd
  extends MessageMicro<RspJumpCheckRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "err_info", "jump_method" }, new Object[] { null, Integer.valueOf(0) }, RspJumpCheckRecmd.class);
  public ServerApi.ErrorInfo err_info = new ServerApi.ErrorInfo();
  public final PBUInt32Field jump_method = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.ServerApi.RspJumpCheckRecmd
 * JD-Core Version:    0.7.0.1
 */