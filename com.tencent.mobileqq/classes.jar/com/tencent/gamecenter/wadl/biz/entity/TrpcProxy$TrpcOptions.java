package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TrpcProxy$TrpcOptions
  extends MessageMicro<TrpcOptions>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField calleeMethod = PBField.initString("");
  public final PBStringField callerServiceName = PBField.initString("");
  public final PBEnumField compressType = PBField.initEnum(0);
  public final PBBoolField connectionMode = PBField.initBool(false);
  public final PBEnumField currentCompressType = PBField.initEnum(0);
  public final PBEnumField currentSerializationType = PBField.initEnum(0);
  public final PBBoolField disableConnectionPool = PBField.initBool(false);
  public final PBBoolField disableFilter = PBField.initBool(false);
  public final PBBoolField disableServiceRouter = PBField.initBool(false);
  public final PBRepeatMessageField<TrpcProxy.TrpcMetaData> metaData2 = PBField.initRepeatMessage(TrpcProxy.TrpcMetaData.class);
  public final PBStringField nameSpace = PBField.initString("");
  public final PBStringField network = PBField.initString("");
  public final PBStringField password = PBField.initString("");
  public final PBEnumField requestType = PBField.initEnum(0);
  public final PBEnumField serializationType = PBField.initEnum(0);
  public final PBStringField serviceName = PBField.initString("");
  public final PBStringField target = PBField.initString("");
  public final PBInt64Field timeout = PBField.initInt64(0L);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 48, 58, 66, 74, 80, 88, 96, 106, 114, 120, 128, 136, 144, 154 }, new String[] { "target", "nameSpace", "timeout", "serializationType", "currentSerializationType", "serviceName", "calleeMethod", "callerServiceName", "currentCompressType", "compressType", "disableFilter", "password", "network", "requestType", "connectionMode", "disableConnectionPool", "disableServiceRouter", "metaData2" }, new Object[] { "", "", Long.valueOf(0L), localInteger, localInteger, "", "", "", localInteger, localInteger, localBoolean, "", "", localInteger, localBoolean, localBoolean, localBoolean, null }, TrpcOptions.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcOptions
 * JD-Core Version:    0.7.0.1
 */