package com.tencent.mobileqq.apollo;

import aihs;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import babp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class EnginePreLoader$1
  implements Runnable
{
  public void run()
  {
    QLog.i("Apollo_EnginePreLoader", 1, "sava preload start");
    long l = System.currentTimeMillis();
    aihs.a(this.this$0, new ApolloEngine());
    aihs.a(this.this$0, new ApolloTicker());
    float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    if (aihs.a(this.this$0).a(0L, 0, 0, f, 1) > 0L)
    {
      aihs.a(this.this$0).a(f);
      aihs.a(this.this$0).a((int)Math.ceil((float)babp.i() / f), (int)Math.ceil((float)babp.j() / f));
      aihs.a(this.this$0);
    }
    QLog.d("Apollo_EnginePreLoader", 1, "create sava director use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.1
 * JD-Core Version:    0.7.0.1
 */