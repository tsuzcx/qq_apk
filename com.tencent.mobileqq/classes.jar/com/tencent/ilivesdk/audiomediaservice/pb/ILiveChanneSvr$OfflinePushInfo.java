package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ILiveChanneSvr$OfflinePushInfo
  extends MessageMicro<OfflinePushInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "push_flag", "desc", "ext", "apns_info", "title", "android_info" }, new Object[] { Integer.valueOf(1), "", "", null, "", null }, OfflinePushInfo.class);
  public ILiveChanneSvr.AndroidInfo android_info = new ILiveChanneSvr.AndroidInfo();
  public ILiveChanneSvr.ApnsInfo apns_info = new ILiveChanneSvr.ApnsInfo();
  public final PBStringField desc = PBField.initString("");
  public final PBStringField ext = PBField.initString("");
  public final PBUInt32Field push_flag = PBField.initUInt32(1);
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.OfflinePushInfo
 * JD-Core Version:    0.7.0.1
 */