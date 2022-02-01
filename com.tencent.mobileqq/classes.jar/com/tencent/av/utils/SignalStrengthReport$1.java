package com.tencent.av.utils;

import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.VideoController;
import lbc;
import mtn;

public class SignalStrengthReport$1
  implements Runnable
{
  public SignalStrengthReport$1(mtn parammtn) {}
  
  public void run()
  {
    int m = 0;
    int n = mtn.e();
    int i;
    int j;
    label22:
    int k;
    int i1;
    if (n == 0)
    {
      i = 0;
      if (n != 0) {
        break label228;
      }
      j = 0;
      k = j;
      if (j == -1) {
        k = 0;
      }
      i1 = Math.abs(k);
      if (n != 1) {
        break label256;
      }
      k = this.this$0.b;
      label51:
      if (n != 0) {
        break label261;
      }
      j = m;
    }
    for (;;)
    {
      VideoController.a().a(n, j, k);
      this.this$0.jdField_a_of_type_JavaLangString = ("networkType:" + n + " signalStrength:" + j + " pingResult:" + k);
      lbc.c("SignalStrengthReport", "setGatewayTestResult networkType:" + n + " | levelPercent:" + i + " | dbm:" + i1 + "| pingResult:" + this.this$0.b);
      if (this.this$0.jdField_a_of_type_AndroidOsHandler != null) {
        this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 2000L);
      }
      return;
      if (n == 1)
      {
        i = this.this$0.c();
        break;
      }
      i = this.this$0.b();
      break;
      label228:
      if (n == 1)
      {
        j = this.this$0.d();
        break label22;
      }
      j = this.this$0.a();
      break label22;
      label256:
      k = 0;
      break label51;
      label261:
      if (n == 1) {
        j = i;
      } else if (Build.VERSION.SDK_INT >= 23) {
        j = i;
      } else {
        j = i1 + 1000;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.1
 * JD-Core Version:    0.7.0.1
 */