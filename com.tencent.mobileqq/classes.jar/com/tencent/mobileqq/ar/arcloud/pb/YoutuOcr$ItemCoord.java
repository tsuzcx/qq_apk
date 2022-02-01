package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoutuOcr$ItemCoord
  extends MessageMicro<ItemCoord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field height = PBField.initInt32(0);
  public final PBInt32Field width = PBField.initInt32(0);
  public final PBInt32Field x = PBField.initInt32(0);
  public final PBInt32Field y = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "x", "y", "width", "height" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, ItemCoord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.ItemCoord
 * JD-Core Version:    0.7.0.1
 */