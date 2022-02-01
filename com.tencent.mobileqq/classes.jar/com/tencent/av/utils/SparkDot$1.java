package com.tencent.av.utils;

import android.os.Handler;

class SparkDot$1
  implements Runnable
{
  SparkDot$1(SparkDot paramSparkDot) {}
  
  public void run()
  {
    SparkDot localSparkDot = this.this$0;
    localSparkDot.e %= this.this$0.h;
    localSparkDot = this.this$0;
    localSparkDot.a(localSparkDot.e);
    localSparkDot = this.this$0;
    localSparkDot.e += 1;
    if (SparkDot.a(this.this$0)) {
      this.this$0.m.postDelayed(this.this$0.n, this.this$0.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SparkDot.1
 * JD-Core Version:    0.7.0.1
 */