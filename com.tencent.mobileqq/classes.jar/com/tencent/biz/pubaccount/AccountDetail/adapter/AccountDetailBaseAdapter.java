package com.tencent.biz.pubaccount.accountdetail.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.PublicAccountMenuBar;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.bean.MsgAttr;
import com.tencent.biz.pubaccount.accountdetail.bean.PictureAttr;
import com.tencent.biz.pubaccount.accountdetail.bean.VideoAttr;
import com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager.OnVideoPlayListener;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailBannerViewWrapper;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailJigsawViewWrapper;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailWindowViewWrapper;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class AccountDetailBaseAdapter
  extends BaseAdapter
  implements View.OnClickListener, AccountDetailVideoManager.OnVideoPlayListener
{
  private static int Y = 10;
  private static int Z = 20;
  View A;
  Drawable B;
  Drawable C;
  Drawable D;
  public Button E;
  AccountDetailXListView F;
  AccountDetailGroupListContainer G;
  public ImageView H;
  public ImageView I;
  public ImageView J;
  public Button K;
  float L;
  int M;
  public boolean N = false;
  int O = 0;
  int P = 0;
  AccountDetailVideoManager Q;
  AccountDetailBaseAdapter.FullScreenTopContainerHolder R = null;
  protected TranslateAnimation S;
  protected TranslateAnimation T;
  protected AnimatorSet U;
  boolean V = false;
  boolean W = false;
  boolean X = false;
  final int a = -1;
  private LayoutInflater aa;
  private int ab = PublicAccountDetailActivityImpl.NETWORK_UNKNOW;
  private boolean ac = true;
  private boolean ad = true;
  private Handler ae = null;
  private int af = 1;
  private boolean ag = false;
  private AccountDetailTopGestureLayout ah;
  private MqqHandler ai = new MqqHandler(Looper.getMainLooper());
  private ArrayList<DynamicInfo> aj = new ArrayList();
  private ArrayList<DynamicInfo> ak = new ArrayList();
  private ArrayList<IPublicAccountConfigAttr> al = new ArrayList();
  private ArrayList<IPublicAccountConfigAttr> am = new ArrayList();
  private AbsListView.OnScrollListener an = new AccountDetailBaseAdapter.6(this);
  private URLDrawableDownListener.Adapter ao = new AccountDetailBaseAdapter.13(this);
  private AccountDetailBaseAdapter.PrefetchListener ap;
  private long aq = 0L;
  final int b = 0;
  final int c = 1;
  final int d = 2;
  final int e = 3;
  final int f = 4;
  final int g = 5;
  final int h = 6;
  final int i = 7;
  final int j = 8;
  final int k = 9;
  final int l = 10;
  final int m = 11;
  final int n = 13;
  String o;
  String p;
  PublicAccountDetailImpl q;
  View r;
  EqqDetail s;
  boolean t = false;
  boolean u = false;
  QQAppInterface v;
  Context w;
  Activity x;
  AccountDetailBaseItemClickHandler y;
  boolean z = false;
  
  public AccountDetailBaseAdapter(QQAppInterface paramQQAppInterface, Context paramContext, PublicAccountDetailImpl paramPublicAccountDetailImpl, String paramString, boolean paramBoolean, AccountDetailXListView paramAccountDetailXListView, AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout)
  {
    this.v = paramQQAppInterface;
    this.aa = LayoutInflater.from(paramContext);
    this.w = paramContext;
    this.x = ((Activity)paramContext);
    this.q = paramPublicAccountDetailImpl;
    if (this.q != null) {
      this.af = PublicAccountDetailImpl.getReportAccountType(paramQQAppInterface, paramString, paramPublicAccountDetailImpl);
    }
    this.z = paramBoolean;
    this.o = paramString;
    this.p = paramQQAppInterface.getCurrentUin();
    this.ae = new Handler();
    this.F = paramAccountDetailXListView;
    this.L = this.F.getResources().getDisplayMetrics().density;
    this.P = ((PublicAccountDetailActivityImpl)this.x).getAccurateScreenDpi()[1];
    this.M = ((PublicAccountDetailActivityImpl)this.x).getAccurateScreenDpi()[0];
    e();
    if (paramBoolean)
    {
      this.y = new AccountDetailBaseItemClickHandler(paramQQAppInterface, paramContext, paramPublicAccountDetailImpl);
      paramQQAppInterface = (AccountDetailDynamicInfo)((IPublicAccountDetailDynamicDataManagerService)paramQQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(paramString);
      if (paramQQAppInterface != null)
      {
        a(paramQQAppInterface.a(), paramQQAppInterface.d);
        a(paramQQAppInterface.b());
      }
      paramQQAppInterface = this.q;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.cardStyle == 1))
      {
        this.u = true;
        w();
      }
      v();
      this.N = g();
      this.F.a(this.N ^ true);
    }
    this.ah = paramAccountDetailTopGestureLayout;
  }
  
  public AccountDetailBaseAdapter(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, AccountDetailXListView paramAccountDetailXListView, ImageView paramImageView1, ImageView paramImageView2, RelativeLayout paramRelativeLayout, ImageView paramImageView3, AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout)
  {
    this.v = paramQQAppInterface;
    this.aa = LayoutInflater.from(paramContext);
    this.w = paramContext;
    this.o = paramString;
    this.t = true;
    this.F = paramAccountDetailXListView;
    this.H = paramImageView1;
    this.I = paramImageView2;
    this.r = paramRelativeLayout;
    this.J = paramImageView3;
    this.L = this.F.getResources().getDisplayMetrics().density;
    e();
    this.ah = paramAccountDetailTopGestureLayout;
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "prefetch data");
    }
    AccountDetailBaseAdapter.PrefetchListener localPrefetchListener = this.ap;
    if (localPrefetchListener != null) {
      localPrefetchListener.a();
    }
  }
  
  private int B()
  {
    Resources localResources = this.x.getResources();
    return localResources.getDimensionPixelSize(localResources.getIdentifier("status_bar_height", "dimen", "android"));
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadImg start:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" count:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = System.currentTimeMillis();
    if (!NetworkUtil.isWifiConnected(this.w)) {
      return;
    }
    Object localObject = new ArrayList(this.aj);
    ThreadManager.post(new AccountDetailBaseAdapter.14(this, this.aq, (List)localObject, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "runShowAnimation");
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.U == null) {
        this.U = new AnimatorSet();
      }
      this.U.playTogether(new Animator[] { paramView1, paramView2 });
      this.U.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  private boolean a(IPublicAccountConfigAttr paramIPublicAccountConfigAttr)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIPublicAccountConfigAttr != null) && (paramIPublicAccountConfigAttr.getConfigs() != null))
    {
      Iterator localIterator = paramIPublicAccountConfigAttr.getConfigs().iterator();
      while (localIterator.hasNext())
      {
        IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)localIterator.next();
        int i1 = paramIPublicAccountConfigAttr.getType();
        if ((i1 != 5) && (i1 != 6))
        {
          if ((i1 == 7) && (!TextUtils.isEmpty(localPaConfigInfo.k)) && (!TextUtils.isEmpty(localPaConfigInfo.r))) {
            localArrayList.add(localPaConfigInfo);
          }
        }
        else if (!TextUtils.isEmpty(localPaConfigInfo.k)) {
          localArrayList.add(localPaConfigInfo);
        }
      }
    }
    return localArrayList.size() != 0;
  }
  
  protected static boolean b(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    boolean bool = false;
    if (paramPublicAccountDetailImpl == null) {
      return false;
    }
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(paramPublicAccountDetailImpl.accountFlag) == -2) {
      bool = true;
    }
    return bool;
  }
  
  private boolean b(IPublicAccountConfigAttr paramIPublicAccountConfigAttr)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.q;
    int i1;
    if (localObject != null) {
      i1 = ((PublicAccountDetailImpl)localObject).followType;
    } else {
      i1 = -1;
    }
    boolean bool = false;
    if ((paramIPublicAccountConfigAttr != null) && (paramIPublicAccountConfigAttr.getConfigs() != null))
    {
      localObject = paramIPublicAccountConfigAttr.getConfigs().iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)((Iterator)localObject).next();
        int i2;
        if ((localPaConfigInfo.d != 0) && ((localPaConfigInfo.d != 1) || (i1 != 1))) {
          i2 = 0;
        } else {
          i2 = 1;
        }
        if (i2 != 0)
        {
          i2 = paramIPublicAccountConfigAttr.getType();
          if (i2 != 2)
          {
            if ((i2 == 3) || (i2 == 4)) {
              if (localPaConfigInfo.e == 23)
              {
                if ((!TextUtils.isEmpty(localPaConfigInfo.k)) && (!TextUtils.isEmpty(localPaConfigInfo.b)) && (!TextUtils.isEmpty(localPaConfigInfo.c))) {
                  localArrayList.add(localPaConfigInfo);
                }
              }
              else if ((!TextUtils.isEmpty(localPaConfigInfo.k)) && (!TextUtils.isEmpty(localPaConfigInfo.b))) {
                localArrayList.add(localPaConfigInfo);
              }
            }
          }
          else if (localPaConfigInfo.e == 23)
          {
            if ((!TextUtils.isEmpty(localPaConfigInfo.k)) && (!TextUtils.isEmpty(localPaConfigInfo.c))) {
              localArrayList.add(localPaConfigInfo);
            }
          }
          else if (!TextUtils.isEmpty(localPaConfigInfo.k)) {
            localArrayList.add(localPaConfigInfo);
          }
        }
      }
    }
    if ((paramIPublicAccountConfigAttr != null) && (paramIPublicAccountConfigAttr.getType() == 4) && (localArrayList.size() % 2 != 0)) {
      localArrayList.remove(localArrayList.size() - 1);
    }
    if (localArrayList.size() != 0) {
      bool = true;
    }
    return bool;
  }
  
  private void v()
  {
    this.al.clear();
    Object localObject = this.q;
    if ((localObject != null) && (((PublicAccountDetailImpl)localObject).customConfigAttrs != null) && (this.q.customConfigAttrs.size() > 0))
    {
      localObject = this.q.customConfigAttrs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublicAccountConfigAttr localIPublicAccountConfigAttr = (IPublicAccountConfigAttr)((Iterator)localObject).next();
        int i1 = localIPublicAccountConfigAttr.getType();
        if (((i1 == 2) || (i1 == 3) || (i1 == 4)) && (b(localIPublicAccountConfigAttr))) {
          this.al.add(localIPublicAccountConfigAttr);
        }
      }
    }
  }
  
  private void w()
  {
    this.am.clear();
    Object localObject = this.q;
    if ((localObject != null) && (((PublicAccountDetailImpl)localObject).fullscreenConfigAttrs != null) && (this.q.fullscreenConfigAttrs.size() > 0))
    {
      localObject = this.q.fullscreenConfigAttrs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublicAccountConfigAttr localIPublicAccountConfigAttr = (IPublicAccountConfigAttr)((Iterator)localObject).next();
        int i1 = localIPublicAccountConfigAttr.getType();
        if (((i1 == 5) || (i1 == 6) || (i1 == 7)) && (a(localIPublicAccountConfigAttr))) {
          this.am.add(localIPublicAccountConfigAttr);
        }
      }
    }
  }
  
  private boolean x()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  @TargetApi(11)
  private void y()
  {
    Object localObject = this.R;
    if (localObject != null)
    {
      if (((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject).g.getVisibility() == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailBaseAdapter", 2, "startShowArrowAnimation");
      }
      localObject = this.S;
      if (localObject != null) {
        ((TranslateAnimation)localObject).cancel();
      }
      localObject = this.T;
      if (localObject != null) {
        ((TranslateAnimation)localObject).cancel();
      }
      this.S = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
      this.S.setDuration(200L);
      this.S.setFillAfter(true);
      this.T = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
      this.T.setDuration(300L);
      this.T.setFillAfter(true);
      this.S.setAnimationListener(new AccountDetailBaseAdapter.11(this));
      this.T.setAnimationListener(new AccountDetailBaseAdapter.12(this));
      this.R.g.startAnimation(this.S);
    }
  }
  
  @TargetApi(11)
  private void z()
  {
    Object localObject = this.R;
    if (localObject == null) {
      return;
    }
    if (((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject).g.getAnimation() != null)
    {
      this.R.g.getAnimation().setAnimationListener(null);
      this.R.g.getAnimation().cancel();
      this.R.g.clearAnimation();
    }
    localObject = this.S;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).setAnimationListener(null);
      this.S.cancel();
      this.S = null;
    }
    localObject = this.T;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).setAnimationListener(null);
      this.T.cancel();
      this.T = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = this.U;
      if (localObject != null)
      {
        localObject = ((AnimatorSet)localObject).getChildAnimations().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Animator localAnimator = (Animator)((Iterator)localObject).next();
          localAnimator.end();
          localAnimator.cancel();
        }
        this.U.end();
        this.U.cancel();
      }
      this.U = null;
    }
  }
  
  public int a()
  {
    return this.ak.size();
  }
  
  public void a(int paramInt)
  {
    this.O = paramInt;
  }
  
  void a(int paramInt, float paramFloat)
  {
    if (paramInt >= paramFloat)
    {
      h();
      if (this.z)
      {
        PublicAccountDetailImpl localPublicAccountDetailImpl = this.q;
        if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.followType != 1)) {
          d(paramInt);
        }
      }
    }
    else
    {
      i();
    }
  }
  
  void a(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (AccountDetailBaseAdapter.OtherTopHolder)paramView.getTag();
    float f2;
    float f1;
    if (x())
    {
      f2 = 76.0F;
      f1 = this.L;
    }
    else
    {
      f2 = 65.0F;
      f1 = this.L;
    }
    f1 *= f2;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.d.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.e.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramView.f.getLayoutParams();
    int i1;
    if (paramInt < f1)
    {
      f2 = paramInt * 70 / f1;
      float f3 = this.L;
      i1 = (int)((100.0F - f2) * f3);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      localLayoutParams1.topMargin = ((int)(f3 * 90.0F));
      i1 = localLayoutParams1.height + (int)(this.L * 4.0F);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      i1 = localLayoutParams1.topMargin;
      f2 = this.L;
      localLayoutParams2.topMargin = (i1 - (int)(2.0F * f2));
      i1 = (int)((20.0F - paramInt * 20 / f1) * f2);
      localLayoutParams3.width = i1;
      localLayoutParams3.height = i1;
      if (paramInt == 0)
      {
        localLayoutParams3.topMargin = ((int)(165.0F * f2));
        localLayoutParams3.leftMargin = ((int)(f2 * 72.0F));
      }
      else
      {
        i1 = localLayoutParams1.topMargin;
        double d1 = localLayoutParams1.height;
        Double.isNaN(d1);
        int i2 = (int)(d1 * 0.72D);
        f2 = paramInt * 2 / f1;
        localLayoutParams3.topMargin = (i1 + i2 + (int)(this.L * f2));
        d1 = localLayoutParams1.height;
        Double.isNaN(d1);
        localLayoutParams3.leftMargin = ((int)(d1 * 0.72D) + (int)(f2 * this.L));
      }
    }
    else
    {
      f2 = this.L;
      i1 = (int)(30.0F * f2);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      localLayoutParams1.topMargin = ((int)(22.0F * f2));
      i1 = (int)(32.0F * f2);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      localLayoutParams2.topMargin = ((int)(20.0F * f2));
      i1 = (int)(f2 * 8.0F);
      localLayoutParams3.height = i1;
      localLayoutParams3.width = i1;
    }
    paramView.d.post(new AccountDetailBaseAdapter.8(this, paramView, localLayoutParams1, localLayoutParams2, localLayoutParams3));
    a(paramInt, f1);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.B = paramDrawable;
  }
  
  void a(View paramView)
  {
    if (this.u)
    {
      paramView.findViewById(2131440819).setVisibility(8);
      return;
    }
    paramView = (TextView)paramView.findViewById(2131440818);
    if (paramView != null)
    {
      if (this.al.size() > 0)
      {
        paramView.setVisibility(0);
        return;
      }
      paramView.setVisibility(8);
    }
  }
  
  public void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, ImageView paramImageView3, Button paramButton)
  {
    this.H = paramImageView1;
    this.I = paramImageView2;
    this.r = paramView;
    this.J = paramImageView3;
    this.K = paramButton;
  }
  
  void a(AccountDetailBaseAdapter.DynamicItemHolder paramDynamicItemHolder, View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramDynamicItemHolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg: dynamic holder is null");
      }
      return;
    }
    DynamicInfo localDynamicInfo = (DynamicInfo)getItem(paramInt);
    if (localDynamicInfo == null)
    {
      if (QLog.isColorLevel())
      {
        paramDynamicItemHolder = new StringBuilder();
        paramDynamicItemHolder.append("setDataForDynamicMsg:");
        paramDynamicItemHolder.append(this.o);
        paramDynamicItemHolder.append("动态消息为空");
        QLog.d("AccountDetailBaseAdapter", 2, paramDynamicItemHolder.toString());
      }
      return;
    }
    if (localDynamicInfo.d == null)
    {
      if (QLog.isColorLevel())
      {
        paramDynamicItemHolder = new StringBuilder();
        paramDynamicItemHolder.append("setDataForDynamicMsg:");
        paramDynamicItemHolder.append(this.o);
        paramDynamicItemHolder.append("动态消息的消息属性为空");
        QLog.d("AccountDetailBaseAdapter", 2, paramDynamicItemHolder.toString());
      }
      return;
    }
    Object localObject3;
    if (!localDynamicInfo.g)
    {
      localDynamicInfo.g = true;
      localObject3 = new JSONObject();
      if (this.t) {}
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject3).put("cha_1", localDynamicInfo.d.h);
        ((JSONObject)localObject3).put("cha_2", this.af);
        localObject4 = this.v;
        str = this.o;
        if (this.q.followType != 1) {
          break label1003;
        }
        Object localObject1 = "02";
        ReportController.b((AppRuntime)localObject4, "dc01160", "Pb_account_lifeservice", str, "0X8007CA2", "0X8007CA2", 0, 0, (String)localObject1, String.valueOf(localDynamicInfo.d.d), String.valueOf(localDynamicInfo.d.a), ((JSONObject)localObject3).toString());
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("setDataForDynamicMsg: item:= ");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append("report msg: artical id=");
          ((StringBuilder)localObject1).append(localDynamicInfo.d.a);
          ((StringBuilder)localObject1).append("   artical name=");
          ((StringBuilder)localObject1).append(localDynamicInfo.a);
          ((StringBuilder)localObject1).append(" json=");
          ((StringBuilder)localObject1).append(((JSONObject)localObject3).toString());
          QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject1).toString());
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      paramInt = localDynamicInfo.d.d;
      boolean bool;
      if (paramInt == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localObject3 = localDynamicInfo.a;
      Object localObject4 = Long.valueOf(localDynamicInfo.d.f);
      Object localObject2 = "";
      String str = localDynamicInfo.d.c;
      Object localObject5;
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("setDataForDynamicMsg:title =");
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append("--coverUrl=");
        ((StringBuilder)localObject5).append("");
        ((StringBuilder)localObject5).append("--jumpUrl=");
        ((StringBuilder)localObject5).append(str);
        ((StringBuilder)localObject5).append("--isVideoMsg =");
        ((StringBuilder)localObject5).append(bool);
        QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject5).toString());
      }
      if (bool)
      {
        paramDynamicItemHolder.d.setVisibility(0);
        paramDynamicItemHolder.f.setVisibility(0);
        paramDynamicItemHolder.e.setVisibility(0);
        if (localDynamicInfo.f != null)
        {
          if (paramBoolean) {
            localObject2 = localDynamicInfo.f.i;
          } else {
            localObject2 = localDynamicInfo.f.b;
          }
          paramDynamicItemHolder.d.setText(UITools.a(localDynamicInfo.f.d));
        }
      }
      else
      {
        paramDynamicItemHolder.d.setVisibility(4);
        paramDynamicItemHolder.f.setVisibility(4);
        paramDynamicItemHolder.e.setVisibility(4);
        if (localDynamicInfo.e != null) {
          if (paramBoolean) {
            localObject2 = localDynamicInfo.e.c;
          } else {
            localObject2 = localDynamicInfo.e.a;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("当前的url是");
        ((StringBuilder)localObject5).append((String)localObject2);
        QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject5).toString());
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((Long)localObject4).longValue() > 0L))
      {
        localObject5 = this.w.getResources();
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#dddfe2"));
        if (paramBoolean) {}
        try
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, localColorDrawable, localColorDrawable, true);
          break label849;
          localObject2 = URLDrawable.getDrawable((String)localObject2, AIOUtils.b(124.0F, (Resources)localObject5), AIOUtils.b(95.0F, (Resources)localObject5), localColorDrawable, localColorDrawable, true);
          label849:
          paramDynamicItemHolder.a.setImageDrawable((Drawable)localObject2);
          paramDynamicItemHolder.b.setText((CharSequence)localObject3);
          paramDynamicItemHolder.c.setText(((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getDateTimeString(((Long)localObject4).longValue()));
          paramView.setOnClickListener(new AccountDetailBaseAdapter.5(this, paramInt, str, localDynamicInfo));
          return;
        }
        catch (Exception paramDynamicItemHolder)
        {
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("setDataForDynamicMsg:");
            paramView.append(paramDynamicItemHolder);
            QLog.d("AccountDetailBaseAdapter", 2, paramView.toString());
          }
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        paramDynamicItemHolder = new StringBuilder();
        paramDynamicItemHolder.append("setDataForDynamicMsg:");
        paramDynamicItemHolder.append(this.o);
        paramDynamicItemHolder.append("动态消息内容不合法");
        QLog.d("AccountDetailBaseAdapter", 2, paramDynamicItemHolder.toString());
      }
      return;
      label1003:
      localObject2 = "01";
    }
  }
  
  void a(AccountDetailBaseAdapter.ErrorItemHolder paramErrorItemHolder, View paramView)
  {
    float f1 = this.w.getResources().getDisplayMetrics().density;
    paramView.setClickable(false);
    paramView.setOnClickListener(null);
    if (this.ac) {
      if (this.ab == PublicAccountDetailActivityImpl.NETWORK_UNKNOW)
      {
        paramErrorItemHolder.a.setText(2131886140);
        paramErrorItemHolder.a.setVisibility(0);
        paramErrorItemHolder.c.setVisibility(4);
        paramErrorItemHolder.b.setVisibility(4);
      }
      else
      {
        int i1;
        if (this.ab == PublicAccountDetailActivityImpl.NETWORK_ERROR)
        {
          paramErrorItemHolder.a.setText(2131892951);
          paramView = paramErrorItemHolder.a;
          i1 = (int)(f1 * 5.0F);
          paramView.setPadding(0, i1, 0, i1);
          paramErrorItemHolder.b.setImageResource(2130839454);
          paramErrorItemHolder.c.setVisibility(0);
        }
        else if (this.ab == PublicAccountDetailActivityImpl.NO_MORE_DATA)
        {
          paramErrorItemHolder.a.setText(2131886143);
          paramErrorItemHolder.b.setImageResource(2130842670);
          paramView = paramErrorItemHolder.a;
          i1 = (int)(f1 * 5.0F);
          paramView.setPadding(0, i1, 0, i1);
          paramErrorItemHolder.c.setVisibility(4);
        }
      }
    }
    paramErrorItemHolder.c.setOnClickListener(new AccountDetailBaseAdapter.4(this, paramErrorItemHolder));
  }
  
  void a(AccountDetailBaseAdapter.FullScreenTopContainerHolder paramFullScreenTopContainerHolder)
  {
    Object localObject1 = this.q;
    if (localObject1 == null) {
      return;
    }
    this.R = paramFullScreenTopContainerHolder;
    int i1 = ((PublicAccountDetailImpl)localObject1).name.length();
    if ((i1 > 8) && (i1 < 13)) {
      paramFullScreenTopContainerHolder.d.setTextSize(2, 20.0F);
    }
    paramFullScreenTopContainerHolder.d.setText(this.q.name);
    if (this.q.certifiedGrade != 0) {
      paramFullScreenTopContainerHolder.c.setVisibility(0);
    } else {
      paramFullScreenTopContainerHolder.c.setVisibility(8);
    }
    if (this.z)
    {
      paramFullScreenTopContainerHolder.e.setVisibility(0);
      paramFullScreenTopContainerHolder.e.setText(this.q.summary.trim());
    }
    paramFullScreenTopContainerHolder.b.setImageDrawable(this.D);
    if (this.q.followType == 1)
    {
      if (this.X)
      {
        paramFullScreenTopContainerHolder.f.setVisibility(0);
        paramFullScreenTopContainerHolder.f.setText(null);
        paramFullScreenTopContainerHolder.f.setBackgroundResource(2130837606);
      }
      else
      {
        paramFullScreenTopContainerHolder.f.setVisibility(8);
      }
      this.K.setText(2131893004);
    }
    else
    {
      paramFullScreenTopContainerHolder.f.setVisibility(0);
      paramFullScreenTopContainerHolder.f.setText(this.w.getResources().getString(2131892922));
      this.K.setText(2131893005);
    }
    localObject1 = (PublicAccountConfigAttrImpl)getItem(0);
    if (localObject1 == null) {
      return;
    }
    if ((((PublicAccountConfigAttrImpl)localObject1).configs != null) && (((PublicAccountConfigAttrImpl)localObject1).configs.size() != 0))
    {
      Object localObject2 = ((IPublicAccountConfigAttr.PaConfigInfo)((PublicAccountConfigAttrImpl)localObject1).configs.get(0)).k;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#f7f9fe"));
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      if (((PublicAccountConfigAttrImpl)localObject1).type == 6) {
        localURLDrawableOptions.mPlayGifImage = true;
      }
      localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 1))
      {
        r();
      }
      else
      {
        paramFullScreenTopContainerHolder.a.setURLDrawableDownListener(this.ao);
        if ((this.Q == null) || (!this.W)) {
          q();
        }
      }
      paramFullScreenTopContainerHolder.a.setImageDrawable((Drawable)localObject2);
      y();
      if (((PublicAccountConfigAttrImpl)localObject1).type == 7)
      {
        if (this.Q == null) {
          this.Q = new AccountDetailVideoManager(this.x, this);
        }
        paramFullScreenTopContainerHolder.j.setVisibility(0);
        this.Q.a((PublicAccountConfigAttrImpl)localObject1, paramFullScreenTopContainerHolder.j);
      }
    }
  }
  
  void a(AccountDetailBaseAdapter.MenuHolder paramMenuHolder, View paramView)
  {
    paramView = this.q.getButtonInfo();
    if (paramView != null)
    {
      paramMenuHolder.a.a(this.v, this.o, this.ai);
      paramMenuHolder.a.setData(paramView);
    }
  }
  
  void a(AccountDetailBaseAdapter.OtherTopHolder paramOtherTopHolder)
  {
    int i1;
    if (this.t)
    {
      if (this.s == null) {
        return;
      }
      paramOtherTopHolder.c.setBackgroundColor(Color.parseColor("#3d7fe3"));
      i1 = this.s.name.length();
      if ((i1 > 8) && (i1 < 13)) {
        paramOtherTopHolder.g.setTextSize(2, 20.0F);
      }
      paramOtherTopHolder.g.setText(this.s.name);
      if (!TextUtils.isEmpty(this.s.displayNumber)) {
        paramOtherTopHolder.h.setText(this.s.displayNumber);
      } else {
        paramOtherTopHolder.h.setVisibility(8);
      }
      if (this.s.certifiedGrade != 0) {
        paramOtherTopHolder.f.setVisibility(0);
      } else {
        paramOtherTopHolder.f.setVisibility(8);
      }
      paramOtherTopHolder.m.setVisibility(8);
    }
    else
    {
      Object localObject = this.q;
      if (localObject == null) {
        return;
      }
      if (((PublicAccountDetailImpl)localObject).protocolVersion == 0)
      {
        paramOtherTopHolder.c.setBackgroundDrawable(this.B);
        paramOtherTopHolder.c.setImageDrawable(this.C);
        paramOtherTopHolder.c.setVisibility(0);
        paramOtherTopHolder.b.setVisibility(8);
        paramOtherTopHolder.k.setVisibility(8);
        paramOtherTopHolder.a.setBackgroundColor(0);
        paramOtherTopHolder.m.setVisibility(8);
        paramOtherTopHolder.l.setVisibility(8);
      }
      else
      {
        paramOtherTopHolder.c.setVisibility(8);
        paramOtherTopHolder.b.setVisibility(0);
        paramOtherTopHolder.i.setText(this.q.summary);
        paramOtherTopHolder.i.setMaxWidth((int)(this.M - this.L * 105.0F));
        paramOtherTopHolder.k.setVisibility(0);
        localObject = paramOtherTopHolder.k;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.q.sharedFollowerCount);
        localStringBuilder.append("位好友关注");
        ((TextView)localObject).setText(localStringBuilder.toString());
        paramOtherTopHolder.a.setBackgroundColor(-1);
        if (PublicAccountUtilImpl.getMessageHistoryInfo(this.q) != null)
        {
          paramOtherTopHolder.m.setVisibility(0);
          paramOtherTopHolder.l.setVisibility(0);
        }
        else
        {
          paramOtherTopHolder.m.setVisibility(8);
          paramOtherTopHolder.l.setVisibility(8);
        }
      }
      i1 = this.q.name.length();
      if ((i1 > 8) && (i1 < 13)) {
        paramOtherTopHolder.g.setTextSize(2, 20.0F);
      }
      paramOtherTopHolder.g.setText(this.q.name);
      if (!TextUtils.isEmpty(this.q.certifiedDescription)) {
        paramOtherTopHolder.h.setText(this.q.certifiedDescription);
      } else {
        paramOtherTopHolder.h.setVisibility(8);
      }
      if (this.q.certifiedGrade != 0) {
        paramOtherTopHolder.f.setVisibility(0);
      } else {
        paramOtherTopHolder.f.setVisibility(8);
      }
    }
    paramOtherTopHolder.d.setImageDrawable(this.D);
  }
  
  public void a(AccountDetailBaseAdapter.PrefetchListener paramPrefetchListener)
  {
    this.ap = paramPrefetchListener;
  }
  
  void a(AccountDetailBaseAdapter.SubscriptTopHolder paramSubscriptTopHolder)
  {
    if (this.q == null) {
      return;
    }
    paramSubscriptTopHolder.a.setBackgroundDrawable(this.B);
    paramSubscriptTopHolder.a.setImageDrawable(this.C);
    int i1 = this.q.name.length();
    if ((i1 > 8) && (i1 < 13)) {
      paramSubscriptTopHolder.e.setTextSize(2, 20.0F);
    }
    paramSubscriptTopHolder.e.setText(this.q.name);
    if (this.q.certifiedGrade != 0) {
      paramSubscriptTopHolder.d.setVisibility(0);
    } else {
      paramSubscriptTopHolder.d.setVisibility(8);
    }
    if ((b(this.q)) && (!TextUtils.isEmpty(this.q.certifiedDescription))) {
      paramSubscriptTopHolder.g.setText(this.q.certifiedDescription);
    } else {
      paramSubscriptTopHolder.g.setVisibility(8);
    }
    String str = a(this.q.summary);
    paramSubscriptTopHolder.f.setText(str);
    paramSubscriptTopHolder.b.setImageDrawable(this.D);
    if (this.q.followType == 1)
    {
      if (this.X)
      {
        paramSubscriptTopHolder.h.setVisibility(0);
        paramSubscriptTopHolder.h.setBackgroundResource(2130837606);
        paramSubscriptTopHolder.h.setText(null);
      }
      else
      {
        paramSubscriptTopHolder.h.setVisibility(8);
      }
      this.K.setText(2131893004);
      return;
    }
    paramSubscriptTopHolder.h.setVisibility(0);
    paramSubscriptTopHolder.h.setBackgroundResource(2130839460);
    paramSubscriptTopHolder.h.setText(this.w.getResources().getString(2131892922));
    paramSubscriptTopHolder.h.setTextColor(-1);
    this.K.setText(2131893005);
  }
  
  public void a(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    this.q = paramPublicAccountDetailImpl;
    if (this.z)
    {
      this.y = new AccountDetailBaseItemClickHandler(this.v, this.w, paramPublicAccountDetailImpl);
      v();
      if (paramPublicAccountDetailImpl.cardStyle == 1)
      {
        c(true);
        return;
      }
      c(false);
    }
  }
  
  public void a(EqqDetail paramEqqDetail)
  {
    this.s = paramEqqDetail;
  }
  
  public void a(ArrayList<DynamicInfo> paramArrayList)
  {
    this.ak.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.ak.addAll(paramArrayList);
    }
  }
  
  public void a(ArrayList<DynamicInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.aj.clear();
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.aj.addAll(paramArrayList);
      this.aq = System.nanoTime();
    }
    paramArrayList = new ArrayList();
    Iterator localIterator = this.aj.iterator();
    while (localIterator.hasNext())
    {
      DynamicInfo localDynamicInfo = (DynamicInfo)localIterator.next();
      if ((localDynamicInfo.f != null) && (localDynamicInfo.f.a != 1) && (localDynamicInfo.f.a != 2)) {
        paramArrayList.add(localDynamicInfo);
      } else if ((localDynamicInfo.d != null) && (localDynamicInfo.d.d != 1) && (localDynamicInfo.d.d != 2)) {
        paramArrayList.add(localDynamicInfo);
      }
    }
    this.aj.removeAll(paramArrayList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  boolean a(int paramInt1, View paramView, int paramInt2)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    boolean bool1;
    if (paramInt1 == 1)
    {
      bool3 = b(paramInt2);
      bool1 = bool2;
      if (paramView.getTag() != null)
      {
        bool1 = bool2;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.DynamicItemHolder))
        {
          bool1 = bool2;
          if (bool3 == ((AccountDetailBaseAdapter.DynamicItemHolder)paramView.getTag()).g) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if (paramInt1 == 2)
    {
      bool1 = bool3;
      if (paramView.getTag() != null)
      {
        bool1 = bool3;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.ErrorItemHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 == 0)
    {
      bool1 = bool4;
      if (paramView.getTag() != null)
      {
        bool1 = bool4;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.OtherTopHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 == 8)
    {
      bool1 = bool5;
      if (paramView.getTag() != null)
      {
        bool1 = bool5;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.SubscriptTopHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 == 9)
    {
      bool1 = bool6;
      if (paramView.getTag() != null)
      {
        bool1 = bool6;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.LoadingItemHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 == 10)
    {
      bool1 = bool7;
      if (paramView.getTag() != null)
      {
        bool1 = bool7;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.FullScreenTopContainerHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 == 11)
    {
      bool1 = bool8;
      if (paramView.getTag() != null)
      {
        bool1 = bool8;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.MenuHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return true;
  }
  
  public PublicAccountDetailImpl b()
  {
    return this.q;
  }
  
  void b(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (AccountDetailBaseAdapter.FullScreenTopContainerHolder)paramView.getTag();
    float f3 = this.L;
    if (x())
    {
      f1 = 64.0F;
      f2 = this.L;
    }
    else
    {
      f1 = 75.0F;
      f2 = this.L;
    }
    float f1 = f3 * 170.0F - f2 * f1 / 2.0F;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.b.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.c.getLayoutParams();
    float f2 = paramInt;
    if (f2 < f1)
    {
      paramView.b.setVisibility(0);
      if (this.q.certifiedGrade != 0) {
        paramView.c.setVisibility(0);
      } else {
        paramView.c.setVisibility(8);
      }
      int i1;
      if (paramInt <= 0)
      {
        f2 = this.L;
        i1 = (int)(90.0F * f2);
        localLayoutParams1.width = i1;
        localLayoutParams1.height = i1;
        i1 = (int)(20.0F * f2);
        localLayoutParams2.width = i1;
        localLayoutParams2.height = i1;
        localLayoutParams2.topMargin = ((int)(f2 * 58.0F));
        localLayoutParams2.leftMargin = ((int)(f2 * 58.0F));
      }
      else
      {
        f2 = paramInt * 50 / f1;
        f3 = this.L;
        i1 = (int)((90.0F - f2) * f3);
        localLayoutParams1.width = i1;
        localLayoutParams1.height = i1;
        i1 = (int)((20.0F - paramInt * 20 / f1) * f3);
        localLayoutParams2.width = i1;
        localLayoutParams2.height = i1;
        double d1 = localLayoutParams1.height;
        Double.isNaN(d1);
        i1 = (int)(d1 * 0.64D);
        f2 = paramInt * 2 / f1;
        localLayoutParams2.topMargin = (i1 + (int)(this.L * f2));
        d1 = localLayoutParams1.height;
        Double.isNaN(d1);
        localLayoutParams2.leftMargin = ((int)(d1 * 0.64D) + (int)(f2 * this.L));
      }
      paramView.b.post(new AccountDetailBaseAdapter.9(this, paramView, localLayoutParams1, localLayoutParams2));
    }
    else if (f2 >= f1)
    {
      paramView.b.setVisibility(4);
      paramView.c.setVisibility(4);
    }
    a(paramInt, f1);
  }
  
  public void b(Drawable paramDrawable)
  {
    this.C = paramDrawable;
  }
  
  public void b(View paramView)
  {
    this.A = paramView;
  }
  
  public void b(boolean paramBoolean)
  {
    this.ad = paramBoolean;
  }
  
  public boolean b(int paramInt)
  {
    DynamicInfo localDynamicInfo = (DynamicInfo)this.aj.get(paramInt - this.al.size() - 2);
    if (localDynamicInfo != null)
    {
      if ((localDynamicInfo.e != null) && (localDynamicInfo.e.b == 1)) {
        return true;
      }
      if ((localDynamicInfo.f != null) && (localDynamicInfo.f.h == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public EqqDetail c()
  {
    return this.s;
  }
  
  public void c(int paramInt)
  {
    this.ab = paramInt;
  }
  
  void c(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (AccountDetailBaseAdapter.SubscriptTopHolder)paramView.getTag();
    float f2;
    float f1;
    if (x())
    {
      f2 = 41.0F;
      f1 = this.L;
    }
    else
    {
      f2 = 30.0F;
      f1 = this.L;
    }
    f1 *= f2;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.b.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.c.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramView.d.getLayoutParams();
    if (paramInt < f1)
    {
      paramView.b.setVisibility(0);
      paramView.c.setVisibility(0);
      if (this.q.certifiedGrade != 0) {
        paramView.d.setVisibility(0);
      } else {
        paramView.d.setVisibility(8);
      }
      f2 = paramInt * 50 / f1;
      float f3 = this.L;
      int i1 = (int)((90.0F - f2) * f3);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      localLayoutParams1.topMargin = ((int)(f3 * 60.0F));
      i1 = localLayoutParams1.height;
      f2 = this.L;
      i1 += (int)(4.0F * f2);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      localLayoutParams2.topMargin = ((int)(58.0F * f2));
      i1 = (int)((20.0F - paramInt * 20 / f1) * f2);
      localLayoutParams3.width = i1;
      localLayoutParams3.height = i1;
      if (paramInt == 0)
      {
        i1 = (int)(f2 * 65.0F);
        localLayoutParams3.leftMargin = i1;
        localLayoutParams3.topMargin = i1;
      }
      else
      {
        double d1 = localLayoutParams1.height;
        Double.isNaN(d1);
        i1 = (int)(d1 * 0.72D) + (int)(paramInt * 2 / f1 * this.L);
        localLayoutParams3.leftMargin = i1;
        localLayoutParams3.topMargin = i1;
      }
      paramView.b.post(new AccountDetailBaseAdapter.10(this, paramView, localLayoutParams1, localLayoutParams2, localLayoutParams3));
    }
    else
    {
      paramView.b.setVisibility(4);
      paramView.c.setVisibility(4);
      paramView.d.setVisibility(4);
    }
    a(paramInt, f1);
  }
  
  public void c(Drawable paramDrawable)
  {
    this.D = paramDrawable;
  }
  
  void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
    if (paramBoolean)
    {
      w();
      return;
    }
    this.am.clear();
  }
  
  public void d()
  {
    Object localObject = this.G;
    if (localObject != null) {
      ((AccountDetailGroupListContainer)localObject).b();
    }
    localObject = this.ae;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.ae = null;
    }
    z();
    p();
    ((IImageManager)QRoute.api(IImageManager.class)).clean();
  }
  
  void d(int paramInt)
  {
    float f1;
    float f2;
    if (this.u)
    {
      if (b(this.q))
      {
        f1 = 258.0F;
        f2 = this.L;
      }
      else
      {
        f1 = 234.0F;
        f2 = this.L;
      }
    }
    else if (b(this.q))
    {
      f1 = 217.0F;
      f2 = this.L;
    }
    else
    {
      f1 = 173.0F;
      f2 = this.L;
    }
    int i1 = (int)(f2 * f1);
    AlphaAnimation localAlphaAnimation;
    if ((this.K.getVisibility() == 8) && (paramInt >= i1))
    {
      this.K.setVisibility(0);
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(100L);
      localAlphaAnimation.setFillBefore(true);
      this.K.startAnimation(localAlphaAnimation);
      return;
    }
    if ((paramInt < i1) && (this.K.getVisibility() == 0))
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(100L);
      this.K.startAnimation(localAlphaAnimation);
      this.K.setVisibility(8);
    }
  }
  
  void d(boolean paramBoolean)
  {
    AccountDetailBaseAdapter.FullScreenTopContainerHolder localFullScreenTopContainerHolder = this.R;
    if (localFullScreenTopContainerHolder != null)
    {
      if (paramBoolean)
      {
        localFullScreenTopContainerHolder.a.setVisibility(0);
        return;
      }
      localFullScreenTopContainerHolder.a.setVisibility(8);
      r();
    }
  }
  
  public void e()
  {
    this.F.setOnScrollListener(this.an);
    this.F.setOnEndScrollListener(new AccountDetailBaseAdapter.7(this));
  }
  
  void e(int paramInt)
  {
    this.F.smoothScrollBy(this.P - paramInt - this.r.getHeight(), 500);
    h();
    if (this.z)
    {
      PublicAccountDetailImpl localPublicAccountDetailImpl = this.q;
      if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.followType != 1)) {
        d(paramInt);
      }
    }
  }
  
  public int f()
  {
    View localView = this.F.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    return localView.getTop();
  }
  
  public boolean g()
  {
    boolean bool;
    if (this.aj.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.ac = bool;
    return (this.ac) && ((this.ab == PublicAccountDetailActivityImpl.NETWORK_UNKNOW) || (this.ab == PublicAccountDetailActivityImpl.NETWORK_ERROR) || (this.ab == PublicAccountDetailActivityImpl.NO_MORE_DATA));
  }
  
  public int getCount()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.q;
    int i1 = 1;
    if ((localPublicAccountDetailImpl == null) && (this.s == null)) {
      return 1;
    }
    localPublicAccountDetailImpl = this.q;
    if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.protocolVersion == 1))
    {
      if (this.q.getButtonInfo() != null) {
        return 2;
      }
      return 1;
    }
    if (this.z)
    {
      int i2 = this.al.size();
      if (this.aj.size() > 0) {
        i1 = 1 + this.aj.size();
      } else if (!this.N) {
        i1 = 0;
      }
      return i2 + 1 + i1;
    }
    return 2;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.q == null) && (this.s == null)) {
      return null;
    }
    Object localObject = this.q;
    if ((localObject != null) && (((PublicAccountDetailImpl)localObject).protocolVersion == 1)) {
      return null;
    }
    if (this.z)
    {
      if (paramInt == 0)
      {
        if (this.u)
        {
          localObject = this.am;
          if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
            return this.am.get(paramInt);
          }
        }
        return null;
      }
      if (paramInt <= this.al.size()) {
        return this.al.get(paramInt - 1);
      }
      if (this.N) {
        return null;
      }
      if (paramInt == this.al.size() + 1) {
        return null;
      }
      return this.aj.get(paramInt - this.al.size() - 2);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.q == null) && (this.s == null)) {
      return 9;
    }
    if (this.z)
    {
      if (paramInt == 0)
      {
        if (this.u) {
          return 10;
        }
        return 8;
      }
      if (paramInt <= this.al.size())
      {
        paramInt = ((IPublicAccountConfigAttr)this.al.get(paramInt - 1)).getType();
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return -1;
            }
            return 5;
          }
          return 4;
        }
        return 3;
      }
      if (this.N) {
        return 2;
      }
      if (paramInt == this.al.size() + 1) {
        return 6;
      }
      return 1;
    }
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.q;
    if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.protocolVersion == 1))
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return -1;
        }
        return 11;
      }
      return 0;
    }
    if (paramInt == 0) {
      return 0;
    }
    return 7;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = getItemViewType(paramInt);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView->pos:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", type:");
      ((StringBuilder)localObject1).append(i1);
      QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject6 = paramView;
    boolean bool3 = a(i1, (View)localObject6, paramInt);
    Object localObject7 = null;
    Object localObject8 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject3;
    Object localObject5;
    Object localObject2;
    Object localObject4;
    if (bool3)
    {
      if (i1 != 0) {
        if (i1 != 1) {
          if (i1 != 2)
          {
            switch (i1)
            {
            default: 
              break;
            case 11: 
              localObject3 = (AccountDetailBaseAdapter.MenuHolder)paramView.getTag();
              localObject5 = null;
              paramView = (View)localObject5;
              localObject1 = paramView;
              localObject2 = localObject1;
              localObject4 = localObject2;
              break;
            case 10: 
              localObject1 = (AccountDetailBaseAdapter.FullScreenTopContainerHolder)paramView.getTag();
              paramView = this.Q;
              if (paramView != null) {
                paramView.l = false;
              }
              localObject5 = null;
              localObject4 = localObject5;
              paramView = (View)localObject4;
              break;
            case 9: 
              localObject4 = (AccountDetailBaseAdapter.LoadingItemHolder)paramView.getTag();
              localObject5 = null;
              paramView = (View)localObject5;
              localObject1 = paramView;
              localObject2 = localObject1;
              localObject3 = localObject2;
              break;
            case 8: 
              localObject5 = (AccountDetailBaseAdapter.SubscriptTopHolder)paramView.getTag();
              break;
            }
            localObject5 = null;
            localObject4 = null;
          }
        }
      }
      Object localObject9;
      Object localObject10;
      Object localObject11;
      for (localObject1 = null;; localObject1 = localObject5)
      {
        paramView = (View)localObject1;
        localObject3 = paramView;
        localObject2 = paramView;
        paramView = (View)localObject4;
        for (;;)
        {
          localObject4 = localObject3;
          bool1 = false;
          localObject7 = localObject8;
          localObject8 = localObject1;
          localObject9 = localObject2;
          localObject10 = localObject3;
          localObject11 = localObject4;
          break;
          localObject2 = (AccountDetailBaseAdapter.ErrorItemHolder)paramView.getTag();
          localObject5 = null;
          paramView = (View)localObject5;
          localObject1 = paramView;
          localObject3 = localObject1;
        }
        localObject7 = (AccountDetailBaseAdapter.DynamicItemHolder)paramView.getTag();
        bool1 = b(paramInt);
        paramView = null;
        localObject8 = paramView;
        localObject9 = localObject8;
        localObject10 = localObject9;
        localObject11 = localObject10;
        localObject5 = localObject11;
        break;
        localObject4 = (AccountDetailBaseAdapter.OtherTopHolder)paramView.getTag();
        localObject5 = null;
      }
      localObject1 = localObject7;
      localObject7 = paramView;
      paramView = (View)localObject6;
      localObject2 = localObject5;
      localObject3 = localObject8;
      localObject4 = localObject9;
      localObject5 = localObject10;
      localObject6 = localObject11;
    }
    else
    {
      if (i1 != 0)
      {
        if (i1 != 1) {
          if (i1 != 2) {
            switch (i1)
            {
            default: 
              localObject1 = null;
              paramView = (View)localObject6;
            }
          }
        }
        for (;;)
        {
          localObject2 = null;
          localObject3 = null;
          localObject4 = localObject3;
          localObject5 = localObject4;
          localObject6 = localObject5;
          break;
          paramView = this.aa.inflate(2131623969, paramViewGroup, false);
          localObject5 = new AccountDetailBaseAdapter.MenuHolder(this);
          ((AccountDetailBaseAdapter.MenuHolder)localObject5).a = ((PublicAccountMenuBar)paramView.findViewById(2131438147));
          paramView.setTag(localObject5);
          localObject1 = null;
          localObject2 = localObject1;
          localObject3 = localObject2;
          localObject4 = localObject3;
          localObject6 = localObject4;
          bool1 = bool2;
          break;
          paramView = this.aa.inflate(2131623972, paramViewGroup, false);
          localObject1 = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).height = this.P;
          if (x()) {
            ((ViewGroup.LayoutParams)localObject1).height -= B();
          }
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramView.setOnClickListener(null);
          localObject3 = new AccountDetailBaseAdapter.FullScreenTopContainerHolder(this);
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).a = ((URLImageView)paramView.findViewById(2131449520));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).b = ((ImageView)paramView.findViewById(2131435219));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).c = ((ImageView)paramView.findViewById(2131430460));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).d = ((TextView)paramView.findViewById(2131427445));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).e = ((TextView)paramView.findViewById(2131427447));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).j = ((FrameLayout)paramView.findViewById(2131449657));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).f = ((Button)paramView.findViewById(2131427443));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).g = paramView.findViewById(2131427441);
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).h = ((ImageView)paramView.findViewById(2131427439));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).i = ((ImageView)paramView.findViewById(2131427440));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).k = ((ImageView)paramView.findViewById(2131437622));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).l = ((TextView)paramView.findViewById(2131447419));
          float f1 = FontSettingManager.getFontLevel() / 16.0F;
          if (f1 > 1.0F) {
            ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).e.setTextSize(14 / f1);
          } else {
            ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).e.setTextSize(14);
          }
          this.E = ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).f;
          this.E.setOnClickListener(this);
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).g.setOnClickListener(new AccountDetailBaseAdapter.2(this));
          paramView.findViewById(2131427449).setOnClickListener(new AccountDetailBaseAdapter.3(this));
          paramView.setTag(localObject3);
          localObject1 = this.Q;
          if (localObject1 != null) {
            ((AccountDetailVideoManager)localObject1).l = true;
          }
          localObject2 = null;
          localObject4 = localObject2;
          localObject5 = localObject4;
          localObject6 = localObject5;
          break label1559;
          paramView = this.aa.inflate(2131623968, paramViewGroup, false);
          paramView.setLayoutParams(new AbsListView.LayoutParams(this.w.getResources().getDisplayMetrics().widthPixels, this.w.getResources().getDisplayMetrics().heightPixels));
          paramView.setOnClickListener(null);
          localObject6 = new AccountDetailBaseAdapter.LoadingItemHolder(this);
          ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).a = ((TextView)paramView.findViewById(2131437659));
          ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).b = ((ImageView)paramView.findViewById(2131437646));
          ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).c = ((TextView)paramView.findViewById(2131444729));
          paramView.setTag(localObject6);
          localObject2 = null;
          localObject3 = localObject2;
          localObject4 = localObject3;
          localObject5 = localObject4;
          break label1559;
          paramView = this.aa.inflate(2131623973, paramViewGroup, false);
          paramView.setOnClickListener(null);
          localObject2 = new AccountDetailBaseAdapter.SubscriptTopHolder(this);
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).a = ((ImageView)paramView.findViewById(2131437916));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).b = ((ImageView)paramView.findViewById(2131435219));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).c = ((ImageView)paramView.findViewById(2131435232));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).d = ((ImageView)paramView.findViewById(2131430460));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).e = ((TextView)paramView.findViewById(2131427445));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).f = ((TextView)paramView.findViewById(2131427447));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).g = ((TextView)paramView.findViewById(2131427444));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).h = ((Button)paramView.findViewById(2131427443));
          this.E = ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).h;
          this.E.setOnClickListener(this);
          paramView.findViewById(2131427449).setOnClickListener(new AccountDetailBaseAdapter.1(this));
          f1 = FontSettingManager.getFontLevel() / 16.0F;
          if (f1 > 1.0F) {
            ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).f.setTextSize(14 / f1);
          } else {
            ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).f.setTextSize(14);
          }
          paramView.setTag(localObject2);
          break label1453;
          if (this.t)
          {
            paramView = this.A;
          }
          else
          {
            if (this.G == null) {
              this.G = new AccountDetailGroupListContainer(this.v, this.w, this.o, this.q, false);
            }
            paramView = this.G.c();
          }
          paramView.setPadding(0, AIOUtils.b(7.0F, this.w.getResources()), 0, 0);
          paramView.setMinimumHeight(this.O);
          break label1450;
          paramView = this.aa.inflate(2131623967, paramViewGroup, false);
          paramView.setOnClickListener(null);
          label1450:
          localObject2 = null;
          label1453:
          localObject4 = null;
          localObject5 = localObject4;
          break label1552;
          paramView = this.aa.inflate(2131625630, paramViewGroup, false);
          localObject4 = new AccountDetailBaseAdapter.ErrorItemHolder(this);
          ((AccountDetailBaseAdapter.ErrorItemHolder)localObject4).a = ((TextView)paramView.findViewById(2131427442));
          ((AccountDetailBaseAdapter.ErrorItemHolder)localObject4).b = ((ImageView)paramView.findViewById(2131440817));
          ((AccountDetailBaseAdapter.ErrorItemHolder)localObject4).c = ((TextView)paramView.findViewById(2131440833));
          paramView.setTag(localObject4);
          paramView.setMinimumHeight(this.P);
          localObject2 = null;
          localObject5 = localObject2;
          label1552:
          localObject3 = null;
          localObject6 = localObject5;
          label1559:
          localObject1 = null;
          bool1 = false;
          break;
          bool1 = b(paramInt);
          if (bool1) {
            paramView = this.aa.inflate(2131625640, paramViewGroup, false);
          } else {
            paramView = this.aa.inflate(2131625631, paramViewGroup, false);
          }
          localObject1 = new AccountDetailBaseAdapter.DynamicItemHolder(this);
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).a = ((URLImageView)paramView.findViewById(2131432274));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).b = ((TextView)paramView.findViewById(2131432277));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).c = ((TextView)paramView.findViewById(2131432276));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).d = ((TextView)paramView.findViewById(2131432289));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).e = ((ImageView)paramView.findViewById(2131432288));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).f = ((ImageView)paramView.findViewById(2131432275));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).g = bool1;
          paramView.setTag(localObject1);
        }
      }
      paramView = this.aa.inflate(2131623971, paramViewGroup, false);
      paramView.setOnClickListener(null);
      localObject7 = new AccountDetailBaseAdapter.OtherTopHolder(this);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).a = paramView.findViewById(2131447721);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).c = ((ImageView)paramView.findViewById(2131437916));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).b = paramView.findViewById(2131446629);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).d = ((ImageView)paramView.findViewById(2131435219));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).e = ((ImageView)paramView.findViewById(2131435232));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).f = ((ImageView)paramView.findViewById(2131430460));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).g = ((TextView)paramView.findViewById(2131427445));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).h = ((TextView)paramView.findViewById(2131427444));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).i = ((TextView)paramView.findViewById(2131427447));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).j = ((ImageView)paramView.findViewById(2131427448));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).k = ((TextView)paramView.findViewById(2131445809));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).b.setOnClickListener(this);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).l = paramView.findViewById(2131432003);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).m = paramView.findViewById(2131435062);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).m.setOnClickListener(this);
      paramView.setTag(localObject7);
      localObject2 = null;
      localObject3 = localObject2;
      localObject4 = localObject3;
      localObject5 = localObject4;
      localObject6 = localObject5;
      bool1 = false;
      localObject1 = localObject6;
    }
    if (i1 == 0)
    {
      a((AccountDetailBaseAdapter.OtherTopHolder)localObject7);
      return paramView;
    }
    if (i1 == 8)
    {
      a((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2);
      return paramView;
    }
    if (i1 == 10)
    {
      a((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3);
      return paramView;
    }
    if (i1 == 1)
    {
      a((AccountDetailBaseAdapter.DynamicItemHolder)localObject1, paramView, paramInt, bool1);
      return paramView;
    }
    if (i1 == 6)
    {
      a(paramView);
      return paramView;
    }
    if (i1 == 2)
    {
      a((AccountDetailBaseAdapter.ErrorItemHolder)localObject4, paramView);
      return paramView;
    }
    if (i1 == 9)
    {
      if (this.ad)
      {
        ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).a.setVisibility(0);
        ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).b.setVisibility(0);
        ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).c.setVisibility(8);
        return paramView;
      }
      ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).a.setVisibility(8);
      ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).b.setVisibility(8);
      ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).c.setVisibility(0);
      return paramView;
    }
    if (i1 == 11)
    {
      a((AccountDetailBaseAdapter.MenuHolder)localObject5, paramView);
      return paramView;
    }
    Object localObject1 = (PublicAccountConfigAttrImpl)getItem(paramInt);
    if (i1 != 3)
    {
      if (i1 != 4)
      {
        if (i1 != 5) {
          return paramView;
        }
        return AccountDetailJigsawViewWrapper.a(this.w, paramView, paramViewGroup, (PublicAccountConfigAttrImpl)localObject1, this.q.followType, this.y, this.o, this.p);
      }
      paramViewGroup = AccountDetailWindowViewWrapper.a(this.w, paramView, paramViewGroup, (PublicAccountConfigAttrImpl)localObject1, this.q.followType, this.y, this.o, this.p);
      localObject1 = this.ah;
      paramView = paramViewGroup;
      if (localObject1 != null)
      {
        ((AccountDetailTopGestureLayout)localObject1).a(paramViewGroup);
        return paramViewGroup;
      }
    }
    else
    {
      paramViewGroup = AccountDetailBannerViewWrapper.a(this.w, paramView, paramViewGroup, (PublicAccountConfigAttrImpl)localObject1, this.q.followType, this.y, this.o, this.p);
      localObject1 = this.ah;
      paramView = paramViewGroup;
      if (localObject1 != null)
      {
        ((AccountDetailTopGestureLayout)localObject1).a(paramViewGroup);
        paramView = paramViewGroup;
      }
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 13;
  }
  
  void h()
  {
    this.r.setBackgroundColor(j());
    this.H.setVisibility(0);
    this.H.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.v, 1, this.o));
    this.I.setVisibility(0);
    this.J.setVisibility(8);
  }
  
  void i()
  {
    this.r.setBackgroundColor(0);
    this.H.setVisibility(8);
    this.I.setVisibility(8);
    this.J.setVisibility(8);
    if (this.z) {
      this.K.setVisibility(8);
    }
  }
  
  protected int j()
  {
    if (!this.t)
    {
      Object localObject = this.q;
      if (localObject != null)
      {
        if ((((PublicAccountDetailImpl)localObject).configBackgroundColor == null) || (this.q.configBackgroundColor.equals(""))) {
          this.q.configBackgroundColor = "3d7fe3";
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(this.q.configBackgroundColor.substring(0, 6));
        return Color.parseColor(((StringBuilder)localObject).toString());
      }
    }
    return Color.parseColor("#3d7fe3");
  }
  
  public AccountDetailVideoManager k()
  {
    AccountDetailVideoManager localAccountDetailVideoManager = this.Q;
    if (localAccountDetailVideoManager != null) {
      return localAccountDetailVideoManager;
    }
    return null;
  }
  
  void l()
  {
    this.F.smoothScrollToPosition(0);
    i();
  }
  
  public void m()
  {
    this.W = true;
    d(false);
  }
  
  public void n()
  {
    d(true);
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.N) && (!g()))
    {
      this.N = false;
      this.F.setAdapter(null);
      this.F.a(true);
      this.F.setAdapter(this);
    }
    super.notifyDataSetChanged();
  }
  
  public void o()
  {
    this.W = false;
    d(true);
  }
  
  public void onClick(View paramView)
  {
    Activity localActivity = this.x;
    if ((localActivity != null) && ((localActivity instanceof View.OnClickListener)))
    {
      if (paramView == this.E) {
        this.X = true;
      }
      ((View.OnClickListener)this.x).onClick(paramView);
    }
  }
  
  void p()
  {
    Button localButton = this.K;
    if ((localButton != null) && (localButton.getAnimation() != null))
    {
      this.K.getAnimation().cancel();
      this.K.clearAnimation();
    }
  }
  
  void q()
  {
    if (this.R == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "showLoadingView");
    }
    this.R.k.setVisibility(0);
    this.R.k.setImageDrawable(this.w.getResources().getDrawable(2130844325));
    this.R.k.clearAnimation();
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(500L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setRepeatMode(1);
    localRotateAnimation.setStartTime(-1L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.R.k.startAnimation(localRotateAnimation);
    this.R.l.setVisibility(8);
  }
  
  void r()
  {
    if (this.R == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "hideLoadingView");
    }
    this.R.k.clearAnimation();
    this.R.k.setVisibility(8);
    this.R.l.setVisibility(8);
  }
  
  void s()
  {
    AccountDetailBaseAdapter.FullScreenTopContainerHolder localFullScreenTopContainerHolder = this.R;
    if (localFullScreenTopContainerHolder == null) {
      return;
    }
    localFullScreenTopContainerHolder.k.clearAnimation();
    this.R.k.setVisibility(0);
    this.R.k.setImageDrawable(this.w.getResources().getDrawable(2130837610));
    this.R.l.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter
 * JD-Core Version:    0.7.0.1
 */