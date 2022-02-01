package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView.PatchAdListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
import com.tencent.mobileqq.kandian.biz.feeds.api.CountDownCallback;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFullPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.ArticlePatchStatus;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

final class ReadInJoyPatchAdUtils$3
  implements ReadInJoyPatchAdView.PatchAdListener
{
  ReadInJoyPatchAdUtils$3(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Activity paramActivity, IVideoUIManager paramIVideoUIManager, IVideoPlayManager paramIVideoPlayManager, CountDownCallback paramCountDownCallback, IVideoFullPlayController paramIVideoFullPlayController, OnPatchPlayListener paramOnPatchPlayListener) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = ReadInJoyPatchAdUtils.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart: id = ");
      localStringBuilder.append(paramVideoPlayParam.D.mArticleID);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    ReadInJoyPatchAdUtils.a(paramVideoPlayParam, paramInt, 1);
    ReadInJoyPatchAdUtils.b();
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {
      return;
    }
    this.a.a.clickPos = paramInt2;
    if (paramInt1 == 1) {
      paramVideoPlayParam.D.patchStatus.b.set(true);
    } else {
      paramVideoPlayParam.D.patchStatus.d.set(true);
    }
    paramVideoPlayParam = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.b, this.a.a, null, 3, true, null);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.b).a(1).b(8).b(paramVideoPlayParam).c(paramInt2).a(this.a.a));
  }
  
  public void b(VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {
      return;
    }
    int i = 1;
    if ((paramInt == 1) && (!paramVideoPlayParam.D.patchStatus.e.get()))
    {
      paramVideoPlayParam.D.patchStatus.e.set(true);
      paramInt = i;
    }
    else if ((paramInt == 2) && (!paramVideoPlayParam.D.patchStatus.f.get()))
    {
      paramVideoPlayParam.D.patchStatus.f.set(true);
      paramInt = i;
    }
    else
    {
      paramInt = 0;
    }
    if (paramInt != 0) {
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(2).b(4).a(this.a.a).e(new JSONObject()));
    }
  }
  
  public void b(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = ReadInJoyPatchAdUtils.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompletion: id = ");
      localStringBuilder.append(paramVideoPlayParam.D.mArticleID);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    ReadInJoyPatchAdUtils.a(paramVideoPlayParam, paramInt1, 3);
    this.a.setVisibility(8);
    this.a.a();
    if (paramInt1 == 1)
    {
      if (this.c.b() == paramVideoPlayParam)
      {
        if (paramInt2 != 1)
        {
          this.d.a(paramVideoPlayParam);
          return;
        }
        this.d.c();
      }
    }
    else
    {
      localObject = this.e;
      if ((localObject != null) && (paramInt2 == 0))
      {
        ((CountDownCallback)localObject).a(paramVideoPlayParam);
        this.f.a();
      }
    }
  }
  
  public void c(VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = ReadInJoyPatchAdUtils.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume: id = ");
      localStringBuilder.append(paramVideoPlayParam.D.mArticleID);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.c.b().D.patchStatus.a.get() == 2)
    {
      ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).playPrePatchAd(this.c.b(), this.c, true, this.g);
      return;
    }
    if (this.c.b().D.patchStatus.c.get() == 2) {
      ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).playPostPatchAd(this.c.b(), this.c, false, true, this.e, this.f, this.g);
    }
  }
  
  public void d(VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if (!ReadInJoyPatchAdUtils.a(paramVideoPlayParam)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = ReadInJoyPatchAdUtils.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause: id = ");
      localStringBuilder.append(paramVideoPlayParam.D.mArticleID);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.c.b().D.patchStatus.a.get() == 1) {
      this.c.b().D.patchStatus.a.set(2);
    } else if (this.c.b().D.patchStatus.c.get() == 1) {
      this.c.b().D.patchStatus.c.set(2);
    }
    paramVideoPlayParam = this.a;
    if (paramVideoPlayParam != null) {
      paramVideoPlayParam.a();
    }
    ReadInJoyPatchAdUtils.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils.3
 * JD-Core Version:    0.7.0.1
 */