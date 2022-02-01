package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspBatchGetPOIList
  extends MessageMicro<RspBatchGetPOIList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "poi_list" }, new Object[] { null, null }, RspBatchGetPOIList.class);
  public final PBRepeatMessageField<qqstory_service.POI> poi_list = PBField.initRepeatMessage(qqstory_service.POI.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetPOIList
 * JD-Core Version:    0.7.0.1
 */