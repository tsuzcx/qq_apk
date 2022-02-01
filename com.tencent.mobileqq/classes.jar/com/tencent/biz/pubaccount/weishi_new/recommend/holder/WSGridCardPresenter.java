package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallItemStrategy;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiHelper;
import com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiReport;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSOpenWeiShiData;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import java.util.ArrayList;
import java.util.List;

public class WSGridCardPresenter
  implements WSGridCardContract.Presenter
{
  private final WSGridCardContract.View a;
  private final WSRecommendAdapter b;
  
  public WSGridCardPresenter(WSGridCardContract.View paramView)
  {
    this.a = paramView;
    this.b = this.a.a();
  }
  
  private int a()
  {
    return WSGlobalConfig.a().b(1);
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSVideoPreloadManager.a(paramstSimpleMetaFeed);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridCardPresenter.java][preloadFeedVideo] title:");
    if (paramstSimpleMetaFeed != null) {
      paramstSimpleMetaFeed = paramstSimpleMetaFeed.feed_desc;
    } else {
      paramstSimpleMetaFeed = "feedNull!";
    }
    localStringBuilder.append(paramstSimpleMetaFeed);
    WSLog.e("WSGridCardPresenterLog", localStringBuilder.toString());
  }
  
  private void a(Context paramContext, int paramInt1, String paramString, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = b(paramstSimpleMetaFeed);
    }
    try
    {
      int i = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open weishi scheme = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", weishi_jump_url = ");
      localStringBuilder.append(paramstSimpleMetaFeed.weishi_jump_url);
      WSLog.d("WSGridCardPresenterLog", localStringBuilder.toString());
      WeishiScehmeUtil.a(paramContext.getApplicationContext(), "biz_src_jc_gzh_weishi", paramString, 1, i, paramInt2);
      UserActionReportPresenter.a(1, 114, paramInt1, paramstSimpleMetaFeed, null);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = new StringBuilder();
      paramContext.append("open weishi error scheme = ");
      paramContext.append(paramString);
      WSLog.d("WSGridCardPresenterLog", paramContext.toString());
    }
  }
  
  private void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = a();
    localWSDownloadParams.mEventId = 501;
    localWSDownloadParams.mTestId = WSReportDc00898.b();
    localWSDownloadParams.mScheme = b(paramstSimpleMetaFeed);
    WeishiDownloadUtil.a((Activity)paramContext, localWSDownloadParams, false);
  }
  
  private String b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("weishi://feed?feed_id=");
      ((StringBuilder)localObject).append(paramstSimpleMetaFeed.id);
      localObject = ((StringBuilder)localObject).toString();
      if (!TextUtils.isEmpty(paramstSimpleMetaFeed.weishi_jump_url)) {
        localObject = paramstSimpleMetaFeed.weishi_jump_url;
      }
      return localObject;
    }
    return null;
  }
  
  private void b(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed.video != null)
    {
      stH5OpInfo localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
      if ((localstH5OpInfo != null) && (!TextUtils.isEmpty(localstH5OpInfo.h5Url)))
      {
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramContext, localstH5OpInfo.h5Url);
        WSReportDc00898.a(140, localstH5OpInfo.type, paramInt, paramstSimpleMetaFeed.h5_op_info.id);
        WSGridBeaconReport.a("gzh_click", 1000004, paramstSimpleMetaFeed, this.b.l);
      }
    }
  }
  
  private String c(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.id)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("weishi://feed?feed_id=");
      localStringBuilder.append(paramstSimpleMetaFeed.id);
      localStringBuilder.append("&logsour=2020020032");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSReportDc00898.a(true);
    if ((paramContext instanceof BaseActivity))
    {
      QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramstSimpleMetaFeed.video_url);
      localStringBuilder.append("&click_index=");
      localStringBuilder.append(paramInt + 1);
      paramContext = JumpParser.a(localQQAppInterface, paramContext, localStringBuilder.toString());
      if (paramContext != null) {
        paramContext.a();
      }
      com.tencent.mobileqq.intervideo.now.dynamic.NowWeishiReportData.a = paramstSimpleMetaFeed.id;
      com.tencent.mobileqq.intervideo.now.dynamic.NowWeishiReportData.b = paramstSimpleMetaFeed.feed_desc;
      com.tencent.mobileqq.intervideo.now.dynamic.NowWeishiReportData.c = paramInt;
    }
  }
  
  public void a(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    a(paramstSimpleMetaFeed);
    ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).initTbsEnvironment();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramstSimpleMetaFeed);
    this.a.a().g = (paramInt + 0);
    WSLauncher.VerticalPageLauncher.a(new WSVerticalPageOpenParams(paramContext, "recommend_tab", "feeds").b(paramBoolean1).a(this.b.l).a(localArrayList).a(0).a(false).c(paramInt).b(paramstSimpleMetaFeed.id).c(String.valueOf(System.currentTimeMillis())).c(paramBoolean2).a(paramView));
    if ((paramInt == 0) && (paramstSimpleMetaFeed.video_type == 7))
    {
      WSReportDc00898.a(141, paramstSimpleMetaFeed.id);
      return;
    }
    WSReportDc00898.a(112, Integer.valueOf(2));
  }
  
  public void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (paramstSimpleMetaFeed.h5_op_info != null)
    {
      WSReportDc00898.a(112, paramstSimpleMetaFeed.h5_op_info.type, paramInt, paramstSimpleMetaFeed.h5_op_info.id);
      String str3 = paramstSimpleMetaFeed.h5_op_info.h5Url;
      String str2 = paramstSimpleMetaFeed.h5_op_info.scheme_url;
      String str1;
      if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)))
      {
        str1 = str2;
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (str2.startsWith("weishi://")) {}
        }
      }
      else
      {
        str1 = c(paramstSimpleMetaFeed);
      }
      WeishiUtils.a(paramContext, str1, str3, "", paramstSimpleMetaFeed.h5_op_info.type, new WSGridCardPresenter.1(this, paramContext, paramInt, paramstSimpleMetaFeed));
    }
  }
  
  public boolean a(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, View paramView)
  {
    int i;
    if (a() == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Object localObject = paramstSimpleMetaFeed.waterFallItemStrategy;
      boolean bool1;
      if ((localObject != null) && (((stWaterFallItemStrategy)localObject).isCallWeishi)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      i = WSGlobalConfig.a().c(1);
      if (WeishiGuideUtils.a(BaseApplicationImpl.getApplication()))
      {
        boolean bool2 = WSGlobalConfig.a().d(1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openCallWeishi = ");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(", isOpenVideoPage = ");
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append(", callCount = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", openCallWSCount = ");
        ((StringBuilder)localObject).append(this.b.e);
        WSLog.d("WSGridCardPresenterLog", ((StringBuilder)localObject).toString());
        if ((bool1) && (this.b.e < i))
        {
          WSReportDc00898.a(112, Integer.valueOf(114));
          WSGridBeaconReport.a("gzh_click", paramstSimpleMetaFeed, UserActionReportPresenter.a(paramstSimpleMetaFeed, paramInt), 1000003, this.b.l);
          localObject = this.b;
          ((WSRecommendAdapter)localObject).e += 1;
          if (i < 10000) {
            i = 104;
          } else {
            i = 100;
          }
          bool1 = WSExpABTestManager.a().w();
          if (bool2)
          {
            a(paramContext, paramInt, paramstSimpleMetaFeed, false, bool1, paramView);
          }
          else if (bool1)
          {
            paramView = WSExpABTestManager.a().x();
            paramView.e(paramstSimpleMetaFeed.weishi_jump_url);
            WSOpenWeiShiHelper.a().a(paramContext, paramView, WSOpenWeiShiReport.a(paramstSimpleMetaFeed, "fullscreen_videoplay", this.b.l, "feeds"));
          }
          if (!bool1) {
            a(paramContext, paramInt, paramstSimpleMetaFeed.weishi_jump_url, paramstSimpleMetaFeed, i);
          }
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridCardPresenter
 * JD-Core Version:    0.7.0.1
 */