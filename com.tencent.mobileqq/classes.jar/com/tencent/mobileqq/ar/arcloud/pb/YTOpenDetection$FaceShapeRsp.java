package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenDetection$FaceShapeRsp
  extends MessageMicro<FaceShapeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBRepeatMessageField<YTOpenBase.FaceShapeItem> face_shape = PBField.initRepeatMessage(YTOpenBase.FaceShapeItem.class);
  public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field image_height = PBField.initInt32(0);
  public final PBInt32Field image_width = PBField.initInt32(0);
  public final PBStringField session_id = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58 }, new String[] { "session_id", "face_shape", "image_height", "image_width", "image", "errorcode", "errormsg" }, new Object[] { "", null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), "" }, FaceShapeRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenDetection.FaceShapeRsp
 * JD-Core Version:    0.7.0.1
 */