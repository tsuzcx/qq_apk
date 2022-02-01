package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_service$RspStoryCreateVideoTag
  extends MessageMicro<RspStoryCreateVideoTag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "tag_info" }, new Object[] { null, null }, RspStoryCreateVideoTag.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public qqstory_struct.TagInfoBase tag_info = new qqstory_struct.TagInfoBase();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryCreateVideoTag
 * JD-Core Version:    0.7.0.1
 */