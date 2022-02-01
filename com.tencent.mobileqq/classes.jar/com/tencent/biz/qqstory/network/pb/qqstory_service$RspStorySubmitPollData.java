package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$RspStorySubmitPollData
  extends MessageMicro<RspStorySubmitPollData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field comment_id = PBField.initUInt32(0);
  public final PBUInt64Field fake_id = PBField.initUInt64(0L);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatField<Integer> video_poll_result = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "result", "video_poll_result", "comment_id", "fake_id" }, new Object[] { null, localInteger, localInteger, Long.valueOf(0L) }, RspStorySubmitPollData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitPollData
 * JD-Core Version:    0.7.0.1
 */