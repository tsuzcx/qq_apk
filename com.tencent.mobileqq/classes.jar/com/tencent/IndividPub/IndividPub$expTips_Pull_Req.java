package com.tencent.IndividPub;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class IndividPub$expTips_Pull_Req
  extends MessageMicro<expTips_Pull_Req>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "from" }, new Object[] { Integer.valueOf(0) }, expTips_Pull_Req.class);
  public final PBUInt32Field from = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.IndividPub.IndividPub.expTips_Pull_Req
 * JD-Core Version:    0.7.0.1
 */