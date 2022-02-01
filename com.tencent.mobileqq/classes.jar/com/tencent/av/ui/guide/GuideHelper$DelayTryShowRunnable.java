package com.tencent.av.ui.guide;

import android.content.Context;
import android.os.Handler;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class GuideHelper$DelayTryShowRunnable
  implements Runnable
{
  public int a = 0;
  long b = 0L;
  WeakReference<Context> c = null;
  WeakReference<GuideHelper> d = null;
  
  public final void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeCallback, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], last_seq[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.w("GuideHelper", 1, localStringBuilder.toString());
    this.b = 0L;
    this.c = null;
    this.d = null;
    ThreadManager.a().removeCallbacks(this);
  }
  
  public final boolean a(long paramLong1, Context paramContext, GuideHelper paramGuideHelper, long paramLong2)
  {
    this.b = paramLong1;
    this.c = new WeakReference(paramContext);
    this.d = new WeakReference(paramGuideHelper);
    ThreadManager.a().removeCallbacks(this);
    return ThreadManager.a().postDelayed(this, paramLong2);
  }
  
  public void run()
  {
    if (this.b == 0L) {
      return;
    }
    Object localObject = this.c;
    GuideHelper localGuideHelper = null;
    if (localObject != null) {
      localObject = (Context)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DelayTryShowRunnable, context fail, seq[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("]");
      QLog.w("GuideHelper", 1, ((StringBuilder)localObject).toString());
      return;
    }
    WeakReference localWeakReference = this.d;
    if (localWeakReference != null) {
      localGuideHelper = (GuideHelper)localWeakReference.get();
    }
    if (localGuideHelper == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DelayTryShowRunnable, GuideHelper fail, seq[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("]");
      QLog.w("GuideHelper", 1, ((StringBuilder)localObject).toString());
      return;
    }
    GuideHelper.a(localGuideHelper, this.b, (Context)localObject, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.DelayTryShowRunnable
 * JD-Core Version:    0.7.0.1
 */