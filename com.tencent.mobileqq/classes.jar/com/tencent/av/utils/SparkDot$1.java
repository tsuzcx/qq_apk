package com.tencent.av.utils;

import android.os.Handler;

class SparkDot$1
  implements Runnable
{
  SparkDot$1(SparkDot paramSparkDot) {}
  
  public void run()
  {
    SparkDot localSparkDot = this.this$0;
    localSparkDot.c %= this.this$0.e;
    localSparkDot = this.this$0;
    localSparkDot.a(localSparkDot.c);
    localSparkDot = this.this$0;
    localSparkDot.c += 1;
    if (SparkDot.a(this.this$0)) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, this.this$0.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SparkDot.1
 * JD-Core Version:    0.7.0.1
 */