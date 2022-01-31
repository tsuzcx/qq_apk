package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ARCloudRecogCustomPb$ARSceneClassifyResult
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ar_errorcode", "ar_errormsg", "image_ar_search_res" }, new Object[] { Integer.valueOf(0), "", null }, ARSceneClassifyResult.class);
  public final PBInt32Field ar_errorcode = PBField.initInt32(0);
  public final PBStringField ar_errormsg = PBField.initString("");
  public ARCloudRecogCustomPb.ImageARSearchRes image_ar_search_res = new ARCloudRecogCustomPb.ImageARSearchRes();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARSceneClassifyResult
 * JD-Core Version:    0.7.0.1
 */