package com.tencent.mobileqq.activity;

import Override;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import agah;
import agai;
import agaj;
import agak;
import agal;
import agam;
import agan;
import agao;
import agap;
import agaq;
import agar;
import agas;
import agat;
import agau;
import agav;
import agax;
import agay;
import agaz;
import agba;
import agbb;
import agbc;
import agbd;
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
import anum;
import anuw;
import anyw;
import anzj;
import aobc;
import aogx;
import aoof;
import aoog;
import arwi;
import avsx;
import avsy;
import avsz;
import axxj;
import axxn;
import aysq;
import ayxl;
import azzw;
import azzy;
import azzz;
import bacz;
import badb;
import bbst;
import bbvd;
import bdll;
import bhgr;
import bhmq;
import bhnv;
import bhtd;
import bhtq;
import bhyk;
import biax;
import bjdm;
import bjdq;
import blnt;
import blpr;
import com.nineoldandroids.animation.ObjectAnimator;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.vas.ZanBannerView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
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
import nnw;

public class VisitorsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aoog, azzz, badb, blnt, blpr
{
  public int a;
  public long a;
  agbb jdField_a_of_type_Agbb;
  public agbd a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Handler a;
  SparseArray<Pair<Point, Boolean>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public View a;
  public ViewGroup a;
  public AlphaAnimation a;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public anum a;
  anuw jdField_a_of_type_Anuw = new agak(this);
  protected anyw a;
  public aobc a;
  private aogx jdField_a_of_type_Aogx = new agav(this);
  aoof jdField_a_of_type_Aoof;
  avsz jdField_a_of_type_Avsz;
  public axxj a;
  axxn jdField_a_of_type_Axxn = new agal(this);
  aysq jdField_a_of_type_Aysq;
  ayxl jdField_a_of_type_Ayxl = new agam(this);
  public bacz a;
  private bbst jdField_a_of_type_Bbst = new agaj(this);
  private bbvd jdField_a_of_type_Bbvd;
  bjdq jdField_a_of_type_Bjdq = new agar(this);
  ObjectAnimator jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator;
  public NearbyZanAnimLayout a;
  ZanBannerView jdField_a_of_type_ComTencentMobileqqVasZanBannerView;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public TabBarView a;
  public SwipListView a;
  public Runnable a;
  protected String a;
  public ArrayList<CardProfile> a;
  public HashMap<String, ImageView> a;
  public Random a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  public boolean a;
  int jdField_b_of_type_Int;
  public long b;
  public agbd b;
  public View b;
  public ViewGroup b;
  public AlphaAnimation b;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TabBarView jdField_b_of_type_ComTencentMobileqqWidgetTabBarView;
  public String b;
  public ArrayList<CardProfile> b;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean b;
  public int c;
  long jdField_c_of_type_Long = 0L;
  public View c;
  public ImageView c;
  public TextView c;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  long jdField_d_of_type_Long = 0L;
  public View d;
  public ImageView d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  int jdField_e_of_type_Int;
  public long e;
  View jdField_e_of_type_AndroidViewView;
  public ImageView e;
  boolean jdField_e_of_type_Boolean = false;
  public int f;
  public View f;
  public ImageView f;
  public boolean f;
  public int g;
  boolean g;
  public int h;
  public volatile boolean h;
  public int i;
  boolean i;
  public int j;
  public boolean j;
  private int k;
  private int l;
  
  public VisitorsActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 5;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new agah(this);
    this.jdField_i_of_type_Int = 0;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_j_of_type_Int = -1;
  }
  
  private long a()
  {
    return getActivity().getSharedPreferences("visitors_last_refresh_time", 0).getLong("visitors_last_refresh_time", 0L);
  }
  
  private Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.c();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, TextView paramTextView)
  {
    paramImageView.setVisibility(8);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167057));
    VipOpenInfo localVipOpenInfo;
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localVipOpenInfo == null) || (!localVipOpenInfo.bOpen)) {
        break label86;
      }
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130850486);
      paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167131));
    }
    label86:
    do
    {
      return;
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130850486);
        paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167131));
        return;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    } while ((paramVipBaseInfo == null) || (!paramVipBaseInfo.bOpen));
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130850782);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131167131));
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    bjdm localbjdm = new bjdm(getResources(), this.jdField_a_of_type_Bbvd.a(paramInt, 200), false, false);
    if (this.l == 0) {
      this.l = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localbjdm.setBounds(0, 0, this.l, this.l);
    paramTextView.setCompoundDrawables(localbjdm, null, null, null);
  }
  
  private void a(CardProfile paramCardProfile)
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(String.valueOf(paramCardProfile.lEctID), 41);
    localAllInOne.jdField_h_of_type_JavaLangString = paramCardProfile.strNick;
    localAllInOne.jdField_b_of_type_Int = paramCardProfile.bAage;
    localAllInOne.jdField_a_of_type_Byte = paramCardProfile.bSex;
    localAllInOne.jdField_a_of_type_Short = paramCardProfile.wFace;
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, String.format("openProfileCard nickname=%s likeSource=%s", new Object[] { paramCardProfile.strNick, Long.valueOf(paramCardProfile.uSource) }));
    }
    if (this.jdField_a_of_type_Anyw.b(localAllInOne.jdField_a_of_type_JavaLangString))
    {
      localAllInOne.jdField_a_of_type_Int = 1;
      localAllInOne.jdField_a_of_type_Long = 1L;
      ProfileActivity.a(this, localAllInOne, 1023);
      return;
    }
    if (paramCardProfile.uSource == 53L)
    {
      localAllInOne.jdField_a_of_type_Int = 96;
      ProfileActivity.a(this, localAllInOne, 1023);
      return;
    }
    if (this.jdField_h_of_type_Int == 0)
    {
      localAllInOne.jdField_h_of_type_Int = 16;
      if ((paramCardProfile.uSource > 0L) && (paramCardProfile.uSource <= 48L)) {
        break label296;
      }
    }
    label296:
    for (localAllInOne.jdField_a_of_type_Long = 6L;; localAllInOne.jdField_a_of_type_Long = paramCardProfile.uSource)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("param_mode", 3);
      int m = getIntent().getIntExtra("frome_where", 6);
      Intent localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", localAllInOne);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("frome_where", m);
      localIntent.addFlags(268435456);
      startActivityForResult(localIntent, 1023);
      this.jdField_d_of_type_Long = paramCardProfile.lEctID;
      return;
      localAllInOne.jdField_h_of_type_Int = 38;
      break;
    }
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
  private void h()
  {
    setRightButton(2131717964, this);
    Object localObject1 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    this.k = ((DisplayMetrics)localObject1).widthPixels;
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131368718));
    this.jdField_b_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new agax(this));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131381201));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setContentBackground(getResources().getDrawable(2130838778), false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2131559652, this.jdField_a_of_type_ComTencentWidgetSwipListView, false));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setSwipListListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setSelector(2131167247);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)findViewById(2131371702));
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.setEnabled(false);
    if (this.jdField_c_of_type_Boolean)
    {
      this.vg.setBackgroundResource(2131167352);
      localObject1 = getResources().getColorStateList(2131165370);
      this.leftView.setTextColor((ColorStateList)localObject1);
      this.leftView.setBackgroundResource(2130838891);
      this.rightViewText.setTextColor((ColorStateList)localObject1);
      this.rightViewText.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131370235));
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2131167352);
      this.jdField_e_of_type_Boolean = this.jdField_a_of_type_Aobc.d();
      this.jdField_f_of_type_Int = bhtq.b(46.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(1);
      this.jdField_b_of_type_JavaLangString = getString(2131693941);
      this.centerView.setText("");
      this.jdField_g_of_type_Int = bhtq.b();
      localObject1 = LayoutInflater.from(this).inflate(2131561275, null);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject1).findViewById(2131376858);
      this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView = ((ZanBannerView)((View)localObject1).findViewById(2131381585));
      ((View)localObject1).findViewById(2131376902).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379920));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379723));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131380055));
      this.jdField_d_of_type_AndroidViewView = ((View)localObject1).findViewById(2131369352);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131376878));
      int m = Math.round(bhtq.a() * 0.29F);
      Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = m;
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = m;
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369340));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131369342));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369339));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new agay(this));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369264));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369265));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369266));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369267));
      this.jdField_e_of_type_AndroidViewView = ((View)localObject1).findViewById(2131376767);
      if ((this.jdField_e_of_type_Boolean) && (VersionUtils.isHoneycomb())) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_f_of_type_AndroidViewView = ((View)localObject1).findViewById(2131369448);
      this.jdField_e_of_type_Int = (-ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
      this.jdField_d_of_type_Int = (bhtq.a() / 2);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView((View)localObject1);
      localObject2 = new agaz(this);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
      this.jdField_a_of_type_Agbb = new agbb(this);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_Agbb);
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)((View)localObject1).findViewById(2131378331));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131719321));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131692947));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_Bjdq);
      e();
      localObject1 = this.jdField_a_of_type_Aobc.a();
      a(true, ((LikeRankingInfo)localObject1).likeCountOfToday, ((LikeRankingInfo)localObject1).rankingNum, ((LikeRankingInfo)localObject1).totalLikeCount);
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Agbd);
    if (this.jdField_c_of_type_Boolean) {
      findViewById(2131376622).setVisibility(8);
    }
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131366811));; this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131376622)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131719321));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131692947));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_Bjdq);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      ThreadManager.postImmediately(new VisitorsActivity.9(this), null, true);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, 1, 0));
      return;
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_Bacz = new bacz(this, this.jdField_a_of_type_AndroidOsHandler, this.app);
    this.jdField_a_of_type_Agbd = new agbd(this, this, this.app, this, 0, this.jdField_c_of_type_Boolean);
    this.jdField_b_of_type_Agbd = new agbd(this, this, this.app, this, 1, this.jdField_c_of_type_Boolean);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init visitors");
    }
    this.jdField_a_of_type_Agbd.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init favorite");
    }
    this.jdField_b_of_type_Agbd.a(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Agbd.jdField_a_of_type_JavaLangString = getString(2131693960);
    this.jdField_b_of_type_Agbd.jdField_a_of_type_JavaLangString = getString(2131693947);
    startTitleProgress();
    this.jdField_c_of_type_JavaLangString = getResources().getString(2131698299);
  }
  
  public int a(CardProfile paramCardProfile, String paramString)
  {
    boolean bool = ((anyw)this.app.getManager(51)).b(paramString);
    int m;
    switch (paramCardProfile.bMutualFriends)
    {
    default: 
      if ((!bool) && (paramCardProfile.bCloseNeighborVote == 1)) {
        m = 10;
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorsActivity", 2, String.format("getVoteLevel visibility=%d uin=%s isFrd=%b mutual=%d ", new Object[] { Integer.valueOf(m), paramString, Boolean.valueOf(bool), Byte.valueOf(paramCardProfile.bMutualFriends) }));
      }
      return m;
      if (paramCardProfile.bAvailableCnt > 0L)
      {
        m = 0;
      }
      else if (paramCardProfile.bTodayVotedCnt > 0L)
      {
        m = 2;
      }
      else
      {
        m = -1;
        continue;
        if (paramCardProfile.bCloseNeighborVote == 1)
        {
          m = 10;
        }
        else if (paramCardProfile.bAvailableCnt > 0L)
        {
          m = 0;
        }
        else if (paramCardProfile.bTodayVotedCnt > 0L)
        {
          m = 2;
        }
        else
        {
          m = -2;
          continue;
          if (paramCardProfile.bAvailableCnt > 0L) {
            m = 0;
          } else if (paramCardProfile.bTodayVotedCnt > 0L) {
            m = 2;
          } else {
            m = -3;
          }
        }
      }
    }
  }
  
  public CharSequence a(CardProfile paramCardProfile, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    int m = 0;
    Object localObject2 = this.jdField_c_of_type_JavaLangString;
    Object localObject1;
    if (paramCardProfile.type == 2)
    {
      localObject1 = anzj.a(2131715595);
      localObject2 = new SpannableString(String.format((String)localObject2, new Object[] { localObject1, Short.valueOf(paramCardProfile.bVoteCnt) }));
      if (paramCardProfile.dwLikeCustomId <= 0L) {
        break label297;
      }
      localObject1 = (PraiseManager)this.app.getManager(209);
      ((PraiseManager)localObject1).a(this);
      if (!paramBoolean) {
        break label278;
      }
      localObject1 = (azzy)((PraiseManager)localObject1).a.get(Integer.valueOf((int)paramCardProfile.dwLikeCustomId));
      label113:
      if ((localObject1 == null) || (TextUtils.isEmpty(((azzy)localObject1).jdField_b_of_type_JavaLangString))) {
        break label302;
      }
      localObject2 = SpannableString.valueOf(TextUtils.concat(new CharSequence[] { ((azzy)localObject1).jdField_b_of_type_JavaLangString, localObject2 }));
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(((azzy)localObject1).jdField_b_of_type_Int), 0, ((azzy)localObject1).jdField_b_of_type_JavaLangString.length(), 33);
      if (((azzy)localObject1).jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label308;
      }
      a(paramTextView, ((azzy)localObject1).jdField_a_of_type_AndroidGraphicsBitmap, ((azzy)localObject1).jdField_b_of_type_Int);
    }
    label278:
    label297:
    label302:
    label308:
    for (m = 1;; m = 0)
    {
      paramTextView.setOnClickListener(new agai(this, paramCardProfile, (azzy)localObject1, paramInt));
      paramTextView.setClickable(true);
      for (paramCardProfile = (CardProfile)localObject2;; paramCardProfile = (CardProfile)localObject2)
      {
        if (m == 0) {
          paramTextView.setCompoundDrawables(null, null, null, null);
        }
        return paramCardProfile;
        if (paramCardProfile.bSex == 1)
        {
          localObject1 = anzj.a(2131715596);
          break;
        }
        localObject1 = anzj.a(2131715598);
        break;
        localObject1 = ((PraiseManager)localObject1).a((int)paramCardProfile.dwLikeCustomId, true, "from_profile_card");
        break label113;
        paramTextView.setOnClickListener(null);
      }
    }
  }
  
  void a()
  {
    if (!bhnv.d(this))
    {
      a(1, getString(2131693965));
      return;
    }
    a(false);
    this.jdField_a_of_type_Agbd.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Agbd.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_h_of_type_Int == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "[switchToTab] same tab return");
      }
      return;
    }
    if ((this.jdField_c_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.d("VisitorsActivity", 2, "[switchToTab]tab=" + paramInt + ", top1=" + this.jdField_a_of_type_Agbb.jdField_a_of_type_Int + ", visible1=" + this.jdField_a_of_type_Agbb.jdField_a_of_type_Boolean);
    }
    this.jdField_h_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Agbd);
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
      avsy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    }
    for (;;)
    {
      paramInt = this.jdField_a_of_type_Agbb.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setSelectionFromTop(0, -paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a() != this.jdField_h_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_h_of_type_Int, false);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.a() == this.jdField_h_of_type_Int) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.jdField_h_of_type_Int, false);
      return;
      if (paramInt == 1)
      {
        bdll.a(this.app, "CliOper", "", "", "0X8004448", "0X8004448", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_b_of_type_Agbd);
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
        avsy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout);
        Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, new arwi());
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        if (VersionUtils.isOreo())
        {
          View localView = getCurrentFocus();
          if (localView != null) {
            localView.clearFocus();
          }
        }
        if (this.jdField_i_of_type_Boolean)
        {
          this.jdField_i_of_type_Boolean = false;
          startTitleProgress();
          if (!bhnv.d(this))
          {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
            return;
          }
          b(true);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "updateRank todayVoteRank=" + paramInt1 + ", todayVoteRank=" + paramInt2 + ", totalVoteCount=" + paramInt3);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    Bundle localBundle = new Bundle();
    localBundle.putInt("totalVoteCount", paramInt3);
    localMessage.setData(localBundle);
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
    if (this.jdField_h_of_type_Int == 0) {}
    for (long l1 = a();; l1 = b())
    {
      paramView.c(l1);
      return;
    }
  }
  
  public void a(int paramInt1, azzy paramazzy, int paramInt2, String paramString)
  {
    paramInt2 = 0;
    if (paramInt1 == 0) {}
    label92:
    label103:
    CardProfile localCardProfile;
    label156:
    do
    {
      do
      {
        int m;
        do
        {
          return;
          paramString = (Pair)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
          if (paramString != null)
          {
            a(paramazzy, ((Point)paramString.first).x, ((Point)paramString.first).y, ((Boolean)paramString.second).booleanValue(), false);
            this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
          }
          paramString = this.jdField_a_of_type_ComTencentWidgetSwipListView;
          if (this.jdField_h_of_type_Int != 0) {
            break;
          }
          paramazzy = this.jdField_a_of_type_Agbd;
          m = paramString.getFirstVisiblePosition();
        } while (paramazzy == null);
        if (paramInt2 < paramazzy.jdField_a_of_type_JavaUtilList.size())
        {
          localCardProfile = paramazzy.a(paramInt2);
          if (localCardProfile != null) {
            break label156;
          }
        }
        while (localCardProfile.dwLikeCustomId != paramInt1)
        {
          paramInt2 += 1;
          break label103;
          break;
          if (this.jdField_h_of_type_Int == 1)
          {
            paramazzy = this.jdField_b_of_type_Agbd;
            break label92;
          }
          paramazzy = null;
          break label92;
        }
        paramazzy = paramString.getChildAt(paramInt2 - m + paramString.getHeaderViewsCount());
      } while (paramazzy == null);
      paramazzy = (TextView)paramazzy.findViewById(2131380191);
    } while (paramazzy == null);
    a(localCardProfile, paramazzy, true, paramInt2);
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
    agbd localagbd;
    int n;
    int m;
    if (this.jdField_h_of_type_Int == 1)
    {
      localagbd = this.jdField_b_of_type_Agbd;
      n = localSwipListView.getChildCount();
      m = 0;
    }
    for (;;)
    {
      if (m < n)
      {
        Object localObject = localSwipListView.getChildAt(m).getTag();
        if ((localObject != null) && ((localObject instanceof agba)))
        {
          localObject = (agba)localObject;
          if (((((agba)localObject).jdField_a_of_type_JavaLangObject instanceof CardProfile)) && (((CardProfile)((agba)localObject).jdField_a_of_type_JavaLangObject).lEctID == paramLong)) {
            agbd.a(localagbd, ((agba)localObject).jdField_a_of_type_JavaLangObject, (agba)localObject);
          }
        }
      }
      else
      {
        return;
        localagbd = this.jdField_a_of_type_Agbd;
        break;
      }
      m += 1;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    int m = paramView.getScrollX();
    if ((paramInt >= 0) && (this.jdField_a_of_type_Agbd != null) && (this.jdField_j_of_type_Int == paramInt)) {
      paramView.scrollTo(0, 0);
    }
    for (;;)
    {
      paramView.setTag(-3, Integer.valueOf(getResources().getDimensionPixelSize(2131298418)));
      return;
      if (m != 0) {
        paramView.scrollTo(0, 0);
      }
    }
  }
  
  public void a(ImageView paramImageView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    PraiseManager localPraiseManager = (PraiseManager)this.app.getManager(209);
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationInWindow(arrayOfInt);
    float f1 = arrayOfInt[0] + paramImageView.getPaddingLeft();
    float f2 = arrayOfInt[1] - this.jdField_i_of_type_Int + paramImageView.getPaddingTop();
    if ((paramBoolean2) && (localPraiseManager.a.get(Integer.valueOf(paramInt)) == null))
    {
      localPraiseManager.a(this);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new Pair(new Point((int)f1, (int)f2), Boolean.valueOf(paramBoolean1)));
    }
    a(localPraiseManager.a(paramInt, paramBoolean2, "from_profile_card"), f1, f2, paramBoolean1, paramBoolean2);
  }
  
  public void a(ImageView paramImageView, boolean paramBoolean)
  {
    int m = PraiseManager.a(this.app);
    if (m > 0)
    {
      a(paramImageView, m, paramBoolean, true);
      return;
    }
    paramImageView.setVisibility(0);
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationInWindow(arrayOfInt);
    if (!paramBoolean) {}
    for (m = 2;; m = 1)
    {
      if (m == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_Avsz.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a(), this.app, this.jdField_a_of_type_Avsz.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a), arrayOfInt[0] + paramImageView.getPaddingLeft() - bhgr.a(this, 20.0F), arrayOfInt[1] - this.jdField_i_of_type_Int + paramImageView.getPaddingTop() - bhgr.a(this, 20.0F), bhgr.a(this, 75.0F), bhgr.a(this, 65.0F));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_Avsz.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a(), arrayOfInt[0] + paramImageView.getPaddingLeft(), arrayOfInt[1] - this.jdField_i_of_type_Int + paramImageView.getPaddingTop());
      return;
    }
  }
  
  void a(TextView paramTextView, Bitmap paramBitmap, int paramInt)
  {
    paramBitmap = nnw.a(new BitmapDrawable(getResources(), paramBitmap), paramInt);
    paramInt = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
    paramBitmap.setBounds(0, 0, paramInt, paramInt);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
    paramTextView.setCompoundDrawablePadding(5);
  }
  
  public void a(azzy paramazzy, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramazzy != null) {
      if ((!paramBoolean1) && (paramazzy.c != null)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(paramazzy, paramazzy.c, this.app, this.jdField_a_of_type_Avsz.a(2, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a), paramFloat1 - bhgr.a(this, 20.0F), paramFloat2 - bhgr.a(this, 20.0F), bhgr.a(this, 75.0F), bhgr.a(this, 65.0F));
      }
    }
    while (paramBoolean2)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(paramazzy, paramazzy.jdField_b_of_type_AndroidGraphicsBitmap, paramFloat1, paramFloat2);
      return;
    }
    if (!paramBoolean1) {}
    for (int m = 2;; m = 1)
    {
      if (m == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_Avsz.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a(), this.app, this.jdField_a_of_type_Avsz.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a), paramFloat1 - bhgr.a(this, 20.0F), paramFloat2 - bhgr.a(this, 20.0F), bhgr.a(this, 75.0F), bhgr.a(this, 65.0F));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_Avsz.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a(), paramFloat1, paramFloat2);
      return;
    }
  }
  
  public void a(azzy paramazzy, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_j_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "doPraiseAnim, mIsPraiseAnimating=true");
      }
      return;
    }
    paramazzy = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramInt2, paramInt3, new Object[] { Integer.valueOf(paramInt1), paramazzy });
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramazzy);
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof agba))) {}
    do
    {
      return;
      if ((Thread.currentThread() != Looper.getMainLooper().getThread()) && (QLog.isColorLevel())) {
        QLog.i("VisitorsActivity", 2, "warning!!!!!! onRightBtnClick not in main thread");
      }
      if (this.jdField_h_of_type_Int == 0)
      {
        paramObject = (agba)paramObject;
        paramObject = this.jdField_a_of_type_Agbd.b(paramObject.jdField_a_of_type_Int);
        this.jdField_a_of_type_Agbd.notifyDataSetChanged();
        if (paramObject != null) {
          this.jdField_a_of_type_Bacz.a(paramObject.lEctID, 1);
        }
        bdll.b(this.app, "dc00898", "", "", "0X8009702", "0X8009702", 0, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_h_of_type_Int != 1);
    paramObject = (agba)paramObject;
    paramObject = this.jdField_b_of_type_Agbd.b(paramObject.jdField_a_of_type_Int);
    this.jdField_b_of_type_Agbd.notifyDataSetChanged();
    if (paramObject != null) {
      this.jdField_a_of_type_Bacz.a(paramObject.lEctID, 0);
    }
    bdll.b(this.app, "dc00898", "", "", "0X8009703", "0X8009703", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString, int paramInt, ImageView paramImageView)
  {
    if (this.jdField_a_of_type_Anyw.b(paramString))
    {
      localBitmap2 = this.jdField_a_of_type_Aoof.a(1, paramString);
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        this.jdField_a_of_type_Aoof.a(paramString, 1, false);
        localBitmap1 = a();
      }
      paramImageView.setImageBitmap(localBitmap1);
      return;
    }
    Bitmap localBitmap2 = this.jdField_a_of_type_Aoof.a(32, paramString, 200);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.jdField_a_of_type_Aoof.a(paramString, 200, true, false);
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
    this.jdField_a_of_type_Agbd.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onVisitorListOk");
    }
    this.jdField_a_of_type_Agbd.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    if (paramLong == 0L) {
      b(true);
    }
    this.jdField_a_of_type_Agbd.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (TextUtils.isEmpty(this.centerView.getText().toString())) {
          break label48;
        }
        this.centerView.setText(2131693941);
      }
    }
    label48:
    do
    {
      do
      {
        return;
        this.centerView.setText("");
        return;
      } while (this.jdField_c_of_type_AndroidViewView == null);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    } while (this.centerView == null);
    this.centerView.setText(2131693941);
  }
  
  @TargetApi(11)
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt1 + "");
    }
    if (paramInt1 == 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(anzj.a(2131715599));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 18.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setTypeface(this.jdField_d_of_type_AndroidWidgetTextView.getTypeface(), 1);
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, bhtq.b(7.0F));
      if (!paramBoolean) {
        break label306;
      }
      if (paramInt3 > 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt3 + "");
        if (paramInt3 <= 9999) {
          break label293;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(36.0F);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aobc.a(paramInt1, paramInt2, paramInt3);
      if ((!paramBoolean) && (!this.jdField_e_of_type_Boolean)) {
        break label1490;
      }
      if ((!paramBoolean) || (!this.jdField_e_of_type_Boolean)) {
        break label458;
      }
      return;
      if (paramInt2 <= 0) {
        break;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt2));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 30.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setTypeface(Typeface.MONOSPACE);
      this.jdField_d_of_type_AndroidWidgetTextView.setTypeface(this.jdField_d_of_type_AndroidWidgetTextView.getTypeface(), 0);
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, bhtq.b(5.0F));
      break;
      label293:
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(44.0F);
    }
    label306:
    Object localObject = this.jdField_a_of_type_Aobc.a();
    if ((paramInt3 >= 0) && (paramInt3 > ((LikeRankingInfo)localObject).totalLikeCount))
    {
      if (((LikeRankingInfo)localObject).totalLikeCount > 0) {}
      for (m = ((LikeRankingInfo)localObject).totalLikeCount;; m = 0)
      {
        localObject = new bhtd(Integer.valueOf(m), Integer.valueOf(paramInt3), new agan(this));
        ((bhtd)localObject).setStartOffset(200L);
        ((bhtd)localObject).setDuration(1200L);
        this.jdField_c_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject);
        break;
      }
    }
    if (((LikeRankingInfo)localObject).totalLikeCount > 0) {}
    for (int m = ((LikeRankingInfo)localObject).totalLikeCount;; m = 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(m + "");
      break;
    }
    for (;;)
    {
      try
      {
        label458:
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845363);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845364);
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845365);
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130847178);
        paramInt1 = bhtq.b(1.0F);
        if (paramBoolean)
        {
          localObject = new TranslateAnimation(0, paramInt1 * -299 + this.jdField_d_of_type_Int, 0, paramInt1 * -299 + this.jdField_d_of_type_Int, 0, paramInt1 * 42 + this.jdField_e_of_type_Int, 0, paramInt1 * 42 + this.jdField_e_of_type_Int);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new agao(this));
          this.jdField_c_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
          if (!paramBoolean) {
            break label1267;
          }
          localObject = new TranslateAnimation(0, paramInt1 * -217 + this.jdField_d_of_type_Int, 0, paramInt1 * -217 + this.jdField_d_of_type_Int, 0, paramInt1 * 47 + this.jdField_e_of_type_Int, 0, paramInt1 * 47 + this.jdField_e_of_type_Int);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new agap(this));
          this.jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
          if (!paramBoolean) {
            break label1342;
          }
          localObject = new TranslateAnimation(0, paramInt1 * -2 + this.jdField_d_of_type_Int, 0, paramInt1 * -15 + this.jdField_d_of_type_Int, 0, paramInt1 * 50 + this.jdField_e_of_type_Int, 0, paramInt1 * 50 + this.jdField_e_of_type_Int);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new agaq(this));
          this.jdField_e_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
          if (!paramBoolean) {
            break label1416;
          }
          localObject = new TranslateAnimation(0, paramInt1 * 74 + this.jdField_d_of_type_Int, 0, paramInt1 * 74 + this.jdField_d_of_type_Int, 0, paramInt1 * 34 + this.jdField_e_of_type_Int, 0, paramInt1 * 34 + this.jdField_e_of_type_Int);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new agas(this));
          this.jdField_f_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
          if (paramBoolean) {
            break;
          }
          this.jdField_e_of_type_Boolean = false;
          this.jdField_a_of_type_Aobc.a(NetConnInfoCenter.getServerTimeMillis());
          localObject = new AnimationSet(true);
          ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 5.0F, 1.0F, 5.0F, 1, 0.5F, 1, 0.5F);
          localScaleAnimation.setDuration(1800L);
          ((AnimationSet)localObject).addAnimation(localScaleAnimation);
          AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 0.8F);
          localAlphaAnimation1.setDuration(400L);
          ((AnimationSet)localObject).addAnimation(localAlphaAnimation1);
          AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.8F, 0.0F);
          localAlphaAnimation2.setDuration(1400L);
          localAlphaAnimation2.setStartOffset(400L);
          ((AnimationSet)localObject).addAnimation(localAlphaAnimation2);
          ((AnimationSet)localObject).setFillAfter(true);
          ((AnimationSet)localObject).setFillEnabled(true);
          if (this.jdField_a_of_type_JavaLangRunnable == null) {
            this.jdField_a_of_type_JavaLangRunnable = new VisitorsActivity.21(this, localScaleAnimation, localAlphaAnimation1, localAlphaAnimation2, (AnimationSet)localObject);
          }
          ((AnimationSet)localObject).setAnimationListener(new agat(this));
          this.jdField_c_of_type_Int = 5;
          this.jdField_f_of_type_AndroidViewView.startAnimation((Animation)localObject);
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("VisitorsActivity", 1, "load img oom");
        return;
      }
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -493 + this.jdField_d_of_type_Int, 0, paramInt1 * -299 + this.jdField_d_of_type_Int, 0, paramInt1 * 174 + this.jdField_e_of_type_Int, 0, paramInt1 * 42 + this.jdField_e_of_type_Int);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(500L);
      continue;
      label1267:
      localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -520 + this.jdField_d_of_type_Int, 0, paramInt1 * -217 + this.jdField_d_of_type_Int, 0, paramInt1 * 239 + this.jdField_e_of_type_Int, 0, paramInt1 * 47 + this.jdField_e_of_type_Int);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(350L);
      continue;
      label1342:
      localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -160 + this.jdField_d_of_type_Int, 0, paramInt1 * -15 + this.jdField_d_of_type_Int, 0, paramInt1 * 138 + this.jdField_e_of_type_Int, 0, paramInt1 * 50 + this.jdField_e_of_type_Int);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(200L);
      continue;
      label1416:
      localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -180 + this.jdField_d_of_type_Int, 0, paramInt1 * 74 + this.jdField_d_of_type_Int, 0, paramInt1 * 148 + this.jdField_e_of_type_Int, 0, paramInt1 * 34 + this.jdField_e_of_type_Int);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(300L);
    }
    label1490:
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Visitor", 2, "onViewCompleteVisableAndReleased");
    }
    if (!this.jdField_h_of_type_Boolean)
    {
      if (this.jdField_h_of_type_Int == 0) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      for (;;)
      {
        a(0, anzj.a(2131715600));
        return true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
    if (this.jdField_h_of_type_Int == 0) {}
    for (long l1 = a();; l1 = b())
    {
      paramView.a(l1);
      if (stopTitleProgress()) {
        break;
      }
      if (bhnv.d(this)) {
        break label125;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
      return true;
    }
    label125:
    if (this.jdField_h_of_type_Int == 0)
    {
      a(true);
      return true;
    }
    b(true);
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    String str = this.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_Anum.b(str, this.jdField_a_of_type_JavaLangString, 0L, 30);
    }
    while (this.jdField_a_of_type_Long <= -1L) {
      return true;
    }
    this.jdField_a_of_type_Anum.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, 30);
    return true;
  }
  
  public void a_(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int m = ((Integer)paramView).intValue();; m = -1)
    {
      this.jdField_j_of_type_Int = m;
      return;
    }
  }
  
  void b()
  {
    if (!bhnv.d(this))
    {
      a(1, getString(2131693965));
      return;
    }
    b(false);
    this.jdField_b_of_type_Agbd.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Agbd.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    if (isFinishing()) {
      QLog.d("VisitorsActivity", 1, "doPraiseMallEntryAnim isFinishing return");
    }
    do
    {
      do
      {
        return;
        if ((azzw.b != null) && (!azzw.b.isEmpty())) {
          break;
        }
      } while (paramInt <= 0);
      ThreadManager.executeOnFileThread(new VisitorsActivity.13(this));
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView == null);
    this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView.setInfoList(azzw.b);
    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "banner_pageview", "", 1, 0, 0, "", "", "");
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
    if (this.jdField_h_of_type_Int == 0) {}
    for (long l1 = a();; l1 = b())
    {
      paramView.b(l1);
      return;
    }
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_h_of_type_Int != 0) {
            break;
          }
          if ((paramObject instanceof agba))
          {
            paramObject = (agba)paramObject;
            bdll.a(this.app, "CliOper", "", "", "0X800444A", "0X800444A", 0, 0, "", "", "", "");
            a((CardProfile)paramObject.jdField_a_of_type_JavaLangObject);
            return;
          }
        } while (!(paramObject instanceof agbc));
        a();
        return;
      } while (this.jdField_h_of_type_Int != 1);
      if ((paramObject instanceof agba))
      {
        paramObject = (agba)paramObject;
        bdll.a(this.app, "CliOper", "", "", "0X8004447", "0X8004447", 0, 0, "", "", "", "");
        a((CardProfile)paramObject.jdField_a_of_type_JavaLangObject);
        return;
      }
    } while (!(paramObject instanceof agbc));
    b();
  }
  
  public void b(ArrayList<CardProfile> paramArrayList, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet onFavoriteListOk");
    }
    this.jdField_b_of_type_Agbd.a(this.jdField_b_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onFavoriteListOk");
    }
    this.jdField_b_of_type_Agbd.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (paramLong == 0L) {
      c(true);
    }
    this.jdField_b_of_type_Agbd.notifyDataSetChanged();
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
      }
    }
    else {
      return;
    }
    a(1, getString(2131718362));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.springBackOverScrollHeaderView();
  }
  
  public boolean b(boolean paramBoolean)
  {
    String str = this.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_Anum.a(str, this.jdField_a_of_type_JavaLangString, 0L, 30);
    }
    while (this.jdField_b_of_type_Long <= -1L) {
      return true;
    }
    this.jdField_a_of_type_Anum.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long, 30);
    return true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    QQToast.a(this, 1, 2131718362, 0).b(getTitleBarHeight());
    b(false);
    if (this.jdField_a_of_type_Agbd.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Agbd.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Agbd.notifyDataSetChanged();
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  void c(boolean paramBoolean)
  {
    c(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 800L);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      }
    }
    else {
      return;
    }
    a(1, getString(2131718362));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.springBackOverScrollHeaderView();
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
    QQToast.a(this, 1, 2131718362, 0).b(getTitleBarHeight());
    c(false);
    if (this.jdField_b_of_type_Agbd.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Agbd.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Agbd.notifyDataSetChanged();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1023) {}
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt1 == 1028)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "VisitorsActivity->doOnActivityResult, resultCode=" + paramInt2);
        }
        this.jdField_a_of_type_Axxj.a(0L, 0L, 511);
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Anum = ((anum)this.app.a(2));
    this.jdField_a_of_type_Axxj = ((axxj)this.app.a(60));
    this.jdField_a_of_type_Anyw = ((anyw)this.app.getManager(51));
    addObserver(this.jdField_a_of_type_Anuw);
    addObserver(this.jdField_a_of_type_Aogx);
    paramBundle = this.app.getCurrentAccountUin();
    Intent localIntent = getIntent();
    this.jdField_a_of_type_JavaLangString = String.valueOf(localIntent.getLongExtra("toUin", 0L));
    this.jdField_a_of_type_Aobc = ((aobc)this.app.getManager(186));
    this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("extra_show_rank", false);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("extra_from", -1);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "mShowRank=" + this.jdField_c_of_type_Boolean);
    }
    this.jdField_a_of_type_Avsz = new avsz(this);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Aysq = ((aysq)this.app.getManager(160));
      this.app.registObserver(this.jdField_a_of_type_Ayxl);
      if (this.jdField_b_of_type_Int == 1) {
        ThreadManager.post(new VisitorsActivity.3(this), 5, null, false);
      }
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (!paramBundle.equals(this.jdField_a_of_type_JavaLangString))) {}
    this.jdField_a_of_type_Long = getIntent().getLongExtra("nextMidVoter", -1L);
    setContentView(2131563102);
    i();
    h();
    this.app.addObserver(this.jdField_a_of_type_Axxn);
    this.jdField_a_of_type_Aoof = new aoof(this, this.app);
    this.jdField_a_of_type_Aoof.a(this);
    this.jdField_a_of_type_Bbvd = ((bbvd)this.app.getManager(15));
    this.jdField_a_of_type_Bbvd.a(this.jdField_a_of_type_Bbst);
    this.jdField_a_of_type_Axxj.a(0L, 0L, 511);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator != null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.removeAllListeners();
      this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.cancel();
    }
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_Anuw);
    this.jdField_a_of_type_Bbvd.b(this.jdField_a_of_type_Bbst);
    removeObserver(this.jdField_a_of_type_Aogx);
    this.app.removeObserver(this.jdField_a_of_type_Axxn);
    if (this.jdField_c_of_type_Boolean) {
      this.app.unRegistObserver(this.jdField_a_of_type_Ayxl);
    }
    ((PraiseManager)this.app.getManager(209)).b(this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ApngImage.pauseAll();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(14);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_Aobc.c();
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "doOnResume mPartakeRank=" + this.jdField_d_of_type_Boolean);
    }
    a(this.jdField_d_of_type_Boolean);
    if (this.jdField_a_of_type_Anum != null) {
      this.jdField_a_of_type_Anum.k();
    }
    if ((this.jdField_c_of_type_Boolean) && (this.mSystemBarComp != null))
    {
      int m = getResources().getColor(2131165367);
      this.mSystemBarComp.setStatusColor(m);
      this.mSystemBarComp.setStatusBarColor(m);
    }
  }
  
  public void doOnStop()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
      this.jdField_a_of_type_Bacz.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
    }
    super.doOnStop();
  }
  
  public void e()
  {
    RedTouchItem localRedTouchItem = this.jdField_a_of_type_Aysq.a(100601);
    if (this.jdField_a_of_type_Aysq.a(localRedTouchItem, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "updateRedPoint level:" + localRedTouchItem.passThroughLevel);
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject;
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)this.mFlingHandler;
      if (((FlingGestureHandler)localObject).mTopLayout != null)
      {
        localObject = ((FlingGestureHandler)localObject).mTopLayout;
        if (paramBoolean) {
          break label49;
        }
      }
    }
    label49:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
      return;
    }
  }
  
  public void f() {}
  
  public void g()
  {
    try
    {
      this.jdField_b_of_type_Agbd.a(this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_Agbd.notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VisitorsActivity", 1, "updateFavData fail.", localException);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Agbd != null) && (this.jdField_a_of_type_Agbd.jdField_a_of_type_Int > 0)) {
      bdll.a(this.app, "CliOper", "", "", "0X8004446", "0X8004446", 0, 0, String.valueOf(this.jdField_a_of_type_Agbd.jdField_a_of_type_Int), "", "", "");
    }
    if ((this.jdField_b_of_type_Agbd != null) && (this.jdField_b_of_type_Agbd.jdField_a_of_type_Int > 0)) {
      bdll.a(this.app, "CliOper", "", "", "0X8004449", "0X8004449", 0, 0, String.valueOf(this.jdField_b_of_type_Agbd.jdField_a_of_type_Int), "", "", "");
    }
    this.app.reportClickEvent("dc00898", "0X8007612");
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.app.getCurrentAccountUin())))
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 0);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("single_top", true);
      ProfileActivity.a(getActivity(), localAllInOne, localBundle);
      overridePendingTransition(2130771988, 2130771989);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      this.app.reportClickEvent("dc00898", "0X8007613");
      startActivity(new Intent(this, LikeSettingActivity.class));
    }
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131369446)
      {
        localObject1 = paramView.getTag();
        if ((localObject1 != null) && ((localObject1 instanceof CardProfile)))
        {
          localObject1 = (CardProfile)localObject1;
          if (this.jdField_a_of_type_Bacz.a((CardProfile)localObject1, (ImageView)paramView))
          {
            localObject1 = Integer.toString(((CardProfile)localObject1).type);
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", (String)localObject1, "");
            localObject2 = new biax(this);
            ((biax)localObject2).a(new agau(this, (String)localObject1));
            ((biax)localObject2).show();
          }
        }
      }
      else
      {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131376858: 
          bdll.b(this.app, "dc00898", "", "", "0X8007611", "0X8007611", 0, 0, "", "", "", "");
          startActivity(new Intent(this, LikeRankingListActivity.class));
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          this.jdField_f_of_type_AndroidViewView.clearAnimation();
          this.jdField_c_of_type_Int = 0;
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView.a();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = bhyk.a(this, "praise", "");
    }
    for (;;)
    {
      localObject2 = new Intent(this, QQBrowserActivity.class);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "banner_click", "", 1, 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView.b(), "");
      VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 536870912L, (Intent)localObject2, false, -1);
      bdll.b(this.app, "CliOper", "", "", "like_mall", "like_enter", 0, 0, "", "", "", "");
      break;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public View onCreateCenterView()
  {
    super.onCreateCenterView();
    this.centerView.setText(2131719279);
    return this.centerView;
  }
  
  public View onCreateRightView()
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
    if ((paramInt1 == 0) || (l1 >= 800L))
    {
      this.jdField_e_of_type_Long = SystemClock.uptimeMillis();
      if (this.jdField_h_of_type_Int == 0)
      {
        this.jdField_a_of_type_Agbd.notifyDataSetChanged();
        return;
      }
      this.jdField_b_of_type_Agbd.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L - l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity
 * JD-Core Version:    0.7.0.1
 */