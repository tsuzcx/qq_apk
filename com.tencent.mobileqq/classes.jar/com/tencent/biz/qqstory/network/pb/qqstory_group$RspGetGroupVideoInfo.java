package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_group$RspGetGroupVideoInfo
  extends MessageMicro<RspGetGroupVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "video_list" }, new Object[] { null, null }, RspGetGroupVideoInfo.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_group.VideoInfoItem> video_list = PBField.initRepeatMessage(qqstory_group.VideoInfoItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupVideoInfo
 * JD-Core Version:    0.7.0.1
 */