package com.tencent.av.service;

import com.tencent.qphone.base.util.QLog;
import lwl;

public class AVServiceForQQ$AVServiceForQQStub$1
  implements Runnable
{
  public AVServiceForQQ$AVServiceForQQStub$1(lwl paramlwl) {}
  
  public void run()
  {
    try
    {
      this.a.a.startForeground(235, this.a.a.a);
      QLog.d("AVServiceForQQ", 1, "setAvServiceForegroud start foreground.");
      return;
    }
    catch (Exception localException)
    {
      QLog.d("AVServiceForQQ", 1, "setAVServiceForegroud, e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub.1
 * JD-Core Version:    0.7.0.1
 */