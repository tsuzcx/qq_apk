package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspGetBatchVideoBasicInfoList
  extends MessageMicro<RspGetBatchVideoBasicInfoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "video_list" }, new Object[] { null, null }, RspGetBatchVideoBasicInfoList.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_struct.StoryVideoBasicInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoBasicInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchVideoBasicInfoList
 * JD-Core Version:    0.7.0.1
 */