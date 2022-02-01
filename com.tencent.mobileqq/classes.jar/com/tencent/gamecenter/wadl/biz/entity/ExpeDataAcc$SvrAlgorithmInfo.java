package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ExpeDataAcc$SvrAlgorithmInfo
  extends MessageMicro<SvrAlgorithmInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "algoritymId", "algorithmType", "traceId", "itemType" }, new Object[] { "", "", "", "" }, SvrAlgorithmInfo.class);
  public final PBStringField algorithmType = PBField.initString("");
  public final PBStringField algoritymId = PBField.initString("");
  public final PBStringField itemType = PBField.initString("");
  public final PBStringField traceId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.SvrAlgorithmInfo
 * JD-Core Version:    0.7.0.1
 */