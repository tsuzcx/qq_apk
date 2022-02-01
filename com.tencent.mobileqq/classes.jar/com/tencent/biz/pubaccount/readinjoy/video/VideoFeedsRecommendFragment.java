package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoPlayCountHandler;
import com.tencent.biz.pubaccount.VideoPlayCountObserver;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.FollowStatusObserver;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule;
import com.tencent.biz.pubaccount.readinjoy.popup.RIJFollowRecommendPopupCommand;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskConfig;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskVideoTimer;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardVideoTipsManager;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager.Callback;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.TiktokVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdTest;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyReportManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdVVAdloadStrategyManager;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanHandler;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanObserver;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class VideoFeedsRecommendFragment
  extends ReportV4Fragment
  implements RIJVideoRewardCoinManager.Callback, VideoColumnBannerManager.IVideoColumnBannerAction, VideoFeedsAdapter.AdapterEventListener, VideoFeedsRecommendManager.Listener, VideoFeedsRecyclerView.ListEventListener
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PublicAccountArticleHandler jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler;
  private PublicAccountArticleObserver jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoPlayCountHandler jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountHandler;
  private VideoPlayCountObserver jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountObserver;
  private VideoPlayRecommendHandler jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler;
  private ReadInJoyAtlasManager.AtlasCallbackImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl;
  private RIJLiveStatusModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule;
  private RIJRewardTaskVideoTimer jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer;
  private RIJRewardVideoTipsManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager;
  private RIJVideoRewardCoinManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager;
  private VideoColumnBannerManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  private VideoFeedsCommentManager.CommentEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener;
  private VideoFeedsCommentManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager;
  private VideoFeedsGuideProxy jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy;
  private VideoFeedsInterruptedAdManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager;
  private VideoFeedsLikeAnimateManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager;
  private VideoFeedsPlayManager.VideoStatusListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecommendFragment.FriendListObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FriendListObserver;
  private VideoFeedsRecommendFragment.FullPlayCallbackImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FullPlayCallbackImpl;
  private VideoFeedsRecommendFragment.LifeCycleCallBack jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LifeCycleCallBack;
  private VideoFeedsRecommendFragment.LiveStatusCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LiveStatusCallback;
  private VideoFeedsRecommendFragment.PlayRecommendObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$PlayRecommendObserver;
  private VideoFeedsRecommendFragment.RIJObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$RIJObserver;
  private VideoFeedsRecommendFragment.ScrollEventListenerImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$ScrollEventListenerImpl;
  private VideoFeedsRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager;
  private VideoFeedsRecommendPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private VideoFeedsShareGuideController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController;
  private VideoFeedsShuntBarManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarManager;
  private VideoFeedsSoftAdBarController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController;
  private VideoFullPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController;
  private VideoColumnDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnDataManager;
  private VideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder;
  private VideoFeedsGameAdComManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager;
  private ADVideoFeedsGuideManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager;
  private VideoAdExposureManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager;
  private VideoAdStrategyReportManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager;
  private VideoAdTimeLoadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager;
  private VideoAdVVAdloadStrategyManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdVVAdloadStrategyManager;
  private VideoPlayDianZanHandler jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler;
  private VideoPlayDianZanObserver jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver;
  private TKDCommentDispatcher.HippyCommentEvent jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent = new VideoFeedsRecommendFragment.5(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<VideoInfo> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<FollowListInfoModule.FollowStatusObserver> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private HashSet<String> jdField_b_of_type_JavaUtilHashSet;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 5;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = false;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = true;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, paramString3, false);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, paramString3, paramBoolean, 0);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ARGS_SESSION_ID", paramString1);
    localBundle.putString("ARGS_VIDEO_CHANNEL_SESSION_ID", paramString3);
    localBundle.putParcelable("ARGS_REUQEST_VIDEO_INFO", paramVideoInfo);
    localBundle.putBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", paramBoolean);
    localBundle.putInt("ARGS_FIRST_INFO_POSITION", paramInt);
    localBundle.putString("ARGS_PAGE_SESSION_ID", paramString2);
    localBundle.putAll(paramBundle);
    paramBundle = new VideoFeedsRecommendFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a(), this.jdField_a_of_type_AndroidOsBundle).toString();
  }
  
  private List<Long> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((VideoInfo)paramList.next()).j;
      try
      {
        localArrayList.add(Long.valueOf(Long.parseLong(str)));
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VideoFeedsRecommendFragment", 1, "convert2LongList pass uin:" + str + " for e:" + localThrowable);
      }
    }
    return localArrayList;
  }
  
  private void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder instanceof TiktokVideoItemHolder))
    {
      TiktokVideoItemHolder localTiktokVideoItemHolder = (TiktokVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder;
      ((TiktokVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder).a.a(paramFloat, new VideoFeedsRecommendFragment.4(this, localTiktokVideoItemHolder));
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || (paramVideoInfo.jdField_b_of_type_Boolean)) {
      return;
    }
    ThreadManager.post(new VideoFeedsRecommendFragment.CheckAccountFollowedRunnable(this, paramVideoInfo), 1, null, true);
  }
  
  private void a(BaseItemHolder paramBaseItemHolder)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.b()) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool1);
      return;
      bool1 = bool2;
      if (!(paramBaseItemHolder instanceof ADVideoItemHolder))
      {
        bool1 = bool2;
        if ((paramBaseItemHolder instanceof BaseVideoItemHolder))
        {
          bool1 = bool2;
          if (!((BaseVideoItemHolder)paramBaseItemHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(getActivity())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramBoolean) {
        TimeSliceHelper.b(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    TimeSliceHelper.c(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
  }
  
  private void a(List<VideoInfo> paramList)
  {
    try
    {
      paramList = a(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule.a(paramList);
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("VideoFeedsRecommendFragment", 1, "fetchLiveStatus error:" + paramList);
    }
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && ((!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)))) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountHandler.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString);
    }
    if ((RIJRewardTaskConfig.a()) && (!paramVideoInfo.jdField_c_of_type_Boolean))
    {
      ReadInJoyLogicEngine.a().j(paramVideoInfo.jdField_g_of_type_JavaLangString);
      ReadInJoyLogicEngine.a().i(paramVideoInfo.jdField_g_of_type_JavaLangString);
    }
  }
  
  private void b(List<VideoInfo> paramList)
  {
    if (this.o)
    {
      QLog.w("VideoFeedsRecommendFragment", 1, "fetchFollowStatus cancel for activity is destroyed.");
      return;
    }
    VideoFeedsRecommendFragment.FollowStatusObserver localFollowStatusObserver = new VideoFeedsRecommendFragment.FollowStatusObserver(paramList);
    this.jdField_a_of_type_JavaUtilList.add(localFollowStatusObserver);
    FollowListInfoModule.a(a(paramList), localFollowStatusObserver);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getScrollState() != 0) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (LinearLayoutManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getLayoutManager();
      int i1 = ((LinearLayoutManager)localObject1).findFirstVisibleItemPosition();
      int i2 = ((LinearLayoutManager)localObject1).findLastVisibleItemPosition();
      localObject1 = null;
      if (i1 < i2)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getLayoutManager().findViewByPosition(i1);
        if (localObject2 == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildViewHolder((View)localObject2);
          if (i1 == paramInt) {
            localObject1 = localObject2;
          }
          if (localObject2 != null) {
            if ((localObject2 instanceof BaseItemHolder))
            {
              localObject2 = ((BaseItemHolder)localObject2).a;
              if (localObject2 != null) {
                ((VideoFeedsAlphaMaskView)localObject2).setAlpha(0.0F);
              }
            }
          }
        }
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d()) || (localObject1 == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a((RecyclerView.ViewHolder)localObject1);
    ExposureSupplementUtil.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder);
    ExposureSupplementUtil.b(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a.c();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
  }
  
  private void d(int paramInt)
  {
    if ((this.m) && (paramInt == 1)) {
      this.m = false;
    }
    do
    {
      return;
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, false);
      VideoVolumeController.a().a(false, "videoFeeds doOnPause");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.b(paramInt);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController.b();
  }
  
  private void k()
  {
    boolean bool2 = true;
    this.jdField_a_of_type_AndroidOsBundle = getArguments();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_SESSION_ID");
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_PAGE_SESSION_ID");
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID");
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_FROM_AIO", false);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    this.jdField_f_of_type_Boolean = ReadInJoyHelper.e(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("FIRST_VIDEO_TOKEN", "");
    this.h = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false);
    label272:
    label295:
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      bool1 = true;
      this.j = bool1;
      if (this.j) {
        break label712;
      }
      bool1 = true;
      this.k = bool1;
      if ((this.jdField_a_of_type_Long <= 0L) || (!this.j)) {
        break label717;
      }
      bool1 = true;
      this.l = bool1;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COMMON_DATA");
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("VIDEO_BUSINESS_INFO");
      this.n = ReadInJoyHelper.d(this.jdField_d_of_type_Int);
      this.jdField_e_of_type_Int = RIJAppSetting.a();
      this.jdField_f_of_type_Int = VideoReporter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule = ReadInJoyLogicEngine.a().a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LiveStatusCallback = new VideoFeedsRecommendFragment.LiveStatusCallback(this, null);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LiveStatusCallback);
      }
      if (CUKingCardHelper.a() != 1) {
        break label722;
      }
      bool1 = true;
      label418:
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl = new VideoFeedsRecommendFragment.FavoriteStatusCallback(this, null);
      if (jdField_a_of_type_Int <= 0) {
        jdField_a_of_type_Int = DisplayUtil.a(getActivity(), 120.0F);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("ARGS_REUQEST_VIDEO_INFO"));
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
        break label727;
      }
    }
    label712:
    label717:
    label722:
    label727:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$PlayRecommendObserver = new VideoFeedsRecommendFragment.PlayRecommendObserver(this, bool1);
      VideoFeedsRecommendFragment.PlayRecommendObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$PlayRecommendObserver, localArrayList);
      TKDCommentDispatcher.INSTANCE.addEventListener(this.jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent);
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mVideoFromType = " + this.jdField_d_of_type_Int);
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mBundle = " + this.jdField_a_of_type_AndroidOsBundle.toString());
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mVideoDataList[0] = " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b());
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() needReloadTitle = " + this.jdField_e_of_type_Boolean + ", showSingleVideo = " + this.jdField_f_of_type_Boolean + ", mFirstVideoStartPosition = " + this.jdField_a_of_type_Long + ", mFirstVideoToken:" + this.jdField_g_of_type_JavaLangString);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label272;
      bool1 = false;
      break label295;
      bool1 = false;
      break label418;
    }
  }
  
  private void l()
  {
    try
    {
      if (VersionUtils.d()) {
        getActivity().getWindow().setFlags(16777216, 16777216);
      }
      label22:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131381485));
      VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new VideoFeedsLayoutManager(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener = new VideoFeedsRecommendFragment.VideoStatusListenerImpl(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(this.n);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.h);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter = new VideoFeedsRecommendPresenter(getActivity(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.n, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager = new ADVideoFeedsGuideManager(getActivity().getApplicationContext());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.a(new VideoFeedsRecommendFragment.1(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(getActivity(), false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = new VideoFeedsAdapter(getActivity().getApplicationContext(), getActivity(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.e(getUserVisibleHint());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_e_of_type_Boolean);
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
      if (this.jdField_f_of_type_Boolean) {}
      for (int i1 = 3;; i1 = 1)
      {
        ((VideoFeedsAdapter)localObject).c(i1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.b(this.k);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.c(this.h);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.d(this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.c((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_g_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$ScrollEventListenerImpl = new VideoFeedsRecommendFragment.ScrollEventListenerImpl(this, null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LifeCycleCallBack);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$ScrollEventListenerImpl);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$ScrollEventListenerImpl);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener = new VideoFeedsRecommendFragment.CommentEventListenerImpl(this, null);
        this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131365103));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager = new VideoFeedsCommentManager(getActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_c_of_type_AndroidViewViewGroup);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener);
        if (this.h)
        {
          localObject = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a((AnchorData)localObject);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager);
        this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager = new VideoFeedsInterruptedAdManager(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager = new VideoFeedsGameAdComManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController = new VideoFeedsSoftAdBarController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy = new VideoFeedsGuideProxy();
        localObject = new VideofeedsUserGuideController(getActivity(), getActivity().getAppRuntime(), this.jdField_b_of_type_AndroidViewViewGroup, true, this.h);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy.a((VideofeedsUserGuideController)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarManager = new VideoFeedsShuntBarManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, (VideofeedsUserGuideController)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy.a(new VideoColumnGuideManager());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager = new RIJVideoRewardCoinManager(getActivity(), this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager = new RIJRewardVideoTipsManager(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager);
        m();
        if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof FrameLayout))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FullPlayCallbackImpl = new VideoFeedsRecommendFragment.FullPlayCallbackImpl(this, null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController = new VideoFullPlayController(getActivity(), (FrameLayout)this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FullPlayCallbackImpl);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a(false);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FullPlayCallbackImpl);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FullPlayCallbackImpl);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager = new VideoFeedsLikeAnimateManager(getActivity(), 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer = new RIJRewardTaskVideoTimer();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        if (!RIJAladdinUtils.b()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController = new VideoFeedsShareGuideController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter, null);
        }
        VideoVolumeController.a().a(getActivity());
        VideoBehaviorsReporter.a().a(true);
        VideoBehaviorsReporter.a().a(2);
        return;
      }
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131371183));
    this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
    if (LiuHaiUtils.b())
    {
      int i1 = LiuHaiUtils.b(getActivity());
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), i1 + this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377955));
    if ((!d()) && (getUserVisibleHint())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371175));
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false)) {
      b(false);
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler = ((VideoPlayRecommendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager = new VideoFeedsRecommendManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountHandler = ((VideoPlayCountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYCOUNT_HANDLER));
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountObserver = new VideoFeedsRecommendFragment.PlayCountObserver(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler = ((VideoPlayDianZanHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_DIANZAN));
    this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver = new VideoFeedsRecommendFragment.DianZanObserver(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler = ((PublicAccountArticleHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER));
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = new VideoFeedsRecommendFragment.AricleObserver(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FriendListObserver = new VideoFeedsRecommendFragment.FriendListObserver(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$RIJObserver = new VideoFeedsRecommendFragment.RIJObserver(this, null);
    w();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager = new VideoAdTimeLoadManager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdVVAdloadStrategyManager = new VideoAdVVAdloadStrategyManager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager = new VideoAdStrategyReportManager();
    o();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$PlayRecommendObserver.a(true, this.jdField_a_of_type_AndroidOsBundle);
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(i1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.scrollToPosition(i1);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    b(localVideoInfo);
    if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.k))) {
      localVideoInfo.k = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, true);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localVideoInfo);
    a(localArrayList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager = new VideoAdExposureManager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager.a(this.n);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnDataManager = new VideoColumnDataManager(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager = new VideoColumnBannerManager(getActivity(), this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnDataManager, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager);
  }
  
  private void o()
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      s();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      }
    }
  }
  
  private void p()
  {
    if ((this.n) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager != null)) {
      if ((ReadInJoyAdSwitchUtil.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int)))
      {
        localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int);
        if (localVideoInfo != null)
        {
          i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.getAdapterPosition() - 1;
          i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager.a(i1, i2, localVideoInfo);
          ExposureSupplementUtil.a(getActivity(), 50, true);
        }
      }
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder == null))
    {
      VideoInfo localVideoInfo;
      int i1;
      int i2;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsRecommendFragment.2(this, i1 + 1), 0L);
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
  }
  
  private void q()
  {
    if (this.jdField_f_of_type_Boolean) {}
    do
    {
      return;
      VideoFeedsPlayActivity.a(HardCodeUtil.a(2131716053) + this.jdField_g_of_type_Boolean);
    } while (this.jdField_g_of_type_Boolean);
    s();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.c(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a();
  }
  
  private void r()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null))
    {
      l2 = this.jdField_c_of_type_Long;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localQQAppInterface == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(), l1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(), this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  private void s()
  {
    long l2;
    Object localObject;
    long l1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler != null)
    {
      l2 = this.jdField_c_of_type_Long;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localObject == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(((QQAppInterface)localObject).getCurrentAccountUin());
      localObject = a();
      int i2 = 0;
      int i1 = i2;
      VideoPlayRecommendHandler localVideoPlayRecommendHandler;
      VideoFeedsRecommendFragment.PlayRecommendObserver localPlayRecommendObserver;
      VideoInfo localVideoInfo;
      int i3;
      ArrayList localArrayList1;
      String str1;
      String str2;
      String str3;
      int i4;
      byte[] arrayOfByte;
      ArrayList localArrayList2;
      Bundle localBundle;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Int > 0) {
          i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Int;
        }
      }
      else
      {
        this.jdField_g_of_type_Boolean = true;
        localVideoPlayRecommendHandler = this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler;
        localPlayRecommendObserver = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$PlayRecommendObserver;
        localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        i3 = this.jdField_d_of_type_Int;
        localArrayList1 = this.jdField_a_of_type_JavaUtilArrayList;
        str1 = ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).i;
        l2 = this.jdField_b_of_type_Long;
        str2 = this.jdField_b_of_type_JavaLangString;
        str3 = this.jdField_c_of_type_JavaLangString;
        i4 = this.jdField_c_of_type_Int;
        arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilHashSet);
        localBundle = this.jdField_a_of_type_AndroidOsBundle;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) {
          break label263;
        }
      }
      label263:
      for (i2 = 0;; i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int)
      {
        localVideoPlayRecommendHandler.a(localPlayRecommendObserver, l1, localVideoInfo, i3, localArrayList1, str1, l2, true, i1, str2, str3, null, i4, (String)localObject, arrayOfByte, 0, localArrayList2, localBundle, i2);
        return;
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null) {
          break;
        }
        i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
        break;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString)))
    {
      VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      localVideoInfo.r += 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy.a();
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FriendListObserver != null) {
      getActivity().addObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$PlayRecommendObserver != null) {
      getActivity().addObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$PlayRecommendObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountObserver != null) {
      getActivity().addObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver != null) {
      getActivity().addObserver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver != null) {
      getActivity().addObserver(this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$RIJObserver != null) {
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$RIJObserver);
    }
  }
  
  private void x()
  {
    getActivity().removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FriendListObserver);
    getActivity().removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$PlayRecommendObserver);
    getActivity().removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountObserver);
    getActivity().removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
    getActivity().removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$RIJObserver);
    FollowListInfoModule localFollowListInfoModule = ReadInJoyLogicEngine.a().a();
    if (localFollowListInfoModule != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FollowListInfoModule.FollowStatusObserver localFollowStatusObserver = (FollowListInfoModule.FollowStatusObserver)localIterator.next();
        if (localFollowStatusObserver != null) {
          localFollowListInfoModule.b(localFollowStatusObserver);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LiveStatusCallback);
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.h();
    }
    VideoVolumeController.a().a(true, "videoFeeds doOnResume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.d();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager.j();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.c();
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, true);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager.c();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdVVAdloadStrategyManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdVVAdloadStrategyManager.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager.c();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder instanceof ADVideoItemHolder))
    {
      if (((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder).a != null) {
        ((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder).a.a();
      }
      if (((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder).b != null) {
        ((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder).b.a();
      }
    }
  }
  
  public void E_()
  {
    if (QLog.isColorLevel()) {
      RIJAppSetting.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    q();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int;
    }
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.f();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return;
    }
    t();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder == null) {}
    long l1;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label390;
      }
      l1 = ((VideoPlayerWrapper)localObject).b();
      if (!this.jdField_d_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager.a((int)(paramLong / 1000.0D));
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarManager.a(localVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, (int)(paramLong / 1000.0D), (int)(l1 / 1000.0D));
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, paramLong, this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, paramLong, l1);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController.a(paramLong, l1);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, this.jdField_d_of_type_Boolean, paramLong * 100.0D / l1, l1);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null) && (localObject != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(((VideoPlayerWrapper)localObject).a(false));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager.a(paramLong, l1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.b());
      }
      if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager == null)) {
        break;
      }
    } while ((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b()));
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
    if ((ReadInJoyAdSwitchUtil.e((VideoAdInfo)localObject)) && (ReadInJoyAdSwitchUtil.a((VideoAdInfo)localObject)))
    {
      if (paramLong < l1 * 0.8D) {
        break label395;
      }
      ReadInJoyAdLog.a("VIDEO_LINK", "fetchAnotherAd : 同时满足 出结束引导和循环展示  80%");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager.a((VideoAdInfo)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int);
    }
    for (;;)
    {
      a((float)paramLong / (float)l1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(paramLong, l1);
      return;
      label390:
      l1 = 0L;
      break;
      label395:
      if (paramLong >= l1 * 0.5D)
      {
        ReadInJoyAdLog.a("VIDEO_LINK", "refreshFetchAnotherAdFlag : 同时满足 出结束引导和循环展示  50%");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "onCenterViewChanged: ");
    }
    if ((paramViewHolder instanceof BaseItemHolder)) {
      a((BaseItemHolder)paramViewHolder);
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager.a((VideoItemHolder)paramViewHolder);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, (VideoItemHolder)paramViewHolder);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.a((VideoItemHolder)paramViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a((VideoItemHolder)paramViewHolder);
      if ((paramViewHolder instanceof ADVideoItemHolder))
      {
        if (((ADVideoItemHolder)paramViewHolder).a != null) {
          ((ADVideoItemHolder)paramViewHolder).a.a();
        }
        if (((ADVideoItemHolder)paramViewHolder).b != null) {
          ((ADVideoItemHolder)paramViewHolder).b.a();
        }
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder = ((VideoItemHolder)paramViewHolder);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, true);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder instanceof ShortVideoItemHolder))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager.a((ShortVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, VideoFeedsRecommendFragment.ScrollEventListenerImpl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$ScrollEventListenerImpl));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int > 0)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy.b(false);
        }
        u();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int + 1));
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup, localVideoInfo.a() * 1000);
        this.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder instanceof ShortVideoItemHolder))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager.a((ShortVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder);
      }
    }
    SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(1, null));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LifeCycleCallBack != null)
    {
      boolean bool = paramViewHolder instanceof ADVideoItemHolder;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LifeCycleCallBack.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy.a(paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager.a(this.jdField_d_of_type_Boolean);
    }
    String str1;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      u();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
      {
        paramViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
        if (paramViewHolder != null)
        {
          if ((paramViewHolder.jdField_a_of_type_Int != 0) || (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
            break label275;
          }
          str1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
          label96:
          str1 = new VideoR5.Builder(str1, paramViewHolder.j, paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramViewHolder.a() * 1000L).a(409409).a().a();
          IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          String str2 = paramViewHolder.j;
          if (TextUtils.isEmpty(paramViewHolder.jdField_g_of_type_JavaLangString)) {
            break label280;
          }
          paramViewHolder = paramViewHolder.jdField_g_of_type_JavaLangString;
          label177:
          localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(false);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder instanceof BaseVideoItemHolder)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FullPlayCallbackImpl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), 0);
        }
      }
    }
    for (;;)
    {
      SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(1, null));
      return;
      paramViewHolder = null;
      break;
      label275:
      str1 = null;
      break label96;
      label280:
      paramViewHolder = "0";
      break label177;
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(this.n);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController != null)
      {
        paramBoolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.b();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.b();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$FullPlayCallbackImpl.a(paramBoolean);
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler.a(paramVideoInfo, paramBoolean);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_LOVE, 0, 0, 0));
  }
  
  public void a(RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(paramRIJFeedsInsertAction);
  }
  
  public void a(VideoFeedsRecommendFragment.LifeCycleCallBack paramLifeCycleCallBack)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LifeCycleCallBack = paramLifeCycleCallBack;
  }
  
  public void a(VideoItemHolder paramVideoItemHolder) {}
  
  public void a(@NotNull String paramString)
  {
    if (getActivity() != null) {
      QQToast.a(getActivity(), paramString, 0).a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(false);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder);
  }
  
  public void a(boolean paramBoolean, @NotNull String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = b();
      if (paramString != null)
      {
        paramString.o = true;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(paramString);
        ReadInJoyLogicEngine.a().j(paramString.jdField_g_of_type_JavaLangString);
        if (!this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager.a(paramInt);
        }
      }
    }
    while (getActivity() == null) {
      return;
    }
    QQToast.a(getActivity(), paramString, 0).a();
  }
  
  public boolean a()
  {
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager.b())) {
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.b()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.h();
        return true;
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null));
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    VideoR5.Builder localBuilder = new VideoR5.Builder(localVideoInfo);
    localBuilder.i(localVideoInfo.jdField_g_of_type_JavaLangString).m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_b_of_type_Int).l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_c_of_type_Int);
    localBuilder.p(1).i(localVideoInfo.jdField_g_of_type_JavaLangString);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009953", "0X8009953", 0, 0, "", "", "", localBuilder.a().a(), false);
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (!this.jdField_d_of_type_Boolean))
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        VideoVolumeController.a().a(paramInt);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.a(VideoVolumeController.a().a());
        return true;
      }
    }
    return false;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    }
    return 0L;
  }
  
  public VideoInfo b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    }
    return null;
  }
  
  public void b()
  {
    r();
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean b()
  {
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager.b())) {
        return true;
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        VideoFeedsPlayActivity.a("BackPressed, back to list from fullscreen");
        return true;
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.b()));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.h();
    return true;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a();
  }
  
  public void d()
  {
    q();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.b());
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LifeCycleCallBack.d();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().a("0X800B944", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController.a());
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().a("0X800B942", 0);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.c();
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, false);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.d();
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, true);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), false);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder);
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
    case 117: 
    case 102: 
    case 9999: 
    case 21: 
    case 10001: 
      do
      {
        do
        {
          do
          {
            String str;
            do
            {
              do
              {
                do
                {
                  return;
                } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager == null);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a(paramInt1, paramInt2, paramIntent);
                return;
              } while (paramInt2 != -1);
              str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
            } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter == null));
            paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(str);
          } while (paramIntent == null);
          paramIntent.jdField_f_of_type_Int += 1;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(paramIntent);
          return;
        } while (paramInt2 != -1);
        QQToast.a(getActivity(), -1, getString(2131699745), 0).b(getActivity().getTitleBarHeight());
        return;
      } while (paramInt2 != -1);
      t();
      return;
    }
    VideoFeedsSoftAdTest.a(getActivity(), paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.jdField_b_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new VideoFeedsRecommendFragment.3(this, paramConfiguration);
      this.jdField_b_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)VideoFeedsResourceLoader.a(2131560486, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    k();
    l();
    n();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LifeCycleCallBack != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$LifeCycleCallBack.c();
    }
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewViewGroup;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.o = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.e();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.c();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager.e();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsInterruptedAdManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.e();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoColumnBannerManager.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager.e();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardVideoTipsManager.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.i();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareGuideController.b();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      TimeSliceHelper.a(((VideoInfo)localObject).jdField_g_of_type_JavaLangString);
      if (((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList != null)
      {
        localObject = ((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          TimeSliceHelper.a(((VideoInfo)((Iterator)localObject).next()).jdField_g_of_type_JavaLangString);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimateManager = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideProxy.b();
    }
    x();
    VideoBehaviorsReporter.a().a();
    VideoVolumeController.a().b(getActivity());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.c();
    }
    VideoAdStrategyManager.b();
    VideoAdTimeLoadManager.g();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdVVAdloadStrategyManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdVVAdloadStrategyManager.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager.e();
    }
    AdReqFreshManager.a().a("RIJAdRefreshSceneFloatVideo");
    AdExposeFreshManager.a().a("RIJAdRefreshSceneFloatVideo");
    RIJAdDownloadCache.a.a();
    TKDCommentDispatcher.INSTANCE.removeEventListener(this.jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent);
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.b();
    }
    d(1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.g();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoFeedsGuideManager.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdTimeLoadManager.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdVVAdloadStrategyManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdVVAdloadStrategyManager.c();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdStrategyReportManager.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController.b();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder instanceof ADVideoItemHolder))
    {
      if (((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder).a != null) {
        ((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder).a.b();
      }
      if (((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder).b != null) {
        ((ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder).b.b();
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnResume()");
    if (getUserVisibleHint()) {
      y();
    }
    super.onResume();
  }
  
  public void onStop()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnStop()");
    d(2);
    super.onStop();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      y();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.e(paramBoolean);
      }
      return;
      d(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment
 * JD-Core Version:    0.7.0.1
 */