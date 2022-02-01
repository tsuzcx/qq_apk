package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ProtocolVideoState$VideoResInfo
  extends MessageMicro<VideoResInfo>
{
  public static final int BITRATE_FIELD_NUMBER = 4;
  public static final int DEFINITION_FIELD_NUMBER = 5;
  public static final int HEIGHT_FIELD_NUMBER = 3;
  public static final int ORIGINALFLAG_FIELD_NUMBER = 6;
  public static final int VIDEOID_FIELD_NUMBER = 1;
  public static final int WIDTH_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "VideoID", "Width", "Height", "Bitrate", "definition", "OriginalFlag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VideoResInfo.class);
  public final PBUInt32Field Bitrate = PBField.initUInt32(0);
  public final PBUInt32Field Height = PBField.initUInt32(0);
  public final PBUInt32Field OriginalFlag = PBField.initUInt32(0);
  public final PBUInt32Field VideoID = PBField.initUInt32(0);
  public final PBUInt32Field Width = PBField.initUInt32(0);
  public final PBUInt32Field definition = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.VideoResInfo
 * JD-Core Version:    0.7.0.1
 */