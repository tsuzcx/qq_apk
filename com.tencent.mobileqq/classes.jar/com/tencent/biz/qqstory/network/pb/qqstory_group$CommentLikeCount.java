package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_group$CommentLikeCount
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field comment_count = PBField.initUInt32(0);
  public final PBUInt32Field error = PBField.initUInt32(0);
  public final PBUInt32Field is_has_like = PBField.initUInt32(0);
  public final PBUInt32Field like_count = PBField.initUInt32(0);
  public final PBRepeatMessageField newly_three_like = PBField.initRepeatMessage(qqstory_group.NewlyLikeInfo.class);
  public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "error", "story_id", "like_count", "comment_count", "is_has_like", "newly_three_like" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, CommentLikeCount.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.CommentLikeCount
 * JD-Core Version:    0.7.0.1
 */