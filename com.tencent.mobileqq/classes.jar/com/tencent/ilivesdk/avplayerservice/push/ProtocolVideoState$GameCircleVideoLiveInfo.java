package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$GameCircleVideoLiveInfo
  extends MessageMicro<GameCircleVideoLiveInfo>
{
  public static final int NOWTIME_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 5;
  public static final int UUID_FIELD_NUMBER = 4;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 1;
  public static final int VIDEORESLIST_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field NowTime = PBField.initUInt32(0);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  public final PBRepeatMessageField<ProtocolVideoState.VideoResInfo> VideoResList = PBField.initRepeatMessage(ProtocolVideoState.VideoResInfo.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBBytesField uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "VideoChanel", "NowTime", "VideoResList", "uuid", "uin" }, new Object[] { localInteger, localInteger, null, localByteStringMicro, Long.valueOf(0L) }, GameCircleVideoLiveInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.GameCircleVideoLiveInfo
 * JD-Core Version:    0.7.0.1
 */