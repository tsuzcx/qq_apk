package com.tencent.jungle.weather;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeatherReportInfo$GetWeatherMessageReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "pbReqMsgHead", "uin", "lat", "lng", "ip", "area_id", "source", "fore_flag", "extra" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, GetWeatherMessageReq.class);
  public final PBUInt32Field area_id = PBField.initUInt32(0);
  public final PBStringField extra = PBField.initString("");
  public final PBUInt32Field fore_flag = PBField.initUInt32(0);
  public final PBUInt32Field ip = PBField.initUInt32(0);
  public final PBUInt32Field lat = PBField.initUInt32(0);
  public final PBUInt32Field lng = PBField.initUInt32(0);
  public WeatherReportInfo.PbReqMsgHead pbReqMsgHead = new WeatherReportInfo.PbReqMsgHead();
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageReq
 * JD-Core Version:    0.7.0.1
 */