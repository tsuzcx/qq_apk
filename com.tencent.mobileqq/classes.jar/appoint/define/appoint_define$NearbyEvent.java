package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$NearbyEvent
  extends MessageMicro<NearbyEvent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public appoint_define.RankEvent msg_rankevent = new appoint_define.RankEvent();
  public final PBUInt32Field uint32_eventtype = PBField.initUInt32(0);
  public final PBUInt64Field uint64_event_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_event_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_eventtype", "msg_rankevent", "uint64_event_uin", "uint64_event_tinyid" }, new Object[] { Integer.valueOf(0), null, localLong, localLong }, NearbyEvent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     appoint.define.appoint_define.NearbyEvent
 * JD-Core Version:    0.7.0.1
 */