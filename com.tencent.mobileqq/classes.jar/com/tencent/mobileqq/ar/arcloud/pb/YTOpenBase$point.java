package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YTOpenBase$point
  extends MessageMicro<point>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field x = PBField.initInt32(0);
  public final PBInt32Field y = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "x", "y" }, new Object[] { localInteger, localInteger }, point.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase.point
 * JD-Core Version:    0.7.0.1
 */