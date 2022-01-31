package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb49$ARClassifyLBSCheckRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "str_id", "uint32_lbs_result", "msg_nearest_point" }, new Object[] { "", Integer.valueOf(0), null }, ARClassifyLBSCheckRsp.class);
  public oidb_cmd0xb49.LBSPoint msg_nearest_point = new oidb_cmd0xb49.LBSPoint();
  public final PBStringField str_id = PBField.initString("");
  public final PBUInt32Field uint32_lbs_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49.ARClassifyLBSCheckRsp
 * JD-Core Version:    0.7.0.1
 */