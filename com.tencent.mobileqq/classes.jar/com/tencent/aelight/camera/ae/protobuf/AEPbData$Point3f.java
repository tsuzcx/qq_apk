package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;

public final class AEPbData$Point3f
  extends MessageMicro<Point3f>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField x = PBField.initFloat(0.0F);
  public final PBFloatField y = PBField.initFloat(0.0F);
  public final PBFloatField z = PBField.initFloat(0.0F);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 29 }, new String[] { "x", "y", "z" }, new Object[] { localFloat, localFloat, localFloat }, Point3f.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.Point3f
 * JD-Core Version:    0.7.0.1
 */