package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeatherReportInfo$GetWeatherByLbsReq
  extends MessageMicro<GetWeatherByLbsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "pbReqMsgHead", "uin", "lat", "lng", "adcode_from_mapsdk" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetWeatherByLbsReq.class);
  public final PBUInt32Field adcode_from_mapsdk = PBField.initUInt32(0);
  public final PBUInt32Field lat = PBField.initUInt32(0);
  public final PBUInt32Field lng = PBField.initUInt32(0);
  public WeatherReportInfo.PbReqMsgHead pbReqMsgHead = new WeatherReportInfo.PbReqMsgHead();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.jungle.weather.proto.WeatherReportInfo.GetWeatherByLbsReq
 * JD-Core Version:    0.7.0.1
 */