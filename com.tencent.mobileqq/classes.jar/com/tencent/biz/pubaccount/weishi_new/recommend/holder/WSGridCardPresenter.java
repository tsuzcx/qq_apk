package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallItemStrategy;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiHelper;
import com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiReport;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSOpenWeiShiData;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class WSGridCardPresenter
  implements WSGridCardContract.Presenter
{
  private final WSRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
  private final WSGridCardContract.View jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardContract$View;
  
  public WSGridCardPresenter(WSGridCardContract.View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardContract$View = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardContract$View.a();
  }
  
  private int a()
  {
    return WSGlobalConfig.a().a(1);
  }
  
  private String a(stSimpleMetaFeed paramstSimpleMetaFeed)
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
  
  private void a(Context paramContext, int paramInt1, String paramString, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = a(paramstSimpleMetaFeed);
    }
    try
    {
      int i = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open weishi scheme = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", weishi_jump_url = ");
      localStringBuilder.append(paramstSimpleMetaFeed.weishi_jump_url);
      WSLog.d("WSGridCardPresenter", localStringBuilder.toString());
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
      WSLog.d("WSGridCardPresenter", paramContext.toString());
    }
  }
  
  private void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = a();
    localWSDownloadParams.mEventId = 501;
    localWSDownloadParams.mTestId = WSReportDc00898.b();
    localWSDownloadParams.mScheme = a(paramstSimpleMetaFeed);
    WeishiDownloadUtil.a((Activity)paramContext, localWSDownloadParams, false);
  }
  
  private String b(stSimpleMetaFeed paramstSimpleMetaFeed)
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
  
  private void b(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (WSDeviceUtils.a())
    {
      c(paramContext, paramInt, paramstSimpleMetaFeed);
      return;
    }
    if (WSGlobalConfig.a().a())
    {
      c(paramContext, paramInt, paramstSimpleMetaFeed);
      return;
    }
    WSLog.a("WSGridCardPresenter", "B test do not download when 4g is not open is server");
  }
  
  private void c(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int i = WSGlobalConfig.a().c(1);
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = a();
    if (i < 10000) {
      i = 104;
    } else {
      i = 100;
    }
    localWSDownloadParams.mEventId = i;
    localWSDownloadParams.mTestId = WSReportDc00898.b();
    localWSDownloadParams.mScheme = a(paramstSimpleMetaFeed);
    WSRecommendAdapter localWSRecommendAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardContract$View.a();
    Activity localActivity = (Activity)paramContext;
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = null;
    if (localWSRecommendAdapter != null) {
      paramContext = localWSRecommendAdapter.a();
    } else {
      paramContext = null;
    }
    if (localWSRecommendAdapter != null) {
      localRockDownloadListenerWrapper = localWSRecommendAdapter.a();
    }
    WeishiDownloadUtil.a(localActivity, localWSDownloadParams, paramContext, localRockDownloadListenerWrapper);
    UserActionReportPresenter.a(1, 115, paramInt, paramstSimpleMetaFeed, WeishiDownloadUtil.a(localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId));
  }
  
  private void d(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed.video != null)
    {
      stH5OpInfo localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
      if ((localstH5OpInfo != null) && (!TextUtils.isEmpty(localstH5OpInfo.h5Url)))
      {
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramContext, localstH5OpInfo.h5Url);
        WSReportDc00898.a(140, localstH5OpInfo.type, paramInt, paramstSimpleMetaFeed.h5_op_info.id);
        WSGridBeaconReport.a("gzh_click", 1000004, paramstSimpleMetaFeed, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString);
      }
    }
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
      com.tencent.mobileqq.intervideo.now.dynamic.NowWeishiReportData.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.id;
      com.tencent.mobileqq.intervideo.now.dynamic.NowWeishiReportData.b = paramstSimpleMetaFeed.feed_desc;
      com.tencent.mobileqq.intervideo.now.dynamic.NowWeishiReportData.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).initTbsEnvironment();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramstSimpleMetaFeed);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardContract$View.a().c = (paramInt + 0);
    WSVerticalPageFragment.a(new WSVerticalPageOpenParams(paramContext, "recommend_tab", "feeds").b(paramBoolean1).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString).a(localArrayList).a(0).a(false).c(paramInt).b(paramstSimpleMetaFeed.id).c(String.valueOf(System.currentTimeMillis())).c(paramBoolean2));
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
        str1 = b(paramstSimpleMetaFeed);
      }
      WeishiUtils.a(paramContext, str1, str3, "", paramstSimpleMetaFeed.h5_op_info.type, new WSGridCardPresenter.1(this, paramContext, paramInt, paramstSimpleMetaFeed));
    }
  }
  
  public boolean a(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
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
      boolean bool2;
      if ((localObject != null) && (((stWaterFallItemStrategy)localObject).isDonwloadWeish)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      i = WSGlobalConfig.a().b(1);
      int j = WSGlobalConfig.a().c(1);
      if (WeishiGuideUtils.a(BaseApplicationImpl.getApplication()))
      {
        bool2 = WSGlobalConfig.a().a(1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openCallWeishi = ");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(", isOpenVideoPage = ");
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append(", callCount = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", openCallWSCount = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_Int);
        WSLog.d("WSGridCardPresenter", ((StringBuilder)localObject).toString());
        if ((bool1) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_Int < i))
        {
          WSReportDc00898.a(112, Integer.valueOf(114));
          WSGridBeaconReport.a("gzh_click", paramstSimpleMetaFeed, UserActionReportPresenter.a(paramstSimpleMetaFeed, paramInt), 1000003, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString);
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
          ((WSRecommendAdapter)localObject).jdField_a_of_type_Int += 1;
          if (i < 10000) {
            i = 104;
          } else {
            i = 100;
          }
          bool1 = WSExpABTestManager.a().i();
          if (bool2)
          {
            a(paramContext, paramInt, paramstSimpleMetaFeed, false, bool1);
          }
          else if (bool1)
          {
            localObject = WSExpABTestManager.a().a();
            ((WSOpenWeiShiData)localObject).e(paramstSimpleMetaFeed.weishi_jump_url);
            WSOpenWeiShiHelper.a().a(paramContext, (WSOpenWeiShiData)localObject, WSOpenWeiShiReport.a(paramstSimpleMetaFeed, "fullscreen_videoplay", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString, "feeds"));
          }
          if (!bool1) {
            a(paramContext, paramInt, paramstSimpleMetaFeed.weishi_jump_url, paramstSimpleMetaFeed, i);
          }
          return true;
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openDownloadWeishi = ");
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append(", downloadCount = ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", openDownloadWSCount = ");
        ((StringBuilder)localObject).append(WSRecommendAdapter.b);
        WSLog.d("WSGridCardPresenter", ((StringBuilder)localObject).toString());
        if ((bool2) && (WSRecommendAdapter.b < j))
        {
          WSReportDc00898.a(112, Integer.valueOf(115));
          WSGridBeaconReport.a("gzh_click", paramstSimpleMetaFeed, UserActionReportPresenter.a(paramstSimpleMetaFeed, paramInt), 1000002, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString);
          a(paramContext, paramInt, paramstSimpleMetaFeed, false, false);
          ThreadManager.getUIHandler().postDelayed(new WSGridCardPresenter.2(this, paramContext, paramInt, paramstSimpleMetaFeed), 50L);
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridCardPresenter
 * JD-Core Version:    0.7.0.1
 */