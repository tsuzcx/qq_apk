package com.tencent.biz.pubaccount.readinjoy.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.popup.RIJFollowRecommendPopupEvent;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoPreloadStrategyConoller;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.miniaio.MiniPieJumpToAioEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.colornote.swipeback.SwipeLayoutUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsPlayActivity
  extends FragmentActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, IVideoFeedsLoadDelegate.LifeCycleCallBack, VideoFeedsRecommendFragment.LifeCycleCallBack, VideoFeedsShareController.ShareSheetActionListener, SimpleEventReceiver
{
  private static boolean jdField_a_of_type_Boolean = false;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private IVideoFeedsLoadDelegate jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsLoadDelegate;
  private VideoFeedsCustomFrameLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout;
  private VideoFeedsRecommendFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment;
  private VideoFeedsResourceLoader jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsResourceLoader;
  private VideoFeedsShareController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController;
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private DragFrameLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController;
  private ColorNote jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
  private String jdField_a_of_type_JavaLangString = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e = false;
  private boolean f;
  private boolean g;
  private boolean h;
  
  private long a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == null)) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a().a();
  }
  
  private VideoInfo a()
  {
    if (((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder instanceof VideoItemHolder)) && (((VideoItemHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a.a != null)) {
      return ((VideoItemHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a.a;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b() != null) {
        return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      }
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    }
    return null;
  }
  
  private IVideoFeedsLoadDelegate a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsLoadDelegate == null) {
      switch (getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0))
      {
      default: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsLoadDelegate = new VideoFeedsLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsLoadDelegate;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsLoadDelegate = new VideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsLoadDelegate = new WeishiVideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
    }
  }
  
  private String a()
  {
    return VideoFeedsHelper.a(a(), false, true) + "&v_bg_color=ffffffff&v_push_animated_disable=1&v_fromswitch=1&fromType=105&firstCreated=1";
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    String str1 = "0X800B455";
    VideoR5.Builder localBuilder;
    label91:
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    String str2;
    if (paramInt == 0)
    {
      str1 = "0X800B455";
      paramInt = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      localBuilder = new VideoR5.Builder((VideoInfo)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a()).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a().d()).a(paramInt).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b());
      if (!paramBoolean) {
        break label184;
      }
      paramInt = i;
      localBuilder = localBuilder.a("is_full_left_slide", Integer.valueOf(paramInt));
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str2 = ((VideoInfo)localObject).j;
      if (TextUtils.isEmpty(((VideoInfo)localObject).g)) {
        break label189;
      }
    }
    label184:
    label189:
    for (localObject = ((VideoInfo)localObject).g;; localObject = "0")
    {
      localIPublicAccountReportUtils.videoDataReportWithFansInfoInR5(null, str2, str1, str1, 0, 0, "0", "", (String)localObject, localBuilder.a().a(), false);
      return;
      if (paramInt != 1) {
        break;
      }
      str1 = "0X800B454";
      break;
      paramInt = 0;
      break label91;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    int i = 1;
    if (Aladdin.getConfig(384).getIntegerFromString("samsung_enable", 1) == 1) {}
    while ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 29) && (i != 0))
    {
      i = paramActivity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
      i = paramActivity.getResources().getDimensionPixelSize(i);
      if ((i > 0) && (i < ViewUtils.a(20.0F)))
      {
        VideoFeedsHelper.a(paramActivity);
        return;
        i = 0;
      }
      else
      {
        VideoFeedsHelper.b(paramActivity);
        return;
      }
    }
    VideoFeedsHelper.b(paramActivity);
  }
  
  private void a(RIJFollowRecommendPopupEvent paramRIJFollowRecommendPopupEvent)
  {
    IVideoFeedsItemUIDelegate localIVideoFeedsItemUIDelegate;
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder instanceof ShortVideoItemHolder))
    {
      localIVideoFeedsItemUIDelegate = ((ShortVideoItemHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a;
      if (paramRIJFollowRecommendPopupEvent.showing) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      localIVideoFeedsItemUIDelegate.a(bool);
      return;
    }
  }
  
  static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, paramString);
    }
  }
  
  static void a(String paramString, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, paramString, paramException);
    }
  }
  
  private boolean a()
  {
    return (!(this.jdField_a_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) || (((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).getCurrentItem() == 0);
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      FlingGestureHandler localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (localFlingGestureHandler.mTopLayout != null)
      {
        localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(paramBoolean);
        localFlingGestureHandler.mTopLayout.setIsInterceptChildEventWhenScroll(paramBoolean);
      }
    }
  }
  
  private void e(boolean paramBoolean)
  {
    int i;
    label31:
    Object localObject2;
    boolean bool;
    label166:
    label190:
    Object localObject3;
    label202:
    label239:
    Object localObject4;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label414;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
      Object localObject5 = new VideoR5.Builder("", "", "", "").b(this.jdField_a_of_type_JavaLangString).a(409409).b((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
      if (localObject1 != null)
      {
        localObject2 = ((VideoR5.Builder)localObject5).e(((VideoInfo)localObject1).f).c(((VideoInfo)localObject1).s).l(i).s(((VideoInfo)localObject1).d()).t(this.jdField_b_of_type_Int + 1).d(((VideoInfo)localObject1).j).e(((VideoInfo)localObject1).jdField_a_of_type_JavaLangString).f(((VideoInfo)localObject1).g);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c())) {
          break label419;
        }
        bool = true;
        ((VideoR5.Builder)localObject2).b(bool);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label425;
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
      if (localObject2 == null) {
        break label431;
      }
      localObject3 = ((VideoInfo)localObject2).g;
      int j = getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      ((VideoR5.Builder)localObject5).h((String)localObject3).E(j).M(0);
      if (!paramBoolean) {
        break label437;
      }
      localObject3 = "1";
      if (!jdField_a_of_type_Boolean) {
        break label444;
      }
      localObject4 = "0X8009501";
      label250:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", (String)localObject4, (String)localObject4, 0, 0, (String)localObject3, "", "", ((VideoR5.Builder)localObject5).a().a(), false);
      String str1 = "";
      localObject4 = "";
      localObject5 = "";
      localObject3 = str1;
      if (localObject1 != null)
      {
        String str2 = String.valueOf(i + 1);
        localObject3 = str1;
        localObject4 = str2;
        if (((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)
        {
          localObject3 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
          localObject4 = str2;
        }
      }
      localObject1 = localObject5;
      if (localObject2 != null) {
        if (((VideoInfo)localObject2).jdField_b_of_type_Int < ((VideoInfo)localObject2).jdField_c_of_type_Int) {
          break label452;
        }
      }
    }
    label414:
    label419:
    label425:
    label431:
    label437:
    label444:
    label452:
    for (Object localObject1 = String.valueOf(1);; localObject1 = String.valueOf(2))
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800957B", "0X800957B", 0, 0, (String)localObject3, (String)localObject4, (String)localObject1, "", false);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label31;
      bool = false;
      break label166;
      localObject2 = null;
      break label190;
      localObject3 = null;
      break label202;
      localObject3 = "0";
      break label239;
      localObject4 = "0X8007DBB";
      break label250;
    }
  }
  
  private void h()
  {
    ThreadManager.post(new VideoFeedsPlayActivity.1(this), 1, null, true);
  }
  
  private void i()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_a_of_type_Int = i;
    if ((i == 9) || (i == 12) || (i == 21) || (i == 20) || (i == 22) || (i == 23)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("KEY_IS_WEISHI_MODE", jdField_a_of_type_Boolean);
      getIntent().putExtra("KEY_IS_WEISHI_MODE", jdField_a_of_type_Boolean);
      return;
    }
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    int i = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    int j = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
    String str2 = null;
    String str3 = "";
    String str1 = "";
    String str4 = "";
    long l = 0L;
    if (localObject != null)
    {
      if ((((VideoInfo)localObject).jdField_a_of_type_Int != 0) || (((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label220;
      }
      str2 = ((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    for (;;)
    {
      str3 = ((VideoInfo)localObject).j;
      str1 = ((VideoInfo)localObject).g;
      str4 = ((VideoInfo)localObject).jdField_a_of_type_JavaLangString;
      l = ((VideoInfo)localObject).a() * 1000L;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("session_id", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("video_session_id", this.jdField_b_of_type_JavaLangString);
        label147:
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        if (!TextUtils.isEmpty(str1)) {}
        for (localObject = str1;; localObject = "0")
        {
          localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str3, "0X800740A", "0X800740A", 0, 0, String.valueOf(i), String.valueOf(j), (String)localObject, VideoReporter.a(str2, str3, str4, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c(), l, localJSONObject), false);
          return;
          label220:
          str2 = null;
          break;
        }
      }
      catch (Exception localException)
      {
        break label147;
      }
    }
  }
  
  @TargetApi(11)
  private void k()
  {
    int i = getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsResourceLoader = new VideoFeedsResourceLoader(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsResourceLoader.a(i);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)findViewById(2131366051));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout = ((VideoFeedsCustomFrameLayout)findViewById(2131377366));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a().a(getLayoutInflater(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout));
    if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
      ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).addOnPageChangeListener(this);
    }
    l();
  }
  
  private void l()
  {
    if (Aladdin.getConfig(417).getIntegerFromString("open_auto_color_ball", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.h = bool;
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController = new ColorNoteController(this, true, false, true, true, 0);
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(ViewUtils.a());
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(this);
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new VideoFeedsPlayActivity.3(this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new VideoFeedsPlayActivity.4(this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new VideoFeedsPlayActivity.5(this));
      return;
    }
  }
  
  private void m()
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      FlingGestureHandler localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      localFlingGestureHandler.setTopLayout(new TopGestureLayout(this));
      localFlingGestureHandler.mTopLayout.setIsInterceptChildEventWhenScroll(false);
      localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(false);
      localFlingGestureHandler.mTopLayout.setInterceptScrollRLFlag(true);
      localFlingGestureHandler.mTopLayout.setOnFlingGesture(new VideoFeedsPlayActivity.6(this));
    }
  }
  
  private void n()
  {
    try
    {
      Object localObject1 = getSupportFragmentManager();
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = localObject1.getClass().getDeclaredField("mExecCommit");
      if (localObject2 != null)
      {
        ((Field)localObject2).setAccessible(true);
        localObject1 = ((Field)localObject2).get(localObject1);
        if (localObject1 != null)
        {
          localObject2 = FragmentActivity.class.getDeclaredField("mHandler");
          if (localObject2 != null)
          {
            ((Field)localObject2).setAccessible(true);
            localObject2 = ((Field)localObject2).get(this);
            if (localObject2 != null)
            {
              ((Handler)localObject2).removeCallbacks((Runnable)localObject1);
              return;
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void o()
  {
    String str = a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", str);
      if (a() != null) {
        localJSONObject.put("thirdUin", a().j);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
        localJSONObject.put("position", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a());
      }
      localJSONObject.put("recordId", this.jdField_c_of_type_JavaLangString);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "resetHomePage: HomePageUrl = " + str);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.updateViolaPage(str, localJSONObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.initViewAfterVisible();
  }
  
  private void p()
  {
    String str = a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "refreshHomePage: HomePageUrl = " + str);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.updateViolaPageWhenScroll(str);
    this.f = false;
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b())
    {
      this.jdField_d_of_type_Int = 3;
      Object localObject = a();
      if (localObject != null)
      {
        ((VideoInfo)localObject).q = this.jdField_d_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mReserve = VideoFeedsHelper.a((VideoInfo)localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
        if (!VideoResumeManager.a.a()) {
          break label72;
        }
      }
      label72:
      for (long l = 0L;; l = a())
      {
        ((ColorNote)localObject).mExtLong = l;
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.n();
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.i();
  }
  
  public void E_() {}
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(paramInt);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b();
    }
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
      VideoInfo localVideoInfo;
      int j;
      if ((paramViewHolder instanceof VideoItemHolder))
      {
        VideoItemHolder localVideoItemHolder = (VideoItemHolder)paramViewHolder;
        localVideoInfo = localVideoItemHolder.a.a;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController.a(localVideoInfo);
        }
        j = localVideoItemHolder.jdField_c_of_type_Int;
        if (j <= this.jdField_b_of_type_Int) {
          break label151;
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = j;
        this.jdField_a_of_type_JavaUtilSet.add(localVideoInfo.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
          ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).setScrollable(paramViewHolder instanceof ShortVideoItemHolder);
        }
        this.f = (paramViewHolder instanceof ShortVideoItemHolder);
        RIJPushNotifyManager.a.a().a(false, "MATCH_ALL_UIN");
        if (i != 0) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a();
        }
        return;
        label151:
        j = this.jdField_b_of_type_Int;
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).setScrollable(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.j();
      }
      ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, false);
    }
    for (;;)
    {
      RIJPushNotifyManager.a.a().a(false, "MATCH_ALL_UIN");
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).setScrollable(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.k();
      }
      ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, true);
    }
  }
  
  public void a(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = paramVideoFeedsRecommendFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this);
  }
  
  public void a(ViolaFragment paramViolaFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment = paramViolaFragment;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      d(false);
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.k();
      }
      a(this);
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).setScrollable(true);
      }
    }
    do
    {
      return;
      d(true);
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.j();
      }
    } while (!(this.jdField_a_of_type_AndroidViewViewGroup instanceof ViewPagerCompat));
    ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).setScrollable(false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setScrollable(true);
    }
  }
  
  protected void b()
  {
    try
    {
      super.setContentView(2131560429);
      this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID")))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID");
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("session_id");
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          this.jdField_c_of_type_JavaLangString = VideoReporter.b();
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CHANNEL_SESSION_ID");
        i();
        k();
        h();
        m();
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "setContentView IllegalStateException", localIllegalStateException);
        continue;
        this.jdField_a_of_type_JavaLangString = VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
      }
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.h();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.g();
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController = new VideoFeedsShareController(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(), this.jdField_a_of_type_Int, jdField_a_of_type_Boolean, this, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.jdField_a_of_type_AndroidWidgetImageView, "more_function_button");
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a();
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b(this);
    ThreadManager.excute(new VideoFeedsPlayActivity.2(this), 16, null, true);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c(paramBoolean);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController.a(0, 2);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SHARE, 0, 0, 0));
    }
    this.e = true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController.a(paramInt1, paramInt2, paramIntent);
      }
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Bundle)localObject);
        continue;
        if (paramInt2 == -1)
        {
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new QQToast(getActivity().getApplicationContext());
          ((QQToast)localObject).d(2000);
          if (i != 0)
          {
            ((QQToast)localObject).a(QQToast.a(2));
            ((QQToast)localObject).c(2131692259);
            ((QQToast)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299166) - (int)DisplayUtils.a(getActivity().getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).a(QQToast.a(1));
            ((QQToast)localObject).c(2131692260);
            ((QQToast)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299166) - (int)DisplayUtils.a(getActivity().getApplicationContext(), 5.0F));
            continue;
            if (paramInt2 == -1) {
              QQToast.a(getActivity(), 2131719363, 0).a();
            }
          }
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (!a()) {
      ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).setCurrentItem(0);
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b())) {
      return;
    }
    e(false);
    e();
    super.doOnBackPressed();
  }
  
  @TargetApi(11)
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      RIJAppSetting.a("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnCreate()");
    }
    super.doOnCreate(paramBundle);
    if (VersionUtils.d()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    LiuHaiUtils.enableNotch(this);
    a(this);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AF10", "0X800AF10", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "doOnCreate: " + paramBundle);
    if ((getIntent() == null) || (getIntent().getExtras() == null))
    {
      finish();
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "doOnCreate: getIntent().getExtras() = null");
      return true;
    }
    b();
    if (paramBundle != null) {
      overridePendingTransition(2130772237, 0);
    }
    for (;;)
    {
      int i = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
      VideoReport.setPageId(this, "6");
      VideoReport.setPageParams(this, new RIJDtParamBuilder().a("ref_channel", Integer.valueOf(i)).a());
      VideoReport.addToDetectionWhitelist(this);
      SimpleEventBus.getInstance().registerReceiver(this);
      return true;
      if (getIntent().getBooleanExtra("VIDEO_FEEDS_ANIM_ENABLE", true)) {
        a().a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout);
      }
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      this.jdField_c_of_type_Boolean = true;
      IVideoFeedsLoadDelegate localIVideoFeedsLoadDelegate = a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
        localIVideoFeedsLoadDelegate.a(localVideoInfo);
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a();
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController.c();
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_AndroidOsHandler = null;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsResourceLoader != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsResourceLoader.a();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        VideoBehaviorsReporter.a().a();
        ReadInJoyScreenShotReporter.a(this).b();
        VideoPreloadStrategyConoller.a().a("video_feeds", this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        a("VideoFeedsPlayActivity doOnDestroy()");
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        a("super.doOnDestroy failed. \n", localIllegalArgumentException);
        n();
        continue;
        Object localObject = null;
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!a()) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController.b();
    }
    if (!this.e) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b();
    }
    this.e = false;
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsPlayActivity.7(this), 500L);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController.a();
    }
    ReadInJoyScreenShotReporter.a(this).a(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle) {}
  
  public void doOnStop()
  {
    super.doOnStop();
    ReadInJoyScreenShotReporter.a(getActivity()).a();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    a(this);
  }
  
  protected void e()
  {
    finish();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.f();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.h();
    }
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == null))
    {
      super.finish();
      overridePendingTransition(0, 2130772015);
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean(VideoUIController.jdField_a_of_type_JavaLangString)) {
        ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 14, 0);
      }
      return;
    }
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    localVideoFeedsPlayManager.a(ReportConstants.VideoEndType.EXIT_SCENE);
    long l1 = localVideoFeedsPlayManager.a();
    long l2 = localVideoFeedsPlayManager.c();
    long l3 = localVideoFeedsPlayManager.d();
    int i;
    Object localObject;
    if (l3 > 0L)
    {
      i = (int)((float)l2 / (float)l3 * 100.0F);
      localObject = localVideoFeedsPlayManager.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() != localObject) {
        break label308;
      }
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", localVideoFeedsPlayManager.a());
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", l1);
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject).g);
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      setResult(-1, (Intent)localObject);
      super.finish();
      overridePendingTransition(0, 2130772015);
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_IS_FROM_CONVERSATION")) {
        ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 14, 0);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_VIDEO_PLAY_PROGRESS, i, 0, 0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.j();
      a("finishActivityWithResult() position=" + l1 + ", currentPlayStatus=" + localVideoFeedsPlayManager.a());
      return;
      i = 0;
      break;
      label308:
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", 0);
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.i();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(MiniPieJumpToAioEvent.class);
    localArrayList.add(RIJFollowRecommendPopupEvent.class);
    return localArrayList;
  }
  
  public String getModuleId()
  {
    return "module_videofeeds";
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    LiuHaiUtils.a(this);
    LiuHaiUtils.enableNotch(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b()))
      {
        e(false);
        e();
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
          VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.jdField_a_of_type_AndroidWidgetImageView, a(), "click_more_function");
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController.a(0, 1);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SHARE, 0, 0, 0));
        }
        this.e = true;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      if ((this.jdField_c_of_type_Int == ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).getCurrentItem()) && (!this.g))
      {
        if (this.jdField_c_of_type_Int != 0) {
          break label47;
        }
        a(1, false);
      }
    }
    for (;;)
    {
      this.g = false;
      return;
      label47:
      if (this.jdField_c_of_type_Int == 1) {
        a(0, false);
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((this.f) && (paramInt1 == 0) && (paramFloat > 0.0F))
    {
      o();
      p();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.g = true;
    a(paramInt, true);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof MiniPieJumpToAioEvent)) && (this.h)) {
      q();
    }
    while (!(paramSimpleBaseEvent instanceof RIJFollowRecommendPopupEvent)) {
      return;
    }
    a((RIJFollowRecommendPopupEvent)paramSimpleBaseEvent);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onRestoreInstanceState: ");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onSaveInstanceState: ");
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    this.mActNeedImmersive = false;
    getWindow().setFlags(1024, 1024);
    getWindow().setBackgroundDrawable(null);
    setRequestedOrientation(1);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if ((Build.VERSION.SDK_INT == 26) && (this.jdField_d_of_type_Boolean))
    {
      SwipeLayoutUtils.a(this);
      this.jdField_d_of_type_Boolean = false;
    }
    try
    {
      superSetRequestedOrientation(paramInt);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "setRequestedOrientation: ", localException);
    }
  }
  
  public boolean themeChangeRightNow()
  {
    return false;
  }
  
  public void updateAppRuntime()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity
 * JD-Core Version:    0.7.0.1
 */