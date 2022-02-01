package com.tencent.mobileqq.ark.share.api.impl;

import com.tencent.mobileqq.ark.share.ArkMessagePreprocessorMgr;
import com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import mqq.app.AppRuntime;

public class ArkAsyncShareMsgServiceImpl
  implements IArkAsyncShareMsgService
{
  ArkAsyncShareMsgManager asyncShareMsgManager;
  ArkMessagePreprocessorMgr messagePreprocessorMgr;
  
  public ArkAsyncShareMsgManager getAsyncShareMsgManager()
  {
    return this.asyncShareMsgManager;
  }
  
  public ArkMessagePreprocessorMgr getMessagePreprocessorMgr()
  {
    return this.messagePreprocessorMgr;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.messagePreprocessorMgr = new ArkMessagePreprocessorMgr();
    this.asyncShareMsgManager = new ArkAsyncShareMsgManager(paramAppRuntime);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.share.api.impl.ArkAsyncShareMsgServiceImpl
 * JD-Core Version:    0.7.0.1
 */