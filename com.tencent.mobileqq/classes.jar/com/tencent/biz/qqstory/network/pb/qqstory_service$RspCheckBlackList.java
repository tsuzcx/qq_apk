package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspCheckBlackList
  extends MessageMicro<RspCheckBlackList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "black_gps_list" }, new Object[] { null, null }, RspCheckBlackList.class);
  public final PBRepeatMessageField<qqstory_struct.GpsMsg> black_gps_list = PBField.initRepeatMessage(qqstory_struct.GpsMsg.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckBlackList
 * JD-Core Version:    0.7.0.1
 */