package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARCloudRecogCustomPb$ARWordDetectInfo
  extends MessageMicro<ARWordDetectInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uin32_get_ocr_class = PBField.initUInt32(0);
  public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin32_timeout_ms", "uin32_get_ocr_class" }, new Object[] { localInteger, localInteger }, ARWordDetectInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARWordDetectInfo
 * JD-Core Version:    0.7.0.1
 */