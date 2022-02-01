package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqGetConfig
  extends MessageMicro<ReqGetConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field get_pic_specs = PBField.initUInt32(0);
  public final PBUInt32Field get_video_tag_info = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "get_pic_specs", "get_video_tag_info" }, new Object[] { localInteger, localInteger }, ReqGetConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetConfig
 * JD-Core Version:    0.7.0.1
 */