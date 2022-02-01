package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ProtocolVideoState$NotifySubCmdChangeWhiteRoomCacheReq
  extends MessageMicro<NotifySubCmdChangeWhiteRoomCacheReq>
{
  public static final int CACHE_INDEX_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "cache_index" }, new Object[] { Integer.valueOf(0) }, NotifySubCmdChangeWhiteRoomCacheReq.class);
  public final PBUInt32Field cache_index = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.NotifySubCmdChangeWhiteRoomCacheReq
 * JD-Core Version:    0.7.0.1
 */