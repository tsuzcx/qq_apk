package com.tencent.gdtad.api.adbox;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class GdtAdBoxDialog$5
  implements AdExposureChecker.ExposureCallback
{
  GdtAdBoxDialog$5(GdtAdBoxDialog paramGdtAdBoxDialog) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    paramWeakReference = (View)paramWeakReference.get();
    if (paramWeakReference == null)
    {
      QLog.i("GdtAdBoxDialog", 1, "onExposure view == null");
      return;
    }
    this.a.a(paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.adbox.GdtAdBoxDialog.5
 * JD-Core Version:    0.7.0.1
 */