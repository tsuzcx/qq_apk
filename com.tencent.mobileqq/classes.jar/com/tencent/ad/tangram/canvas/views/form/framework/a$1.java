package com.tencent.ad.tangram.canvas.views.form.framework;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import java.lang.ref.WeakReference;

final class a$1
  implements Runnable
{
  a$1(Context paramContext, Ad paramAd, AdFormData paramAdFormData, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdFormError localAdFormError = a.access$000(this.val$context, this.val$ad, this.val$formData);
    if ((this.val$listener == null) || (this.val$listener.get() == null)) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new a.1.1(this, localAdFormError));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.a.1
 * JD-Core Version:    0.7.0.1
 */