package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$HotUserFeed
  extends MessageMicro<HotUserFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_feed_id = PBField.initString("");
  public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_publish_uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "str_feed_id", "uint32_praise_count", "uint64_publish_uid", "uint32_publish_time" }, new Object[] { "", localInteger, Long.valueOf(0L), localInteger }, HotUserFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     appoint.define.appoint_define.HotUserFeed
 * JD-Core Version:    0.7.0.1
 */