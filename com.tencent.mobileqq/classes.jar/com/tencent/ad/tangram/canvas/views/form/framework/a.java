package com.tencent.ad.tangram.canvas.views.form.framework;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.report.AdDMPReportUtil;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

public final class a
{
  private static final String TAG = "AdFormCommitUtil";
  
  private static AdFormError commit(Context paramContext, Ad paramAd, AdFormData paramAdFormData)
  {
    Object localObject;
    if ((paramAd == null) || (!paramAd.isValid()) || (paramAd.getActionSetId() == -2147483648L) || (paramAdFormData == null) || (!paramAdFormData.isValid()))
    {
      AdLog.e("AdFormCommitUtil", "commit error");
      localObject = new AdFormError(4, -1, null);
    }
    AdFormError localAdFormError;
    do
    {
      do
      {
        return localObject;
        b.prefetch(paramContext, paramAd, paramAdFormData);
        localAdFormError = e.upload(paramAdFormData);
        localObject = localAdFormError;
      } while (localAdFormError == null);
      localObject = localAdFormError;
    } while (localAdFormError.type != 1);
    AdDMPReportUtil.reportUpload(paramContext, paramAd, paramAdFormData);
    return localAdFormError;
  }
  
  public static void commitAsync(Context paramContext, Ad paramAd, AdFormData paramAdFormData, WeakReference<AdFormCommitListener> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      ((AdFormCommitListener)paramWeakReference.get()).beforeCommit();
    }
    AdThreadManager.INSTANCE.post(new a.1(paramContext, paramAd, paramAdFormData, paramWeakReference), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.a
 * JD-Core Version:    0.7.0.1
 */