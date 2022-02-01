package com.tencent.hippy.qq.module;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;

class QQBaseWebIpcModule$1
  extends OnRemoteRespObserver
{
  QQBaseWebIpcModule$1(QQBaseWebIpcModule paramQQBaseWebIpcModule) {}
  
  public void onBindedToClient()
  {
    this.this$0.onBindedToClient();
  }
  
  public void onDisconnectWithService()
  {
    this.this$0.onDisconnectWithService();
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    this.this$0.onPushMsg(paramBundle);
  }
  
  public void onResponse(Bundle paramBundle)
  {
    this.this$0.onResponse(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBaseWebIpcModule.1
 * JD-Core Version:    0.7.0.1
 */