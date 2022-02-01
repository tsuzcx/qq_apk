package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientTransInfo$IntC2SChangeSessionReq
  extends MessageMicro<IntC2SChangeSessionReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_translate = PBField.initBool(false);
  public final PBEnumField enum_business_direction = PBField.initEnum(1);
  public final PBEnumField enum_data_source = PBField.initEnum(1);
  public final PBEnumField enum_net_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "enum_net_type", "uint32_client_port", "enum_business_direction", "enum_data_source", "bool_translate" }, new Object[] { localInteger, Integer.valueOf(0), localInteger, localInteger, Boolean.valueOf(false) }, IntC2SChangeSessionReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionReq
 * JD-Core Version:    0.7.0.1
 */