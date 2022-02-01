package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallItemStrategy;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import cooperation.vip.VasAdvSupport;
import java.util.ArrayList;
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
      String str = "weishi://feed?feed_id=" + paramstSimpleMetaFeed.id;
      if (!TextUtils.isEmpty(paramstSimpleMetaFeed.weishi_jump_url)) {
        str = paramstSimpleMetaFeed.weishi_jump_url;
      }
      return str;
    }
    return null;
  }
  
  private void a(Context paramContext, int paramInt1, String paramString, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        int i = a();
        WSLog.d("WSGridCardPresenter", "open weishi scheme = " + paramString + ", weishi_jump_url = " + paramstSimpleMetaFeed.weishi_jump_url);
        WeishiScehmeUtil.a(paramContext.getApplicationContext(), "biz_src_jc_gzh_weishi", paramString, 1, i, paramInt2);
        UserActionReportPresenter.a(1, 114, paramInt1, paramstSimpleMetaFeed, null);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        WSLog.d("WSGridCardPresenter", "open weishi error scheme = " + paramString);
        return;
      }
      paramString = a(paramstSimpleMetaFeed);
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
    if ((paramstSimpleMetaFeed != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.id))) {
      return "weishi://feed?feed_id=" + paramstSimpleMetaFeed.id + "&logsour=2020020032";
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
    Activity localActivity;
    if (i < 10000)
    {
      i = 104;
      localWSDownloadParams.mEventId = i;
      localWSDownloadParams.mTestId = WSReportDc00898.b();
      localWSDownloadParams.mScheme = a(paramstSimpleMetaFeed);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardContract$View.a();
      localActivity = (Activity)paramContext;
      if (localObject == null) {
        break label154;
      }
      paramContext = ((WSRecommendAdapter)localObject).a();
      label98:
      if (localObject == null) {
        break label159;
      }
    }
    label154:
    label159:
    for (Object localObject = ((WSRecommendAdapter)localObject).a();; localObject = null)
    {
      WeishiDownloadUtil.a(localActivity, localWSDownloadParams, paramContext, (RockDownloadListenerWrapper)localObject);
      UserActionReportPresenter.a(1, 115, paramInt, paramstSimpleMetaFeed, WeishiDownloadUtil.a(localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId));
      return;
      i = 100;
      break;
      paramContext = null;
      break label98;
    }
  }
  
  private void d(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed.video != null)
    {
      stH5OpInfo localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
      if ((localstH5OpInfo != null) && (!TextUtils.isEmpty(localstH5OpInfo.h5Url)))
      {
        RIJJumpUtils.a(paramContext, localstH5OpInfo.h5Url);
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
      paramContext = JumpParser.a(((BaseActivity)paramContext).app, paramContext, paramstSimpleMetaFeed.video_url + "&click_index=" + (paramInt + 1));
      if (paramContext != null) {
        paramContext.a();
      }
      com.tencent.mobileqq.intervideo.now.dynamic.NowWeishiReportData.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.id;
      com.tencent.mobileqq.intervideo.now.dynamic.NowWeishiReportData.b = paramstSimpleMetaFeed.feed_desc;
      com.tencent.mobileqq.intervideo.now.dynamic.NowWeishiReportData.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(Context paramContext, int paramInt, ArrayList<stSimpleMetaFeed> paramArrayList, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    VasAdvSupport.a().a();
    paramArrayList.add(paramstSimpleMetaFeed);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardContract$View.a().c = (paramInt - 0);
    WSReportUtils.b(String.valueOf(System.currentTimeMillis()));
    WSVerticalBeaconReport.a(paramInt);
    WSVerticalBeaconReport.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString);
    WSVerticalBeaconReport.a(paramstSimpleMetaFeed.id);
    WSVerticalPageFragment.a(new WSVerticalPageOpenParams(paramContext, "recommend_tab", "feeds").b(paramBoolean).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString).a(paramArrayList).a(0).a(false));
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
  
  public boolean a(Context paramContext, int paramInt, ArrayList<stSimpleMetaFeed> paramArrayList, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    boolean bool1;
    label39:
    boolean bool2;
    label55:
    int j;
    if (a() == 2)
    {
      i = 1;
      if (i == 0) {
        break label421;
      }
      Object localObject = paramstSimpleMetaFeed.waterFallItemStrategy;
      if ((localObject == null) || (!((stWaterFallItemStrategy)localObject).isCallWeishi)) {
        break label273;
      }
      bool1 = true;
      if ((localObject == null) || (!((stWaterFallItemStrategy)localObject).isDonwloadWeish)) {
        break label279;
      }
      bool2 = true;
      i = WSGlobalConfig.a().b(1);
      j = WSGlobalConfig.a().c(1);
      if (!WeishiGuideUtils.a(BaseApplicationImpl.getApplication())) {
        break label292;
      }
      bool2 = WSGlobalConfig.a().a(1);
      WSLog.d("WSGridCardPresenter", "openCallWeishi = " + bool1 + ", isOpenVideoPage = " + bool2 + ", callCount = " + i + ", openCallWSCount = " + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_Int);
      if ((!bool1) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_Int >= i)) {
        break label421;
      }
      WSReportDc00898.a(112, Integer.valueOf(114));
      WSGridBeaconReport.a("gzh_click", paramstSimpleMetaFeed, UserActionReportPresenter.a(paramstSimpleMetaFeed, paramInt), 1000003, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
      ((WSRecommendAdapter)localObject).jdField_a_of_type_Int += 1;
      if (i >= 10000) {
        break label285;
      }
    }
    label273:
    label279:
    label285:
    for (int i = 104;; i = 100)
    {
      if (bool2) {
        a(paramContext, paramInt, paramArrayList, paramstSimpleMetaFeed, false);
      }
      a(paramContext, paramInt, paramstSimpleMetaFeed.weishi_jump_url, paramstSimpleMetaFeed, i);
      return true;
      i = 0;
      break;
      bool1 = false;
      break label39;
      bool2 = false;
      break label55;
    }
    label292:
    WSLog.d("WSGridCardPresenter", "openDownloadWeishi = " + bool2 + ", downloadCount = " + j + ", openDownloadWSCount = " + WSRecommendAdapter.b);
    if ((bool2) && (WSRecommendAdapter.b < j))
    {
      WSReportDc00898.a(112, Integer.valueOf(115));
      WSGridBeaconReport.a("gzh_click", paramstSimpleMetaFeed, UserActionReportPresenter.a(paramstSimpleMetaFeed, paramInt), 1000002, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString);
      a(paramContext, paramInt, paramArrayList, paramstSimpleMetaFeed, false);
      ThreadManager.getUIHandler().postDelayed(new WSGridCardPresenter.2(this, paramContext, paramInt, paramstSimpleMetaFeed), 50L);
      return true;
    }
    label421:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridCardPresenter
 * JD-Core Version:    0.7.0.1
 */