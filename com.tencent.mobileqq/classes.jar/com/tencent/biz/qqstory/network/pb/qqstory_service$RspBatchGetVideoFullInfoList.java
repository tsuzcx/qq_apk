package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspBatchGetVideoFullInfoList
  extends MessageMicro<RspBatchGetVideoFullInfoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "result", "video_list", "interact_status" }, new Object[] { null, null, Integer.valueOf(0) }, RspBatchGetVideoFullInfoList.class);
  public final PBUInt32Field interact_status = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoFullInfoList
 * JD-Core Version:    0.7.0.1
 */