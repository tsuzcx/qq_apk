package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_cmd0xb49$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82 }, new String[] { "int32_lat", "int32_lon", "msg_ar_classify_req" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), null }, ReqBody.class);
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  public oidb_cmd0xb49.ARClassifyLBSCheckReq msg_ar_classify_req = new oidb_cmd0xb49.ARClassifyLBSCheckReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.ReqBody
 * JD-Core Version:    0.7.0.1
 */