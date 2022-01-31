package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class appoint_define$HotTopicList
  extends MessageMicro<HotTopicList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_topic_list" }, new Object[] { null }, HotTopicList.class);
  public final PBRepeatMessageField<appoint_define.HotTopic> rpt_topic_list = PBField.initRepeatMessage(appoint_define.HotTopic.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appoint.define.appoint_define.HotTopicList
 * JD-Core Version:    0.7.0.1
 */