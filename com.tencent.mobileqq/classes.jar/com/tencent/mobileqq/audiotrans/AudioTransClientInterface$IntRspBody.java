package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class AudioTransClientInterface$IntRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "msg_failed_rsp", "msg_join_session_rsp", "msg_exit_session_rsp", "msg_change_session_rsp", "msg_raw_data_rsp", "msg_heart_beat_rsp", "msg_push_data_rsp", "msg_notify_exit_rsp" }, new Object[] { null, null, null, null, null, null, null, null }, IntRspBody.class);
  public AudioTransClientInterface.IntC2SChangeSessionRsp msg_change_session_rsp = new AudioTransClientInterface.IntC2SChangeSessionRsp();
  public AudioTransClientInterface.IntC2SExitSessionRsp msg_exit_session_rsp = new AudioTransClientInterface.IntC2SExitSessionRsp();
  public AudioTransClientInterface.IntC2SFailedRsp msg_failed_rsp = new AudioTransClientInterface.IntC2SFailedRsp();
  public AudioTransClientInterface.IntC2SHeartBeatRsp msg_heart_beat_rsp = new AudioTransClientInterface.IntC2SHeartBeatRsp();
  public AudioTransClientInterface.IntC2SJoinSessionRsp msg_join_session_rsp = new AudioTransClientInterface.IntC2SJoinSessionRsp();
  public AudioTransClientInterface.IntS2CNotifyExitRsp msg_notify_exit_rsp = new AudioTransClientInterface.IntS2CNotifyExitRsp();
  public AudioTransClientInterface.IntS2CPushDataRsp msg_push_data_rsp = new AudioTransClientInterface.IntS2CPushDataRsp();
  public AudioTransClientInterface.IntC2SRawDataRsp msg_raw_data_rsp = new AudioTransClientInterface.IntC2SRawDataRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInterface.IntRspBody
 * JD-Core Version:    0.7.0.1
 */