package com.tencent.gdtad.api.motivevideo;

import aapv;
import aase;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;

class GdtMvDownloadBtnManager$1
  implements Runnable
{
  GdtMvDownloadBtnManager$1(GdtMvDownloadBtnManager paramGdtMvDownloadBtnManager) {}
  
  public void run()
  {
    aapv localaapv;
    if (GdtMvDownloadBtnManager.a(this.this$0) != null) {
      localaapv = new aapv();
    }
    for (;;)
    {
      GdtMvDownloadBtnManager.a(this.this$0);
      Object localObject = GdtMvDownloadBtnManager.a(this.this$0).getUrlForClick();
      aase.a("GdtMvDownloadBtnManager", "fetching AppData " + GdtMvDownloadBtnManager.b(this.this$0) + ", url = " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = localaapv.a((String)localObject, "&gd=1", GdtMvDownloadBtnManager.b(this.this$0));
        if ((localObject != null) && (((GdtMvAppBtnData)localObject).isValid()))
        {
          ((GdtMvAppBtnData)localObject).mGdtAd_appId = GdtMvDownloadBtnManager.a(this.this$0).getAppId();
          ((GdtMvAppBtnData)localObject).packageName = GdtMvDownloadBtnManager.a(this.this$0).getAppPackageName();
          ((GdtMvAppBtnData)localObject).name = GdtMvDownloadBtnManager.a(this.this$0).getAdvertiser_corporate_image_name();
          ((GdtMvAppBtnData)localObject).via = GdtMvDownloadBtnManager.a(this.this$0).getVia();
          new Handler(Looper.getMainLooper()).post(new GdtMvDownloadBtnManager.1.1(this, (GdtMvAppBtnData)localObject));
        }
      }
      if (GdtMvDownloadBtnManager.a(this.this$0) != null)
      {
        aase.c("GdtMvDownloadBtnPresenter", "loader sucess!!!");
        this.this$0.e();
      }
      while ((GdtMvDownloadBtnManager.a(this.this$0) != null) || (GdtMvDownloadBtnManager.b(this.this$0) >= 2))
      {
        GdtMvDownloadBtnManager.a(this.this$0, false);
        return;
        aase.c("GdtMvDownloadBtnPresenter", "loader failed!!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager.1
 * JD-Core Version:    0.7.0.1
 */