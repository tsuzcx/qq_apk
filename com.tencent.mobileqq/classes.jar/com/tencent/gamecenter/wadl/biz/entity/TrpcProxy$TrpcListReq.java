package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class TrpcProxy$TrpcListReq
  extends MessageMicro<TrpcListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "list" }, new Object[] { null }, TrpcListReq.class);
  public final PBRepeatMessageField<TrpcProxy.TrpcInovkeReq> list = PBField.initRepeatMessage(TrpcProxy.TrpcInovkeReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq
 * JD-Core Version:    0.7.0.1
 */