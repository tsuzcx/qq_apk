package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspStorySearchVideoTag
  extends MessageMicro<RspStorySearchVideoTag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "video_tag_list", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), "" }, RspStorySearchVideoTag.class);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBStringField next_cookie = PBField.initString("");
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_struct.TagInfoBase> video_tag_list = PBField.initRepeatMessage(qqstory_struct.TagInfoBase.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySearchVideoTag
 * JD-Core Version:    0.7.0.1
 */