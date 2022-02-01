package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AVFunDrawing$DrawingInfo
  extends MessageMicro<DrawingInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<AVFunDrawing.PointInfo> msg_point_info = PBField.initRepeatMessage(AVFunDrawing.PointInfo.class);
  public final PBStringField str_pen_color = PBField.initString("");
  public final PBStringField str_pen_name = PBField.initString("");
  public final PBUInt32Field uint32_pen_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pen_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_screen_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_screen_width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58 }, new String[] { "uint32_pen_type", "str_pen_name", "str_pen_color", "uint32_pen_width", "uint32_screen_width", "uint32_screen_height", "msg_point_info" }, new Object[] { localInteger, "", "", localInteger, localInteger, localInteger, null }, DrawingInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.AVFunDrawing.DrawingInfo
 * JD-Core Version:    0.7.0.1
 */