package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Pair;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.RIJMiniProgramUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoySrtUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ValueReference;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.guidingchannel.ReadInJoyDailyJumpToKDTabUtils;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.PGCShortContentUtils;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.UGRuleManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.ShareWebPageInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.WendaInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class RIJListViewGroupHandlerClick
{
  public static ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.mChannelID = paramArticleInfo.mChannelID;
    NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    localArticleInfo.mStrategyId = localPackArticleInfo.jdField_a_of_type_Int;
    localArticleInfo.mAlgorithmID = localPackArticleInfo.jdField_b_of_type_Long;
    localArticleInfo.mTitle = localPackArticleInfo.jdField_a_of_type_JavaLangString;
    localArticleInfo.mFirstPagePicUrl = localPackArticleInfo.jdField_c_of_type_JavaLangString;
    localArticleInfo.mArticleContentUrl = localPackArticleInfo.jdField_d_of_type_JavaLangString;
    localArticleInfo.mArticleID = localPackArticleInfo.jdField_a_of_type_Long;
    localArticleInfo.mSubscribeID = localPackArticleInfo.jdField_e_of_type_JavaLangString;
    localArticleInfo.mSubscribeName = localPackArticleInfo.jdField_f_of_type_JavaLangString;
    localArticleInfo.innerUniqueID = localPackArticleInfo.jdField_g_of_type_JavaLangString;
    localArticleInfo.mNewPolymericInfo = paramArticleInfo.mNewPolymericInfo;
    return localArticleInfo;
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramBaseAdapter, paramArticleInfo, true, paramInt1, paramInt2, paramBoolean, 1);
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, ArticleInfo paramArticleInfo, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_name", HardCodeUtil.a(2131713028));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    boolean bool;
    if (!RIJItemViewType.q(paramArticleInfo))
    {
      bool = true;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo);
      paramInt3 = RIJItemViewType.a(paramArticleInfo);
      if ((!paramBoolean1) || ((paramInt3 != 6) && (paramInt3 != 28) && (paramInt3 != 71))) {
        break label243;
      }
      localIntent.putExtra("is_need_show_animation_translate", true);
      localIntent.putExtra("is_need_show_animation_adapter", true);
      if (paramBoolean2)
      {
        localIntent.putExtra("view_translation_animation_top", paramInt1);
        localIntent.putExtra("view_translation_animation_left", paramInt2);
      }
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      VideoReporter.a.put(ReadInJoyChannelActivity.class, VideoReporter.b());
      VideoVolumeControl.a().a(false, "jumpFromKandianFeed", 1);
      return;
      bool = false;
      break;
      label243:
      if (paramBaseAdapter != null) {
        paramBaseAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void a(View paramView, int paramInt, ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if ((paramView instanceof ProteusItemView)) {
      a((ProteusItemView)paramView, paramBuilder.a());
    }
    for (;;)
    {
      a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, paramBuilder);
      return;
      if ((paramView instanceof LinearLayout)) {
        a((LinearLayout)paramView, paramBuilder.a());
      }
    }
  }
  
  private void a(View paramView, int paramInt, ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder, Handler paramHandler)
  {
    if (a(paramArticleInfo, paramView))
    {
      RIJFrameworkReportManager.a(paramBuilder.a(), paramArticleInfo, paramBuilder.b());
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit Gallery feeds");
    }
    for (;;)
    {
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if (paramBuilder.a() != null) {}
      try
      {
        if (!TextUtils.isEmpty(ViolaAccessHelper.c(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
        {
          paramView = paramHandler;
          if (paramHandler == null) {
            paramView = new Handler(Looper.getMainLooper());
          }
          paramView.postDelayed(new RIJListViewGroupHandlerClick.1(this, paramBuilder), 2000L);
          return;
          b(paramArticleInfo, paramInt - 1, paramBuilder);
        }
        else
        {
          paramBuilder.a().notifyDataSetChanged();
          return;
        }
      }
      catch (Exception paramView)
      {
        paramBuilder.a().notifyDataSetChanged();
      }
    }
  }
  
  private void a(View paramView, ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (VideoFeedsHelper.a(paramArticleInfo, paramBuilder.a())) {}
    do
    {
      return;
      int i = RIJItemViewType.a(paramArticleInfo);
      if ((i == 23) || (i == 26) || (i == 56) || (i == 59) || (i == 19) || (i == 17) || (i == 11) || (i == 28))
      {
        a(paramArticleInfo, paramView, paramBuilder);
        return;
      }
      i = RIJItemViewType.a(paramArticleInfo);
      if (a(paramArticleInfo, i))
      {
        a(paramArticleInfo, paramBuilder, i);
        return;
      }
    } while (!a(paramArticleInfo));
    c(paramArticleInfo, paramBuilder);
  }
  
  private void a(LinearLayout paramLinearLayout, Activity paramActivity)
  {
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131365177);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(paramActivity.getResources().getColor(2131166494));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ProteusItemView paramProteusItemView, Activity paramActivity)
  {
    paramProteusItemView = (TextBase)paramProteusItemView.a().getVirtualView().findViewBaseByName("id_artilce_title");
    if (paramProteusItemView != null)
    {
      paramProteusItemView.setTextColor(paramActivity.getResources().getColor(2131166494));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt)
  {
    String str = paramArticleInfo.mArticleContentUrl;
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      paramActivity.startActivity(localIntent);
    }
    RIJFrameworkReportManager.a(paramActivity, paramArticleInfo, paramInt);
  }
  
  private void a(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (paramReadInJoyBaseAdapter != null) && (!RIJItemViewType.a(paramArticleInfo))) {
      RIJJumpUtils.a(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList == null) || (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("RIJListViewGroupHandlerClick", 1, "handleJumpFullVideoPlayForNewPolymeric, bad data need backend check");
      return;
    }
    a(paramArticleInfo, (NewPolymericInfo.PackArticleInfo)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0), paramView, paramInt, paramReadInJoyBaseAdapter);
  }
  
  private void a(ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder, int paramInt)
  {
    if (b(paramArticleInfo, paramInt)) {
      a(paramArticleInfo, null, 0, 0, false, 0, paramBuilder);
    }
    for (;;)
    {
      a(paramBuilder);
      return;
      if ((paramInt == 95) || (paramInt == 94)) {
        ReadInJoyUtils.a(paramBuilder.a(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo.jdField_a_of_type_JavaLangString);
      } else if (paramArticleInfo.isPGCShortContent()) {
        PGCShortContentUtils.a(paramBuilder.a(), paramArticleInfo);
      } else if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
        a(paramArticleInfo, paramBuilder);
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo, View paramView, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = new VideoPlayManager.VideoPlayParam();
    if (paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo == null) {
      QLog.e("handleJumpFullVideoPlayForNewPolymeric", 2, " bad data need backend check");
    }
    do
    {
      return;
      localVideoPlayParam.jdField_c_of_type_Long = paramPackArticleInfo.jdField_a_of_type_Long;
      localVideoPlayParam.jdField_h_of_type_JavaLangString = (paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_b_of_type_Long + "");
      localVideoPlayParam.jdField_i_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_d_of_type_JavaLangString;
      localVideoPlayParam.jdField_k_of_type_JavaLangString = paramPackArticleInfo.jdField_e_of_type_JavaLangString;
      localVideoPlayParam.jdField_g_of_type_Int = paramPackArticleInfo.jdField_a_of_type_Int;
      localVideoPlayParam.jdField_g_of_type_Long = paramPackArticleInfo.jdField_b_of_type_Long;
      Object localObject = new ReadinjoyVideoReportData();
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramPackArticleInfo.jdField_a_of_type_Long);
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_JavaLangString = paramPackArticleInfo.jdField_g_of_type_JavaLangString;
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_Int = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_a_of_type_Int;
      ((ReadinjoyVideoReportData)localObject).jdField_b_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_a_of_type_JavaLangString;
      localVideoPlayParam.a = ((ReadinjoyVideoReportData)localObject);
      localVideoPlayParam.jdField_b_of_type_JavaLangString = paramPackArticleInfo.jdField_c_of_type_JavaLangString;
      localVideoPlayParam.jdField_c_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_a_of_type_JavaLangString;
      localVideoPlayParam.jdField_f_of_type_Int = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_a_of_type_Int;
      localVideoPlayParam.jdField_c_of_type_Int = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_b_of_type_Int;
      localVideoPlayParam.jdField_d_of_type_Int = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_c_of_type_Int;
      localVideoPlayParam.jdField_b_of_type_Int = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_d_of_type_Int;
      localVideoPlayParam.jdField_e_of_type_Long = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_a_of_type_Long;
      localVideoPlayParam.jdField_j_of_type_JavaLangString = paramPackArticleInfo.jdField_g_of_type_JavaLangString;
      localVideoPlayParam.jdField_g_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_b_of_type_JavaLangString;
      localVideoPlayParam.jdField_d_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_f_of_type_JavaLangString;
      localVideoPlayParam.jdField_e_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_e_of_type_JavaLangString;
      localVideoPlayParam.jdField_f_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_g_of_type_JavaLangString;
      if (paramView != null)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localVideoPlayParam.jdField_h_of_type_Int = localObject[0];
        localVideoPlayParam.jdField_i_of_type_Int = localObject[1];
        localVideoPlayParam.jdField_j_of_type_Int = paramView.getWidth();
        localVideoPlayParam.jdField_k_of_type_Int = paramView.getHeight();
        if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
        {
          localObject = ReadInJoyDisplayUtils.a(3, paramInt);
          int i = localVideoPlayParam.jdField_h_of_type_Int;
          localVideoPlayParam.jdField_h_of_type_Int = ((localVideoPlayParam.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + i);
          localVideoPlayParam.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
        }
      }
      localObject = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject).jdField_a_of_type_Int = 409409;
      paramReadInJoyBaseAdapter.a(localVideoPlayParam, paramArticleInfo);
      if (paramInt == 0) {
        VideoReporter.a(paramPackArticleInfo.jdField_a_of_type_Long, paramPackArticleInfo.jdField_g_of_type_JavaLangString, paramInt, (int)paramPackArticleInfo.jdField_b_of_type_Long, paramPackArticleInfo.jdField_a_of_type_Int, 24, -1L, (ReportInfo.VideoExtraRepoerData)localObject, -1, paramPackArticleInfo.jdField_k_of_type_JavaLangString);
      }
      ReadInJoyLogicEngine.a().a(paramPackArticleInfo.jdField_a_of_type_Long, System.currentTimeMillis());
    } while ((paramView instanceof ComponentContentVerticalSmallVideo));
    paramReadInJoyBaseAdapter.notifyDataSetChanged();
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArticleInfo paramArticleInfo, Activity paramActivity)
  {
    if (a(paramArticleInfo, paramView))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ShortContent feeds");
      QLog.d("RIJListViewGroupHandlerClick", 1, "tryJumpToUgUrl: true");
      paramArticleInfo.clickJumpTarget = PGCShortContentUtils.a(ProteusSupportUtil.a(paramArticleInfo), "-1");
    }
    for (;;)
    {
      paramBaseArticleInfo.clickArea = 7;
      RIJFrameworkReportManager.a(paramActivity, paramArticleInfo, (int)paramBaseArticleInfo.mChannelID);
      return;
      QLog.d("RIJListViewGroupHandlerClick", 1, "short content redirectToOtherPage");
      PGCShortContentUtils.a(paramActivity, paramArticleInfo);
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramBaseArticleInfo.isAccountShown) {
      paramBaseArticleInfo.clickArea = 7;
    }
    if (a(paramArticleInfo, paramView))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ug normal feeds");
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      paramBuilder.a().notifyDataSetChanged();
      paramBaseArticleInfo.clickJumpTarget = PGCShortContentUtils.a(ProteusSupportUtil.a(paramArticleInfo), "-1");
      RIJFrameworkReportManager.a(paramBuilder.a(), paramArticleInfo, paramBuilder.b());
      return;
    }
    if (a(paramArticleInfo, paramView, paramBuilder))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit srt normal feeds");
      paramBaseArticleInfo.clickJumpTarget = PGCShortContentUtils.a(ReadInJoySrtUtils.a().a(), "-1");
      return;
    }
    if ((!UGRuleManager.c(paramArticleInfo)) && (!ReadInJoySrtUtils.a().a()) && (RIJTransMergeKanDianReport.a(paramView.getContext(), paramArticleInfo)))
    {
      RIJFrameworkReportManager.a(paramBuilder.a(), paramArticleInfo, paramBuilder.b());
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      paramBuilder.a().notifyDataSetChanged();
      paramBuilder = RIJJumpUtils.b(paramArticleInfo.getInnerUniqueID());
      paramBaseArticleInfo.clickJumpTarget = PGCShortContentUtils.a(paramBuilder, "-1");
      RIJJumpUtils.a(paramView.getContext(), paramArticleInfo, paramBuilder);
      return;
    }
    if (ReadInJoyDailyJumpToKDTabUtils.a(paramView.getContext(), paramArticleInfo.mArticleContentUrl))
    {
      RIJFrameworkReportManager.a(paramBuilder.a(), paramArticleInfo, paramBuilder.b());
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      paramBuilder.a().notifyDataSetChanged();
      return;
    }
    paramBaseArticleInfo.clickJumpTarget = PGCShortContentUtils.a("", "3");
    b(paramArticleInfo, paramBuilder);
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView)
  {
    String str = ProteusSupportUtil.a(paramArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (UGRuleManager.a(str)) {
        RIJJumpUtils.a(paramView.getContext(), paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("RIJListViewGroupHandlerClick", 1, "UGRuleManager articleInfo hit ug title" + paramArticleInfo.mTitle);
        return true;
        VideoFeedsHelper.a(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (UGRuleManager.c(paramArticleInfo)) {}
    boolean bool;
    String str;
    do
    {
      return false;
      bool = ReadInJoySrtUtils.a().a(paramArticleInfo, null, null);
      str = ReadInJoySrtUtils.a().a();
    } while ((!bool) || (TextUtils.isEmpty(str)));
    ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramBuilder.a().notifyDataSetChanged();
    RIJFrameworkReportManager.a(paramBuilder.a(), paramArticleInfo, paramBuilder.b());
    RIJJumpUtils.a(paramView.getContext(), paramArticleInfo, str);
    return true;
  }
  
  private boolean a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if ((paramArticleInfo.isTwoItemVideoFeed()) && (paramArticleInfo.mFeedType != 36))
    {
      QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() RETURN article.mArticleID:" + paramArticleInfo.mArticleID + " article.mTitle:" + paramArticleInfo.mTitle);
      return true;
    }
    if (RIJItemViewType.a(paramArticleInfo) == 6)
    {
      if ((paramView instanceof ProteusItemView)) {
        a((ProteusItemView)paramView, paramBuilder.a());
      }
    }
    else
    {
      if (!a(paramArticleInfo, paramView)) {
        break label297;
      }
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ug video feeds");
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      paramBuilder.a().notifyDataSetChanged();
      RIJFrameworkReportManager.a(paramBuilder.a(), paramArticleInfo, paramBuilder.b());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() article.mArticleID:" + paramArticleInfo.mArticleID + " article.mTitle:" + paramArticleInfo.mTitle + " article.mSummary:" + paramArticleInfo.mSummary + "mJsonVideoList:" + paramArticleInfo.mJsonVideoList + " videoJumpChannelID=" + paramArticleInfo.videoJumpChannelID + " videoJumpChannelName=" + paramArticleInfo.videoJumpChannelName + " videoJumpChannelType=" + paramArticleInfo.videoJumpChannelType);
      }
      return false;
      if (!(paramView instanceof LinearLayout)) {
        break;
      }
      a((LinearLayout)paramView, paramBuilder.a());
      break;
      label297:
      if (a(paramArticleInfo, paramView, paramBuilder))
      {
        QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit srt video feeds");
      }
      else if (RIJItemViewType.p(paramArticleInfo))
      {
        QLog.d("RIJListViewGroupHandlerClick", 1, "isLargeImageMiniAppCard, jumpto: " + paramArticleInfo.mArticleContentUrl);
        RIJMiniProgramUtils.a.a(paramArticleInfo, 1, null);
        RIJFrameworkReportManager.b(paramArticleInfo, paramBuilder.b());
      }
      else if (paramBaseArticleInfo.isAccountShown)
      {
        paramBaseArticleInfo.clickArea = 7;
        paramBaseArticleInfo.clickJumpTarget = PGCShortContentUtils.a("", "3");
        b(paramArticleInfo, paramBuilder);
      }
      else
      {
        a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, paramBuilder);
      }
    }
  }
  
  private void b(View paramView, ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (RIJItemViewType.c(paramArticleInfo))
    {
      a(paramArticleInfo, paramBuilder);
      return;
    }
    RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo, 1, false, 4, false);
  }
  
  private void b(RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    int j = paramBuilder.a().getCount();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        Object localObject = paramBuilder.a().getItem(i);
        if ((localObject instanceof ArticleInfo))
        {
          localObject = (ArticleInfo)localObject;
          ((ArticleInfo)localObject).setSearchWordInfo(null, null, null);
          ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        }
        i += 1;
      }
    }
  }
  
  private void b(ArticleInfo paramArticleInfo, int paramInt, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)))
    {
      RIJFrameworkReportManager.a(paramBuilder.a(), paramArticleInfo, paramBuilder.b());
      if (paramBuilder.a().a(paramBuilder.b(), paramArticleInfo.mArticleID)) {}
      RIJPreParseData.a(paramArticleInfo);
      if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        str = paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
        localBundle = new Bundle();
        localBundle.putString("big_brother_source_key", RIJJumpUtils.a(0));
        RIJJumpUtils.a(paramBuilder.a(), str, localBundle);
        GalleryReportedUtils.a(paramBuilder.a(), paramArticleInfo, paramBuilder.a());
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      Bundle localBundle;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("RIJListViewGroupHandlerClick", 2, "jumpToGallery failed: url is null");
      return;
    }
    QLog.e("RIJListViewGroupHandlerClick", 2, "jumpToGallery falied articleInfo is null or rowkey is empty");
  }
  
  private void b(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.jdField_k_of_type_JavaLangString)))
    {
      RIJFrameworkReportManager.a(paramActivity, paramArticleInfo, paramInt);
      RIJJumpUtils.b(paramActivity, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.jdField_k_of_type_JavaLangString);
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    }
  }
  
  private void b(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    RIJJumpUtils.a(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt);
    ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramReadInJoyBaseAdapter.notifyDataSetChanged();
    RIJJumpUtils.a(paramActivity, paramArticleInfo);
  }
  
  private boolean b(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, ValueReference<Integer> paramValueReference, ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder, Handler paramHandler)
  {
    boolean bool = false;
    if ((RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo)))
    {
      RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo, 0, false, 1, false);
      RIJFrameworkReportManager.b(paramArticleInfo, paramBuilder.b());
      paramBaseArticleInfo = "jumpNewSocialSecondPage";
    }
    for (;;)
    {
      QLog.d("RIJListViewGroupHandlerClick", 1, "onItemClickPartTwo, jumpTarget= " + paramBaseArticleInfo);
      return bool;
      if (RIJItemViewType.h(paramArticleInfo))
      {
        b(paramView, paramArticleInfo, paramBuilder);
        paramBaseArticleInfo = "onOfficalRecommendClick";
      }
      else
      {
        if (RIJFeedsType.a(paramArticleInfo))
        {
          if (a(paramBaseArticleInfo, paramView, paramInt, paramArticleInfo, paramBuilder)) {}
          for (bool = true;; bool = false)
          {
            paramBaseArticleInfo = "onVideoArticleClick";
            break;
            paramValueReference.a(Integer.valueOf(4));
          }
        }
        if (RIJFeedsType.c(paramArticleInfo))
        {
          a(paramView, paramInt, paramArticleInfo, paramBuilder, paramHandler);
          paramBaseArticleInfo = "onGalleryClick";
        }
        else if ((RIJFeedsType.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) || (paramArticleInfo.isAccountShown))
        {
          a(paramBaseArticleInfo, paramView, paramArticleInfo, paramBuilder);
          paramValueReference.a(Integer.valueOf(2));
          paramBaseArticleInfo = "onSupportNativeClick";
        }
        else if (paramArticleInfo.mFeedType == 26)
        {
          b(paramArticleInfo, paramBuilder.a(), paramBuilder.b());
          paramBaseArticleInfo = "onQuestionClick";
        }
        else if (paramArticleInfo.mFeedType == 23)
        {
          RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo, 1, false, 4, false);
          paramBaseArticleInfo = "FeedsType_PGC_Gallery->jumpNewSocialSecondPage";
        }
        else if (paramArticleInfo.mFeedType == 34)
        {
          RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo.mArticleContentUrl, null);
          RIJFrameworkReportManager.b(paramArticleInfo, paramBuilder.b());
          paramBaseArticleInfo = "FeedsType_Scrip_Cms";
        }
        else if (paramArticleInfo.mFeedType == 39)
        {
          ReadInJoyAdUtils.a(paramArticleInfo, paramBuilder.a(), paramInt);
          paramBaseArticleInfo = "jumpToMiniGame";
        }
        else
        {
          paramValueReference.a(Integer.valueOf(2));
          a(paramArticleInfo, paramBuilder.a(), paramBuilder.b(), paramBuilder.a());
          paramBaseArticleInfo = "onAdClick";
        }
      }
    }
  }
  
  private void c(ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (RIJFeedsType.a(paramArticleInfo)) {
      a(paramArticleInfo, null, 0, 0, false, 0, paramBuilder);
    }
    do
    {
      return;
      if (paramArticleInfo.isPGCShortContent())
      {
        PGCShortContentUtils.a(paramBuilder.a(), paramArticleInfo);
        return;
      }
    } while (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo));
    a(paramArticleInfo, paramBuilder);
  }
  
  private void d(ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramArticleInfo.isPGCShortContent())
    {
      PGCShortContentUtils.a(paramBuilder.a(), paramArticleInfo);
      return;
    }
    a(paramArticleInfo, 2, paramBuilder);
  }
  
  private void e(ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    boolean bool = true;
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject2 = (QQAppInterface)localObject1;
      localObject1 = new NowFromData();
      if (paramBuilder.b() != 56) {
        break label143;
      }
      ((NowFromData)localObject1).jdField_b_of_type_JavaLangString = "kandian_video";
      ((NowFromData)localObject1).jdField_a_of_type_JavaLangString = "kandian_video";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (paramArticleInfo.mCommentIconType == 1) {
        localBundle.putBoolean("jump_now_switch", bool);
      }
      try
      {
        localObject2 = (DynamicNowManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER);
        localBundle.putString("roomid", paramArticleInfo.mArticleContentUrl);
        localBundle.putString("fromid", ((NowFromData)localObject1).jdField_b_of_type_JavaLangString);
        ((DynamicNowManager)localObject2).a(localBundle);
        RIJFrameworkReportManager.a(paramBuilder.a(), paramArticleInfo, paramBuilder.b());
        return;
        label143:
        ((NowFromData)localObject1).jdField_b_of_type_JavaLangString = "kandian_shouye";
        ((NowFromData)localObject1).jdField_a_of_type_JavaLangString = "kandian_shouye";
        continue;
        bool = false;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RIJListViewGroupHandlerClick", 2, "subscribeId to roomId error, " + localNumberFormatException.getMessage());
          }
        }
      }
    }
  }
  
  public void a(int paramInt, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if ((paramBuilder.a() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)paramBuilder.a()).g(paramInt);
    }
    for (;;)
    {
      if (DailyModeConfigHandler.c(paramBuilder.b())) {
        KandianDailyReportUtils.a(paramInt);
      }
      a(paramBuilder);
      return;
      if ((paramBuilder.a() instanceof SplashActivity))
      {
        RIJTabFrameBase localRIJTabFrameBase = RIJJumpUtils.a(paramBuilder.a());
        if (localRIJTabFrameBase != null) {
          localRIJTabFrameBase.b(paramInt);
        }
      }
    }
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, HashMap<String, Integer> paramHashMap, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    int m = 0;
    AladdinConfig localAladdinConfig;
    int k;
    int j;
    if ((!StudyModeManager.a()) && (!paramArticleInfo.hasSearchWordInfo()) && ((RIJItemViewType.a(paramArticleInfo) == 3) || (RIJItemViewType.a(paramArticleInfo) == 1)) && (paramArticleInfo.mIsShowSearchord == 1))
    {
      localAladdinConfig = Aladdin.getConfig(201);
      if (localAladdinConfig == null) {
        break label213;
      }
      k = localAladdinConfig.getIntegerFromString("feeds_searchterm", 0);
      j = localAladdinConfig.getIntegerFromString("feeds_searchterm_max", 1000);
    }
    for (int i = localAladdinConfig.getIntegerFromString("feeds_pos_range_each_max", 3);; i = 3)
    {
      if (!DateUtils.isToday(SharedPreUtils.b("search_word_prefix_last_request_time")))
      {
        SharedPreUtils.a("search_word_prefix_last_request_time", System.currentTimeMillis());
        SharedPreUtils.a("search_word_prefix_show_times", 0L);
      }
      if (paramHashMap.containsKey(paramArticleInfo.mRefreshTime)) {
        m = ((Integer)paramHashMap.get(paramArticleInfo.mRefreshTime)).intValue();
      }
      if ((m < i) && (SharedPreUtils.b("search_word_prefix_show_times") < j) && (k == 1)) {
        ((UniteSearchHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER)).a(ByteStringMicro.copyFromUtf8(paramArticleInfo.innerUniqueID), new RIJListViewGroupHandlerClick.2(this, paramHashMap, paramArticleInfo, m, paramBuilder, paramInt));
      }
      return;
      label213:
      j = 1000;
      k = 0;
    }
  }
  
  public void a(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof FeedItemCell)) {
      ((FeedItemCell)paramView).b();
    }
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramInt == 2) {
      a(paramView, paramArticleInfo, paramBuilder);
    }
    while (paramInt != 1) {
      return;
    }
    d(paramArticleInfo, paramBuilder);
  }
  
  public void a(RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    Object localObject = paramBuilder.a().getItem(0);
    if ((paramBuilder.b() == 0) && ((localObject instanceof ArticleInfo)))
    {
      localObject = (ArticleInfo)localObject;
      paramBuilder.a(NetConnInfoCenter.getServerTime());
      paramBuilder.a((ArticleInfo)localObject);
      localObject = (QQAppInterface)ReadInJoyUtils.a();
      localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBriefPrefix((QQAppInterface)localObject, paramBuilder.a());
      String str = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBriefSuffix(paramBuilder.a());
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(RIJQQAppInterfaceUtil.b(), str, String.valueOf(paramBuilder.a()), (String)localObject, true);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramInt == 1) {
      RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo, false);
    }
    while (paramInt != 2) {
      return;
    }
    if ((RIJItemViewType.d(paramArticleInfo)) && (RIJItemViewType.c(paramArticleInfo)))
    {
      a(paramArticleInfo, paramBuilder);
      return;
    }
    RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo, 3);
  }
  
  public void a(ArticleInfo paramArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramArticleInfo.mFeedType == 2) {
      return;
    }
    if (paramBuilder.b() == 0)
    {
      Integer localInteger = VideoFeedsHelper.a(paramBuilder.a(), paramArticleInfo);
      if (localInteger.intValue() != -1)
      {
        RIJFrameworkReportManager.a(paramArticleInfo, paramBuilder.a(), paramBuilder.b(), localInteger);
        return;
      }
    }
    if ((paramBuilder.b() != 0) || (RIJFeedsType.i(paramArticleInfo)) || (RIJFeedsType.m(paramArticleInfo)) || (RIJFeedsType.n(paramArticleInfo)))
    {
      if (RIJFeedsType.n(paramArticleInfo)) {
        a(paramArticleInfo, (NewPolymericInfo.PackArticleInfo)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(paramInt3), paramView, paramBuilder.b(), paramBuilder.a());
      }
      for (;;)
      {
        ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
          paramBuilder.a().notifyDataSetChanged();
        }
        if (!RIJFeedsType.l(paramArticleInfo)) {
          break;
        }
        paramView = ReadinjoyReportUtils.a(paramBuilder.a(), paramArticleInfo.mVideoAdsSource, paramInt3, paramArticleInfo.getInnerUniqueID(), 54, ReadinjoyReportUtils.a(paramArticleInfo), paramArticleInfo.videoReportInfo);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramView, false);
        RIJFrameworkReportManager.a(paramArticleInfo, paramInt3);
        return;
        a(paramArticleInfo, paramView, paramBuilder);
      }
    }
    ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramInt3 = -1;
    if (paramArticleInfo.videoJumpChannelID > 0) {
      if (paramArticleInfo.videoJumpChannelID == 56)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoanimation", 2, " init translation animation for viewTop:" + paramInt1 + "view left:" + paramInt2 + "isFromItemClick:" + paramBoolean);
        }
        a(paramBuilder.a(), paramBuilder.a(), paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        label373:
        paramInt1 = paramArticleInfo.videoJumpChannelID;
        RIJFrameworkReportManager.a(paramArticleInfo, paramBuilder.a(), paramBuilder.b());
      }
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        paramView = new ReportInfo.VideoExtraRepoerData();
        paramView.jdField_a_of_type_Int = paramInt1;
        VideoReporter.a(paramArticleInfo, paramBuilder.b(), 24, -1L, paramView);
      }
      if ((RIJItemViewType.a(paramArticleInfo) == 6) || (RIJItemViewType.a(paramArticleInfo) == 28)) {
        break;
      }
      paramBuilder.a().notifyDataSetChanged();
      return;
      paramView = new HashMap();
      paramView.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo.mArticleID));
      ReadInJoyActivityHelper.b(paramBuilder.a(), paramArticleInfo.videoJumpChannelID, paramArticleInfo.videoJumpChannelName, paramArticleInfo.videoJumpChannelType, 5, paramView);
      break label373;
      if (ReadInJoyHelper.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        a(paramBuilder.a(), paramBuilder.a(), paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        RIJFrameworkReportManager.a(paramArticleInfo, paramBuilder.a(), paramBuilder.b());
        paramInt1 = 56;
      }
      else
      {
        a(paramArticleInfo, paramView, paramBuilder);
        paramInt1 = paramInt3;
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, View paramView, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (RIJFeedsType.g(paramArticleInfo))
    {
      a(paramArticleInfo, paramView, paramBuilder.b(), paramBuilder.a());
      return;
    }
    VideoPlayManager.VideoPlayParam localVideoPlayParam = new VideoPlayManager.VideoPlayParam();
    localVideoPlayParam.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localVideoPlayParam.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localVideoPlayParam.jdField_h_of_type_JavaLangString = paramArticleInfo.thirdUin;
    localVideoPlayParam.jdField_i_of_type_JavaLangString = paramArticleInfo.thirdUinName;
    localVideoPlayParam.jdField_k_of_type_JavaLangString = paramArticleInfo.mSubscribeID;
    localVideoPlayParam.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localVideoPlayParam.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    ReadinjoyVideoReportData localReadinjoyVideoReportData = new ReadinjoyVideoReportData();
    localReadinjoyVideoReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localReadinjoyVideoReportData.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    label411:
    Object localObject;
    if (((!RIJItemViewType.g(paramArticleInfo)) && (!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.j(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) || ((!RIJItemViewType.q(paramArticleInfo)) || ((RIJFeedsType.l(paramArticleInfo)) && (!RIJItemViewType.q(paramArticleInfo)))))
    {
      localVideoPlayParam.jdField_f_of_type_Int = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_f_of_type_Int;
      localVideoPlayParam.jdField_c_of_type_Int = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_a_of_type_Int;
      localVideoPlayParam.jdField_d_of_type_Int = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_b_of_type_Int;
      localReadinjoyVideoReportData.jdField_a_of_type_Int = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_f_of_type_Int;
      localVideoPlayParam.jdField_b_of_type_Int = ((int)(((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_a_of_type_Long / 1000L));
      localVideoPlayParam.jdField_b_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_d_of_type_JavaLangString;
      localVideoPlayParam.jdField_j_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_g_of_type_JavaLangString;
      localVideoPlayParam.jdField_c_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_i_of_type_JavaLangString;
      if ((RIJFeedsType.i(paramArticleInfo)) && (RIJFeedsType.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localVideoPlayParam.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localReadinjoyVideoReportData.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localVideoPlayParam.a = localReadinjoyVideoReportData;
        localVideoPlayParam.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
        localVideoPlayParam.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
        localVideoPlayParam.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
        if (paramView != null)
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          localVideoPlayParam.jdField_h_of_type_Int = localObject[0];
          localVideoPlayParam.jdField_i_of_type_Int = localObject[1];
          localVideoPlayParam.jdField_j_of_type_Int = paramView.getWidth();
          localVideoPlayParam.jdField_k_of_type_Int = paramView.getHeight();
          if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
          {
            localObject = ReadInJoyDisplayUtils.a(3, paramBuilder.b());
            int i = localVideoPlayParam.jdField_h_of_type_Int;
            localVideoPlayParam.jdField_h_of_type_Int = ((localVideoPlayParam.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + i);
            localVideoPlayParam.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
          }
          VideoFeedsHelper.a(localVideoPlayParam, paramView);
        }
        localObject = new ReportInfo.VideoExtraRepoerData();
        ((ReportInfo.VideoExtraRepoerData)localObject).jdField_a_of_type_Int = 409409;
        if (paramBuilder.b() != 56) {
          break label841;
        }
      }
    }
    for (;;)
    {
      if (paramBuilder.b() == 0) {
        VideoReporter.a(paramArticleInfo, paramBuilder.b(), 24, -1L, (ReportInfo.VideoExtraRepoerData)localObject);
      }
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if ((paramView instanceof ComponentContentVerticalSmallVideo)) {
        break;
      }
      paramBuilder.a().notifyDataSetChanged();
      return;
      localVideoPlayParam.jdField_b_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_d_of_type_JavaLangString;
      break label411;
      if ((RIJFeedsType.i(paramArticleInfo)) && (RIJFeedsType.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localVideoPlayParam.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localVideoPlayParam.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localVideoPlayParam.jdField_f_of_type_Int = paramArticleInfo.busiType;
        localVideoPlayParam.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
        localVideoPlayParam.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
        localReadinjoyVideoReportData.jdField_a_of_type_Int = paramArticleInfo.busiType;
        localVideoPlayParam.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
        localVideoPlayParam.jdField_j_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
        localVideoPlayParam.jdField_g_of_type_JavaLangString = paramArticleInfo.mThirdVideoURL;
        localVideoPlayParam.jdField_f_of_type_Long = paramArticleInfo.mThirdVideoURLExpireTime;
        break label411;
      }
      if (paramArticleInfo.mVideoCoverUrl == null) {}
      for (localObject = null;; localObject = paramArticleInfo.mVideoCoverUrl.getFile())
      {
        localVideoPlayParam.jdField_b_of_type_JavaLangString = ((String)localObject);
        break;
      }
      label841:
      paramBuilder.a().a(localVideoPlayParam, paramArticleInfo);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (RIJFeedsType.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) {
      b(paramArticleInfo, paramBuilder);
    }
    for (;;)
    {
      ReadinjoyReportUtils.a(paramArticleInfo);
      return;
      RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo, paramBuilder.a(), paramBuilder.b());
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (DailyModeConfigHandler.c(paramInt))
    {
      paramBaseArticleInfo.mJumpType = 1;
      ReadInJoyHelper.a(paramBaseArticleInfo);
    }
  }
  
  @VisibleForTesting
  boolean a(ArticleInfo paramArticleInfo)
  {
    return (RIJItemViewType.a(paramArticleInfo)) || (RIJItemViewType.h(paramArticleInfo)) || (RIJFeedsType.c(paramArticleInfo)) || (RIJFeedsType.d(paramArticleInfo)) || (RIJFeedsType.f(paramArticleInfo)) || (RIJFeedsType.g(paramArticleInfo));
  }
  
  @VisibleForTesting
  boolean a(ArticleInfo paramArticleInfo, int paramInt)
  {
    return (UtilsForComponent.b(paramInt)) || (RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo));
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, ValueReference<Integer> paramValueReference, ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder, Handler paramHandler)
  {
    boolean bool;
    if (RIJItemViewType.o(paramArticleInfo))
    {
      paramBaseArticleInfo = "clickWeChatVideoCard";
      bool = false;
    }
    for (;;)
    {
      QLog.d("RIJListViewGroupHandlerClick", 1, "onItemClickPartOwn, jumpTarget= " + paramBaseArticleInfo);
      return bool;
      if (RIJItemViewType.a(paramArticleInfo))
      {
        RIJJumpUtils.b(paramBuilder.a(), paramArticleInfo, 6);
        RIJFrameworkReportManager.a(paramBuilder.a(), paramArticleInfo, paramBuilder.b());
        paramBaseArticleInfo = "clickCommentBiuCard";
        bool = false;
      }
      else if (RIJFeedsType.l(paramArticleInfo))
      {
        a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, paramBuilder);
        paramValueReference.a(Integer.valueOf(4));
        paramBaseArticleInfo = "handleVideoFeedsClickJump";
        bool = false;
      }
      else if (paramArticleInfo.mFeedType == 3)
      {
        e(paramArticleInfo, paramBuilder);
        paramBaseArticleInfo = "onNowFeedsClick";
        bool = false;
      }
      else if (paramArticleInfo.mFeedType == 13)
      {
        a(paramArticleInfo, paramBuilder.a(), paramBuilder.b());
        paramBaseArticleInfo = "onQEGameClick";
        bool = false;
      }
      else if ((paramArticleInfo.mFeedType == 22) || (paramArticleInfo.mFeedType == 21) || (RIJFeedsType.o(paramArticleInfo)))
      {
        RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo, 4, false, 3, false);
        paramBaseArticleInfo = "jumpNewSocialSecondPage";
        bool = false;
      }
      else if (RIJItemViewType.b(paramArticleInfo))
      {
        a(paramBaseArticleInfo, paramView, paramArticleInfo, paramBuilder.a());
        paramBaseArticleInfo = "onPgcShortContentClick";
        bool = false;
      }
      else if ((RIJItemViewType.a(paramArticleInfo)) && (RIJItemViewType.c(paramArticleInfo)))
      {
        a(paramArticleInfo, paramBuilder);
        paramBaseArticleInfo = "jumpArticleDetail";
        bool = false;
      }
      else if (RIJItemViewType.a(paramArticleInfo))
      {
        RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo, 1, false, 4, false);
        paramBaseArticleInfo = "RIJItemViewType -> jumpNewSocialSecondPage";
        bool = false;
      }
      else if (RIJItemViewType.a(paramArticleInfo) == 71)
      {
        a(paramView, paramInt, paramArticleInfo, paramBuilder);
        paramValueReference.a(Integer.valueOf(4));
        paramBaseArticleInfo = "onUgcVideoAsPgcClick";
        bool = false;
      }
      else if ((RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)))
      {
        RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo, 4, false, 3, false);
        RIJFrameworkReportManager.b(paramArticleInfo, paramBuilder.b());
        paramBaseArticleInfo = "isUGC->jumpNewSocialSecondPage";
        bool = false;
      }
      else if ((RIJFeedsType.c(paramArticleInfo)) || (RIJFeedsType.d(paramArticleInfo)))
      {
        RIJJumpUtils.a(paramBuilder.a(), paramArticleInfo, 1, false, 4, false);
        RIJFrameworkReportManager.b(paramArticleInfo, paramBuilder.b());
        RIJFrameworkReportManager.c(paramArticleInfo, paramBuilder.b());
        paramBaseArticleInfo = "isTopicRecommend->jumpNewSocialSecondPage";
        bool = false;
      }
      else if (RIJFeedsType.a(paramArticleInfo))
      {
        a(paramArticleInfo, 1, paramBuilder);
        GalleryReportedUtils.a(paramBuilder.a(), paramArticleInfo, paramBuilder.a());
        paramValueReference.a(Integer.valueOf(2));
        paramBaseArticleInfo = "jumpSocialDetailPageWhenClick";
        bool = false;
      }
      else
      {
        bool = b(paramBaseArticleInfo, paramView, paramInt, paramValueReference, paramArticleInfo, paramBuilder, paramHandler);
        paramBaseArticleInfo = "onItemClickPartTwo";
      }
    }
  }
  
  public void b(ArticleInfo paramArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (RIJFeedsType.g(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean) {
        localArticleInfo = a(paramArticleInfo);
      }
    }
    if (localFastWebModule != null) {
      paramBuilder.b(localFastWebModule.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null));
    }
    b(localArticleInfo, paramBuilder.a(), paramBuilder.b(), paramBuilder.a());
  }
  
  @VisibleForTesting
  boolean b(ArticleInfo paramArticleInfo, int paramInt)
  {
    return (paramInt == 11) || (paramInt == 28) || (RIJItemViewType.b(paramArticleInfo) == 23) || (RIJItemViewType.c(paramArticleInfo) == 56);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJListViewGroupHandlerClick
 * JD-Core Version:    0.7.0.1
 */