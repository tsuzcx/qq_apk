package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$VideoPlayInfo$VideoInfo
  extends MessageMicro<VideoInfo>
{
  public static final int ALREADYTRANSFLAG_FIELD_NUMBER = 15;
  public static final int BUFFINGFLAG_FIELD_NUMBER = 6;
  public static final int GAMECIRCLELIVINGINFO_FIELD_NUMBER = 9;
  public static final int LIVETYPE_FIELD_NUMBER = 4;
  public static final int LIVINGINFO_FIELD_NUMBER = 5;
  public static final int PUSHONSTAGETIME_FIELD_NUMBER = 12;
  public static final int PUSHUIN_FIELD_NUMBER = 3;
  public static final int SETSOURCEFLAG_FIELD_NUMBER = 14;
  public static final int STAGEUIN_FIELD_NUMBER = 2;
  public static final int STAGEUSERTYPE_FIELD_NUMBER = 13;
  public static final int UPDATETIME_FIELD_NUMBER = 7;
  public static final int UUID_FIELD_NUMBER = 8;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 1;
  public static final int VIDEOSTARTTIME_FIELD_NUMBER = 16;
  public static final int VIDEOSVRINNERIP_FIELD_NUMBER = 10;
  public static final int VIDEOSVROUTERIP_FIELD_NUMBER = 11;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field AlreadyTransFlag = PBField.initUInt32(0);
  public final PBEnumField BuffingFlag = PBField.initEnum(1);
  public ProtocolVideoState.GameCircleVideoLiveInfo GameCircleLivingInfo = new ProtocolVideoState.GameCircleVideoLiveInfo();
  public final PBUInt32Field LiveType = PBField.initUInt32(0);
  public ProtocolVideoState.VideoLiveInfo LivingInfo = new ProtocolVideoState.VideoLiveInfo();
  public final PBUInt32Field PushOnStageTime = PBField.initUInt32(0);
  public final PBUInt64Field PushUin = PBField.initUInt64(0L);
  public final PBUInt32Field SetSourceFlag = PBField.initUInt32(0);
  public final PBUInt64Field StageUin = PBField.initUInt64(0L);
  public final PBUInt32Field StageUserType = PBField.initUInt32(0);
  public final PBUInt32Field UpdateTime = PBField.initUInt32(0);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  public final PBUInt32Field VideoStartTime = PBField.initUInt32(0);
  public final PBBytesField uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field videoSvrInnerIP = PBField.initUInt32(0);
  public final PBUInt32Field videoSvrOuterIP = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66, 74, 80, 88, 96, 104, 112, 120, 128 }, new String[] { "VideoChanel", "StageUin", "PushUin", "LiveType", "LivingInfo", "BuffingFlag", "UpdateTime", "uuid", "GameCircleLivingInfo", "videoSvrInnerIP", "videoSvrOuterIP", "PushOnStageTime", "StageUserType", "SetSourceFlag", "AlreadyTransFlag", "VideoStartTime" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.VideoPlayInfo.VideoInfo
 * JD-Core Version:    0.7.0.1
 */