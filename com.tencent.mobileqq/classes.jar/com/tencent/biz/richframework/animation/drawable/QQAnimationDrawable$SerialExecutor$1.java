package com.tencent.biz.richframework.animation.drawable;

class QQAnimationDrawable$SerialExecutor$1
  implements Runnable
{
  QQAnimationDrawable$SerialExecutor$1(QQAnimationDrawable.SerialExecutor paramSerialExecutor, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    finally
    {
      this.this$0.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.SerialExecutor.1
 * JD-Core Version:    0.7.0.1
 */