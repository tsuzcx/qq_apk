package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.qphone.base.util.QLog;
import pwa;
import pxb;

public class PTSJSCLoader$1
  implements Runnable
{
  public PTSJSCLoader$1(pwa parampwa) {}
  
  public void run()
  {
    if (!pxb.a.a())
    {
      QLog.i("PTSJSCLoader", 1, "[init], ptsJSCEnabled is false.");
      return;
    }
    pwa.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.1
 * JD-Core Version:    0.7.0.1
 */