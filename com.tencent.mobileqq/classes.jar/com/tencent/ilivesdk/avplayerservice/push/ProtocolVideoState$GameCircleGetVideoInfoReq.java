package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$GameCircleGetVideoInfoReq
  extends MessageMicro<GameCircleGetVideoInfoReq>
{
  public static final int OPEN_APPID_FIELD_NUMBER = 3;
  public static final int SESSIONID_FIELD_NUMBER = 2;
  public static final int UUID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field open_appid = PBField.initUInt64(0L);
  public final PBBytesField sessionid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "uuid", "sessionid", "open_appid" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L) }, GameCircleGetVideoInfoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.GameCircleGetVideoInfoReq
 * JD-Core Version:    0.7.0.1
 */