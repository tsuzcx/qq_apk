package com.tencent.av.service;

import com.tencent.qphone.base.util.QLog;

class AVServiceForQQ$AVServiceForQQStub$1
  implements Runnable
{
  AVServiceForQQ$AVServiceForQQStub$1(AVServiceForQQ.AVServiceForQQStub paramAVServiceForQQStub) {}
  
  public void run()
  {
    try
    {
      this.a.a.startForeground(235, this.a.a.b);
      QLog.d("AVServiceForQQ", 1, "setAvServiceForegroud start foreground.");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAVServiceForegroud, e = ");
      localStringBuilder.append(localException);
      QLog.d("AVServiceForQQ", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub.1
 * JD-Core Version:    0.7.0.1
 */