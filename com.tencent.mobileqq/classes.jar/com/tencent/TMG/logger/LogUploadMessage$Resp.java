package com.tencent.TMG.logger;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LogUploadMessage$Resp
  extends MessageMicro<Resp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "num_log_uploads", "params" }, new Object[] { Integer.valueOf(0), null }, Resp.class);
  public final PBUInt32Field num_log_uploads = PBField.initUInt32(0);
  public final PBRepeatMessageField<LogUploadMessage.LogParam> params = PBField.initRepeatMessage(LogUploadMessage.LogParam.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.logger.LogUploadMessage.Resp
 * JD-Core Version:    0.7.0.1
 */