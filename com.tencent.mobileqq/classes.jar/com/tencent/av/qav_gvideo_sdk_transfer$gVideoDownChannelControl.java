package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qav_gvideo_sdk_transfer$gVideoDownChannelControl
  extends MessageMicro<gVideoDownChannelControl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_switch", "uint32_videoacceptTypeSize", "msg_video_accept_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, gVideoDownChannelControl.class);
  public final PBRepeatMessageField<qav_gvideo_sdk_transfer.gVideoAcceptType> msg_video_accept_type = PBField.initRepeatMessage(qav_gvideo_sdk_transfer.gVideoAcceptType.class);
  public final PBUInt32Field uint32_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_videoacceptTypeSize = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.qav_gvideo_sdk_transfer.gVideoDownChannelControl
 * JD-Core Version:    0.7.0.1
 */