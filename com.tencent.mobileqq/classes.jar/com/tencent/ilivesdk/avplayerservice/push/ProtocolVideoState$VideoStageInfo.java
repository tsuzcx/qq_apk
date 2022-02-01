package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$VideoStageInfo
  extends MessageMicro<VideoStageInfo>
{
  public static final int STAGEUIN_FIELD_NUMBER = 2;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "VideoChanel", "StageUin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, VideoStageInfo.class);
  public final PBUInt64Field StageUin = PBField.initUInt64(0L);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.VideoStageInfo
 * JD-Core Version:    0.7.0.1
 */