package com.tencent.mobileqq.ar.model;

import amyt;
import anbo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$10
  implements Runnable
{
  public QQARSession$10(anbo paramanbo) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult. download resource timeout.");
    anbo.a(this.this$0).b();
    this.this$0.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.10
 * JD-Core Version:    0.7.0.1
 */