package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WadlTrpcReport$DcReportRequest
  extends MessageMicro<DcReportRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "record" }, new Object[] { null }, DcReportRequest.class);
  public final PBRepeatMessageField<WadlTrpcReport.DcRecord> record = PBField.initRepeatMessage(WadlTrpcReport.DcRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlTrpcReport.DcReportRequest
 * JD-Core Version:    0.7.0.1
 */