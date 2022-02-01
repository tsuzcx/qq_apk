package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAnimUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoPlayControlUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.presenter.IReadInJoyPresenter;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyPresenterImpl;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticlePatchStatus;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler;
import com.tencent.biz.pubaccount.readinjoy.video.RIJVideoOnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoResumeManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoColumnItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoColumnItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsTwoItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsWithColumnViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.ViewHolder.VideoUIHandler;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.WeishiGridTwoItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView;
import com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoHandler
  extends BaseHandler
  implements Handler.Callback
{
  private static volatile boolean e = false;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ADBaseAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager;
  protected VideoHandler.PlayableItem a;
  private NetInfoHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoNetInfoHandler;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  protected VideoPlayManager a;
  protected VideoPreDownloadMgr a;
  protected VideoRecommendManager a;
  private VideoShareHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper;
  private ViewHolder.VideoUIHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  protected boolean a;
  private int b;
  protected boolean b;
  protected boolean c = false;
  protected boolean d = true;
  private boolean f;
  private boolean g = false;
  private boolean h = true;
  
  public VideoHandler()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem = null;
    this.jdField_b_of_type_Int = 0;
  }
  
  private void A()
  {
    boolean bool = a().a().a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((c()) && (!bool) && ((!ReadInJoyHelper.m()) || ((a().a().a() instanceof ReadInJoyNewFeedsActivity))))
    {
      t();
      B();
    }
    if (((!ReadInJoyHelper.m()) || ((a().a().a() instanceof ReadInJoyNewFeedsActivity))) && (b() == 56)) {
      VideoReporter.jdField_a_of_type_Int = VideoReporter.a(a().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  private void B()
  {
    a().g();
  }
  
  private void C()
  {
    if (b() == 56) {
      ReadInJoyLogicEngine.a().a(56);
    }
  }
  
  private LinearLayout a()
  {
    if (DailyModeConfigHandler.c(b())) {
      return this.jdField_a_of_type_AndroidWidgetLinearLayout;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public static VideoHandler.PlayableItem a(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof VideoHandler.PlayableItem))) {
      return null;
    }
    return (VideoHandler.PlayableItem)paramView.getTag();
  }
  
  private BaseArticleInfo a(int paramInt)
  {
    return a().b(paramInt);
  }
  
  public static BaseArticleInfo a(VideoHandler paramVideoHandler, View paramView)
  {
    if ((paramVideoHandler == null) || (paramView == null) || (!(paramView.getTag() instanceof VideoHandler.PlayableItem))) {
      return null;
    }
    paramView = (VideoHandler.PlayableItem)paramView.getTag();
    if (paramView != null) {
      return paramVideoHandler.a(paramView.a());
    }
    return null;
  }
  
  private VideoPlayManager.VideoPlayParam a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    a().setLayerType(2, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new VideoHandler.8(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(a(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new VideoHandler.9(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentWidgetListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  public static void a(Context paramContext, ImageView paramImageView, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)ReadInJoyDisplayUtils.a(paramContext, paramVideoPlayParam));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  private void a(Intent paramIntent)
  {
    if ((b() == 0) && (!VideoResumeManager.a.a())) {}
    label16:
    long l1;
    int i;
    VideoPlayManager.VideoPlayParam localVideoPlayParam;
    do
    {
      do
      {
        break label16;
        do
        {
          return;
        } while (paramIntent == null);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult for OPEN_FULLPLAY");
        }
        a().a().a(false);
        l1 = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", -1L);
        i = paramIntent.getIntExtra("VIDEO_PLAY_STATUS", -1);
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      return;
      localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      if (localVideoPlayParam != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
    return;
    if (paramIntent.getExtras() != null) {}
    for (paramIntent = paramIntent.getExtras().getString("VIDEO_ARTICLE_ID");; paramIntent = null)
    {
      boolean bool;
      if (!TextUtils.equals(localVideoPlayParam.j, paramIntent))
      {
        paramIntent = b(paramIntent);
        if (paramIntent == null)
        {
          l1 = localVideoPlayParam.d;
          bool = false;
        }
      }
      for (;;)
      {
        if (b(i))
        {
          if (bool) {
            a(paramIntent);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.video", 2, "onActivityResult continue play, playResumeVideo:" + bool + ",startPosition:" + l1 + ",curPlayParam:" + localVideoPlayParam);
            }
            VideoVolumeControl.a().a(false, "readinoy video continuePlay", 1);
            return;
            if (paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) {
              paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.d = l1;
            }
            bool = true;
            break;
            if ((l1 >= 0L) && (localVideoPlayParam != null)) {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a((int)l1, localVideoPlayParam);
            } else {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.f(true);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult stop play, should not continue play");
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem == null) {
          break;
        }
        long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(4);
        paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem.a();
        if (l1 > 0L) {
          l2 = l1;
        }
        paramIntent.d = l2;
        if (l1 > 0L) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem.a().e = -1;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem = null;
        return;
        paramIntent = null;
        bool = false;
      }
    }
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {}
    View localView2;
    do
    {
      return;
      View localView1 = null;
      if ((paramView.getTag() instanceof ViewHolder)) {
        localView1 = ((ViewHolder)paramView.getTag()).g;
      }
      localView2 = localView1;
      if (localView1 == null)
      {
        localView2 = localView1;
        if ((paramView.getTag(2131376634) instanceof ViewHolder)) {
          localView2 = ((ViewHolder)paramView.getTag(2131376634)).g;
        }
      }
    } while (localView2 == null);
    EventCollector.getInstance().onViewClicked(localView2);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((a() instanceof ReadInJoyChannelActivity)) {
      if ((this.c) && (paramView != null) && (paramInt > 0) && (paramInt <= 2))
      {
        if ((paramInt != 1) || (!this.d)) {
          break label105;
        }
        this.d = false;
        paramView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, "adapter animation start at item position" + paramInt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " judge adapter animation show or not：");
      }
      return;
      label105:
      if (paramInt == 2)
      {
        if (this.c) {
          this.c = false;
        }
        paramView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      }
    }
  }
  
  private void a(ViewHolder paramViewHolder)
  {
    if ((paramViewHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler == null)) {}
    while (!paramViewHolder.a()) {
      return;
    }
    paramViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler);
  }
  
  private void a(AbsListView paramAbsListView)
  {
    VideoHandler.PlayableItem localPlayableItem = a(paramAbsListView);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 4, "playVideoInArea:" + localPlayableItem);
    }
    VideoPlayManager.VideoPlayParam localVideoPlayParam;
    if (localPlayableItem != null)
    {
      paramAbsListView = localPlayableItem.a();
      localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      if (paramAbsListView == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "error state not play" + paramAbsListView.jdField_c_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((localVideoPlayParam != null) && (localVideoPlayParam.jdField_c_of_type_Long == paramAbsListView.jdField_c_of_type_Long) && (localVideoPlayParam.b == b()) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d()) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e()));
        VideoVolumeControl.a().b();
        a(localPlayableItem);
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "checkPlayableArea vid: " + paramAbsListView.jdField_c_of_type_JavaLangString);
      return;
      p();
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a().a(paramAbsListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a().h();
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  private void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam1, VideoPlayManager.VideoPlayParam paramVideoPlayParam2)
  {
    VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
    if (paramVideoPlayParam1 != paramVideoPlayParam2)
    {
      if (((paramVideoPlayParam1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) && ((paramVideoPlayParam2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo))) {
        ReadInJoyLogicEngine.a().a(b(), (ArticleInfo)paramVideoPlayParam1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (ArticleInfo)paramVideoPlayParam2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      }
      this.jdField_a_of_type_ComTencentWidgetListView.clearFocus();
      this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(new VideoHandler.4(this, paramVideoPlayParam1, localVideoPlayManager, paramVideoPlayParam2), 100L);
    }
    while (localVideoPlayManager.a() != 7) {
      return;
    }
    a(paramVideoPlayParam1);
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 0) || (paramInt == 4);
  }
  
  private boolean d()
  {
    if (!ReadInJoyHelper.a(c())) {}
    String str;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext));
        str = RIJAppSetting.a(this.jdField_a_of_type_Long);
      } while (RIJAppSetting.jdField_c_of_type_JavaLangString.equals(str));
      if (RIJAppSetting.a.equals(str)) {
        return true;
      }
    } while (!RIJAppSetting.b.equals(str));
    return VideoAutoPlayController.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    ArticleInfo localArticleInfo = a();
    boolean bool1 = bool2;
    if (a() == null)
    {
      bool1 = bool2;
      if (localArticleInfo != null)
      {
        bool1 = bool2;
        if (a(0) != null)
        {
          bool1 = bool2;
          if (localArticleInfo.mArticleID == a(0).mArticleID) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void u()
  {
    if (b() == 56)
    {
      VideoBehaviorsReporter.a().a(true);
      VideoBehaviorsReporter.a().a(0);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoNetInfoHandler);
    if ((a() instanceof ReadInJoyChannelActivity)) {
      this.c = a().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
    }
    if ((a() instanceof ReadInJoyChannelActivity)) {
      this.jdField_a_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772085));
    if (!VideoFeedsHelper.c()) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.a.add(this);
    if ((this.jdField_a_of_type_ComTencentWidgetListView instanceof ReadInJoyBaseListView)) {
      ((ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentWidgetListView).a(new RIJVideoOnScrollListener(this));
    }
  }
  
  private void v()
  {
    if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)) {}
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      long l = ((VideoPlayManager.VideoPlayParam)localObject).jdField_c_of_type_Long;
      localObject = a(((VideoPlayManager.VideoPlayParam)localObject).jdField_a_of_type_Int);
      if ((localObject != null) && (l != ((BaseArticleInfo)localObject).mArticleID))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(12);
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video", 2, "fixVideoPlayErrorState stopVideo videoVid:" + ((BaseArticleInfo)localObject).getVideoVid());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.readinjoy.video", 2, "fixVideoPlayErrorState stopVideo throwable:" + localThrowable.getMessage());
    }
  }
  
  private void w()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a().findViewById(2131374178));
    if (DailyModeConfigHandler.c(b()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a().findViewById(2131374177));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a().findViewById(2131374176));
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = VideoAutoPlayController.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a(this.jdField_a_of_type_Long);
    if (b() == 56)
    {
      VideoReporter.jdField_a_of_type_Int = VideoReporter.a(a().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentWidgetListView.setContentBackground(new ColorDrawable(-1));
    }
    if (a().a().a() != null)
    {
      a().a(a().a().a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController);
      return;
    }
    m();
  }
  
  private void y()
  {
    boolean bool = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    ArticleInfo localArticleInfo = a().a();
    int i;
    if ((bool) && ((a() instanceof ReadInJoyChannelActivity)))
    {
      if (!this.h) {
        break label220;
      }
      i = RIJItemViewType.a(localArticleInfo);
      if ((i != 6) && (i != 71)) {
        break label174;
      }
      this.jdField_b_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_left", 0);
      this.jdField_a_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_top", 0);
      ReadInJoyAnimUtils.a(a(), localArticleInfo, a(), (ReadInJoyArticleAdapter)a(), b(), this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
      a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager = new ADBaseAppDownloadManager(a());
      a().a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager);
      ThreadManager.executeOnSubThread(new VideoHandler.7(this));
      return;
      label174:
      if (i == 28)
      {
        i = ReadInJoyHelper.e(ReadInJoyUtils.a());
        ReadInJoyAnimUtils.a(a(), localArticleInfo, a(), (ReadInJoyArticleAdapter)a(), b(), 0, i);
        a(i);
        continue;
        label220:
        j();
      }
    }
  }
  
  private void z()
  {
    ThreadManager.executeOnSubThread(new VideoHandler.10(this));
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
    }
    return l;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = a(paramInt).intValue();
    Object localObject;
    ReadInJoyView localReadInJoyView;
    if ((paramView == null) || (!(paramView.getTag() instanceof ViewHolder)))
    {
      localObject = a(paramInt, paramView, paramViewGroup, i);
      paramView = ((ViewHolder)localObject).a(paramInt, paramViewGroup);
      ((ViewHolder)localObject).g = paramView;
      ((ViewHolder)localObject).jdField_a_of_type_Int = paramInt;
      paramView.setTag(localObject);
      paramView.setTag(2131369928, a());
      paramViewGroup = new ReadInJoyPresenterImpl(a(), a().a().a(), a(), a(), a().a(), a().a());
      paramView.setTag(2131381653, paramViewGroup);
      localReadInJoyView = new ReadInJoyView(paramView);
      paramView.setTag(2131381656, localReadInJoyView);
    }
    BaseArticleInfo localBaseArticleInfo;
    for (;;)
    {
      localBaseArticleInfo = a(paramInt);
      ((ViewHolder)localObject).a(a());
      if (localBaseArticleInfo != null) {
        break;
      }
      QLog.w("VideoHandler", 2, "article is null, return");
      return localReadInJoyView.a();
      localObject = (ViewHolder)paramView.getTag();
      ((ViewHolder)localObject).jdField_a_of_type_Int = paramInt;
      paramViewGroup = (IReadInJoyPresenter)paramView.getTag(2131381653);
      localReadInJoyView = (ReadInJoyView)paramView.getTag(2131381656);
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((VideoFeedsTwoItemViewHolder)localObject, localBaseArticleInfo);
      ReadInJoyPTSCostHelper.a("VideoHandler", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      localObject = null;
      if (paramInt < d() - 1) {
        localObject = (ArticleInfo)a(paramInt + 1);
      }
      localObject = new ReadInJoyModelImpl(a(), (ArticleInfo)localBaseArticleInfo, i, b(), c(), paramInt, a(), d(), (ArticleInfo)localObject, a());
      paramView.setTag(2131381651, localObject);
      paramViewGroup.a(localReadInJoyView, (IReadInJoyModel)localObject, i);
      return localReadInJoyView.a();
      if (i == 4)
      {
        l = System.currentTimeMillis();
        a().a((VideoFeedsViewHolder)localObject, localBaseArticleInfo, paramInt);
        ReadInJoyPTSCostHelper.a("VideoHandler", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
        if ((a() != null) && (a().a() != null) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
        {
          localObject = (AdvertisementInfo)localBaseArticleInfo;
          a().a().a((AdvertisementInfo)localObject, a().a());
        }
      }
      else if (i == 70)
      {
        l = System.currentTimeMillis();
        a().a((WeishiGridTwoItemViewHolder)localObject, localBaseArticleInfo, paramInt);
        ReadInJoyPTSCostHelper.a("VideoHandler", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
      }
      else if (i == 118)
      {
        a().a((VideoColumnItemViewHolder)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 119)
      {
        a().a((VideoFeedsViewHolder)localObject, localBaseArticleInfo, paramInt);
        localObject = (VideoFeedsWithColumnViewHolder)localObject;
        ((VideoFeedsWithColumnViewHolder)localObject).a(localBaseArticleInfo.mVideoColumnInfo);
        ((VideoFeedsWithColumnViewHolder)localObject).a(localBaseArticleInfo);
        ((VideoFeedsWithColumnViewHolder)localObject).f.setTag(localObject);
        ((VideoFeedsWithColumnViewHolder)localObject).l.setTag(localObject);
      }
      else if (i == 6)
      {
        a().a((BigImgVideoItemViewHolder)localObject, localBaseArticleInfo, paramInt);
      }
      else if (i == 128)
      {
        a().a((BigImgVideoColumnItemViewHolder)localObject, localBaseArticleInfo, paramInt);
      }
    }
  }
  
  public VideoHandler.PlayableItem a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem;
  }
  
  public VideoHandler.PlayableItem a(AbsListView paramAbsListView)
  {
    Object localObject;
    if ((!a().a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController == null) || (paramAbsListView.getChildCount() <= 0))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    label30:
    if (i < paramAbsListView.getChildCount())
    {
      View localView = paramAbsListView.getChildAt(i);
      if ((localView.getTag() instanceof VideoHandler.PlayableItem))
      {
        localObject = (VideoHandler.PlayableItem)localView.getTag();
        if (!((VideoHandler.PlayableItem)localObject).a(localView)) {}
      }
    }
    for (paramAbsListView = (AbsListView)localObject;; paramAbsListView = null)
    {
      localObject = paramAbsListView;
      if (paramAbsListView != null) {
        break;
      }
      localObject = paramAbsListView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.readinjoy.video", 2, "checkPlayableArea(): no item can auto play...");
      return paramAbsListView;
      i += 1;
      break label30;
    }
  }
  
  public ArticleInfo a()
  {
    return a().a();
  }
  
  public VideoAutoPlayController a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  }
  
  public VideoPreDownloadMgr a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  }
  
  public VideoRecommendManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
  }
  
  public VideoShareHelper a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper;
  }
  
  public VideoFeedsViewHolder a(String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
    int i = Math.max(this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount(), j);
    int k;
    if (i < a().a().size() + this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount())
    {
      k = i - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      BaseArticleInfo localBaseArticleInfo = a(k);
      if ((4 == a(k).intValue()) && (localBaseArticleInfo != null) && (TextUtils.equals(localBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        int m = i - j;
        if ((m >= 0) && (m < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())) {
          paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
        }
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        return (VideoFeedsViewHolder)paramString.getTag();
        if ((k >= 0) && (k < a().a().size())) {
          paramString = a(k, null, this.jdField_a_of_type_ComTencentWidgetListView);
        }
      }
      else
      {
        return null;
        i += 1;
        break;
        return null;
      }
      paramString = null;
    }
  }
  
  public ViewHolder a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = a();
    switch (paramInt2)
    {
    default: 
      paramView = new VideoFeedsViewHolder(paramView, this);
    }
    for (;;)
    {
      a(paramView);
      return paramView;
      paramView = new VideoFeedsViewHolder(paramView, this);
      continue;
      paramView = new VideoFeedsTwoItemViewHolder(paramView, this);
      continue;
      paramView = new WeishiGridTwoItemViewHolder(paramView, this);
      continue;
      paramView = new VideoColumnItemViewHolder(paramView, this);
      continue;
      paramView = new VideoFeedsWithColumnViewHolder(paramView, this);
      continue;
      paramView = new BigImgVideoItemViewHolder(paramView, this);
      continue;
      paramView = new BigImgVideoColumnItemViewHolder(paramView, this);
    }
  }
  
  public Boolean a()
  {
    if ((a() != null) && (a().a() != null) && (a().a().a()))
    {
      a().a().j();
      return Boolean.valueOf(true);
    }
    return super.a();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        a(paramIntent);
        return;
      case 2: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult for REFRESH_EVENT_CHECK_PLAYAREA");
        }
        v();
        b(this.jdField_a_of_type_ComTencentWidgetListView, 50);
        QLog.d("gifvideo.VideoHandler", 2, "check shortcontent play");
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "do nothing!");
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (b() == 40677) {
      if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
  }
  
  public void a(View paramView1, View paramView2, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    super.a(paramView1, paramView2, paramBaseArticleInfo, paramInt);
    a(paramView2, paramInt);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    w();
    x();
    y();
    z();
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoNetInfoHandler = new NetInfoHandler(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler = new ViewHolder.VideoUIHandler();
    this.f = ReadInJoyHelper.e();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidContentContext = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper = new VideoShareHelper(a());
    u();
    this.jdField_a_of_type_Long = paramLong;
    this.h = VideoFeedsHelper.c();
  }
  
  public void a(VideoHandler.PlayableItem paramPlayableItem)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem = paramPlayableItem;
    a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(paramPlayableItem.a());
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.postDelayed(new VideoHandler.5(this, paramVideoPlayParam), 1000L);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem != null) {}
    for (;;)
    {
      return;
      VideoFeedsViewHolder localVideoFeedsViewHolder = a(paramVideoPlayParam.j);
      if (localVideoFeedsViewHolder != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem = localVideoFeedsViewHolder;
        paramVideoPlayParam.jdField_a_of_type_AndroidViewView = localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      }
      while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() != null))
      {
        paramVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
        if (QLog.isColorLevel()) {
          QLog.i("VideoHandler", 2, "notifyVideoPositionChanged:");
        }
        paramVideoPlayParam.g();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("VideoHandler", 2, "fixNowPlayHolder failed videoPlayParam:" + paramVideoPlayParam + "    callSource:" + paramInt);
        }
      }
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    RIJVideoReportManager.a(paramVideoPlayParam, paramBaseArticleInfo, a());
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam1, VideoPlayManager.VideoPlayParam paramVideoPlayParam2)
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = a();
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).a(paramVideoPlayParam1, paramVideoPlayParam2);
    }
    if (this.jdField_a_of_type_Long == 1002L)
    {
      int i = AIOUtils.a(44.5F, a().getResources());
      int j = a().getResources().getDimensionPixelOffset(2131298859);
      a().setPadding(0, i + j, 0, 0);
    }
    b(paramVideoPlayParam1, paramVideoPlayParam2);
  }
  
  public void a(VideoPlayManager paramVideoPlayManager, VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = paramVideoAutoPlayController;
    if (VideoAutoPlayController.a(BaseApplicationImpl.getContext())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b(true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (!a().e()))
      {
        m();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController);
        if (ReadInJoyHelper.a(c())) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(0);
        }
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b(false);
    }
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    super.f();
    if ((a().a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.postDelayed(new VideoHandler.6(this), 1200L);
      }
    }
    else
    {
      return;
    }
    b(this.jdField_a_of_type_ComTencentWidgetListView, ReadInJoyBaseAdapter.jdField_b_of_type_Int);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    t();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (RIJFeedsType.a(a(paramInt1))) && (b() == 56) && (this.f) && (paramInt2 == 4);
  }
  
  public VideoFeedsViewHolder b(String paramString)
  {
    Object localObject2 = null;
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
    int i = Math.max(this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount(), j);
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i <= k)
      {
        int m = i - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
        localObject1 = a(m);
        if ((localObject1 == null) || (4 != a(m).intValue()) || (!TextUtils.equals(((BaseArticleInfo)localObject1).innerUniqueID, paramString))) {
          break label122;
        }
        paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
        localObject1 = localObject2;
        if (paramString != null) {
          localObject1 = (VideoFeedsViewHolder)paramString.getTag();
        }
      }
      return localObject1;
      label122:
      i += 1;
    }
  }
  
  public void b()
  {
    super.b();
    this.g = true;
    n();
    A();
    C();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoHandler.1(this), 1000L);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            return;
            localObject = a(paramAbsListView);
          } while ((b() == 40677) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.h())) || ((paramAbsListView.getFirstVisiblePosition() <= 5) && (!SuperMaskDataMgr.a.a()) && ((SuperMaskUIMgr.a.a() == 1) || (SuperMaskUIMgr.a.a() == 2))));
          if (localObject == null) {
            break;
          }
          localObject = ((VideoHandler.PlayableItem)localObject).a();
        } while ((localObject != null) && (((VideoPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (((VideoPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.patchStatus.a.get() == 1));
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b()) || (paramAbsListView.getVisibility() != 0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.removeMessages(1001);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "checkPlayableArea delay: " + paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(9, paramBoolean);
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    super.c();
    this.g = false;
    q();
    a().d();
    VideoPlayControlUtils.a(this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  public void c(AbsListView paramAbsListView, int paramInt)
  {
    if ((b() == 0) || (b() == 40677)) {}
    do
    {
      do
      {
        return;
      } while ((!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) || (paramAbsListView == null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.removeMessages(1001);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "force checkPlayableArea delay: " + paramInt);
  }
  
  public boolean c()
  {
    return a().a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.a.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager.a();
    }
  }
  
  public void f()
  {
    super.f();
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if ((localQQAppInterface != null) && (!e))
    {
      e = true;
      ((DynamicNowManager)localQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a();
    }
  }
  
  public void g() {}
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    VideoPlayManager.VideoPlayParam localVideoPlayParam;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null)
    {
      localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem != null) || (localVideoPlayParam != null)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null))
      {
        int j = -1;
        i = j;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem.a() != null) {
            i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler$PlayableItem.a().jdField_a_of_type_Int;
          }
        }
        if (localVideoPlayParam == null) {
          break label115;
        }
        i = localVideoPlayParam.jdField_a_of_type_Int;
      }
    }
    label115:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i, true);
      return;
      localVideoPlayParam = null;
      break;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      this.jdField_a_of_type_ComTencentWidgetListView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    } while (!ReadInJoyAdUtils.a(this.jdField_a_of_type_AndroidGraphicsRect));
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_b_of_type_Boolean) {
        a(this.jdField_a_of_type_ComTencentWidgetListView);
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel())
      {
        QLog.w("VideoHandler", 2, "MSG_FOR_CHECK_PLAYAREA, 平移转场动画未做完，不触发自动播放");
        continue;
        a(this.jdField_a_of_type_ComTencentWidgetListView);
      }
    }
  }
  
  public void i()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = a();
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).p();
    }
    if (this.jdField_a_of_type_Long == 1002L) {
      a().setPadding(0, 0, 0, 0);
    }
  }
  
  public void j()
  {
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && ((e()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a())) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b()) && (this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.removeMessages(1001);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.sendEmptyMessage(1001);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "checkPlayableArea after transAnim: ");
      }
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a(false);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(new VideoHandler.2(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VideoHandler", 2, "mVideoPlayManager == null");
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(BaseApplicationImpl.getContext());
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
    if (b() == 56) {}
    for (int i = VideoPreloadReportData.jdField_b_of_type_Int;; i = VideoPreloadReportData.jdField_a_of_type_Int)
    {
      localVideoPreDownloadMgr.a = new VideoPreloadReportData(i, VideoPreloadReportData.g);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new VideoHandler.3(this));
      return;
    }
  }
  
  public void n()
  {
    if ((a().a().f()) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.b();
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int i = j;
      if (j >= d()) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i);
      a().a().b(false);
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.removeMessages(1001);
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(9);
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b();
    }
  }
  
  public void r()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder$VideoUIHandler.removeMessages(1001);
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoHandler", 2, "clearData " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoNetInfoHandler);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoShareVideoShareHelper.a();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoNetInfoHandler);
  }
  
  public void t()
  {
    VideoPlayManager localVideoPlayManager = a().a().a();
    if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null)) {
      localVideoPlayManager.b(11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler
 * JD-Core Version:    0.7.0.1
 */