package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenDetection$LightDetectReq
  extends MessageMicro<LightDetectReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField app_id = PBField.initString("");
  public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField session_id = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "app_id", "image", "url", "session_id" }, new Object[] { "", localByteStringMicro, "", "" }, LightDetectReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenDetection.LightDetectReq
 * JD-Core Version:    0.7.0.1
 */