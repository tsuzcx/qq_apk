package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ImageRetrievalLogic$RetrievalClassInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 25, 34, 40 }, new String[] { "iClass", "sClass", "dClassProb", "vItem", "iStatus" }, new Object[] { Integer.valueOf(0), "", Double.valueOf(0.0D), null, Integer.valueOf(0) }, RetrievalClassInfo.class);
  public final PBDoubleField dClassProb = PBField.initDouble(0.0D);
  public final PBInt32Field iClass = PBField.initInt32(0);
  public final PBInt32Field iStatus = PBField.initInt32(0);
  public final PBStringField sClass = PBField.initString("");
  public final PBRepeatMessageField vItem = PBField.initRepeatMessage(ImageRetrievalLogic.RetrievalItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.RetrievalClassInfo
 * JD-Core Version:    0.7.0.1
 */