package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChanneSvr$OfficialAccountType
  extends MessageMicro<OfficialAccountType>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "account", "type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, OfficialAccountType.class);
  public final PBUInt64Field account = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.OfficialAccountType
 * JD-Core Version:    0.7.0.1
 */