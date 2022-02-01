package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class TrpcProxy$TrpcInovkeReq
  extends MessageMicro<TrpcInovkeReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
  public TrpcProxy.TrpcMsg msg = new TrpcProxy.TrpcMsg();
  public TrpcProxy.TrpcOptions options = new TrpcProxy.TrpcOptions();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "data", "msg", "options" }, new Object[] { localByteStringMicro, null, null }, TrpcInovkeReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeReq
 * JD-Core Version:    0.7.0.1
 */