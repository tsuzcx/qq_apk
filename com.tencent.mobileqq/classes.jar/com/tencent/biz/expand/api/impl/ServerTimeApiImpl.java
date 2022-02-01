package com.tencent.biz.expand.api.impl;

import com.tencent.biz.expand.api.IServerTimeApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class ServerTimeApiImpl
  implements IServerTimeApi
{
  public long getServerTime()
  {
    return NetConnInfoCenter.getServerTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.impl.ServerTimeApiImpl
 * JD-Core Version:    0.7.0.1
 */