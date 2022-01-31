package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class device_lock_recommend_auth$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_uin", "uint32_seq", "uint32_ret", "rpt_msg_devicelist" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField<device_lock_recommend_auth.DeviceInfo> rpt_msg_devicelist = PBField.initRepeatMessage(device_lock_recommend_auth.DeviceInfo.class);
  public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ims.device_lock_recommend_auth.RspBody
 * JD-Core Version:    0.7.0.1
 */