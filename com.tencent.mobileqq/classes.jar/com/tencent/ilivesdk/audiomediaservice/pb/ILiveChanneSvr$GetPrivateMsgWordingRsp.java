package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ILiveChanneSvr$GetPrivateMsgWordingRsp
  extends MessageMicro<GetPrivateMsgWordingRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "wording", "relation" }, new Object[] { "", Integer.valueOf(0) }, GetPrivateMsgWordingRsp.class);
  public final PBUInt32Field relation = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.GetPrivateMsgWordingRsp
 * JD-Core Version:    0.7.0.1
 */