package com.tencent.ilivesdk.roomservice.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbexit_heart_list_room$LeaveLiveRoomReq
  extends MessageMicro<LeaveLiveRoomReq>
{
  public static final int ROOMID_FIELD_NUMBER = 2;
  public static final int SIG_FIELD_NUMBER = 3;
  public static final int SUB_ROOMID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field sub_roomid = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "sub_roomid", "roomid", "sig" }, new Object[] { localInteger, localInteger, localByteStringMicro }, LeaveLiveRoomReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.pb.pbexit_heart_list_room.LeaveLiveRoomReq
 * JD-Core Version:    0.7.0.1
 */