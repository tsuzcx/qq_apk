package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspStoryFeedIdList
  extends MessageMicro<RspStoryFeedIdList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<qqstory_struct.FeedSeqInfo> feed_seq_info_list = PBField.initRepeatMessage(qqstory_struct.FeedSeqInfo.class);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBUInt32Field is_today_end = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "result", "feed_seq_info_list", "is_end", "next_cookie", "is_today_end" }, new Object[] { null, null, localInteger, localByteStringMicro, localInteger }, RspStoryFeedIdList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedIdList
 * JD-Core Version:    0.7.0.1
 */