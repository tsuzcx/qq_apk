package com.tencent.ilivesdk.service.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;

public final class SwitchAndEnterRoom$NearPosition
  extends MessageMicro<NearPosition>
{
  public static final int LAT_FIELD_NUMBER = 2;
  public static final int LNG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField lat = PBField.initFloat(0.0F);
  public final PBFloatField lng = PBField.initFloat(0.0F);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21 }, new String[] { "lng", "lat" }, new Object[] { localFloat, localFloat }, NearPosition.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.service.pb.SwitchAndEnterRoom.NearPosition
 * JD-Core Version:    0.7.0.1
 */