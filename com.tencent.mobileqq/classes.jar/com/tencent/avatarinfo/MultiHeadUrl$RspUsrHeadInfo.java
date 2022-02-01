package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiHeadUrl$RspUsrHeadInfo
  extends MessageMicro<RspUsrHeadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<MultiHeadUrl.RspHeadInfo> dstHeadInfos = PBField.initRepeatMessage(MultiHeadUrl.RspHeadInfo.class);
  public final PBStringField dstOpenid = PBField.initString("");
  public final PBUInt64Field dstTid = PBField.initUInt64(0L);
  public final PBUInt64Field dstUin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "dstUin", "dstTid", "dstOpenid", "dstHeadInfos" }, new Object[] { localLong, localLong, "", null }, RspUsrHeadInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo
 * JD-Core Version:    0.7.0.1
 */