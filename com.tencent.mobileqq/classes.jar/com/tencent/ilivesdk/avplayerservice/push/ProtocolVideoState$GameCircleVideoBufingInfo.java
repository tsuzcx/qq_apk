package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$GameCircleVideoBufingInfo
  extends MessageMicro<GameCircleVideoBufingInfo>
{
  public static final int UIN_FIELD_NUMBER = 3;
  public static final int UUID_FIELD_NUMBER = 1;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBBytesField uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "uuid", "VideoChanel", "uin" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, GameCircleVideoBufingInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.GameCircleVideoBufingInfo
 * JD-Core Version:    0.7.0.1
 */