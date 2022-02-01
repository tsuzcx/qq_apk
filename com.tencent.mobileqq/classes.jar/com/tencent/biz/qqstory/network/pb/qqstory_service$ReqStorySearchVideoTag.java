package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqStorySearchVideoTag
  extends MessageMicro<ReqStorySearchVideoTag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "start_cookie", "size", "video_tag_name" }, new Object[] { "", Integer.valueOf(0), "" }, ReqStorySearchVideoTag.class);
  public final PBUInt32Field size = PBField.initUInt32(0);
  public final PBStringField start_cookie = PBField.initString("");
  public final PBStringField video_tag_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStorySearchVideoTag
 * JD-Core Version:    0.7.0.1
 */