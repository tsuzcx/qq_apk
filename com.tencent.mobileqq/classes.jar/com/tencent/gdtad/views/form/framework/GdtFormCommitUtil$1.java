package com.tencent.gdtad.views.form.framework;

import android.os.Handler;
import android.os.Looper;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.form.GdtFormData;
import java.lang.ref.WeakReference;
import yqq;
import yqu;

public final class GdtFormCommitUtil$1
  implements Runnable
{
  public GdtFormCommitUtil$1(GdtAd paramGdtAd, GdtFormData paramGdtFormData, WeakReference paramWeakReference) {}
  
  public void run()
  {
    yqq localyqq = yqu.a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new GdtFormCommitUtil.1.1(this, localyqq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormCommitUtil.1
 * JD-Core Version:    0.7.0.1
 */