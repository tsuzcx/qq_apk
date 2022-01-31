package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class AudioTransInterfaceTranslate$IntTransRspBody
  extends MessageMicro<IntTransRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "msg_failed_rsp", "msg_join_session_rsp", "msg_change_session_rsp", "msg_exit_session_rsp", "msg_raw_data_rsp", "msg_client_report_rsp", "msg_push_data_rsp", "msg_data_timeout_rsp", "msg_report_change_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null }, IntTransRspBody.class);
  public AudioTransInterfaceTranslate.IntTransChangeSessionRsp msg_change_session_rsp = new AudioTransInterfaceTranslate.IntTransChangeSessionRsp();
  public AudioTransInterfaceTranslate.IntTransClientReportRsp msg_client_report_rsp = new AudioTransInterfaceTranslate.IntTransClientReportRsp();
  public AudioTransInterfaceTranslate.TransIntTimeoutRsp msg_data_timeout_rsp = new AudioTransInterfaceTranslate.TransIntTimeoutRsp();
  public AudioTransInterfaceTranslate.IntTransExitSessionRsp msg_exit_session_rsp = new AudioTransInterfaceTranslate.IntTransExitSessionRsp();
  public AudioTransInterfaceTranslate.IntTransFailedRsp msg_failed_rsp = new AudioTransInterfaceTranslate.IntTransFailedRsp();
  public AudioTransInterfaceTranslate.IntTransJoinSessionRsp msg_join_session_rsp = new AudioTransInterfaceTranslate.IntTransJoinSessionRsp();
  public AudioTransInterfaceTranslate.TransIntPushDataRsp msg_push_data_rsp = new AudioTransInterfaceTranslate.TransIntPushDataRsp();
  public AudioTransInterfaceTranslate.IntTransRawDataRsp msg_raw_data_rsp = new AudioTransInterfaceTranslate.IntTransRawDataRsp();
  public AudioTransInterfaceTranslate.IntTransReportRsp msg_report_change_rsp = new AudioTransInterfaceTranslate.IntTransReportRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate.IntTransRspBody
 * JD-Core Version:    0.7.0.1
 */