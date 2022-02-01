package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$GameCircleVideoNotifyInfo
  extends MessageMicro<GameCircleVideoNotifyInfo>
{
  public static final int LIVETYPE_FIELD_NUMBER = 5;
  public static final int OPERTYPE_FIELD_NUMBER = 3;
  public static final int SESSIONID_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 6;
  public static final int UUID_FIELD_NUMBER = 1;
  public static final int VIDEORESLIST_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field LiveType = PBField.initUInt32(0);
  public final PBUInt32Field OperType = PBField.initUInt32(0);
  public final PBRepeatMessageField<ProtocolVideoState.VideoResInfo> VideoResList = PBField.initRepeatMessage(ProtocolVideoState.VideoResInfo.class);
  public final PBBytesField sessionid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBBytesField uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48 }, new String[] { "uuid", "sessionid", "OperType", "VideoResList", "LiveType", "uin" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, null, localInteger, Long.valueOf(0L) }, GameCircleVideoNotifyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.GameCircleVideoNotifyInfo
 * JD-Core Version:    0.7.0.1
 */