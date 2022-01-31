package com.tencent.mobileqq.apollo;

import aknx;
import akqk;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import bdgk;
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
    akqk.a(this.this$0, new ApolloEngine());
    akqk.a(this.this$0, new ApolloTicker());
    float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    if (akqk.a(this.this$0).a(0L, 0, 0, f, 1, aknx.a()) > 0L)
    {
      akqk.a(this.this$0).a(f);
      akqk.a(this.this$0).a((int)Math.ceil((float)bdgk.i() / f), (int)Math.ceil((float)bdgk.j() / f));
      akqk.a(this.this$0);
    }
    QLog.d("Apollo_EnginePreLoader", 1, "create sava director use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.1
 * JD-Core Version:    0.7.0.1
 */