package com.tencent.imcore.message.core.codec;

import com.tencent.mobileqq.service.message.TempSessionInfo;
import msf.msgcomm.msg_comm.Msg;

public abstract interface TempSessionServiceType
{
  public abstract void a(msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.core.codec.TempSessionServiceType
 * JD-Core Version:    0.7.0.1
 */