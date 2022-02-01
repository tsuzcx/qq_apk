package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$GameCircleSetVideoSwitchReq
  extends MessageMicro<GameCircleSetVideoSwitchReq>
{
  public static final int LIVETYPE_FIELD_NUMBER = 4;
  public static final int OPEN_APPID_FIELD_NUMBER = 5;
  public static final int OPERTYPE_FIELD_NUMBER = 3;
  public static final int SESSIONID_FIELD_NUMBER = 2;
  public static final int SESSION_GROUPID_FIELD_NUMBER = 7;
  public static final int UIN_FIELD_NUMBER = 8;
  public static final int UUID_FIELD_NUMBER = 1;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field LiveType = PBField.initUInt32(0);
  public final PBUInt32Field OperType = PBField.initUInt32(0);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  public final PBUInt64Field open_appid = PBField.initUInt64(0L);
  public final PBUInt32Field session_groupid = PBField.initUInt32(0);
  public final PBBytesField sessionid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBBytesField uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64 }, new String[] { "uuid", "sessionid", "OperType", "LiveType", "open_appid", "VideoChanel", "session_groupid", "uin" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, GameCircleSetVideoSwitchReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.GameCircleSetVideoSwitchReq
 * JD-Core Version:    0.7.0.1
 */