package com.tencent.biz.pubaccount.weishi_new.ipc;

import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import mqq.os.MqqHandler;

public class WSIPCClientHelper
{
  private static WSIPCClientHelper a;
  private boolean b;
  
  private WSIPCClientHelper()
  {
    b();
  }
  
  public static WSIPCClientHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WSIPCClientHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void b()
  {
    if (this.b)
    {
      WSLog.e("WSIPCClientHelper", "has connected");
      return;
    }
    QIPCClientHelper.getInstance().getClient().connect(new WSIPCClientHelper.1(this));
  }
  
  public void a(@Nullable String paramString)
  {
    if (paramString == null) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new WSIPCClientHelper.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ipc.WSIPCClientHelper
 * JD-Core Version:    0.7.0.1
 */