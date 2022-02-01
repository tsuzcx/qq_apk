package com.tencent.mobileqq.activity;

import MQQ.PayRuleCfg;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.qqsettingme.ICardCatcher;
import com.tencent.mobileqq.activity.qqsettingme.IQQSettingMeProcessor;
import com.tencent.mobileqq.activity.qqsettingme.ISuperMemberDataCatcher;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeConstant;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeConstant.OpenPageType;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeItemData;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeViewModel;
import com.tencent.mobileqq.activity.qqsettingme.api.IAvatarLayoutApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IFaceDrawableApi;
import com.tencent.mobileqq.activity.qqsettingme.api.ILoveZoneRedTouchApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IQVipMedalViewApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeLabelTextViewApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeAvatarRedTouchBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeAvatarViewBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDailyBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDocumentBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDynamicItemBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeFileBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeKingCardBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeLevelAndMedalBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeMiniGameBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeNicknameBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMePrettyNumBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeProfileBubbleBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeRichStatusBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSettingBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeShoppingBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSignatureBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSuperMemberPayButtonBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeWeatherBean;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.Title;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeMenuConfigBean;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.BitmapUtil;
import com.tencent.util.URLUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.redInfo.RedInfo;

public class QQSettingMe
  implements View.OnClickListener, View.OnTouchListener
{
  public static int a;
  private static final HashMap<String, QQSettingMeBizBean> an = new HashMap();
  private static final HashMap<String, Integer> ao = new HashMap();
  private static volatile boolean i;
  private final ImageView A;
  private final ImageView B;
  private final ImageView C;
  private final TextView D;
  private final RedTouch E;
  private final View F;
  private final View G;
  private final View H;
  private final RedTouch I;
  private final View J;
  private final RedTouch K;
  private final ImageView L;
  private final ImageView M;
  private final RedTouch N;
  private final LinearLayout O;
  private final RedTouch P;
  private final TextView Q;
  private final FixedBounceScrollView R;
  private LinearLayout S;
  private final View T;
  private ViewGroup U;
  private TextView V;
  private View W;
  private View X;
  private final View Y;
  private final TextView Z;
  private final ImageView aa;
  private final RedTouch ab;
  private final RedDotTextView ac;
  private final ImageView ad;
  private final TextView ae;
  private final View af;
  private final TextView ag;
  private final LinearLayout ah;
  private final View ai;
  private final TextView aj;
  private final TextView ak;
  private final TextView al;
  private final TextView am;
  private ArrayList<View> ap = new ArrayList();
  public volatile boolean b = false;
  public boolean c;
  public ViewGroup d;
  public final View e;
  public final View f;
  private AppRuntime g;
  private final QBaseActivity h;
  private final QQSettingMeViewModel j;
  private long k;
  private boolean l;
  private boolean m = false;
  private int n;
  private final int o;
  private final View p;
  private RedTouch q;
  private final View r;
  private final View s;
  private final ImageView t;
  private final RedTouch u;
  private final View v;
  private final RedTouch w;
  private final URLImageView x;
  private final TextView y;
  private final ImageView z;
  
  @TargetApi(11)
  public QQSettingMe(QBaseActivity paramQBaseActivity, AppRuntime paramAppRuntime, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.h = paramQBaseActivity;
    this.g = paramAppRuntime;
    this.d = paramViewGroup;
    paramViewGroup = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(this.h);
    this.j = ((QQSettingMeViewModel)ViewModelProviderHelper.a(paramViewGroup, QQSettingMeViewModel.a).get(QQSettingMeViewModel.class));
    paramViewGroup.getLifecycle().addObserver(new QQSettingMe.1(this));
    this.p = this.d.findViewById(2131432229);
    this.p.setOnClickListener(this);
    this.p.setOnTouchListener(this);
    if (AppSetting.e) {
      this.p.setContentDescription(HardCodeUtil.a(2131908391));
    }
    this.r = this.p.findViewById(2131432227);
    this.s = this.p.findViewById(2131432226);
    this.t = ((ImageView)this.s.findViewById(2131432224));
    ((IAvatarLayoutApi)QRoute.api(IAvatarLayoutApi.class)).putAvatar(this.s, this.t, false);
    paramViewGroup = paramAppRuntime.getCurrentAccountUin();
    Object localObject;
    if ((paramViewGroup != null) && (paramViewGroup.length() != 0))
    {
      localObject = ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getBitmapFromCache(paramAppRuntime, paramViewGroup, 0, true);
      if (localObject != null) {
        this.t.setImageBitmap((Bitmap)localObject);
      } else {
        this.t.setImageResource(2130841060);
      }
    }
    else
    {
      this.t.setImageResource(2130841060);
    }
    this.v = this.p.findViewById(2131432245);
    this.w = new RedTouch(paramQBaseActivity, this.v).c(8388661).a();
    this.u = new RedTouch(paramQBaseActivity, this.r).c(8388661).a();
    w();
    this.r.setVisibility(((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getStrokeVisible(paramViewGroup, paramAppRuntime));
    this.x = ((URLImageView)this.p.findViewById(2131432236));
    if (QQTheme.isNowThemeIsNight()) {
      this.x.setColorFilter(1996488704);
    }
    this.p.findViewById(2131432234).setOnClickListener(this);
    int i1 = this.h.getBaseContext().getResources().getDimensionPixelSize(2131299233);
    this.n = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - i1 - ScreenUtil.dip2px(45.0F));
    this.o = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - i1 - ScreenUtil.dip2px(20.0F));
    this.y = ((TextView)this.p.findViewById(2131432233));
    this.y.setMaxWidth(this.n);
    this.z = ((ImageView)this.p.findViewById(2131432237));
    this.A = ((ImageView)this.p.findViewById(2131432246));
    this.B = ((ImageView)this.p.findViewById(2131432247));
    this.B.setOnClickListener(this);
    this.H = this.p.findViewById(2131432238);
    this.H.setOnClickListener(this);
    this.I = new RedTouch(paramQBaseActivity, this.H).c(8388661).b(12).c(1.0F).b(1.0F).a();
    this.D = ((TextView)this.p.findViewById(2131432239));
    this.E = new RedTouch(paramQBaseActivity, this.D).c(8388661).b(12).c(0.0F).b(1.0F).a();
    this.D.setText("");
    this.D.setOnClickListener(this);
    this.C = ((ImageView)this.p.findViewById(2131432225));
    this.C.setOnClickListener(this);
    this.e = this.p.findViewById(2131432235);
    this.e.setOnClickListener(this);
    this.F = this.p.findViewById(2131432231);
    this.G = this.p.findViewById(2131432232);
    this.O = ((LinearLayout)this.d.findViewById(2131432217));
    this.Q = ((TextView)this.O.findViewById(2131432216));
    if (ImmersiveUtils.isSupporImmersive() == 0)
    {
      paramViewGroup = (ViewGroup.MarginLayoutParams)this.O.getLayoutParams();
      paramViewGroup.topMargin = (ScreenUtil.dip2px(35.0F) - ImmersiveUtils.getStatusBarHeight(this.h.getApplicationContext()));
      this.O.setLayoutParams(paramViewGroup);
    }
    this.O.setOnClickListener(this);
    this.O.setOnTouchListener(this);
    this.P = new RedTouch(this.h, this.O.findViewById(2131432215)).c(8388661).a();
    this.J = this.d.findViewById(2131432242);
    this.K = new RedTouch(this.h, this.J).d(10).c(8388627).a();
    this.K.setId(2131432244);
    this.J.setOnClickListener(this);
    this.J.setOnTouchListener(this);
    this.L = ((ImageView)this.d.findViewById(2131432179));
    paramViewGroup = (FrameLayout)this.d.findViewById(2131432178);
    if (ImmersiveUtils.isSupporImmersive() == 0)
    {
      localObject = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (ScreenUtil.dip2px(29.0F) - ImmersiveUtils.getStatusBarHeight(this.h.getApplicationContext()));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Change backWrapper topMargin=");
        localStringBuilder.append(((ViewGroup.MarginLayoutParams)localObject).topMargin);
        QLog.d("QQSettingRedesign", 2, localStringBuilder.toString());
      }
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.L.setOnClickListener(this);
    this.L.setOnTouchListener(this);
    this.M = ((ImageView)this.d.findViewById(2131432207));
    this.N = new RedTouch(paramQBaseActivity, this.M).c(8388661).b(20).c(1.0F).b(1.0F).a();
    this.M.setOnClickListener(this);
    this.M.setOnTouchListener(this);
    this.R = ((FixedBounceScrollView)this.d.findViewById(2131432194));
    this.R.setDamping(2.0F);
    this.R.setBounceDelay(600L);
    this.R.setmCustomTopFadingEdgeScale(0.675F);
    paramViewGroup = ((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).getCurrentThemeInfo();
    paramQBaseActivity = paramViewGroup.getString("themeId");
    boolean bool;
    if ((!TextUtils.isEmpty(paramQBaseActivity)) && (!"1000".equals(paramQBaseActivity)) && (!"1103".equals(paramQBaseActivity))) {
      bool = false;
    } else {
      bool = true;
    }
    this.l = bool;
    if (this.l) {
      i1 = this.d.getResources().getColor(2131167330);
    } else {
      i1 = this.d.getResources().getColor(2131167331);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "QQSettingMe_init, color=", Integer.valueOf(i1), ",themeId = ", paramQBaseActivity, ", enginePath=", paramViewGroup.getString("themePath") });
    }
    this.S = ((LinearLayout)this.R.findViewById(2131432192));
    paramViewGroup = this.S;
    paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), ScreenUtil.dip2px(14.0F), this.S.getPaddingRight(), this.S.getPaddingBottom());
    this.T = this.d.findViewById(2131432193);
    this.T.setOnClickListener(this);
    if ((!TextUtils.isEmpty(paramQBaseActivity)) && (!"1000".equals(paramQBaseActivity))) {
      this.T.setVisibility(8);
    } else {
      this.T.setVisibility(0);
    }
    this.Y = this.d.findViewById(2131432209);
    this.Y.setOnClickListener(this);
    this.Y.setOnTouchListener(this);
    AccessibilityUtil.a(this.Y, HardCodeUtil.a(2131908383), Button.class.getName());
    this.Z = ((TextView)this.d.findViewById(2131432212));
    this.aa = ((ImageView)this.d.findViewById(2131432210));
    this.ac = ((RedDotTextView)this.d.findViewById(2131432211));
    this.ab = new RedTouch(this.h, this.ac).a();
    this.f = this.d.findViewById(2131432196);
    this.f.setOnClickListener(this);
    this.f.setOnTouchListener(this);
    AccessibilityUtil.a(this.f, HardCodeUtil.a(2131908366), Button.class.getName());
    this.ae = ((TextView)this.d.findViewById(2131432198));
    this.ad = ((ImageView)this.d.findViewById(2131432197));
    this.af = this.d.findViewById(2131432220);
    this.ag = ((TextView)this.d.findViewById(2131432221));
    this.af.setOnClickListener(this);
    this.af.setOnTouchListener(this);
    this.ah = ((LinearLayout)this.d.findViewById(2131432250));
    this.ah.setOnClickListener(this);
    this.ah.setOnTouchListener(this);
    this.aj = ((TextView)this.d.findViewById(2131432251));
    this.ai = this.d.findViewById(2131432252);
    this.ak = ((TextView)this.d.findViewById(2131432253));
    this.al = ((TextView)this.d.findViewById(2131432254));
    this.am = ((TextView)this.d.findViewById(2131432249));
    if (!SimpleUIUtil.e())
    {
      this.aj.getPaint().setFakeBoldText(true);
      this.ak.getPaint().setFakeBoldText(true);
      this.al.getPaint().setFakeBoldText(true);
    }
    if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isNowThemeIsDefault(paramAppRuntime, false, null))
    {
      this.aj.setTextColor(-6709582);
      this.ak.setTextColor(-6709582);
      this.al.setTextColor(-6709582);
    }
    else
    {
      this.aj.setTextColor(this.h.getResources().getColor(2131167330));
      this.ak.setTextColor(this.h.getResources().getColor(2131167330));
      this.al.setTextColor(this.h.getResources().getColor(2131167330));
    }
    if (!this.l)
    {
      this.Z.setTextColor(i1);
      this.ae.setTextColor(i1);
      this.ag.setTextColor(i1);
      this.aa.setImageResource(2130847739);
      this.ad.setImageResource(2130847714);
      this.aj.setTextColor(i1);
      this.ak.setTextColor(i1);
      this.al.setTextColor(i1);
      this.am.setTextColor(i1);
    }
    o();
    q();
  }
  
  public static QQSettingMeBizBean a(String paramString)
  {
    QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)an.get(paramString);
    if ((localQQSettingMeBizBean != null) && (localQQSettingMeBizBean.k() != null)) {
      return localQQSettingMeBizBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "getBizBean, bizId:", paramString, ", return null" });
    }
    return null;
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = paramView.getContext();
    float f1 = paramInt;
    localLayoutParams.height = DisplayUtil.a(paramView, f1);
    localLayoutParams.width = DisplayUtil.a(paramView, f1);
  }
  
  private void a(URLImageView paramURLImageView, QQSettingMeBizBean paramQQSettingMeBizBean)
  {
    if (this.l) {
      paramQQSettingMeBizBean = paramQQSettingMeBizBean.d();
    } else {
      paramQQSettingMeBizBean = paramQQSettingMeBizBean.e();
    }
    a(paramURLImageView, paramQQSettingMeBizBean);
  }
  
  private void a(URLImageView paramURLImageView, String paramString)
  {
    if (!URLUtil.e(paramString)) {
      try
      {
        paramURLImageView.setImageDrawable(BaseApplication.getContext().getResources().getDrawable(Integer.parseInt(paramString)));
        return;
      }
      catch (Exception paramURLImageView)
      {
        QLog.e("QQSettingRedesign", 1, new Object[] { "setURLDrawableForMenu, ", paramString, ", ", paramURLImageView });
        return;
      }
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mRequestWidth = paramURLImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramURLImageView.getWidth();
    paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  public static void a(String paramString, int paramInt)
  {
    ao.put(paramString, Integer.valueOf(paramInt));
  }
  
  private void a(String paramString, boolean paramBoolean1, long paramLong, boolean paramBoolean2, int paramInt)
  {
    if (SimpleUIUtil.e())
    {
      this.x.setImageDrawable(null);
      this.x.setVisibility(8);
      return;
    }
    boolean bool = this.m;
    int i1 = 0;
    if ((!bool) && (!paramBoolean1) && (paramBoolean2))
    {
      ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setPlayAnimatinDelay(this.g);
      this.x.setVisibility(0);
      ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setDrawable(this.g, paramLong, this.x, paramString, paramInt);
      QLog.d("drawer_report", 1, "Avatar pendant exposure");
      ReportController.b(this.g, "CliOper", "", "", "AvatarPendant", "choutishow", 0, 0, "", "", "", "");
      paramInt = 1;
    }
    else
    {
      this.x.setImageDrawable(null);
      this.x.setVisibility(8);
      paramInt = i1;
    }
    if ((paramInt != 0) && (this.m)) {
      ReportController.b(this.g, "CliOper", "", "", "0X8006728", "0X8006728", 0, 0, "", "", "", "");
    }
  }
  
  private boolean a(QQSettingMeBizBean paramQQSettingMeBizBean)
  {
    boolean bool2 = true;
    if (paramQQSettingMeBizBean == null) {
      return true;
    }
    int i1;
    if ((!SimpleUIUtil.e()) && (!((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) && (!paramQQSettingMeBizBean.h())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ((SimpleUIUtil.e()) && (!paramQQSettingMeBizBean.i())) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i3;
    if ((((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) && (!paramQQSettingMeBizBean.j())) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    boolean bool1 = bool2;
    if (i1 == 0)
    {
      bool1 = bool2;
      if (i2 == 0)
      {
        bool1 = bool2;
        if (i3 == 0) {
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public static View b(String paramString)
  {
    QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)an.get(paramString);
    if ((localQQSettingMeBizBean != null) && (localQQSettingMeBizBean.k() != null)) {
      return localQQSettingMeBizBean.k().a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "getItemView, bizId:", paramString, ", return null" });
    }
    return null;
  }
  
  private void b(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView = paramView.getLayoutParams();
    paramView.height = paramInt;
    paramView.width = paramInt;
  }
  
  private void b(QQSettingMeSuperMemberPayButtonBean paramQQSettingMeSuperMemberPayButtonBean)
  {
    if ((!TextUtils.isEmpty(paramQQSettingMeSuperMemberPayButtonBean.d.iconText)) && (!TextUtils.isEmpty(paramQQSettingMeSuperMemberPayButtonBean.d.iconUrl)))
    {
      TextView localTextView = (TextView)b("d_vip_identity").findViewById(2131432188);
      localTextView.setOnClickListener(paramQQSettingMeSuperMemberPayButtonBean.f);
      QQSettingMe.8 local8 = new QQSettingMe.8(this, paramQQSettingMeSuperMemberPayButtonBean, localTextView);
      try
      {
        paramQQSettingMeSuperMemberPayButtonBean = new URL(paramQQSettingMeSuperMemberPayButtonBean.d.iconUrl);
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("key_density", 320);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mUseApngImage = true;
        localURLDrawableOptions.mExtraInfo = localObject;
        localObject = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        paramQQSettingMeSuperMemberPayButtonBean = URLDrawable.getDrawable(paramQQSettingMeSuperMemberPayButtonBean, localURLDrawableOptions);
        localTextView.setBackgroundDrawable(paramQQSettingMeSuperMemberPayButtonBean);
        if (paramQQSettingMeSuperMemberPayButtonBean.getStatus() == 1)
        {
          local8.onLoadSuccessed(paramQQSettingMeSuperMemberPayButtonBean);
          return;
        }
        localTextView.setText("");
        paramQQSettingMeSuperMemberPayButtonBean.setURLDrawableListener(local8);
        if (paramQQSettingMeSuperMemberPayButtonBean.getStatus() == 2)
        {
          paramQQSettingMeSuperMemberPayButtonBean.restartDownload();
          return;
        }
      }
      catch (MalformedURLException paramQQSettingMeSuperMemberPayButtonBean)
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler showPayButton: ", paramQQSettingMeSuperMemberPayButtonBean);
      }
      return;
    }
    QLog.e("QQSettingRedesign", 1, "showPayButton: iconText or iconUrl is empty");
  }
  
  private void b(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouch localRedTouch = c(paramString);
    paramString = g(paramString);
    if (localRedTouch != null)
    {
      if (paramString == null) {
        return;
      }
      if (paramAppInfo == null)
      {
        localRedTouch.a((BusinessInfoCheckUpdate.AppInfo)null);
        paramString.setAppInfo(null);
        return;
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo1 = new BusinessInfoCheckUpdate.AppInfo();
      localAppInfo1.set(paramAppInfo);
      BusinessInfoCheckUpdate.AppInfo localAppInfo2 = new BusinessInfoCheckUpdate.AppInfo();
      localAppInfo2.set(paramAppInfo);
      if ((localAppInfo2.iNewFlag.get() != 0) && (localAppInfo2.red_display_info.get() != null) && (localAppInfo2.red_display_info.red_type_info.get() != null))
      {
        Object localObject = new ArrayList(localAppInfo2.red_display_info.red_type_info.get());
        int i1 = ((ArrayList)localObject).size() - 1;
        int i3;
        for (int i2 = 0; i1 >= 0; i2 = i3)
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((ArrayList)localObject).get(i1);
          int i4 = localRedTypeInfo.red_type.get();
          if (i4 == 0) {
            ((ArrayList)localObject).remove(i1);
          }
          for (;;)
          {
            i3 = 1;
            break;
            if ((i4 == 3) && (RedTouchTextView.a(localRedTypeInfo, localAppInfo2)))
            {
              RedTouchTextView.setImageRedNotShowRedPoint(localRedTypeInfo, paramAppInfo);
            }
            else
            {
              i3 = i2;
              if (i4 != 15) {
                break;
              }
              i3 = i2;
              if (!RedTouchTextView.b(localRedTypeInfo, localAppInfo2)) {
                break;
              }
              RedTouchTextView.setDiffImageRedNotShowRedPoint(localRedTypeInfo, paramAppInfo);
            }
          }
          i1 -= 1;
        }
        if (((ArrayList)localObject).size() < 2) {
          ((ArrayList)localObject).clear();
        }
        localAppInfo2.red_display_info.red_type_info.set((List)localObject);
        paramAppInfo = new ArrayList();
        if (i2 != 0)
        {
          localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
          paramAppInfo.add(localObject);
        }
        localAppInfo1.red_display_info.red_type_info.set(paramAppInfo);
        localRedTouch.a(localAppInfo1);
        paramString.setAppInfo(localAppInfo2);
        return;
      }
      localRedTouch.a(localAppInfo1);
      paramString.setAppInfo(localAppInfo2);
    }
  }
  
  private void b(boolean paramBoolean, String paramString)
  {
    if (!AppSetting.e) {
      return;
    }
    if (paramBoolean)
    {
      this.ah.setContentDescription("查看天气");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      localStringBuilder.append("地点：");
      localStringBuilder.append(this.am.getText());
      localStringBuilder.append("，天气：");
      int i1 = -1;
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 49594: 
        if (paramString.equals("208")) {
          i1 = 7;
        }
        break;
      case 49593: 
        if (paramString.equals("207")) {
          i1 = 6;
        }
        break;
      case 49592: 
        if (paramString.equals("206")) {
          i1 = 5;
        }
        break;
      case 49591: 
        if (paramString.equals("205")) {
          i1 = 4;
        }
        break;
      case 49590: 
        if (paramString.equals("204")) {
          i1 = 3;
        }
        break;
      case 49589: 
        if (paramString.equals("203")) {
          i1 = 2;
        }
        break;
      case 49588: 
        if (paramString.equals("202")) {
          i1 = 1;
        }
        break;
      case 49587: 
        if (paramString.equals("201")) {
          i1 = 0;
        }
        break;
      }
      switch (i1)
      {
      default: 
        localStringBuilder.append("未知");
        break;
      case 7: 
        localStringBuilder.append("霾");
        break;
      case 6: 
        localStringBuilder.append("沙尘");
        break;
      case 5: 
        localStringBuilder.append("雾");
        break;
      case 4: 
        localStringBuilder.append("雪");
        break;
      case 3: 
        localStringBuilder.append("雨");
        break;
      case 2: 
        localStringBuilder.append("阴");
        break;
      case 1: 
        localStringBuilder.append("多云");
        break;
      case 0: 
        localStringBuilder.append("晴");
      }
      localStringBuilder.append("，温度：");
      localStringBuilder.append(this.aj.getText());
      localStringBuilder.append("摄氏度");
    }
    this.ah.setContentDescription(localStringBuilder.toString());
  }
  
  public static RedTouch c(String paramString)
  {
    QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)an.get(paramString);
    if ((localQQSettingMeBizBean != null) && (localQQSettingMeBizBean.k() != null)) {
      return localQQSettingMeBizBean.k().b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "getItemRedTouch, bizId:", paramString, ", return null" });
    }
    return null;
  }
  
  private void c(QQSettingMeLevelAndMedalBean paramQQSettingMeLevelAndMedalBean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateMyVipInfo svip= ");
      ((StringBuilder)localObject1).append(paramQQSettingMeLevelAndMedalBean.d);
      ((StringBuilder)localObject1).append(",vip=");
      ((StringBuilder)localObject1).append(paramQQSettingMeLevelAndMedalBean.e);
      ((StringBuilder)localObject1).append(",vipLevel=");
      ((StringBuilder)localObject1).append(paramQQSettingMeLevelAndMedalBean.h);
      QLog.i("QQSettingRedesign", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = b("d_vip_identity");
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131432189);
    Object localObject3 = (URLImageView)((View)localObject1).findViewById(2131432185);
    if (!paramQQSettingMeLevelAndMedalBean.o)
    {
      ((TextView)localObject2).setText(paramQQSettingMeLevelAndMedalBean.a);
      a((URLImageView)localObject3, (QQSettingMeBizBean)an.get("d_vip_identity"));
    }
    boolean bool = TextUtils.isEmpty(paramQQSettingMeLevelAndMedalBean.a);
    int i1 = 0;
    if (!bool) {
      try
      {
        localObject2 = this.g.getApplication().getSharedPreferences("vipTitleSpFile", 0).edit();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("vipTitleSpKey_");
        ((StringBuilder)localObject3).append(this.g.getCurrentAccountUin());
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(LocaleManager.d());
        ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), paramQQSettingMeLevelAndMedalBean.a).commit();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("vipText = ");
          ((StringBuilder)localObject2).append(paramQQSettingMeLevelAndMedalBean.a);
          QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject2).toString());
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQSettingRedesign", 1, "updateMyVipInfo, exception e = ", localException);
      }
    }
    if (a(a("d_vip_identity"))) {
      i1 = 8;
    }
    ((View)localObject1).setVisibility(i1);
    if (AppSetting.e) {
      AccessibilityUtil.a((View)localObject1, paramQQSettingMeLevelAndMedalBean.a, Button.class.getName());
    }
  }
  
  private int d(QQSettingMeLevelAndMedalBean paramQQSettingMeLevelAndMedalBean)
  {
    Object localObject = this.h.getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    float f2 = ((Resources)localObject).getDimension(2131299230);
    float f3 = ((Resources)localObject).getDimension(2131299214) + ((Resources)localObject).getDimension(2131299218) + ((Resources)localObject).getDimension(2131299222) + ((Resources)localObject).getDimension(2131299225) + ((Resources)localObject).getDimension(2131299233);
    float f1 = f3;
    if (paramQQSettingMeLevelAndMedalBean.q) {
      f1 = f3 + Utils.a(42.0F, this.h.getResources()) + ((Resources)localObject).getDimension(2131299232);
    }
    f3 = localDisplayMetrics.widthPixels - f1 - paramQQSettingMeLevelAndMedalBean.l;
    f1 = f2;
    if (f2 <= 1.0F) {
      f1 = 1.0F;
    }
    int i1 = (int)Math.floor(f3 / f1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resizeQQLevelIconSize width=");
      ((StringBuilder)localObject).append(localDisplayMetrics.widthPixels);
      ((StringBuilder)localObject).append(",iconSize=");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(",vipSize=");
      ((StringBuilder)localObject).append(paramQQSettingMeLevelAndMedalBean.l);
      ((StringBuilder)localObject).append(",space=");
      ((StringBuilder)localObject).append(f3);
      ((StringBuilder)localObject).append(",maxIconSize=");
      ((StringBuilder)localObject).append(i1);
      QLog.i("QQSettingRedesign", 4, ((StringBuilder)localObject).toString());
    }
    return i1;
  }
  
  private RedTouchTextView g(String paramString)
  {
    QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)an.get(paramString);
    if ((localQQSettingMeBizBean != null) && (localQQSettingMeBizBean.k() != null)) {
      return localQQSettingMeBizBean.k().c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "getItemRedText, bizId:", paramString, ", return null" });
    }
    return null;
  }
  
  private int h(String paramString)
  {
    QQSettingMeConstant.OpenPageType localOpenPageType = QQSettingMeConstant.OpenPageType.H5_TYPE;
    String str = (String)QQSettingMeConstant.a.get(paramString);
    paramString = localOpenPageType;
    if (((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).isCanOpenHippy(str)) {
      paramString = QQSettingMeConstant.OpenPageType.HIPPY_TYPE;
    }
    return paramString.ordinal();
  }
  
  private void i(String paramString)
  {
    Object localObject1;
    if (this.U == null)
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.S.getLayoutParams();
      this.R.removeView(this.S);
      FrameLayout localFrameLayout = new FrameLayout(this.d.getContext());
      Object localObject2 = new ViewGroup.MarginLayoutParams(-1, -2);
      this.R.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject2);
      localFrameLayout.addView(this.S, (ViewGroup.LayoutParams)localObject1);
      localObject2 = new FrameLayout(this.d.getContext());
      localFrameLayout.addView((View)localObject2, new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams)localObject1));
      this.U = ((ViewGroup)localObject2);
      VideoReport.traversePage(this.R);
    }
    if (this.V == null)
    {
      localObject1 = new TextView(this.d.getContext());
      ((TextView)localObject1).setText(paramString);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(1, 12.0F);
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setBackgroundResource(2130846077);
      paramString = new FrameLayout.LayoutParams(-2, -2);
      this.U.addView((View)localObject1, paramString);
      this.V = ((TextView)localObject1);
      this.V.setVisibility(8);
    }
  }
  
  public static boolean i()
  {
    return i;
  }
  
  private void n()
  {
    boolean bool = QQTheme.isNowSimpleUI();
    int i1 = 0;
    int i2 = 0;
    View localView;
    Object localObject1;
    if (bool)
    {
      i1 = i2;
      while (i1 < this.ap.size())
      {
        localView = (View)this.ap.get(i1);
        localObject1 = (URLImageView)localView.findViewById(2131432185);
        if (localObject1 != null) {
          ((FrameLayout.LayoutParams)((URLImageView)localObject1).getLayoutParams()).gravity = 17;
        }
        a((View)localObject1, 26);
        a(localView.findViewById(2131432187), 16);
        localView.setBackgroundResource(2130852486);
        localView.getLayoutParams().height = DisplayUtil.a(BaseApplication.getContext(), 45.0F);
        i1 += 1;
      }
    }
    while (i1 < this.ap.size())
    {
      localView = (View)this.ap.get(i1);
      localObject1 = (URLImageView)localView.findViewById(2131432185);
      if (localObject1 != null) {
        ((FrameLayout.LayoutParams)((URLImageView)localObject1).getLayoutParams()).gravity = 17;
      }
      a((View)localObject1, 32);
      Object localObject2 = localView.findViewById(2131432187);
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).getLayoutParams();
        localObject2 = ((View)localObject2).getContext();
        ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.a((Context)localObject2, 11.5F);
        ((ViewGroup.LayoutParams)localObject1).width = DisplayUtil.a((Context)localObject2, 7.0F);
      }
      localView.setBackgroundResource(2130847707);
      localView.getLayoutParams().height = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299215);
      i1 += 1;
    }
  }
  
  private void o()
  {
    if (!QQTheme.isNowSimpleUI()) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (localBaseApplication == null) {
      return;
    }
    a(this.aa, 23);
    int i1 = DisplayUtil.a(localBaseApplication, 7.0F);
    this.M.setPadding(i1, i1, i1, i1);
    this.L.setPadding(i1, i1, i1, i1);
    a(this.ad, 23);
    a((ImageView)this.d.findViewById(2131432219), 23);
    this.aj.setTextSize(2, 20.0F);
    Object localObject = (LinearLayout.LayoutParams)this.af.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).gravity = 83;
    this.af.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((RelativeLayout.LayoutParams)this.O.getLayoutParams()).leftMargin = DisplayUtil.a(localBaseApplication, 2.5F);
    localObject = this.d.findViewById(2131432206);
    if (localObject != null) {
      ((RelativeLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = DisplayUtil.a(localBaseApplication, 74.0F);
    }
    this.p.getLayoutParams().height = DisplayUtil.a(localBaseApplication, 155.0F);
    localObject = this.d.findViewById(2131432223);
    if (localObject != null) {
      ((RelativeLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = DisplayUtil.a(localBaseApplication, 80.0F);
    }
    ((RelativeLayout.LayoutParams)this.R.getLayoutParams()).topMargin = 0;
    this.d.findViewById(2131432180).setPadding(DisplayUtil.a(localBaseApplication, 3.0F), 0, 0, 0);
    i1 = DisplayUtil.a(localBaseApplication, 10.0F);
    this.d.setPadding(0, i1, 0, 0);
  }
  
  private void p()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (localBaseApplication == null) {
      return;
    }
    n();
    int i1 = DisplayUtil.a(localBaseApplication, 6.0F);
    this.M.setPadding(i1, i1, i1, i1);
    this.L.setPadding(i1, i1, i1, i1);
    this.aj.setTextSize(2, 22.0F);
    b(this.aa, localBaseApplication.getResources().getDimensionPixelSize(2131299216));
    b(this.ad, localBaseApplication.getResources().getDimensionPixelSize(2131299216));
    b((ImageView)this.d.findViewById(2131432219), localBaseApplication.getResources().getDimensionPixelSize(2131299216));
    b(this.O.findViewById(2131432214), DisplayUtil.a(localBaseApplication, 28.0F));
    i1 = DisplayUtil.a(localBaseApplication, 19.0F);
    Object localObject = this.O;
    ((LinearLayout)localObject).setPadding(i1, ((LinearLayout)localObject).getPaddingTop(), this.O.getPaddingRight(), this.O.getPaddingBottom());
    ((RelativeLayout.LayoutParams)this.O.getLayoutParams()).leftMargin = DisplayUtil.a(localBaseApplication, 0.0F);
    localObject = (LinearLayout.LayoutParams)this.af.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).gravity = 83;
    this.af.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.d.findViewById(2131432206);
    if (localObject != null) {
      ((RelativeLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = DisplayUtil.a(localBaseApplication, 86.0F);
    }
    this.p.getLayoutParams().height = DisplayUtil.a(localBaseApplication, 170.0F);
    localObject = this.d.findViewById(2131432223);
    if (localObject != null) {
      ((RelativeLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = DisplayUtil.a(localBaseApplication, 91.0F);
    }
    ((RelativeLayout.LayoutParams)this.R.getLayoutParams()).topMargin = DisplayUtil.a(localBaseApplication, 20.0F);
    this.d.findViewById(2131432180).setPadding(0, 0, 0, 0);
    this.d.setPadding(0, 0, 0, 0);
  }
  
  private void q()
  {
    this.S.removeAllViews();
    Object localObject1 = (Integer)ao.get("d_profile_bubble");
    if (localObject1 != null)
    {
      this.W = LayoutInflater.from(this.h).inflate(((Integer)localObject1).intValue(), this.S, false);
      this.W.setVisibility(8);
      this.S.addView(this.W);
    }
    this.j.j();
    int i1;
    if (this.l) {
      i1 = this.d.getResources().getColor(2131167330);
    } else {
      i1 = this.d.getResources().getColor(2131167331);
    }
    int i4 = ScreenUtil.dip2px(2.0F);
    an.clear();
    Object localObject3 = (QQSettingMeMenuConfigBean)QConfigManager.b().b(743);
    Object localObject2 = ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getPlateColor("A3");
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QQTheme.isNowThemeIsNight()) {
        i2 = 1996488704;
      } else {
        i2 = 0;
      }
      localObject1 = Integer.valueOf(i2);
    }
    this.ap.clear();
    QQSettingMeBizBean[] arrayOfQQSettingMeBizBean = ((QQSettingMeMenuConfigBean)localObject3).b();
    int i5 = arrayOfQQSettingMeBizBean.length;
    int i2 = 0;
    while (i2 < i5)
    {
      QQSettingMeBizBean localQQSettingMeBizBean = arrayOfQQSettingMeBizBean[i2];
      QQSettingMeItemData localQQSettingMeItemData = new QQSettingMeItemData();
      if (ao.get(localQQSettingMeBizBean.a()) != null)
      {
        localObject2 = ao;
        localObject3 = localQQSettingMeBizBean.a();
      }
      else
      {
        localObject2 = ao;
        localObject3 = "d_common";
      }
      localObject2 = (Integer)((HashMap)localObject2).get(localObject3);
      if (localObject2 != null)
      {
        localObject3 = LayoutInflater.from(this.h).inflate(((Integer)localObject2).intValue(), this.S, false);
        this.S.addView((View)localObject3);
        this.ap.add(localObject3);
        ((View)localObject3).setFocusable(true);
        ((View)localObject3).setOnClickListener(new QQSettingMe.MenuWrapClickListener(localQQSettingMeBizBean.a(), localQQSettingMeBizBean.g(), this, null));
        URLImageView localURLImageView = (URLImageView)((View)localObject3).findViewById(2131432185);
        if (!QQTheme.isNowThemeIsNight()) {
          localURLImageView.setColorFilter(((Integer)localObject1).intValue());
        } else {
          localURLImageView.setColorFilter(new LightingColorFilter(0, Color.parseColor("#999999")));
        }
        a(localURLImageView, localQQSettingMeBizBean);
        RedTouchTextView localRedTouchTextView = (RedTouchTextView)((View)localObject3).findViewById(2131432189);
        if (LocaleManager.b()) {
          localObject2 = localQQSettingMeBizBean.b().b;
        } else {
          localObject2 = localQQSettingMeBizBean.b().a;
        }
        localRedTouchTextView.setText((CharSequence)localObject2);
        if (!this.l) {
          localRedTouchTextView.setTextColor(i1);
        }
        if ((SimpleUIUtil.e()) && ("2920".equals(QQTheme.getCurrentThemeId()))) {
          localRedTouchTextView.setTextColor(this.d.getResources().getColor(2131167329));
        }
        localObject2 = (TextView)((View)localObject3).findViewById(2131432188);
        ((IThemeLabelTextViewApi)QRoute.api(IThemeLabelTextViewApi.class)).setSupportMaskView((View)localObject2, true);
        ((TextView)localObject2).setVisibility(0);
        if (LocaleManager.b()) {
          localObject2 = localQQSettingMeBizBean.b().b;
        } else {
          localObject2 = localQQSettingMeBizBean.b().a;
        }
        AccessibilityUtil.a((View)localObject3, (CharSequence)localObject2, Button.class.getName());
        localURLImageView.setPadding(i4, i4, i4, i4);
        localObject2 = (LinearLayout.LayoutParams)localURLImageView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).leftMargin -= i4;
        localObject2 = (LinearLayout.LayoutParams)localRedTouchTextView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).leftMargin -= i4;
        int i3;
        if (a(localQQSettingMeBizBean)) {
          i3 = 8;
        } else {
          i3 = 0;
        }
        ((View)localObject3).setVisibility(i3);
        localQQSettingMeItemData.a((View)localObject3);
        localQQSettingMeItemData.a(new RedTouch(this.h, localURLImageView).c(8388661).a());
        localQQSettingMeItemData.a(localRedTouchTextView);
        localQQSettingMeBizBean.a(localQQSettingMeItemData);
        an.put(localQQSettingMeBizBean.a(), localQQSettingMeBizBean);
        this.j.b(localQQSettingMeBizBean.a());
      }
      i2 += 1;
    }
    n();
    localObject1 = b("d_lovespace");
    if (localObject1 != null) {
      this.X = ((View)localObject1).findViewById(2131432186);
    }
    localObject1 = this.X;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    this.j.a(this.g, this.h);
    this.j.a(this);
    this.j.b();
  }
  
  private void r()
  {
    Iterator localIterator = an.values().iterator();
    while (localIterator.hasNext())
    {
      QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)localIterator.next();
      if (!TextUtils.isEmpty(localQQSettingMeBizBean.c()))
      {
        VideoReport.setElementId(b(localQQSettingMeBizBean.a()), localQQSettingMeBizBean.c());
        VideoReport.setElementClickPolicy(b(localQQSettingMeBizBean.a()), ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(b(localQQSettingMeBizBean.a()), ExposurePolicy.REPORT_FIRST);
        VideoReport.setElementDynamicParams(b(localQQSettingMeBizBean.a()), new QQSettingMe.2(this, localQQSettingMeBizBean));
      }
    }
    VideoReport.setElementId(this.ah, "em_drawer_weather");
    VideoReport.setElementClickPolicy(this.ah, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.ah, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementId(this.af, "em_drawer_talent");
    VideoReport.setElementClickPolicy(this.af, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.af, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementId(this.O, "em_drawer_sign_up");
    VideoReport.setElementClickPolicy(this.O, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.O, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementId(this.e, "em_drawer_energy_sign");
    VideoReport.setElementClickPolicy(this.e, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.e, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementId(this.D, "em_drawer_qqlevel_sign");
    VideoReport.setElementClickPolicy(this.D, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.D, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementDynamicParams(this.D, new QQSettingMe.3(this));
    VideoReport.setElementId(this.H, "em_drawer_member_sign");
    VideoReport.setElementClickPolicy(this.H, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.H, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementDynamicParams(this.H, new QQSettingMe.4(this));
  }
  
  private void s()
  {
    if (!QQTheme.isNowSimpleUI())
    {
      p();
      return;
    }
    o();
    n();
    LinearLayout localLinearLayout = this.O;
    if (localLinearLayout != null)
    {
      a(localLinearLayout.findViewById(2131432214), 23);
      int i1 = DisplayUtil.a(BaseApplication.getContext(), 16.0F);
      localLinearLayout = this.O;
      localLinearLayout.setPadding(i1, localLinearLayout.getPaddingTop(), this.O.getPaddingRight(), this.O.getPaddingBottom());
    }
  }
  
  private void t()
  {
    Object localObject = b("d_vip_identity");
    if (localObject == null) {
      return;
    }
    localObject = (TextView)((View)localObject).findViewById(2131432188);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setBackgroundDrawable(null);
  }
  
  private void u()
  {
    int i3 = this.h.getBaseContext().getResources().getDimensionPixelSize(2131299233);
    int i2 = this.A.getVisibility();
    int i1 = 0;
    if (i2 == 0) {
      i1 = 0 + ScreenUtil.dip2px(53.0F);
    }
    i2 = i1;
    if (this.z.getVisibility() == 0) {
      i2 = i1 + ScreenUtil.dip2px(35.0F);
    }
    i1 = i2;
    if (this.B.getVisibility() == 0) {
      i1 = i2 + ScreenUtil.dip2px(17.0F);
    }
    this.n = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - i3 - ScreenUtil.dip2px(45.0F) - i1);
    this.y.setMaxWidth(this.n);
  }
  
  private void v()
  {
    int i1 = (int)this.h.getResources().getDimension(2131297305);
    Object localObject = new int[2];
    this.aa.getLocationOnScreen((int[])localObject);
    int i2 = this.Y.getWidth();
    int i3 = this.aa.getWidth();
    if ((i2 != 0) && (i3 != 0))
    {
      i1 -= (i2 - i3) / 2;
    }
    else
    {
      i1 = (int)this.h.getResources().getDimension(2131297310);
      QLog.e("QQSettingRedesign", 1, "setBottomBtnMarginLeft, but getWidth return 0");
    }
    localObject = this.d.findViewById(2131432180).getLayoutParams();
    if ((i1 > 0) && ((localObject instanceof RelativeLayout.LayoutParams)))
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i1;
      this.d.findViewById(2131432180).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setBottomBtnMarginLeft, diffMargin = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void w()
  {
    if (SimpleUIUtil.e())
    {
      this.v.setVisibility(0);
      this.w.setVisibility(0);
      this.u.setVisibility(4);
      this.q = this.w;
      return;
    }
    this.v.setVisibility(8);
    this.w.setVisibility(4);
    this.u.setVisibility(0);
    this.q = this.u;
  }
  
  public QQSettingMeViewModel a()
  {
    return this.j;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.h.getResources();
    Drawable localDrawable = null;
    if (paramInt == 1)
    {
      if (this.l) {
        localDrawable = ((Resources)localObject).getDrawable(2130847715);
      } else {
        localDrawable = ((Resources)localObject).getDrawable(2130847714);
      }
      localObject = ((Resources)localObject).getString(2131897267);
    }
    else if (paramInt == 2)
    {
      if (this.l) {
        localDrawable = ((Resources)localObject).getDrawable(2130847715);
      } else {
        localDrawable = ((Resources)localObject).getDrawable(2130847714);
      }
      localObject = ((Resources)localObject).getString(2131897267);
    }
    else
    {
      localObject = null;
    }
    if (localDrawable != null) {
      this.ad.setImageDrawable(localDrawable);
    }
    if (localObject != null)
    {
      this.ae.setText((CharSequence)localObject);
      this.f.setOnClickListener(this);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.j.f();
  }
  
  public void a(QQSettingMeAvatarRedTouchBean paramQQSettingMeAvatarRedTouchBean)
  {
    try
    {
      if (paramQQSettingMeAvatarRedTouchBean.c != null) {
        this.q.a(paramQQSettingMeAvatarRedTouchBean.c);
      } else {
        this.q.a(paramQQSettingMeAvatarRedTouchBean.b);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    boolean bool = this.m;
    this.m = this.q.h();
    if (QLog.isColorLevel()) {
      QLog.d("LocalRedTouchManager", 2, new Object[] { "updateHeadIcon, old:", Boolean.valueOf(bool), " new:", Boolean.valueOf(this.m), ",profileRedTypeInfo = ", paramQQSettingMeAvatarRedTouchBean.c, ",profileAppinfo = ", paramQQSettingMeAvatarRedTouchBean.b });
    }
    if (bool != this.m) {
      a(paramQQSettingMeAvatarRedTouchBean.g, paramQQSettingMeAvatarRedTouchBean.d, paramQQSettingMeAvatarRedTouchBean.e, paramQQSettingMeAvatarRedTouchBean.f, paramQQSettingMeAvatarRedTouchBean.h);
    }
  }
  
  public void a(QQSettingMeAvatarViewBean paramQQSettingMeAvatarViewBean)
  {
    String str = this.g.getCurrentUin();
    ((IAvatarLayoutApi)QRoute.api(IAvatarLayoutApi.class)).setFaceDrawable(this.s, (AppInterface)this.g, paramQQSettingMeAvatarViewBean.a, str, true, true);
    this.r.setVisibility(((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getStrokeVisible(str, this.g));
    a(paramQQSettingMeAvatarViewBean.e, paramQQSettingMeAvatarViewBean.b, paramQQSettingMeAvatarViewBean.c, paramQQSettingMeAvatarViewBean.d, paramQQSettingMeAvatarViewBean.f);
    if (QLog.isDevelopLevel())
    {
      paramQQSettingMeAvatarViewBean = new StringBuilder();
      paramQQSettingMeAvatarViewBean.append("updateFace, ");
      paramQQSettingMeAvatarViewBean.append(str);
      QLog.i("QQSettingRedesign", 4, paramQQSettingMeAvatarViewBean.toString());
    }
  }
  
  public void a(QQSettingMeDailyBean paramQQSettingMeDailyBean)
  {
    int i1 = this.h.getBaseContext().getResources().getDimensionPixelSize(2131299233);
    int i2 = ScreenUtil.SCREEN_WIDTH;
    int i3 = ScreenUtil.dip2px(65.0F);
    int i4 = ScreenUtil.dip2px(15.0F);
    int i5 = this.M.getWidth();
    this.O.setVisibility(0);
    Drawable localDrawable = this.h.getResources().getDrawable(2130847744);
    URLImageView localURLImageView = (URLImageView)this.O.findViewById(2131432214);
    if (!QQTheme.isNowSimpleUI())
    {
      Object localObject1;
      Object localObject3;
      if ((!TextUtils.isEmpty(paramQQSettingMeDailyBean.c)) && (!TextUtils.isEmpty(paramQQSettingMeDailyBean.d)))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = 56;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = 56;
        localObject3 = ((ICardCatcher)this.j.a("d_head_vip")).a();
        if ((localObject3 != null) && ((((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).checkUsePersonalCard(this.g, (Card)localObject3)) || (!((Card)localObject3).isNoCover()))) {
          localObject3 = URLDrawable.getDrawable(paramQQSettingMeDailyBean.d, (URLDrawable.URLDrawableOptions)localObject1);
        } else {
          localObject3 = URLDrawable.getDrawable(paramQQSettingMeDailyBean.c, (URLDrawable.URLDrawableOptions)localObject1);
        }
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("use custom icon=");
          ((StringBuilder)localObject1).append(paramQQSettingMeDailyBean.c);
          QLog.i("DailySignIn", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject3;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use default icon");
        }
        localObject3 = (IThemeUtilApi)QRoute.api(IThemeUtilApi.class);
        AppRuntime localAppRuntime = this.g;
        Object localObject4 = null;
        localObject1 = localDrawable;
        if (((IThemeUtilApi)localObject3).isNowThemeIsDefault(localAppRuntime, true, null))
        {
          try
          {
            localObject3 = BitmapFactory.decodeResource(this.h.getResources(), 2130847744);
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localObject3 = localObject4;
            if (QLog.isColorLevel())
            {
              QLog.d("QQSettingRedesign", 2, localOutOfMemoryError, new Object[0]);
              localObject3 = localObject4;
            }
          }
          localObject2 = localDrawable;
          if (localObject3 != null) {
            localObject2 = new BitmapDrawable(this.h.getResources(), BitmapUtil.a((Bitmap)localObject3));
          }
        }
      }
    }
    else
    {
      a(localURLImageView, 22);
      localObject2 = localDrawable;
    }
    localURLImageView.setImageDrawable((Drawable)localObject2);
    Object localObject2 = this.Q;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setMaxWidth(i2 - i1 - i3 - (i4 + i5));
      this.Q.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.Q.setText(paramQQSettingMeDailyBean.e);
    }
    else
    {
      QLog.e("QQSettingRedesign", 1, "mSignInWord===null");
    }
    this.P.g();
  }
  
  public void a(QQSettingMeDocumentBean paramQQSettingMeDocumentBean)
  {
    View localView = b("d_tencent_document");
    if (localView == null) {
      return;
    }
    int i1;
    if ((paramQQSettingMeDocumentBean.a) && (!a(a("d_tencent_document")))) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
    if (!paramQQSettingMeDocumentBean.a) {
      return;
    }
    TextView localTextView = (TextView)localView.findViewById(2131432189);
    if (!TextUtils.isEmpty(paramQQSettingMeDocumentBean.c)) {
      localTextView.setText(paramQQSettingMeDocumentBean.c);
    }
    if ((!TextUtils.isEmpty(paramQQSettingMeDocumentBean.b)) && (QQTheme.isDefaultTheme())) {
      try
      {
        a((URLImageView)localView.findViewById(2131432185), paramQQSettingMeDocumentBean.b);
      }
      catch (Exception paramQQSettingMeDocumentBean)
      {
        QLog.e("QQSettingRedesign", 1, "set tencent_doc URL Drawable failed ", paramQQSettingMeDocumentBean);
      }
    }
    ReportController.b(this.g, "CliOper", "", "", "0X800887D", "0X800887D", 0, 0, "", "", "", "");
  }
  
  public void a(QQSettingMeDynamicItemBean paramQQSettingMeDynamicItemBean)
  {
    QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)an.get(paramQQSettingMeDynamicItemBean.a);
    if (localQQSettingMeBizBean == null) {
      return;
    }
    View localView = localQQSettingMeBizBean.l();
    if (localView == null) {
      return;
    }
    TextView localTextView = (TextView)localView.findViewById(2131432189);
    if (!TextUtils.isEmpty(paramQQSettingMeDynamicItemBean.b))
    {
      localTextView.setText(paramQQSettingMeDynamicItemBean.b);
    }
    else
    {
      if (LocaleManager.b()) {
        localObject = localQQSettingMeBizBean.b().b;
      } else {
        localObject = localQQSettingMeBizBean.b().a;
      }
      localTextView.setText((CharSequence)localObject);
    }
    AccessibilityUtil.a(localView, localTextView.getText(), Button.class.getName());
    Object localObject = (URLImageView)localView.findViewById(2131432185);
    if (paramQQSettingMeDynamicItemBean.c == null)
    {
      a((URLImageView)localObject, localQQSettingMeBizBean);
      return;
    }
    if (!QQTheme.isNowSimpleUI()) {
      if (paramQQSettingMeDynamicItemBean.c != null)
      {
        ((URLImageView)localObject).setImageDrawable(paramQQSettingMeDynamicItemBean.c);
        if (QQTheme.isNowThemeIsNight()) {
          ((URLImageView)localObject).setColorFilter(1996488704);
        }
      }
      else
      {
        if (this.l) {
          paramQQSettingMeDynamicItemBean = localQQSettingMeBizBean.d();
        } else {
          paramQQSettingMeDynamicItemBean = localQQSettingMeBizBean.e();
        }
        ((URLImageView)localObject).setImageResource(Integer.parseInt(paramQQSettingMeDynamicItemBean));
      }
    }
    ((URLImageView)localObject).setColorFilter(0);
  }
  
  public void a(QQSettingMeFileBean paramQQSettingMeFileBean)
  {
    if (b("d_document") == null) {
      return;
    }
    boolean bool = QLog.isColorLevel();
    int i2 = 0;
    if (bool) {
      QLog.i("QQSettingRedesign", 2, String.format(Locale.CHINA, "updateFace2FaceGuide switch_hasShowed = %d_%b", new Object[] { Integer.valueOf(paramQQSettingMeFileBean.a), Boolean.valueOf(paramQQSettingMeFileBean.c) }));
    }
    int i1 = i2;
    if (paramQQSettingMeFileBean.a == 1)
    {
      i1 = i2;
      if (!paramQQSettingMeFileBean.c) {
        i1 = 1;
      }
    }
    TextView localTextView;
    if (i1 == 0)
    {
      localTextView = this.V;
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        return;
      }
    }
    if (i1 != 0)
    {
      localTextView = this.V;
      if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
        return;
      }
      i(paramQQSettingMeFileBean.b);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new QQSettingMe.6(this), 50L);
    }
  }
  
  public void a(QQSettingMeKingCardBean paramQQSettingMeKingCardBean)
  {
    View localView = b("d_vip_card");
    if (localView == null) {
      return;
    }
    int i1;
    if ((paramQQSettingMeKingCardBean.a) && (!a(a("d_vip_card")))) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
    if (!paramQQSettingMeKingCardBean.a) {
      return;
    }
    if (!LocaleManager.a()) {
      return;
    }
    if (!paramQQSettingMeKingCardBean.d)
    {
      TextView localTextView = (TextView)localView.findViewById(2131432189);
      localTextView.setText(paramQQSettingMeKingCardBean.b);
      localTextView.setContentDescription(paramQQSettingMeKingCardBean.b);
      a((URLImageView)localView.findViewById(2131432185), (QQSettingMeBizBean)an.get("d_vip_card"));
    }
    AccessibilityUtil.a(localView, paramQQSettingMeKingCardBean.b, Button.class.getName());
  }
  
  public void a(QQSettingMeLevelAndMedalBean paramQQSettingMeLevelAndMedalBean)
  {
    for (;;)
    {
      try
      {
        if ((paramQQSettingMeLevelAndMedalBean.b != null) && (this.h != null) && (this.A != null) && (this.B != null))
        {
          localObject1 = new SpannableStringBuilder();
          Object localObject2 = this.h.getResources();
          this.A.setVisibility(8);
          this.B.setVisibility(8);
          if (((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).isBigVipClub(paramQQSettingMeLevelAndMedalBean.b.nameplateVipType)) {
            ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setVipExtIcon(this.h, this.B, paramQQSettingMeLevelAndMedalBean.b.nameplateExtId);
          }
          if ((!paramQQSettingMeLevelAndMedalBean.i) && (paramQQSettingMeLevelAndMedalBean.g == ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getQQBigMemberId()) && (paramQQSettingMeLevelAndMedalBean.f) && (paramQQSettingMeLevelAndMedalBean.n >> 8 == 3)) {
            ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setVipExtIcon(this.h, this.B, paramQQSettingMeLevelAndMedalBean.b.nameplateExtId);
          }
          if ((paramQQSettingMeLevelAndMedalBean.j != null) && (paramQQSettingMeLevelAndMedalBean.k != 0))
          {
            ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setVipCardDrawable(this.h.getResources(), this.A, paramQQSettingMeLevelAndMedalBean.j, this.h.getResources().getDrawable(paramQQSettingMeLevelAndMedalBean.k));
            this.A.setVisibility(0);
            this.A.setContentDescription(HardCodeUtil.a(2131913733));
            this.A.setFocusableInTouchMode(true);
            this.A.setOnTouchListener(((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).headVipReport(this.g, paramQQSettingMeLevelAndMedalBean.b.uin));
          }
          else
          {
            this.A.setOnTouchListener(null);
          }
          u();
          if (paramQQSettingMeLevelAndMedalBean.p)
          {
            URLDrawable localURLDrawable = ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getGameCardIcon(this.C, paramQQSettingMeLevelAndMedalBean.b.namePlateOfKingGameId, paramQQSettingMeLevelAndMedalBean.b.namePlateOfKingDan, paramQQSettingMeLevelAndMedalBean.b.namePlateOfKingDanDisplatSwitch, paramQQSettingMeLevelAndMedalBean.b.gameCardId);
            this.C.setImageDrawable(localURLDrawable);
          }
          else
          {
            this.C.setVisibility(8);
          }
          if (QQTheme.isNowSimpleUI())
          {
            this.H.setVisibility(8);
            this.F.setVisibility(8);
            this.G.setVisibility(8);
          }
          else if ((paramQQSettingMeLevelAndMedalBean.c != null) && (paramQQSettingMeLevelAndMedalBean.c.infoList.size() > 0))
          {
            ((IQVipMedalViewApi)QRoute.api(IQVipMedalViewApi.class)).setData(this.H, paramQQSettingMeLevelAndMedalBean.c);
            this.H.setVisibility(0);
            this.G.setVisibility(0);
            if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isNowThemeIsDefault(this.g, true, null)) {
              this.F.setBackgroundColor(Color.parseColor("#7bffffff"));
            } else {
              this.F.setBackgroundColor(this.h.getResources().getColor(2131167334));
            }
          }
          else
          {
            this.H.setVisibility(8);
            this.F.setVisibility(8);
            this.G.setVisibility(8);
          }
          ((SpannableStringBuilder)localObject1).append(((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).parseQQLevel((Resources)localObject2, paramQQSettingMeLevelAndMedalBean.m, paramQQSettingMeLevelAndMedalBean.b.iQQLevel, d(paramQQSettingMeLevelAndMedalBean)));
          ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setTextForAnimation(this.D, (SpannableStringBuilder)localObject1, TextView.BufferType.SPANNABLE);
          localObject1 = this.D;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("等级：");
          ((StringBuilder)localObject2).append(paramQQSettingMeLevelAndMedalBean.b.iQQLevel);
          ((TextView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
          c(paramQQSettingMeLevelAndMedalBean);
          if (AppSetting.e)
          {
            localObject2 = new StringBuilder(this.y.getText());
            if (paramQQSettingMeLevelAndMedalBean.d)
            {
              localObject1 = "你是尊贵的超级会员";
            }
            else
            {
              if (!paramQQSettingMeLevelAndMedalBean.e) {
                break label800;
              }
              localObject1 = "你是尊贵的会员";
            }
            ((StringBuilder)localObject2).append((String)localObject1);
            if (paramQQSettingMeLevelAndMedalBean.b.iQQLevel > 0)
            {
              ((StringBuilder)localObject2).append(" 等级");
              ((StringBuilder)localObject2).append(paramQQSettingMeLevelAndMedalBean.b.iQQLevel);
            }
            this.p.setContentDescription(((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "updateQQLevelVipView card == null");
          }
          return;
        }
      }
      catch (Throwable paramQQSettingMeLevelAndMedalBean)
      {
        paramQQSettingMeLevelAndMedalBean.printStackTrace();
      }
      return;
      label800:
      Object localObject1 = "";
    }
  }
  
  public void a(QQSettingMeMiniGameBean paramQQSettingMeMiniGameBean)
  {
    Object localObject = b("d_minigame");
    if (localObject == null) {
      return;
    }
    int i1;
    if ((paramQQSettingMeMiniGameBean.a == 0) && (!a(a("d_minigame")))) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((View)localObject).setVisibility(i1);
    URLImageView localURLImageView = (URLImageView)((View)localObject).findViewById(2131432185);
    localObject = (TextView)((View)localObject).findViewById(2131432189);
    try
    {
      if ((!TextUtils.isEmpty(paramQQSettingMeMiniGameBean.b)) && (QQTheme.isDefaultTheme())) {
        a(localURLImageView, paramQQSettingMeMiniGameBean.b);
      }
      if (!TextUtils.isEmpty(paramQQSettingMeMiniGameBean.c))
      {
        ((TextView)localObject).setText(paramQQSettingMeMiniGameBean.c);
        return;
      }
    }
    catch (Exception paramQQSettingMeMiniGameBean)
    {
      QLog.e("QQSettingRedesign", 1, "set URL Drawable failed ", paramQQSettingMeMiniGameBean);
    }
  }
  
  public void a(QQSettingMeNicknameBean paramQQSettingMeNicknameBean)
  {
    if (TextUtils.isEmpty(this.g.getCurrentAccountUin()))
    {
      ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setImageDrawableForDynamic(this.t, paramQQSettingMeNicknameBean.b);
      this.y.setText("");
      this.y.setCompoundDrawables(null, null, null, null);
      this.D.setText("");
      this.A.setVisibility(8);
      this.B.setVisibility(8);
      this.z.setVisibility(8);
      return;
    }
    this.j.a("d_avatar").i();
    this.y.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    if (this.y.getTop() > this.M.getBottom()) {
      this.y.setMaxWidth(this.n - this.M.getWidth());
    } else {
      this.y.setMaxWidth(this.n);
    }
    if (!Utils.a(paramQQSettingMeNicknameBean.a, this.y.getText())) {
      this.y.setText(paramQQSettingMeNicknameBean.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from updateAccountInfo");
    }
    this.j.a("d_head_vip").i();
    if (AppSetting.e) {
      this.p.setContentDescription(this.y.getText());
    }
  }
  
  public void a(QQSettingMePrettyNumBean paramQQSettingMePrettyNumBean)
  {
    this.z.setVisibility(8);
    if (!paramQQSettingMePrettyNumBean.a) {
      return;
    }
    if (paramQQSettingMePrettyNumBean.b == null) {
      return;
    }
    if (paramQQSettingMePrettyNumBean.c == null) {
      return;
    }
    this.z.setVisibility(0);
    this.z.setImageDrawable(paramQQSettingMePrettyNumBean.c);
    if (paramQQSettingMePrettyNumBean.d) {
      this.z.setColorFilter(1996488704);
    } else {
      this.z.setColorFilter(0);
    }
    this.z.setOnClickListener(new QQSettingMe.9(this));
    u();
  }
  
  public void a(QQSettingMeProfileBubbleBean paramQQSettingMeProfileBubbleBean)
  {
    if ((paramQQSettingMeProfileBubbleBean.a) && (paramQQSettingMeProfileBubbleBean.c != null))
    {
      QLog.d("QQSettingRedesign", 1, new Object[] { "updateProfileBubbleMsgView ", Integer.valueOf(paramQQSettingMeProfileBubbleBean.b) });
      long l1;
      if (paramQQSettingMeProfileBubbleBean.c.uint64_from_uin.has()) {
        l1 = paramQQSettingMeProfileBubbleBean.c.uint64_from_uin.get();
      } else {
        l1 = 0L;
      }
      View localView1 = this.W.findViewById(2131432204);
      ImageView localImageView = (ImageView)this.W.findViewById(2131432202);
      TextView localTextView = (TextView)this.W.findViewById(2131432203);
      View localView2 = this.W.findViewById(2131432201);
      if (QQTheme.isNowThemeIsNight()) {
        localView1.setBackgroundResource(2130847718);
      } else {
        localView1.setBackgroundResource(2130847717);
      }
      if (l1 == 111L)
      {
        localImageView.setImageDrawable(this.h.getResources().getDrawable(2130847386));
      }
      else
      {
        Drawable localDrawable = paramQQSettingMeProfileBubbleBean.e;
        Object localObject = (IFaceDrawableApi)QRoute.api(IFaceDrawableApi.class);
        AppInterface localAppInterface = (AppInterface)this.g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l1);
        localStringBuilder.append("");
        localDrawable = ((IFaceDrawableApi)localObject).getFaceDrawable(localAppInterface, localStringBuilder.toString(), localDrawable, localDrawable);
        localObject = localImageView.getDrawable();
        ((IFaceDrawableApi)QRoute.api(IFaceDrawableApi.class)).cancelFaceDrawable(localDrawable, (Drawable)localObject);
        localImageView.setImageDrawable(localDrawable);
      }
      paramQQSettingMeProfileBubbleBean = this.h.getResources().getString(2131897249, new Object[] { Integer.valueOf(paramQQSettingMeProfileBubbleBean.b) });
      if (!paramQQSettingMeProfileBubbleBean.equalsIgnoreCase(localTextView.getText().toString())) {
        localTextView.setText(paramQQSettingMeProfileBubbleBean);
      }
      localView1.setContentDescription(paramQQSettingMeProfileBubbleBean);
      localView1.setOnTouchListener(new QQSettingMe.7(this, localImageView, localTextView, localView2));
      localView1.setOnClickListener(this);
      this.W.setVisibility(0);
      return;
    }
    this.W.setVisibility(8);
    ((ImageView)this.W.findViewById(2131432202)).setImageDrawable(null);
  }
  
  @TargetApi(9)
  public void a(QQSettingMeRichStatusBean paramQQSettingMeRichStatusBean)
  {
    ImageView localImageView1 = (ImageView)this.J.findViewById(2131432240);
    TextView localTextView = (TextView)this.J.findViewById(2131432241);
    ImageView localImageView2 = (ImageView)this.J.findViewById(2131432228);
    localImageView2.setColorFilter(localTextView.getCurrentTextColor());
    localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    localTextView.setMaxWidth(this.o);
    Object localObject1 = this.g.getApp();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("qqsettingme_signature");
    localStringBuilder1.append(this.g.getAccount());
    SharedPreferences.Editor localEditor = ((BaseApplication)localObject1).getSharedPreferences(localStringBuilder1.toString(), 0).edit();
    StringBuilder localStringBuilder2 = new StringBuilder(100);
    if ((paramQQSettingMeRichStatusBean.a != null) && (!TextUtils.isEmpty(paramQQSettingMeRichStatusBean.a.actionText)))
    {
      localImageView1.setImageBitmap(paramQQSettingMeRichStatusBean.b);
      localImageView1.setVisibility(0);
      localStringBuilder2.append(paramQQSettingMeRichStatusBean.a.actionText);
      if (!TextUtils.isEmpty(paramQQSettingMeRichStatusBean.a.dataText)) {
        localStringBuilder2.append(paramQQSettingMeRichStatusBean.a.dataText);
      }
      localStringBuilder2.append(' ');
      localEditor.putInt("actionId", paramQQSettingMeRichStatusBean.a.actionId);
      localEditor.putString("actionText", paramQQSettingMeRichStatusBean.a.actionText);
      localEditor.putString("dataText", paramQQSettingMeRichStatusBean.a.dataText);
    }
    else
    {
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130847722);
      localImageView1.setVisibility(8);
    }
    if (paramQQSettingMeRichStatusBean.a != null)
    {
      boolean bool = paramQQSettingMeRichStatusBean.a.hasTopic();
      Object localObject2 = null;
      localStringBuilder1 = null;
      if (bool)
      {
        if (paramQQSettingMeRichStatusBean.a.shouldShowAtHead())
        {
          localObject1 = paramQQSettingMeRichStatusBean.a.topicToPlainText();
          localStringBuilder2.append((String)localObject1);
          localEditor.putString("topics", (String)localObject1);
          localObject1 = localStringBuilder1;
          if (paramQQSettingMeRichStatusBean.a.plainText != null)
          {
            localObject1 = localStringBuilder1;
            if (paramQQSettingMeRichStatusBean.a.plainText.size() > 0) {
              localObject1 = (String)paramQQSettingMeRichStatusBean.a.plainText.get(0);
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localStringBuilder2.append((String)localObject1);
          }
          localEditor.putString("plainText", (String)localObject1);
        }
        if (paramQQSettingMeRichStatusBean.a.shouldShowMixing())
        {
          paramQQSettingMeRichStatusBean = paramQQSettingMeRichStatusBean.a.getPlainText();
          localStringBuilder2.append(paramQQSettingMeRichStatusBean);
          localEditor.putString("plainMixTopic", paramQQSettingMeRichStatusBean);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (paramQQSettingMeRichStatusBean.a.plainText != null)
        {
          localObject1 = localObject2;
          if (paramQQSettingMeRichStatusBean.a.plainText.size() > 0) {
            localObject1 = (String)paramQQSettingMeRichStatusBean.a.plainText.get(0);
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localStringBuilder2.append((String)localObject1);
        }
        localEditor.putString("plainText", (String)localObject1);
      }
    }
    localEditor.apply();
    paramQQSettingMeRichStatusBean = localStringBuilder2.toString();
    if (TextUtils.isEmpty(paramQQSettingMeRichStatusBean))
    {
      localTextView.setText(2131897237);
      localImageView2.setVisibility(0);
    }
    else
    {
      localImageView2.setVisibility(0);
      if (DeviceInfoUtil.z())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramQQSettingMeRichStatusBean);
        ((StringBuilder)localObject1).append(" ");
        localTextView.setText(new QQText(((StringBuilder)localObject1).toString(), 1, 16));
      }
      else
      {
        localTextView.setText(new QQText(paramQQSettingMeRichStatusBean, 1, 16));
      }
    }
    if (AppSetting.e)
    {
      localObject1 = this.J;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("个性签名");
      localStringBuilder1.append(paramQQSettingMeRichStatusBean);
      ((View)localObject1).setContentDescription(localStringBuilder1.toString());
    }
    if (SimpleUIUtil.e()) {
      localImageView1.setVisibility(8);
    }
  }
  
  public void a(QQSettingMeSettingBean paramQQSettingMeSettingBean)
  {
    boolean bool2 = paramQQSettingMeSettingBean.b;
    RedDotTextView localRedDotTextView = this.ac;
    if (localRedDotTextView != null) {
      localRedDotTextView.a(paramQQSettingMeSettingBean.b);
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (paramQQSettingMeSettingBean.c)
      {
        bool2 = true;
        localRedDotTextView = this.ac;
        bool1 = bool2;
        if (localRedDotTextView != null)
        {
          localRedDotTextView.a(true);
          bool1 = bool2;
        }
      }
    }
    if (!bool1) {
      this.ab.c(paramQQSettingMeSettingBean.a);
    }
  }
  
  public void a(QQSettingMeShoppingBean paramQQSettingMeShoppingBean)
  {
    Object localObject1 = b("d_qq_shopping");
    if (localObject1 == null) {
      return;
    }
    int i1;
    if ((paramQQSettingMeShoppingBean.a) && (!a(a("d_qq_shopping")))) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((View)localObject1).setVisibility(i1);
    if (!paramQQSettingMeShoppingBean.a) {
      return;
    }
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131432189);
    if (!TextUtils.isEmpty(paramQQSettingMeShoppingBean.b)) {
      ((TextView)localObject2).setText(paramQQSettingMeShoppingBean.b);
    }
    localObject1 = (URLImageView)((View)localObject1).findViewById(2131432185);
    if (!TextUtils.isEmpty(paramQQSettingMeShoppingBean.c))
    {
      localObject2 = ((IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class)).getApngURLDrawable(paramQQSettingMeShoppingBean.c, new ColorDrawable(0), null, null);
      if (localObject2 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateShoppingItemView:");
      ((StringBuilder)localObject1).append(paramQQSettingMeShoppingBean.b);
      ((StringBuilder)localObject1).append("  ");
      ((StringBuilder)localObject1).append(paramQQSettingMeShoppingBean.c);
      QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(QQSettingMeSignatureBean paramQQSettingMeSignatureBean)
  {
    ImageView localImageView = (ImageView)this.J.findViewById(2131432240);
    Object localObject1 = (TextView)this.J.findViewById(2131432241);
    Object localObject2 = (ImageView)this.J.findViewById(2131432228);
    ((ImageView)localObject2).setColorFilter(((TextView)localObject1).getCurrentTextColor());
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    ((TextView)localObject1).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    ((TextView)localObject1).setMaxWidth(this.o);
    if (QLog.isColorLevel())
    {
      String str1 = paramQQSettingMeSignatureBean.b;
      int i1 = paramQQSettingMeSignatureBean.a;
      String str2 = paramQQSettingMeSignatureBean.c;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" plainText = ");
      localStringBuilder2.append(paramQQSettingMeSignatureBean.e);
      QLog.d("QQSettingRedesign", 2, new Object[] { "preLoadSignature, actionText = ", str1, " actionId = ", Integer.valueOf(i1), " dataText = ", str2, localStringBuilder2.toString() });
    }
    if (!TextUtils.isEmpty(paramQQSettingMeSignatureBean.b))
    {
      localImageView.setImageBitmap(paramQQSettingMeSignatureBean.g);
      localImageView.setVisibility(0);
      localStringBuilder1.append(paramQQSettingMeSignatureBean.b);
      if (!TextUtils.isEmpty(paramQQSettingMeSignatureBean.c)) {
        localStringBuilder1.append(paramQQSettingMeSignatureBean.c);
      }
      localStringBuilder1.append(' ');
    }
    else
    {
      localImageView.setBackgroundResource(0);
      localImageView.setPadding(0, 0, 0, 0);
      localImageView.setImageResource(2130847722);
      localImageView.setVisibility(8);
    }
    if (TextUtils.isEmpty(paramQQSettingMeSignatureBean.f))
    {
      if (!TextUtils.isEmpty(paramQQSettingMeSignatureBean.d)) {
        localStringBuilder1.append(paramQQSettingMeSignatureBean.d);
      }
      if (!TextUtils.isEmpty(paramQQSettingMeSignatureBean.e)) {
        localStringBuilder1.append(paramQQSettingMeSignatureBean.e);
      }
    }
    else
    {
      localStringBuilder1.append(paramQQSettingMeSignatureBean.f);
    }
    paramQQSettingMeSignatureBean = localStringBuilder1.toString();
    if (TextUtils.isEmpty(paramQQSettingMeSignatureBean))
    {
      ((TextView)localObject1).setText(2131897237);
      ((ImageView)localObject2).setVisibility(0);
    }
    else
    {
      ((ImageView)localObject2).setVisibility(0);
      if (DeviceInfoUtil.z())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramQQSettingMeSignatureBean);
        ((StringBuilder)localObject2).append(" ");
        ((TextView)localObject1).setText(new QQText(((StringBuilder)localObject2).toString(), 1, 16));
      }
      else
      {
        ((TextView)localObject1).setText(new QQText(paramQQSettingMeSignatureBean, 1, 16));
      }
    }
    if (AppSetting.e)
    {
      localObject1 = this.J;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("个性签名");
      ((StringBuilder)localObject2).append(paramQQSettingMeSignatureBean);
      ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    }
    if (SimpleUIUtil.e()) {
      localImageView.setVisibility(8);
    }
  }
  
  public void a(QQSettingMeSuperMemberPayButtonBean paramQQSettingMeSuperMemberPayButtonBean)
  {
    try
    {
      if (paramQQSettingMeSuperMemberPayButtonBean.e) {
        b(paramQQSettingMeSuperMemberPayButtonBean);
      } else {
        t();
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
      localAppInfo.set(paramQQSettingMeSuperMemberPayButtonBean.a);
      if ((paramQQSettingMeSuperMemberPayButtonBean.e) && (RedTouchTextView.a(localAppInfo) != null))
      {
        paramQQSettingMeSuperMemberPayButtonBean = new ArrayList();
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(0);
        paramQQSettingMeSuperMemberPayButtonBean.add(localRedTypeInfo);
        localAppInfo.red_display_info.red_type_info.set(paramQQSettingMeSuperMemberPayButtonBean);
      }
      b("d_vip_identity", localAppInfo);
      return;
    }
    catch (Exception paramQQSettingMeSuperMemberPayButtonBean)
    {
      QLog.e("QQSettingRedesign", 1, "updateSuperMemberItemView: ", paramQQSettingMeSuperMemberPayButtonBean);
    }
  }
  
  public void a(QQSettingMeWeatherBean paramQQSettingMeWeatherBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "updateWeatherView cur_temp:", paramQQSettingMeWeatherBean.a, ",cur_areainfo", paramQQSettingMeWeatherBean.b, ",cur_adcode:", Integer.valueOf(paramQQSettingMeWeatherBean.c), ",o_wea_code", paramQQSettingMeWeatherBean.d, ",show_flag:", Boolean.valueOf(paramQQSettingMeWeatherBean.e) });
    }
    if (!paramQQSettingMeWeatherBean.e)
    {
      this.ah.setVisibility(8);
      this.ah.setClickable(false);
      this.am.setVisibility(4);
      return;
    }
    if ((!TextUtils.isEmpty(paramQQSettingMeWeatherBean.a)) && (!TextUtils.isEmpty(paramQQSettingMeWeatherBean.b)))
    {
      this.ah.setVisibility(0);
      this.am.setVisibility(0);
      this.ah.setClickable(true);
      this.aj.setText(paramQQSettingMeWeatherBean.a);
      localObject = paramQQSettingMeWeatherBean.b.split("-");
      localTextView = this.am;
      if (localObject.length == 2) {
        localObject = localObject[1];
      } else {
        localObject = localObject[0];
      }
      localTextView.setText((CharSequence)localObject);
    }
    try
    {
      localObject = URLEncoder.encode(paramQQSettingMeWeatherBean.b, "utf-8");
    }
    catch (Exception localException)
    {
      label232:
      StringBuilder localStringBuilder;
      break label232;
    }
    Object localObject = paramQQSettingMeWeatherBean.b;
    TextView localTextView = this.am;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("&city=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&adcode=");
    localStringBuilder.append(paramQQSettingMeWeatherBean.c);
    localTextView.setTag(localStringBuilder.toString());
    this.al.setText("o");
    a(paramQQSettingMeWeatherBean.f, paramQQSettingMeWeatherBean.a);
    b(paramQQSettingMeWeatherBean.f, paramQQSettingMeWeatherBean.d);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null) {
      this.N.a(paramAppInfo);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if (ImmersiveUtils.isSupporImmersive() == 0) {
      return;
    }
    boolean bool2 = this.c;
    boolean bool1 = false;
    if (bool2)
    {
      if ((SimpleUIUtil.e()) && (!QQTheme.isNowThemeIsNight()) && (ImmersiveUtils.isSupporImmersive() != 0))
      {
        paramBoolean = QQTheme.getCurrentThemeId();
        if ((!QQTheme.isThemeSimpleDayUI(paramBoolean)) || (QQTheme.isSimpleColrThemeStateBarUseWhite(paramBoolean))) {
          bool1 = true;
        }
        ImmersiveUtils.setStatusTextColor(bool1, this.h.getWindow());
        return;
      }
      ImmersiveUtils.adjustThemeStatusBar(this.h.getWindow());
      return;
    }
    Card localCard = ((ICardCatcher)this.j.a("d_head_vip")).a();
    Boolean localBoolean = paramBoolean;
    if (paramBoolean == null)
    {
      localBoolean = paramBoolean;
      if (localCard != null)
      {
        if ((!((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).checkUsePersonalCard(this.g, localCard)) && (localCard.isNoCover())) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        localBoolean = Boolean.valueOf(bool1);
      }
    }
    if ((localBoolean != null) && (QQTheme.isDefaultTheme()))
    {
      ImmersiveUtils.setStatusTextColor(localBoolean.booleanValue() ^ true, this.h.getWindow());
      return;
    }
    if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isNowThemeIsNight(this.g, true, null))
    {
      ImmersiveUtils.setStatusTextColor(false, this.h.getWindow());
      return;
    }
    if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isGoldenTheme())
    {
      ImmersiveUtils.setStatusTextColor(false, this.h.getWindow());
      return;
    }
    ImmersiveUtils.setStatusTextColor(((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isDartStatusBar(this.h, 2131167331), this.h.getWindow());
  }
  
  public void a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (an.get(paramString) != null)
    {
      if (((QQSettingMeBizBean)an.get(paramString)).l().getVisibility() != 0) {
        return;
      }
      if (paramString.equals("d_lovespace")) {
        ((ILoveZoneRedTouchApi)QRoute.api(ILoveZoneRedTouchApi.class)).setRedData(this.X, paramAppInfo);
      }
      try
      {
        if (("d_qq_shopping".equals(paramString)) && (g(paramString) != null)) {
          g(paramString).setIsNeedRedImageAutoFix(true);
        }
        b(paramString, paramAppInfo);
        return;
      }
      catch (Exception paramAppInfo)
      {
        QLog.e("QQSettingRedesign", 1, new Object[] { "updateDrawerRedTouch error: ", paramString, ", ", paramAppInfo });
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->fillData, isInit:");
      localStringBuilder.append(this.b);
      QLog.d("QQSettingRedesign", 2, localStringBuilder.toString());
    }
    this.g = paramAppRuntime;
    this.j.a(paramAppRuntime);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h.runOnUiThread(new QQSettingMe.5(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.aj != null) && (this.am != null) && (this.ak != null) && (this.al != null) && (this.ah != null) && (this.ai != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.ak.setVisibility(8);
      int i1;
      if ((!paramBoolean) && (paramString.charAt(0) == '-'))
      {
        paramString = paramString.substring(1);
        this.ak.setVisibility(0);
        this.ak.setText("-");
        this.ak.measure(0, 0);
        i1 = this.ak.getMeasuredWidth();
        this.aj.setText(paramString);
      }
      else
      {
        i1 = 0;
      }
      this.aj.measure(0, 0);
      this.am.measure(0, 0);
      this.ah.measure(0, 0);
      this.al.measure(0, 0);
      int i4 = this.aj.getMeasuredWidth();
      int i3 = this.ah.getMeasuredWidth();
      int i2 = (i3 - i4 - i1 - this.al.getMeasuredWidth()) / 2;
      i4 /= 2;
      i3 /= 2;
      paramString = (LinearLayout.LayoutParams)this.ai.getLayoutParams();
      paramString.leftMargin = (i3 - (i2 + i1 + i4));
      this.ai.setLayoutParams(paramString);
    }
  }
  
  public void b()
  {
    if ((!QQSettingMeMenuConfigBean.a) && (((QQSettingMeMenuConfigBean)QConfigManager.b().b(743)).a())) {
      q();
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onResume!");
    }
    j();
    if (!this.b)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "init: false");
      }
      v();
      VideoReport.addToDetectionWhitelist(this.h);
      this.b = true;
    }
    this.j.c();
    i = true;
    VideoReport.setPageId(this.d, "pg_drawer");
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "0S200MNJT807V3GE");
    VideoReport.setPageParams(this.d, new PageParams(localHashMap));
    r();
  }
  
  public void b(int paramInt)
  {
    if (!(this.ad.getDrawable() instanceof Animatable))
    {
      if (this.l) {
        localObject = this.h.getResources().getDrawable(2130847712);
      } else {
        localObject = this.h.getResources().getDrawable(2130847713);
      }
      this.ad.setImageDrawable((Drawable)localObject);
      if ((localObject instanceof Animatable)) {
        ((Animatable)localObject).start();
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    this.ae.setText((CharSequence)localObject);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NIGHTMODE_ACTION_DOWNLOADING: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQSettingRedesign", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(QQSettingMeLevelAndMedalBean paramQQSettingMeLevelAndMedalBean)
  {
    if ((paramQQSettingMeLevelAndMedalBean.b != null) && (this.h != null) && (this.ag != null))
    {
      String str;
      if (paramQQSettingMeLevelAndMedalBean.b.allowPeopleSee)
      {
        if (paramQQSettingMeLevelAndMedalBean.b.lLoginDays < 10000L) {
          str = String.format(HardCodeUtil.a(2131897265), new Object[] { Long.valueOf(paramQQSettingMeLevelAndMedalBean.b.lLoginDays) });
        } else {
          str = "9999+";
        }
        paramQQSettingMeLevelAndMedalBean = String.format(HardCodeUtil.a(2131897307), new Object[] { Long.valueOf(paramQQSettingMeLevelAndMedalBean.b.lLoginDays) });
      }
      else
      {
        str = HardCodeUtil.a(2131897306);
        paramQQSettingMeLevelAndMedalBean = HardCodeUtil.a(2131897266);
      }
      this.ag.setText(str);
      AccessibilityUtil.a(this.af, paramQQSettingMeLevelAndMedalBean, Button.class.getName());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateTalent error");
    }
  }
  
  public void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    try
    {
      this.K.a(paramAppInfo);
      return;
    }
    catch (Exception paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    View localView = b("d_smallworld");
    if (localView == null) {
      return;
    }
    int i1;
    if ((paramBoolean) && (!a(a("d_smallworld")))) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "-->onPause!");
    }
    this.j.d();
    i = false;
    VideoReport.pageLogicDestroy(this.d);
  }
  
  public void c(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouch localRedTouch = this.E;
    if (localRedTouch != null) {
      localRedTouch.a(paramAppInfo);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "-->onDestroy!");
    }
    this.j.e();
  }
  
  public void d(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouch localRedTouch = this.I;
    if (localRedTouch != null) {
      localRedTouch.a(paramAppInfo);
    }
  }
  
  public void d(String paramString)
  {
    View localView = b("d_lovespace");
    if (localView != null)
    {
      boolean bool = "0".equals(paramString);
      int i2 = 0;
      int i1;
      if ((!bool) && (!a(a("d_lovespace")))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        i1 = i2;
      } else {
        i1 = 8;
      }
      localView.setVisibility(i1);
    }
  }
  
  @RequiresApi(api=23)
  public void e()
  {
    s();
    w();
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "ThemeDebugKeyLog:onPostThemeChanged, refresh pendant after theme changed.");
    }
    Object localObject1 = ((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).getCurrentThemeInfo();
    Object localObject2 = ((Bundle)localObject1).getString("themeId");
    boolean bool;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!"1000".equals(localObject2)) && (!"1103".equals(localObject2))) {
      bool = false;
    } else {
      bool = true;
    }
    this.l = bool;
    a(null);
    int i1;
    if (this.l)
    {
      i1 = this.d.getResources().getColor(2131167330);
      this.aa.setImageResource(2130847735);
      this.ad.setImageResource(2130847715);
    }
    else
    {
      i1 = this.d.getResources().getColor(2131167331);
      this.aa.setImageResource(2130847739);
      this.ad.setImageResource(2130847714);
    }
    Object localObject3 = ((ICardCatcher)this.j.a("d_head_vip")).a();
    if ((localObject3 != null) && ((((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).checkUsePersonalCard(this.g, (Card)localObject3)) || (!((Card)localObject3).isNoCover()))) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "onPostThemeChanged, color=", Integer.valueOf(i1), ",themeid = ", localObject2, ", enginePath=", ((Bundle)localObject1).getString("themePath") });
    }
    this.Z.setTextColor(i1);
    this.ae.setTextColor(i1);
    this.ag.setTextColor(i1);
    if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isNowThemeIsDefault(this.g, true, null))
    {
      this.aj.setTextColor(-6709582);
      this.ak.setTextColor(-6709582);
      this.al.setTextColor(-6709582);
    }
    else
    {
      this.aj.setTextColor(i1);
      this.ak.setTextColor(i1);
      this.al.setTextColor(i1);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!"1000".equals(localObject2))) {
      this.T.setVisibility(8);
    } else {
      this.T.setVisibility(0);
    }
    this.am.setTextColor(i1);
    localObject2 = ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getPlateColor("A3");
    localObject1 = localObject2;
    int i2;
    if (localObject2 == null)
    {
      if (QQTheme.isNowThemeIsNight()) {
        i2 = 1996488704;
      } else {
        i2 = 0;
      }
      localObject1 = Integer.valueOf(i2);
    }
    localObject2 = an.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (QQSettingMeBizBean)((Iterator)localObject2).next();
      if (((QQSettingMeBizBean)localObject3).l() != null)
      {
        Object localObject4 = ((QQSettingMeBizBean)localObject3).l();
        if (a((QQSettingMeBizBean)localObject3)) {
          i2 = 8;
        } else {
          i2 = 0;
        }
        ((View)localObject4).setVisibility(i2);
        localObject4 = (URLImageView)((QQSettingMeBizBean)localObject3).l().findViewById(2131432185);
        a((URLImageView)localObject4, (QQSettingMeBizBean)localObject3);
        if (!QQTheme.isNowThemeIsNight()) {
          ((URLImageView)localObject4).setColorFilter(((Integer)localObject1).intValue());
        } else {
          ((URLImageView)localObject4).setColorFilter(new LightingColorFilter(0, Color.parseColor("#999999")));
        }
        localObject3 = (TextView)((QQSettingMeBizBean)localObject3).l().findViewById(2131432189);
        if (!this.l) {
          ((TextView)localObject3).setTextColor(i1);
        } else {
          ((TextView)localObject3).setTextColor(this.d.getResources().getColor(2131167329));
        }
        if ((SimpleUIUtil.e()) && ("2920".equals(QQTheme.getCurrentThemeId()))) {
          ((TextView)localObject3).setTextColor(this.d.getResources().getColor(2131167329));
        }
      }
    }
    if (QQTheme.isNowThemeIsNight()) {
      this.x.setColorFilter(1996488704);
    } else {
      this.x.setColorFilter(0);
    }
    this.j.g();
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateVipText sp vipText = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = b("d_vip_identity");
    if (!TextUtils.isEmpty(paramString))
    {
      if (localObject == null) {
        return;
      }
      localObject = (TextView)((View)localObject).findViewById(2131432189);
      if (localObject != null) {
        ((TextView)localObject).setText(paramString);
      }
    }
  }
  
  public void f()
  {
    this.c = true;
    this.j.i();
    Object localObject = this.V;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 0))
    {
      this.V.setVisibility(8);
      localObject = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g.getCurrentAccountUin());
      localStringBuilder.append("qqsettingme_f2f_guide");
      ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
    }
    a(null);
  }
  
  public void f(String paramString)
  {
    this.y.setText(paramString);
  }
  
  public void g()
  {
    this.c = false;
    this.j.h();
    a(null);
  }
  
  public AppRuntime h()
  {
    return this.g;
  }
  
  public void j()
  {
    QQSettingMeSuperMemberPayButtonBean localQQSettingMeSuperMemberPayButtonBean = ((ISuperMemberDataCatcher)this.j.a("d_vip_identity")).a();
    if ((!TextUtils.isEmpty(localQQSettingMeSuperMemberPayButtonBean.c)) && (!localQQSettingMeSuperMemberPayButtonBean.c.equals(this.g.getCurrentAccountUin())))
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler payRuleUin changed");
      t();
    }
  }
  
  public void k()
  {
    Object localObject = this.ah;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.am;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(4);
    }
  }
  
  public void l()
  {
    Iterator localIterator = an.values().iterator();
    while (localIterator.hasNext())
    {
      QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)localIterator.next();
      localQQSettingMeBizBean.m().g();
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localQQSettingMeBizBean.n().getAppInfo();
      if ((localAppInfo != null) && (localAppInfo.exposure_max.get() <= 0))
      {
        localAppInfo.iNewFlag.set(0);
        localQQSettingMeBizBean.n().setAppInfo(localAppInfo);
      }
    }
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    if ((paramView != null) && (this.b)) {
      if ((this.k != 0L) && (System.currentTimeMillis() - this.k < 500L))
      {
        this.k = System.currentTimeMillis();
      }
      else
      {
        this.k = System.currentTimeMillis();
        int i4 = paramView.getId();
        if (i4 == 2131432179)
        {
          this.j.a("d_common").onClick(paramView);
        }
        else
        {
          int i1 = 1;
          int i2 = 1;
          int i3 = 1;
          boolean bool = true;
          Object localObject;
          if ((i4 != 2131432217) && (i4 != 2131432181))
          {
            if (i4 == 2131432234)
            {
              this.j.a("d_nickname").onClick(paramView);
            }
            else if (i4 == 2131432229)
            {
              paramView.setTag(Boolean.valueOf(this.q.h()));
              this.j.a("d_avatar").onClick(paramView);
            }
            else if (i4 == 2131432207)
            {
              this.j.a("d_qrcode").onClick(paramView);
            }
            else if (i4 == 2131432209)
            {
              this.j.a("d_setting").onClick(paramView);
            }
            else if (i4 == 2131432196)
            {
              this.j.a("d_night_mode").onClick(paramView);
            }
            else if (i4 == 2131432220)
            {
              this.j.a("d_head_vip").onClick(paramView);
              VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(0));
              VideoReport.reportEvent("clck", paramView, null);
            }
            else if (i4 == 2131432250)
            {
              this.j.a("d_weather").onClick(paramView);
              VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(0));
              VideoReport.reportEvent("clck", paramView, null);
            }
            else if (i4 == 2131432242)
            {
              localObject = this.J;
              if ((localObject != null) && (this.h != null))
              {
                localObject = (TextView)((View)localObject).findViewById(2131432241);
                if ((localObject == null) || (((TextView)localObject).getText() == null)) {
                  bool = false;
                }
                paramView.setTag(Boolean.valueOf(bool));
              }
              this.j.a("d_signature").onClick(paramView);
            }
            else if (i4 == 2131432238)
            {
              localObject = this.I;
              if ((localObject == null) || (!((RedTouch)localObject).h())) {
                i1 = 0;
              }
              this.j.a("d_head_vip").onClick(paramView);
              VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(i1));
              VideoReport.reportEvent("clck", paramView, null);
            }
            else if (i4 == 2131432239)
            {
              localObject = this.E;
              if ((localObject != null) && (((RedTouch)localObject).h())) {
                i1 = i2;
              } else {
                i1 = 0;
              }
              this.j.a("d_head_vip").onClick(paramView);
              VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(i1));
              VideoReport.reportEvent("clck", paramView, null);
            }
            else if (i4 == 2131432225)
            {
              this.j.a("d_head_vip").onClick(paramView);
            }
            else if (i4 == 2131432235)
            {
              this.j.a("d_head_vip").onClick(paramView);
              VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(0));
              VideoReport.reportEvent("clck", paramView, null);
            }
            else if (i4 == 2131432204)
            {
              this.j.a("d_profile_bubble").onClick(paramView);
            }
            else if (i4 == 2131432247)
            {
              this.j.a("d_head_vip").onClick(paramView);
            }
          }
          else
          {
            localObject = this.P;
            if ((localObject != null) && (((RedTouch)localObject).h())) {
              i1 = i3;
            } else {
              i1 = 0;
            }
            this.j.a("d_daily").onClick(paramView);
            VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(i1));
            VideoReport.reportEvent("clck", paramView, null);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {
      return false;
    }
    int i1 = paramView.getId();
    if ((i1 == 2131432217) || (i1 == 2131432179) || (i1 == 2131432207) || (i1 == 2131432229) || (i1 == 2131432209) || (i1 == 2131432196) || (i1 == 2131432220) || (i1 == 2131432250) || (i1 == 2131432242)) {
      this.j.a(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */