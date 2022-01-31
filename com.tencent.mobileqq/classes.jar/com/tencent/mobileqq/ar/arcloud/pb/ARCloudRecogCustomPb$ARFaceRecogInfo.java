package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARCloudRecogCustomPb$ARFaceRecogInfo
  extends MessageMicro<ARFaceRecogInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin32_timeout_ms", "face_rect" }, new Object[] { Integer.valueOf(0), null }, ARFaceRecogInfo.class);
  public final PBRepeatMessageField<ARCloudRecogCustomPb.FaceRect> face_rect = PBField.initRepeatMessage(ARCloudRecogCustomPb.FaceRect.class);
  public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARFaceRecogInfo
 * JD-Core Version:    0.7.0.1
 */