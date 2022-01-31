package com.tencent.biz.pubaccount.readinjoy.ad.view;

public class ReadInJoyAdGestureView$LongPressRunnable
  implements Runnable
{
  public ReadInJoyAdGestureView$LongPressRunnable(ReadInJoyAdGestureView paramReadInJoyAdGestureView) {}
  
  public void run()
  {
    if ((ReadInJoyAdGestureView.a(this.this$0)) || (ReadInJoyAdGestureView.b(this.this$0))) {
      return;
    }
    this.this$0.c();
    this.this$0.a = false;
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView.LongPressRunnable
 * JD-Core Version:    0.7.0.1
 */