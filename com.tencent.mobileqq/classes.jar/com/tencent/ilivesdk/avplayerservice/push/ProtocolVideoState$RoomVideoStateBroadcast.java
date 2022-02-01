package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$RoomVideoStateBroadcast
  extends MessageMicro<RoomVideoStateBroadcast>
{
  public static final int AV_TYPE_CHANGE_FIELD_NUMBER = 10;
  public static final int CLOSEDESCRIPTION_FIELD_NUMBER = 9;
  public static final int CLOSETYPE_FIELD_NUMBER = 8;
  public static final int LIVETYPE_FIELD_NUMBER = 5;
  public static final int OPERTYPE_FIELD_NUMBER = 4;
  public static final int PLAYINGINFOS_FIELD_NUMBER = 6;
  public static final int ROOMID_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 1;
  public static final int USERTYPE_FIELD_NUMBER = 3;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField CloseDescription = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField CloseType = PBField.initEnum(10);
  public final PBInt32Field LiveType = PBField.initInt32(0);
  public final PBInt32Field OperType = PBField.initInt32(0);
  public ProtocolVideoState.VideoLiveInfo PlayingInfos = new ProtocolVideoState.VideoLiveInfo();
  public final PBUInt64Field RoomID = PBField.initUInt64(0L);
  public final PBUInt64Field Uin = PBField.initUInt64(0L);
  public final PBInt32Field UserType = PBField.initInt32(0);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  public final PBUInt32Field av_type_change = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64, 74, 80 }, new String[] { "Uin", "RoomID", "UserType", "OperType", "LiveType", "PlayingInfos", "VideoChanel", "CloseType", "CloseDescription", "av_type_change" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, null, localInteger, Integer.valueOf(10), localByteStringMicro, localInteger }, RoomVideoStateBroadcast.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.RoomVideoStateBroadcast
 * JD-Core Version:    0.7.0.1
 */