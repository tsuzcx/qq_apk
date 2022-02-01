package com.tencent.mobileqq.activity;

import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.ObjectAnimator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.CardProfile.CardProfileComparator;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.flutter.config.QFlutterDPC;
import com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilderFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import com.tencent.mobileqq.profile.vote.LikeRankingUtil;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.profile.votelist.VoteItemClickListener;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.ZanBannerView;
import com.tencent.mobileqq.vas.ZanDoubleDialog;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.NearbyZanAnimLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class VisitorsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DecodeTaskCompletionListener, PraiseManager.OnPraiseLoadListener, VoteItemClickListener, OverScrollViewListener, SwipListView.SwipListListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new VisitorsActivity.1(this);
  SparseArray<Pair<Point, Boolean>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ObjectAnimator jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator;
  VisitorsActivity.ListViewScrollListener jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$ListViewScrollListener;
  VisitorsActivity.VisitorAdapter jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
  public CardHandler a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new VisitorsActivity.12(this);
  protected FriendsManager a;
  LikeRankingListManager jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new VisitorsActivity.5(this);
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  FloatViewBuilderFactory jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory;
  public INearbyCardHandler a;
  NearbyCardObserver jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new VisitorsActivity.14(this);
  LocalRedTouchManager jdField_a_of_type_ComTencentMobileqqNearbyRedtouchLocalRedTouchManager;
  GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new VisitorsActivity.15(this);
  VoteHelper jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new VisitorsActivity.11(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  ZanBannerView jdField_a_of_type_ComTencentMobileqqVasZanBannerView;
  NearbyZanAnimLayout jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new VisitorsActivity.2(this);
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  Runnable jdField_a_of_type_JavaLangRunnable;
  protected String a;
  public ArrayList<CardProfile> a;
  HashMap<String, ImageView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public Random a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = -1L;
  View jdField_b_of_type_AndroidViewView;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  VisitorsActivity.VisitorAdapter jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
  TabBarView jdField_b_of_type_ComTencentMobileqqWidgetTabBarView;
  String jdField_b_of_type_JavaLangString;
  public ArrayList<CardProfile> b;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 5;
  long jdField_c_of_type_Long = 0L;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  long jdField_d_of_type_Long = 0L;
  View jdField_d_of_type_AndroidViewView;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  long jdField_e_of_type_Long = 0L;
  View jdField_e_of_type_AndroidViewView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int;
  View jdField_f_of_type_AndroidViewView;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int;
  boolean jdField_g_of_type_Boolean = false;
  public int h;
  volatile boolean h;
  protected int i;
  boolean i;
  int j;
  public boolean j;
  int k = -1;
  private int l;
  private int m = 0;
  
  public VisitorsActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_h_of_type_Int = -1;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = null;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
  }
  
  private long a()
  {
    return getActivity().getSharedPreferences("visitors_last_refresh_time", 0).getLong("visitors_last_refresh_time", 0L);
  }
  
  private Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = com.tencent.mobileqq.utils.ImageUtil.h();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, TextView paramTextView)
  {
    paramImageView.setVisibility(8);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167124));
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130850860);
        paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167200));
        return;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130850860);
        paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167200));
        return;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if ((paramVipBaseInfo != null) && (paramVipBaseInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130851196);
        paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167200));
      }
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.m == 0) {
      this.m = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    paramInt = this.m;
    localStatableBitmapDrawable.setBounds(0, 0, paramInt, paramInt);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  private void a(CardProfile paramCardProfile)
  {
    AllInOne localAllInOne = new AllInOne(String.valueOf(paramCardProfile.lEctID), 41);
    localAllInOne.nickname = paramCardProfile.strNick;
    localAllInOne.age = paramCardProfile.bAage;
    localAllInOne.gender = paramCardProfile.bSex;
    localAllInOne.faceId = paramCardProfile.wFace;
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, String.format("openProfileCard nickname=%s likeSource=%s", new Object[] { paramCardProfile.strNick, Long.valueOf(paramCardProfile.uSource) }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(localAllInOne.uin))
    {
      localAllInOne.pa = 1;
      localAllInOne.likeSource = 1L;
      ProfileUtils.openProfileCardForResult(this, localAllInOne, 1023);
      return;
    }
    if (paramCardProfile.uSource == 53L)
    {
      localAllInOne.pa = 96;
      ProfileUtils.openProfileCardForResult(this, localAllInOne, 1023);
      return;
    }
    if (this.jdField_h_of_type_Int == 0) {
      localAllInOne.profileEntryType = 16;
    } else {
      localAllInOne.profileEntryType = 38;
    }
    if ((paramCardProfile.uSource > 0L) && (paramCardProfile.uSource <= 48L)) {
      localAllInOne.likeSource = paramCardProfile.uSource;
    } else {
      localAllInOne.likeSource = 6L;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("param_mode", 3);
    int n = getIntent().getIntExtra("frome_where", 6);
    Intent localIntent = new Intent();
    localIntent.putExtra("AllInOne", localAllInOne);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("frome_where", n);
    localIntent.addFlags(268435456);
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/nearby/people/profile", 1023);
    this.jdField_d_of_type_Long = paramCardProfile.lEctID;
  }
  
  private long b()
  {
    return getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).getLong("favoritors_last_refresh_time", 0L);
  }
  
  private void b(long paramLong)
  {
    getActivity().getSharedPreferences("visitors_last_refresh_time", 0).edit().putLong("visitors_last_refresh_time", paramLong).commit();
  }
  
  private void c(long paramLong)
  {
    getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).edit().putLong("favoritors_last_refresh_time", paramLong).commit();
  }
  
  @TargetApi(11)
  private void g()
  {
    setRightButton(2131718832, this);
    Object localObject1 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    this.l = ((DisplayMetrics)localObject1).widthPixels;
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131368866));
    this.jdField_b_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new VisitorsActivity.6(this));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131380967));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setContentBackground(getResources().getDrawable(2130838739), false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2131559642, this.jdField_a_of_type_ComTencentWidgetSwipListView, false));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setSwipListListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout = ((NearbyZanAnimLayout)findViewById(2131371746));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout.setEnabled(false);
    if (this.jdField_c_of_type_Boolean)
    {
      this.vg.setBackgroundResource(2131167445);
      localObject1 = getResources().getColorStateList(2131165352);
      this.leftView.setTextColor((ColorStateList)localObject1);
      this.leftView.setBackgroundResource(2130838767);
      this.rightViewText.setTextColor((ColorStateList)localObject1);
      this.rightViewText.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131370302));
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2131167445);
      this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.d();
      this.jdField_f_of_type_Int = ViewUtils.b(46.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(1);
      this.jdField_b_of_type_JavaLangString = getString(2131694400);
      this.centerView.setText("");
      this.jdField_g_of_type_Int = ViewUtils.b();
      localObject1 = LayoutInflater.from(this).inflate(2131561154, null);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject1).findViewById(2131376744);
      this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView = ((ZanBannerView)((View)localObject1).findViewById(2131381334));
      ((View)localObject1).findViewById(2131376779).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379748));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379560));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379855));
      this.jdField_d_of_type_AndroidViewView = ((View)localObject1).findViewById(2131369478);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131376759));
      int n = Math.round(ViewUtils.a() * 0.29F);
      Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = n;
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = n;
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369461));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131369463));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369460));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new VisitorsActivity.7(this));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369404));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369405));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369406));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369407));
      this.jdField_e_of_type_AndroidViewView = ((View)localObject1).findViewById(2131376662);
      if ((this.jdField_e_of_type_Boolean) && (VersionUtils.e())) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_f_of_type_AndroidViewView = ((View)localObject1).findViewById(2131369559);
      this.jdField_e_of_type_Int = (-ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
      this.jdField_d_of_type_Int = (ViewUtils.a() / 2);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView((View)localObject1);
      localObject2 = new VisitorsActivity.8(this);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$ListViewScrollListener = new VisitorsActivity.ListViewScrollListener(this);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$ListViewScrollListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)((View)localObject1).findViewById(2131378203));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131720388));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131693237));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
      e();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a();
      a(true, ((LikeRankingInfo)localObject1).likeCountOfToday, ((LikeRankingInfo)localObject1).rankingNum, ((LikeRankingInfo)localObject1).totalLikeCount);
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter);
    if (this.jdField_c_of_type_Boolean)
    {
      findViewById(2131376517).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131366982));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131376517));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131720388));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131693237));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
    ThreadManager.postImmediately(new VisitorsActivity.9(this), null, true);
    localObject1 = this.jdField_a_of_type_AndroidOsHandler;
    ((Handler)localObject1).sendMessage(((Handler)localObject1).obtainMessage(13, 1, 0));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper = new VoteHelper(this, this.jdField_a_of_type_AndroidOsHandler, this.app);
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter = new VisitorsActivity.VisitorAdapter(this, this, this.app, this, 0, this.jdField_c_of_type_Boolean);
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter = new VisitorsActivity.VisitorAdapter(this, this, this.app, this, 1, this.jdField_c_of_type_Boolean);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init visitors");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init favorite");
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.a(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.jdField_a_of_type_JavaLangString = getString(2131694419);
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.jdField_a_of_type_JavaLangString = getString(2131694406);
    startTitleProgress();
    this.jdField_c_of_type_JavaLangString = getResources().getString(2131699172);
  }
  
  int a(CardProfile paramCardProfile, String paramString)
  {
    boolean bool = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
    int i1 = paramCardProfile.bMutualFriends;
    int n = 10;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if ((!bool) && (paramCardProfile.bCloseNeighborVote == 1)) {
          break label157;
        }
        if (paramCardProfile.bAvailableCnt <= 0L)
        {
          if (paramCardProfile.bTodayVotedCnt > 0L) {
            break label150;
          }
          n = -3;
          break label157;
        }
      }
      else
      {
        if (paramCardProfile.bCloseNeighborVote == 1) {
          break label157;
        }
        if (paramCardProfile.bAvailableCnt <= 0L)
        {
          if (paramCardProfile.bTodayVotedCnt > 0L) {
            break label150;
          }
          n = -2;
          break label157;
        }
      }
    }
    else {
      if (paramCardProfile.bAvailableCnt <= 0L) {
        break label141;
      }
    }
    n = 0;
    break label157;
    label141:
    if (paramCardProfile.bTodayVotedCnt > 0L) {
      label150:
      n = 2;
    } else {
      n = -1;
    }
    label157:
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, String.format("getVoteLevel visibility=%d uin=%s isFrd=%b mutual=%d ", new Object[] { Integer.valueOf(n), paramString, Boolean.valueOf(bool), Byte.valueOf(paramCardProfile.bMutualFriends) }));
    }
    return n;
  }
  
  CharSequence a(CardProfile paramCardProfile, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = this.jdField_c_of_type_JavaLangString;
    int n;
    if (paramCardProfile.type == 2) {
      n = 2131716298;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = HardCodeUtil.a(n);
      break;
      if (paramCardProfile.bSex == 1) {
        n = 2131716299;
      } else {
        n = 2131716301;
      }
    }
    int i2 = 0;
    int i1 = 0;
    SpannableString localSpannableString = new SpannableString(String.format((String)localObject1, new Object[] { localObject2, Short.valueOf(paramCardProfile.bVoteCnt) }));
    if (paramCardProfile.dwLikeCustomId > 0L)
    {
      localObject1 = (PraiseManager)this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
      ((PraiseManager)localObject1).a(this);
      if (paramBoolean) {
        localObject1 = (PraiseInfo)((PraiseManager)localObject1).a.get(Integer.valueOf((int)paramCardProfile.dwLikeCustomId));
      } else {
        localObject1 = ((PraiseManager)localObject1).a((int)paramCardProfile.dwLikeCustomId, true, "from_profile_card");
      }
      localObject2 = localSpannableString;
      n = i2;
      if (localObject1 != null)
      {
        localObject2 = localSpannableString;
        n = i2;
        if (!TextUtils.isEmpty(((PraiseInfo)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject2 = SpannableString.valueOf(TextUtils.concat(new CharSequence[] { ((PraiseInfo)localObject1).jdField_b_of_type_JavaLangString, localSpannableString }));
          ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(((PraiseInfo)localObject1).jdField_b_of_type_Int), 0, ((PraiseInfo)localObject1).jdField_b_of_type_JavaLangString.length(), 33);
          n = i1;
          if (((PraiseInfo)localObject1).jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            a(paramTextView, ((PraiseInfo)localObject1).jdField_a_of_type_AndroidGraphicsBitmap, ((PraiseInfo)localObject1).jdField_b_of_type_Int);
            n = 1;
          }
          paramTextView.setOnClickListener(new VisitorsActivity.10(this, paramCardProfile, (PraiseInfo)localObject1, paramInt));
          paramTextView.setClickable(true);
        }
      }
    }
    else
    {
      paramTextView.setOnClickListener(null);
      n = i2;
      localObject2 = localSpannableString;
    }
    if (n == 0) {
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
    return localObject2;
  }
  
  void a()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      a(1, getString(2131694424));
      return;
    }
    a(false);
    VisitorsActivity.VisitorAdapter localVisitorAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
    localVisitorAdapter.jdField_a_of_type_Boolean = true;
    localVisitorAdapter.notifyDataSetChanged();
  }
  
  void a(int paramInt)
  {
    if (this.jdField_h_of_type_Int == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "[switchToTab] same tab return");
      }
      return;
    }
    Object localObject;
    if ((this.jdField_c_of_type_Boolean) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[switchToTab]tab=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", top1=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$ListViewScrollListener.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", visible1=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$ListViewScrollListener.jdField_a_of_type_Boolean);
      QLog.d("VisitorsActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_h_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout.clearAnimation();
      FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    }
    else if (paramInt == 1)
    {
      ReportController.a(this.app, "CliOper", "", "", "0X8004448", "0X8004448", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout.clearAnimation();
      FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout);
      Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, new CardProfile.CardProfileComparator());
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      if (VersionUtils.m())
      {
        localObject = getCurrentFocus();
        if (localObject != null) {
          ((View)localObject).clearFocus();
        }
      }
      if (this.jdField_i_of_type_Boolean)
      {
        this.jdField_i_of_type_Boolean = false;
        startTitleProgress();
        if (!NetworkUtil.isNetSupport(this))
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
          return;
        }
        b(true);
      }
    }
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$ListViewScrollListener.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setSelectionFromTop(0, -paramInt);
    if (this.jdField_c_of_type_Boolean)
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a();
      int n = this.jdField_h_of_type_Int;
      if (paramInt != n) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(n, false);
      }
      paramInt = this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.a();
      n = this.jdField_h_of_type_Int;
      if (paramInt != n) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(n, false);
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateRank todayVoteRank=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", todayVoteRank=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", totalVoteCount=");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("VisitorsActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10);
    ((Message)localObject).arg1 = paramInt1;
    ((Message)localObject).arg2 = paramInt2;
    Bundle localBundle = new Bundle();
    localBundle.putInt("totalVoteCount", paramInt3);
    ((Message)localObject).setData(localBundle);
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 200L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {
      return;
    }
    paramString = (Pair)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (paramString != null)
    {
      a(paramPraiseInfo, ((Point)paramString.first).x, ((Point)paramString.first).y, ((Boolean)paramString.second).booleanValue(), false);
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
    }
    paramString = this.jdField_a_of_type_ComTencentWidgetSwipListView;
    paramInt2 = this.jdField_h_of_type_Int;
    if (paramInt2 == 0) {
      paramPraiseInfo = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
    } else if (paramInt2 == 1) {
      paramPraiseInfo = this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
    } else {
      paramPraiseInfo = null;
    }
    int n = paramString.getFirstVisiblePosition();
    if (paramPraiseInfo == null) {
      return;
    }
    paramInt2 = 0;
    while (paramInt2 < paramPraiseInfo.jdField_a_of_type_JavaUtilList.size())
    {
      CardProfile localCardProfile = paramPraiseInfo.a(paramInt2);
      if ((localCardProfile == null) || (localCardProfile.dwLikeCustomId != paramInt1))
      {
        paramInt2 += 1;
      }
      else
      {
        paramPraiseInfo = paramString.getChildAt(paramInt2 - n + paramString.getHeaderViewsCount());
        if (paramPraiseInfo != null)
        {
          paramPraiseInfo = (TextView)paramPraiseInfo.findViewById(2131379975);
          if (paramPraiseInfo != null) {
            a(localCardProfile, paramPraiseInfo, true, paramInt2);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(long paramLong)
  {
    SwipListView localSwipListView = this.jdField_a_of_type_ComTencentWidgetSwipListView;
    VisitorsActivity.VisitorAdapter localVisitorAdapter;
    if (this.jdField_h_of_type_Int == 1) {
      localVisitorAdapter = this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
    } else {
      localVisitorAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
    }
    int i1 = localSwipListView.getChildCount();
    int n = 0;
    while (n < i1)
    {
      Object localObject = localSwipListView.getChildAt(n).getTag();
      if ((localObject != null) && ((localObject instanceof VisitorsActivity.CustomViewHolder)))
      {
        localObject = (VisitorsActivity.CustomViewHolder)localObject;
        if (((((VisitorsActivity.CustomViewHolder)localObject).jdField_a_of_type_JavaLangObject instanceof CardProfile)) && (((CardProfile)((VisitorsActivity.CustomViewHolder)localObject).jdField_a_of_type_JavaLangObject).lEctID == paramLong))
        {
          VisitorsActivity.VisitorAdapter.a(localVisitorAdapter, ((VisitorsActivity.CustomViewHolder)localObject).jdField_a_of_type_JavaLangObject, (VisitorsActivity.CustomViewHolder)localObject);
          return;
        }
      }
      n += 1;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    int n = paramView.getScrollX();
    if ((paramInt >= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter != null) && (this.k == paramInt)) {
      paramView.scrollTo(0, 0);
    } else if (n != 0) {
      paramView.scrollTo(0, 0);
    }
    paramView.setTag(-3, Integer.valueOf(getResources().getDimensionPixelSize(2131298570)));
  }
  
  public void a(ImageView paramImageView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    PraiseManager localPraiseManager = (PraiseManager)this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationInWindow(arrayOfInt);
    float f1 = arrayOfInt[0] + paramImageView.getPaddingLeft();
    float f2 = arrayOfInt[1] - this.jdField_j_of_type_Int + paramImageView.getPaddingTop();
    if ((paramBoolean2) && (localPraiseManager.a.get(Integer.valueOf(paramInt)) == null))
    {
      localPraiseManager.a(this);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new Pair(new Point((int)f1, (int)f2), Boolean.valueOf(paramBoolean1)));
    }
    a(localPraiseManager.a(paramInt, paramBoolean2, "from_profile_card"), f1, f2, paramBoolean1, paramBoolean2);
  }
  
  public void a(ImageView paramImageView, boolean paramBoolean)
  {
    int n = PraiseManager.a(this.app);
    if (n > 0)
    {
      a(paramImageView, n, paramBoolean, true);
      return;
    }
    paramImageView.setVisibility(0);
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationInWindow(arrayOfInt);
    if (!paramBoolean) {
      n = 2;
    } else {
      n = 1;
    }
    if (n == 2)
    {
      localNearbyZanAnimLayout = this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout;
      localNearbyZanAnimLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(n, localNearbyZanAnimLayout.a).a(), this.app, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(n, this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout.a), arrayOfInt[0] + paramImageView.getPaddingLeft() - DisplayUtil.a(this, 20.0F), arrayOfInt[1] - this.jdField_j_of_type_Int + paramImageView.getPaddingTop() - DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 75.0F), DisplayUtil.a(this, 65.0F));
      return;
    }
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout;
    localNearbyZanAnimLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(n, localNearbyZanAnimLayout.a).a(), arrayOfInt[0] + paramImageView.getPaddingLeft(), arrayOfInt[1] - this.jdField_j_of_type_Int + paramImageView.getPaddingTop());
  }
  
  void a(TextView paramTextView, Bitmap paramBitmap, int paramInt)
  {
    paramBitmap = com.tencent.biz.common.util.ImageUtil.a(new BitmapDrawable(getResources(), paramBitmap), paramInt);
    paramInt = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
    paramBitmap.setBounds(0, 0, paramInt, paramInt);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
    paramTextView.setCompoundDrawablePadding(5);
  }
  
  public void a(PraiseInfo paramPraiseInfo, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramPraiseInfo != null)
    {
      if ((!paramBoolean1) && (paramPraiseInfo.c != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout.a(paramPraiseInfo, paramPraiseInfo.c, this.app, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(2, this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout.a), paramFloat1 - DisplayUtil.a(this, 20.0F), paramFloat2 - DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 75.0F), DisplayUtil.a(this, 65.0F));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout.a(paramPraiseInfo, paramPraiseInfo.jdField_b_of_type_AndroidGraphicsBitmap, paramFloat1, paramFloat2);
      return;
    }
    if (!paramBoolean2)
    {
      int n = 1;
      if (!paramBoolean1) {
        n = 2;
      }
      if (n == 2)
      {
        paramPraiseInfo = this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout;
        paramPraiseInfo.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(n, paramPraiseInfo.a).a(), this.app, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(n, this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout.a), paramFloat1 - DisplayUtil.a(this, 20.0F), paramFloat2 - DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 75.0F), DisplayUtil.a(this, 65.0F));
        return;
      }
      paramPraiseInfo = this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout;
      paramPraiseInfo.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(n, paramPraiseInfo.a).a(), paramFloat1, paramFloat2);
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_j_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "doPraiseAnim, mIsPraiseAnimating=true");
      }
      return;
    }
    paramPraiseInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramInt2, paramInt3, new Object[] { Integer.valueOf(paramInt1), paramPraiseInfo });
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramPraiseInfo);
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof VisitorsActivity.CustomViewHolder)) {
        return;
      }
      if ((Thread.currentThread() != Looper.getMainLooper().getThread()) && (QLog.isColorLevel())) {
        QLog.i("VisitorsActivity", 2, "warning!!!!!! onRightBtnClick not in main thread");
      }
      int n = this.jdField_h_of_type_Int;
      if (n == 0)
      {
        paramObject = (VisitorsActivity.CustomViewHolder)paramObject;
        paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.b(paramObject.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.notifyDataSetChanged();
        if (paramObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(paramObject.lEctID, 1);
        }
        ReportController.b(this.app, "dc00898", "", "", "0X8009702", "0X8009702", 0, 0, "", "", "", "");
        return;
      }
      if (n == 1)
      {
        paramObject = (VisitorsActivity.CustomViewHolder)paramObject;
        paramObject = this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.b(paramObject.jdField_a_of_type_Int);
        this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.notifyDataSetChanged();
        if (paramObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(paramObject.lEctID, 0);
        }
        ReportController.b(this.app, "dc00898", "", "", "0X8009703", "0X8009703", 0, 0, "", "", "", "");
      }
    }
  }
  
  void a(String paramString, int paramInt, ImageView paramImageView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString))
    {
      localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 1, false);
        localBitmap1 = a();
      }
      paramImageView.setImageBitmap(localBitmap1);
      return;
    }
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(32, paramString, 200);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeStrangeFace(paramString, 200, true, false);
      localBitmap1 = a();
    }
    paramImageView.setImageBitmap(localBitmap1);
  }
  
  public void a(ArrayList<CardProfile> paramArrayList, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet onVisitorListOk");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onVisitorListOk");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    if (paramLong == 0L) {
      b(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (paramBoolean)
    {
      localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null)
      {
        localView.setVisibility(0);
        if (!TextUtils.isEmpty(this.centerView.getText().toString()))
        {
          this.centerView.setText(2131694400);
          return;
        }
        this.centerView.setText("");
      }
    }
    else
    {
      localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null)
      {
        localView.setVisibility(8);
        if (this.centerView != null) {
          this.centerView.setText(2131694400);
        }
      }
    }
  }
  
  @TargetApi(11)
  void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt1 >= 0)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    if (paramInt1 == 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131716302));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 18.0F);
      localObject1 = this.jdField_d_of_type_AndroidWidgetTextView;
      ((TextView)localObject1).setTypeface(((TextView)localObject1).getTypeface(), 1);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ((RelativeLayout.LayoutParams)localObject1).topMargin, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ViewUtils.b(7.0F));
    }
    else if (paramInt2 > 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt2));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 30.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setTypeface(Typeface.MONOSPACE);
      localObject1 = this.jdField_d_of_type_AndroidWidgetTextView;
      ((TextView)localObject1).setTypeface(((TextView)localObject1).getTypeface(), 0);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ((RelativeLayout.LayoutParams)localObject1).topMargin, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ViewUtils.b(5.0F));
    }
    if (paramBoolean)
    {
      if (paramInt3 > 0)
      {
        localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        if (paramInt3 > 9999) {
          this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(36.0F);
        } else {
          this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(44.0F);
        }
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a();
      int n;
      if ((paramInt3 >= 0) && (paramInt3 > ((LikeRankingInfo)localObject1).totalLikeCount))
      {
        if (((LikeRankingInfo)localObject1).totalLikeCount > 0) {
          n = ((LikeRankingInfo)localObject1).totalLikeCount;
        } else {
          n = 0;
        }
        localObject1 = new ValueAnimation(Integer.valueOf(n), Integer.valueOf(paramInt3), new VisitorsActivity.16(this));
        ((ValueAnimation)localObject1).setStartOffset(200L);
        ((ValueAnimation)localObject1).setDuration(1200L);
        this.jdField_c_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject1);
      }
      else
      {
        if (((LikeRankingInfo)localObject1).totalLikeCount > 0) {
          n = ((LikeRankingInfo)localObject1).totalLikeCount;
        } else {
          n = 0;
        }
        localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(n);
        ((StringBuilder)localObject2).append("");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a(paramInt1, paramInt2, paramInt3);
    if ((!paramBoolean) && (!this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    if ((paramBoolean) && (this.jdField_e_of_type_Boolean)) {
      return;
    }
    try
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845515);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845516);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845517);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130847409);
      paramInt1 = ViewUtils.b(1.0F);
      float f1;
      float f2;
      if (paramBoolean)
      {
        paramInt2 = paramInt1 * -299;
        paramInt3 = this.jdField_d_of_type_Int;
        f1 = paramInt2 + paramInt3;
        f2 = paramInt2 + paramInt3;
        paramInt2 = paramInt1 * 42;
        paramInt3 = this.jdField_e_of_type_Int;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt2 + paramInt3, 0, paramInt2 + paramInt3);
        ((TranslateAnimation)localObject1).setDuration(0L);
        ((TranslateAnimation)localObject1).setStartOffset(0L);
      }
      else
      {
        paramInt2 = this.jdField_d_of_type_Int;
        f1 = paramInt1 * -493 + paramInt2;
        f2 = paramInt1 * -299 + paramInt2;
        paramInt2 = this.jdField_e_of_type_Int;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt1 * 174 + paramInt2, 0, paramInt1 * 42 + paramInt2);
        ((TranslateAnimation)localObject1).setDuration(900L);
        ((TranslateAnimation)localObject1).setStartOffset(500L);
      }
      ((TranslateAnimation)localObject1).setFillEnabled(true);
      ((TranslateAnimation)localObject1).setFillAfter(true);
      ((TranslateAnimation)localObject1).setInterpolator(new OvershootInterpolator(1.0F));
      ((TranslateAnimation)localObject1).setAnimationListener(new VisitorsActivity.17(this));
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject1);
      if (paramBoolean)
      {
        paramInt2 = paramInt1 * -217;
        paramInt3 = this.jdField_d_of_type_Int;
        f1 = paramInt2 + paramInt3;
        f2 = paramInt2 + paramInt3;
        paramInt2 = paramInt1 * 47;
        paramInt3 = this.jdField_e_of_type_Int;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt2 + paramInt3, 0, paramInt2 + paramInt3);
        ((TranslateAnimation)localObject1).setDuration(0L);
        ((TranslateAnimation)localObject1).setStartOffset(0L);
      }
      else
      {
        paramInt2 = this.jdField_d_of_type_Int;
        f1 = paramInt1 * -520 + paramInt2;
        f2 = paramInt1 * -217 + paramInt2;
        paramInt2 = this.jdField_e_of_type_Int;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt1 * 239 + paramInt2, 0, paramInt1 * 47 + paramInt2);
        ((TranslateAnimation)localObject1).setDuration(900L);
        ((TranslateAnimation)localObject1).setStartOffset(350L);
      }
      ((TranslateAnimation)localObject1).setFillEnabled(true);
      ((TranslateAnimation)localObject1).setFillAfter(true);
      ((TranslateAnimation)localObject1).setInterpolator(new OvershootInterpolator(1.0F));
      ((TranslateAnimation)localObject1).setAnimationListener(new VisitorsActivity.18(this));
      this.jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject1);
      if (paramBoolean)
      {
        paramInt2 = this.jdField_d_of_type_Int;
        f1 = paramInt1 * -2 + paramInt2;
        f2 = paramInt1 * -15 + paramInt2;
        paramInt2 = paramInt1 * 50;
        paramInt3 = this.jdField_e_of_type_Int;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt2 + paramInt3, 0, paramInt2 + paramInt3);
        ((TranslateAnimation)localObject1).setDuration(0L);
        ((TranslateAnimation)localObject1).setStartOffset(0L);
      }
      else
      {
        paramInt2 = this.jdField_d_of_type_Int;
        f1 = paramInt1 * -160 + paramInt2;
        f2 = paramInt1 * -15 + paramInt2;
        paramInt2 = this.jdField_e_of_type_Int;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt1 * 138 + paramInt2, 0, paramInt1 * 50 + paramInt2);
        ((TranslateAnimation)localObject1).setDuration(900L);
        ((TranslateAnimation)localObject1).setStartOffset(200L);
      }
      ((TranslateAnimation)localObject1).setFillEnabled(true);
      ((TranslateAnimation)localObject1).setFillAfter(true);
      ((TranslateAnimation)localObject1).setInterpolator(new OvershootInterpolator(1.0F));
      ((TranslateAnimation)localObject1).setAnimationListener(new VisitorsActivity.19(this));
      this.jdField_e_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject1);
      if (paramBoolean)
      {
        paramInt2 = paramInt1 * 74;
        paramInt3 = this.jdField_d_of_type_Int;
        f1 = paramInt2 + paramInt3;
        f2 = paramInt2 + paramInt3;
        paramInt1 *= 34;
        paramInt2 = this.jdField_e_of_type_Int;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt1 + paramInt2, 0, paramInt1 + paramInt2);
        ((TranslateAnimation)localObject1).setDuration(0L);
        ((TranslateAnimation)localObject1).setStartOffset(0L);
      }
      else
      {
        paramInt2 = this.jdField_d_of_type_Int;
        f1 = paramInt1 * -180 + paramInt2;
        f2 = paramInt1 * 74 + paramInt2;
        paramInt2 = this.jdField_e_of_type_Int;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt1 * 148 + paramInt2, 0, paramInt1 * 34 + paramInt2);
        ((TranslateAnimation)localObject1).setDuration(900L);
        ((TranslateAnimation)localObject1).setStartOffset(300L);
      }
      ((TranslateAnimation)localObject1).setFillEnabled(true);
      ((TranslateAnimation)localObject1).setFillAfter(true);
      ((TranslateAnimation)localObject1).setInterpolator(new OvershootInterpolator(1.0F));
      ((TranslateAnimation)localObject1).setAnimationListener(new VisitorsActivity.20(this));
      this.jdField_f_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject1);
      if (!paramBoolean)
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a(NetConnInfoCenter.getServerTimeMillis());
        localObject1 = new AnimationSet(true);
        localObject2 = new ScaleAnimation(1.0F, 5.0F, 1.0F, 5.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject2).setDuration(1800L);
        ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
        AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 0.8F);
        localAlphaAnimation1.setDuration(400L);
        ((AnimationSet)localObject1).addAnimation(localAlphaAnimation1);
        AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.8F, 0.0F);
        localAlphaAnimation2.setDuration(1400L);
        localAlphaAnimation2.setStartOffset(400L);
        ((AnimationSet)localObject1).addAnimation(localAlphaAnimation2);
        ((AnimationSet)localObject1).setFillAfter(true);
        ((AnimationSet)localObject1).setFillEnabled(true);
        if (this.jdField_a_of_type_JavaLangRunnable == null) {
          this.jdField_a_of_type_JavaLangRunnable = new VisitorsActivity.21(this, (ScaleAnimation)localObject2, localAlphaAnimation1, localAlphaAnimation2, (AnimationSet)localObject1);
        }
        ((AnimationSet)localObject1).setAnimationListener(new VisitorsActivity.22(this));
        this.jdField_c_of_type_Int = 5;
        this.jdField_f_of_type_AndroidViewView.startAnimation((Animation)localObject1);
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label1592:
      break label1592;
    }
    QLog.e("VisitorsActivity", 1, "load img oom");
  }
  
  boolean a(boolean paramBoolean)
  {
    String str = this.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(str, this.jdField_a_of_type_JavaLangString, 0L, 30);
      return true;
    }
    long l1 = this.jdField_a_of_type_Long;
    if (l1 > -1L) {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(str, this.jdField_a_of_type_JavaLangString, l1, 30);
    }
    return true;
  }
  
  void b()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      a(1, getString(2131694424));
      return;
    }
    b(false);
    VisitorsActivity.VisitorAdapter localVisitorAdapter = this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
    localVisitorAdapter.jdField_a_of_type_Boolean = true;
    localVisitorAdapter.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    if (isFinishing())
    {
      QLog.d("VisitorsActivity", 1, "doPraiseMallEntryAnim isFinishing return");
      return;
    }
    if ((PraiseConfigHelper.b != null) && (!PraiseConfigHelper.b.isEmpty()))
    {
      ZanBannerView localZanBannerView = this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView;
      if (localZanBannerView != null)
      {
        localZanBannerView.setInfoList(PraiseConfigHelper.b);
        VasWebviewUtil.a(this.app.getCurrentAccountUin(), "thumbup", "banner_pageview", "", 1, 0, 0, "", "", "");
      }
    }
    else if (paramInt > 0)
    {
      ThreadManager.executeOnFileThread(new VisitorsActivity.13(this));
    }
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    int n = this.jdField_h_of_type_Int;
    if (n == 0)
    {
      if ((paramObject instanceof VisitorsActivity.CustomViewHolder))
      {
        paramObject = (VisitorsActivity.CustomViewHolder)paramObject;
        ReportController.a(this.app, "CliOper", "", "", "0X800444A", "0X800444A", 0, 0, "", "", "", "");
        a((CardProfile)paramObject.jdField_a_of_type_JavaLangObject);
        return;
      }
      if ((paramObject instanceof VisitorsActivity.MoreViewHolder)) {
        a();
      }
    }
    else if (n == 1)
    {
      if ((paramObject instanceof VisitorsActivity.CustomViewHolder))
      {
        paramObject = (VisitorsActivity.CustomViewHolder)paramObject;
        ReportController.a(this.app, "CliOper", "", "", "0X8004447", "0X8004447", 0, 0, "", "", "", "");
        a((CardProfile)paramObject.jdField_a_of_type_JavaLangObject);
        return;
      }
      if ((paramObject instanceof VisitorsActivity.MoreViewHolder)) {
        b();
      }
    }
  }
  
  public void b(ArrayList<CardProfile> paramArrayList, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet onFavoriteListOk");
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.a(this.jdField_b_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onFavoriteListOk");
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (paramLong == 0L) {
      c(true);
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.notifyDataSetChanged();
  }
  
  void b(boolean paramBoolean)
  {
    b(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
        return;
      }
      a(1, getString(2131719247));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.springBackOverScrollHeaderView();
    }
  }
  
  boolean b(boolean paramBoolean)
  {
    String str = this.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(str, this.jdField_a_of_type_JavaLangString, 0L, 30);
      return true;
    }
    long l1 = this.jdField_b_of_type_Long;
    if (l1 > -1L) {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(str, this.jdField_a_of_type_JavaLangString, l1, 30);
    }
    return true;
  }
  
  void c()
  {
    this.jdField_a_of_type_Boolean = false;
    QQToast.a(this, 1, 2131719247, 0).b(getTitleBarHeight());
    b(false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.jdField_a_of_type_Boolean)
    {
      VisitorsActivity.VisitorAdapter localVisitorAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
      localVisitorAdapter.jdField_a_of_type_Boolean = false;
      localVisitorAdapter.notifyDataSetChanged();
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  void c(boolean paramBoolean)
  {
    c(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 800L);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
        return;
      }
      a(1, getString(2131719247));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.springBackOverScrollHeaderView();
    }
  }
  
  void d()
  {
    this.jdField_b_of_type_Boolean = false;
    QQToast.a(this, 1, 2131719247, 0).b(getTitleBarHeight());
    c(false);
    if (this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.jdField_a_of_type_Boolean)
    {
      VisitorsActivity.VisitorAdapter localVisitorAdapter = this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
      localVisitorAdapter.jdField_a_of_type_Boolean = false;
      localVisitorAdapter.notifyDataSetChanged();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 1023) && (paramInt1 == 1028))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VisitorsActivity->doOnActivityResult, resultCode=");
        localStringBuilder.append(paramInt2);
        QLog.d("NearbyLikeLimitManager", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessINearbyCardHandler.a(0L, 0L, 511);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessINearbyCardHandler = ((INearbyCardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    paramBundle = this.app.getCurrentAccountUin();
    Object localObject = getIntent();
    this.jdField_a_of_type_JavaLangString = String.valueOf(((Intent)localObject).getLongExtra("toUin", 0L));
    this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager = ((LikeRankingListManager)this.app.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER));
    this.jdField_c_of_type_Boolean = ((Intent)localObject).getBooleanExtra("extra_show_rank", false);
    this.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("extra_from", -1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mShowRank=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      QLog.d("VisitorsActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory = new FloatViewBuilderFactory(this);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchLocalRedTouchManager = ((LocalRedTouchManager)this.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER));
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      if (this.jdField_b_of_type_Int == 1) {
        ThreadManager.post(new VisitorsActivity.3(this), 5, null, false);
      }
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null) {
      paramBundle.equals(localObject);
    }
    this.jdField_a_of_type_Long = getIntent().getLongExtra("nextMidVoter", -1L);
    setContentView(2131563040);
    h();
    g();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessINearbyCardHandler.a(0L, 0L, 511);
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator;
    if (localObject != null)
    {
      ((ObjectAnimator)localObject).removeAllListeners();
      this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.cancel();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    if (this.jdField_c_of_type_Boolean) {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    ((PraiseManager)this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).b(this);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ApngImage.pauseAll();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(14);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.c();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume mPartakeRank=");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      QLog.d("VisitorsActivity", 2, ((StringBuilder)localObject).toString());
    }
    a(this.jdField_d_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppCardHandler;
    if (localObject != null) {
      ((CardHandler)localObject).e();
    }
    if ((this.jdField_c_of_type_Boolean) && (this.mSystemBarComp != null))
    {
      int n = getResources().getColor(2131165349);
      this.mSystemBarComp.setStatusColor(n);
      this.mSystemBarComp.setStatusBarColor(n);
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
      this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.b();
    }
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout;
    if (localNearbyZanAnimLayout != null) {
      localNearbyZanAnimLayout.clearAnimation();
    }
    super.doOnStop();
  }
  
  void e()
  {
    RedTouchItem localRedTouchItem = this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchLocalRedTouchManager.a(100601);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchLocalRedTouchManager.a(localRedTouchItem, false))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateRedPoint level:");
        localStringBuilder.append(localRedTouchItem.passThroughLevel);
        QLog.d("VisitorsActivity", 2, localStringBuilder.toString());
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void f()
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.a(this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VisitorsActivity", 1, "updateFavData fail.", localException);
    }
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      FlingGestureHandler localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (localFlingGestureHandler.mTopLayout != null) {
        localFlingGestureHandler.mTopLayout.setInterceptTouchFlag(paramBoolean ^ true);
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
    if ((localObject != null) && (((VisitorsActivity.VisitorAdapter)localObject).jdField_a_of_type_Int > 0)) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004446", "0X8004446", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.jdField_a_of_type_Int), "", "", "");
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter;
    if ((localObject != null) && (((VisitorsActivity.VisitorAdapter)localObject).jdField_a_of_type_Int > 0)) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004449", "0X8004449", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.jdField_a_of_type_Int), "", "", "");
    }
    ReportController.b(this.app, "dc00898", "", "", "0X8007612", "0X8007612", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_Int == 2)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.app.getCurrentAccountUin())))
      {
        localObject = new AllInOne(this.jdField_a_of_type_JavaLangString, 0);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("single_top", true);
        ProfileActivity.a(getActivity(), (AllInOne)localObject, localBundle);
        overridePendingTransition(2130772002, 2130772003);
      }
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8007613", "0X8007613", 0, 0, "", "", "", "");
      startActivity(new Intent(this, LikeSettingActivity.class));
    }
    else
    {
      Object localObject1;
      Object localObject2;
      if (paramView.getId() == 2131369557)
      {
        localObject1 = paramView.getTag();
        if ((localObject1 != null) && ((localObject1 instanceof CardProfile)))
        {
          localObject1 = (CardProfile)localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a((CardProfile)localObject1, (ImageView)paramView))
          {
            localObject1 = Integer.toString(((CardProfile)localObject1).type);
            VasWebviewUtil.a(this.app.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", (String)localObject1, "");
            localObject2 = new ZanDoubleDialog(this);
            ((ZanDoubleDialog)localObject2).a(new VisitorsActivity.4(this, (String)localObject1));
            ((ZanDoubleDialog)localObject2).show();
          }
        }
      }
      else
      {
        int n = paramView.getId();
        if (n != 2131376744)
        {
          if (n == 2131376779)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView.a();
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = IndividuationUrlHelper.a(this, "praise", "");
            }
            localObject2 = new Intent(this, QQBrowserActivity.class);
            VasWebviewUtil.a(this.app.getCurrentAccountUin(), "thumbup", "banner_click", "", 1, 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView.b(), "");
            VasWebviewUtil.b(this, (String)localObject1, 536870912L, (Intent)localObject2, false, -1);
            ReportController.b(this.app, "CliOper", "", "", "like_mall", "like_enter", 0, 0, "", "", "", "");
          }
        }
        else
        {
          ReportController.b(this.app, "dc00898", "", "", "0X8007611", "0X8007611", 0, 0, "", "", "", "");
          LikeRankingUtil.a(this, QFlutterDPC.a().b());
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          this.jdField_f_of_type_AndroidViewView.clearAnimation();
          this.jdField_c_of_type_Int = 0;
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected View onCreateCenterView()
  {
    super.onCreateCenterView();
    this.centerView.setText(2131720341);
    return this.centerView;
  }
  
  protected View onCreateRightView()
  {
    super.onCreateRightView();
    this.rightViewText.setVisibility(8);
    return this.rightViewText;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    long l1 = SystemClock.uptimeMillis() - this.jdField_e_of_type_Long;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if ((paramInt1 != 0) && (l1 < 800L))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L - l1);
      return;
    }
    this.jdField_e_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_h_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityVisitorsActivity$VisitorAdapter.notifyDataSetChanged();
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
    long l1;
    if (this.jdField_h_of_type_Int == 0) {
      l1 = a();
    } else {
      l1 = b();
    }
    paramView.c(l1);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
    long l1;
    if (this.jdField_h_of_type_Int == 0) {
      l1 = a();
    } else {
      l1 = b();
    }
    paramView.b(l1);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Visitor", 2, "onViewCompleteVisableAndReleased");
    }
    if (!this.jdField_h_of_type_Boolean)
    {
      if (this.jdField_h_of_type_Int == 0) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      } else {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
      a(0, HardCodeUtil.a(2131716303));
      return true;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
    long l1;
    if (this.jdField_h_of_type_Int == 0) {
      l1 = a();
    } else {
      l1 = b();
    }
    paramView.a(l1);
    if (!stopTitleProgress())
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
        return true;
      }
      if (this.jdField_h_of_type_Int == 0)
      {
        a(true);
        return true;
      }
      b(true);
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void updateCurShowRightView(View paramView)
  {
    int i1 = -1;
    int n = i1;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      n = i1;
      if ((paramView instanceof Integer)) {
        n = ((Integer)paramView).intValue();
      }
    }
    this.k = n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity
 * JD-Core Version:    0.7.0.1
 */