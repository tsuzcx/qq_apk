package com.tencent.mobileqq.ar.model;

import alie;
import alkz;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$12
  implements Runnable
{
  public QQARSession$12(alkz paramalkz) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult. download resource timeout.");
    alkz.a(this.this$0).b();
    this.this$0.b(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.12
 * JD-Core Version:    0.7.0.1
 */