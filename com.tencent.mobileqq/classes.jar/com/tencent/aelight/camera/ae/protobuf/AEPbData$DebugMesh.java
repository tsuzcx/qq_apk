package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class AEPbData$DebugMesh
  extends MessageMicro<DebugMesh>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "mesh_points" }, new Object[] { null }, DebugMesh.class);
  public final PBRepeatMessageField<AEPbData.Point3f> mesh_points = PBField.initRepeatMessage(AEPbData.Point3f.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.DebugMesh
 * JD-Core Version:    0.7.0.1
 */