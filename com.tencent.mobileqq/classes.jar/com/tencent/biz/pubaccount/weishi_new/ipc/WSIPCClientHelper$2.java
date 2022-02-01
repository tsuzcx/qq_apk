package com.tencent.biz.pubaccount.weishi_new.ipc;

import com.tencent.mobileqq.qipc.QIPCClientHelper;

class WSIPCClientHelper$2
  implements Runnable
{
  WSIPCClientHelper$2(WSIPCClientHelper paramWSIPCClientHelper, String paramString) {}
  
  public void run()
  {
    WSIPCClientHelper.a(this.this$0);
    QIPCClientHelper.getInstance().callServer("WSIPCModule", this.a, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ipc.WSIPCClientHelper.2
 * JD-Core Version:    0.7.0.1
 */