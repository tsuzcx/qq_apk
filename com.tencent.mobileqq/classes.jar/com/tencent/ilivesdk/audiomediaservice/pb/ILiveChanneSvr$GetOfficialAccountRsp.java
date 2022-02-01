package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChanneSvr$GetOfficialAccountRsp
  extends MessageMicro<GetOfficialAccountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "official_account", "account_type", "is_nobility" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, GetOfficialAccountRsp.class);
  public final PBRepeatMessageField<ILiveChanneSvr.OfficialAccountType> account_type = PBField.initRepeatMessage(ILiveChanneSvr.OfficialAccountType.class);
  public final PBUInt32Field is_nobility = PBField.initUInt32(0);
  public final PBRepeatField<Long> official_account = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.GetOfficialAccountRsp
 * JD-Core Version:    0.7.0.1
 */