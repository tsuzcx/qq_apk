package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenDetection$LightDetectRsp
  extends MessageMicro<LightDetectRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "session_id", "score", "lr_gram_dif", "lr_dif", "face_whole", "face_dif", "errorcode", "errormsg" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, LightDetectRsp.class);
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBInt32Field face_dif = PBField.initInt32(0);
  public final PBInt32Field face_whole = PBField.initInt32(0);
  public final PBInt32Field lr_dif = PBField.initInt32(0);
  public final PBInt32Field lr_gram_dif = PBField.initInt32(0);
  public final PBInt32Field score = PBField.initInt32(0);
  public final PBStringField session_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenDetection.LightDetectRsp
 * JD-Core Version:    0.7.0.1
 */