package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransInterfaceTranslate$IntTransJoinSessionReq
  extends MessageMicro<IntTransJoinSessionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "enum_business_type", "msg_crypt_info", "bool_translate", "uint32_data_timeout" }, new Object[] { Integer.valueOf(1), null, Boolean.valueOf(false), Integer.valueOf(0) }, IntTransJoinSessionReq.class);
  public final PBBoolField bool_translate = PBField.initBool(false);
  public final PBEnumField enum_business_type = PBField.initEnum(1);
  public AudioTransCommon.AudioCryptInfo msg_crypt_info = new AudioTransCommon.AudioCryptInfo();
  public final PBUInt32Field uint32_data_timeout = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate.IntTransJoinSessionReq
 * JD-Core Version:    0.7.0.1
 */