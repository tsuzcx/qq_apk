package com.tencent.ilivesdk.roomservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbexit_heart_list_room$UserHeartBeatReq
  extends MessageMicro<UserHeartBeatReq>
{
  public static final int MACHINE_CODE_FIELD_NUMBER = 3;
  public static final int ROOMID_FIELD_NUMBER = 2;
  public static final int SUB_ROOMID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "sub_roomid", "roomid", "machine_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, UserHeartBeatReq.class);
  public final PBStringField machine_code = PBField.initString("");
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  public final PBUInt32Field sub_roomid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.pb.pbexit_heart_list_room.UserHeartBeatReq
 * JD-Core Version:    0.7.0.1
 */