package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARCloudRecogCustomPb$ARWordDetectInfo
  extends MessageMicro<ARWordDetectInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin32_timeout_ms", "uin32_get_ocr_class" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ARWordDetectInfo.class);
  public final PBUInt32Field uin32_get_ocr_class = PBField.initUInt32(0);
  public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARWordDetectInfo
 * JD-Core Version:    0.7.0.1
 */