package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qav_gvideo_sdk_transfer$GAudioInfo
  extends MessageMicro<GAudioInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_multiBusiType = PBField.initUInt32(0);
  public final PBUInt32Field uint32_relationType = PBField.initUInt32(0);
  public final PBUInt32Field uint32_roomCreateTime = PBField.initUInt32(0);
  public final PBUInt64Field uint64_relationId = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_roomId = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_relationId", "uint32_relationType", "uint32_multiBusiType", "uint64_roomId", "uint32_roomCreateTime" }, new Object[] { localLong, localInteger, localInteger, localLong, localInteger }, GAudioInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qav_gvideo_sdk_transfer.GAudioInfo
 * JD-Core Version:    0.7.0.1
 */