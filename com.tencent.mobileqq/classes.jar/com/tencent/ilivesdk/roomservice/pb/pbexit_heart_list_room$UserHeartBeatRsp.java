package com.tencent.ilivesdk.roomservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbexit_heart_list_room$UserHeartBeatRsp
  extends MessageMicro<UserHeartBeatRsp>
{
  public static final int INTERVAL_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "interval" }, new Object[] { Integer.valueOf(0) }, UserHeartBeatRsp.class);
  public final PBUInt32Field interval = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.pb.pbexit_heart_list_room.UserHeartBeatRsp
 * JD-Core Version:    0.7.0.1
 */