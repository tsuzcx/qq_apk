package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class AudioTransInterfaceTranslate$IntTransReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "msg_join_session_req", "msg_change_session_req", "msg_exit_session_req", "msg_raw_data_req", "msg_client_report_req", "msg_push_data_req", "msg_data_timeout_req", "msg_report_change_req" }, new Object[] { null, null, null, null, null, null, null, null }, IntTransReqBody.class);
  public AudioTransInterfaceTranslate.IntTransChangeSessionReq msg_change_session_req = new AudioTransInterfaceTranslate.IntTransChangeSessionReq();
  public AudioTransInterfaceTranslate.IntTransClientReportReq msg_client_report_req = new AudioTransInterfaceTranslate.IntTransClientReportReq();
  public AudioTransInterfaceTranslate.TransIntTimeoutReq msg_data_timeout_req = new AudioTransInterfaceTranslate.TransIntTimeoutReq();
  public AudioTransInterfaceTranslate.IntTransExitSessionReq msg_exit_session_req = new AudioTransInterfaceTranslate.IntTransExitSessionReq();
  public AudioTransInterfaceTranslate.IntTransJoinSessionReq msg_join_session_req = new AudioTransInterfaceTranslate.IntTransJoinSessionReq();
  public AudioTransInterfaceTranslate.TransIntPushDataReq msg_push_data_req = new AudioTransInterfaceTranslate.TransIntPushDataReq();
  public AudioTransInterfaceTranslate.IntTransRawDataReq msg_raw_data_req = new AudioTransInterfaceTranslate.IntTransRawDataReq();
  public AudioTransInterfaceTranslate.IntTransReportReq msg_report_change_req = new AudioTransInterfaceTranslate.IntTransReportReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate.IntTransReqBody
 * JD-Core Version:    0.7.0.1
 */