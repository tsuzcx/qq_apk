package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ILiveChanneSvr$AndroidInfo
  extends MessageMicro<AndroidInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "sound", "oppo_channel_id", "url" }, new Object[] { "", "", "" }, AndroidInfo.class);
  public final PBStringField oppo_channel_id = PBField.initString("");
  public final PBStringField sound = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.AndroidInfo
 * JD-Core Version:    0.7.0.1
 */