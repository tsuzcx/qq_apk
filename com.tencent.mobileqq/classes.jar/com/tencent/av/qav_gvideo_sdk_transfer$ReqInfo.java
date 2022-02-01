package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class qav_gvideo_sdk_transfer$ReqInfo
  extends MessageMicro<ReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "req_event", "gAudioInfo" }, new Object[] { Integer.valueOf(1), null }, ReqInfo.class);
  public qav_gvideo_sdk_transfer.GAudioInfo gAudioInfo = new qav_gvideo_sdk_transfer.GAudioInfo();
  public final PBEnumField req_event = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.qav_gvideo_sdk_transfer.ReqInfo
 * JD-Core Version:    0.7.0.1
 */