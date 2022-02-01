package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ILiveChanneSvr$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "text_elem", "custom_elem", "offline_push_info", "msg_life_time" }, new Object[] { null, null, null, Integer.valueOf(7) }, MsgBody.class);
  public ILiveChanneSvr.TIMCustomElem custom_elem = new ILiveChanneSvr.TIMCustomElem();
  public final PBUInt32Field msg_life_time = PBField.initUInt32(7);
  public ILiveChanneSvr.OfflinePushInfo offline_push_info = new ILiveChanneSvr.OfflinePushInfo();
  public final PBRepeatMessageField<ILiveChanneSvr.TIMTextElem> text_elem = PBField.initRepeatMessage(ILiveChanneSvr.TIMTextElem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.MsgBody
 * JD-Core Version:    0.7.0.1
 */