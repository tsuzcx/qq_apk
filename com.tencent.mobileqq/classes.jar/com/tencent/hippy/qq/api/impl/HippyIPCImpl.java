package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.hippy.qq.ipc.HippyIpcModule;
import com.tencent.mobileqq.qipc.QIPCModule;

public class HippyIPCImpl
  implements IHippyIPC
{
  public QIPCModule getIPCModule()
  {
    return HippyIpcModule.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippyIPCImpl
 * JD-Core Version:    0.7.0.1
 */