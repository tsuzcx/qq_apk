package com.tencent.biz.pubaccount.weishi_new.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class WSIPCModule
  extends QIPCModule
{
  private static WSIPCModule a;
  
  public WSIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static WSIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WSIPCModule("WSIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ipc.WSIPCModule
 * JD-Core Version:    0.7.0.1
 */