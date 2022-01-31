package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ARCloudRecogCustomPb$ARFaceRecogRes
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "errorcode", "errormsg", "session_id", "star_info", "time_ms", "group_size" }, new Object[] { Integer.valueOf(0), "", "", null, Integer.valueOf(0), Integer.valueOf(0) }, ARFaceRecogRes.class);
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBInt32Field group_size = PBField.initInt32(0);
  public final PBStringField session_id = PBField.initString("");
  public final PBRepeatMessageField star_info = PBField.initRepeatMessage(ARCloudRecogCustomPb.StarInfo.class);
  public final PBInt32Field time_ms = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARFaceRecogRes
 * JD-Core Version:    0.7.0.1
 */