package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AVFunDrawing$PointInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24 }, new String[] { "float_x", "float_y", "uint32_type" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0) }, PointInfo.class);
  public final PBFloatField float_x = PBField.initFloat(0.0F);
  public final PBFloatField float_y = PBField.initFloat(0.0F);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.AVFunDrawing.PointInfo
 * JD-Core Version:    0.7.0.1
 */