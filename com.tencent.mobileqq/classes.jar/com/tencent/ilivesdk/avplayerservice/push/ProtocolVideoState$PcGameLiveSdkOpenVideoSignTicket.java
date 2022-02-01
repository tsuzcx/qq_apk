package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$PcGameLiveSdkOpenVideoSignTicket
  extends MessageMicro<PcGameLiveSdkOpenVideoSignTicket>
{
  public static final int CLIENTIP_FIELD_NUMBER = 2;
  public static final int EXPIRED_TIME_FIELD_NUMBER = 5;
  public static final int GAMEID_FIELD_NUMBER = 3;
  public static final int TIME_STAMP_FIELD_NUMBER = 4;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uin", "clientip", "gameid", "time_stamp", "expired_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PcGameLiveSdkOpenVideoSignTicket.class);
  public final PBUInt32Field clientip = PBField.initUInt32(0);
  public final PBUInt32Field expired_time = PBField.initUInt32(0);
  public final PBUInt32Field gameid = PBField.initUInt32(0);
  public final PBUInt32Field time_stamp = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.PcGameLiveSdkOpenVideoSignTicket
 * JD-Core Version:    0.7.0.1
 */