package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$ReqCheckBlackList
  extends MessageMicro<ReqCheckBlackList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gps_list" }, new Object[] { null }, ReqCheckBlackList.class);
  public final PBRepeatMessageField<qqstory_struct.GpsMsg> gps_list = PBField.initRepeatMessage(qqstory_struct.GpsMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCheckBlackList
 * JD-Core Version:    0.7.0.1
 */