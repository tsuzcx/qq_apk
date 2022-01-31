package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspGetConfig
  extends MessageMicro<RspGetConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "result", "user_config", "pic_specs_list", "video_source_tag_list" }, new Object[] { null, null, null, null }, RspGetConfig.class);
  public final PBRepeatMessageField<qqstory_struct.PicSpecs> pic_specs_list = PBField.initRepeatMessage(qqstory_struct.PicSpecs.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_struct.UserConfig> user_config = PBField.initRepeatMessage(qqstory_struct.UserConfig.class);
  public final PBRepeatMessageField<qqstory_struct.VideoSourceTagInfo> video_source_tag_list = PBField.initRepeatMessage(qqstory_struct.VideoSourceTagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetConfig
 * JD-Core Version:    0.7.0.1
 */