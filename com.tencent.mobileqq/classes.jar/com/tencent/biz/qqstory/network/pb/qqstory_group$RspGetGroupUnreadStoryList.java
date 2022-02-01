package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$RspGetGroupUnreadStoryList
  extends MessageMicro<RspGetGroupUnreadStoryList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_group.UserGroupStoryItem> story_list = PBField.initRepeatMessage(qqstory_group.UserGroupStoryItem.class);
  public final PBRepeatField<Long> top_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field total_unread = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "result", "is_end", "next_cookie", "story_list", "total_unread", "top_uin_list" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Long.valueOf(0L) }, RspGetGroupUnreadStoryList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupUnreadStoryList
 * JD-Core Version:    0.7.0.1
 */