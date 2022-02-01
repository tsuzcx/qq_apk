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
  ImageView A;
  TextView B;
  TextView C;
  TextView D;
  TextView E;
  View F;
  ImageView G;
  ImageView H;
  ImageView I;
  ImageView J;
  View K;
  View L;
  int M = 5;
  Runnable N;
  TabBarView O;
  int P;
  int Q;
  int R;
  String S;
  boolean T = false;
  boolean U = false;
  AlphaAnimation V;
  AlphaAnimation W;
  int X;
  IFaceDecoder Y;
  Bitmap Z;
  protected String a;
  int aA = -1;
  private PullRefreshHeader aB;
  private int aC;
  private AtomicBoolean aD = new AtomicBoolean(true);
  private AtomicBoolean aE = new AtomicBoolean(false);
  private SVIPObserver aF = new VisitorsActivity.5(this);
  private StatusManager aG;
  private IIconListener aH = new VisitorsActivity.11(this);
  private int aI = 0;
  ViewGroup aa;
  NearbyZanAnimLayout ab;
  public int ac = -1;
  HashMap<String, ImageView> ad = new HashMap();
  long ae = 0L;
  volatile boolean af = false;
  protected int ag = 0;
  public CardHandler ah;
  protected FriendsManager ai = null;
  boolean aj = true;
  public INearbyCardHandler ak;
  String al;
  FloatViewBuilderFactory am;
  long an = 0L;
  public Random ao;
  public boolean ap = false;
  ObjectAnimator aq;
  Handler ar = new VisitorsActivity.1(this);
  TabBarView.OnTabChangeListener as = new VisitorsActivity.2(this);
  int at = 0;
  VisitorsActivity.ListViewScrollListener au;
  long av = 0L;
  CardObserver aw = new VisitorsActivity.12(this);
  SparseArray<Pair<Point, Boolean>> ax = new SparseArray();
  NearbyCardObserver ay = new VisitorsActivity.14(this);
  GameCenterObserver az = new VisitorsActivity.15(this);
  TabBarView b;
  VoteHelper c;
  public ArrayList<CardProfile> d = new ArrayList();
  SwipListView e;
  VisitorsActivity.VisitorAdapter f;
  boolean g = false;
  View h;
  long i = -1L;
  int j;
  VisitorsActivity.VisitorAdapter k;
  public ArrayList<CardProfile> l = new ArrayList();
  boolean m = false;
  View n;
  long o = -1L;
  int p;
  LocalRedTouchManager q;
  LikeRankingListManager r;
  boolean s;
  boolean t;
  boolean u = false;
  ViewGroup v;
  RelativeLayout w;
  View x;
  ZanBannerView y;
  ImageView z;
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, TextView paramTextView)
  {
    paramImageView.setVisibility(8);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131168102));
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130852711);
        paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131168185));
        return;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130852711);
        paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131168185));
        return;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if ((paramVipBaseInfo != null) && (paramVipBaseInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130853452);
        paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131168185));
      }
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(getResources(), this.aG.a(paramInt, 200), false, false);
    if (this.aI == 0) {
      this.aI = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    paramInt = this.aI;
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
    if (this.ai.n(localAllInOne.uin))
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
    if (this.ac == 0) {
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
    int i1 = getIntent().getIntExtra("frome_where", 6);
    Intent localIntent = new Intent();
    localIntent.putExtra("AllInOne", localAllInOne);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("frome_where", i1);
    localIntent.addFlags(268435456);
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/nearby/people/profile", 1023);
    this.an = paramCardProfile.lEctID;
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
    setRightButton(2131916361, this);
    Object localObject1 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    this.aC = ((DisplayMetrics)localObject1).widthPixels;
    this.aa = ((ViewGroup)findViewById(2131435800));
    this.aa.getViewTreeObserver().addOnGlobalLayoutListener(new VisitorsActivity.6(this));
    this.e = ((SwipListView)findViewById(2131449957));
    this.e.setContentBackground(getResources().getDrawable(2130838958), false);
    this.aB = ((PullRefreshHeader)getLayoutInflater().inflate(2131625671, this.e, false));
    this.e.setOverScrollHeader(this.aB);
    this.e.setOverScrollListener(this);
    this.e.setSwipListListener(this);
    this.e.setDragEnable(true);
    this.e.setSelector(2131168376);
    this.e.setNeedCheckSpringback(true);
    this.ab = ((NearbyZanAnimLayout)findViewById(2131439177));
    this.ab.setVisibility(0);
    this.ab.setEnabled(false);
    if (this.s)
    {
      this.vg.setBackgroundResource(2131168542);
      localObject1 = getResources().getColorStateList(2131165594);
      this.leftView.setTextColor((ColorStateList)localObject1);
      this.leftView.setBackgroundResource(2130838989);
      this.rightViewText.setTextColor((ColorStateList)localObject1);
      this.rightViewText.setBackgroundDrawable(null);
      this.v = ((ViewGroup)findViewById(2131437549));
      this.v.setBackgroundResource(2131168542);
      this.u = this.r.f();
      this.R = ViewUtils.dpToPx(46.0F);
      this.aB.setArrowColor(1);
      this.S = getString(2131892079);
      this.centerView.setText("");
      this.X = ViewUtils.getScreenHeight();
      localObject1 = LayoutInflater.from(this).inflate(2131627505, null);
      this.x = ((View)localObject1).findViewById(2131445032);
      this.y = ((ZanBannerView)((View)localObject1).findViewById(2131450386));
      ((View)localObject1).findViewById(2131445074).setOnClickListener(this);
      this.C = ((TextView)((View)localObject1).findViewById(2131448555));
      this.D = ((TextView)((View)localObject1).findViewById(2131448316));
      this.E = ((TextView)((View)localObject1).findViewById(2131448712));
      this.F = ((View)localObject1).findViewById(2131436549);
      this.w = ((RelativeLayout)((View)localObject1).findViewById(2131445052));
      int i1 = Math.round(ViewUtils.getScreenWidth() * 0.29F);
      Object localObject2 = (RelativeLayout.LayoutParams)this.C.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = i1;
      this.C.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.E.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = i1;
      this.E.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.z = ((ImageView)((View)localObject1).findViewById(2131436525));
      this.B = ((TextView)((View)localObject1).findViewById(2131436527));
      this.A = ((ImageView)((View)localObject1).findViewById(2131436524));
      this.x.setOnTouchListener(new VisitorsActivity.7(this));
      this.G = ((ImageView)((View)localObject1).findViewById(2131436438));
      this.H = ((ImageView)((View)localObject1).findViewById(2131436439));
      this.I = ((ImageView)((View)localObject1).findViewById(2131436440));
      this.J = ((ImageView)((View)localObject1).findViewById(2131436441));
      this.K = ((View)localObject1).findViewById(2131444925);
      if ((this.u) && (VersionUtils.e())) {
        this.K.setVisibility(0);
      }
      this.L = ((View)localObject1).findViewById(2131436661);
      this.Q = (-ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
      this.P = (ViewUtils.getScreenWidth() / 2);
      this.e.addHeaderView((View)localObject1);
      localObject2 = new VisitorsActivity.8(this);
      this.V = new AlphaAnimation(0.0F, 1.0F);
      this.V.setDuration(300L);
      this.V.setInterpolator(this, 17432581);
      this.V.setAnimationListener((Animation.AnimationListener)localObject2);
      this.W = new AlphaAnimation(1.0F, 0.0F);
      this.W.setDuration(300L);
      this.W.setInterpolator(this, 17432581);
      this.W.setAnimationListener((Animation.AnimationListener)localObject2);
      this.au = new VisitorsActivity.ListViewScrollListener(this);
      this.e.setOnScrollListener(this.au);
      this.O = ((TabBarView)((View)localObject1).findViewById(2131446721));
      this.O.a(0, getString(2131918027));
      this.O.a(1, getString(2131890783));
      this.O.setSelectedTab(0, false);
      this.O.setOnTabChangeListener(this.as);
      e();
      localObject1 = this.r.b();
      a(true, ((LikeRankingInfo)localObject1).likeCountOfToday, ((LikeRankingInfo)localObject1).rankingNum, ((LikeRankingInfo)localObject1).totalLikeCount);
    }
    this.e.setAdapter(this.f);
    if (this.s)
    {
      findViewById(2131444764).setVisibility(8);
      this.b = ((TabBarView)findViewById(2131433428));
    }
    else
    {
      this.b = ((TabBarView)findViewById(2131444764));
    }
    this.b.a(0, getString(2131918027));
    this.b.a(1, getString(2131890783));
    this.b.setOnTabChangeListener(this.as);
    this.b.setSelectedTab(0, false);
    ThreadManager.postImmediately(new VisitorsActivity.9(this), null, true);
    localObject1 = this.ar;
    ((Handler)localObject1).sendMessage(((Handler)localObject1).obtainMessage(13, 1, 0));
  }
  
  private void h()
  {
    this.c = new VoteHelper(this, this.ar, this.app);
    this.f = new VisitorsActivity.VisitorAdapter(this, this, this.app, this, 0, this.s);
    this.k = new VisitorsActivity.VisitorAdapter(this, this, this.app, this, 1, this.s);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init visitors");
    }
    this.f.a(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init favorite");
    }
    this.k.a(this.l);
    this.f.e = getString(2131892098);
    this.k.e = getString(2131892085);
    startTitleProgress();
    this.al = getResources().getString(2131897188);
  }
  
  private long i()
  {
    return getActivity().getSharedPreferences("visitors_last_refresh_time", 0).getLong("visitors_last_refresh_time", 0L);
  }
  
  private long j()
  {
    return getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).getLong("favoritors_last_refresh_time", 0L);
  }
  
  private Bitmap k()
  {
    if (this.Z == null) {
      this.Z = com.tencent.mobileqq.utils.ImageUtil.n();
    }
    return this.Z;
  }
  
  int a(CardProfile paramCardProfile, String paramString)
  {
    boolean bool = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString);
    int i2 = paramCardProfile.bMutualFriends;
    int i1 = 10;
    if (i2 != 1)
    {
      if (i2 != 2)
      {
        if ((!bool) && (paramCardProfile.bCloseNeighborVote == 1)) {
          break label157;
        }
        if (paramCardProfile.bAvailableCnt <= 0L)
        {
          if (paramCardProfile.bTodayVotedCnt > 0L) {
            break label150;
          }
          i1 = -3;
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
          i1 = -2;
          break label157;
        }
      }
    }
    else {
      if (paramCardProfile.bAvailableCnt <= 0L) {
        break label141;
      }
    }
    i1 = 0;
    break label157;
    label141:
    if (paramCardProfile.bTodayVotedCnt > 0L) {
      label150:
      i1 = 2;
    } else {
      i1 = -1;
    }
    label157:
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, String.format("getVoteLevel visibility=%d uin=%s isFrd=%b mutual=%d ", new Object[] { Integer.valueOf(i1), paramString, Boolean.valueOf(bool), Byte.valueOf(paramCardProfile.bMutualFriends) }));
    }
    return i1;
  }
  
  CharSequence a(CardProfile paramCardProfile, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = this.al;
    int i1;
    if (paramCardProfile.type == 2) {
      i1 = 2131913740;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = HardCodeUtil.a(i1);
      break;
      if (paramCardProfile.bSex == 1) {
        i1 = 2131913741;
      } else {
        i1 = 2131913743;
      }
    }
    int i3 = 0;
    int i2 = 0;
    SpannableString localSpannableString = new SpannableString(String.format((String)localObject1, new Object[] { localObject2, Short.valueOf(paramCardProfile.bVoteCnt) }));
    if (paramCardProfile.dwLikeCustomId > 0L)
    {
      localObject1 = (PraiseManager)this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
      ((PraiseManager)localObject1).a(this);
      if (paramBoolean) {
        localObject1 = (PraiseInfo)((PraiseManager)localObject1).c.get(Integer.valueOf((int)paramCardProfile.dwLikeCustomId));
      } else {
        localObject1 = ((PraiseManager)localObject1).a((int)paramCardProfile.dwLikeCustomId, true, "from_profile_card");
      }
      localObject2 = localSpannableString;
      i1 = i3;
      if (localObject1 != null)
      {
        localObject2 = localSpannableString;
        i1 = i3;
        if (!TextUtils.isEmpty(((PraiseInfo)localObject1).c))
        {
          localObject2 = SpannableString.valueOf(TextUtils.concat(new CharSequence[] { ((PraiseInfo)localObject1).c, localSpannableString }));
          ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(((PraiseInfo)localObject1).d), 0, ((PraiseInfo)localObject1).c.length(), 33);
          i1 = i2;
          if (((PraiseInfo)localObject1).f != null)
          {
            a(paramTextView, ((PraiseInfo)localObject1).f, ((PraiseInfo)localObject1).d);
            i1 = 1;
          }
          paramTextView.setOnClickListener(new VisitorsActivity.10(this, paramCardProfile, (PraiseInfo)localObject1, paramInt));
          paramTextView.setClickable(true);
        }
      }
    }
    else
    {
      paramTextView.setOnClickListener(null);
      i1 = i3;
      localObject2 = localSpannableString;
    }
    if (i1 == 0) {
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
    return localObject2;
  }
  
  void a()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      a(1, getString(2131892104));
      return;
    }
    b(false);
    VisitorsActivity.VisitorAdapter localVisitorAdapter = this.f;
    localVisitorAdapter.c = true;
    localVisitorAdapter.notifyDataSetChanged();
  }
  
  void a(int paramInt)
  {
    if (this.ac == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "[switchToTab] same tab return");
      }
      return;
    }
    Object localObject;
    if ((this.s) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[switchToTab]tab=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", top1=");
      ((StringBuilder)localObject).append(this.au.a);
      ((StringBuilder)localObject).append(", visible1=");
      ((StringBuilder)localObject).append(this.au.b);
      QLog.d("VisitorsActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.ac = paramInt;
    if (paramInt == 0)
    {
      this.e.setAdapter(this.f);
      this.ab.clearAnimation();
      FloatViewBuilder.a(this.ab);
      this.ar.removeMessages(8);
      this.ar.sendEmptyMessage(8);
    }
    else if (paramInt == 1)
    {
      ReportController.a(this.app, "CliOper", "", "", "0X8004448", "0X8004448", 0, 0, "", "", "", "");
      this.e.setAdapter(this.k);
      this.ab.clearAnimation();
      FloatViewBuilder.a(this.ab);
      Collections.sort(this.l, new CardProfile.CardProfileComparator());
      this.ar.removeMessages(7);
      this.ar.sendEmptyMessage(7);
      if (VersionUtils.m())
      {
        localObject = getCurrentFocus();
        if (localObject != null) {
          ((View)localObject).clearFocus();
        }
      }
      if (this.aj)
      {
        this.aj = false;
        startTitleProgress();
        if (!NetworkUtil.isNetSupport(this))
        {
          this.ar.sendEmptyMessageDelayed(2, 1000L);
          return;
        }
        c(true);
      }
    }
    paramInt = this.au.a;
    this.e.setSelectionFromTop(0, -paramInt);
    if (this.s)
    {
      paramInt = this.b.getSelectedTabIndex();
      int i1 = this.ac;
      if (paramInt != i1) {
        this.b.setSelectedTab(i1, false);
      }
      paramInt = this.O.getSelectedTabIndex();
      i1 = this.ac;
      if (paramInt != i1) {
        this.O.setSelectedTab(i1, false);
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.s) {
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
    Object localObject = this.ar.obtainMessage(10);
    ((Message)localObject).arg1 = paramInt1;
    ((Message)localObject).arg2 = paramInt2;
    Bundle localBundle = new Bundle();
    localBundle.putInt("totalVoteCount", paramInt3);
    ((Message)localObject).setData(localBundle);
    if (this.U)
    {
      this.ar.sendMessageDelayed((Message)localObject, 200L);
      return;
    }
    this.ar.sendMessage((Message)localObject);
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {
      return;
    }
    paramString = (Pair)this.ax.get(paramInt1);
    if (paramString != null)
    {
      a(paramPraiseInfo, ((Point)paramString.first).x, ((Point)paramString.first).y, ((Boolean)paramString.second).booleanValue(), false);
      this.ax.remove(paramInt1);
    }
    paramString = this.e;
    paramInt2 = this.ac;
    if (paramInt2 == 0) {
      paramPraiseInfo = this.f;
    } else if (paramInt2 == 1) {
      paramPraiseInfo = this.k;
    } else {
      paramPraiseInfo = null;
    }
    int i1 = paramString.getFirstVisiblePosition();
    if (paramPraiseInfo == null) {
      return;
    }
    paramInt2 = 0;
    while (paramInt2 < paramPraiseInfo.b.size())
    {
      CardProfile localCardProfile = paramPraiseInfo.a(paramInt2);
      if ((localCardProfile == null) || (localCardProfile.dwLikeCustomId != paramInt1))
      {
        paramInt2 += 1;
      }
      else
      {
        paramPraiseInfo = paramString.getChildAt(paramInt2 - i1 + paramString.getHeaderViewsCount());
        if (paramPraiseInfo != null)
        {
          paramPraiseInfo = (TextView)paramPraiseInfo.findViewById(2131448874);
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
      QQToast.makeText(this, paramInt, paramString, 0).show(getTitleBarHeight());
    }
  }
  
  public void a(long paramLong)
  {
    SwipListView localSwipListView = this.e;
    VisitorsActivity.VisitorAdapter localVisitorAdapter;
    if (this.ac == 1) {
      localVisitorAdapter = this.k;
    } else {
      localVisitorAdapter = this.f;
    }
    int i2 = localSwipListView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = localSwipListView.getChildAt(i1).getTag();
      if ((localObject != null) && ((localObject instanceof VisitorsActivity.CustomViewHolder)))
      {
        localObject = (VisitorsActivity.CustomViewHolder)localObject;
        if (((((VisitorsActivity.CustomViewHolder)localObject).o instanceof CardProfile)) && (((CardProfile)((VisitorsActivity.CustomViewHolder)localObject).o).lEctID == paramLong))
        {
          VisitorsActivity.VisitorAdapter.a(localVisitorAdapter, ((VisitorsActivity.CustomViewHolder)localObject).o, (VisitorsActivity.CustomViewHolder)localObject);
          return;
        }
      }
      i1 += 1;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    int i1 = paramView.getScrollX();
    if ((paramInt >= 0) && (this.f != null) && (this.aA == paramInt)) {
      paramView.scrollTo(0, 0);
    } else if (i1 != 0) {
      paramView.scrollTo(0, 0);
    }
    paramView.setTag(-3, Integer.valueOf(getResources().getDimensionPixelSize(2131299284)));
  }
  
  public void a(ImageView paramImageView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    PraiseManager localPraiseManager = (PraiseManager)this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationInWindow(arrayOfInt);
    float f1 = arrayOfInt[0] + paramImageView.getPaddingLeft();
    float f2 = arrayOfInt[1] - this.at + paramImageView.getPaddingTop();
    if ((paramBoolean2) && (localPraiseManager.c.get(Integer.valueOf(paramInt)) == null))
    {
      localPraiseManager.a(this);
      this.ax.put(paramInt, new Pair(new Point((int)f1, (int)f2), Boolean.valueOf(paramBoolean1)));
    }
    a(localPraiseManager.a(paramInt, paramBoolean2, "from_profile_card"), f1, f2, paramBoolean1, paramBoolean2);
  }
  
  public void a(ImageView paramImageView, boolean paramBoolean)
  {
    int i1 = PraiseManager.a(this.app);
    if (i1 > 0)
    {
      a(paramImageView, i1, paramBoolean, true);
      return;
    }
    paramImageView.setVisibility(0);
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationInWindow(arrayOfInt);
    if (!paramBoolean) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    if (i1 == 2)
    {
      localNearbyZanAnimLayout = this.ab;
      localNearbyZanAnimLayout.a(this.am.a(i1, localNearbyZanAnimLayout.d).a(), this.app, this.am.a(i1, this.ab.d), arrayOfInt[0] + paramImageView.getPaddingLeft() - DisplayUtil.a(this, 20.0F), arrayOfInt[1] - this.at + paramImageView.getPaddingTop() - DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 75.0F), DisplayUtil.a(this, 65.0F));
      return;
    }
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.ab;
    localNearbyZanAnimLayout.a(this.am.a(i1, localNearbyZanAnimLayout.d).a(), arrayOfInt[0] + paramImageView.getPaddingLeft(), arrayOfInt[1] - this.at + paramImageView.getPaddingTop());
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
      if ((!paramBoolean1) && (paramPraiseInfo.j != null))
      {
        this.ab.a(paramPraiseInfo, paramPraiseInfo.j, this.app, this.am.a(2, this.ab.d), paramFloat1 - DisplayUtil.a(this, 20.0F), paramFloat2 - DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 75.0F), DisplayUtil.a(this, 65.0F));
        return;
      }
      this.ab.a(paramPraiseInfo, paramPraiseInfo.h, paramFloat1, paramFloat2);
      return;
    }
    if (!paramBoolean2)
    {
      int i1 = 1;
      if (!paramBoolean1) {
        i1 = 2;
      }
      if (i1 == 2)
      {
        paramPraiseInfo = this.ab;
        paramPraiseInfo.a(this.am.a(i1, paramPraiseInfo.d).a(), this.app, this.am.a(i1, this.ab.d), paramFloat1 - DisplayUtil.a(this, 20.0F), paramFloat2 - DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 75.0F), DisplayUtil.a(this, 65.0F));
        return;
      }
      paramPraiseInfo = this.ab;
      paramPraiseInfo.a(this.am.a(i1, paramPraiseInfo.d).a(), paramFloat1, paramFloat2);
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.ap)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "doPraiseAnim, mIsPraiseAnimating=true");
      }
      return;
    }
    paramPraiseInfo = this.ar.obtainMessage(11, paramInt2, paramInt3, new Object[] { Integer.valueOf(paramInt1), paramPraiseInfo });
    this.ar.sendMessage(paramPraiseInfo);
    this.ap = true;
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
      int i1 = this.ac;
      if (i1 == 0)
      {
        paramObject = (VisitorsActivity.CustomViewHolder)paramObject;
        paramObject = this.f.b(paramObject.m);
        this.f.notifyDataSetChanged();
        if (paramObject != null) {
          this.c.a(paramObject.lEctID, 1);
        }
        ReportController.b(this.app, "dc00898", "", "", "0X8009702", "0X8009702", 0, 0, "", "", "", "");
        return;
      }
      if (i1 == 1)
      {
        paramObject = (VisitorsActivity.CustomViewHolder)paramObject;
        paramObject = this.k.b(paramObject.m);
        this.k.notifyDataSetChanged();
        if (paramObject != null) {
          this.c.a(paramObject.lEctID, 0);
        }
        ReportController.b(this.app, "dc00898", "", "", "0X8009703", "0X8009703", 0, 0, "", "", "", "");
      }
    }
  }
  
  void a(String paramString, int paramInt, ImageView paramImageView)
  {
    if (this.ai.n(paramString))
    {
      localBitmap2 = this.Y.getBitmapFromCache(1, paramString);
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        this.Y.requestDecodeFace(paramString, 1, false);
        localBitmap1 = k();
      }
      paramImageView.setImageBitmap(localBitmap1);
      return;
    }
    Bitmap localBitmap2 = this.Y.getBitmapFromCache(32, paramString, 200);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.Y.requestDecodeStrangeFace(paramString, 200, true, false);
      localBitmap1 = k();
    }
    paramImageView.setImageBitmap(localBitmap1);
  }
  
  public void a(ArrayList<CardProfile> paramArrayList, long paramLong)
  {
    this.d.clear();
    this.d.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet onVisitorListOk");
    }
    this.f.a(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onVisitorListOk");
    }
    this.f.c = false;
    this.g = false;
    if (paramLong == 0L) {
      d(true);
    }
    this.f.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (paramBoolean)
    {
      localView = this.x;
      if (localView != null)
      {
        localView.setVisibility(0);
        if (!TextUtils.isEmpty(this.centerView.getText().toString()))
        {
          this.centerView.setText(2131892079);
          return;
        }
        this.centerView.setText("");
      }
    }
    else
    {
      localView = this.x;
      if (localView != null)
      {
        localView.setVisibility(8);
        if (this.centerView != null) {
          this.centerView.setText(2131892079);
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
      localObject1 = this.C;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    if (paramInt1 == 0)
    {
      this.E.setText(HardCodeUtil.a(2131913744));
      this.E.setTextSize(1, 18.0F);
      localObject1 = this.E;
      ((TextView)localObject1).setTypeface(((TextView)localObject1).getTypeface(), 1);
      localObject1 = (RelativeLayout.LayoutParams)this.E.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ((RelativeLayout.LayoutParams)localObject1).topMargin, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ViewUtils.dpToPx(7.0F));
    }
    else if (paramInt2 > 0)
    {
      this.E.setText(String.valueOf(paramInt2));
      this.E.setTextSize(1, 30.0F);
      this.E.setTypeface(Typeface.MONOSPACE);
      localObject1 = this.E;
      ((TextView)localObject1).setTypeface(((TextView)localObject1).getTypeface(), 0);
      localObject1 = (RelativeLayout.LayoutParams)this.E.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ((RelativeLayout.LayoutParams)localObject1).topMargin, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ViewUtils.dpToPx(5.0F));
    }
    if (paramBoolean)
    {
      if (paramInt3 > 0)
      {
        localObject1 = this.D;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        if (paramInt3 > 9999) {
          this.D.setTextSize(36.0F);
        } else {
          this.D.setTextSize(44.0F);
        }
      }
    }
    else
    {
      localObject1 = this.r.b();
      int i1;
      if ((paramInt3 >= 0) && (paramInt3 > ((LikeRankingInfo)localObject1).totalLikeCount))
      {
        if (((LikeRankingInfo)localObject1).totalLikeCount > 0) {
          i1 = ((LikeRankingInfo)localObject1).totalLikeCount;
        } else {
          i1 = 0;
        }
        localObject1 = new ValueAnimation(Integer.valueOf(i1), Integer.valueOf(paramInt3), new VisitorsActivity.16(this));
        ((ValueAnimation)localObject1).setStartOffset(200L);
        ((ValueAnimation)localObject1).setDuration(1200L);
        this.D.startAnimation((Animation)localObject1);
      }
      else
      {
        if (((LikeRankingInfo)localObject1).totalLikeCount > 0) {
          i1 = ((LikeRankingInfo)localObject1).totalLikeCount;
        } else {
          i1 = 0;
        }
        localObject1 = this.D;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append("");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
    }
    this.r.a(paramInt1, paramInt2, paramInt3);
    if ((!paramBoolean) && (!this.u))
    {
      this.K.setVisibility(0);
      return;
    }
    if ((paramBoolean) && (this.u)) {
      return;
    }
    try
    {
      this.G.setImageResource(2130846978);
      this.H.setImageResource(2130846979);
      this.I.setImageResource(2130846980);
      this.J.setImageResource(2130849063);
      paramInt1 = ViewUtils.dpToPx(1.0F);
      float f1;
      float f2;
      if (paramBoolean)
      {
        paramInt2 = paramInt1 * -299;
        paramInt3 = this.P;
        f1 = paramInt2 + paramInt3;
        f2 = paramInt2 + paramInt3;
        paramInt2 = paramInt1 * 42;
        paramInt3 = this.Q;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt2 + paramInt3, 0, paramInt2 + paramInt3);
        ((TranslateAnimation)localObject1).setDuration(0L);
        ((TranslateAnimation)localObject1).setStartOffset(0L);
      }
      else
      {
        paramInt2 = this.P;
        f1 = paramInt1 * -493 + paramInt2;
        f2 = paramInt1 * -299 + paramInt2;
        paramInt2 = this.Q;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt1 * 174 + paramInt2, 0, paramInt1 * 42 + paramInt2);
        ((TranslateAnimation)localObject1).setDuration(900L);
        ((TranslateAnimation)localObject1).setStartOffset(500L);
      }
      ((TranslateAnimation)localObject1).setFillEnabled(true);
      ((TranslateAnimation)localObject1).setFillAfter(true);
      ((TranslateAnimation)localObject1).setInterpolator(new OvershootInterpolator(1.0F));
      ((TranslateAnimation)localObject1).setAnimationListener(new VisitorsActivity.17(this));
      this.G.startAnimation((Animation)localObject1);
      if (paramBoolean)
      {
        paramInt2 = paramInt1 * -217;
        paramInt3 = this.P;
        f1 = paramInt2 + paramInt3;
        f2 = paramInt2 + paramInt3;
        paramInt2 = paramInt1 * 47;
        paramInt3 = this.Q;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt2 + paramInt3, 0, paramInt2 + paramInt3);
        ((TranslateAnimation)localObject1).setDuration(0L);
        ((TranslateAnimation)localObject1).setStartOffset(0L);
      }
      else
      {
        paramInt2 = this.P;
        f1 = paramInt1 * -520 + paramInt2;
        f2 = paramInt1 * -217 + paramInt2;
        paramInt2 = this.Q;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt1 * 239 + paramInt2, 0, paramInt1 * 47 + paramInt2);
        ((TranslateAnimation)localObject1).setDuration(900L);
        ((TranslateAnimation)localObject1).setStartOffset(350L);
      }
      ((TranslateAnimation)localObject1).setFillEnabled(true);
      ((TranslateAnimation)localObject1).setFillAfter(true);
      ((TranslateAnimation)localObject1).setInterpolator(new OvershootInterpolator(1.0F));
      ((TranslateAnimation)localObject1).setAnimationListener(new VisitorsActivity.18(this));
      this.H.startAnimation((Animation)localObject1);
      if (paramBoolean)
      {
        paramInt2 = this.P;
        f1 = paramInt1 * -2 + paramInt2;
        f2 = paramInt1 * -15 + paramInt2;
        paramInt2 = paramInt1 * 50;
        paramInt3 = this.Q;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt2 + paramInt3, 0, paramInt2 + paramInt3);
        ((TranslateAnimation)localObject1).setDuration(0L);
        ((TranslateAnimation)localObject1).setStartOffset(0L);
      }
      else
      {
        paramInt2 = this.P;
        f1 = paramInt1 * -160 + paramInt2;
        f2 = paramInt1 * -15 + paramInt2;
        paramInt2 = this.Q;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt1 * 138 + paramInt2, 0, paramInt1 * 50 + paramInt2);
        ((TranslateAnimation)localObject1).setDuration(900L);
        ((TranslateAnimation)localObject1).setStartOffset(200L);
      }
      ((TranslateAnimation)localObject1).setFillEnabled(true);
      ((TranslateAnimation)localObject1).setFillAfter(true);
      ((TranslateAnimation)localObject1).setInterpolator(new OvershootInterpolator(1.0F));
      ((TranslateAnimation)localObject1).setAnimationListener(new VisitorsActivity.19(this));
      this.I.startAnimation((Animation)localObject1);
      if (paramBoolean)
      {
        paramInt2 = paramInt1 * 74;
        paramInt3 = this.P;
        f1 = paramInt2 + paramInt3;
        f2 = paramInt2 + paramInt3;
        paramInt1 *= 34;
        paramInt2 = this.Q;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt1 + paramInt2, 0, paramInt1 + paramInt2);
        ((TranslateAnimation)localObject1).setDuration(0L);
        ((TranslateAnimation)localObject1).setStartOffset(0L);
      }
      else
      {
        paramInt2 = this.P;
        f1 = paramInt1 * -180 + paramInt2;
        f2 = paramInt1 * 74 + paramInt2;
        paramInt2 = this.Q;
        localObject1 = new TranslateAnimation(0, f1, 0, f2, 0, paramInt1 * 148 + paramInt2, 0, paramInt1 * 34 + paramInt2);
        ((TranslateAnimation)localObject1).setDuration(900L);
        ((TranslateAnimation)localObject1).setStartOffset(300L);
      }
      ((TranslateAnimation)localObject1).setFillEnabled(true);
      ((TranslateAnimation)localObject1).setFillAfter(true);
      ((TranslateAnimation)localObject1).setInterpolator(new OvershootInterpolator(1.0F));
      ((TranslateAnimation)localObject1).setAnimationListener(new VisitorsActivity.20(this));
      this.J.startAnimation((Animation)localObject1);
      if (!paramBoolean)
      {
        this.u = false;
        this.r.a(NetConnInfoCenter.getServerTimeMillis());
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
        if (this.N == null) {
          this.N = new VisitorsActivity.21(this, (ScaleAnimation)localObject2, localAlphaAnimation1, localAlphaAnimation2, (AnimationSet)localObject1);
        }
        ((AnimationSet)localObject1).setAnimationListener(new VisitorsActivity.22(this));
        this.M = 5;
        this.L.startAnimation((Animation)localObject1);
        this.K.setVisibility(0);
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
  
  void b()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      a(1, getString(2131892104));
      return;
    }
    c(false);
    VisitorsActivity.VisitorAdapter localVisitorAdapter = this.k;
    localVisitorAdapter.c = true;
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
      ZanBannerView localZanBannerView = this.y;
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
    int i1 = this.ac;
    if (i1 == 0)
    {
      if ((paramObject instanceof VisitorsActivity.CustomViewHolder))
      {
        paramObject = (VisitorsActivity.CustomViewHolder)paramObject;
        ReportController.a(this.app, "CliOper", "", "", "0X800444A", "0X800444A", 0, 0, "", "", "", "");
        a((CardProfile)paramObject.o);
        return;
      }
      if ((paramObject instanceof VisitorsActivity.MoreViewHolder)) {
        a();
      }
    }
    else if (i1 == 1)
    {
      if ((paramObject instanceof VisitorsActivity.CustomViewHolder))
      {
        paramObject = (VisitorsActivity.CustomViewHolder)paramObject;
        ReportController.a(this.app, "CliOper", "", "", "0X8004447", "0X8004447", 0, 0, "", "", "", "");
        a((CardProfile)paramObject.o);
        return;
      }
      if ((paramObject instanceof VisitorsActivity.MoreViewHolder)) {
        b();
      }
    }
  }
  
  public void b(ArrayList<CardProfile> paramArrayList, long paramLong)
  {
    this.l.clear();
    this.l.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet onFavoriteListOk");
    }
    this.k.a(this.l);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onFavoriteListOk");
    }
    this.k.c = false;
    this.m = false;
    if (paramLong == 0L) {
      e(true);
    }
    this.k.notifyDataSetChanged();
  }
  
  boolean b(boolean paramBoolean)
  {
    String str = this.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      this.g = true;
      this.i = -1L;
      this.ah.b(str, this.a, 0L, 30);
      return true;
    }
    long l1 = this.i;
    if (l1 > -1L) {
      this.ah.b(str, this.a, l1, 30);
    }
    return true;
  }
  
  void c()
  {
    this.g = false;
    QQToast.makeText(this, 1, 2131916799, 0).show(getTitleBarHeight());
    d(false);
    if (this.f.c)
    {
      VisitorsActivity.VisitorAdapter localVisitorAdapter = this.f;
      localVisitorAdapter.c = false;
      localVisitorAdapter.notifyDataSetChanged();
    }
    if (this.s) {
      this.K.setVisibility(0);
    }
  }
  
  boolean c(boolean paramBoolean)
  {
    String str = this.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      this.m = true;
      this.o = -1L;
      this.ah.a(str, this.a, 0L, 30);
      return true;
    }
    long l1 = this.o;
    if (l1 > -1L) {
      this.ah.a(str, this.a, l1, 30);
    }
    return true;
  }
  
  void d()
  {
    this.m = false;
    QQToast.makeText(this, 1, 2131916799, 0).show(getTitleBarHeight());
    e(false);
    if (this.k.c)
    {
      VisitorsActivity.VisitorAdapter localVisitorAdapter = this.k;
      localVisitorAdapter.c = false;
      localVisitorAdapter.notifyDataSetChanged();
    }
  }
  
  void d(boolean paramBoolean)
  {
    b(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.ar.sendEmptyMessageDelayed(1, 800L);
        this.aB.a(0);
        return;
      }
      a(1, getString(2131916799));
      this.e.springBackOverScrollHeaderView();
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
      this.ak.a(0L, 0L, 511);
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
    this.ah = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.ak = ((INearbyCardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER));
    this.ai = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    addObserver(this.aw);
    addObserver(this.aF);
    paramBundle = this.app.getCurrentAccountUin();
    Object localObject = getIntent();
    this.a = String.valueOf(((Intent)localObject).getLongExtra("toUin", 0L));
    this.r = ((LikeRankingListManager)this.app.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER));
    this.s = ((Intent)localObject).getBooleanExtra("extra_show_rank", false);
    this.p = ((Intent)localObject).getIntExtra("extra_from", -1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mShowRank=");
      ((StringBuilder)localObject).append(this.s);
      QLog.d("VisitorsActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.am = new FloatViewBuilderFactory(this);
    if (this.s)
    {
      this.q = ((LocalRedTouchManager)this.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER));
      this.app.registObserver(this.az);
      if (this.p == 1) {
        ThreadManager.post(new VisitorsActivity.3(this), 5, null, false);
      }
    }
    localObject = this.a;
    if (localObject != null) {
      paramBundle.equals(localObject);
    }
    this.i = getIntent().getLongExtra("nextMidVoter", -1L);
    setContentView(2131629654);
    h();
    g();
    this.app.addObserver(this.ay);
    this.Y = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.Y.setDecodeTaskCompletionListener(this);
    this.aG = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.aG.a(this.aH);
    this.ak.a(0L, 0L, 511);
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.aq;
    if (localObject != null)
    {
      ((ObjectAnimator)localObject).removeAllListeners();
      this.aq.cancel();
    }
    localObject = this.Y;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    super.doOnDestroy();
    this.ar.removeCallbacksAndMessages(null);
    removeObserver(this.aw);
    this.aG.b(this.aH);
    removeObserver(this.aF);
    this.app.removeObserver(this.ay);
    if (this.s) {
      this.app.unRegistObserver(this.az);
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
    this.t = this.r.e();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume mPartakeRank=");
      ((StringBuilder)localObject).append(this.t);
      QLog.d("VisitorsActivity", 2, ((StringBuilder)localObject).toString());
    }
    a(this.t);
    Object localObject = this.ah;
    if (localObject != null) {
      ((CardHandler)localObject).e();
    }
    if ((this.s) && (this.mSystemBarComp != null))
    {
      int i1 = getResources().getColor(2131165591);
      this.mSystemBarComp.setStatusColor(i1);
      this.mSystemBarComp.setStatusBarColor(i1);
    }
  }
  
  protected void doOnStop()
  {
    if (this.ar.hasMessages(6))
    {
      this.ar.removeMessages(6);
      this.c.b();
    }
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.ab;
    if (localNearbyZanAnimLayout != null) {
      localNearbyZanAnimLayout.clearAnimation();
    }
    super.doOnStop();
  }
  
  void e()
  {
    RedTouchItem localRedTouchItem = this.q.a(100601);
    if (this.q.a(localRedTouchItem, false))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateRedPoint level:");
        localStringBuilder.append(localRedTouchItem.passThroughLevel);
        QLog.d("VisitorsActivity", 2, localStringBuilder.toString());
      }
      this.F.setVisibility(0);
    }
  }
  
  void e(boolean paramBoolean)
  {
    c(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.ar.sendEmptyMessageDelayed(4, 800L);
        this.aB.a(0);
        return;
      }
      a(1, getString(2131916799));
      this.e.springBackOverScrollHeaderView();
    }
  }
  
  public void f()
  {
    try
    {
      this.k.a(this.l);
      this.k.notifyDataSetChanged();
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
    Object localObject = this.f;
    if ((localObject != null) && (((VisitorsActivity.VisitorAdapter)localObject).d > 0)) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004446", "0X8004446", 0, 0, String.valueOf(this.f.d), "", "", "");
    }
    localObject = this.k;
    if ((localObject != null) && (((VisitorsActivity.VisitorAdapter)localObject).d > 0)) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004449", "0X8004449", 0, 0, String.valueOf(this.k.d), "", "", "");
    }
    ReportController.b(this.app, "dc00898", "", "", "0X8007612", "0X8007612", 0, 0, "", "", "", "");
    if (this.p == 2)
    {
      localObject = this.a;
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.app.getCurrentAccountUin())))
      {
        localObject = new AllInOne(this.a, 0);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("single_top", true);
        ProfileActivity.a(getActivity(), (AllInOne)localObject, localBundle);
        overridePendingTransition(2130772005, 2130772006);
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
      if (paramView.getId() == 2131436660)
      {
        localObject1 = paramView.getTag();
        if ((localObject1 != null) && ((localObject1 instanceof CardProfile)))
        {
          localObject1 = (CardProfile)localObject1;
          if (this.c.a((CardProfile)localObject1, (ImageView)paramView))
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
        int i1 = paramView.getId();
        if (i1 != 2131445032)
        {
          if (i1 == 2131445074)
          {
            localObject2 = this.y.getCurrentClickUrl();
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = IndividuationUrlHelper.a(this, "praise", "");
            }
            localObject2 = new Intent(this, QQBrowserActivity.class);
            VasWebviewUtil.a(this.app.getCurrentAccountUin(), "thumbup", "banner_click", "", 1, 0, 0, "", this.y.getCurrentReportName(), "");
            VasWebviewUtil.b(this, (String)localObject1, 536870912L, (Intent)localObject2, false, -1);
            ReportController.b(this.app, "CliOper", "", "", "like_mall", "like_enter", 0, 0, "", "", "", "");
          }
        }
        else
        {
          ReportController.b(this.app, "dc00898", "", "", "0X8007611", "0X8007611", 0, 0, "", "", "", "");
          LikeRankingUtil.a(this, QFlutterDPC.a().d());
          this.F.setVisibility(8);
          this.L.clearAnimation();
          this.M = 0;
          this.ar.removeCallbacks(this.N);
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
    this.centerView.setText(2131917978);
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
    long l1 = SystemClock.uptimeMillis() - this.av;
    this.ar.removeMessages(3);
    if ((paramInt1 != 0) && (l1 < 800L))
    {
      this.ar.sendEmptyMessageDelayed(3, 800L - l1);
      return;
    }
    this.av = SystemClock.uptimeMillis();
    if (this.ac == 0)
    {
      this.f.notifyDataSetChanged();
      return;
    }
    this.k.notifyDataSetChanged();
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = this.aB;
    long l1;
    if (this.ac == 0) {
      l1 = i();
    } else {
      l1 = j();
    }
    paramView.c(l1);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = this.aB;
    long l1;
    if (this.ac == 0) {
      l1 = i();
    } else {
      l1 = j();
    }
    paramView.b(l1);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Visitor", 2, "onViewCompleteVisableAndReleased");
    }
    if (!this.af)
    {
      if (this.ac == 0) {
        this.ar.sendEmptyMessage(1);
      } else {
        this.ar.sendEmptyMessage(4);
      }
      a(0, HardCodeUtil.a(2131913745));
      return true;
    }
    paramView = this.aB;
    long l1;
    if (this.ac == 0) {
      l1 = i();
    } else {
      l1 = j();
    }
    paramView.a(l1);
    if (!stopTitleProgress())
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        this.ar.sendEmptyMessageDelayed(2, 1000L);
        return true;
      }
      if (this.ac == 0)
      {
        b(true);
        return true;
      }
      c(true);
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void updateCurShowRightView(View paramView)
  {
    int i2 = -1;
    int i1 = i2;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i1 = i2;
      if ((paramView instanceof Integer)) {
        i1 = ((Integer)paramView).intValue();
      }
    }
    this.aA = i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity
 * JD-Core Version:    0.7.0.1
 */