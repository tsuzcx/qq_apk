package com.tencent.gdtad.api.motivevideo;

import aalg;
import aanp;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import java.lang.ref.WeakReference;

class GdtMvDownloadBtnManager$FirstLoadDataTask
  implements Runnable
{
  private WeakReference<GdtMvDownloadBtnManager> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  
  private void a(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    aanp.a("FirstLoadDataTask", "postResultToUI() called with: tempAppBtnData = [" + paramGdtMvAppBtnData + "]");
    new Handler(Looper.getMainLooper()).post(new GdtMvDownloadBtnManager.FirstLoadDataTask.1(this, paramGdtMvAppBtnData));
  }
  
  public void run()
  {
    aanp.a("FirstLoadDataTask", "run() called");
    if (this.jdField_a_of_type_Boolean) {}
    GdtMvDownloadBtnManager localGdtMvDownloadBtnManager;
    do
    {
      return;
      localGdtMvDownloadBtnManager = (GdtMvDownloadBtnManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localGdtMvDownloadBtnManager == null) || (GdtMvDownloadBtnManager.a(localGdtMvDownloadBtnManager) == null) || (TextUtils.isEmpty(GdtMvDownloadBtnManager.a(localGdtMvDownloadBtnManager).getUrlForClick())));
    GdtMvAppBtnData localGdtMvAppBtnData = new aalg().a(GdtMvDownloadBtnManager.a(localGdtMvDownloadBtnManager).getUrlForClick(), "&gd=1", 1);
    if ((localGdtMvAppBtnData != null) && (localGdtMvAppBtnData.isValid()))
    {
      GdtMvDownloadBtnManager.a(localGdtMvAppBtnData.apkUrlhttp);
      GdtMvDownloadBtnManager.b(localGdtMvDownloadBtnManager, localGdtMvAppBtnData);
      a(localGdtMvAppBtnData);
      return;
    }
    aanp.b("FirstLoadDataTask", "load gdt mv app btn data error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager.FirstLoadDataTask
 * JD-Core Version:    0.7.0.1
 */