package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_service$RspGetUserVideoInfo
  extends MessageMicro<RspGetUserVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "result", "video_info", "base_info" }, new Object[] { null, null, null }, RspGetUserVideoInfo.class);
  public qqstory_struct.StoryVideoBasicInfo base_info = new qqstory_struct.StoryVideoBasicInfo();
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public qqstory_struct.StoryVideoDes video_info = new qqstory_struct.StoryVideoDes();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserVideoInfo
 * JD-Core Version:    0.7.0.1
 */