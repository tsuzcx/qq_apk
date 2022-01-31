package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARCloudRecogCommonPb$ARFileReqInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_file_name", "uint32_file_format" }, new Object[] { "", Integer.valueOf(0) }, ARFileReqInfo.class);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_file_format = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCommonPb.ARFileReqInfo
 * JD-Core Version:    0.7.0.1
 */