package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$VideoUrl
  extends MessageMicro<VideoUrl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "video_level", "video_url" }, new Object[] { Integer.valueOf(0), "" }, VideoUrl.class);
  public final PBUInt32Field video_level = PBField.initUInt32(0);
  public final PBStringField video_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoUrl
 * JD-Core Version:    0.7.0.1
 */