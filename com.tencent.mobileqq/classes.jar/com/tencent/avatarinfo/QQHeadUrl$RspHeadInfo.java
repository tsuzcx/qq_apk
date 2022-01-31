package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQHeadUrl$RspHeadInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66 }, new String[] { "dstUin", "faceType", "timestamp", "faceFlag", "url", "sysid", "dstUid", "headVerify" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", "" }, RspHeadInfo.class);
  public final PBStringField dstUid = PBField.initString("");
  public final PBUInt64Field dstUin = PBField.initUInt64(0L);
  public final PBUInt32Field faceFlag = PBField.initUInt32(0);
  public final PBUInt32Field faceType = PBField.initUInt32(0);
  public final PBStringField headVerify = PBField.initString("");
  public final PBUInt32Field sysid = PBField.initUInt32(0);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo
 * JD-Core Version:    0.7.0.1
 */