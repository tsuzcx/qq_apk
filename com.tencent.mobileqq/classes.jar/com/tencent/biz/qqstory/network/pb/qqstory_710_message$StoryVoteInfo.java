package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryVoteInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_bigv = PBField.initUInt32(0);
  public final PBUInt32Field is_my_vote = PBField.initUInt32(0);
  public final PBBytesField nick_postfix = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_del = PBField.initUInt32(0);
  public final PBBytesField vote_answer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vote_question = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field vote_time = PBField.initUInt32(0);
  public final PBUInt32Field vote_type = PBField.initUInt32(0);
  public final PBUInt64Field vote_uid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 64, 72, 82 }, new String[] { "vote_uid", "vote_time", "is_bigv", "union_id", "vote_type", "vote_question", "vote_answer", "video_del", "is_my_vote", "nick_postfix" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, StoryVoteInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryVoteInfo
 * JD-Core Version:    0.7.0.1
 */