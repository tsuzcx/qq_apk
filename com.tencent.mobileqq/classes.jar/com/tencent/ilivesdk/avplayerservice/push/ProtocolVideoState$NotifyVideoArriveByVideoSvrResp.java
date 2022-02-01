package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$NotifyVideoArriveByVideoSvrResp
  extends MessageMicro<NotifyVideoArriveByVideoSvrResp>
{
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int ROOMID_FIELD_NUMBER = 3;
  public static final int SESSIONID_FIELD_NUMBER = 5;
  public static final int UIN_FIELD_NUMBER = 2;
  public static final int UUID_FIELD_NUMBER = 6;
  public static final int VIDEOID_FIELD_NUMBER = 4;
  public static final int VIDEO_KIND_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field Result = PBField.initUInt32(0);
  public final PBUInt64Field RoomID = PBField.initUInt64(0L);
  public final PBUInt64Field Uin = PBField.initUInt64(0L);
  public final PBUInt32Field VideoID = PBField.initUInt32(0);
  public final PBBytesField sessionid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_kind = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56 }, new String[] { "Result", "Uin", "RoomID", "VideoID", "sessionid", "uuid", "video_kind" }, new Object[] { localInteger, localLong, localLong, localInteger, localByteStringMicro1, localByteStringMicro2, localInteger }, NotifyVideoArriveByVideoSvrResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.NotifyVideoArriveByVideoSvrResp
 * JD-Core Version:    0.7.0.1
 */