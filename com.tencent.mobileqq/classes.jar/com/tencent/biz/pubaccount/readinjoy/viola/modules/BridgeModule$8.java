package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import arik;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

class BridgeModule$8
  implements Runnable
{
  BridgeModule$8(BridgeModule paramBridgeModule) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((arik)((QQAppInterface)localAppRuntime).getManager(306)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.8
 * JD-Core Version:    0.7.0.1
 */