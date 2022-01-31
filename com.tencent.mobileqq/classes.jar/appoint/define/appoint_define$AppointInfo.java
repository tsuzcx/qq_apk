package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$AppointInfo
  extends MessageMicro<AppointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 56, 64, 72, 82, 88, 96, 106 }, new String[] { "msg_appoint_id", "msg_appointment", "uint32_appoint_status", "str_join_wording", "str_view_wording", "uint32_unread_count", "uint32_owner", "uint32_join", "uint32_view", "str_comment_wording", "uint32_comment_num", "uint32_attend_status", "msg_appointment_ex" }, new Object[] { null, null, Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null }, AppointInfo.class);
  public appoint_define.AppointID msg_appoint_id = new appoint_define.AppointID();
  public appoint_define.AppointContent msg_appointment = new appoint_define.AppointContent();
  public appoint_define.AppointInfoEx msg_appointment_ex = new appoint_define.AppointInfoEx();
  public final PBStringField str_comment_wording = PBField.initString("");
  public final PBStringField str_join_wording = PBField.initString("");
  public final PBStringField str_view_wording = PBField.initString("");
  public final PBUInt32Field uint32_appoint_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_attend_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_join = PBField.initUInt32(0);
  public final PBUInt32Field uint32_owner = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_view = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appoint.define.appoint_define.AppointInfo
 * JD-Core Version:    0.7.0.1
 */