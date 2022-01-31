package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ARCloudRecogCustomPb$ARObjectClassifyResult
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ar_object_classify_errorcode", "ar_object_classify_errormsg", "image_ar_search_res" }, new Object[] { Integer.valueOf(0), "", null }, ARObjectClassifyResult.class);
  public final PBInt32Field ar_object_classify_errorcode = PBField.initInt32(0);
  public final PBStringField ar_object_classify_errormsg = PBField.initString("");
  public ARCloudRecogCustomPb.ImageARSearchRes image_ar_search_res = new ARCloudRecogCustomPb.ImageARSearchRes();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARObjectClassifyResult
 * JD-Core Version:    0.7.0.1
 */