package com.tencent.gdtad.basics.motivevideo;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.elements.GdtMvElementsController;
import com.tencent.gdtad.basics.motivevideo.js.GdtMvWebJsAction;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtMvMiniAppReportHelper;
import com.tencent.gdtad.basics.motivevideo.web.bottomcrad.GdtMVWebBottomCardController;
import com.tencent.gdtad.basics.motivevideo.web.endcrad.GdtMVEndcardWebController;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class GdtMvViewController$MvWebJsCallAction
  implements GdtMvWebJsAction
{
  private GdtMvViewController$MvWebJsCallAction(GdtMvViewController paramGdtMvViewController) {}
  
  public String a(String paramString)
  {
    int i;
    if ((GdtMvViewController.m(this.a) != null) && (GdtMvViewController.m(this.a).d() != null) && (GdtMvViewController.m(this.a).a() != null))
    {
      i = 0;
    }
    else
    {
      QLog.i("Web", 1, "onGetAdInfo fail data empty");
      i = 1;
    }
    if (TextUtils.isEmpty(GdtMvViewController.m(this.a).a().adsContent))
    {
      QLog.i("Web", 1, "onGetAdInfo fail adsContent empty");
      i = 1;
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(GdtMvViewController.m(this.a).d().getTraceId())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetAdInfo fail req=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",local=");
      localStringBuilder.append(GdtMvViewController.m(this.a).d().getTraceId());
      QLog.i("Web", 1, localStringBuilder.toString());
      i = 1;
    }
    if (i != 0)
    {
      if (GdtMvViewController.o(this.a) != null) {
        GdtMvViewController.o(this.a).a();
      }
      if (GdtMvViewController.b(this.a) != null) {
        GdtMvViewController.b(this.a).b();
      }
      return "";
    }
    if (GdtMvViewController.b(this.a) != null) {
      GdtMvViewController.b(this.a).c();
    }
    return GdtMvViewController.m(this.a).a().adsContent;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMvViewController", 2, "onVideoClose");
    }
    this.a.b(false);
    if (GdtADFlyingStreamingReportHelper.a().b() == 1) {
      GdtADFlyingStreamingReportHelper.a().a(1020038L);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (GdtMvViewController.p(this.a) != null)
    {
      GdtMvViewController.p(this.a).a(1, paramString, paramBoolean);
      return;
    }
    QLog.i("Web", 1, "mvAnimationController null");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMvViewController", 2, "onVideoMute");
    }
    this.a.a(false);
  }
  
  public void b(String paramString)
  {
    try
    {
      localJSONObject = new JSONObject(paramString);
      localObject = localJSONObject;
    }
    catch (JSONException localJSONException1)
    {
      JSONObject localJSONObject;
      Object localObject;
      label45:
      label47:
      label80:
      break label45;
    }
    try
    {
      if (GdtMvViewController.k(this.a) == null) {
        break label80;
      }
      localJSONObject.put("pd", GdtMvViewController.k(this.a).getCurrentPosition());
      localObject = localJSONObject;
    }
    catch (JSONException localJSONException2)
    {
      break label47;
    }
    localJSONObject = null;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReportAntiSpam,json error:");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("GdtMvViewController", 1, ((StringBuilder)localObject).toString());
    localObject = localJSONObject;
    this.a.d.a((JSONObject)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.MvWebJsCallAction
 * JD-Core Version:    0.7.0.1
 */