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

public final class qqstory_service$ReqPublishVideo
  extends MessageMicro<ReqPublishVideo>
{
  public static final int STRING_STORY_COMBO = 5;
  public static final int STRING_STORY_FILTER = 3;
  public static final int STRING_STORY_MUSIC = 4;
  public static final int STRING_STORY_PENDANT = 2;
  public static final int STRING_STORY_TEXT = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.Address address = new qqstory_struct.Address();
  public final PBUInt32Field client_version = PBField.initUInt32(0);
  public final PBUInt32Field compared_activity_id = PBField.initUInt32(0);
  public final PBUInt32Field compared_level = PBField.initUInt32(0);
  public final PBStringField compared_vid = PBField.initString("");
  public final PBUInt32Field content_origin = PBField.initUInt32(0);
  public final PBUInt32Field content_type = PBField.initUInt32(0);
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBBytesField doodle_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field dov_fresh_task_id = PBField.initUInt32(0);
  public final PBUInt32Field dov_from_new_version = PBField.initUInt32(0);
  public final PBBytesField extra = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField game_pk_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.VideoSpreadGroupList group_list = new qqstory_struct.VideoSpreadGroupList();
  public final PBUInt32Field group_source = PBField.initUInt32(0);
  public final PBUInt32Field ignore_personal_publish = PBField.initUInt32(0);
  public qqstory_struct.InteractPasterInfo interact_paster_info = new qqstory_struct.InteractPasterInfo();
  public final PBUInt32Field is_capture_together_video = PBField.initUInt32(0);
  public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> mention_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBBytesField multi_shoot_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<String> poll_options = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField poll_text = PBField.initString("");
  public final PBUInt32Field qim_sync_to_qq = PBField.initUInt32(0);
  public qqstory_struct.VideoReaderConf reader_conf = new qqstory_struct.VideoReaderConf();
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field sync_to_qzone = PBField.initUInt32(0);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field total_time = PBField.initUInt64(0L);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_extern_link_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field video_label_id = PBField.initUInt64(0L);
  public final PBBytesField video_label_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_label_type = PBField.initUInt32(0);
  public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<String> wording_check = PBField.initRepeat(PBStringField.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64, 82, 114, 122, 128, 136, 146, 152, 160, 170, 178, 184, 192, 200, 210, 216, 224, 232, 242, 248, 266, 274, 282, 288, 298, 304, 314, 320, 330, 336, 344, 354, 360 }, new String[] { "title", "vid", "video_cover", "doodle_url", "total_time", "address", "label", "create_time", "video_url", "doodle_text", "video_attr", "mention_list", "source", "reader_conf", "content_type", "content_origin", "group_list", "multi_shoot_group_id", "date", "ignore_personal_publish", "group_source", "video_label_title", "video_label_id", "video_label_type", "client_version", "extra", "qim_sync_to_qq", "poll_text", "poll_options", "interact_paster_info", "sync_to_qzone", "video_extern_link_attr", "dov_fresh_task_id", "compared_vid", "is_capture_together_video", "game_pk_vid", "compared_level", "compared_activity_id", "wording_check", "dov_from_new_version" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localLong, null, localByteStringMicro5, localLong, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localLong, localInteger, null, localInteger, localInteger, null, localByteStringMicro9, localInteger, localInteger, localInteger, localByteStringMicro10, localLong, localInteger, localInteger, localByteStringMicro11, localInteger, "", "", null, localInteger, localByteStringMicro12, localInteger, "", localInteger, localByteStringMicro13, localInteger, localInteger, "", localInteger }, ReqPublishVideo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqPublishVideo
 * JD-Core Version:    0.7.0.1
 */