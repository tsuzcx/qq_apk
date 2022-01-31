package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$Feed
  extends MessageMicro<Feed>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_user_info", "msg_feed_info", "uint32_owner_flag" }, new Object[] { null, null, Integer.valueOf(0) }, Feed.class);
  public appoint_define.FeedInfo msg_feed_info = new appoint_define.FeedInfo();
  public appoint_define.PublisherInfo msg_user_info = new appoint_define.PublisherInfo();
  public final PBUInt32Field uint32_owner_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appoint.define.appoint_define.Feed
 * JD-Core Version:    0.7.0.1
 */