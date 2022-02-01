package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$SyncVideoPlayStat2RoomReq
  extends MessageMicro<SyncVideoPlayStat2RoomReq>
{
  public static final int PLAYSTATE_FIELD_NUMBER = 4;
  public static final int ROOMID_FIELD_NUMBER = 2;
  public static final int ROOMTYPE_FIELD_NUMBER = 3;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field PlayState = PBField.initUInt32(0);
  public final PBUInt64Field RoomID = PBField.initUInt64(0L);
  public final PBUInt32Field RoomType = PBField.initUInt32(0);
  public final PBUInt64Field Uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "Uin", "RoomID", "RoomType", "PlayState" }, new Object[] { localLong, localLong, localInteger, localInteger }, SyncVideoPlayStat2RoomReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.SyncVideoPlayStat2RoomReq
 * JD-Core Version:    0.7.0.1
 */