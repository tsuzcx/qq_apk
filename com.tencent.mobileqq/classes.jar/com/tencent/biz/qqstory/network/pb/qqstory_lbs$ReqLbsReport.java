package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_lbs$ReqLbsReport
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "list_data" }, new Object[] { null }, ReqLbsReport.class);
  public final PBRepeatMessageField list_data = PBField.initRepeatMessage(qqstory_lbs.LbsData.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_lbs.ReqLbsReport
 * JD-Core Version:    0.7.0.1
 */