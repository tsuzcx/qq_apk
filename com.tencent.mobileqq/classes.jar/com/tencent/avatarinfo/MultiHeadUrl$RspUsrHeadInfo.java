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
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "dstUin", "dstTid", "dstOpenid", "dstHeadInfos" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", null }, RspUsrHeadInfo.class);
  public final PBRepeatMessageField<MultiHeadUrl.RspHeadInfo> dstHeadInfos = PBField.initRepeatMessage(MultiHeadUrl.RspHeadInfo.class);
  public final PBStringField dstOpenid = PBField.initString("");
  public final PBUInt64Field dstTid = PBField.initUInt64(0L);
  public final PBUInt64Field dstUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo
 * JD-Core Version:    0.7.0.1
 */