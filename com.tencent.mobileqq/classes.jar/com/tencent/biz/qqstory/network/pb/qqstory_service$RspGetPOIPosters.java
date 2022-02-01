package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspGetPOIPosters
  extends MessageMicro<RspGetPOIPosters>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "poi_posters" }, new Object[] { null, null }, RspGetPOIPosters.class);
  public final PBRepeatMessageField<qqstory_struct.POIPosterData> poi_posters = PBField.initRepeatMessage(qqstory_struct.POIPosterData.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIPosters
 * JD-Core Version:    0.7.0.1
 */