package com.tencent.mobileqq.activity.aio;

import acwm;
import com.tencent.qphone.base.util.QLog;
import wim;

public class IntimateInfoShareHelper$6
  implements Runnable
{
  public IntimateInfoShareHelper$6(acwm paramacwm, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      wim.a(this.a, this.b);
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