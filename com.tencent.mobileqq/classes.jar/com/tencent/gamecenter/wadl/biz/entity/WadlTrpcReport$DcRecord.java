package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WadlTrpcReport$DcRecord
  extends MessageMicro<DcRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "dcId", "data" }, new Object[] { "", null }, DcRecord.class);
  public final PBRepeatMessageField<WadlTrpcReport.KV> data = PBField.initRepeatMessage(WadlTrpcReport.KV.class);
  public final PBStringField dcId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlTrpcReport.DcRecord
 * JD-Core Version:    0.7.0.1
 */