package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqAddFeedComment
  extends MessageMicro<ReqAddFeedComment>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<qqstory_struct.FeedCommentAtVideoInfo> at_video_info = PBField.initRepeatMessage(qqstory_struct.FeedCommentAtVideoInfo.class);
  public final PBUInt32Field comment_type = PBField.initUInt32(0);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField extras = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field fake_id = PBField.initUInt64(0L);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField reply_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 64, 74 }, new String[] { "feed_id", "reply_union_id", "content", "fake_id", "source", "type", "at_video_info", "comment_type", "extras" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro4 }, ReqAddFeedComment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqAddFeedComment
 * JD-Core Version:    0.7.0.1
 */