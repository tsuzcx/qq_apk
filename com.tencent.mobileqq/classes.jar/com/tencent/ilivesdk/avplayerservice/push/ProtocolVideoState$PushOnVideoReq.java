package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$PushOnVideoReq
  extends MessageMicro<PushOnVideoReq>
{
  public static final int DSTUIN_FIELD_NUMBER = 6;
  public static final int FATHERROOMID_FIELD_NUMBER = 12;
  public static final int LIVETYPE_FIELD_NUMBER = 10;
  public static final int MAINROOMID_FIELD_NUMBER = 11;
  public static final int OPERTYPE_FIELD_NUMBER = 1;
  public static final int ROOMID_FIELD_NUMBER = 4;
  public static final int ROOMSVRIP_FIELD_NUMBER = 8;
  public static final int ROOMTYPE_FIELD_NUMBER = 5;
  public static final int SIG_FIELD_NUMBER = 7;
  public static final int SRCUIN_FIELD_NUMBER = 2;
  public static final int SRCUSERTYPE_FIELD_NUMBER = 3;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 9;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field DstUin = PBField.initUInt64(0L);
  public final PBUInt64Field FatherRoomID = PBField.initUInt64(0L);
  public final PBUInt32Field LiveType = PBField.initUInt32(0);
  public final PBUInt64Field MainRoomID = PBField.initUInt64(0L);
  public final PBUInt32Field OperType = PBField.initUInt32(0);
  public final PBUInt64Field RoomID = PBField.initUInt64(0L);
  public final PBUInt32Field RoomSvrIP = PBField.initUInt32(0);
  public final PBUInt32Field RoomType = PBField.initUInt32(0);
  public final PBBytesField Sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field SrcUin = PBField.initUInt64(0L);
  public final PBUInt32Field SrcUserType = PBField.initUInt32(0);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 72, 80, 88, 96 }, new String[] { "OperType", "SrcUin", "SrcUserType", "RoomID", "RoomType", "DstUin", "Sig", "RoomSvrIP", "VideoChanel", "LiveType", "MainRoomID", "FatherRoomID" }, new Object[] { localInteger, localLong, localInteger, localLong, localInteger, localLong, localByteStringMicro, localInteger, localInteger, localInteger, localLong, localLong }, PushOnVideoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.PushOnVideoReq
 * JD-Core Version:    0.7.0.1
 */