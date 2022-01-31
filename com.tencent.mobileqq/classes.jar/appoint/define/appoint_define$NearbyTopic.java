package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$NearbyTopic
  extends MessageMicro<NearbyTopic>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 128, 136, 146 }, new String[] { "uint64_topic_id", "str_topic", "str_foreword", "uint32_create_time", "uint32_update_time", "uint32_hot_flag", "uint32_button_style", "str_button_src", "str_background_src", "str_attendee_info", "uint32_index", "uint32_publish_scope", "uint32_effective_time", "uint32_expiation_time", "uint32_pushed_usr_count", "uint32_timerange_left", "uint32_timerange_right", "str_area" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, NearbyTopic.class);
  public final PBStringField str_area = PBField.initString("");
  public final PBStringField str_attendee_info = PBField.initString("");
  public final PBStringField str_background_src = PBField.initString("");
  public final PBStringField str_button_src = PBField.initString("");
  public final PBStringField str_foreword = PBField.initString("");
  public final PBStringField str_topic = PBField.initString("");
  public final PBUInt32Field uint32_button_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_effective_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expiation_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publish_scope = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pushed_usr_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timerange_left = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timerange_right = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appoint.define.appoint_define.NearbyTopic
 * JD-Core Version:    0.7.0.1
 */