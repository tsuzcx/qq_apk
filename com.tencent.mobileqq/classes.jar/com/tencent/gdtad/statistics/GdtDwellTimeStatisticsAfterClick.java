package com.tencent.gdtad.statistics;

import android.os.SystemClock;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

@Deprecated
final class GdtDwellTimeStatisticsAfterClick
{
  private GdtAd a;
  private WeakReference<View> b;
  private boolean c;
  private boolean d;
  private long e;
  
  private void a()
  {
    WeakReference localWeakReference1 = new WeakReference(this);
    if (this.d)
    {
      localWeakReference2 = this.b;
      if ((localWeakReference2 != null) && (localWeakReference2.get() != null))
      {
        if (((View)this.b.get()).isShown())
        {
          this.d = false;
          this.c = false;
          c();
          return;
        }
        ((View)this.b.get()).postDelayed(new GdtDwellTimeStatisticsAfterClick.CheckRunnable(localWeakReference1), 100L);
        return;
      }
      this.d = false;
      this.c = false;
      c();
      return;
    }
    WeakReference localWeakReference2 = this.b;
    if ((localWeakReference2 != null) && (localWeakReference2.get() != null))
    {
      if (!((View)this.b.get()).isShown())
      {
        this.d = true;
        b();
        ((View)this.b.get()).postDelayed(new GdtDwellTimeStatisticsAfterClick.CheckRunnable(localWeakReference1), 100L);
        return;
      }
      ((View)this.b.get()).postDelayed(new GdtDwellTimeStatisticsAfterClick.CheckRunnable(localWeakReference1), 100L);
      return;
    }
    this.c = false;
  }
  
  private void b()
  {
    this.e = SystemClock.elapsedRealtime();
    GdtLog.b("GdtDwellTimeStatisticsAfterClick", String.format("enter %d", new Object[] { Long.valueOf(this.e) }));
  }
  
  private void c()
  {
    long l = SystemClock.elapsedRealtime();
    GdtLog.b("GdtDwellTimeStatisticsAfterClick", String.format("leave %d", new Object[] { Long.valueOf(l) }));
    if (this.e == -2147483648L) {
      GdtLog.d("GdtDwellTimeStatisticsAfterClick", "leave error");
    }
    l -= this.e;
    GdtLog.b("GdtDwellTimeStatisticsAfterClick", String.format("dwell %d", new Object[] { Long.valueOf(l) }));
    this.e = -2147483648L;
    GdtActionReporter.Params localParams = new GdtActionReporter.Params();
    localParams.a = this.a;
    localParams.b.landing_page_action_type.set(42);
    localParams.b.latency_ms.set(l);
    GdtActionReporter.a(localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick
 * JD-Core Version:    0.7.0.1
 */