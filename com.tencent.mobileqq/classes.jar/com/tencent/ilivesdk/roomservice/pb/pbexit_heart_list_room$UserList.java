package com.tencent.ilivesdk.roomservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbexit_heart_list_room$UserList
  extends MessageMicro<UserList>
{
  public static final int CUR_TS_FIELD_NUMBER = 3;
  public static final int USER_INFO_FIELD_NUMBER = 2;
  public static final int USER_NUM_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "user_num", "user_info", "cur_ts" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, UserList.class);
  public final PBUInt32Field cur_ts = PBField.initUInt32(0);
  public final PBRepeatMessageField<pbexit_heart_list_room.UserInfo> user_info = PBField.initRepeatMessage(pbexit_heart_list_room.UserInfo.class);
  public final PBUInt32Field user_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.pb.pbexit_heart_list_room.UserList
 * JD-Core Version:    0.7.0.1
 */