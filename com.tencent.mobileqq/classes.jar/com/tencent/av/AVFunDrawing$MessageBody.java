package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AVFunDrawing$MessageBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_msg_type", "versionInfo", "drawingInfo" }, new Object[] { Integer.valueOf(0), null, null }, MessageBody.class);
  public AVFunDrawing.DrawingInfo drawingInfo = new AVFunDrawing.DrawingInfo();
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public AVFunDrawing.VersionInfo versionInfo = new AVFunDrawing.VersionInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.AVFunDrawing.MessageBody
 * JD-Core Version:    0.7.0.1
 */