package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARCloudRecogCustomPb$ARFaceRegInfo
  extends MessageMicro<ARFaceRegInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_img_cnt", "uin32_timeout_ms", "person_id", "person_name", "group_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, ARFaceRegInfo.class);
  public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField person_id = PBField.initString("");
  public final PBStringField person_name = PBField.initString("");
  public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  public final PBUInt32Field uint32_img_cnt = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARFaceRegInfo
 * JD-Core Version:    0.7.0.1
 */