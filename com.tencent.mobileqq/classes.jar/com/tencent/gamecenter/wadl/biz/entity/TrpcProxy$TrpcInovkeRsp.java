package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class TrpcProxy$TrpcInovkeRsp
  extends MessageMicro<TrpcInovkeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField errType = PBField.initEnum(0);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "data", "errType", "ret", "msg" }, new Object[] { localByteStringMicro, localInteger, localInteger, "" }, TrpcInovkeRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp
 * JD-Core Version:    0.7.0.1
 */