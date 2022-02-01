package com.tencent.ad.tangram.views.form.framework;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.views.form.AdFormData;
import com.tencent.ad.tangram.views.form.AdFormError;
import java.lang.ref.WeakReference;

final class b$1
  implements Runnable
{
  b$1(Context paramContext, Ad paramAd, AdFormData paramAdFormData, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdFormError localAdFormError = b.access$000(this.val$context, this.val$ad, this.val$formData);
    WeakReference localWeakReference = this.val$listener;
    if (localWeakReference != null)
    {
      if (localWeakReference.get() == null) {
        return;
      }
      new Handler(Looper.getMainLooper()).post(new b.1.1(this, localAdFormError));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.b.1
 * JD-Core Version:    0.7.0.1
 */