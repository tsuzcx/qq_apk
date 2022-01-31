package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$ReqBatchGetPOIList
  extends MessageMicro<ReqBatchGetPOIList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gps" }, new Object[] { null }, ReqBatchGetPOIList.class);
  public final PBRepeatMessageField<qqstory_struct.GpsMsg> gps = PBField.initRepeatMessage(qqstory_struct.GpsMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetPOIList
 * JD-Core Version:    0.7.0.1
 */