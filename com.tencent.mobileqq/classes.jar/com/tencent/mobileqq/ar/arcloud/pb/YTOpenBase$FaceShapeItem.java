package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YTOpenBase$FaceShapeItem
  extends MessageMicro<FaceShapeItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 34, 42, 50, 58, 66, 74 }, new String[] { "face_profile", "left_eye", "right_eye", "left_eyebrow", "right_eyebrow", "mouth", "nose" }, new Object[] { null, null, null, null, null, null, null }, FaceShapeItem.class);
  public final PBRepeatMessageField<YTOpenBase.point> face_profile = PBField.initRepeatMessage(YTOpenBase.point.class);
  public final PBRepeatMessageField<YTOpenBase.point> left_eye = PBField.initRepeatMessage(YTOpenBase.point.class);
  public final PBRepeatMessageField<YTOpenBase.point> left_eyebrow = PBField.initRepeatMessage(YTOpenBase.point.class);
  public final PBRepeatMessageField<YTOpenBase.point> mouth = PBField.initRepeatMessage(YTOpenBase.point.class);
  public final PBRepeatMessageField<YTOpenBase.point> nose = PBField.initRepeatMessage(YTOpenBase.point.class);
  public final PBRepeatMessageField<YTOpenBase.point> right_eye = PBField.initRepeatMessage(YTOpenBase.point.class);
  public final PBRepeatMessageField<YTOpenBase.point> right_eyebrow = PBField.initRepeatMessage(YTOpenBase.point.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase.FaceShapeItem
 * JD-Core Version:    0.7.0.1
 */