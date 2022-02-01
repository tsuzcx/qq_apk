package com.tencent.gdtad.api.motivebrowsing;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import rx.Subscription;
import rx.functions.Action1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"}, k=3, mv={1, 1, 16})
final class GdtMotiveBrowsingViewModel$resumeCountDown$1<T>
  implements Action1<Long>
{
  GdtMotiveBrowsingViewModel$resumeCountDown$1(GdtMotiveBrowsingViewModel paramGdtMotiveBrowsingViewModel) {}
  
  public final void a(Long paramLong)
  {
    paramLong = this.a;
    GdtMotiveBrowsingViewModel.a(paramLong, GdtMotiveBrowsingViewModel.a(paramLong) - 1);
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "onCountDown subscribe value : " + GdtMotiveBrowsingViewModel.a(this.a));
    }
    if (GdtMotiveBrowsingViewModel.a(this.a) <= 0)
    {
      GdtMotiveBrowsingViewModel.a(this.a, GdtMotiveBrowsingViewModel.a(this.a));
      GdtMotiveBrowsingViewModel.b(this.a, (Subscription)null);
    }
    this.a.a().setValue(new MotiveBrowsingData(1, null, GdtMotiveBrowsingViewModel.a(this.a), 2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingViewModel.resumeCountDown.1
 * JD-Core Version:    0.7.0.1
 */