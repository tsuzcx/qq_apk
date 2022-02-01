package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$StoryVideoFullInfo
  extends MessageMicro<StoryVideoFullInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ban_type = PBField.initUInt32(0);
  public final PBBytesField compared_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_struct.VideoUrl> compressed_video = PBField.initRepeatMessage(qqstory_struct.VideoUrl.class);
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field duration = PBField.initUInt64(0L);
  public final PBUInt32Field error = PBField.initUInt32(0);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public qqstory_struct.VideoSpreadGroupList group_list = new qqstory_struct.VideoSpreadGroupList();
  public qqstory_struct.InteractPasterInfo interact_paster_info = new qqstory_struct.InteractPasterInfo();
  public final PBStringField original_author_id = PBField.initString("");
  public final PBBytesField original_author_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field player_scale_type = PBField.initUInt32(0);
  public final PBRepeatField<String> poll_options = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField poll_text = PBField.initString("");
  public qqstory_struct.QimVideoInfo qim_video_info = new qqstory_struct.QimVideoInfo();
  public final PBUInt32Field source_type = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field url_flag = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_extern_link_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field video_index = PBField.initUInt64(0L);
  public final PBUInt32Field video_source = PBField.initUInt32(0);
  public final PBUInt32Field video_source_tag_type = PBField.initUInt32(0);
  public qqstory_struct.TagInfoBase video_tag = new qqstory_struct.TagInfoBase();
  public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_url_expire_time = PBField.initUInt32(0);
  public final PBBytesField ws_schema = PBField.initBytes(ByteStringMicro.EMPTY);
  
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
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 64, 72, 82, 88, 98, 104, 112, 120, 130, 136, 146, 154, 162, 170, 178, 184, 192, 202, 208, 218, 226, 234, 242, 248 }, new String[] { "error", "vid", "type", "union_id", "video_url", "video_cover", "doodle_url", "create_time", "duration", "video_attr", "ban_type", "group_list", "video_source", "url_flag", "group_id", "video_tag", "video_index", "poll_text", "poll_options", "compressed_video", "qim_video_info", "interact_paster_info", "source_type", "player_scale_type", "ws_schema", "video_url_expire_time", "original_author_id", "original_author_name", "video_extern_link_attr", "compared_vid", "video_source_tag_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro6, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L), "", "", null, null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), "", localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0) }, StoryVideoFullInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo
 * JD-Core Version:    0.7.0.1
 */