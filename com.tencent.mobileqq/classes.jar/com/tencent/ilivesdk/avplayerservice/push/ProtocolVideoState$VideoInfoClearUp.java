package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$VideoInfoClearUp
  extends MessageMicro<VideoInfoClearUp>
{
  public static final int FATHERROOMID_FIELD_NUMBER = 7;
  public static final int MAINROOMID_FIELD_NUMBER = 6;
  public static final int REMOVEVIDEOINFOLIST_FIELD_NUMBER = 8;
  public static final int ROOMID_FIELD_NUMBER = 3;
  public static final int ROOMTYPE_FIELD_NUMBER = 4;
  public static final int SESSIONID_FIELD_NUMBER = 2;
  public static final int SESSION_GROUPID_FIELD_NUMBER = 5;
  public static final int VIDEO_KIND_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field FatherRoomID = PBField.initUInt64(0L);
  public final PBUInt64Field MainRoomID = PBField.initUInt64(0L);
  public final PBRepeatMessageField<ProtocolVideoState.VideoPlayInfo.VideoInfo> RemoveVideoInfoList = PBField.initRepeatMessage(ProtocolVideoState.VideoPlayInfo.VideoInfo.class);
  public final PBUInt64Field RoomID = PBField.initUInt64(0L);
  public final PBUInt32Field RoomType = PBField.initUInt32(0);
  public final PBUInt32Field session_groupid = PBField.initUInt32(0);
  public final PBBytesField sessionid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_kind = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 66 }, new String[] { "video_kind", "sessionid", "RoomID", "RoomType", "session_groupid", "MainRoomID", "FatherRoomID", "RemoveVideoInfoList" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null }, VideoInfoClearUp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.VideoInfoClearUp
 * JD-Core Version:    0.7.0.1
 */