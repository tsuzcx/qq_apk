package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$DateComment
  extends MessageMicro<DateComment>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public appoint_define.AppointID msg_appoint_id = new appoint_define.AppointID();
  public appoint_define.RichText msg_content = new appoint_define.RichText();
  public appoint_define.StrangerInfo msg_publisher_info = new appoint_define.StrangerInfo();
  public appoint_define.ReplyInfo msg_reply_info = new appoint_define.ReplyInfo();
  public final PBStringField str_comment_id = PBField.initString("");
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 50, 56, 66 }, new String[] { "str_comment_id", "msg_appoint_id", "msg_publisher_info", "uint32_time", "msg_reply_info", "uint32_flag", "msg_content" }, new Object[] { "", null, null, localInteger, null, localInteger, null }, DateComment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     appoint.define.appoint_define.DateComment
 * JD-Core Version:    0.7.0.1
 */