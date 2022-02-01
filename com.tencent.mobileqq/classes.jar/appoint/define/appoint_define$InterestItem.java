package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$InterestItem
  extends MessageMicro<InterestItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_tag_back_color = PBField.initString("");
  public final PBStringField str_tag_category = PBField.initString("");
  public final PBStringField str_tag_font_color = PBField.initString("");
  public final PBStringField str_tag_href = PBField.initString("");
  public final PBStringField str_tag_icon_url = PBField.initString("");
  public final PBStringField str_tag_name = PBField.initString("");
  public final PBStringField str_tag_other_url = PBField.initString("");
  public final PBStringField str_tag_vid = PBField.initString("");
  public final PBUInt32Field uint32_add_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tag_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 72, 82, 90, 96 }, new String[] { "uint64_tag_id", "str_tag_name", "str_tag_icon_url", "str_tag_href", "str_tag_back_color", "str_tag_font_color", "str_tag_vid", "uint32_tag_type", "uint32_add_time", "str_tag_category", "str_tag_other_url", "uint32_bid" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", "", localInteger, localInteger, "", "", localInteger }, InterestItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     appoint.define.appoint_define.InterestItem
 * JD-Core Version:    0.7.0.1
 */