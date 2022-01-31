package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import asyy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

class BridgeModule$10
  implements Runnable
{
  BridgeModule$10(BridgeModule paramBridgeModule) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((asyy)((QQAppInterface)localAppRuntime).getManager(306)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.10
 * JD-Core Version:    0.7.0.1
 */