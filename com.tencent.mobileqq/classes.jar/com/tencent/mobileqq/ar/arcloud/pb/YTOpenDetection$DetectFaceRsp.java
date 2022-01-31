package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenDetection$DetectFaceRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 24, 32, 42, 48, 58 }, new String[] { "session_id", "image_height", "image_width", "face", "errorcode", "errormsg" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), "" }, DetectFaceRsp.class);
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBRepeatMessageField face = PBField.initRepeatMessage(YTOpenBase.FaceItem.class);
  public final PBInt32Field image_height = PBField.initInt32(0);
  public final PBInt32Field image_width = PBField.initInt32(0);
  public final PBStringField session_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenDetection.DetectFaceRsp
 * JD-Core Version:    0.7.0.1
 */