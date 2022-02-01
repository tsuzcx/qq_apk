package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ProtocolVideoState$GameCircleGetVideoInfoRes
  extends MessageMicro<GameCircleGetVideoInfoRes>
{
  public static final int SESSIONID_FIELD_NUMBER = 1;
  public static final int VIDEOBUFINGINFOS_FIELD_NUMBER = 3;
  public static final int VIDEOPLAYINGINFOS_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<ProtocolVideoState.GameCircleVideoBufingInfo> VideoBufingInfos = PBField.initRepeatMessage(ProtocolVideoState.GameCircleVideoBufingInfo.class);
  public final PBRepeatMessageField<ProtocolVideoState.GameCircleVideoLiveInfo> VideoPlayingInfos = PBField.initRepeatMessage(ProtocolVideoState.GameCircleVideoLiveInfo.class);
  public final PBBytesField sessionid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "sessionid", "VideoPlayingInfos", "VideoBufingInfos" }, new Object[] { localByteStringMicro, null, null }, GameCircleGetVideoInfoRes.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.GameCircleGetVideoInfoRes
 * JD-Core Version:    0.7.0.1
 */