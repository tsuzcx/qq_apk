package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenBase$FaceItem
  extends MessageMicro<FaceItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 37, 45, 48, 56, 64, 72, 80, 88, 96, 104, 165, 173, 181, 189, 242, 320, 328, 336 }, new String[] { "face_id", "x", "y", "height", "width", "pitch", "roll", "yaw", "age", "gender", "glass", "expression", "beauty", "rel_leftx", "rel_width", "rel_lefty", "rel_height", "face_shape", "glasses", "mask", "hat" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FaceItem.class);
  public final PBInt32Field age = PBField.initInt32(0);
  public final PBInt32Field beauty = PBField.initInt32(0);
  public final PBInt32Field expression = PBField.initInt32(0);
  public final PBStringField face_id = PBField.initString("");
  public YTOpenBase.FaceShapeItem face_shape = new YTOpenBase.FaceShapeItem();
  public final PBInt32Field gender = PBField.initInt32(0);
  public final PBBoolField glass = PBField.initBool(false);
  public final PBInt32Field glasses = PBField.initInt32(0);
  public final PBInt32Field hat = PBField.initInt32(0);
  public final PBFloatField height = PBField.initFloat(0.0F);
  public final PBInt32Field mask = PBField.initInt32(0);
  public final PBInt32Field pitch = PBField.initInt32(0);
  public final PBFloatField rel_height = PBField.initFloat(0.0F);
  public final PBFloatField rel_leftx = PBField.initFloat(0.0F);
  public final PBFloatField rel_lefty = PBField.initFloat(0.0F);
  public final PBFloatField rel_width = PBField.initFloat(0.0F);
  public final PBInt32Field roll = PBField.initInt32(0);
  public final PBFloatField width = PBField.initFloat(0.0F);
  public final PBInt32Field x = PBField.initInt32(0);
  public final PBInt32Field y = PBField.initInt32(0);
  public final PBInt32Field yaw = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase.FaceItem
 * JD-Core Version:    0.7.0.1
 */