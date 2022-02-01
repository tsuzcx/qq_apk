package com.tencent.mobileqq.app.qqdaily;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.RspBody;

public abstract interface QQDailyHandler$OnReceiveListener
{
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_cmd0xe27.RspBody paramRspBody);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyHandler.OnReceiveListener
 * JD-Core Version:    0.7.0.1
 */