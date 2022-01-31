package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$AppointInfoEx
  extends MessageMicro<AppointInfoEx>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64 }, new String[] { "str_feeds_pic_url", "str_feeds_url", "str_detail_title", "str_detail_describe", "uint32_show_publisher", "str_detail_pic_url", "str_detail_url", "uint32_show_attend" }, new Object[] { "", "", "", "", Integer.valueOf(0), "", "", Integer.valueOf(0) }, AppointInfoEx.class);
  public final PBStringField str_detail_describe = PBField.initString("");
  public final PBStringField str_detail_pic_url = PBField.initString("");
  public final PBStringField str_detail_title = PBField.initString("");
  public final PBStringField str_detail_url = PBField.initString("");
  public final PBStringField str_feeds_pic_url = PBField.initString("");
  public final PBStringField str_feeds_url = PBField.initString("");
  public final PBUInt32Field uint32_show_attend = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_publisher = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appoint.define.appoint_define.AppointInfoEx
 * JD-Core Version:    0.7.0.1
 */