package com.tencent.IndividPub;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class IndividPub$expTips_Pull_Rsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48 }, new String[] { "expFlag", "content", "clickText", "action", "url", "itemId" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", Integer.valueOf(0) }, expTips_Pull_Rsp.class);
  public final PBEnumField action = PBField.initEnum(0);
  public final PBStringField clickText = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field expFlag = PBField.initUInt32(0);
  public final PBUInt32Field itemId = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.IndividPub.IndividPub.expTips_Pull_Rsp
 * JD-Core Version:    0.7.0.1
 */