package com.tencent.mobileqq.ar.model;

import anbo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$27
  implements Runnable
{
  public QQARSession$27(anbo paramanbo) {}
  
  public void run()
  {
    if ((this.this$0.a != 2) || (!anbo.a(this.this$0)))
    {
      QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus with error status so return", new Object[0]));
      return;
    }
    if (this.this$0.d())
    {
      this.this$0.l();
      anbo.c(this.this$0, 0L);
      anbo.a(this.this$0, null);
      anbo.b(this.this$0, null);
    }
    this.this$0.a(5L);
    anbo.d(this.this$0);
    this.this$0.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.27
 * JD-Core Version:    0.7.0.1
 */