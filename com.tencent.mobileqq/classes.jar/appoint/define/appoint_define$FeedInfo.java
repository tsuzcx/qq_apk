package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$FeedInfo
  extends MessageMicro<FeedInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 66, 72, 82, 88, 96, 104, 114 }, new String[] { "uint64_feed_type", "str_feed_id", "msg_feed_content", "msg_topic_info", "uint32_publish_time", "uint32_praise_count", "uint32_praise_flag", "rpt_msg_praise_user", "uint32_comment_count", "rpt_msg_comment_list", "uint32_comment_ret_all", "uint32_hot_flag", "uint64_svr_reserved", "msg_hot_entry" }, new Object[] { Long.valueOf(0L), "", null, null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null }, FeedInfo.class);
  public appoint_define.FeedContent msg_feed_content = new appoint_define.FeedContent();
  public appoint_define.HotEntry msg_hot_entry = new appoint_define.HotEntry();
  public appoint_define.NearbyTopic msg_topic_info = new appoint_define.NearbyTopic();
  public final PBRepeatMessageField<appoint_define.FeedComment> rpt_msg_comment_list = PBField.initRepeatMessage(appoint_define.FeedComment.class);
  public final PBRepeatMessageField<appoint_define.StrangerInfo> rpt_msg_praise_user = PBField.initRepeatMessage(appoint_define.StrangerInfo.class);
  public final PBStringField str_feed_id = PBField.initString("");
  public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_ret_all = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint32_publish_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feed_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_svr_reserved = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appoint.define.appoint_define.FeedInfo
 * JD-Core Version:    0.7.0.1
 */