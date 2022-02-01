package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$NotifyVideoArriveByVideoSvrReq
  extends MessageMicro<NotifyVideoArriveByVideoSvrReq>
{
  public static final int ROOMID_FIELD_NUMBER = 2;
  public static final int SESSIONID_FIELD_NUMBER = 7;
  public static final int UIN_FIELD_NUMBER = 1;
  public static final int UUID_FIELD_NUMBER = 8;
  public static final int VIDEOID_FIELD_NUMBER = 3;
  public static final int VIDEORATE_FIELD_NUMBER = 6;
  public static final int VIDEOSVRINNERIP_FIELD_NUMBER = 4;
  public static final int VIDEOSVROUTERIP_FIELD_NUMBER = 5;
  public static final int VIDEO_KIND_FIELD_NUMBER = 9;
  public static final int WILL_TRANS_FLAG_FIELD_NUMBER = 10;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field RoomID = PBField.initUInt64(0L);
  public final PBUInt64Field Uin = PBField.initUInt64(0L);
  public final PBUInt32Field VideoID = PBField.initUInt32(0);
  public final PBUInt32Field VideoRate = PBField.initUInt32(0);
  public final PBUInt32Field VideosvrInnerIP = PBField.initUInt32(0);
  public final PBUInt32Field VideosvrOuterIP = PBField.initUInt32(0);
  public final PBBytesField sessionid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_kind = PBField.initUInt32(0);
  public final PBUInt32Field will_trans_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 72, 80 }, new String[] { "Uin", "RoomID", "VideoID", "VideosvrInnerIP", "VideosvrOuterIP", "VideoRate", "sessionid", "uuid", "video_kind", "will_trans_flag" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localInteger }, NotifyVideoArriveByVideoSvrReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.NotifyVideoArriveByVideoSvrReq
 * JD-Core Version:    0.7.0.1
 */