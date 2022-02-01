package com.tencent.mobileqq.app;

import MQQ.VipUserInfo;
import com.tencent.qphone.base.util.QLog;

public class VipInfoObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate-isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("VipInfoObserver", 2, localStringBuilder.toString());
    }
    if (paramInt == 1)
    {
      int i = -1;
      paramInt = i;
      if (paramBoolean)
      {
        paramObject = (VipUserInfo)paramObject;
        paramInt = i;
        if (paramObject != null)
        {
          paramInt = i;
          if (paramObject.bUpdate == 1) {
            paramInt = paramObject.iGrowthValue;
          }
        }
      }
      a(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.VipInfoObserver
 * JD-Core Version:    0.7.0.1
 */