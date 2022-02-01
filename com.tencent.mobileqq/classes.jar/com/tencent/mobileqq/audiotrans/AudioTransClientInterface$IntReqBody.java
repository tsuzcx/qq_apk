package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class AudioTransClientInterface$IntReqBody
  extends MessageMicro<IntReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "msg_join_session_req", "msg_exit_session_req", "msg_change_session_req", "msg_raw_data_req", "msg_heart_beat_req", "msg_push_data_req", "msg_notify_exit_req" }, new Object[] { null, null, null, null, null, null, null }, IntReqBody.class);
  public AudioTransClientInterface.IntC2SChangeSessionReq msg_change_session_req = new AudioTransClientInterface.IntC2SChangeSessionReq();
  public AudioTransClientInterface.IntC2SExitSessionReq msg_exit_session_req = new AudioTransClientInterface.IntC2SExitSessionReq();
  public AudioTransClientInterface.IntC2SHeartBeatReq msg_heart_beat_req = new AudioTransClientInterface.IntC2SHeartBeatReq();
  public AudioTransClientInterface.IntC2SJoinSessionReq msg_join_session_req = new AudioTransClientInterface.IntC2SJoinSessionReq();
  public AudioTransClientInterface.IntS2CNotifyExitReq msg_notify_exit_req = new AudioTransClientInterface.IntS2CNotifyExitReq();
  public AudioTransClientInterface.IntS2CPushDataReq msg_push_data_req = new AudioTransClientInterface.IntS2CPushDataReq();
  public AudioTransClientInterface.IntC2SRawDataReq msg_raw_data_req = new AudioTransClientInterface.IntC2SRawDataReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInterface.IntReqBody
 * JD-Core Version:    0.7.0.1
 */