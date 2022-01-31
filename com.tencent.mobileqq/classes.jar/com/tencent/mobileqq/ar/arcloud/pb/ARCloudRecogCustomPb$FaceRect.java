package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ARCloudRecogCustomPb$FaceRect
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "face_rect_id", "face_origin_x", "face_origin_y", "face_size_w", "face_size_h" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FaceRect.class);
  public final PBInt32Field face_origin_x = PBField.initInt32(0);
  public final PBInt32Field face_origin_y = PBField.initInt32(0);
  public final PBInt32Field face_rect_id = PBField.initInt32(0);
  public final PBInt32Field face_size_h = PBField.initInt32(0);
  public final PBInt32Field face_size_w = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.FaceRect
 * JD-Core Version:    0.7.0.1
 */