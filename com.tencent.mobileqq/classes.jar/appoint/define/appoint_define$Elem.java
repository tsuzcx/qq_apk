package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class appoint_define$Elem
  extends MessageMicro<Elem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_content", "msg_face_info" }, new Object[] { "", null }, Elem.class);
  public appoint_define.Face msg_face_info = new appoint_define.Face();
  public final PBStringField str_content = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appoint.define.appoint_define.Elem
 * JD-Core Version:    0.7.0.1
 */