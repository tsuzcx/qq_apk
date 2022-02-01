package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$ActivityInfo
  extends MessageMicro<ActivityInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField cover = PBField.initString("");
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBUInt64Field create_uin = PBField.initUInt64(0L);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBUInt64Field enroll = PBField.initUInt64(0L);
  public final PBStringField id = PBField.initString("");
  public final PBStringField loc_name = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public appoint_define.OrganizerInfo organizer_info = new appoint_define.OrganizerInfo();
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_flag = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 64, 72, 80, 90, 96 }, new String[] { "id", "name", "cover", "url", "start_time", "end_time", "loc_name", "enroll", "create_uin", "create_time", "organizer_info", "uint64_flag" }, new Object[] { "", "", "", "", localInteger, localInteger, "", localLong, localLong, localInteger, null, localLong }, ActivityInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     appoint.define.appoint_define.ActivityInfo
 * JD-Core Version:    0.7.0.1
 */