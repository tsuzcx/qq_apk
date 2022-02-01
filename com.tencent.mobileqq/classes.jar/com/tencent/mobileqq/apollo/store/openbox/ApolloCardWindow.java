package com.tencent.mobileqq.apollo.store.openbox;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.model.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(11)
public class ApolloCardWindow
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, BoxCardHandler.OnBoxCardHandlerListener, IApolloOpenBoxListener, MultilScreenlLayout.OnClickScrollLayoutListener
{
  static float a;
  static Map<String, Drawable> f = new HashMap();
  private static final String i = HardCodeUtil.a(2131898567);
  private static final String j = HardCodeUtil.a(2131898556);
  private static boolean k;
  private LinearLayout A;
  private TextView B;
  private RoundRectLinearLayout C;
  private TextView D;
  private ApolloOpenBoxView E;
  private TextView F;
  private WeakReferenceHandler G;
  private OpeningCardGroup H;
  private TextView I;
  private ImageView J;
  private ImageView K;
  private ImageView L;
  private ImageView M;
  private AlphaAnimation N;
  private AlphaAnimation O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private int T;
  private boolean U;
  private BoxCardHandler V;
  private boolean W;
  private int Z;
  private LinearLayout aa;
  private float ab;
  private float ac;
  private boolean ad;
  private int ae;
  private int af;
  private int ag;
  private TextView ah;
  private ImageView ai;
  private ImageView aj;
  private TextView ak;
  private RoundRectLinearLayout al;
  private ImageView am;
  private TextView an;
  private ImageView ao;
  private ApolloCardWindow.OnCloseCardWindowListener ap;
  ScaleAnimation b;
  ScaleAnimation c;
  AnimationSet d;
  DownloaderInterface e;
  DownloadListener g = new ApolloCardWindow.2(this);
  Runnable h = new ApolloCardWindow.3(this);
  private ApolloBoxData l;
  private String m;
  private TextView n;
  private Context o;
  private TextView p;
  private ImageView q;
  private String r;
  private String s;
  private String t;
  private long u;
  private int v;
  private int w;
  private List<ApolloCardLayout> x = new ArrayList();
  private WeakReference<AppInterface> y;
  private boolean z;
  
  public ApolloCardWindow(Context paramContext)
  {
    super(paramContext);
    this.o = paramContext;
    d();
    this.e = new DownloaderFactory(BaseApplicationImpl.getApplication().getRuntime()).a(3);
    ThreadManager.post(this.h, 10, null, true);
  }
  
  public static void a()
  {
    a = FontSettingManager.getFontLevel() / 16.0F;
    if (a == 0.0F) {
      a = 1.0F;
    }
  }
  
  private void a(Message paramMessage)
  {
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)) && (!TextUtils.isEmpty((String)paramMessage.obj)))
    {
      paramMessage = URLDrawable.URLDrawableOptions.obtain();
      paramMessage.mLoadingDrawable = ImageUtil.j();
      paramMessage.mFailedDrawable = paramMessage.mLoadingDrawable;
      ApolloDrawableExtraInfo localApolloDrawableExtraInfo = new ApolloDrawableExtraInfo();
      localApolloDrawableExtraInfo.mDrawableType = ApolloConstant.ad;
      paramMessage.mExtraInfo = localApolloDrawableExtraInfo;
    }
  }
  
  public static void b()
  {
    if (k) {
      return;
    }
    k = true;
    int i2 = 0;
    int i1 = 0;
    StringBuilder localStringBuilder;
    while (i1 <= 9)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("apollo_card_gold_");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
      localStringBuilder.append((String)localObject);
      if (!new File(localStringBuilder.toString()).exists()) {
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable((String)localObject, null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl((String)localObject)).startDownload();
      }
      i1 += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
    ((StringBuilder)localObject).append("apollo_card_gold_add.png");
    if (!new File(((StringBuilder)localObject).toString()).exists()) {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_gold_add.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_gold_add.png")).startDownload();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
    ((StringBuilder)localObject).append("apollo_card_gold_icon.png");
    i1 = i2;
    if (!new File(((StringBuilder)localObject).toString()).exists())
    {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_gold_icon.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_gold_icon.png")).startDownload();
      i1 = i2;
    }
    while (i1 <= 9)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("apollo_card_crystal_");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
      localStringBuilder.append((String)localObject);
      if (!new File(localStringBuilder.toString()).exists()) {
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable((String)localObject, null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl((String)localObject)).startDownload();
      }
      i1 += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
    ((StringBuilder)localObject).append("apollo_card_crystal_add.png");
    if (!new File(((StringBuilder)localObject).toString()).exists()) {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_crystal_add.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_crystal_add.png")).startDownload();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
    ((StringBuilder)localObject).append("apollo_card_crystal_image.png");
    if (!new File(((StringBuilder)localObject).toString()).exists()) {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_crystal_image.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_crystal_image.png")).startDownload();
    }
  }
  
  private void d()
  {
    setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()), 0, 0);
    this.ae = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.W = true;
    this.V = new BoxCardHandler(this);
    this.G = new WeakReferenceHandler(Looper.getMainLooper(), this);
    a();
    int i2 = (int)DeviceInfoUtil.D();
    int i1 = (int)DeviceInfoUtil.E() - ImmersiveUtils.getStatusBarHeight(this.o);
    super.setBackgroundColor(-671088640);
    float f1 = i2;
    this.P = ((int)(0.706F * f1));
    int i3 = (int)(0.04F * f1);
    this.Q = i3;
    int i4 = this.P;
    this.R = ((i2 - i4 - this.Q * 2) / 2);
    this.S = (i4 * 760 / 530);
    float f2 = i1;
    this.Z = ((int)(0.23F * f2));
    this.af = (i2 >> 1);
    this.ag = ((int)(0.461F * f2));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = new RelativeLayout(getContext());
    super.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.H = new OpeningCardGroup(this.o, this);
    localObject2 = new RelativeLayout.LayoutParams(-1, this.S);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = this.Z;
    Object localObject3 = this.H;
    i4 = this.P;
    int i5 = this.S;
    int i6 = this.Q;
    int i7 = this.R;
    ((OpeningCardGroup)localObject3).setFrameWidth(i4, i5, 0, i6, i7, i7);
    ((RelativeLayout)localObject1).addView(this.H, (ViewGroup.LayoutParams)localObject2);
    this.H.setClickLayoutListener(this);
    this.n = new TextView(this.o);
    this.n.setBackgroundResource(2130853306);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    double d1 = i2;
    Double.isNaN(d1);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(d1 * 0.032D));
    d1 = i1;
    Double.isNaN(d1);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(d1 * 0.017D));
    this.n.setGravity(17);
    this.n.setTextSize(17.0F / a);
    this.n.setTextColor(-1);
    this.n.setText(2131887812);
    this.n.setOnClickListener(this);
    super.addView(this.n, (ViewGroup.LayoutParams)localObject2);
    this.al = new RoundRectLinearLayout(this.o);
    this.al.setOrientation(0);
    this.al.setGravity(17);
    this.al.setClickable(true);
    this.al.setRoundRect(ViewUtils.dip2px(15.0F), -1, true);
    localObject2 = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(30.0F));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(0.018F * f2));
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    this.al.setPadding(0, 0, ViewUtils.dip2px(12.0F), 0);
    super.addView(this.al, (ViewGroup.LayoutParams)localObject2);
    this.J = new ImageView(this.o);
    localObject2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(15.0F), ViewUtils.dip2px(17.0F));
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(12.0F);
    this.al.addView(this.J, (ViewGroup.LayoutParams)localObject2);
    this.J.setOnClickListener(this);
    this.J.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.B = new TextView(this.o);
    this.B.setGravity(17);
    this.B.setTextSize(12.0F / a);
    this.B.setTextColor(-16777216);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(3.0F);
    this.al.addView(this.B, (ViewGroup.LayoutParams)localObject2);
    this.B.setOnClickListener(this);
    this.ai = new ImageView(this.o);
    this.ai.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localObject2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(15.0F), ViewUtils.dip2px(17.0F));
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(15.0F);
    this.al.addView(this.ai, (ViewGroup.LayoutParams)localObject2);
    this.ai.setOnClickListener(this);
    this.ak = new TextView(this.o);
    this.ak.setGravity(17);
    this.ak.setTextSize(12.0F / a);
    this.ak.setTextColor(-16777216);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(3.0F);
    this.al.addView(this.ak, (ViewGroup.LayoutParams)localObject2);
    this.ak.setOnClickListener(this);
    this.am = new ImageView(this.o);
    this.am.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localObject2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(15.0F), ViewUtils.dip2px(17.0F));
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(15.0F);
    this.al.addView(this.am, (ViewGroup.LayoutParams)localObject2);
    this.am.setOnClickListener(this);
    this.an = new TextView(this.o);
    this.an.setGravity(17);
    this.an.setTextSize(12.0F / a);
    this.an.setTextColor(-16777216);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(3.0F);
    this.al.addView(this.an, (ViewGroup.LayoutParams)localObject2);
    this.an.setOnClickListener(this);
    this.ah = new TextView(this.o);
    this.ah.setTextSize(14.0F / a);
    this.ah.setTextColor(-34816);
    this.ah.setText(HardCodeUtil.a(2131898566));
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(0.029F * f1));
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(0.17F * f2));
    super.addView(this.ah, (ViewGroup.LayoutParams)localObject2);
    this.aa = new LinearLayout(this.o);
    this.aa.setOrientation(1);
    this.aa.setGravity(17);
    this.p = new TextView(this.o);
    this.p.setGravity(17);
    this.p.setTextSize(17.0F / a);
    this.p.setTextColor(-1);
    this.s = i;
    this.p.setText(this.s);
    this.p.setClickable(true);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = ViewUtils.dip2px(25.0F);
    this.aa.addView(this.p, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(250.0F) * 3 / 4);
    localObject3 = new URLImageView(this.o);
    URLDrawable localURLDrawable = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_error.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_error.png"));
    localURLDrawable.setTargetDensity(this.o.getResources().getDisplayMetrics().densityDpi / 2);
    ((URLImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER);
    ((URLImageView)localObject3).setImageDrawable(localURLDrawable);
    ((URLImageView)localObject3).setClickable(true);
    this.aa.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ViewUtils.dip2px(66.0F);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ViewUtils.dip2px(129.0F);
    super.addView(this.aa, (ViewGroup.LayoutParams)localObject2);
    this.q = new ImageView(this.o);
    this.q.setImageResource(2130839588);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
    super.addView(this.q, (ViewGroup.LayoutParams)localObject2);
    this.T = ((int)(0.061F * f2));
    this.A = new LinearLayout(this.o);
    this.A.setOrientation(0);
    this.A.setGravity(17);
    localObject2 = new RelativeLayout.LayoutParams((int)(0.936F * f1), this.T);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(0.027F * f1));
    super.addView(this.A, (ViewGroup.LayoutParams)localObject2);
    this.C = new RoundRectLinearLayout(this.o);
    this.C.setGravity(17);
    this.C.setRoundRect((int)(f1 * 0.008F), -7707920, false);
    this.L = new ImageView(this.o);
    this.L.setBackgroundResource(2130838478);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    this.C.addView(this.L, (ViewGroup.LayoutParams)localObject2);
    this.D = new TextView(this.o);
    this.D.setGravity(17);
    this.D.setTextSize(18.0F / a);
    this.D.setTextColor(-1);
    this.D.setText("送花给TA");
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(8.0F);
    this.C.addView(this.D, (ViewGroup.LayoutParams)localObject2);
    this.C.setOnClickListener(this);
    localObject2 = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    this.A.addView(this.C, (ViewGroup.LayoutParams)localObject2);
    this.F = new TextView(this.o);
    this.F.setGravity(17);
    this.F.setTextSize(18.0F);
    this.F.setTextColor(-1);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(f2 * 0.2F));
    super.addView(this.F, (ViewGroup.LayoutParams)localObject2);
    this.E = new ApolloOpenBoxView(this.o, this);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)localObject1).addView(this.E, (ViewGroup.LayoutParams)localObject2);
    this.I = new TextView(this.o);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    i1 = 0;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ViewUtils.dip2px(217.0F);
    this.I.setGravity(17);
    this.I.setTextSize(30.0F / a);
    this.I.setTextColor(-1);
    ((RelativeLayout)localObject1).addView(this.I, (ViewGroup.LayoutParams)localObject2);
    while (i1 < 4)
    {
      this.x.add(new ApolloCardLayout(this.o));
      i1 += 1;
    }
    this.M = new ImageView(this.o);
    this.M.setBackgroundResource(2130838477);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = (i2 / 4);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i3;
    this.M.setVisibility(4);
    super.addView(this.M, (ViewGroup.LayoutParams)localObject1);
    super.setOnClickListener(this);
  }
  
  private void e()
  {
    ImageView localImageView = this.ao;
    if (localImageView != null) {
      localImageView.setImageResource(2130838476);
    }
  }
  
  private void f()
  {
    ImageView localImageView = this.aj;
    if (localImageView != null) {
      localImageView.setImageResource(2130838476);
    }
  }
  
  private void g()
  {
    ImageView localImageView = this.K;
    if (localImageView != null) {
      localImageView.setImageResource(2130838476);
    }
  }
  
  private boolean h()
  {
    Object localObject1 = this.l;
    if (localObject1 == null) {
      return true;
    }
    if (((ApolloBoxData)localObject1).m.size() > 2)
    {
      localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.m.get(2);
      if ((localObject1 != null) && (((ApolloBoxData.BoxCardListSummary)localObject1).d > 0))
      {
        Object localObject2 = this.I;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("+");
        localStringBuilder.append(((ApolloBoxData.BoxCardListSummary)localObject1).d);
        ((TextView)localObject2).setText(localStringBuilder.toString());
        localObject2 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_props_image.png", null, ((ApolloBoxData.BoxCardListSummary)localObject1).e);
        int i1 = ViewUtils.dip2px(25.0F / a);
        ((URLDrawable)localObject2).setBounds(0, 0, i1, i1);
        this.I.setCompoundDrawables((Drawable)localObject2, null, null, null);
        a(ViewUtils.dip2px(125.0F) + this.B.getWidth() + this.ak.getWidth());
        this.an.setText(ApolloBoxData.a(((ApolloBoxData.BoxCardListSummary)localObject1).c - ((ApolloBoxData.BoxCardListSummary)localObject1).d));
        a(this.an, ((ApolloBoxData.BoxCardListSummary)localObject1).c - ((ApolloBoxData.BoxCardListSummary)localObject1).d, ((ApolloBoxData.BoxCardListSummary)localObject1).c, 200, 650);
        if (this.ao == null)
        {
          this.ao = new ImageView(this.o);
          this.ao.setId(2131442952);
          this.ao.setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject1 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(15.0F), ViewUtils.dip2px(15.0F));
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = (ViewUtils.dip2px(82.0F) + this.B.getWidth() + this.ak.getWidth());
          ((RelativeLayout.LayoutParams)localObject1).topMargin = (((RelativeLayout.LayoutParams)this.al.getLayoutParams()).topMargin + ViewUtils.dip2px(7.5F));
          super.addView(this.ao, (ViewGroup.LayoutParams)localObject1);
        }
        a(this.am, this.ao, 650);
        this.G.sendEmptyMessageDelayed(269, 650L);
      }
    }
    this.ao.setImageDrawable(null);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloCardWindow", 2, "MSG_CODE_ADD_GOLD:");
    }
    return false;
  }
  
  private boolean i()
  {
    Object localObject1 = this.l;
    if (localObject1 == null) {
      return true;
    }
    if (((ApolloBoxData)localObject1).m.size() == 1) {
      return false;
    }
    localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.m.get(1);
    if (localObject1 != null)
    {
      if (((ApolloBoxData.BoxCardListSummary)localObject1).d <= 0) {
        return false;
      }
      Object localObject2 = this.I;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(((ApolloBoxData.BoxCardListSummary)localObject1).d);
      ((TextView)localObject2).setText(localStringBuilder.toString());
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = super.getResources().getDrawable(2130838474);
      localObject2 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_first_image.png", (URLDrawable.URLDrawableOptions)localObject2, ((ApolloBoxData.BoxCardListSummary)localObject1).e);
      int i1 = ViewUtils.dip2px(25.0F / a);
      ((URLDrawable)localObject2).setBounds(0, 0, i1, i1);
      this.I.setCompoundDrawables((Drawable)localObject2, null, null, null);
      a(this.B.getWidth() + this.ai.getWidth() + ViewUtils.dip2px(28.0F));
      this.ak.setText(ApolloBoxData.b(((ApolloBoxData.BoxCardListSummary)localObject1).c - ((ApolloBoxData.BoxCardListSummary)localObject1).d));
      a(this.ak, ((ApolloBoxData.BoxCardListSummary)localObject1).c - ((ApolloBoxData.BoxCardListSummary)localObject1).d, ((ApolloBoxData.BoxCardListSummary)localObject1).c, 200, 650);
      if (this.aj == null)
      {
        this.aj = new ImageView(this.o);
        this.aj.setId(2131442952);
        this.aj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localObject1 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(15.0F), ViewUtils.dip2px(15.0F));
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (ViewUtils.dip2px(47.0F) + this.B.getWidth());
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (((RelativeLayout.LayoutParams)this.al.getLayoutParams()).topMargin + ViewUtils.dip2px(7.5F));
        super.addView(this.aj, (ViewGroup.LayoutParams)localObject1);
      }
      this.aj.setImageDrawable(null);
      a(this.ai, this.aj, 650);
      this.G.sendEmptyMessageDelayed(267, 650L);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloCardWindow", 2, "MSG_CODE_ADD_GOLD:");
      }
    }
    return false;
  }
  
  private boolean j()
  {
    Object localObject1 = this.l;
    if (localObject1 == null) {
      return true;
    }
    if (((ApolloBoxData)localObject1).m.size() == 0) {
      return false;
    }
    localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.m.get(0);
    if (localObject1 != null)
    {
      if (((ApolloBoxData.BoxCardListSummary)localObject1).d <= 0) {
        return false;
      }
      this.I.setVisibility(0);
      Object localObject2 = this.I;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(((ApolloBoxData.BoxCardListSummary)localObject1).d);
      ((TextView)localObject2).setText(localStringBuilder.toString());
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = super.getResources().getDrawable(2130838473);
      localObject2 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_first_image.png", (URLDrawable.URLDrawableOptions)localObject2, ((ApolloBoxData.BoxCardListSummary)localObject1).e);
      int i1 = ViewUtils.dip2px(25.0F / a);
      ((URLDrawable)localObject2).setBounds(0, 0, (int)(i1 * 0.8F), i1);
      this.I.setCompoundDrawables((Drawable)localObject2, null, null, null);
      a(0);
      this.B.setText(ApolloBoxData.c(((ApolloBoxData.BoxCardListSummary)localObject1).c - ((ApolloBoxData.BoxCardListSummary)localObject1).d));
      a(this.B, ((ApolloBoxData.BoxCardListSummary)localObject1).c - ((ApolloBoxData.BoxCardListSummary)localObject1).d, ((ApolloBoxData.BoxCardListSummary)localObject1).c, 200, 650);
      if (this.K == null)
      {
        this.K = new ImageView(this.o);
        this.K.setId(2131432297);
        this.K.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localObject1 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(15.0F), ViewUtils.dip2px(15.0F));
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = ViewUtils.dip2px(12.0F);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (((RelativeLayout.LayoutParams)this.al.getLayoutParams()).topMargin + ViewUtils.dip2px(7.5F));
        super.addView(this.K, (ViewGroup.LayoutParams)localObject1);
      }
      this.K.setImageDrawable(null);
      a(this.J, this.K, 650);
      this.G.sendEmptyMessageDelayed(266, 650L);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloCardWindow", 2, "MSG_CODE_ADD_CARD:");
      }
    }
    return false;
  }
  
  private boolean k()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      if (((ApolloBoxData)localObject).n == null) {
        return true;
      }
      int i1 = this.P;
      int i2 = i1 / 2;
      int i3 = this.Q;
      int i4 = this.R;
      int i5 = this.S / 2;
      this.H.a(i2 + i3 + i4, i1 + i3, i5);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloCardWindow", 2, "MSG_CODE_CARD_TO_NORMAL");
      }
      localObject = this.l;
      if (localObject != null)
      {
        i1 = ((ApolloBoxData)localObject).m.size();
        i2 = 650;
        if (i1 > 0)
        {
          localObject = (ApolloBoxData.BoxCardListSummary)this.l.m.get(0);
          if ((localObject != null) && (((ApolloBoxData.BoxCardListSummary)localObject).a) && (((ApolloBoxData.BoxCardListSummary)localObject).d > 0))
          {
            this.G.sendEmptyMessageDelayed(255, 500L);
            i1 = 650;
            break label177;
          }
        }
        i1 = 0;
        i2 = 0;
        label177:
        i3 = i1;
        if (this.l.m.size() > 1)
        {
          localObject = (ApolloBoxData.BoxCardListSummary)this.l.m.get(1);
          i3 = i1;
          if (localObject != null)
          {
            i3 = i1;
            if (((ApolloBoxData.BoxCardListSummary)localObject).a)
            {
              i3 = i1;
              if (((ApolloBoxData.BoxCardListSummary)localObject).d > 0)
              {
                this.G.sendEmptyMessageDelayed(265, i2 + 500);
                i3 = i1 + 150 + 500;
              }
            }
          }
        }
        if (this.l.m.size() > 2)
        {
          localObject = (ApolloBoxData.BoxCardListSummary)this.l.m.get(2);
          if ((localObject != null) && (((ApolloBoxData.BoxCardListSummary)localObject).a) && (((ApolloBoxData.BoxCardListSummary)localObject).d > 0)) {
            this.G.sendEmptyMessageDelayed(268, i3 + 500);
          }
        }
      }
      return false;
    }
    return true;
  }
  
  private boolean l()
  {
    super.setVisibility(0);
    c();
    if (this.l == null)
    {
      this.p.setText(this.s);
      this.aa.setVisibility(0);
      this.q.setVisibility(8);
      this.H.setVisibility(4);
      return true;
    }
    this.F.setVisibility(8);
    Object localObject1;
    int i1;
    if ((!TextUtils.isEmpty(this.r)) && (this.r.equals(this.m)))
    {
      this.C.setVisibility(8);
    }
    else if (this.l.k > 0)
    {
      this.C.setVisibility(0);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject1 = this.L;
        float f1;
        if (this.l.c) {
          f1 = 1.0F;
        } else {
          f1 = 0.5F;
        }
        ((ImageView)localObject1).setAlpha(f1);
      }
      localObject1 = this.D;
      if (this.l.c) {
        i1 = -1;
      } else {
        i1 = -2130706433;
      }
      ((TextView)localObject1).setTextColor(i1);
    }
    else
    {
      this.C.setVisibility(8);
    }
    this.aa.setVisibility(8);
    this.q.setVisibility(8);
    if ("drawer".equals(this.t)) {
      this.v = 0;
    } else if ("friendcard".equals(this.t)) {
      this.v = 1;
    } else {
      this.v = 2;
    }
    if ((this.l.f == 0L) && (this.l.e != -501031L))
    {
      if (this.l.k > 0)
      {
        if ((!TextUtils.isEmpty(this.l.a)) && (this.l.a.equals(this.l.b)))
        {
          this.w = 1;
          localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.l.get(Integer.valueOf(3));
          if ((localObject1 != null) && (((ApolloBoxData.BoxCardListSummary)localObject1).d > 0)) {
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C2", this.v, 0, new String[] { "", String.valueOf(((ApolloBoxData.BoxCardListSummary)localObject1).d), "" });
          }
          localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.l.get(Integer.valueOf(7));
          if ((localObject1 != null) && (((ApolloBoxData.BoxCardListSummary)localObject1).d > 0)) {
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C04", this.v, 0, new String[] { "", String.valueOf(((ApolloBoxData.BoxCardListSummary)localObject1).d), "" });
          }
          localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.l.get(Integer.valueOf(15));
          if ((localObject1 != null) && (((ApolloBoxData.BoxCardListSummary)localObject1).d > 0)) {
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C06", this.v, 0, new String[] { "", String.valueOf(((ApolloBoxData.BoxCardListSummary)localObject1).d), "" });
          }
          i1 = 0;
        }
        else
        {
          this.w = 2;
          if ((this.l.o != null) && (!this.l.o.isEmpty()))
          {
            localObject1 = this.l.o.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (ApolloBoxData.ApolloBoxDataItem)((Iterator)localObject1).next();
              ApolloBoxData.BoxCardListSummary localBoxCardListSummary = (ApolloBoxData.BoxCardListSummary)this.l.l.get(Integer.valueOf(3));
              if ((localBoxCardListSummary != null) && (localBoxCardListSummary.d > 0)) {
                VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.v, 0, new String[] { String.valueOf(((ApolloBoxData.ApolloBoxDataItem)localObject2).g), String.valueOf(0), String.valueOf(((ApolloBoxData.ApolloBoxDataItem)localObject2).f) });
              }
              localObject2 = (ApolloBoxData.BoxCardListSummary)this.l.l.get(Integer.valueOf(7));
              if ((localObject2 != null) && (((ApolloBoxData.BoxCardListSummary)localObject2).d > 0)) {
                VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.v, 0, new String[] { "0", String.valueOf(0), "4" });
              }
              localObject2 = (ApolloBoxData.BoxCardListSummary)this.l.l.get(Integer.valueOf(15));
              if ((localObject2 != null) && (((ApolloBoxData.BoxCardListSummary)localObject2).d > 0)) {
                VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.v, 0, new String[] { "0", String.valueOf(0), "5" });
              }
            }
          }
          i1 = 1;
        }
        VipUtils.a(null, "cmshow", "Apollo", "0X80065C1", this.v, 0, new String[] { String.valueOf(i1), String.valueOf(this.l.k) });
      }
      else if (this.l.e == -501030L)
      {
        this.w = 3;
        VipUtils.a(null, "cmshow", "Apollo", "0X80065C4", this.v, 0, new String[] { "0", "0", "1" });
      }
      else
      {
        this.w = 4;
        VipUtils.a(null, "cmshow", "Apollo", "0X80065C5", this.v, 0, new String[0]);
      }
    }
    else
    {
      if (this.l.k > 0)
      {
        if ((!TextUtils.isEmpty(this.l.a)) && (this.l.a.equals(this.l.b))) {
          this.w = 1;
        } else {
          this.w = 2;
        }
      }
      else if (this.l.f == -501030L) {
        this.w = 3;
      } else {
        this.w = 4;
      }
      VipUtils.a(null, "cmshow", "Apollo", "openfloatagain", this.v, 0, new String[] { String.valueOf(this.w) });
    }
    r();
    return false;
  }
  
  private void m()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      this.L.setAlpha(0.5F);
    }
    this.D.setTextColor(-2130706433);
    if (this.A.getVisibility() == 0) {
      QQToast.makeText(this.o, HardCodeUtil.a(2131898557), 0).show();
    }
  }
  
  private void n()
  {
    if (this.l != null)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.L;
        float f1;
        if (this.l.c) {
          f1 = 1.0F;
        } else {
          f1 = 0.5F;
        }
        ((ImageView)localObject).setAlpha(f1);
      }
      Object localObject = this.D;
      int i1;
      if (this.l.c) {
        i1 = -1;
      } else {
        i1 = -2130706433;
      }
      ((TextView)localObject).setTextColor(i1);
    }
    if (this.A.getVisibility() == 0) {
      QQToast.makeText(this.o, HardCodeUtil.a(2131898562), 0).show();
    }
  }
  
  private void o()
  {
    super.setVisibility(0);
    this.aa.setVisibility(8);
    this.q.setVisibility(0);
    this.F.setVisibility(8);
  }
  
  private void p()
  {
    super.setVisibility(0);
    this.A.setVisibility(4);
    this.p.setText(this.s);
    this.aa.setVisibility(0);
    this.q.setVisibility(8);
    this.F.setVisibility(8);
  }
  
  private void q()
  {
    this.V.a(this.o, this.m, this.t, (AppInterface)this.y.get());
  }
  
  private void r()
  {
    Object localObject1 = this.l;
    if ((localObject1 != null) && (((ApolloBoxData)localObject1).n != null))
    {
      if (this.l.n.isEmpty()) {
        return;
      }
      if (TextUtils.isEmpty(this.l.d)) {
        localObject1 = "";
      } else {
        localObject1 = this.l.d;
      }
      Object localObject2 = localObject1;
      if (!TextUtils.isEmpty(this.r))
      {
        localObject2 = localObject1;
        if (this.r.equals(this.l.b)) {
          localObject2 = HardCodeUtil.a(2131898563);
        }
      }
      Object localObject3;
      if (this.l.m.size() == 3)
      {
        this.am.setVisibility(0);
        this.an.setVisibility(0);
        this.ai.setVisibility(0);
        this.ak.setVisibility(0);
        this.J.setVisibility(0);
        this.B.setVisibility(0);
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.m.get(2);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).e))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).e), null, ((ApolloBoxData.BoxCardListSummary)localObject1).e);
            this.am.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).b == 7) {
            this.an.setTextColor(-31676);
          } else {
            this.an.setTextColor(-16777216);
          }
        }
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.m.get(1);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).e))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).e), null, ((ApolloBoxData.BoxCardListSummary)localObject1).e);
            this.ai.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).b == 7) {
            this.ak.setTextColor(-31676);
          } else {
            this.ak.setTextColor(-16777216);
          }
        }
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.m.get(0);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).e))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).e), null, ((ApolloBoxData.BoxCardListSummary)localObject1).e);
            this.J.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).b == 7) {
            this.B.setTextColor(-31676);
          } else {
            this.B.setTextColor(-16777216);
          }
        }
      }
      else if (this.l.m.size() == 2)
      {
        this.am.setVisibility(8);
        this.an.setVisibility(8);
        this.ai.setVisibility(0);
        this.ak.setVisibility(0);
        this.J.setVisibility(0);
        this.B.setVisibility(0);
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.m.get(1);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).e))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).e), null, ((ApolloBoxData.BoxCardListSummary)localObject1).e);
            this.ai.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).b == 7) {
            this.ak.setTextColor(-31676);
          } else {
            this.ak.setTextColor(-16777216);
          }
        }
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.m.get(0);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).e))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).e), null, ((ApolloBoxData.BoxCardListSummary)localObject1).e);
            this.J.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).b == 7) {
            this.B.setTextColor(-31676);
          } else {
            this.B.setTextColor(-16777216);
          }
        }
      }
      else if (this.l.m.size() == 1)
      {
        this.am.setVisibility(8);
        this.an.setVisibility(8);
        this.ai.setVisibility(8);
        this.ak.setVisibility(8);
        this.J.setVisibility(0);
        this.B.setVisibility(0);
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.l.m.get(0);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).e))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).e), null, ((ApolloBoxData.BoxCardListSummary)localObject1).e);
            this.J.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).b == 7) {
            this.B.setTextColor(-31676);
          } else {
            this.B.setTextColor(-16777216);
          }
        }
      }
      if (this.l.j != -1) {
        super.setBackgroundColor(this.l.j);
      }
      this.H.removeAllViews();
      if ((this.l.f == 0L) && (this.l.e != -501031L) && (this.l.e != -501027L))
      {
        AbstractGifImage.pauseAll();
        localObject1 = this.F;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131898560));
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131898561));
        ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
        this.F.setVisibility(0);
        this.E.setVisibility(0);
        if (this.l.m.size() > 0) {
          this.B.setText(ApolloBoxData.c(((ApolloBoxData.BoxCardListSummary)this.l.m.get(0)).c - ((ApolloBoxData.BoxCardListSummary)this.l.m.get(0)).d));
        }
        if (this.l.m.size() > 1) {
          this.ak.setText(ApolloBoxData.b(((ApolloBoxData.BoxCardListSummary)this.l.m.get(1)).c - ((ApolloBoxData.BoxCardListSummary)this.l.m.get(1)).d));
        }
        if (this.l.m.size() > 2) {
          this.an.setText(ApolloBoxData.a(((ApolloBoxData.BoxCardListSummary)this.l.m.get(2)).c - ((ApolloBoxData.BoxCardListSummary)this.l.m.get(2)).d));
        }
        if ((this.l.f == -501027L) || (this.u == -501027L)) {
          this.ah.setVisibility(0);
        }
        localObject3 = new ArrayList();
        i1 = 0;
        while (i1 < this.l.n.size())
        {
          if (this.x.size() > i1)
          {
            localObject1 = (ApolloCardLayout)this.x.get(i1);
            ((ApolloCardLayout)localObject1).clearAnimation();
          }
          else
          {
            localObject1 = null;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new ApolloCardLayout(this.o);
            this.x.add(localObject2);
          }
          ((List)localObject3).add(localObject2);
          localObject1 = (ApolloBoxData.ApolloBoxDataItem)this.l.n.get(i1);
          if ((localObject1 != null) && (((ApolloBoxData.ApolloBoxDataItem)localObject1).f == 15)) {
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C002", this.v, 0, new String[0]);
          }
          i1 += 1;
        }
        this.H.a(this.l.n, (List)localObject3, this.af, this.ag - this.Z, super.getWidth(), super.getHeight());
        this.G.sendEmptyMessageDelayed(256, 600);
        this.E.a();
        return;
      }
      this.H.setVisibility(0);
      int i1 = 0;
      while (i1 < this.l.n.size())
      {
        if (this.x.size() > i1)
        {
          localObject1 = (ApolloCardLayout)this.x.get(i1);
          ((ApolloCardLayout)localObject1).clearAnimation();
        }
        else
        {
          localObject1 = null;
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new ApolloCardLayout(this.o);
          this.x.add(localObject2);
        }
        localObject1 = new FrameLayout.LayoutParams(this.P, this.S);
        this.H.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        i1 += 1;
      }
      this.H.a(this.P, this.S, this.l);
      this.H.setCurrentFrame(0);
      this.H.requestLayout();
      this.A.setVisibility(0);
      this.al.setVisibility(0);
      this.U = true;
      if (this.l.m.size() > 0) {
        this.B.setText(ApolloBoxData.c(((ApolloBoxData.BoxCardListSummary)this.l.m.get(0)).c));
      }
      if (this.l.m.size() > 1) {
        this.ak.setText(ApolloBoxData.b(((ApolloBoxData.BoxCardListSummary)this.l.m.get(1)).c));
      }
      if (this.l.m.size() > 2) {
        this.an.setText(ApolloBoxData.a(((ApolloBoxData.BoxCardListSummary)this.l.m.get(2)).c));
      }
      if ((this.l.f == -501027L) || (this.u == -501027L)) {
        this.ah.setVisibility(0);
      }
    }
  }
  
  private void s()
  {
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    localScaleAnimation1.setDuration(100L);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.0F, 0.6666667F, 1.0F, 0.6666667F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation2.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setStartOffset(100L);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localScaleAnimation1);
    localAnimationSet.addAnimation(localScaleAnimation2);
    this.L.startAnimation(localAnimationSet);
  }
  
  Drawable a(String paramString)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    paramString.setDensity(getContext().getResources().getDisplayMetrics().densityDpi);
    return new BitmapDrawable(getContext().getResources(), paramString);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(false);
  }
  
  void a(int paramInt)
  {
    this.d = new AnimationSet(false);
    if (this.N == null)
    {
      this.N = new AlphaAnimation(0.0F, 1.0F);
      this.N.setDuration(150L);
    }
    if (this.b == null)
    {
      this.b = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.0F);
      this.b.setDuration(150L);
      this.b.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    this.d.addAnimation(this.N);
    this.d.addAnimation(this.b);
    Object localObject = new QuadBezierAnimation(0, 0, 0, -ViewUtils.dip2px(144.0F), -(ViewUtils.dip2px(195.0F) - paramInt), -ViewUtils.dip2px(164.0F));
    ((QuadBezierAnimation)localObject).setDuration(500L);
    ((QuadBezierAnimation)localObject).setStartOffset(250L);
    ((QuadBezierAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    if (this.c == null)
    {
      this.c = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F);
      this.c.setDuration(500L);
      this.c.setStartOffset(250L);
    }
    this.d.addAnimation(this.c);
    this.d.addAnimation((Animation)localObject);
    if (this.O == null)
    {
      this.O = new AlphaAnimation(1.0F, 0.0F);
      this.O.setDuration(500L);
      this.O.setStartOffset(250L);
    }
    this.d.addAnimation(this.O);
    this.d.setFillAfter(true);
    localObject = this.I;
    if (localObject != null) {
      ((TextView)localObject).startAnimation(this.d);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOpenStep drawStep:");
      localStringBuilder.append(paramInt1);
      QLog.d("[cmshow]ApolloCardWindow", 2, localStringBuilder.toString());
    }
    if (super.getVisibility() != 0) {
      return;
    }
    if (this.l == null) {
      return;
    }
    if (4 == paramInt1)
    {
      this.F.setVisibility(8);
      this.al.setVisibility(0);
      this.H.setVisibility(0);
      this.A.setVisibility(0);
      this.H.b();
      if ((this.l.f == -501027L) || (this.u == -501027L)) {
        this.ah.setVisibility(0);
      }
    }
    else if (10 == paramInt1)
    {
      if (this.H.getVisibility() != 0)
      {
        this.F.setVisibility(8);
        this.al.setVisibility(0);
        this.H.setVisibility(0);
        if ((this.l.f == -501027L) || (this.u == -501027L)) {
          this.ah.setVisibility(0);
        }
      }
      this.H.a(this.P, this.S, this.l);
      this.H.setCurrentFrame(0);
      this.E.setVisibility(4);
      this.U = true;
      AbstractGifImage.resumeAll();
    }
  }
  
  public void a(View paramView, String paramString1, String paramString2, AppInterface paramAppInterface, ApolloCardWindow.OnCloseCardWindowListener paramOnCloseCardWindowListener)
  {
    if ((paramView != null) && (paramAppInterface != null))
    {
      if (paramString1 == null) {
        return;
      }
      this.ap = paramOnCloseCardWindowListener;
      super.setVisibility(4);
      this.y = new WeakReference(paramAppInterface);
      this.A.setVisibility(4);
      this.t = paramString2;
      this.m = paramString1;
      this.r = paramAppInterface.getCurrentAccountUin();
      this.z = false;
      this.al.setVisibility(8);
      this.ah.setVisibility(8);
      this.al.setVisibility(8);
      this.H.clearAnimation();
      this.H.setVisibility(4);
      this.I.setVisibility(8);
      this.E.setVisibility(4);
      this.U = false;
      this.G.removeCallbacksAndMessages(null);
      if (this.W)
      {
        this.G.sendEmptyMessage(258);
        this.G.removeMessages(264);
        this.G.sendEmptyMessageDelayed(264, 1000L);
      }
      else
      {
        this.G.removeMessages(264);
        this.G.sendEmptyMessage(264);
        this.G.sendEmptyMessageDelayed(258, 500L);
      }
      this.W = false;
    }
  }
  
  void a(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    Object localObject = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(150L);
    long l1 = paramInt;
    ((ScaleAnimation)localObject).setStartOffset(l1);
    if (paramImageView1 != null) {
      paramImageView1.startAnimation((Animation)localObject);
    }
    paramImageView1 = new AnimationSet(false);
    localObject = new ScaleAnimation(1.0F, 4.0F, 1.0F, 4.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(150L);
    paramImageView1.addAnimation((Animation)localObject);
    new AlphaAnimation(0.0F, 1.0F).setDuration(75L);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(150L);
    paramImageView1.addAnimation((Animation)localObject);
    paramImageView1.setStartOffset(l1);
    paramImageView1.setFillAfter(true);
    if (paramImageView2 != null) {
      paramImageView2.startAnimation(paramImageView1);
    }
  }
  
  void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 <= paramInt1) {
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setObjectValues(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.addUpdateListener(new ApolloCardWindow.1(this, paramTextView));
    localValueAnimator.setStartDelay(paramInt4);
    localValueAnimator.start();
  }
  
  void a(File paramFile, String paramString)
  {
    if (this.e == null) {
      return;
    }
    DownloadTask localDownloadTask = new DownloadTask(paramString, paramFile);
    localDownloadTask.N = true;
    localDownloadTask.D = false;
    localDownloadTask.J = true;
    localDownloadTask.T = false;
    localDownloadTask.P = true;
    localDownloadTask.Q = true;
    localDownloadTask.m = true;
    localDownloadTask.L = "apollo_res";
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramFile.getPath());
    localBundle.putString("url", paramString);
    this.e.startDownload(localDownloadTask, this.g, null);
  }
  
  public void a(String paramString1, boolean paramBoolean, long paramLong, Object paramObject, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cmd:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" retCode:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" data:");
      localStringBuilder.append(paramObject);
      QLog.d("[cmshow]ApolloCardWindow", 2, localStringBuilder.toString());
    }
    if (super.getVisibility() == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloCardWindow", 2, "onResult + super.getVisibility() not VISIBLE");
      }
      return;
    }
    if ((!TextUtils.isEmpty(this.m)) && (!this.m.equals(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("mBoxUin:");
        paramString1.append(this.m);
        paramString1.append("notEqual uin:");
        paramString1.append(paramString2);
        paramString1.append(" return!");
        QLog.d("[cmshow]ApolloCardWindow", 2, paramString1.toString());
      }
      return;
    }
    if ("apollo_core.get_user_info_v2".equals(paramString1))
    {
      if ((!TextUtils.isEmpty(this.m)) && (this.m.equals(paramString2)))
      {
        paramString1 = this.G.obtainMessage(257);
        paramString1.obj = paramObject;
        paramString1.sendToTarget();
      }
    }
    else
    {
      if ("apollo_interact.thank_zan".equals(paramString1))
      {
        if ((paramLong == 0L) && (paramBoolean))
        {
          this.G.obtainMessage(262).sendToTarget();
          return;
        }
        this.z = false;
        this.G.obtainMessage(261).sendToTarget();
        return;
      }
      if ("apollo_interact.take_chips".equals(paramString1))
      {
        this.G.removeMessages(258);
        if ((paramObject instanceof ApolloBoxData)) {
          this.l = ((ApolloBoxData)paramObject);
        }
        this.u = paramLong;
        paramString1 = this.l;
        if ((paramString1 != null) && ((this.u == -501030L) || (paramString1.f == -501030L)))
        {
          if (this.l.n == null) {
            this.l.n = new ArrayList();
          }
          paramString1 = new ApolloBoxData.ApolloBoxDataItem();
          paramString1.t = 1;
          this.l.n.add(0, paramString1);
        }
        if (paramBoolean)
        {
          paramLong = this.u;
          if ((paramLong != 0L) && (paramLong != -501030L) && (paramLong != -501027L) && (paramLong != -501040L) && (paramLong != -501031L))
          {
            if (paramLong == -501028L)
            {
              this.s = j;
              this.G.obtainMessage(259).sendToTarget();
              return;
            }
            this.s = i;
            this.G.obtainMessage(259).sendToTarget();
            return;
          }
          this.G.obtainMessage(260).sendToTarget();
          return;
        }
        this.s = i;
        this.G.obtainMessage(259).sendToTarget();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = this.ap;
      if (localObject != null) {
        ((ApolloCardWindow.OnCloseCardWindowListener)localObject).d(this.m);
      }
    }
    super.setVisibility(8);
    this.G.removeCallbacksAndMessages(null);
    this.H.a(paramBoolean);
    Object localObject = this.I;
    if (localObject != null) {
      ((TextView)localObject).clearAnimation();
    }
    localObject = this.B;
    if (localObject != null) {
      ((TextView)localObject).clearAnimation();
    }
    localObject = this.J;
    if (localObject != null) {
      ((ImageView)localObject).clearAnimation();
    }
    localObject = this.ak;
    if (localObject != null) {
      ((TextView)localObject).clearAnimation();
    }
    localObject = this.ai;
    if (localObject != null) {
      ((ImageView)localObject).clearAnimation();
    }
    if (paramBoolean)
    {
      this.E.b();
      this.x.clear();
      this.V.a();
    }
  }
  
  void c()
  {
    Object localObject1 = this.l;
    Object localObject4;
    Object localObject5;
    File localFile;
    if ((localObject1 != null) && (this.E != null) && (!TextUtils.isEmpty(((ApolloBoxData)localObject1).i)) && (!TextUtils.isEmpty(this.l.h)))
    {
      localObject1 = MD5Utils.toMD5(this.l.h);
      localObject4 = MD5Utils.toMD5(this.l.i);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/");
      ((StringBuilder)localObject5).append((String)localObject1);
      ((StringBuilder)localObject5).append(".cache");
      localObject5 = new File(((StringBuilder)localObject5).toString());
      ??? = new StringBuilder();
      ((StringBuilder)???).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/");
      ((StringBuilder)???).append((String)localObject4);
      ((StringBuilder)???).append(".cache");
      localFile = new File(((StringBuilder)???).toString());
      if ((!((File)localObject5).exists()) || (!localFile.exists())) {}
    }
    for (;;)
    {
      synchronized (f)
      {
        if (!f.containsKey(localObject1)) {
          break label301;
        }
        localObject1 = (Drawable)f.get(localObject1);
        if (!f.containsKey(localObject4)) {
          break label306;
        }
        localObject4 = (Drawable)f.get(localObject4);
        if ((localObject1 != null) && (localObject4 != null)) {
          this.E.setDrawables((Drawable)localObject1, (Drawable)localObject4, null);
        }
      }
      if (!((File)localObject5).exists()) {
        a((File)localObject5, this.l.h);
      }
      if (!localFile.exists()) {
        a(localFile, this.l.i);
      }
      return;
      label301:
      Object localObject3 = null;
      continue;
      label306:
      localObject4 = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    case 263: 
    default: 
      return false;
    case 269: 
      e();
      return false;
    case 268: 
      if (h()) {
        return false;
      }
      break;
    case 267: 
      f();
      return false;
    case 266: 
      g();
      return false;
    case 265: 
      if (i()) {
        return false;
      }
      break;
    case 264: 
      q();
      return false;
    case 262: 
      m();
      return false;
    case 261: 
      n();
      return false;
    case 260: 
      if (l()) {
        return false;
      }
      break;
    case 259: 
      p();
      return false;
    case 258: 
      o();
      return false;
    case 257: 
      a(paramMessage);
      return false;
    case 256: 
      if (k()) {
        return false;
      }
      break;
    case 255: 
      if (!j()) {
        break;
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.n)
    {
      VipUtils.a(null, "cmshow", "Apollo", "0X80065C8", this.v, 0, new String[0]);
      a(false);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramView != this.B) && (paramView != this.J))
    {
      if ((paramView != this.ai) && (paramView != this.ak))
      {
        if ((paramView != this.am) && (paramView != this.an))
        {
          if (paramView == this.C)
          {
            paramView = this.l;
            if (paramView == null) {
              return;
            }
            if (!this.U) {
              return;
            }
            int i1;
            if ((paramView.c) && (!this.z))
            {
              if (NetworkUtil.isNetworkAvailable(this.o))
              {
                if (Build.VERSION.SDK_INT >= 11) {
                  this.L.setAlpha(0.5F);
                }
                this.D.setTextColor(-2130706433);
                this.z = true;
                this.V.a(this.o, this.l.g, (AppInterface)this.y.get(), this.t, this.m);
                s();
              }
              else
              {
                QQToast.makeText(this.o, HardCodeUtil.a(2131898565), 0).show();
              }
              i1 = 1;
            }
            else
            {
              QQToast.makeText(this.o, HardCodeUtil.a(2131898555), 0).show();
              i1 = 2;
            }
            if ((this.l.m.size() > 2) && (((ApolloBoxData.BoxCardListSummary)this.l.m.get(2)).d > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "sendflower", i1, 0, new String[] { "3" });
            }
            if ((this.l.m.size() > 1) && (((ApolloBoxData.BoxCardListSummary)this.l.m.get(1)).d > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "sendflower", i1, 0, new String[] { "2" });
            }
            if ((this.l.m.size() > 0) && (((ApolloBoxData.BoxCardListSummary)this.l.m.get(0)).d > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "sendflower", i1, 0, new String[] { "1" });
            }
          }
          else if ((this == paramView) && (this.U) && (!this.ad))
          {
            VipUtils.a(null, "cmshow", "Apollo", "clickblackfloat", this.v, 0, new String[0]);
            a(false);
          }
        }
        else
        {
          paramView = this.l;
          if (paramView == null) {
            return;
          }
          if (paramView.m.size() > 2)
          {
            paramView = (ApolloBoxData.BoxCardListSummary)this.l.m.get(2);
            if (!TextUtils.isEmpty(paramView.f))
            {
              localObject1 = new Intent(this.o, QQBrowserActivity.class);
              ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_lmx");
              VasWebviewUtil.a(this.o, paramView.f, -1L, (Intent)localObject1, false, -1);
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C001", this.v, 0, new String[0]);
            }
          }
          a(false);
        }
      }
      else
      {
        if (this.l == null) {
          return;
        }
        paramView = new StringBuilder();
        paramView.append(ApolloConstant.z);
        paramView.append("&adtag=floatlayer");
        localObject1 = paramView.toString();
        paramView = (View)localObject1;
        if (this.l.m.size() > 1)
        {
          localObject2 = (ApolloBoxData.BoxCardListSummary)this.l.m.get(1);
          paramView = (View)localObject1;
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject2).f)) {
            paramView = ((ApolloBoxData.BoxCardListSummary)localObject2).f;
          }
        }
        localObject1 = new Intent(this.o, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.a(this.o, paramView, -1L, (Intent)localObject1, false, -1);
        VipUtils.a(null, "cmshow", "Apollo", "0X80065C03", this.v, 0, new String[0]);
        a(false);
      }
    }
    else
    {
      if (!this.U) {
        return;
      }
      if (this.l == null) {
        return;
      }
      localObject2 = new Intent(this.o, QQBrowserActivity.class);
      paramView = new StringBuilder();
      paramView.append(ApolloConstant.A);
      paramView.append("&adtag=floatlayer");
      localObject1 = paramView.toString();
      paramView = (View)localObject1;
      if (this.l.m.size() > 0)
      {
        ApolloBoxData.BoxCardListSummary localBoxCardListSummary = (ApolloBoxData.BoxCardListSummary)this.l.m.get(0);
        paramView = (View)localObject1;
        if (!TextUtils.isEmpty(localBoxCardListSummary.f)) {
          paramView = localBoxCardListSummary.f;
        }
      }
      ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.a(this.o, paramView, -1L, (Intent)localObject2, false, -1);
      VipUtils.a(null, "cmshow", "Apollo", "0X80065C01", this.v, 0, new String[0]);
      a(false);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label137;
          }
        }
        else
        {
          if (Math.hypot(Math.abs(this.ab - f1), Math.abs(this.ac - f2)) <= this.ae) {
            break label137;
          }
          this.ad = true;
          break label137;
        }
      }
      if (Math.hypot(Math.abs(this.ab - f1), Math.abs(this.ac - f2)) > this.ae) {
        this.ad = true;
      }
    }
    else
    {
      this.ab = f1;
      this.ac = f2;
      this.ad = false;
    }
    label137:
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow
 * JD-Core Version:    0.7.0.1
 */