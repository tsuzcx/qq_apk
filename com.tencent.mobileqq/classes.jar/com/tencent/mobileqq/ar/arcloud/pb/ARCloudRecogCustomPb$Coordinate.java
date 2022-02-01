package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ARCloudRecogCustomPb$Coordinate
  extends MessageMicro<Coordinate>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_height = PBField.initInt32(0);
  public final PBInt32Field int32_width = PBField.initInt32(0);
  public final PBInt32Field int32_x = PBField.initInt32(0);
  public final PBInt32Field int32_y = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_x", "int32_y", "int32_width", "int32_height" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, Coordinate.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.Coordinate
 * JD-Core Version:    0.7.0.1
 */