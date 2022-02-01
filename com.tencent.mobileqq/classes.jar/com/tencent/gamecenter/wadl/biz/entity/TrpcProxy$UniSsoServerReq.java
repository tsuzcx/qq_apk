package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TrpcProxy$UniSsoServerReq
  extends MessageMicro<UniSsoServerReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public TrpcProxy.UniSsoServerReqComm comm = new TrpcProxy.UniSsoServerReqComm();
  public final PBBytesField pbReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField reqdata = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "comm", "reqdata", "pbReqData" }, new Object[] { null, "", localByteStringMicro }, UniSsoServerReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.UniSsoServerReq
 * JD-Core Version:    0.7.0.1
 */