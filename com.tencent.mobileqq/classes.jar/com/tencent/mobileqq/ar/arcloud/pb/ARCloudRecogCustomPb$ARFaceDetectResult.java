package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ARCloudRecogCustomPb$ARFaceDetectResult
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field ar_face_detect_errorcode = PBField.initInt32(0);
  public final PBStringField ar_face_detect_errormsg = PBField.initString("");
  public final PBRepeatField cdb_res = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public YTOpenDetection.DetectFaceRsp image_ar_face_detect_res = new YTOpenDetection.DetectFaceRsp();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "ar_face_detect_errorcode", "ar_face_detect_errormsg", "cdb_res", "image_ar_face_detect_res" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, null }, ARFaceDetectResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARFaceDetectResult
 * JD-Core Version:    0.7.0.1
 */