package com.tencent.ilivesdk.service.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SwitchAndEnterRoom$GetRoomListRsp
  extends MessageMicro<GetRoomListRsp>
{
  public static final int INDEX_FIELD_NUMBER = 4;
  public static final int INTERVAL_FIELD_NUMBER = 2;
  public static final int IS_FIND_FIELD_NUMBER = 3;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int ROOM_LIST_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "result", "interval", "is_find", "index", "room_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, GetRoomListRsp.class);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt32Field interval = PBField.initUInt32(0);
  public final PBUInt32Field is_find = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBRepeatMessageField<SwitchAndEnterRoom.RoomInfo> room_list = PBField.initRepeatMessage(SwitchAndEnterRoom.RoomInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.service.pb.SwitchAndEnterRoom.GetRoomListRsp
 * JD-Core Version:    0.7.0.1
 */