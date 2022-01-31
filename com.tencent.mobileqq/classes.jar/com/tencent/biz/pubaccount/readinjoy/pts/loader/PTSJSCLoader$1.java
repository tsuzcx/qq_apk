package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.qphone.base.util.QLog;
import ppo;
import pqj;

public class PTSJSCLoader$1
  implements Runnable
{
  public PTSJSCLoader$1(ppo paramppo) {}
  
  public void run()
  {
    if (!pqj.a.a())
    {
      QLog.i("PTSJSCLoader", 1, "[init], ptsJSCEnabled is false.");
      return;
    }
    ppo.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.1
 * JD-Core Version:    0.7.0.1
 */