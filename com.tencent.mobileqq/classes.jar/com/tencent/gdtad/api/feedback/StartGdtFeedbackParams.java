package com.tencent.gdtad.api.feedback;

import android.app.Activity;
import com.tencent.gdtad.aditem.GdtAd;
import java.lang.ref.WeakReference;

public final class StartGdtFeedbackParams
{
  public WeakReference<Activity> a;
  public WeakReference<GdtFeedbackListener> b;
  public GdtAd c;
  public int d;
  public boolean e;
  
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
    localStartGdtFeedbackParams.a = paramWeakReference;
    localStartGdtFeedbackParams.b = paramWeakReference1;
    localStartGdtFeedbackParams.c = paramGdtAd;
    localStartGdtFeedbackParams.d = paramInt;
    localStartGdtFeedbackParams.e = paramBoolean;
    return localStartGdtFeedbackParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.StartGdtFeedbackParams
 * JD-Core Version:    0.7.0.1
 */