package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARCloudRecogCustomPb$SearchQuestionInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin32_timeout_ms", "uin64_pic_height", "uin64_pic_width" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, SearchQuestionInfo.class);
  public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  public final PBUInt64Field uin64_pic_height = PBField.initUInt64(0L);
  public final PBUInt64Field uin64_pic_width = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.SearchQuestionInfo
 * JD-Core Version:    0.7.0.1
 */