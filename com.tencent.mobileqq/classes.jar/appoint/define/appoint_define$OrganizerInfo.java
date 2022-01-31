package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class appoint_define$OrganizerInfo
  extends MessageMicro<OrganizerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "host_name", "host_url", "host_cover" }, new Object[] { "", "", "" }, OrganizerInfo.class);
  public final PBStringField host_cover = PBField.initString("");
  public final PBStringField host_name = PBField.initString("");
  public final PBStringField host_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appoint.define.appoint_define.OrganizerInfo
 * JD-Core Version:    0.7.0.1
 */