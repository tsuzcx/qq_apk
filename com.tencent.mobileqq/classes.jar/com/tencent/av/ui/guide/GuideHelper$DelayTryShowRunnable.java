package com.tencent.av.ui.guide;

import android.content.Context;
import android.os.Handler;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class GuideHelper$DelayTryShowRunnable
  implements Runnable
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  WeakReference<Context> jdField_a_of_type_MqqUtilWeakReference = null;
  WeakReference<GuideHelper> b = null;
  
  GuideHelper$DelayTryShowRunnable()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public final void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeCallback, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], last_seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w("GuideHelper", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.b = null;
    ThreadManager.a().removeCallbacks(this);
  }
  
  public final boolean a(long paramLong1, Context paramContext, GuideHelper paramGuideHelper, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    this.b = new WeakReference(paramGuideHelper);
    ThreadManager.a().removeCallbacks(this);
    return ThreadManager.a().postDelayed(this, paramLong2);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("]");
      QLog.w("GuideHelper", 1, ((StringBuilder)localObject).toString());
      return;
    }
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      localGuideHelper = (GuideHelper)localWeakReference.get();
    }
    if (localGuideHelper == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DelayTryShowRunnable, GuideHelper fail, seq[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("]");
      QLog.w("GuideHelper", 1, ((StringBuilder)localObject).toString());
      return;
    }
    GuideHelper.a(localGuideHelper, this.jdField_a_of_type_Long, (Context)localObject, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.DelayTryShowRunnable
 * JD-Core Version:    0.7.0.1
 */