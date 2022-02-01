package com.tencent.biz.pubaccount.weishi_new.ipc;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
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
  
  private void b()
  {
    if (WSExpABTestManager.a().v()) {
      WSAioListHelper.a(WSAioListHelper.b(), "web_active");
    }
  }
  
  private void c() {}
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = paramString.hashCode();
    if (paramInt != 544375181)
    {
      if ((paramInt == 846204181) && (paramString.equals("action_req_aio_list_operation_feed")))
      {
        paramInt = 0;
        break label50;
      }
    }
    else if (paramString.equals("action_write_back_feed"))
    {
      paramInt = 1;
      break label50;
    }
    paramInt = -1;
    label50:
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        b();
      }
    }
    else {
      c();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ipc.WSIPCModule
 * JD-Core Version:    0.7.0.1
 */