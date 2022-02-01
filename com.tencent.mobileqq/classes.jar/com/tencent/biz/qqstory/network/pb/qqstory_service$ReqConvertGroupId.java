package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqConvertGroupId
  extends MessageMicro<ReqConvertGroupId>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "convert_from", "group_req_list" }, new Object[] { Integer.valueOf(0), null }, ReqConvertGroupId.class);
  public final PBUInt32Field convert_from = PBField.initUInt32(0);
  public final PBRepeatMessageField<qqstory_struct.GroupId> group_req_list = PBField.initRepeatMessage(qqstory_struct.GroupId.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqConvertGroupId
 * JD-Core Version:    0.7.0.1
 */