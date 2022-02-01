package com.tencent.ilivesdk.service.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SwitchAndEnterRoom$GetRoomListReq
  extends MessageMicro<GetRoomListReq>
{
  public static final int DIRECTION_FIELD_NUMBER = 4;
  public static final int EXT_FIELD_NUMBER = 6;
  public static final int NEXT_ROOM_ID_FIELD_NUMBER = 3;
  public static final int ROOM_ID_FIELD_NUMBER = 1;
  public static final int SEX_FIELD_NUMBER = 2;
  public static final int SOURCE_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field direction = PBField.initUInt32(0);
  public final PBBytesField ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field next_room_id = PBField.initUInt32(0);
  public final PBUInt32Field room_id = PBField.initUInt32(0);
  public final PBUInt32Field sex = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "room_id", "sex", "next_room_id", "direction", "source", "ext" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro }, GetRoomListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.service.pb.SwitchAndEnterRoom.GetRoomListReq
 * JD-Core Version:    0.7.0.1
 */