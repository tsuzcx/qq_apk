package com.tencent.ilivesdk.service.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SwitchAndEnterRoom$SameCityTopic
  extends MessageMicro<SameCityTopic>
{
  public static final int LATITUDE_FIELD_NUMBER = 2;
  public static final int LONGITUDE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "longitude", "latitude" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SameCityTopic.class);
  public final PBUInt32Field latitude = PBField.initUInt32(0);
  public final PBUInt32Field longitude = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.service.pb.SwitchAndEnterRoom.SameCityTopic
 * JD-Core Version:    0.7.0.1
 */