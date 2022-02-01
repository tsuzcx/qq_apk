package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TrpcProxy$TrpcListRsp
  extends MessageMicro<TrpcListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField errType = PBField.initEnum(0);
  public final PBRepeatMessageField<TrpcProxy.TrpcInovkeRsp> list = PBField.initRepeatMessage(TrpcProxy.TrpcInovkeRsp.class);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "list", "errType", "ret", "msg" }, new Object[] { null, localInteger, localInteger, "" }, TrpcListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListRsp
 * JD-Core Version:    0.7.0.1
 */