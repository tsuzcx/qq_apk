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
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
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
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.CardProfile.CardProfileComparator;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilderFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
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
import ueo;
import uep;
import ueq;
import uer;
import ues;
import uet;
import ueu;
import uev;
import uew;
import uex;
import uey;
import uez;
import ufa;
import ufb;
import ufc;
import ufd;
import ufe;
import uff;
import ufg;
import ufh;
import ufi;
import ufj;
import ufk;
import ufl;
import ufm;
import ufo;

public class VisitorsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, PraiseManager.OnPraiseLoadListener, FaceDecoder.DecodeTaskCompletionListener, OverScrollViewListener
{
  public int a;
  public long a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Handler a;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new uep(this);
  public View a;
  public ViewGroup a;
  public AlphaAnimation a;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  ObjectAnimator jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator;
  public CardHandler a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new uer(this);
  protected FriendsManager a;
  LikeRankingListManager jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager;
  FloatViewBuilderFactory jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory;
  public NearbyZanAnimLayout a;
  public NearbyCardHandler a;
  NearbyCardObserver jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new uev(this);
  public LocalRedTouchManager a;
  GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new uew(this);
  public VoteHelper a;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ufk(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new uez(this);
  public TabBarView a;
  public XListView a;
  public Runnable a;
  protected String a;
  public ArrayList a;
  public HashMap a;
  public final List a;
  public Random a;
  ufm jdField_a_of_type_Ufm;
  public ufo a;
  public boolean a;
  int jdField_b_of_type_Int;
  public long b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ueq(this);
  public View b;
  public ViewGroup b;
  public AlphaAnimation b;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private PullRefreshHeader jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  TabBarView jdField_b_of_type_ComTencentMobileqqWidgetTabBarView;
  public XListView b;
  public String b;
  public ArrayList b;
  ufm jdField_b_of_type_Ufm;
  public ufo b;
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
  private int j;
  public boolean j;
  public boolean k;
  
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
    this.jdField_a_of_type_AndroidOsHandler = new ueo(this);
    this.jdField_i_of_type_Int = 0;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private long a()
  {
    return getActivity().getSharedPreferences("visitors_last_refresh_time", 0).getLong("visitors_last_refresh_time", 0L);
  }
  
  private Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = com.tencent.mobileqq.utils.ImageUtil.c();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, TextView paramTextView)
  {
    paramImageView.setVisibility(8);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131494250));
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo == null) || (!localVipOpenInfo.bOpen)) {
        break label83;
      }
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130845982);
      paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131494295));
    }
    label83:
    do
    {
      return;
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    } while ((paramVipBaseInfo == null) || (!paramVipBaseInfo.bOpen));
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130846210);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131494295));
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.jdField_j_of_type_Int == 0) {
      this.jdField_j_of_type_Int = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.jdField_j_of_type_Int, this.jdField_j_of_type_Int);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  private void a(CardProfile paramCardProfile)
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(String.valueOf(paramCardProfile.lEctID), 41);
    localAllInOne.jdField_h_of_type_JavaLangString = paramCardProfile.strNick;
    localAllInOne.jdField_b_of_type_Int = paramCardProfile.bAage;
    localAllInOne.jdField_a_of_type_Byte = paramCardProfile.bSex;
    localAllInOne.jdField_a_of_type_Short = paramCardProfile.wFace;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(localAllInOne.jdField_a_of_type_JavaLangString);
    if (QLog.isDevelopLevel()) {
      QLog.i("VisitorsActivity", 4, "openProfileCard, nick = " + paramCardProfile.strNick + ", isFriend= " + bool + ", likeSource:" + paramCardProfile.uSource);
    }
    if (bool)
    {
      localAllInOne.jdField_a_of_type_Int = 1;
      localAllInOne.jdField_a_of_type_Long = 1L;
      ProfileActivity.a(this, localAllInOne, 1023);
      return;
    }
    if (this.jdField_h_of_type_Int == 0)
    {
      localAllInOne.jdField_h_of_type_Int = 16;
      if ((paramCardProfile.uSource > 0L) && (paramCardProfile.uSource <= 48L)) {
        break label304;
      }
    }
    label304:
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
  private void f()
  {
    setRightButton(2131436773, this);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131366461));
    this.jdField_b_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new uff(this));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131375263));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(getResources().getDrawable(2130838210), false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130969238, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131492923);
    this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131375264));
    this.jdField_b_of_type_ComTencentWidgetXListView.setContentBackground(getResources().getDrawable(2130838210), false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130969238, this.jdField_b_of_type_ComTencentWidgetXListView, false));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    this.jdField_b_of_type_ComTencentWidgetXListView.setSelector(2131492923);
    this.jdField_b_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)findViewById(2131375265));
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.setEnabled(false);
    if (this.jdField_c_of_type_Boolean)
    {
      this.vg.setBackgroundResource(2131493307);
      Object localObject1 = getResources().getColorStateList(2131494019);
      this.leftView.setTextColor((ColorStateList)localObject1);
      this.leftView.setBackgroundResource(2130838254);
      this.rightViewText.setTextColor((ColorStateList)localObject1);
      this.rightViewText.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375262));
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2131493307);
      this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.d();
      this.jdField_f_of_type_Int = ViewUtils.b(46.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(1);
      this.jdField_b_of_type_JavaLangString = getString(2131433067);
      this.centerView.setText("");
      this.jdField_g_of_type_Int = ViewUtils.c();
      localObject1 = LayoutInflater.from(this).inflate(2130970358, null);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject1).findViewById(2131370234);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370235));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370236));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370237));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131370246));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131370248));
      this.jdField_d_of_type_AndroidViewView = ((View)localObject1).findViewById(2131365196);
      int m = Math.round(ViewUtils.a() * 0.29F);
      Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = m;
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = m;
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131370222));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370241));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131370243));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new ufg(this));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131370230));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131370232));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131370233));
      this.jdField_e_of_type_AndroidViewView = ((View)localObject1).findViewById(2131370239);
      if ((this.jdField_e_of_type_Boolean) && (VersionUtils.e())) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_f_of_type_AndroidViewView = ((View)localObject1).findViewById(2131370244);
      this.jdField_e_of_type_Int = (-ImmersiveUtils.a(BaseApplication.getContext()));
      this.jdField_d_of_type_Int = (ViewUtils.a() / 2);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject1);
      this.jdField_b_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject1);
      localObject2 = new ufh(this);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
      this.jdField_a_of_type_Ufm = new ufm(this);
      this.jdField_b_of_type_Ufm = new ufm(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)((View)localObject1).findViewById(2131370231));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131434999));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131435000));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
      e();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a();
      a(true, ((LikeRankingInfo)localObject1).likeCountOfToday, ((LikeRankingInfo)localObject1).rankingNum, ((LikeRankingInfo)localObject1).totalLikeCount);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ufo);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_b_of_type_Ufo);
    if (this.jdField_c_of_type_Boolean) {
      findViewById(2131366460).setVisibility(8);
    }
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131375266));; this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131366460)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131434999));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131435000));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      ThreadManager.postImmediately(new ufi(this), null, true);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, 1, 0));
      return;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper = new VoteHelper(this, this.jdField_a_of_type_AndroidOsHandler, this.app);
    this.jdField_a_of_type_Ufo = new ufo(this, this, this.app, this.jdField_a_of_type_AndroidViewView$OnClickListener, 0, this.jdField_c_of_type_Boolean);
    this.jdField_b_of_type_Ufo = new ufo(this, this, this.app, this.jdField_b_of_type_AndroidViewView$OnClickListener, 1, this.jdField_c_of_type_Boolean);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init visitors");
    }
    this.jdField_a_of_type_Ufo.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init favorite");
    }
    this.jdField_b_of_type_Ufo.a(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Ufo.jdField_a_of_type_JavaLangString = getString(2131437389);
    this.jdField_b_of_type_Ufo.jdField_a_of_type_JavaLangString = getString(2131437390);
    startTitleProgress();
    this.jdField_c_of_type_JavaLangString = getResources().getString(2131438652);
  }
  
  public CharSequence a(CardProfile paramCardProfile, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    int m = 0;
    Object localObject2 = this.jdField_c_of_type_JavaLangString;
    Object localObject1;
    if (paramCardProfile.type == 2)
    {
      localObject1 = "你";
      localObject2 = new SpannableString(String.format((String)localObject2, new Object[] { localObject1, Short.valueOf(paramCardProfile.bVoteCnt) }));
      if (paramCardProfile.dwLikeCustomId <= 0L) {
        break label288;
      }
      localObject1 = (PraiseManager)this.app.getManager(208);
      ((PraiseManager)localObject1).a(this);
      if (!paramBoolean) {
        break label269;
      }
      localObject1 = (PraiseInfo)((PraiseManager)localObject1).a.get(Integer.valueOf((int)paramCardProfile.dwLikeCustomId));
      label110:
      if ((localObject1 == null) || (TextUtils.isEmpty(((PraiseInfo)localObject1).jdField_b_of_type_JavaLangString))) {
        break label293;
      }
      localObject2 = SpannableString.valueOf(TextUtils.concat(new CharSequence[] { ((PraiseInfo)localObject1).jdField_b_of_type_JavaLangString, localObject2 }));
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(((PraiseInfo)localObject1).jdField_b_of_type_Int), 0, ((PraiseInfo)localObject1).jdField_b_of_type_JavaLangString.length(), 33);
      if (((PraiseInfo)localObject1).jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label299;
      }
      a(paramTextView, ((PraiseInfo)localObject1).jdField_a_of_type_AndroidGraphicsBitmap, ((PraiseInfo)localObject1).jdField_b_of_type_Int);
    }
    label269:
    label288:
    label293:
    label299:
    for (m = 1;; m = 0)
    {
      paramTextView.setOnClickListener(new ufj(this, paramCardProfile, (PraiseInfo)localObject1, paramInt));
      paramTextView.setClickable(true);
      for (paramCardProfile = (CardProfile)localObject2;; paramCardProfile = (CardProfile)localObject2)
      {
        if (m == 0) {
          paramTextView.setCompoundDrawables(null, null, null, null);
        }
        return paramCardProfile;
        if (paramCardProfile.bSex == 1)
        {
          localObject1 = "她";
          break;
        }
        localObject1 = "他";
        break;
        localObject1 = ((PraiseManager)localObject1).a((int)paramCardProfile.dwLikeCustomId, true, "from_profile_card");
        break label110;
        paramTextView.setOnClickListener(null);
      }
    }
  }
  
  public void a()
  {
    if (!NetworkUtil.d(this))
    {
      a(1, getString(2131434794));
      return;
    }
    a(false);
    this.jdField_a_of_type_Ufo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ufo.notifyDataSetChanged();
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
      QLog.d("VisitorsActivity", 2, "[switchToTab]tab=" + paramInt + ", top1=" + this.jdField_a_of_type_Ufm.jdField_a_of_type_Int + ", visible1=" + this.jdField_a_of_type_Ufm.jdField_a_of_type_Boolean + ", top2=" + this.jdField_b_of_type_Ufm.jdField_a_of_type_Int + ", visible2=" + this.jdField_b_of_type_Ufm.jdField_a_of_type_Boolean);
    }
    this.jdField_h_of_type_Int = paramInt;
    boolean bool1;
    boolean bool2;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
      FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      if (this.jdField_c_of_type_Boolean)
      {
        bool1 = this.jdField_a_of_type_Ufm.jdField_a_of_type_Boolean;
        bool2 = this.jdField_b_of_type_Ufm.jdField_a_of_type_Boolean;
        if ((bool1) || (bool2))
        {
          if (!bool2) {
            this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(1);
          }
        }
        else
        {
          label214:
          this.jdField_a_of_type_Ufm.jdField_a_of_type_Boolean = bool2;
          this.jdField_a_of_type_Ufm.jdField_a_of_type_Int = this.jdField_b_of_type_Ufm.jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Ufm);
          this.jdField_b_of_type_ComTencentWidgetXListView.setOnScrollListener(null);
        }
      }
      else
      {
        this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
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
        if (bool1) {
          break label214;
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.requestFocusFromTouch();
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(0, this.jdField_b_of_type_Ufm.jdField_a_of_type_Int);
      }
      catch (Exception localException1)
      {
        QLog.e("VisitorsActivity", 1, "setVisibility err", localException1);
        continue;
      }
      if (paramInt == 1)
      {
        ReportController.a(this.app, "CliOper", "", "", "0X8004448", "0X8004448", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
        FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout);
        Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, new CardProfile.CardProfileComparator());
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        if (this.jdField_c_of_type_Boolean)
        {
          bool1 = this.jdField_a_of_type_Ufm.jdField_a_of_type_Boolean;
          bool2 = this.jdField_b_of_type_Ufm.jdField_a_of_type_Boolean;
          if ((bool1) || (bool2))
          {
            if (!bool1) {
              this.jdField_b_of_type_ComTencentWidgetXListView.setSelection(1);
            }
          }
          else
          {
            this.jdField_b_of_type_Ufm.jdField_a_of_type_Boolean = bool1;
            this.jdField_b_of_type_Ufm.jdField_a_of_type_Int = this.jdField_a_of_type_Ufm.jdField_a_of_type_Int;
            this.jdField_b_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_b_of_type_Ufm);
            this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(null);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
          if (VersionUtils.j())
          {
            View localView = getCurrentFocus();
            if (localView != null) {
              localView.clearFocus();
            }
          }
        }
        try
        {
          this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
          if (this.jdField_i_of_type_Boolean)
          {
            this.jdField_i_of_type_Boolean = false;
            startTitleProgress();
            if (!NetworkUtil.d(this))
            {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
              return;
              this.jdField_b_of_type_ComTencentWidgetXListView.setSelectionFromTop(0, this.jdField_a_of_type_Ufm.jdField_a_of_type_Int);
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            QLog.e("VisitorsActivity", 1, "mFavoListView setVisibility err", localException2);
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
    if (paramListView == this.jdField_a_of_type_ComTencentWidgetXListView)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(b());
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    paramInt2 = 0;
    if (paramInt1 == 0) {}
    label87:
    label99:
    label110:
    CardProfile localCardProfile;
    label151:
    label172:
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
            a(paramPraiseInfo, ((Point)paramString.first).x, ((Point)paramString.first).y, ((Boolean)paramString.second).booleanValue(), false);
            this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
          }
          if (this.jdField_h_of_type_Int != 0) {
            break;
          }
          paramString = this.jdField_a_of_type_ComTencentWidgetXListView;
          if (this.jdField_h_of_type_Int != 0) {
            break label151;
          }
          paramPraiseInfo = this.jdField_a_of_type_Ufo;
          m = paramString.getFirstVisiblePosition();
        } while (paramPraiseInfo == null);
        if (paramInt2 < paramPraiseInfo.jdField_a_of_type_JavaUtilList.size())
        {
          localCardProfile = paramPraiseInfo.a(paramInt2);
          if (localCardProfile != null) {
            break label172;
          }
        }
        while (localCardProfile.dwLikeCustomId != paramInt1)
        {
          paramInt2 += 1;
          break label110;
          break;
          paramString = this.jdField_b_of_type_ComTencentWidgetXListView;
          break label87;
          if (this.jdField_h_of_type_Int == 1)
          {
            paramPraiseInfo = this.jdField_b_of_type_Ufo;
            break label99;
          }
          paramPraiseInfo = null;
          break label99;
        }
        paramPraiseInfo = paramString.getChildAt(paramInt2 - m + paramString.getHeaderViewsCount());
      } while (paramPraiseInfo == null);
      paramPraiseInfo = (TextView)paramPraiseInfo.findViewById(2131364846);
    } while (paramPraiseInfo == null);
    a(localCardProfile, paramPraiseInfo, true, paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(long paramLong)
  {
    XListView localXListView;
    ufo localufo;
    int n;
    int m;
    if (this.jdField_h_of_type_Int == 1)
    {
      localXListView = this.jdField_b_of_type_ComTencentWidgetXListView;
      localufo = this.jdField_b_of_type_Ufo;
      n = localXListView.getChildCount();
      m = 0;
    }
    for (;;)
    {
      if (m < n)
      {
        Object localObject = localXListView.getChildAt(m).getTag();
        if ((localObject != null) && ((localObject instanceof ufl)))
        {
          localObject = (ufl)localObject;
          if (((((ufl)localObject).a instanceof CardProfile)) && (((CardProfile)((ufl)localObject).a).lEctID == paramLong)) {
            ufo.a(localufo, ((ufl)localObject).a, (ufl)localObject);
          }
        }
      }
      else
      {
        return;
        localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
        localufo = this.jdField_a_of_type_Ufo;
        break;
      }
      m += 1;
    }
  }
  
  public void a(ImageView paramImageView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    PraiseManager localPraiseManager = (PraiseManager)this.app.getManager(208);
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a(), this.app, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a), arrayOfInt[0] + paramImageView.getPaddingLeft() - DisplayUtil.a(this, 20.0F), arrayOfInt[1] - this.jdField_i_of_type_Int + paramImageView.getPaddingTop() - DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 75.0F), DisplayUtil.a(this, 65.0F));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a(), arrayOfInt[0] + paramImageView.getPaddingLeft(), arrayOfInt[1] - this.jdField_i_of_type_Int + paramImageView.getPaddingTop());
      return;
    }
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
    if (paramPraiseInfo != null) {
      if ((!paramBoolean1) && (paramPraiseInfo.c != null)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(paramPraiseInfo.c, this.app, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(2, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a), paramFloat1 - DisplayUtil.a(this, 20.0F), paramFloat2 - DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 75.0F), DisplayUtil.a(this, 65.0F));
      }
    }
    while (paramBoolean2)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(paramPraiseInfo.jdField_b_of_type_AndroidGraphicsBitmap, paramFloat1, paramFloat2);
      return;
    }
    if (!paramBoolean1) {}
    for (int m = 2;; m = 1)
    {
      if (m == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a(), this.app, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a), paramFloat1 - DisplayUtil.a(this, 20.0F), paramFloat2 - DisplayUtil.a(this, 20.0F), DisplayUtil.a(this, 75.0F), DisplayUtil.a(this, 65.0F));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory.a(m, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a).a(), paramFloat1, paramFloat2);
      return;
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
  
  public void a(String paramString, int paramInt, ImageView paramImageView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString))
    {
      localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString);
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 1, false);
        localBitmap1 = a();
      }
      paramImageView.setImageBitmap(localBitmap1);
      return;
    }
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, paramString, 200);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 200, true, false);
      localBitmap1 = a();
    }
    paramImageView.setImageBitmap(localBitmap1);
  }
  
  public void a(ArrayList paramArrayList, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet onVisitorListOk");
    }
    this.jdField_a_of_type_Ufo.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onVisitorListOk");
    }
    this.jdField_a_of_type_Ufo.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    if (paramLong == 0L) {
      b(true);
    }
    this.jdField_a_of_type_Ufo.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!TextUtils.isEmpty(this.centerView.getText().toString())) {
          this.centerView.setText(2131433067);
        }
      }
      else if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    do
    {
      return;
      this.centerView.setText("");
      break;
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if (this.centerView != null) {
          this.centerView.setText(2131433067);
        }
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  @TargetApi(11)
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt1 + "");
    }
    if (paramInt1 == 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText("未上榜");
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 18.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setTypeface(this.jdField_d_of_type_AndroidWidgetTextView.getTypeface(), 1);
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, ViewUtils.b(7.0F));
      if (!paramBoolean) {
        break label303;
      }
      if (paramInt3 > 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt3 + "");
        if (paramInt3 <= 9999) {
          break label290;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(36.0F);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a(paramInt1, paramInt2, paramInt3);
      if ((!paramBoolean) && (!this.jdField_e_of_type_Boolean)) {
        break label1287;
      }
      if ((!paramBoolean) || (!this.jdField_e_of_type_Boolean)) {
        break label455;
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
      ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, ViewUtils.b(5.0F));
      break;
      label290:
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(44.0F);
    }
    label303:
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a();
    if ((paramInt3 >= 0) && (paramInt3 > ((LikeRankingInfo)localObject).totalLikeCount))
    {
      if (((LikeRankingInfo)localObject).totalLikeCount > 0) {}
      for (m = ((LikeRankingInfo)localObject).totalLikeCount;; m = 0)
      {
        localObject = new ValueAnimation(Integer.valueOf(m), Integer.valueOf(paramInt3), new uex(this));
        ((ValueAnimation)localObject).setStartOffset(200L);
        ((ValueAnimation)localObject).setDuration(1200L);
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
        label455:
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130842584);
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130842585);
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130842586);
        paramInt1 = ViewUtils.b(1.0F);
        if (paramBoolean)
        {
          localObject = new TranslateAnimation(0, paramInt1 * -276 + this.jdField_d_of_type_Int, 0, paramInt1 * -276 + this.jdField_d_of_type_Int, 0, paramInt1 * 44 + this.jdField_e_of_type_Int, 0, paramInt1 * 44 + this.jdField_e_of_type_Int);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new uey(this));
          this.jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
          if (!paramBoolean) {
            break label1138;
          }
          localObject = new TranslateAnimation(0, paramInt1 * -195 + this.jdField_d_of_type_Int, 0, paramInt1 * -195 + this.jdField_d_of_type_Int, 0, paramInt1 * 44 + this.jdField_e_of_type_Int, 0, paramInt1 * 44 + this.jdField_e_of_type_Int);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new ufa(this));
          this.jdField_e_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
          if (!paramBoolean) {
            break label1213;
          }
          localObject = new TranslateAnimation(0, paramInt1 * -16 + this.jdField_d_of_type_Int, 0, paramInt1 * -16 + this.jdField_d_of_type_Int, 0, paramInt1 * 48 + this.jdField_e_of_type_Int, 0, paramInt1 * 48 + this.jdField_e_of_type_Int);
          ((TranslateAnimation)localObject).setDuration(0L);
          ((TranslateAnimation)localObject).setStartOffset(0L);
          ((TranslateAnimation)localObject).setFillEnabled(true);
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
          ((TranslateAnimation)localObject).setAnimationListener(new ufb(this));
          this.jdField_f_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
          if (paramBoolean) {
            break;
          }
          this.jdField_e_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a(NetConnInfoCenter.getServerTimeMillis());
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
            this.jdField_a_of_type_JavaLangRunnable = new ufc(this, localScaleAnimation, localAlphaAnimation1, localAlphaAnimation2, (AnimationSet)localObject);
          }
          ((AnimationSet)localObject).setAnimationListener(new ufd(this));
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
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -493 + this.jdField_d_of_type_Int, 0, paramInt1 * -276 + this.jdField_d_of_type_Int, 0, paramInt1 * 174 + this.jdField_e_of_type_Int, 0, paramInt1 * 44 + this.jdField_e_of_type_Int);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(500L);
      continue;
      label1138:
      localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -520 + this.jdField_d_of_type_Int, 0, paramInt1 * -195 + this.jdField_d_of_type_Int, 0, paramInt1 * 239 + this.jdField_e_of_type_Int, 0, paramInt1 * 44 + this.jdField_e_of_type_Int);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(350L);
      continue;
      label1213:
      localTranslateAnimation = new TranslateAnimation(0, paramInt1 * -160 + this.jdField_d_of_type_Int, 0, paramInt1 * -16 + this.jdField_d_of_type_Int, 0, paramInt1 * 138 + this.jdField_e_of_type_Int, 0, paramInt1 * 48 + this.jdField_e_of_type_Int);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setStartOffset(200L);
    }
    label1287:
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Visitor", 2, "onViewCompleteVisableAndReleased");
    }
    if (!this.jdField_h_of_type_Boolean) {
      if (this.jdField_h_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        a(0, "正在加载，请稍候。");
      }
    }
    label116:
    do
    {
      do
      {
        return true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        break;
        if (paramListView != this.jdField_a_of_type_ComTencentWidgetXListView) {
          break label116;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
      } while (stopTitleProgress());
      if (!NetworkUtil.d(this))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
        return true;
      }
      a(true);
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(b());
    } while (stopTitleProgress());
    if (!NetworkUtil.d(this))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
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
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(str, this.jdField_a_of_type_JavaLangString, 0L, 30);
    }
    while (this.jdField_a_of_type_Long <= -1L) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, 30);
    return true;
  }
  
  public void b()
  {
    if (!NetworkUtil.d(this))
    {
      a(1, getString(2131434794));
      return;
    }
    b(false);
    this.jdField_b_of_type_Ufo.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Ufo.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    if ((PraiseConfigHelper.a == null) || (PraiseConfigHelper.a.isEmpty())) {
      if (paramInt > 0) {
        ThreadManager.executeOnFileThread(new ues(this));
      }
    }
    for (;;)
    {
      Object localObject;
      if (!this.k)
      {
        localObject = PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 0.2F });
        PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 0.2F });
        PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("alpha", new float[] { 1.0F, 0.2F });
        if (this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator != null)
        {
          this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.removeAllListeners();
          this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.cancel();
        }
        this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.jdField_c_of_type_AndroidWidgetImageView, new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, localPropertyValuesHolder2 });
        this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.setRepeatMode(2);
        this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.setRepeatCount(-1);
        this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.setDuration(750L);
        this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.setInterpolator(new uet(this));
        this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.addListener(new ueu(this));
        this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.start();
        this.k = true;
      }
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(getResources().getDrawable(2130845687));
      paramInt = 0;
      while (paramInt < PraiseConfigHelper.a.size())
      {
        localObject = URLDrawable.getDrawable((String)PraiseConfigHelper.a.get(paramInt), null);
        ((URLDrawable)localObject).startDownload();
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        paramInt += 1;
      }
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentWidgetXListView)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(b());
  }
  
  public void b(ArrayList paramArrayList, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet onFavoriteListOk");
    }
    this.jdField_b_of_type_Ufo.a(this.jdField_b_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onFavoriteListOk");
    }
    this.jdField_b_of_type_Ufo.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (paramLong == 0L) {
      c(true);
    }
    this.jdField_b_of_type_Ufo.notifyDataSetChanged();
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
    a(1, getString(2131434332));
    this.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
  
  boolean b(boolean paramBoolean)
  {
    String str = this.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(str, this.jdField_a_of_type_JavaLangString, 0L, 30);
    }
    while (this.jdField_b_of_type_Long <= -1L) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long, 30);
    return true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    QQToast.a(this, 1, 2131434332, 0).b(getTitleBarHeight());
    b(false);
    if (this.jdField_a_of_type_Ufo.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ufo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Ufo.notifyDataSetChanged();
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
        this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      }
    }
    else {
      return;
    }
    a(1, getString(2131434332));
    this.jdField_b_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
    QQToast.a(this, 1, 2131434332, 0).b(getTitleBarHeight());
    c(false);
    if (this.jdField_b_of_type_Ufo.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Ufo.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Ufo.notifyDataSetChanged();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(0L, 0L, 511);
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
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.m();
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler = ((NearbyCardHandler)this.app.a(60));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    paramBundle = this.app.getCurrentAccountUin();
    Intent localIntent = getIntent();
    this.jdField_a_of_type_JavaLangString = String.valueOf(localIntent.getLongExtra("toUin", 0L));
    this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager = ((LikeRankingListManager)this.app.getManager(185));
    this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("extra_show_rank", false);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("extra_from", -1);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "mShowRank=" + this.jdField_c_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilderFactory = new FloatViewBuilderFactory(this);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchLocalRedTouchManager = ((LocalRedTouchManager)this.app.getManager(159));
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      if (this.jdField_b_of_type_Int == 1) {
        ThreadManager.post(new ufe(this), 5, null, false);
      }
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (!paramBundle.equals(this.jdField_a_of_type_JavaLangString))) {}
    this.jdField_a_of_type_Long = getIntent().getLongExtra("nextMidVoter", -1L);
    setContentView(2130971673);
    g();
    f();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(0L, 0L, 511);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator != null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.removeAllListeners();
      this.jdField_a_of_type_ComNineoldandroidsAnimationObjectAnimator.cancel();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    if (this.jdField_c_of_type_Boolean) {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    ((PraiseManager)this.app.getManager(208)).b(this);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.c();
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "doOnResume mPartakeRank=" + this.jdField_d_of_type_Boolean);
    }
    a(this.jdField_d_of_type_Boolean);
    if ((this.jdField_c_of_type_Boolean) && (this.mSystemBarComp != null))
    {
      int m = getResources().getColor(2131493307);
      this.mSystemBarComp.setStatusColor(m);
      this.mSystemBarComp.setStatusBarColor(m);
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
      this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
    }
    super.doOnStop();
  }
  
  public void e()
  {
    RedTouchItem localRedTouchItem = this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchLocalRedTouchManager.a(100601);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchLocalRedTouchManager.a(localRedTouchItem, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "updateRedPoint level:" + localRedTouchItem.passThroughLevel);
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Ufo != null) && (this.jdField_a_of_type_Ufo.jdField_a_of_type_Int > 0)) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004446", "0X8004446", 0, 0, String.valueOf(this.jdField_a_of_type_Ufo.jdField_a_of_type_Int), "", "", "");
    }
    if ((this.jdField_b_of_type_Ufo != null) && (this.jdField_b_of_type_Ufo.jdField_a_of_type_Int > 0)) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004449", "0X8004449", 0, 0, String.valueOf(this.jdField_b_of_type_Ufo.jdField_a_of_type_Int), "", "", "");
    }
    this.app.reportClickEvent("dc00898", "0X8007612");
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
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
    do
    {
      return;
      if (paramView.getId() != 2131364845) {
        break;
      }
      localObject = paramView.getTag();
    } while ((localObject == null) || (!(localObject instanceof CardProfile)));
    Object localObject = (CardProfile)localObject;
    this.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a((CardProfile)localObject, (ImageView)paramView);
    return;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131370234: 
      ReportController.b(this.app, "dc00898", "", "", "0X8007611", "0X8007611", 0, 0, "", "", "", "");
      startActivity(new Intent(this, LikeRankingListActivity.class));
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.clearAnimation();
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "praise", ""), 536870912L, paramView, false, -1);
    ReportController.b(this.app, "CliOper", "", "", "like_mall", "like_enter", 0, 0, "", "", "", "");
  }
  
  protected View onCreateCenterView()
  {
    super.onCreateCenterView();
    this.centerView.setText(2131434996);
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
    long l = SystemClock.uptimeMillis() - this.jdField_e_of_type_Long;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if ((paramInt1 == 0) || (l >= 800L))
    {
      this.jdField_e_of_type_Long = SystemClock.uptimeMillis();
      if (this.jdField_h_of_type_Int == 0)
      {
        this.jdField_a_of_type_Ufo.notifyDataSetChanged();
        return;
      }
      this.jdField_b_of_type_Ufo.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity
 * JD-Core Version:    0.7.0.1
 */