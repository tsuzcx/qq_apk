package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQHeadUrl$ReqUsrInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "dstUin", "timestamp", "dstEncid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, ReqUsrInfo.class);
  public final PBStringField dstEncid = PBField.initString("");
  public final PBUInt64Field dstUin = PBField.initUInt64(0L);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo
 * JD-Core Version:    0.7.0.1
 */