package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$SetVideoSwitchResp
  extends MessageMicro<SetVideoSwitchResp>
{
  public static final int CLIENTTYPE_FIELD_NUMBER = 4;
  public static final int ERRMSG_FIELD_NUMBER = 9;
  public static final int LIVETYPE_FIELD_NUMBER = 6;
  public static final int OPERTYPE_FIELD_NUMBER = 5;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int ROOMID_FIELD_NUMBER = 3;
  public static final int UIN_FIELD_NUMBER = 2;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 7;
  public static final int VIDEOID_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ClientType = PBField.initUInt32(0);
  public final PBBytesField ErrMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field LiveType = PBField.initInt32(0);
  public final PBInt32Field OperType = PBField.initInt32(0);
  public final PBUInt32Field Result = PBField.initUInt32(0);
  public final PBUInt64Field RoomID = PBField.initUInt64(0L);
  public final PBUInt64Field Uin = PBField.initUInt64(0L);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  public final PBUInt32Field VideoID = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "Result", "Uin", "RoomID", "ClientType", "OperType", "LiveType", "VideoChanel", "VideoID", "ErrMsg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, SetVideoSwitchResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.SetVideoSwitchResp
 * JD-Core Version:    0.7.0.1
 */