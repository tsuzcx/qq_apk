package com.tencent.mobileqq.activity.bless;

class CountDownView$1
  implements Runnable
{
  CountDownView$1(CountDownView paramCountDownView) {}
  
  public void run()
  {
    if ((CountDownView.a(this.this$0)) && (CountDownView.b(this.this$0) >= CountDownView.b().length))
    {
      this.this$0.a();
      if (CountDownView.c(this.this$0) != null) {
        CountDownView.c(this.this$0).a();
      }
      return;
    }
    if (CountDownView.b(this.this$0) >= CountDownView.b().length) {
      return;
    }
    CountDownView.d(this.this$0);
    this.this$0.setImageResource(CountDownView.b()[CountDownView.b(this.this$0)]);
    CountDownView localCountDownView = this.this$0;
    localCountDownView.postDelayed(CountDownView.e(localCountDownView), 1000L);
    CountDownView.f(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.CountDownView.1
 * JD-Core Version:    0.7.0.1
 */