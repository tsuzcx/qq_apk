package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ProtocolVideoState$GetRoomVideoInfoRes
  extends MessageMicro<GetRoomVideoInfoRes>
{
  public static final int STAGEREADYINFOS_FIELD_NUMBER = 3;
  public static final int UINT32_LIVE_TYPE_FIELD_NUMBER = 6;
  public static final int VIDEOBUFINGINFOS_FIELD_NUMBER = 4;
  public static final int VIDEOPLAYINGINFOS_FIELD_NUMBER = 2;
  public static final int VIDEO_STATUS_FIELD_NUMBER = 5;
  public static final int WHITEROOMFLAG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<ProtocolVideoState.VideoStageInfo> StageReadyInfos = PBField.initRepeatMessage(ProtocolVideoState.VideoStageInfo.class);
  public final PBRepeatMessageField<ProtocolVideoState.VideoBufingInfo> VideoBufingInfos = PBField.initRepeatMessage(ProtocolVideoState.VideoBufingInfo.class);
  public final PBRepeatMessageField<ProtocolVideoState.VideoLiveInfo> VideoPlayingInfos = PBField.initRepeatMessage(ProtocolVideoState.VideoLiveInfo.class);
  public final PBUInt32Field WhiteRoomFlag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_live_type = PBField.initUInt32(0);
  public final PBUInt32Field video_status = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "WhiteRoomFlag", "VideoPlayingInfos", "StageReadyInfos", "VideoBufingInfos", "video_status", "uint32_live_type" }, new Object[] { localInteger, null, null, null, localInteger, localInteger }, GetRoomVideoInfoRes.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.GetRoomVideoInfoRes
 * JD-Core Version:    0.7.0.1
 */