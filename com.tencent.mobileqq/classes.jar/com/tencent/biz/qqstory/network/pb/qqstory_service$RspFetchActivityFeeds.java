package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$RspFetchActivityFeeds
  extends MessageMicro<RspFetchActivityFeeds>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<qqstory_struct.ActivityFeedNode> feed_list = PBField.initRepeatMessage(qqstory_struct.ActivityFeedNode.class);
  public final PBUInt64Field feeds_seq = PBField.initUInt64(0L);
  public final PBUInt32Field fetch_time = PBField.initUInt32(0);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48 }, new String[] { "result", "next_cookie", "is_end", "fetch_time", "feed_list", "feeds_seq" }, new Object[] { null, localByteStringMicro, localInteger, localInteger, null, Long.valueOf(0L) }, RspFetchActivityFeeds.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspFetchActivityFeeds
 * JD-Core Version:    0.7.0.1
 */