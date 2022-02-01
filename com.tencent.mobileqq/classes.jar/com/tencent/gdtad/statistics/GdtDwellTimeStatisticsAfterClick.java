package com.tencent.gdtad.statistics;

import abrl;
import abrq;
import abrr;
import android.os.SystemClock;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public final class GdtDwellTimeStatisticsAfterClick
{
  private long jdField_a_of_type_Long = -2147483648L;
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public GdtDwellTimeStatisticsAfterClick(GdtAd paramGdtAd, WeakReference<View> paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null);
  }
  
  private void b()
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
          d();
          return;
        }
        ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).postDelayed(new GdtDwellTimeStatisticsAfterClick.CheckRunnable(localWeakReference), 100L);
        return;
      }
      this.b = false;
      this.jdField_a_of_type_Boolean = false;
      d();
      return;
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      if (!((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isShown())
      {
        this.b = true;
        c();
        ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).postDelayed(new GdtDwellTimeStatisticsAfterClick.CheckRunnable(localWeakReference), 100L);
        return;
      }
      ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).postDelayed(new GdtDwellTimeStatisticsAfterClick.CheckRunnable(localWeakReference), 100L);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    abrl.b("GdtDwellTimeStatisticsAfterClick", String.format("enter %d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  private void d()
  {
    long l = SystemClock.elapsedRealtime();
    abrl.b("GdtDwellTimeStatisticsAfterClick", String.format("leave %d", new Object[] { Long.valueOf(l) }));
    if (this.jdField_a_of_type_Long == -2147483648L) {
      abrl.d("GdtDwellTimeStatisticsAfterClick", "leave error");
    }
    l -= this.jdField_a_of_type_Long;
    abrl.b("GdtDwellTimeStatisticsAfterClick", String.format("dwell %d", new Object[] { Long.valueOf(l) }));
    this.jdField_a_of_type_Long = -2147483648L;
    abrr localabrr = new abrr();
    localabrr.jdField_a_of_type_ComTencentAdTangramAd = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    localabrr.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(42);
    localabrr.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(l);
    abrq.a(localabrr);
  }
  
  public void a()
  {
    if (!a()) {
      abrl.d("GdtDwellTimeStatisticsAfterClick", "click error");
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick
 * JD-Core Version:    0.7.0.1
 */