package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class appoint_define$ReplyInfo
  extends MessageMicro<ReplyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_comment_id", "msg_stranger_info" }, new Object[] { "", null }, ReplyInfo.class);
  public appoint_define.StrangerInfo msg_stranger_info = new appoint_define.StrangerInfo();
  public final PBStringField str_comment_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appoint.define.appoint_define.ReplyInfo
 * JD-Core Version:    0.7.0.1
 */