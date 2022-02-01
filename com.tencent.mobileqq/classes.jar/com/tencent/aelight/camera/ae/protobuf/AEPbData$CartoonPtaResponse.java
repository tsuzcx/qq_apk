package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AEPbData$CartoonPtaResponse
  extends MessageMicro<CartoonPtaResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "code", "msg", "deltaHSV", "skeleton", "dressList", "blendshape", "faceAttr", "debugInfo" }, new Object[] { Integer.valueOf(0), "", null, null, null, null, null, null }, CartoonPtaResponse.class);
  public final PBRepeatMessageField<AEPbData.BlendItem> blendshape = PBField.initRepeatMessage(AEPbData.BlendItem.class);
  public final PBInt32Field code = PBField.initInt32(0);
  public AEPbData.DebugInfo debugInfo = new AEPbData.DebugInfo();
  public final PBRepeatMessageField<AEPbData.ColorItem> deltaHSV = PBField.initRepeatMessage(AEPbData.ColorItem.class);
  public final PBRepeatMessageField<AEPbData.DressItem> dressList = PBField.initRepeatMessage(AEPbData.DressItem.class);
  public AEPbData.FaceAttr faceAttr = new AEPbData.FaceAttr();
  public final PBStringField msg = PBField.initString("");
  public final PBRepeatMessageField<AEPbData.SkeletonItem> skeleton = PBField.initRepeatMessage(AEPbData.SkeletonItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.CartoonPtaResponse
 * JD-Core Version:    0.7.0.1
 */