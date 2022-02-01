package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class qav_gvideo_sdk_transfer$RespInfo
  extends MessageMicro<RespInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "gAudioInfo" }, new Object[] { Integer.valueOf(0), null }, RespInfo.class);
  public qav_gvideo_sdk_transfer.GAudioInfo gAudioInfo = new qav_gvideo_sdk_transfer.GAudioInfo();
  public final PBEnumField uint32_result = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qav_gvideo_sdk_transfer.RespInfo
 * JD-Core Version:    0.7.0.1
 */