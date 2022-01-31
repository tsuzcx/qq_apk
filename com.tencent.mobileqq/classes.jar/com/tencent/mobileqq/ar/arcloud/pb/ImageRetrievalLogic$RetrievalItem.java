package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ImageRetrievalLogic$RetrievalItem
  extends MessageMicro<RetrievalItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBDoubleField dProb = PBField.initDouble(0.0D);
  public final PBInt32Field iAutoJump = PBField.initInt32(0);
  public final PBInt32Field iClass = PBField.initInt32(0);
  public final PBInt32Field iNeedCheckLBS = PBField.initInt32(0);
  public final PBInt32Field iSource = PBField.initInt32(0);
  public final PBBytesField sCdbRes = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField sClass = PBField.initString("");
  public final PBStringField sImageId = PBField.initString("");
  public final PBStringField sItemID = PBField.initString("");
  public final PBStringField sJumpUrl = PBField.initString("");
  public final PBStringField sPicUrl = PBField.initString("");
  public final PBStringField sTitle = PBField.initString("");
  public final PBStringField sWiki = PBField.initString("");
  public ImageRetrievalLogic.LabelSource stLabel = new ImageRetrievalLogic.LabelSource();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 25, 34, 42, 48, 58, 64, 810, 818, 826, 834, 840, 850 }, new String[] { "iClass", "sClass", "dProb", "sItemID", "stLabel", "iSource", "sPicUrl", "iAutoJump", "sTitle", "sWiki", "sJumpUrl", "sCdbRes", "iNeedCheckLBS", "sImageId" }, new Object[] { Integer.valueOf(0), "", Double.valueOf(0.0D), "", null, Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", localByteStringMicro, Integer.valueOf(0), "" }, RetrievalItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic.RetrievalItem
 * JD-Core Version:    0.7.0.1
 */