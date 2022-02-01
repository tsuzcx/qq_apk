package com.tencent.mobileqq.ar.model;

import aoiw;
import aolr;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$10
  implements Runnable
{
  public QQARSession$10(aolr paramaolr) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult. download resource timeout.");
    aolr.a(this.this$0).b();
    this.this$0.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.10
 * JD-Core Version:    0.7.0.1
 */