package com.tencent.gdtad.statistics;

import acho;
import acht;
import achu;
import android.os.SystemClock;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

@Deprecated
final class GdtDwellTimeStatisticsAfterClick
{
  private long jdField_a_of_type_Long;
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private void a()
  {
    WeakReference localWeakReference = new WeakReference(this);
    if (this.b)
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        if (((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isShown())
        {
          this.b = false;
          this.jdField_a_of_type_Boolean = false;
          c();
          return;
        }
        ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).postDelayed(new GdtDwellTimeStatisticsAfterClick.CheckRunnable(localWeakReference), 100L);
        return;
      }
      this.b = false;
      this.jdField_a_of_type_Boolean = false;
      c();
      return;
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      if (!((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isShown())
      {
        this.b = true;
        b();
        ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).postDelayed(new GdtDwellTimeStatisticsAfterClick.CheckRunnable(localWeakReference), 100L);
        return;
      }
      ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).postDelayed(new GdtDwellTimeStatisticsAfterClick.CheckRunnable(localWeakReference), 100L);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    acho.b("GdtDwellTimeStatisticsAfterClick", String.format("enter %d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  private void c()
  {
    long l = SystemClock.elapsedRealtime();
    acho.b("GdtDwellTimeStatisticsAfterClick", String.format("leave %d", new Object[] { Long.valueOf(l) }));
    if (this.jdField_a_of_type_Long == -2147483648L) {
      acho.d("GdtDwellTimeStatisticsAfterClick", "leave error");
    }
    l -= this.jdField_a_of_type_Long;
    acho.b("GdtDwellTimeStatisticsAfterClick", String.format("dwell %d", new Object[] { Long.valueOf(l) }));
    this.jdField_a_of_type_Long = -2147483648L;
    achu localachu = new achu();
    localachu.jdField_a_of_type_ComTencentAdTangramAd = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    localachu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(42);
    localachu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(l);
    acht.a(localachu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick
 * JD-Core Version:    0.7.0.1
 */