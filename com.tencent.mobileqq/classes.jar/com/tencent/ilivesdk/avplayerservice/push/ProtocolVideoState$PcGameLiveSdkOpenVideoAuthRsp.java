package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$PcGameLiveSdkOpenVideoAuthRsp
  extends MessageMicro<PcGameLiveSdkOpenVideoAuthRsp>
{
  public static final int RESULT_FIELD_NUMBER = 2;
  public static final int SIGN_TICKET_FIELD_NUMBER = 3;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBBytesField sign_ticket = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "result", "sign_ticket" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, PcGameLiveSdkOpenVideoAuthRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.PcGameLiveSdkOpenVideoAuthRsp
 * JD-Core Version:    0.7.0.1
 */