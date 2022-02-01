package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARCloudRecogCustomPb$GetIdentityRsp
  extends MessageMicro<GetIdentityRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_game_id = PBField.initEnum(0);
  public final PBUInt32Field uint32_confirmed = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enum_game_id", "uint32_confirmed" }, new Object[] { localInteger, localInteger }, GetIdentityRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.GetIdentityRsp
 * JD-Core Version:    0.7.0.1
 */