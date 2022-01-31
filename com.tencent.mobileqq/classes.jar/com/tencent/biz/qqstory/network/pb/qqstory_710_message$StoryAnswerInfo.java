package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryAnswerInfo
  extends MessageMicro<StoryAnswerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField answer_question = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField answer_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field answer_time = PBField.initUInt32(0);
  public final PBUInt32Field answer_type = PBField.initUInt32(0);
  public final PBUInt64Field answer_uid = PBField.initUInt64(0L);
  public final PBUInt32Field at_video_ts = PBField.initUInt32(0);
  public final PBUInt32Field is_bigv = PBField.initUInt32(0);
  public final PBUInt32Field is_my_answer = PBField.initUInt32(0);
  public final PBBytesField nick_postfix = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_del = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 64, 72, 82, 88 }, new String[] { "answer_uid", "answer_time", "is_bigv", "union_id", "answer_type", "answer_question", "answer_text", "video_del", "is_my_answer", "nick_postfix", "at_video_ts" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, StoryAnswerInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryAnswerInfo
 * JD-Core Version:    0.7.0.1
 */