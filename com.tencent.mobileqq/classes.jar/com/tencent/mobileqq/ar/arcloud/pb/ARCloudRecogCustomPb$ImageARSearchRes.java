package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ARCloudRecogCustomPb$ImageARSearchRes
  extends MessageMicro<ImageARSearchRes>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 66 }, new String[] { "errorcode", "errormsg", "session_id", "tags", "time_ms", "score", "kpt_num", "coordinate" }, new Object[] { Integer.valueOf(0), "", "", null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ImageARSearchRes.class);
  public ARCloudRecogCustomPb.Coordinate coordinate = new ARCloudRecogCustomPb.Coordinate();
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBInt32Field kpt_num = PBField.initInt32(0);
  public final PBInt32Field score = PBField.initInt32(0);
  public final PBStringField session_id = PBField.initString("");
  public final PBRepeatMessageField<ARCloudRecogCustomPb.ImageARTag> tags = PBField.initRepeatMessage(ARCloudRecogCustomPb.ImageARTag.class);
  public final PBInt32Field time_ms = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageARSearchRes
 * JD-Core Version:    0.7.0.1
 */