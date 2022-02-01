package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$AppointContent
  extends MessageMicro<AppointContent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public appoint_define.AddressInfo msg_appoint_address = new appoint_define.AddressInfo();
  public appoint_define.TravelInfo msg_travel_info = new appoint_define.TravelInfo();
  public final PBStringField str_appoint_introduce = PBField.initString("");
  public final PBUInt32Field uint32_appoint_date = PBField.initUInt32(0);
  public final PBUInt32Field uint32_appoint_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_appoint_subject = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pay_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58 }, new String[] { "uint32_appoint_subject", "uint32_pay_type", "uint32_appoint_date", "uint32_appoint_gender", "str_appoint_introduce", "msg_appoint_address", "msg_travel_info" }, new Object[] { localInteger, localInteger, localInteger, localInteger, "", null, null }, AppointContent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     appoint.define.appoint_define.AppointContent
 * JD-Core Version:    0.7.0.1
 */