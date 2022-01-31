package com.tencent.mobileqq.apollo.store;

import android.os.SystemClock;
import bhtd;
import com.tencent.qphone.base.util.QLog;

class ApolloGameActivity$3
  implements Runnable
{
  ApolloGameActivity$3(ApolloGameActivity paramApolloGameActivity) {}
  
  public void run()
  {
    long l = SystemClock.uptimeMillis();
    ApolloGameActivity.a(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.b, 2, " onCreate_doInitLaunchData cost time:" + (SystemClock.uptimeMillis() - l));
    }
    ApolloGameActivity.a(this.this$0).sendEmptyMessage(112);
    l = SystemClock.uptimeMillis();
    ApolloGameActivity.b(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.b, 2, " onCreate_doInitGameJs cost time:" + (SystemClock.uptimeMillis() - l));
    }
    l = SystemClock.uptimeMillis();
    ApolloGameActivity.c(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.b, 2, " onCreate_doOnAsyncAfter cost time:" + (SystemClock.uptimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity.3
 * JD-Core Version:    0.7.0.1
 */