package com.tencent.biz.pubaccount.util.monitor;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.WindowManager;
import com.tencent.mobileqq.kandian.base.bandwidth.api.IBandwidthPredictor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class FPSMonitor
  implements DropFrameCollector.DropFrameCallback
{
  private DropFrameCollector a;
  private FPSSuspendedBall b;
  private WindowManager c;
  private boolean d = false;
  private SoftReference<Context> e;
  
  public static final FPSMonitor a()
  {
    return FPSMonitor.FPSMonitorHolder.a();
  }
  
  private void b(Context paramContext)
  {
    if (c() != paramContext) {
      return;
    }
    paramContext = this.b;
    if ((paramContext != null) && (paramContext.getParent() != null)) {
      this.c.removeViewImmediate(this.b);
    }
    if ((this.a != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.a.b();
    }
    this.a = null;
    this.c = null;
    this.b = null;
    this.e = null;
  }
  
  private Context c()
  {
    SoftReference localSoftReference = this.e;
    if (localSoftReference != null) {
      return (Context)localSoftReference.get();
    }
    return null;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    FPSSuspendedBall localFPSSuspendedBall = this.b;
    if (localFPSSuspendedBall != null) {
      localFPSSuspendedBall.a(paramFloat1, paramFloat2, paramFloat3, ((IBandwidthPredictor)QRoute.api(IBandwidthPredictor.class)).getLastBandwidth(), ((IBandwidthPredictor)QRoute.api(IBandwidthPredictor.class)).getCurrentPrediction());
    }
  }
  
  public void a(Activity paramActivity)
  {
    a(paramActivity, false);
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    if (!this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FPSMonitor", 2, "start fail, switch was closed");
      }
      return;
    }
    Context localContext = c();
    if ((paramActivity == localContext) && (this.b != null)) {
      return;
    }
    b(localContext);
    this.e = new SoftReference(paramActivity);
    this.c = ((WindowManager)paramActivity.getSystemService("window"));
    this.b = new FPSSuspendedBall(paramActivity);
    this.a = new DropFrameCollector(this, this.c);
    this.b.a(paramActivity, this.c);
    this.b.a(paramBoolean);
    this.a.a();
  }
  
  public void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    b(paramContext);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.FPSMonitor
 * JD-Core Version:    0.7.0.1
 */