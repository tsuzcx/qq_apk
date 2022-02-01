package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class AEPbData$FaceInfo
  extends MessageMicro<FaceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public AEPbData.FacePose face_pose = new AEPbData.FacePose();
  public final PBRepeatField<Float> pos = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBRepeatField<Float> rc_face = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBRepeatField<Float> rc_leftEye = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBRepeatField<Float> rc_mouth = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBRepeatField<Float> rc_rightEye = PBField.initRepeat(PBFloatField.__repeatHelper__);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 29, 37, 45, 50 }, new String[] { "pos", "rc_face", "rc_leftEye", "rc_rightEye", "rc_mouth", "face_pose" }, new Object[] { localFloat, localFloat, localFloat, localFloat, localFloat, null }, FaceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.FaceInfo
 * JD-Core Version:    0.7.0.1
 */