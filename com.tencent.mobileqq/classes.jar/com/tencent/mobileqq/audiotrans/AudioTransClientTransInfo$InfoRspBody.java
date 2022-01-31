package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class AudioTransClientTransInfo$InfoRspBody
  extends MessageMicro<InfoRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_failed_rsp", "msg_create_session_rsp" }, new Object[] { null, null }, InfoRspBody.class);
  public AudioTransClientTransInfo.InfoC2SCreateSessionRsp msg_create_session_rsp = new AudioTransClientTransInfo.InfoC2SCreateSessionRsp();
  public AudioTransClientTransInfo.InfoC2SFailedRsp msg_failed_rsp = new AudioTransClientTransInfo.InfoC2SFailedRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoRspBody
 * JD-Core Version:    0.7.0.1
 */