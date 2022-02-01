package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryMessagePollInfo
  extends MessageMicro<StoryMessagePollInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField choice_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField message_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field oper_type = PBField.initUInt32(0);
  public final PBUInt64Field oper_uin = PBField.initUInt64(0L);
  public final PBUInt32Field push_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "oper_uin", "oper_type", "message_text", "choice_text", "push_time" }, new Object[] { Long.valueOf(0L), localInteger, localByteStringMicro1, localByteStringMicro2, localInteger }, StoryMessagePollInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMessagePollInfo
 * JD-Core Version:    0.7.0.1
 */