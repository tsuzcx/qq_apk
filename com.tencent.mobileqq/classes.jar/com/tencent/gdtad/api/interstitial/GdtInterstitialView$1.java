package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

final class GdtInterstitialView$1
  implements ArkViewImplement.LoadCallback
{
  GdtInterstitialView$1(long paramLong, String paramString, WeakReference paramWeakReference1, WeakReference paramWeakReference2, GdtInterstitialParams paramGdtInterstitialParams) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    int j = GdtArkUtil.a(paramInt2);
    int i = j;
    if (j == 0) {
      i = 1;
    }
    GdtLog.b("GdtInterstitialView", String.format("onLoadFailed state:%d duration:%d errCode:%d msg:%s canRetry:%b error:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(i) }));
    GdtInterstitialView.a(i, paramInt2, this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!((GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d))
    {
      ((GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d = true;
      GdtAnalysisHelperForInterstitial.a((Context)this.b.get(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, (GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get(), i, paramInt2);
    }
  }
  
  public void onLoadState(int paramInt)
  {
    GdtLog.b("GdtInterstitialView", String.format("onLoadState state:%d duration:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) }));
    if ((paramInt == 1) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!((GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d))
    {
      ((GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d = true;
      ((GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c = true;
      GdtAnalysisHelperForInterstitial.a((Context)this.b.get(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, (GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0, -2147483648);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialView.1
 * JD-Core Version:    0.7.0.1
 */