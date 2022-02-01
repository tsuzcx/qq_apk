package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TrpcProxy$TrpcMetaData
  extends MessageMicro<TrpcMetaData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField key = PBField.initString("");
  public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", localByteStringMicro }, TrpcMetaData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcMetaData
 * JD-Core Version:    0.7.0.1
 */