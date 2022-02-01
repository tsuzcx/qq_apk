package com.tencent.avgame.protocol;

import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface ProtocolCoder
{
  public abstract Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.protocol.ProtocolCoder
 * JD-Core Version:    0.7.0.1
 */