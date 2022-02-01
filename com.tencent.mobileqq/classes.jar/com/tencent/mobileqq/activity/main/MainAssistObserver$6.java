package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.app.readinjoy.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$6
  extends ReadInJoyObserver
{
  MainAssistObserver$6(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SplashActivity", 4, "mainobserver onReadInJoyNotifyRedTouchUpdate, isSuccess=" + paramBoolean1 + ",isUpdate=" + paramBoolean2 + ", type=" + paramInt);
    }
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt & 0x2) != 0)) {
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.6
 * JD-Core Version:    0.7.0.1
 */