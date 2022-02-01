package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$HotFreshFeedList
  extends MessageMicro<HotFreshFeedList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_feeds", "uint32_update_time" }, new Object[] { null, Integer.valueOf(0) }, HotFreshFeedList.class);
  public final PBRepeatMessageField<appoint_define.HotUserFeed> rpt_msg_feeds = PBField.initRepeatMessage(appoint_define.HotUserFeed.class);
  public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     appoint.define.appoint_define.HotFreshFeedList
 * JD-Core Version:    0.7.0.1
 */