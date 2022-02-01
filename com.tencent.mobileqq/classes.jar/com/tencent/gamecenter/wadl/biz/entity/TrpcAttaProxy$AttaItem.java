package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TrpcAttaProxy$AttaItem
  extends MessageMicro<AttaItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26 }, new String[] { "attaId", "valueList" }, new Object[] { "", null }, AttaItem.class);
  public final PBStringField attaId = PBField.initString("");
  public final PBRepeatMessageField<TrpcAttaProxy.AttaValue> valueList = PBField.initRepeatMessage(TrpcAttaProxy.AttaValue.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.TrpcAttaProxy.AttaItem
 * JD-Core Version:    0.7.0.1
 */