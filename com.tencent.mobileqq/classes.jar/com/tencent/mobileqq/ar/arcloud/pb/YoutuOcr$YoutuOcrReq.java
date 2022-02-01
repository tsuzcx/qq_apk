package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoutuOcr$YoutuOcrReq
  extends MessageMicro<YoutuOcrReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin32_timeout_ms", "language" }, new Object[] { Integer.valueOf(0), "" }, YoutuOcrReq.class);
  public final PBStringField language = PBField.initString("");
  public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrReq
 * JD-Core Version:    0.7.0.1
 */