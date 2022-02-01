package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientTransInfo$IntC2SJoinSessionReq
  extends MessageMicro<IntC2SJoinSessionReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_translate = PBField.initBool(false);
  public final PBEnumField enum_business_direction = PBField.initEnum(1);
  public final PBEnumField enum_data_source = PBField.initEnum(1);
  public final PBEnumField enum_net_type = PBField.initEnum(1);
  public final PBEnumField enum_term = PBField.initEnum(1);
  public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint32_client_ver", "enum_term", "enum_net_type", "uint32_client_port", "enum_business_direction", "enum_data_source", "bool_translate" }, new Object[] { localInteger1, localInteger2, localInteger2, localInteger1, localInteger2, localInteger2, Boolean.valueOf(false) }, IntC2SJoinSessionReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionReq
 * JD-Core Version:    0.7.0.1
 */