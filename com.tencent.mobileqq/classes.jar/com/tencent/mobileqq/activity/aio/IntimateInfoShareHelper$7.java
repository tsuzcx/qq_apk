package com.tencent.mobileqq.activity.aio;

import agim;
import com.tencent.qphone.base.util.QLog;
import zyx;

public class IntimateInfoShareHelper$7
  implements Runnable
{
  public IntimateInfoShareHelper$7(agim paramagim, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      zyx.a(this.a, this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("IntimateInfoShareHelper", 1, "showQQToast error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.7
 * JD-Core Version:    0.7.0.1
 */