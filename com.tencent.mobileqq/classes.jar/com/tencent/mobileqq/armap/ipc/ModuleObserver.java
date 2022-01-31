package com.tencent.mobileqq.armap.ipc;

import android.os.Bundle;
import eipc.EIPCResult;

public class ModuleObserver
  implements IAsyncObserver
{
  public void a(String paramString) {}
  
  public void a(String paramString, EIPCResult paramEIPCResult)
  {
    if (IPCConstants.b.equals(paramString)) {
      a(paramEIPCResult.isSuccess());
    }
    do
    {
      return;
      if (IPCConstants.c.equals(paramString))
      {
        b(paramEIPCResult.isSuccess());
        return;
      }
    } while (!IPCConstants.d.equals(paramString));
    paramEIPCResult = paramEIPCResult.data;
    paramString = "no data";
    if (paramEIPCResult != null) {
      paramString = paramEIPCResult.getString("text");
    }
    a(paramString);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ipc.ModuleObserver
 * JD-Core Version:    0.7.0.1
 */