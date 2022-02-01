package com.tencent.av.ui.guide;

import android.content.Context;
import android.os.Handler;
import bjum;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class GuideHelper$DelayTryShowRunnable
  implements Runnable
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  WeakReference<Context> jdField_a_of_type_MqqUtilWeakReference = null;
  WeakReference<GuideHelper> b = null;
  
  public final void a(long paramLong)
  {
    QLog.w("GuideHelper", 1, "removeCallback, seq[" + paramLong + "], last_seq[" + this.jdField_a_of_type_Long + "]");
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.b = null;
    bjum.a().removeCallbacks(this);
  }
  
  public final boolean a(long paramLong1, Context paramContext, GuideHelper paramGuideHelper, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    this.b = new WeakReference(paramGuideHelper);
    bjum.a().removeCallbacks(this);
    return bjum.a().postDelayed(this, paramLong2);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {}
    for (Context localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get(); localContext == null; localContext = null)
    {
      QLog.w("GuideHelper", 1, "DelayTryShowRunnable, context fail, seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    if (this.b != null) {}
    for (GuideHelper localGuideHelper = (GuideHelper)this.b.get(); localGuideHelper == null; localGuideHelper = null)
    {
      QLog.w("GuideHelper", 1, "DelayTryShowRunnable, GuideHelper fail, seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    GuideHelper.a(localGuideHelper, this.jdField_a_of_type_Long, localContext, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.DelayTryShowRunnable
 * JD-Core Version:    0.7.0.1
 */