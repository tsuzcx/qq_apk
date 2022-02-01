package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

class BabyQIPCModule$1
  extends CardObserver
{
  BabyQIPCModule$1(BabyQIPCModule paramBabyQIPCModule) {}
  
  public void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a.babyQSwitch = paramBoolean2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("babyqWeb onGetBabyQSwitch babyQSwitch = ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("BabyQIPCModule", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */