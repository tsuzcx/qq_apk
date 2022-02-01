package com.tencent.mobileqq.activity.main;

import android.view.View;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyTabObserver;
import cooperation.readinjoy.ReadInJoyHelper;

class MainAssistObserver$5
  extends ReadInJoyTabObserver
{
  MainAssistObserver$5(MainAssistObserver paramMainAssistObserver) {}
  
  public void a()
  {
    if (ReadInJoyHelper.n()) {
      this.a.a(39, null);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    if (!ReadInJoyHelper.m()) {}
    while (this.a.a == null) {
      return;
    }
    this.a.a.runOnUiThread(new MainAssistObserver.5.2(this, paramInt, paramObject));
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(1, paramView);
  }
  
  public void e()
  {
    if (!ReadInJoyHelper.m()) {}
    while (this.a.a == null) {
      return;
    }
    this.a.a.runOnUiThread(new MainAssistObserver.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.5
 * JD-Core Version:    0.7.0.1
 */