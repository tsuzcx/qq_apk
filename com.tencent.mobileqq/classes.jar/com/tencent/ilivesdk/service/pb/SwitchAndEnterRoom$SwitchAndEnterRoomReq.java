package com.tencent.ilivesdk.service.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SwitchAndEnterRoom$SwitchAndEnterRoomReq
  extends MessageMicro<SwitchAndEnterRoomReq>
{
  public static final int ENTER_ROOM_FIELD_NUMBER = 4;
  public static final int MACHINECODE_FIELD_NUMBER = 2;
  public static final int SWITCH_REQ_FIELD_NUMBER = 1;
  public static final int TS_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "switch_req", "machineCode", "ts", "enter_room" }, new Object[] { null, "", Long.valueOf(0L), Integer.valueOf(0) }, SwitchAndEnterRoomReq.class);
  public final PBUInt32Field enter_room = PBField.initUInt32(0);
  public final PBStringField machineCode = PBField.initString("");
  public SwitchAndEnterRoom.GetRoomListReq switch_req = new SwitchAndEnterRoom.GetRoomListReq();
  public final PBUInt64Field ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.service.pb.SwitchAndEnterRoom.SwitchAndEnterRoomReq
 * JD-Core Version:    0.7.0.1
 */