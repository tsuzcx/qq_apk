package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiHeadUrl$MultiBusidUrlRsp
  extends MessageMicro<MultiBusidUrlRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field dstUidType = PBField.initUInt32(0);
  public final PBRepeatMessageField<MultiHeadUrl.RspUsrHeadInfo> dstUsrHeadInfos = PBField.initRepeatMessage(MultiHeadUrl.RspUsrHeadInfo.class);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBStringField srcOpenid = PBField.initString("");
  public final PBUInt64Field srcTid = PBField.initUInt64(0L);
  public final PBUInt32Field srcUidType = PBField.initUInt32(0);
  public final PBUInt64Field srcUin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "srcUidType", "srcUin", "srcTid", "srcOpenid", "result", "dstUidType", "dstUsrHeadInfos" }, new Object[] { localInteger, localLong, localLong, "", localInteger, localInteger, null }, MultiBusidUrlRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp
 * JD-Core Version:    0.7.0.1
 */