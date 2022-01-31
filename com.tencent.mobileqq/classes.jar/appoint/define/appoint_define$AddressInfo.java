package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class appoint_define$AddressInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "str_company_zone", "str_company_name", "str_company_addr", "str_company_pic_url", "str_company_url", "msg_company_id" }, new Object[] { "", "", "", "", "", null }, AddressInfo.class);
  public appoint_define.ShopID msg_company_id = new appoint_define.ShopID();
  public final PBStringField str_company_addr = PBField.initString("");
  public final PBStringField str_company_name = PBField.initString("");
  public final PBStringField str_company_pic_url = PBField.initString("");
  public final PBStringField str_company_url = PBField.initString("");
  public final PBStringField str_company_zone = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appoint.define.appoint_define.AddressInfo
 * JD-Core Version:    0.7.0.1
 */