package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransInterfaceTranslate$IntTransFailedRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_errcode", "str_errmsg" }, new Object[] { Integer.valueOf(0), "" }, IntTransFailedRsp.class);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate.IntTransFailedRsp
 * JD-Core Version:    0.7.0.1
 */