package com.tencent.gdtad.api.motivevideo;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.webbottomcard.GdtMVWebBottomCardController;
import com.tencent.gdtad.jsbridge.GdtMvWebJsCallHandler.Action;
import com.tencent.mobileqq.apollo.process.video.ICmGameVideoPlayer;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class GdtMvViewController$MvWebJsCallAction
  implements GdtMvWebJsCallHandler.Action
{
  private GdtMvViewController$MvWebJsCallAction(GdtMvViewController paramGdtMvViewController) {}
  
  public String a(String paramString)
  {
    int i = 0;
    if ((GdtMvViewController.a(this.a) == null) || (GdtMvViewController.a(this.a).a() == null) || (GdtMvViewController.a(this.a).a() == null))
    {
      QLog.i("Web", 1, "onGetAdInfo fail data empty");
      i = 1;
    }
    if (TextUtils.isEmpty(GdtMvViewController.a(this.a).a().adsContent))
    {
      QLog.i("Web", 1, "onGetAdInfo fail adsContent empty");
      i = 1;
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(GdtMvViewController.a(this.a).a().getTraceId())))
    {
      QLog.i("Web", 1, "onGetAdInfo fail req=" + paramString + ",local=" + GdtMvViewController.a(this.a).a().getTraceId());
      i = 1;
    }
    if (i != 0)
    {
      if (GdtMvViewController.a(this.a) != null) {
        GdtMvViewController.a(this.a).a();
      }
      if (GdtMvViewController.a(this.a) != null) {
        GdtMvViewController.a(this.a).c();
      }
      return "";
    }
    if (GdtMvViewController.a(this.a) != null) {
      GdtMvViewController.a(this.a).d();
    }
    return GdtMvViewController.a(this.a).a().adsContent;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMvViewController", 2, "onVideoClose");
    }
    this.a.a(false);
    if (GdtADFlyingStreamingReportHelper.a().a() == 1) {
      GdtADFlyingStreamingReportHelper.a().a(1020038L);
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject2 = localJSONObject;
        QLog.e("GdtMvViewController", 1, "onReportAntiSpam,json error:" + paramString);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (GdtMvViewController.a(this.a) != null)
          {
            localJSONObject.put("pd", GdtMvViewController.a(this.a).b());
            localObject2 = localJSONObject;
          }
          this.a.a.a((JSONObject)localObject2);
          return;
        }
        catch (JSONException localJSONException2)
        {
          Object localObject2;
          Object localObject1;
          break label57;
        }
        localJSONException1 = localJSONException1;
        localObject1 = null;
      }
      label57:
      localObject2 = localObject1;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (GdtMvViewController.a(this.a) != null)
    {
      GdtMvViewController.a(this.a).a(1, paramString, paramBoolean);
      if (GdtADFlyingStreamingReportHelper.a().a() != 2) {
        break label54;
      }
      GdtADFlyingStreamingReportHelper.a().a(1020015L);
    }
    label54:
    while (GdtADFlyingStreamingReportHelper.a().a() != 1)
    {
      return;
      QLog.i("Web", 1, "mvAnimationController null");
      break;
    }
    GdtADFlyingStreamingReportHelper.a().a(1020014L);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMvViewController", 2, "onVideoMute");
    }
    this.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.MvWebJsCallAction
 * JD-Core Version:    0.7.0.1
 */