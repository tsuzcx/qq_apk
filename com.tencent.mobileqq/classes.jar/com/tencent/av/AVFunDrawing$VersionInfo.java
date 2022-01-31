package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AVFunDrawing$VersionInfo
  extends MessageMicro<VersionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_version", "uint32_support_drawing" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, VersionInfo.class);
  public final PBUInt32Field uint32_support_drawing = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.AVFunDrawing.VersionInfo
 * JD-Core Version:    0.7.0.1
 */