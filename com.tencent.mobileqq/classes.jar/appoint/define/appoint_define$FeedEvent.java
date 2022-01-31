package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$FeedEvent
  extends MessageMicro<FeedEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64 }, new String[] { "uint64_event_id", "uint32_time", "uint32_eventtype", "msg_user_info", "msg_feed_info", "str_event_tips", "msg_comment", "uint64_cancel_event_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, "", null, Long.valueOf(0L) }, FeedEvent.class);
  public appoint_define.FeedComment msg_comment = new appoint_define.FeedComment();
  public appoint_define.FeedInfo msg_feed_info = new appoint_define.FeedInfo();
  public appoint_define.StrangerInfo msg_user_info = new appoint_define.StrangerInfo();
  public final PBStringField str_event_tips = PBField.initString("");
  public final PBUInt32Field uint32_eventtype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cancel_event_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_event_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appoint.define.appoint_define.FeedEvent
 * JD-Core Version:    0.7.0.1
 */