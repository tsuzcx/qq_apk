package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class AudioTransClientInfo$InfoRspBody
  extends MessageMicro<InfoRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_failed_rsp", "msg_create_session_rsp" }, new Object[] { null, null }, InfoRspBody.class);
  public AudioTransClientInfo.InfoC2SCreateSessionRsp msg_create_session_rsp = new AudioTransClientInfo.InfoC2SCreateSessionRsp();
  public AudioTransClientInfo.InfoC2SFailedRsp msg_failed_rsp = new AudioTransClientInfo.InfoC2SFailedRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInfo.InfoRspBody
 * JD-Core Version:    0.7.0.1
 */