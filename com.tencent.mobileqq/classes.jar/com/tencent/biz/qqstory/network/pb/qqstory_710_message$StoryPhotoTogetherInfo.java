package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryPhotoTogetherInfo
  extends MessageMicro<StoryPhotoTogetherInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field at_video_ts = PBField.initUInt32(0);
  public final PBUInt32Field comment_del = PBField.initUInt32(0);
  public final PBUInt32Field comment_id = PBField.initUInt32(0);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_bigv = PBField.initUInt32(0);
  public final PBBytesField photo_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field photo_time = PBField.initUInt32(0);
  public final PBUInt64Field photo_uid = PBField.initUInt64(0L);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_del = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 74, 80 }, new String[] { "photo_uid", "photo_time", "is_bigv", "union_id", "content", "comment_id", "comment_del", "video_del", "photo_feed_id", "at_video_ts" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localInteger, localByteStringMicro3, localInteger }, StoryPhotoTogetherInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryPhotoTogetherInfo
 * JD-Core Version:    0.7.0.1
 */