package com.tencent.mobileqq.activity.aio;

import aclt;
import com.tencent.qphone.base.util.QLog;
import vvp;

public class IntimateInfoShareHelper$6
  implements Runnable
{
  public IntimateInfoShareHelper$6(aclt paramaclt, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      vvp.a(this.a, this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("IntimateInfoShareHelper", 1, "showQQToast error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.6
 * JD-Core Version:    0.7.0.1
 */