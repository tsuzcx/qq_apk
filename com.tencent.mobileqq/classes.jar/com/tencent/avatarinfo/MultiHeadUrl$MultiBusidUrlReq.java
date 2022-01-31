package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiHeadUrl$MultiBusidUrlReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "srcUidType", "srcUin", "srcTid", "srcOpenid", "dstUsrType", "dstUidType", "dstUsrInfos" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), null }, MultiBusidUrlReq.class);
  public final PBUInt32Field dstUidType = PBField.initUInt32(0);
  public final PBRepeatMessageField dstUsrInfos = PBField.initRepeatMessage(MultiHeadUrl.ReqUsrInfo.class);
  public final PBRepeatField dstUsrType = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField srcOpenid = PBField.initString("");
  public final PBUInt64Field srcTid = PBField.initUInt64(0L);
  public final PBUInt32Field srcUidType = PBField.initUInt32(0);
  public final PBUInt64Field srcUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq
 * JD-Core Version:    0.7.0.1
 */