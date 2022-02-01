package com.tencent.mobileqq.activity.aio;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.QLog;

class IntimateInfoShareHelper$7
  implements Runnable
{
  IntimateInfoShareHelper$7(IntimateInfoShareHelper paramIntimateInfoShareHelper, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      QRUtils.a(this.a, this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showQQToast error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.d("IntimateInfoShareHelper", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.7
 * JD-Core Version:    0.7.0.1
 */