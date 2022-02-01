package com.tencent.ad.tangram.views.form.framework;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.views.form.AdFormData;
import com.tencent.ad.tangram.views.form.AdFormError;
import java.lang.ref.WeakReference;

public final class b
{
  private static final String TAG = "AdFormCommitUtil";
  
  private static AdFormError commit(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    if ((paramAd != null) && (paramAd.isValid()) && (paramAd.getActionSetId() != -2147483648L) && (paramAdFormData != null) && (paramAdFormData.isValid()))
    {
      f.prefetch(paramContext, paramAd, paramAdFormData);
      AdFormError localAdFormError = j.upload(paramAdFormData);
      if ((localAdFormError != null) && (localAdFormError.type == 1)) {
        com.tencent.ad.tangram.statistics.form.a.reportUpload(paramContext, paramAd, paramAdFormData);
      }
      return localAdFormError;
    }
    AdLog.e("AdFormCommitUtil", "commit error");
    return new AdFormError(4, -1, null);
  }
  
  public static void commitAsync(Context paramContext, Ad paramAd, AdFormData paramAdFormData, WeakReference<a> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      ((a)paramWeakReference.get()).beforeCommit();
    }
    AdThreadManager.INSTANCE.post(new b.1(paramContext, paramAd, paramAdFormData, paramWeakReference), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.b
 * JD-Core Version:    0.7.0.1
 */