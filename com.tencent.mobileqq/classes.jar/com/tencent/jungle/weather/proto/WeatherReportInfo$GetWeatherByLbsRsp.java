package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeatherReportInfo$GetWeatherByLbsRsp
  extends MessageMicro<GetWeatherByLbsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56 }, new String[] { "pbRspMsgHead", "area", "o_wea_code", "t_wea_code", "wea_desc", "temper", "show_flag" }, new Object[] { null, null, "", "", "", "", Integer.valueOf(0) }, GetWeatherByLbsRsp.class);
  public WeatherReportInfo.Area area = new WeatherReportInfo.Area();
  public final PBStringField o_wea_code = PBField.initString("");
  public WeatherReportInfo.PbRspMsgHead pbRspMsgHead = new WeatherReportInfo.PbRspMsgHead();
  public final PBUInt32Field show_flag = PBField.initUInt32(0);
  public final PBStringField t_wea_code = PBField.initString("");
  public final PBStringField temper = PBField.initString("");
  public final PBStringField wea_desc = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.jungle.weather.proto.WeatherReportInfo.GetWeatherByLbsRsp
 * JD-Core Version:    0.7.0.1
 */