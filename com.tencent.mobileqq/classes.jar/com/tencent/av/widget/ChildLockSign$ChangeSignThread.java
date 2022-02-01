package com.tencent.av.widget;

class ChildLockSign$ChangeSignThread
  extends Thread
{
  ChildLockSign$ChangeSignThread(ChildLockSign paramChildLockSign) {}
  
  public void run()
  {
    ChildLockSign localChildLockSign = this.this$0;
    ChildLockSign.a(localChildLockSign, ChildLockSign.a(localChildLockSign));
    ChildLockSign.a(this.this$0, false);
    this.this$0.postInvalidate();
    try
    {
      Thread.sleep(500L);
      label36:
      ChildLockSign.a(this.this$0, 1);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label36;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockSign.ChangeSignThread
 * JD-Core Version:    0.7.0.1
 */