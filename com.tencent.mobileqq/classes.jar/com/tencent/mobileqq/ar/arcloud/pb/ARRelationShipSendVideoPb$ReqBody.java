package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARRelationShipSendVideoPb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_share_info", "rpt_uint64_to_uin" }, new Object[] { null, Long.valueOf(0L) }, ReqBody.class);
  public ARRelationShipSendVideoPb.shareInfo msg_share_info = new ARRelationShipSendVideoPb.shareInfo();
  public final PBRepeatField<Long> rpt_uint64_to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipSendVideoPb.ReqBody
 * JD-Core Version:    0.7.0.1
 */