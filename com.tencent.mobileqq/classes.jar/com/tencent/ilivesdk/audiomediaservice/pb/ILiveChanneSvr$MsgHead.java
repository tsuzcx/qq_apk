package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChanneSvr$MsgHead
  extends MessageMicro<MsgHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "send_uin", "to_uin", "random", "timestamp", "sync_other_machine", "as_admin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Boolean.valueOf(false) }, MsgHead.class);
  public final PBBoolField as_admin = PBField.initBool(false);
  public final PBUInt32Field random = PBField.initUInt32(0);
  public final PBUInt64Field send_uin = PBField.initUInt64(0L);
  public final PBUInt32Field sync_other_machine = PBField.initUInt32(2);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
  public final PBRepeatField<Long> to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.MsgHead
 * JD-Core Version:    0.7.0.1
 */