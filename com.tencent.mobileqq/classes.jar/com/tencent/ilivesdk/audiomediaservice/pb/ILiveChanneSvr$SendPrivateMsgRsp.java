package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ILiveChanneSvr$SendPrivateMsgRsp
  extends MessageMicro<SendPrivateMsgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "errcode", "errmsg" }, new Object[] { Integer.valueOf(0), "" }, SendPrivateMsgRsp.class);
  public final PBInt32Field errcode = PBField.initInt32(0);
  public final PBStringField errmsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.SendPrivateMsgRsp
 * JD-Core Version:    0.7.0.1
 */