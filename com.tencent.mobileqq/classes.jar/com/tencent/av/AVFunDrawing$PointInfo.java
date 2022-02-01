package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AVFunDrawing$PointInfo
  extends MessageMicro<PointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField float_x = PBField.initFloat(0.0F);
  public final PBFloatField float_y = PBField.initFloat(0.0F);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24 }, new String[] { "float_x", "float_y", "uint32_type" }, new Object[] { localFloat, localFloat, Integer.valueOf(0) }, PointInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.AVFunDrawing.PointInfo
 * JD-Core Version:    0.7.0.1
 */