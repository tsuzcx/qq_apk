package com.tencent.biz.pubaccount.weishi_new.ipc;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;

public class WSIPCClientHelper
{
  private boolean a;
  
  private WSIPCClientHelper()
  {
    a();
  }
  
  private void a()
  {
    if (this.a)
    {
      WSLog.e("WSIPCClientHelper", "has connected");
      return;
    }
    QIPCClientHelper.getInstance().getClient().connect(new WSIPCClientHelper.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ipc.WSIPCClientHelper
 * JD-Core Version:    0.7.0.1
 */