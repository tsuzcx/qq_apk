package com.tencent.mobileqq.ar.model;

import anbo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$4
  implements Runnable
{
  public QQARSession$4(anbo paramanbo) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "uninit run. mIsInited = " + anbo.b(this.this$0));
    anbo.a(this.this$0);
    this.this$0.a = 5;
    anbo.a(this.this$0, false);
    QLog.i("AREngine_QQARSession", 1, "uninit end. mIsInited = " + anbo.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.4
 * JD-Core Version:    0.7.0.1
 */