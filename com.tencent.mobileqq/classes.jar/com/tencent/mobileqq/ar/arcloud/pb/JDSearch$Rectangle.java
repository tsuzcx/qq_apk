package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class JDSearch$Rectangle
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 29, 37, 45 }, new String[] { "bottom", "is_user_rectangle", "left", "right", "top" }, new Object[] { Float.valueOf(0.0F), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) }, Rectangle.class);
  public final PBFloatField bottom = PBField.initFloat(0.0F);
  public final PBInt32Field is_user_rectangle = PBField.initInt32(0);
  public final PBFloatField left = PBField.initFloat(0.0F);
  public final PBFloatField right = PBField.initFloat(0.0F);
  public final PBFloatField top = PBField.initFloat(0.0F);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.JDSearch.Rectangle
 * JD-Core Version:    0.7.0.1
 */