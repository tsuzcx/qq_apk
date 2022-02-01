package com.tencent.ilivesdk.service.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SwitchAndEnterRoom$NearRoomInfoCache
  extends MessageMicro<NearRoomInfoCache>
{
  public static final int ROOM_INFO_FIELD_NUMBER = 1;
  public static final int UPDATA_TIME_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "room_info", "updata_time" }, new Object[] { null, Integer.valueOf(0) }, NearRoomInfoCache.class);
  public final PBRepeatMessageField<SwitchAndEnterRoom.RoomInfo> room_info = PBField.initRepeatMessage(SwitchAndEnterRoom.RoomInfo.class);
  public final PBUInt32Field updata_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.service.pb.SwitchAndEnterRoom.NearRoomInfoCache
 * JD-Core Version:    0.7.0.1
 */