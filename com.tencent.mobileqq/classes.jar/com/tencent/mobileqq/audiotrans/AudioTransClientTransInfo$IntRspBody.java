package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class AudioTransClientTransInfo$IntRspBody
  extends MessageMicro<IntRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "msg_failed_rsp", "msg_join_session_rsp", "msg_exit_session_rsp", "msg_change_session_rsp", "msg_raw_data_rsp", "msg_heart_beat_rsp", "msg_push_data_rsp", "msg_notify_exit_rsp" }, new Object[] { null, null, null, null, null, null, null, null }, IntRspBody.class);
  public AudioTransClientTransInfo.IntC2SChangeSessionRsp msg_change_session_rsp = new AudioTransClientTransInfo.IntC2SChangeSessionRsp();
  public AudioTransClientTransInfo.IntC2SExitSessionRsp msg_exit_session_rsp = new AudioTransClientTransInfo.IntC2SExitSessionRsp();
  public AudioTransClientTransInfo.IntC2SFailedRsp msg_failed_rsp = new AudioTransClientTransInfo.IntC2SFailedRsp();
  public AudioTransClientTransInfo.IntC2SHeartBeatRsp msg_heart_beat_rsp = new AudioTransClientTransInfo.IntC2SHeartBeatRsp();
  public AudioTransClientTransInfo.IntC2SJoinSessionRsp msg_join_session_rsp = new AudioTransClientTransInfo.IntC2SJoinSessionRsp();
  public AudioTransClientTransInfo.IntS2CNotifyExitRsp msg_notify_exit_rsp = new AudioTransClientTransInfo.IntS2CNotifyExitRsp();
  public AudioTransClientTransInfo.IntS2CPushDataRsp msg_push_data_rsp = new AudioTransClientTransInfo.IntS2CPushDataRsp();
  public AudioTransClientTransInfo.IntC2SRawDataRsp msg_raw_data_rsp = new AudioTransClientTransInfo.IntC2SRawDataRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntRspBody
 * JD-Core Version:    0.7.0.1
 */