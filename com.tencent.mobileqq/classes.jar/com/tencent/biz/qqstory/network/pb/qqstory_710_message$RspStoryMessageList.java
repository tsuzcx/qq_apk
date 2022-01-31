package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_710_message$RspStoryMessageList
  extends MessageMicro<RspStoryMessageList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "errinfo", "message_list", "message_num", "is_end", "has_read_msg" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspStoryMessageList.class);
  public qqstory_710_message.ErrorInfo errinfo = new qqstory_710_message.ErrorInfo();
  public final PBUInt32Field has_read_msg = PBField.initUInt32(0);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBRepeatMessageField<qqstory_710_message.StoryMessage> message_list = PBField.initRepeatMessage(qqstory_710_message.StoryMessage.class);
  public final PBUInt32Field message_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.RspStoryMessageList
 * JD-Core Version:    0.7.0.1
 */