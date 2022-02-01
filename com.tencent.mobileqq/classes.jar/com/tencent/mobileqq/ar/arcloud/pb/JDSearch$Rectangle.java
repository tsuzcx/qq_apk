package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class JDSearch$Rectangle
  extends MessageMicro<Rectangle>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField bottom = PBField.initFloat(0.0F);
  public final PBInt32Field is_user_rectangle = PBField.initInt32(0);
  public final PBFloatField left = PBField.initFloat(0.0F);
  public final PBFloatField right = PBField.initFloat(0.0F);
  public final PBFloatField top = PBField.initFloat(0.0F);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 29, 37, 45 }, new String[] { "bottom", "is_user_rectangle", "left", "right", "top" }, new Object[] { localFloat, Integer.valueOf(0), localFloat, localFloat, localFloat }, Rectangle.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.JDSearch.Rectangle
 * JD-Core Version:    0.7.0.1
 */