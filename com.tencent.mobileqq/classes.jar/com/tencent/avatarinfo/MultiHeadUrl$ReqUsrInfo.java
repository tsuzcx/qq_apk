package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiHeadUrl$ReqUsrInfo
  extends MessageMicro<ReqUsrInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "dstUin", "dstTid", "dstOpenid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, ReqUsrInfo.class);
  public final PBStringField dstOpenid = PBField.initString("");
  public final PBUInt64Field dstTid = PBField.initUInt64(0L);
  public final PBUInt64Field dstUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo
 * JD-Core Version:    0.7.0.1
 */