package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenDetection$FaceShapeReq
  extends MessageMicro<FaceShapeReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField app_id = PBField.initString("");
  public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field mode = PBField.initInt32(0);
  public final PBBoolField ret_image = PBField.initBool(false);
  public final PBStringField session_id = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 32, 40, 66, 82 }, new String[] { "app_id", "image", "mode", "ret_image", "url", "session_id" }, new Object[] { "", localByteStringMicro, Integer.valueOf(0), Boolean.valueOf(false), "", "" }, FaceShapeReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenDetection.FaceShapeReq
 * JD-Core Version:    0.7.0.1
 */