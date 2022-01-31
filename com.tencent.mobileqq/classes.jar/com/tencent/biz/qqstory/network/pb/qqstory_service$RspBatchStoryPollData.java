package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspBatchStoryPollData
  extends MessageMicro<RspBatchStoryPollData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "result", "poll_info_list", "rate_info_list", "qa_info_list" }, new Object[] { null, null, null, null }, RspBatchStoryPollData.class);
  public final PBRepeatMessageField<qqstory_struct.VidPollInfo> poll_info_list = PBField.initRepeatMessage(qqstory_struct.VidPollInfo.class);
  public final PBRepeatMessageField<qqstory_struct.VidQAInfo> qa_info_list = PBField.initRepeatMessage(qqstory_struct.VidQAInfo.class);
  public final PBRepeatMessageField<qqstory_struct.VidRateInfo> rate_info_list = PBField.initRepeatMessage(qqstory_struct.VidRateInfo.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchStoryPollData
 * JD-Core Version:    0.7.0.1
 */