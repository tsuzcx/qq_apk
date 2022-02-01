package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetPublishConfig
  extends MessageMicro<RspGetPublishConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field can_take_picture = PBField.initUInt32(0);
  public final PBUInt32Field is_firsttime_show_take_pic = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt32Field show_now_entry = PBField.initUInt32(0);
  public final PBUInt32Field video_use_bdh = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "result", "show_now_entry", "can_take_picture", "is_firsttime_show_take_pic", "video_use_bdh" }, new Object[] { null, localInteger, localInteger, localInteger, localInteger }, RspGetPublishConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPublishConfig
 * JD-Core Version:    0.7.0.1
 */