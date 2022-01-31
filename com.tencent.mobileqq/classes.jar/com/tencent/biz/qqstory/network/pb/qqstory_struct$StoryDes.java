package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$StoryDes
  extends MessageMicro<StoryDes>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field has_unwatched_video = PBField.initUInt32(0);
  public qqstory_struct.LiveVideoDes live_video = new qqstory_struct.LiveVideoDes();
  public final PBUInt64Field new_story_time = PBField.initUInt64(0L);
  public final PBBytesField storyCover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField story_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField story_video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
  public final PBUInt32Field video_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58, 66 }, new String[] { "user", "storyCover", "new_story_time", "has_unwatched_video", "video_count", "live_video", "story_title", "story_video_attr" }, new Object[] { null, localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2, localByteStringMicro3 }, StoryDes.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryDes
 * JD-Core Version:    0.7.0.1
 */