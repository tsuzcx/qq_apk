package com.tencent.mobileqq.ar.model;

import akwn;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$4
  implements Runnable
{
  public QQARSession$4(akwn paramakwn) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "uninit run. mIsInited = " + akwn.b(this.this$0));
    akwn.a(this.this$0);
    this.this$0.a = 5;
    akwn.a(this.this$0, false);
    QLog.i("AREngine_QQARSession", 1, "uninit end. mIsInited = " + akwn.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.4
 * JD-Core Version:    0.7.0.1
 */