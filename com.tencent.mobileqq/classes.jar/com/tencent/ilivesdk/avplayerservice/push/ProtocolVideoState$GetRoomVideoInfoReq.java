package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$GetRoomVideoInfoReq
  extends MessageMicro<GetRoomVideoInfoReq>
{
  public static final int DSTROOMID_FIELD_NUMBER = 5;
  public static final int ROOMID_FIELD_NUMBER = 2;
  public static final int ROOTROOMID_FIELD_NUMBER = 4;
  public static final int SIG_FIELD_NUMBER = 3;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field DstRoomID = PBField.initUInt64(0L);
  public final PBUInt64Field RoomID = PBField.initUInt64(0L);
  public final PBUInt64Field RootRoomID = PBField.initUInt64(0L);
  public final PBBytesField Sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field Uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "Uin", "RoomID", "Sig", "RootRoomID", "DstRoomID" }, new Object[] { localLong, localLong, localByteStringMicro, localLong, localLong }, GetRoomVideoInfoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.GetRoomVideoInfoReq
 * JD-Core Version:    0.7.0.1
 */