package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SerializationPB$VideoListFeed
  extends MessageMicro<VideoListFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public SerializationPB.CommentLikeFeed commet_like_feed = new SerializationPB.CommentLikeFeed();
  public final PBUInt32Field has_public_video = PBField.initUInt32(0);
  public final PBUInt32Field has_tag = PBField.initUInt32(0);
  public final PBUInt32Field is_contribute = PBField.initUInt32(0);
  public final PBUInt32Field is_video_end = PBField.initUInt32(0);
  public final PBBytesField qim_sync_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField video_next_cookie = PBField.initString("");
  public final PBUInt32Field video_pull_type = PBField.initUInt32(0);
  public final PBUInt32Field video_seq = PBField.initUInt32(0);
  public final PBBytesField ws_schema_main = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField ws_schema_memories = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 74, 82, 90 }, new String[] { "commet_like_feed", "video_next_cookie", "video_pull_type", "is_video_end", "is_contribute", "video_seq", "has_tag", "has_public_video", "qim_sync_wording", "ws_schema_main", "ws_schema_memories" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, VideoListFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.SerializationPB.VideoListFeed
 * JD-Core Version:    0.7.0.1
 */