package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$VideoLiveInfo
  extends MessageMicro<VideoLiveInfo>
{
  public static final int DEFAULTVIDEOID_FIELD_NUMBER = 11;
  public static final int FLASHURL_FIELD_NUMBER = 10;
  public static final int GAMEID_FIELD_NUMBER = 6;
  public static final int GENDER_FIELD_NUMBER = 2;
  public static final int LOGOTIMESTAMP_FIELD_NUMBER = 3;
  public static final int NICK_FIELD_NUMBER = 4;
  public static final int NOWTIME_FIELD_NUMBER = 5;
  public static final int UIN_FIELD_NUMBER = 8;
  public static final int USERTYPE_FIELD_NUMBER = 9;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 1;
  public static final int VIDEORESLIST_FIELD_NUMBER = 7;
  public static final int VIDEO_USE_P2P_FLAG_FIELD_NUMBER = 12;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field DefaultVideoID = PBField.initUInt32(0);
  public final PBBytesField FlashUrl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field GameID = PBField.initUInt32(0);
  public final PBUInt32Field Gender = PBField.initUInt32(0);
  public final PBUInt32Field LogoTimeStamp = PBField.initUInt32(0);
  public final PBBytesField Nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field NowTime = PBField.initUInt32(0);
  public final PBUInt64Field Uin = PBField.initUInt64(0L);
  public final PBUInt32Field UserType = PBField.initUInt32(0);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  public final PBRepeatMessageField<ProtocolVideoState.VideoResInfo> VideoResList = PBField.initRepeatMessage(ProtocolVideoState.VideoResInfo.class);
  public final PBUInt32Field video_use_p2p_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 64, 72, 82, 88, 96 }, new String[] { "VideoChanel", "Gender", "LogoTimeStamp", "Nick", "NowTime", "GameID", "VideoResList", "Uin", "UserType", "FlashUrl", "DefaultVideoID", "video_use_p2p_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, VideoLiveInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.VideoLiveInfo
 * JD-Core Version:    0.7.0.1
 */