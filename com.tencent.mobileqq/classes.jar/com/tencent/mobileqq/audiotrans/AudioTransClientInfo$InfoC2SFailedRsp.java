package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientInfo$InfoC2SFailedRsp
  extends MessageMicro<InfoC2SFailedRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_errcode", "str_errmsg" }, new Object[] { Integer.valueOf(0), "" }, InfoC2SFailedRsp.class);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInfo.InfoC2SFailedRsp
 * JD-Core Version:    0.7.0.1
 */