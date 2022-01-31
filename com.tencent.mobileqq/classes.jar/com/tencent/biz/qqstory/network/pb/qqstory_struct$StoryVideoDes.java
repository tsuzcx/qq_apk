package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$StoryVideoDes
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.Address address = new qqstory_struct.Address();
  public final PBUInt32Field ban_type = PBField.initUInt32(0);
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field has_like = PBField.initUInt32(0);
  public final PBUInt32Field has_related_videos = PBField.initUInt32(0);
  public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.UserInfo owner = new qqstory_struct.UserInfo();
  public final PBUInt32Field stranger_view_total_num = PBField.initUInt32(0);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field total_like_num = PBField.initUInt32(0);
  public final PBUInt32Field uncheck_like_num = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field video_total_time = PBField.initUInt64(0L);
  public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field view_total_num = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 66, 72, 82, 88, 130, 138, 144, 152, 160, 168, 176 }, new String[] { "vid", "video_url", "video_cover", "title", "doodle_url", "create_time", "view_total_num", "label", "video_total_time", "address", "has_related_videos", "video_attr", "owner", "stranger_view_total_num", "has_like", "uncheck_like_num", "total_like_num", "ban_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro6, Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro7, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StoryVideoDes.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoDes
 * JD-Core Version:    0.7.0.1
 */