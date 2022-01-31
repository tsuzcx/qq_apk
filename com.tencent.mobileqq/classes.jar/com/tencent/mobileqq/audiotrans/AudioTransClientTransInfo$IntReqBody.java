package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class AudioTransClientTransInfo$IntReqBody
  extends MessageMicro<IntReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "msg_join_session_req", "msg_exit_session_req", "msg_change_session_req", "msg_raw_data_req", "msg_heart_beat_req", "msg_push_data_req", "msg_notify_exit_req" }, new Object[] { null, null, null, null, null, null, null }, IntReqBody.class);
  public AudioTransClientTransInfo.IntC2SChangeSessionReq msg_change_session_req = new AudioTransClientTransInfo.IntC2SChangeSessionReq();
  public AudioTransClientTransInfo.IntC2SExitSessionReq msg_exit_session_req = new AudioTransClientTransInfo.IntC2SExitSessionReq();
  public AudioTransClientTransInfo.IntC2SHeartBeatReq msg_heart_beat_req = new AudioTransClientTransInfo.IntC2SHeartBeatReq();
  public AudioTransClientTransInfo.IntC2SJoinSessionReq msg_join_session_req = new AudioTransClientTransInfo.IntC2SJoinSessionReq();
  public AudioTransClientTransInfo.IntS2CNotifyExitReq msg_notify_exit_req = new AudioTransClientTransInfo.IntS2CNotifyExitReq();
  public AudioTransClientTransInfo.IntS2CPushDataReq msg_push_data_req = new AudioTransClientTransInfo.IntS2CPushDataReq();
  public AudioTransClientTransInfo.IntC2SRawDataReq msg_raw_data_req = new AudioTransClientTransInfo.IntC2SRawDataReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntReqBody
 * JD-Core Version:    0.7.0.1
 */