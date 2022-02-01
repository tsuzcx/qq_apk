package com.tencent.mobileqq.ark.share.api;

import com.tencent.mobileqq.ark.share.ArkMessagePreprocessorMgr;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IArkAsyncShareMsgService
  extends IRuntimeService
{
  public abstract ArkAsyncShareMsgManager getAsyncShareMsgManager();
  
  public abstract ArkMessagePreprocessorMgr getMessagePreprocessorMgr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService
 * JD-Core Version:    0.7.0.1
 */