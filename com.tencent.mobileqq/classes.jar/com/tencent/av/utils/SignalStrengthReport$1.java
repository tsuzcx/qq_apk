package com.tencent.av.utils;

import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;

class SignalStrengthReport$1
  implements Runnable
{
  SignalStrengthReport$1(SignalStrengthReport paramSignalStrengthReport) {}
  
  public void run()
  {
    int n = SignalStrengthReport.e();
    int m = 0;
    int i;
    if (n == 0) {
      i = 0;
    } else if (n == 1) {
      i = this.this$0.c();
    } else {
      i = this.this$0.b();
    }
    int j;
    if (n == 0) {
      j = 0;
    } else if (n == 1) {
      j = this.this$0.d();
    } else {
      j = this.this$0.a();
    }
    int k = j;
    if (j == -1) {
      k = 0;
    }
    int i1 = Math.abs(k);
    if (n == 1) {
      k = this.this$0.b;
    } else {
      k = 0;
    }
    if (n == 0) {
      j = m;
    } else if ((n == 1) || (Build.VERSION.SDK_INT >= 23)) {
      j = i;
    } else {
      j = i1 + 1000;
    }
    VideoController.a().a(n, j, k);
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("networkType:");
    localStringBuilder.append(n);
    localStringBuilder.append(" signalStrength:");
    localStringBuilder.append(j);
    localStringBuilder.append(" pingResult:");
    localStringBuilder.append(k);
    ((SignalStrengthReport)localObject).jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setGatewayTestResult networkType:");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append(" | levelPercent:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" | dbm:");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("| pingResult:");
    ((StringBuilder)localObject).append(this.this$0.b);
    AVLog.printColorLog("SignalStrengthReport", ((StringBuilder)localObject).toString());
    if (this.this$0.jdField_a_of_type_AndroidOsHandler != null) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.1
 * JD-Core Version:    0.7.0.1
 */