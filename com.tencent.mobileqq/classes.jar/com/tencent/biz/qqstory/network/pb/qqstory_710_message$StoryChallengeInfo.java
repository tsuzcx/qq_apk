package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryChallengeInfo
  extends MessageMicro<StoryChallengeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField challenge_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field challenge_time = PBField.initUInt32(0);
  public final PBUInt64Field challenge_uid = PBField.initUInt64(0L);
  public final PBUInt32Field comment_del = PBField.initUInt32(0);
  public final PBUInt32Field comment_id = PBField.initUInt32(0);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_bigv = PBField.initUInt32(0);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_del = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 74 }, new String[] { "challenge_uid", "challenge_time", "is_bigv", "union_id", "content", "comment_id", "comment_del", "video_del", "challenge_feed_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, StoryChallengeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryChallengeInfo
 * JD-Core Version:    0.7.0.1
 */