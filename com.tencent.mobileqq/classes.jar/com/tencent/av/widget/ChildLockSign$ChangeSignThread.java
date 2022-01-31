package com.tencent.av.widget;

class ChildLockSign$ChangeSignThread
  extends Thread
{
  ChildLockSign$ChangeSignThread(ChildLockSign paramChildLockSign) {}
  
  public void run()
  {
    ChildLockSign.a(this.this$0, ChildLockSign.a(this.this$0));
    ChildLockSign.a(this.this$0, false);
    this.this$0.postInvalidate();
    try
    {
      Thread.sleep(500L);
      label37:
      this.this$0.a(1);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockSign.ChangeSignThread
 * JD-Core Version:    0.7.0.1
 */