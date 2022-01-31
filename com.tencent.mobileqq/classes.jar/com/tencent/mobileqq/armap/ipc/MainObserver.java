package com.tencent.mobileqq.armap.ipc;

import eipc.EIPCResult;

public class MainObserver
  implements IAsyncObserver
{
  public void a(String paramString, EIPCResult paramEIPCResult)
  {
    if (IPCConstants.c.equals(paramString)) {
      a(paramEIPCResult.isSuccess());
    }
  }
  
  public void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ipc.MainObserver
 * JD-Core Version:    0.7.0.1
 */