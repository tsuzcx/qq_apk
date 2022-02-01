package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenDetection$DetectFaceReq
  extends MessageMicro<DetectFaceReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField app_id = PBField.initString("");
  public final PBInt32Field attr_flag = PBField.initInt32(255);
  public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field mode = PBField.initInt32(0);
  public final PBBoolField need_shape = PBField.initBool(true);
  public final PBStringField session_id = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 32, 40, 48, 66, 82 }, new String[] { "app_id", "image", "mode", "need_shape", "attr_flag", "url", "session_id" }, new Object[] { "", localByteStringMicro, Integer.valueOf(0), Boolean.valueOf(true), Integer.valueOf(255), "", "" }, DetectFaceReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenDetection.DetectFaceReq
 * JD-Core Version:    0.7.0.1
 */