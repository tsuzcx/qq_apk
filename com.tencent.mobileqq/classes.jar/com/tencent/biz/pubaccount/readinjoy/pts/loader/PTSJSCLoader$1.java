package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager;
import com.tencent.qphone.base.util.QLog;

class PTSJSCLoader$1
  implements Runnable
{
  PTSJSCLoader$1(PTSJSCLoader paramPTSJSCLoader) {}
  
  public void run()
  {
    if (!PTSSwitchManager.a.a())
    {
      QLog.i("PTSJSCLoader", 1, "[init], ptsJSCEnabled is false.");
      return;
    }
    PTSJSCLoader.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.1
 * JD-Core Version:    0.7.0.1
 */