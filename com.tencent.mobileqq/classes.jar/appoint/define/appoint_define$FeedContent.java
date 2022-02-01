package appoint.define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$FeedContent
  extends MessageMicro<FeedContent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_private_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public appoint_define.ADFeed msg_ad = new appoint_define.ADFeed();
  public appoint_define.LocaleInfo msg_locale = new appoint_define.LocaleInfo();
  public appoint_define.RichText msg_text = new appoint_define.RichText();
  public final PBRepeatField<String> rpt_str_pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_group_bulletin = PBField.initString("");
  public final PBStringField str_group_name = PBField.initString("");
  public final PBStringField str_href_url = PBField.initString("");
  public final PBStringField str_poi_id = PBField.initString("");
  public final PBStringField str_poi_title = PBField.initString("");
  public final PBUInt32Field uint32_effective_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expiation_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feed_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feeds_index = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 42, 50, 56, 66, 74, 160, 168, 178, 184, 194, 202 }, new String[] { "rpt_str_pic_url", "msg_text", "str_href_url", "str_group_name", "str_group_bulletin", "uint32_feed_type", "str_poi_id", "str_poi_title", "uint32_effective_time", "uint32_expiation_time", "msg_locale", "uint32_feeds_index", "msg_ad", "bytes_private_data" }, new Object[] { "", null, "", "", "", localInteger, "", "", localInteger, localInteger, null, localInteger, null, localByteStringMicro }, FeedContent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     appoint.define.appoint_define.FeedContent
 * JD-Core Version:    0.7.0.1
 */