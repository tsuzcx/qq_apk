package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$StoryVideoBasicInfo
  extends MessageMicro<StoryVideoBasicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.Address address = new qqstory_struct.Address();
  public final PBUInt32Field ban_type = PBField.initUInt32(0);
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.VideoSpreadGroupList group_list = new qqstory_struct.VideoSpreadGroupList();
  public final PBUInt32Field has_related_videos = PBField.initUInt32(0);
  public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField owner_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<String> poll_options = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField poll_text = PBField.initString("");
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field video_index = PBField.initUInt64(0L);
  public final PBUInt32Field video_source = PBField.initUInt32(0);
  public qqstory_struct.TagInfoBase video_tag = new qqstory_struct.TagInfoBase();
  public final PBUInt64Field video_total_time = PBField.initUInt64(0L);
  public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 66, 72, 82, 88, 130, 138, 144, 154, 160, 170, 176, 194, 202 }, new String[] { "vid", "video_url", "video_cover", "title", "doodle_url", "create_time", "label", "video_total_time", "address", "has_related_videos", "video_attr", "owner_union_id", "ban_type", "group_list", "video_source", "video_tag", "video_index", "poll_text", "poll_options" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), null, Integer.valueOf(0), null, Long.valueOf(0L), "", "" }, StoryVideoBasicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoBasicInfo
 * JD-Core Version:    0.7.0.1
 */