package com.tencent.biz.authorize;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class JsonConfig$1
  extends Handler
{
  JsonConfig$1(JsonConfig paramJsonConfig, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "clear mJsApiWhiteList");
    }
    this.a.c.clear();
    if ((paramMessage.obj instanceof ConcurrentHashMap))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "update new mJsApiWhiteList!");
      }
      this.a.c.putAll((ConcurrentHashMap)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.JsonConfig.1
 * JD-Core Version:    0.7.0.1
 */