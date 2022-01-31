package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.qphone.base.util.QLog;
import pdu;
import pep;

public class PTSEngineLoader$2
  implements Runnable
{
  public PTSEngineLoader$2(pdu parampdu) {}
  
  public void run()
  {
    if (!pep.a.c()) {
      return;
    }
    pdu.a(this.this$0);
    if (pdu.a(this.this$0))
    {
      pdu.b(this.this$0);
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[init], handleDownloadPTSEngine.");
    pdu.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.2
 * JD-Core Version:    0.7.0.1
 */