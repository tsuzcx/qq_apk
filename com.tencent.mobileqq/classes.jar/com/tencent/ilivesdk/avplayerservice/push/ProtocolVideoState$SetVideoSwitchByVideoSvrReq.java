package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$SetVideoSwitchByVideoSvrReq
  extends MessageMicro<SetVideoSwitchByVideoSvrReq>
{
  public static final int CLIENTTYPE_FIELD_NUMBER = 5;
  public static final int FATHERROOMID_FIELD_NUMBER = 3;
  public static final int GAMEID_FIELD_NUMBER = 11;
  public static final int GENDER_FIELD_NUMBER = 8;
  public static final int LIVETYPE_FIELD_NUMBER = 7;
  public static final int LOGOTIMESTAMP_FIELD_NUMBER = 9;
  public static final int NICK_FIELD_NUMBER = 10;
  public static final int OPERTYPE_FIELD_NUMBER = 6;
  public static final int ROOMID_FIELD_NUMBER = 4;
  public static final int ROOTROOMID_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 1;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 12;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ClientType = PBField.initUInt32(0);
  public final PBUInt64Field FatherRoomID = PBField.initUInt64(0L);
  public final PBUInt32Field GameID = PBField.initUInt32(0);
  public final PBUInt32Field Gender = PBField.initUInt32(0);
  public final PBEnumField LiveType = PBField.initEnum(0);
  public final PBUInt32Field LogoTimeStamp = PBField.initUInt32(0);
  public final PBBytesField Nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField OperType = PBField.initEnum(0);
  public final PBUInt64Field RoomID = PBField.initUInt64(0L);
  public final PBUInt64Field RootRoomID = PBField.initUInt64(0L);
  public final PBUInt64Field Uin = PBField.initUInt64(0L);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 96 }, new String[] { "Uin", "RootRoomID", "FatherRoomID", "RoomID", "ClientType", "OperType", "LiveType", "Gender", "LogoTimeStamp", "Nick", "GameID", "VideoChanel" }, new Object[] { localLong, localLong, localLong, localLong, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro, localInteger, localInteger }, SetVideoSwitchByVideoSvrReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.SetVideoSwitchByVideoSvrReq
 * JD-Core Version:    0.7.0.1
 */