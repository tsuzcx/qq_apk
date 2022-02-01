package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$RspStorySubmitRateData
  extends MessageMicro<RspStorySubmitRateData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field comment_id = PBField.initUInt32(0);
  public final PBUInt64Field fake_id = PBField.initUInt64(0L);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt32Field total_rate_count = PBField.initUInt32(0);
  public final PBUInt64Field total_rate_score = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "result", "total_rate_count", "total_rate_score", "comment_id", "fake_id" }, new Object[] { null, localInteger, localLong, localInteger, localLong }, RspStorySubmitRateData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitRateData
 * JD-Core Version:    0.7.0.1
 */