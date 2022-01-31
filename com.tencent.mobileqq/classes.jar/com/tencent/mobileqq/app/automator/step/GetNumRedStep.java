package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.NumRedPointHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.BaseApplication;

public class GetNumRedStep
  extends AsyncStep
{
  protected int a()
  {
    SharedPreferences localSharedPreferences = this.a.b.getApp().getSharedPreferences(this.a.b.getAccount(), 0);
    int i = localSharedPreferences.getInt("NumRedTimeInterval", 600);
    int j = localSharedPreferences.getInt("NumRedLastTime", 0);
    if ((int)(System.currentTimeMillis() / 1000L) - j > i) {
      ((NumRedPointHandler)this.a.b.a(55)).b();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetNumRedStep
 * JD-Core Version:    0.7.0.1
 */