package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class TrpcAttaProxy$ReportAttaListReq
  extends MessageMicro<ReportAttaListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "attaList" }, new Object[] { null }, ReportAttaListReq.class);
  public final PBRepeatMessageField<TrpcAttaProxy.AttaItem> attaList = PBField.initRepeatMessage(TrpcAttaProxy.AttaItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.TrpcAttaProxy.ReportAttaListReq
 * JD-Core Version:    0.7.0.1
 */