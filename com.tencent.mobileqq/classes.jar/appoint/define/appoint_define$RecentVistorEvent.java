package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$RecentVistorEvent
  extends MessageMicro<RecentVistorEvent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_eventtype = PBField.initUInt32(0);
  public final PBUInt64Field uint64_event_tinyid = PBField.initUInt64(0L);
  public final PBUInt32Field uint64_unread_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_eventtype", "uint64_event_tinyid", "uint64_unread_count" }, new Object[] { localInteger, Long.valueOf(0L), localInteger }, RecentVistorEvent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     appoint.define.appoint_define.RecentVistorEvent
 * JD-Core Version:    0.7.0.1
 */