package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ProtocolVideoState$GameCircleSetVideoSwitchResp
  extends MessageMicro<GameCircleSetVideoSwitchResp>
{
  public static final int ERRMSG_FIELD_NUMBER = 9;
  public static final int LIVETYPE_FIELD_NUMBER = 5;
  public static final int OPERTYPE_FIELD_NUMBER = 4;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SESSIONID_FIELD_NUMBER = 3;
  public static final int SESSION_GROUPID_FIELD_NUMBER = 8;
  public static final int UUID_FIELD_NUMBER = 2;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 6;
  public static final int VIDEOID_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField ErrMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field LiveType = PBField.initInt32(0);
  public final PBInt32Field OperType = PBField.initInt32(0);
  public final PBUInt32Field Result = PBField.initUInt32(0);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  public final PBUInt32Field VideoID = PBField.initUInt32(0);
  public final PBUInt32Field session_groupid = PBField.initUInt32(0);
  public final PBBytesField sessionid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74 }, new String[] { "Result", "uuid", "sessionid", "OperType", "LiveType", "VideoChanel", "VideoID", "session_groupid", "ErrMsg" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, GameCircleSetVideoSwitchResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.GameCircleSetVideoSwitchResp
 * JD-Core Version:    0.7.0.1
 */