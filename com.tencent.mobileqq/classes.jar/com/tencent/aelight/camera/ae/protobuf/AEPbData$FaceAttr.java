package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class AEPbData$FaceAttr
  extends MessageMicro<FaceAttr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField gender = PBField.initEnum(0);
  public AEPbData.Point2f mole_center = new AEPbData.Point2f();
  public final PBInt32Field roleID = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "gender", "mole_center", "roleID" }, new Object[] { localInteger, null, localInteger }, FaceAttr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.FaceAttr
 * JD-Core Version:    0.7.0.1
 */