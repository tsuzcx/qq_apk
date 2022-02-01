package com.tencent.biz.webviewbase;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;

class WebAIOController$3
  extends OnRemoteRespObserver
{
  WebAIOController$3(WebAIOController paramWebAIOController) {}
  
  public void onBindedToClient()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onBindedToClient");
    }
  }
  
  public void onDisconnectWithService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onDisconnectWithService");
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onPushMsg");
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBanner", 2, "-->onResponse");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewbase.WebAIOController.3
 * JD-Core Version:    0.7.0.1
 */