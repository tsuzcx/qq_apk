package com.tencent.gdtad.api.feedback;

import android.app.Activity;
import com.tencent.gdtad.aditem.GdtAd;
import java.lang.ref.WeakReference;

public final class StartGdtFeedbackParams
{
  public int a;
  public GdtAd a;
  public WeakReference<Activity> a;
  public boolean a;
  public WeakReference<GdtFeedbackListener> b;
  
  public static StartGdtFeedbackParams a(WeakReference<Activity> paramWeakReference, WeakReference<GdtFeedbackListener> paramWeakReference1, GdtAd paramGdtAd)
  {
    return a(paramWeakReference, paramWeakReference1, paramGdtAd, 0);
  }
  
  public static StartGdtFeedbackParams a(WeakReference<Activity> paramWeakReference, WeakReference<GdtFeedbackListener> paramWeakReference1, GdtAd paramGdtAd, int paramInt)
  {
    return a(paramWeakReference, paramWeakReference1, paramGdtAd, paramInt, false);
  }
  
  public static StartGdtFeedbackParams a(WeakReference<Activity> paramWeakReference, WeakReference<GdtFeedbackListener> paramWeakReference1, GdtAd paramGdtAd, int paramInt, boolean paramBoolean)
  {
    StartGdtFeedbackParams localStartGdtFeedbackParams = new StartGdtFeedbackParams();
    localStartGdtFeedbackParams.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    localStartGdtFeedbackParams.b = paramWeakReference1;
    localStartGdtFeedbackParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    localStartGdtFeedbackParams.jdField_a_of_type_Int = paramInt;
    localStartGdtFeedbackParams.jdField_a_of_type_Boolean = paramBoolean;
    return localStartGdtFeedbackParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.StartGdtFeedbackParams
 * JD-Core Version:    0.7.0.1
 */