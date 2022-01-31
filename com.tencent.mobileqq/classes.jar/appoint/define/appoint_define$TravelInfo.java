package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$TravelInfo
  extends MessageMicro<TravelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "msg_depart_locale", "msg_destination", "uint32_vehicle", "uint32_partner_count", "str_place_pic_url", "str_place_url" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), "", "" }, TravelInfo.class);
  public appoint_define.LocaleInfo msg_depart_locale = new appoint_define.LocaleInfo();
  public appoint_define.LocaleInfo msg_destination = new appoint_define.LocaleInfo();
  public final PBStringField str_place_pic_url = PBField.initString("");
  public final PBStringField str_place_url = PBField.initString("");
  public final PBUInt32Field uint32_partner_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vehicle = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appoint.define.appoint_define.TravelInfo
 * JD-Core Version:    0.7.0.1
 */