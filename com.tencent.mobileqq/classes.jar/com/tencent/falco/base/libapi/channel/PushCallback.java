package com.tencent.falco.base.libapi.channel;

import com.tencent.falco.base.libapi.channel.helper.MsgExtInfo;

public abstract interface PushCallback
{
  public abstract void onRecv(int paramInt, byte[] paramArrayOfByte, MsgExtInfo paramMsgExtInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.channel.PushCallback
 * JD-Core Version:    0.7.0.1
 */