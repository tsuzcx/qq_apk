package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$7
  extends ReadInJoyObserver
{
  MainAssistObserver$7(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mainobserver onReadInJoyNotifyRedTouchUpdate, isSuccess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",isUpdate=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramInt);
      QLog.i("SplashActivity", 4, localStringBuilder.toString());
    }
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt & 0x2) != 0)) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.7
 * JD-Core Version:    0.7.0.1
 */