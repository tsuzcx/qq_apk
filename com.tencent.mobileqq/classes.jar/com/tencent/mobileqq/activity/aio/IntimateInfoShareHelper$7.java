package com.tencent.mobileqq.activity.aio;

import afbf;
import com.tencent.qphone.base.util.QLog;
import yyi;

public class IntimateInfoShareHelper$7
  implements Runnable
{
  public IntimateInfoShareHelper$7(afbf paramafbf, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      yyi.a(this.a, this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("IntimateInfoShareHelper", 1, "showQQToast error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.7
 * JD-Core Version:    0.7.0.1
 */