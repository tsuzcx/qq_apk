package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AVFunDrawing$MessageBody
  extends MessageMicro<MessageBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint32_msg_type", "versionInfo", "drawingInfo", "uint32_seq", "uint64_time" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0), Long.valueOf(0L) }, MessageBody.class);
  public AVFunDrawing.DrawingInfo drawingInfo = new AVFunDrawing.DrawingInfo();
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  public AVFunDrawing.VersionInfo versionInfo = new AVFunDrawing.VersionInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.AVFunDrawing.MessageBody
 * JD-Core Version:    0.7.0.1
 */