package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$StoryVideoCommentInfo
  extends MessageMicro<StoryVideoCommentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<qqstory_struct.FeedCommentAtVideoInfo> at_video_info = PBField.initRepeatMessage(qqstory_struct.FeedCommentAtVideoInfo.class);
  public final PBUInt32Field at_video_shoot_time = PBField.initUInt32(0);
  public final PBUInt32Field author_role = PBField.initUInt32(0);
  public final PBUInt64Field author_uid = PBField.initUInt64(0L);
  public final PBStringField author_union_id = PBField.initString("");
  public final PBUInt32Field comment_id = PBField.initUInt32(0);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField extras = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field fake_id = PBField.initUInt64(0L);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field reply_role = PBField.initUInt32(0);
  public final PBUInt64Field reply_time = PBField.initUInt64(0L);
  public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
  public final PBStringField reply_union_id = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66, 72, 82, 90, 96, 106, 114, 122, 128 }, new String[] { "comment_id", "reply_uid", "author_uid", "reply_time", "content", "fake_id", "author_role", "author_union_id", "reply_role", "reply_union_id", "at_video_info", "type", "extras", "vid", "feed_id", "at_video_shoot_time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "", null, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, StoryVideoCommentInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo
 * JD-Core Version:    0.7.0.1
 */