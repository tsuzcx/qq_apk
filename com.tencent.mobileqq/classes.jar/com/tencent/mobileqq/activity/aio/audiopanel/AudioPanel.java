package com.tencent.mobileqq.activity.aio.audiopanel;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AudioPanel
  extends LinearLayout
  implements Handler.Callback, View.OnClickListener, ViewPager.OnPageChangeListener, AudioTransitionAnimManager.TransitionAnimListener
{
  private static PopupWindow O;
  private static final int P;
  private static final int Q;
  private static final float R;
  private static final int S;
  private static final int[] b = { 1038, 1948, 2857, 3766, 4675, 5584, 6493, 7402, 8311, 10000 };
  private static final int c;
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private RelativeLayout D;
  private PttTextTransitionAnim E;
  private ImageView F;
  private boolean G = false;
  private boolean H = false;
  private int I = -1;
  private boolean J = false;
  private int K;
  private float L;
  private int M = 0;
  private LottieDrawable N;
  private Rect T;
  private Rect U;
  private Paint V;
  private float W;
  private int Z;
  View a;
  private float aa;
  private boolean ab;
  private WeakReferenceHandler ac = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private Runnable ad = new AudioPanel.2(this);
  private boolean d;
  private int e = 1;
  private SessionInfo f;
  private QQAppInterface g;
  private AudioPanelViewPager h;
  private ViewGroup i;
  private AudioPanelAdapter j;
  private PressToSpeakPanel k;
  private InputLinearLayout l;
  private PanelIconLinearLayout m;
  private TextView n;
  private TextView o;
  private TextView p;
  private String[] q = new String[3];
  private ViewGroup r;
  private boolean s = false;
  private int t;
  private int u;
  private int v;
  private BaseChatPie w;
  private int x = -1;
  private boolean y = false;
  private boolean z = false;
  
  static
  {
    int[] arrayOfInt = b;
    c = arrayOfInt[1] - arrayOfInt[0];
    O = null;
    if (Build.VERSION.SDK_INT >= 16) {
      i1 = 55;
    } else if (Build.VERSION.SDK_INT > 9) {
      i1 = 65;
    } else {
      i1 = 85;
    }
    P = i1;
    int i2 = P;
    if (Build.VERSION.SDK_INT >= 16) {
      i1 = 4;
    } else if (Build.VERSION.SDK_INT > 9) {
      i1 = 6;
    } else {
      i1 = 8;
    }
    Q = i2 - i1;
    int i1 = P;
    i2 = Q;
    R = (i1 + i2) * 0.52F / 1200.0F;
    S = (i1 + i2) * -40 / 1200;
  }
  
  public AudioPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AudioPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup1.getParent();
    int i2 = localViewGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (localViewGroup.getChildAt(i1) == paramViewGroup1) {
        break label46;
      }
      i1 += 1;
    }
    i1 = -1;
    label46:
    paramViewGroup2 = null;
    if (i1 >= 0)
    {
      paramViewGroup2 = new View(paramContext);
      paramContext = new RelativeLayout.LayoutParams(-1, paramViewGroup1.getHeight());
      paramContext.addRule(6, paramViewGroup1.getId());
      paramContext.addRule(8, paramViewGroup1.getId());
      paramViewGroup2.setLayoutParams(paramContext);
      localViewGroup.addView(paramViewGroup2, i1);
    }
    return paramViewGroup2;
  }
  
  public static PopupWindow a(Context paramContext, int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4, int paramInt5)
  {
    PopupWindow localPopupWindow = O;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
      return O;
    }
    paramContext = new View(paramContext);
    paramContext.setBackgroundColor(1275068416);
    O = new PopupWindow(paramContext, paramInt1, paramInt2);
    try
    {
      if (Build.VERSION.SDK_INT >= 22) {
        O.setAttachedInDecor(false);
      }
      O.setClippingEnabled(false);
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanel", 2, paramContext, new Object[0]);
      }
    }
    if (paramView.getWindowToken() != null) {
      O.showAtLocation(paramView, paramInt3, paramInt4, paramInt5);
    }
    return O;
  }
  
  private void a(float paramFloat)
  {
    float f1 = this.L;
    if (f1 == 0.0F)
    {
      this.L = paramFloat;
      return;
    }
    paramFloat -= f1;
    int i1 = 0;
    if (paramFloat > 0.0F) {
      i1 = 1;
    } else if (paramFloat < 0.0F) {
      i1 = -1;
    }
    if (this.M != i1)
    {
      this.H = true;
      this.M = i1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPageScrolledTransitionAnim() curItem is:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" nextItem=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" needDoPageScrolledTransitionAnim=");
      localStringBuilder.append(this.H);
      localStringBuilder.append(" nextdirect=");
      localStringBuilder.append(this.M);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    paramInt2 = d(paramInt2);
    if ((this.H) && (paramInt1 != paramInt2))
    {
      b(paramInt1, paramInt2);
      this.H = false;
    }
    this.E.setScrollDis(paramFloat, this.h.getWidth());
    if ((this.N != null) && (!this.H))
    {
      float f1 = paramFloat;
      if (Math.abs(paramFloat) > this.h.getWidth()) {
        f1 = Math.abs(paramFloat) - this.h.getWidth();
      }
      paramFloat = AudioTransitionAnimUtils.a(f1, this.h.getWidth());
      AudioTransitionAnimManager.a().a(this.N, paramFloat, this.I, this.J);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doTransitionAnimByNextItem lastSelectItem is:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" nextItem=");
      localStringBuilder.append(paramInt2);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (!AudioTransitionAnimManager.a().c()) {
      return;
    }
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = getCurrentItem();
    }
    if (i1 != paramInt2)
    {
      this.I = AudioTransitionAnimUtils.a(i1, paramInt2);
      a(getContext(), this.J);
    }
  }
  
  private void c(int paramInt)
  {
    int i1 = getCurrentItem();
    if (paramInt == 2131446202) {
      paramInt = 1;
    } else if (paramInt == 2131444489) {
      paramInt = 2;
    } else if (paramInt == 2131449982) {
      paramInt = 0;
    } else {
      paramInt = -1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doClickItemTransitionAnim() lastSelectItem is:");
      localStringBuilder.append(i1);
      localStringBuilder.append(" nextItem=");
      localStringBuilder.append(paramInt);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if ((paramInt >= 0) && (paramInt != i1))
    {
      c(true);
      this.J = true;
      b(i1, paramInt);
    }
  }
  
  private int d(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt > 2) {
      i1 = 2;
    }
    paramInt = i1;
    if (i1 < 0) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private int getCurrentColor()
  {
    AudioPanelViewPager localAudioPanelViewPager = this.h;
    if (localAudioPanelViewPager != null)
    {
      int i1 = localAudioPanelViewPager.getCurrentItem();
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 == 2) {
            return this.h.getContext().getResources().getColor(2131167982);
          }
        }
        else {
          return this.h.getContext().getResources().getColor(2131167982);
        }
      }
      else {
        return this.h.getContext().getResources().getColor(2131167982);
      }
    }
    return -15158044;
  }
  
  public static PopupWindow getTopMask()
  {
    return O;
  }
  
  private void h()
  {
    if (this.h.getCurrentItem() == 1)
    {
      Object localObject1 = this.k;
      if (localObject1 != null)
      {
        Object localObject2 = ((PressToSpeakPanel)localObject1).getPressToSpeakView();
        localObject1 = new Rect();
        ((ImageView)localObject2).getGlobalVisibleRect((Rect)localObject1);
        localObject2 = new Rect();
        super.getGlobalVisibleRect((Rect)localObject2);
        int i1 = ((Rect)localObject1).left - ((Rect)localObject2).left;
        int i2 = ((Rect)localObject1).top - ((Rect)localObject2).top;
        this.W = TypedValue.applyDimension(1, 30.0F, getResources().getDisplayMetrics());
        this.T = new Rect(i1, i2, ((Rect)localObject1).width() + i1, ((Rect)localObject1).height() + i2);
        this.Z = 40;
        this.aa = 0.98F;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("initAndStartHollowRoundAnim:");
          ((StringBuilder)localObject1).append(this.Z);
          ((StringBuilder)localObject1).append(", ");
          ((StringBuilder)localObject1).append(this.aa);
          QLog.d("HollowRound", 2, ((StringBuilder)localObject1).toString());
        }
        this.V = new Paint();
        this.V.setAntiAlias(true);
        this.V.setStyle(Paint.Style.STROKE);
        j();
      }
    }
  }
  
  private void i()
  {
    if (this.T != null)
    {
      this.Z += S;
      this.aa += R;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateHollowRoundAnim:");
        localStringBuilder.append(this.Z);
        localStringBuilder.append(", ");
        localStringBuilder.append(this.aa);
        QLog.d("HollowRound", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void j()
  {
    Rect localRect = this.U;
    if (localRect == null)
    {
      super.invalidate();
      return;
    }
    super.invalidate(localRect);
  }
  
  private void k()
  {
    c(true);
    this.G = true;
    this.K = getCurrentItem();
    this.E.setCurrentItem(this.K);
    this.L = 0.0F;
    this.M = 0;
    this.s = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrollStateChanged()   SCROLL_STATE_DRAGGING curItemWhenPageStatusChangeToDrag=");
      localStringBuilder.append(this.K);
      localStringBuilder.append(" needDoPageScrolledTransitionAnim=");
      localStringBuilder.append(this.H);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
  }
  
  private void l()
  {
    this.G = false;
    this.E.setCurrentItem(getCurrentItem());
    if (!this.J)
    {
      LottieDrawable localLottieDrawable = this.N;
      if (localLottieDrawable != null)
      {
        localLottieDrawable.endAnimation();
        g();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.h.getCurrentItem() != paramInt)
    {
      this.h.setCurrentItem(paramInt);
      requestLayout();
      ViewGroup localViewGroup = this.r;
      a(localViewGroup, localViewGroup.getChildAt(this.h.getCurrentItem()), this.h.getContext().getResources().getColor(2131167983), getCurrentColor());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.w;
    if ((localObject != null) && (!((BaseChatPie)localObject).bs()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("oldPanel=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" newPanel=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" text.length ");
        ((StringBuilder)localObject).append(this.w.Y.getText().length());
        QLog.d("doPanelChanged", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt2 == 2)
      {
        if ((paramInt1 != 2) && (AIOInputTypeHelper.b(this.g))) {
          a(false);
        }
      }
      else {
        this.w.Y.getText().length();
      }
    }
  }
  
  public void a(Animator paramAnimator, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationEnd AudioPanel mCurAnimType:");
      paramAnimator.append(this.I);
      paramAnimator.append(",type= ");
      paramAnimator.append(paramInt);
      paramAnimator.append(" isPageViewStartDragger=");
      paramAnimator.append(this.G);
      QLog.d("AudioPanel", 2, paramAnimator.toString());
    }
    if (!AudioTransitionAnimUtils.b(paramInt)) {
      return;
    }
    this.J = false;
    if (!this.G) {
      g();
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playTransitionAnimByType AudioTransitionAnimManager animType:");
      ((StringBuilder)localObject).append(this.I);
      ((StringBuilder)localObject).append(" mCurLottieDrawable=");
      ((StringBuilder)localObject).append(this.N);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = AudioTransitionAnimManager.a();
    ((AudioTransitionAnimManager)localObject).a(this);
    LottieDrawable localLottieDrawable = this.N;
    if (localLottieDrawable != null) {
      ((AudioTransitionAnimManager)localObject).a(localLottieDrawable);
    } else {
      this.D.setVisibility(0);
    }
    this.N = ((AudioTransitionAnimManager)localObject).a(paramContext, this.I);
    paramContext = this.N;
    if (paramContext != null) {
      ((AudioTransitionAnimManager)localObject).a(paramContext, this.I, this.F, paramBoolean);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.B)
    {
      this.B = false;
      this.w.a(0, this.y, false);
    }
  }
  
  void a(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    if (paramViewGroup != null)
    {
      int i2 = paramViewGroup.getChildCount();
      int i3 = getCurrentItem();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject;
        if (i1 != i3)
        {
          localObject = paramViewGroup.getChildAt(i1);
          if ((localObject instanceof TextView))
          {
            localObject = (TextView)localObject;
            ((TextView)localObject).setTextColor(paramInt1);
            ((TextView)localObject).setTextSize(2, 13.0F);
          }
          else if (i1 == 0)
          {
            localObject = this.p;
            if (localObject != null)
            {
              ((TextView)localObject).setTextColor(paramInt1);
              this.p.setTextSize(2, 13.0F);
            }
          }
        }
        else if (paramView != null)
        {
          if ((paramView instanceof TextView))
          {
            localObject = (TextView)paramView;
            ((TextView)localObject).setTextColor(paramInt2);
            ((TextView)localObject).setTextSize(2, 15.0F);
          }
          else if ((paramView instanceof FrameLayout))
          {
            localObject = this.p;
            if (localObject != null)
            {
              ((TextView)localObject).setTextColor(paramInt2);
              this.p.setTextSize(2, 15.0F);
              BabyQHandler.a(this.a);
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, InputLinearLayout paramInputLinearLayout, PanelIconLinearLayout paramPanelIconLinearLayout)
  {
    this.g = paramQQAppInterface;
    this.f = paramSessionInfo;
    this.l = paramInputLinearLayout;
    this.m = paramPanelIconLinearLayout;
    this.w = paramBaseChatPie;
    this.h = ((AudioPanelViewPager)findViewById(2131439794));
    this.F = ((ImageView)findViewById(2131428834));
    this.D = ((RelativeLayout)findViewById(2131428835));
    this.E = ((PttTextTransitionAnim)findViewById(2131440800));
    this.i = ((ViewGroup)findViewById(2131439787));
    this.n = ((TextView)findViewById(2131446202));
    this.o = ((TextView)findViewById(2131444489));
    this.p = ((TextView)findViewById(2131449982));
    this.a = findViewById(2131449974);
    this.r = ((ViewGroup)findViewById(2131439786));
    if (((ReceiptHelper)this.w.q(118)).a) {
      this.i.setVisibility(8);
    }
    this.j = new AudioPanelAdapter(paramQQAppInterface, paramBaseChatPie, this, this.i, this.l, this.m);
    this.h.a(this);
    this.h.setAdapter(this.j);
    this.h.setOnPageChangeListener(this);
    paramBaseChatPie = this.h;
    int i2 = this.j.getCount();
    int i1 = 1;
    paramBaseChatPie.setCurrentItem(Math.min(1, i2 - 1));
    this.n.setTextColor(getCurrentColor());
    this.y = true;
    this.z = true;
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    paramBaseChatPie = getResources().getDrawable(2130852413);
    if ((paramBaseChatPie instanceof BitmapDrawable))
    {
      paramSessionInfo = (BitmapDrawable)paramBaseChatPie;
      paramSessionInfo.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      paramSessionInfo.setDither(true);
    }
    else if ((paramBaseChatPie instanceof SkinnableBitmapDrawable))
    {
      paramSessionInfo = (SkinnableBitmapDrawable)paramBaseChatPie;
      paramSessionInfo.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      paramSessionInfo.setDither(true);
    }
    if (paramBaseChatPie != null) {
      setBackgroundDrawable(paramBaseChatPie);
    } else if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioPanel background is null:");
    }
    this.ac.sendEmptyMessage(3);
    if (QLog.isColorLevel())
    {
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append("AudioPanel.init() is called,time is:");
      paramBaseChatPie.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, paramBaseChatPie.toString());
    }
    if (Utils.c(this.f.b))
    {
      paramBaseChatPie = (BabyQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (paramBaseChatPie.b(2))
      {
        paramBaseChatPie.a();
        BabyQHandler.a(getContext(), this.a);
      }
    }
    AudioTransitionAnimManager.a().a(this);
    VideoReport.setElementId(this, "em_aio_voice_panel");
    VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
    paramQQAppInterface = ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103300");
    if ((paramQQAppInterface == null) || (paramQQAppInterface.iNewFlag.get() != 1)) {
      i1 = 0;
    }
    VideoReport.setElementParam(this, "is_red_tips_before", Integer.valueOf(i1));
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDrawableLoaded AudioPanel mCurAnimType:");
      localStringBuilder.append(this.I);
      localStringBuilder.append(",type= ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" drawable=");
      localStringBuilder.append(paramLottieDrawable);
      QLog.d("AudioPanel", 2, localStringBuilder.toString());
    }
    if (!AudioTransitionAnimUtils.b(paramInt)) {
      return;
    }
    if (this.I == paramInt)
    {
      this.N = paramLottieDrawable;
      if (this.N != null)
      {
        ThreadManager.getUIHandler().removeCallbacks(this.ad);
        ThreadManager.getUIHandler().post(this.ad);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    b(false);
    this.ab = paramBoolean;
    WeakReferenceHandler localWeakReferenceHandler = this.ac;
    if (paramBoolean) {
      i1 = 600;
    }
    localWeakReferenceHandler.sendEmptyMessageDelayed(1, i1 + 1200);
  }
  
  public boolean a()
  {
    Object localObject1 = this.j.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      ViewGroup localViewGroup = this.j.b;
      Object localObject2 = null;
      int i2 = localViewGroup.getChildCount();
      int i1 = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i1 >= i2) {
          break;
        }
        localObject1 = localViewGroup.getChildAt(i1);
        if (((View)localObject1).getVisibility() == 0) {
          break;
        }
        i1 += 1;
      }
      bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if ((localObject1 instanceof AudioPanelCallback)) {
          bool1 = ((AudioPanelCallback)localObject1).b();
        }
      }
    }
    b(true);
    return bool1;
  }
  
  public void b()
  {
    int i1 = 0;
    AudioPanelAioHelper.a = false;
    f();
    if (this.j.b != null)
    {
      ViewGroup localViewGroup = this.j.b;
      Object localObject2 = null;
      int i2 = localViewGroup.getChildCount();
      Object localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (i1 >= i2) {
          break;
        }
        localObject1 = localViewGroup.getChildAt(i1);
        if (((View)localObject1).getVisibility() == 0) {
          break;
        }
        i1 += 1;
      }
      if ((localObject1 != null) && ((localObject1 instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localObject1).c();
      }
    }
    b(true);
  }
  
  public void b(int paramInt)
  {
    if (!AudioTransitionAnimManager.a().c()) {
      return;
    }
    c(true);
    this.I = AudioTransitionAnimUtils.c(paramInt);
    this.J = true;
    a(getContext(), true);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.T != null)
    {
      this.T = null;
      this.U = null;
    }
    this.ab = false;
    this.ac.removeMessages(2);
    this.ac.removeMessages(1);
    if (paramBoolean) {
      j();
    }
  }
  
  public void c()
  {
    this.I = -1;
    ThreadManager.getUIHandler().removeCallbacks(this.ad);
    AudioTransitionAnimManager.a().b();
    int i1 = this.w.aR();
    Object localObject2 = null;
    if (i1 != 36) {
      O = null;
    }
    if (this.j.b != null)
    {
      ViewGroup localViewGroup = this.j.b;
      int i2 = localViewGroup.getChildCount();
      i1 = 0;
      Object localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (i1 >= i2) {
          break;
        }
        localObject1 = localViewGroup.getChildAt(i1);
        if (((View)localObject1).getVisibility() == 0) {
          break;
        }
        i1 += 1;
      }
      if ((localObject1 != null) && ((localObject1 instanceof AudioPanelCallback))) {
        ((AudioPanelCallback)localObject1).d();
      }
    }
    f();
  }
  
  public void c(boolean paramBoolean)
  {
    if (!AudioTransitionAnimManager.a().c()) {
      return;
    }
    if (this.D != null)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showAnimMask needStopLastAnim=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("AudioPanel", 2, ((StringBuilder)localObject).toString());
      }
      if (paramBoolean)
      {
        localObject = this.N;
        if ((localObject != null) && (((LottieDrawable)localObject).isAnimating())) {
          this.N.endAnimation();
        }
      }
      if (this.N != null) {
        this.D.setVisibility(0);
      }
    }
  }
  
  public void d()
  {
    if ((this.j.c != null) && ((this.j.c instanceof ListenChangeVoicePanel)))
    {
      ((AudioPanelCallback)this.j.c).d();
      this.j.c = null;
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Rect localRect = this.T;
    if (localRect != null)
    {
      if (this.Z <= 0)
      {
        if (!this.ab)
        {
          a(true);
          return;
        }
        b(false);
        return;
      }
      float f3 = localRect.width() / 2;
      float f2 = this.aa * f3;
      float f1 = this.W;
      if (f2 <= f3 + f1) {
        if (f2 > f3) {
          f1 = f2 - f3;
        } else {
          f1 = 0.0F;
        }
      }
      if (f1 > 0.0F)
      {
        f3 = f1 / 2.0F;
        this.V.setColor(Color.argb(this.Z, 0, 0, 255));
        this.V.setStrokeWidth(f1);
        paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f2 - f3, this.V);
      }
      this.ac.sendEmptyMessageDelayed(2, P);
    }
  }
  
  public void e()
  {
    if (this.T != null) {
      b(true);
    }
  }
  
  public void f()
  {
    int i1 = ((AudioPanelAioHelper)this.w.q(128)).e;
    if (i1 < 0) {
      return;
    }
    ((AudioPanelAioHelper)this.w.q(128)).e = -1;
    ThreadManager.post(new AudioPanel.1(this, i1), 8, null, false);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanel", 2, "hideAnimLayout ");
    }
    RelativeLayout localRelativeLayout = this.D;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public TextView getChangeVoicePageDescTv()
  {
    return this.p;
  }
  
  public int getCurrentItem()
  {
    AudioPanelViewPager localAudioPanelViewPager = this.h;
    if (localAudioPanelViewPager != null) {
      return localAudioPanelViewPager.getCurrentItem();
    }
    return -1;
  }
  
  public int getStatus()
  {
    return this.e;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      h();
      return true;
    }
    if (paramMessage.what == 2)
    {
      i();
      j();
      return true;
    }
    if (paramMessage.what == 3)
    {
      paramMessage = ((IRedTouchManager)this.g.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103300.103301");
      RedTouch localRedTouch = new RedTouch(this.w.aX(), this.p).c(53).a();
      this.p.setTag(localRedTouch);
      localRedTouch.a(paramMessage);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i3 = paramView.getId();
    c(i3);
    int i2 = 0;
    int i1;
    if (i3 == 2131446202)
    {
      setCurrentPannel(1, false);
      i1 = 1;
    }
    else if (i3 == 2131444489)
    {
      setCurrentPannel(2, false);
      i1 = 2;
    }
    else
    {
      i1 = i2;
      if (i3 == 2131449982)
      {
        setCurrentPannel(0, false);
        ((IRedTouchManager)this.g.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103300.103301");
        localObject = this.p.getTag();
        if ((localObject != null) && ((localObject instanceof RedTouch))) {
          ((RedTouch)localObject).g();
        }
        localObject = this.m;
        i1 = i2;
        if (localObject != null)
        {
          ((PanelIconLinearLayout)localObject).setShowRed(2, false);
          i1 = i2;
        }
      }
    }
    Object localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i1);
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "changevoice", "0X8006F4D", 0, 0, localStringBuilder.toString(), "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((i1 == 1) || (i1 == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((!this.s) || (this.z))
    {
      this.z = false;
      paramInt2 = this.h.getCurrentItem();
      Object localObject = this.r.getChildAt(paramInt2);
      if (localObject != null)
      {
        paramInt1 = (paramInt3 - paramInt1 - ((View)localObject).getWidth()) / 2;
        paramInt2 = ((View)localObject).getLeft();
        localObject = this.r;
        ((ViewGroup)localObject).scrollTo(paramInt2 - paramInt1, ((ViewGroup)localObject).getScrollY());
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.h.getLayoutParams();
      if (this.h.getCurrentItem() == 0) {
        boolean bool = ListenChangeVoicePanel.n;
      }
      label26:
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageScrollStateChanged() is called,state is:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" onPageScrolled=");
      ((StringBuilder)localObject).append(this.G);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 1)
    {
      k();
      return;
    }
    if (paramInt == 0)
    {
      l();
      if (getCurrentItem() == 0)
      {
        ReportController.b(this.g, "CliOper", "", "", "changevoice", "0X8006F4C", 0, 0, "1", "", "", "");
        ((IRedTouchManager)this.g.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103300.103301");
        localObject = this.p.getTag();
        if ((localObject != null) && ((localObject instanceof RedTouch))) {
          ((RedTouch)localObject).g();
        }
        localObject = this.m;
        if (localObject != null) {
          ((PanelIconLinearLayout)localObject).setShowRed(2, false);
        }
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt2 = this.h.getWidth() + this.h.getPageMargin();
    if (!this.s)
    {
      this.v = this.h.getCurrentItem();
      this.t = ((this.v + this.x) * paramInt2);
      this.u = this.r.getScrollX();
      this.s = true;
    }
    paramFloat = this.h.getScrollX() - this.t;
    if (paramFloat < 0.0F) {
      paramInt1 = this.v - 1;
    } else if (paramFloat > 0.0F) {
      paramInt1 = this.v + 1;
    } else {
      paramInt1 = this.v;
    }
    a(paramFloat);
    int i1;
    int i2;
    if (!this.J)
    {
      i1 = this.M;
      if (i1 != 0)
      {
        i2 = this.K;
        a(i2, i1 + i2, paramFloat);
      }
    }
    Object localObject = this.r.getChildAt(this.v);
    View localView = this.r.getChildAt(paramInt1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled() is called,pageBeforeScroll is:");
      localStringBuilder.append(this.v);
      localStringBuilder.append(",nextPage is:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",vpWidthWithMargin is:");
      localStringBuilder.append(paramInt2);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled vpRelativeScrollX is:");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(",vpScrollXBeforeScroll is:");
      localStringBuilder.append(this.t);
      localStringBuilder.append(",pdScrollXBeforeScroll is:");
      localStringBuilder.append(this.u);
      localStringBuilder.append(" viewPager.getScrollX()=");
      localStringBuilder.append(this.h.getScrollX());
      localStringBuilder.append(" curItem=");
      localStringBuilder.append(this.K);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && (localView != null))
    {
      paramInt1 = ((View)localObject).getLeft();
      i1 = ((View)localObject).getWidth() / 2;
      i2 = localView.getLeft();
      int i3 = localView.getWidth() / 2;
      paramFloat = Math.abs(paramFloat / paramInt2);
      paramInt1 = (int)((i2 + i3 - (paramInt1 + i1)) * paramFloat);
      localObject = this.r;
      ((ViewGroup)localObject).scrollTo(this.u + paramInt1, ((ViewGroup)localObject).getScrollY());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected() is called,position is:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" onPageScrolled=");
      ((StringBuilder)localObject).append(this.G);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0) {
      ReportController.b(this.g, "CliOper", "", "", "0X8005471", "0X8005471", 0, 0, "", "", "", "");
    } else if (paramInt == 1) {
      ReportController.b(this.g, "dc00898", "", "", "0X800A1D2", "0X800A1D2", 0, 0, "", "", "", "");
    }
    Object localObject = this.r;
    a((ViewGroup)localObject, ((ViewGroup)localObject).getChildAt(this.h.getCurrentItem()), this.h.getContext().getResources().getColor(2131167983), getCurrentColor());
    this.w.a(paramInt, this.y, this.A);
    this.A = false;
    if (AppSetting.e)
    {
      localObject = this.q;
      if ((localObject != null) && (paramInt < localObject.length))
      {
        int i1 = 0;
        while (i1 < this.r.getChildCount())
        {
          localObject = this.r.getChildAt(i1);
          if ((localObject != null) && (i1 < this.q.length))
          {
            if ((localObject instanceof TextView)) {
              localObject = (TextView)localObject;
            } else {
              localObject = (TextView)((View)localObject).findViewById(2131449982);
            }
            this.q[i1] = this.g.getApp().getString(2131886470, new Object[] { ((TextView)localObject).getText() });
            if (paramInt == i1)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(HardCodeUtil.a(2131899037));
              localStringBuilder.append(this.q[i1]);
              ((TextView)localObject).setContentDescription(localStringBuilder.toString());
            }
            else
            {
              ((TextView)localObject).setContentDescription(this.q[i1]);
            }
          }
          i1 += 1;
        }
        localObject = this.r;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131899036));
        localStringBuilder.append(this.q[paramInt]);
        AccessibilityUtils.a((View)localObject, localStringBuilder.toString());
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setCurrentPannel(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= 3) {
        return;
      }
      if (this.h.getCurrentItem() != paramInt)
      {
        this.A = paramBoolean;
        this.B = paramBoolean;
        this.h.setCurrentItem(paramInt);
        requestLayout();
        ViewGroup localViewGroup = this.r;
        a(localViewGroup, localViewGroup.getChildAt(this.h.getCurrentItem()), this.h.getContext().getResources().getColor(2131167983), getCurrentColor());
      }
      if (this.h.a) {
        this.x = (-paramInt);
      }
      this.E.setCurrentItem(paramInt);
    }
  }
  
  public void setReceiptMode(boolean paramBoolean)
  {
    this.j.a(paramBoolean);
    this.C = true;
    PressToSpeakPanel localPressToSpeakPanel = this.k;
    if (localPressToSpeakPanel != null) {
      localPressToSpeakPanel.setUseOnce(true);
    }
  }
  
  public void setSpeakPanel(PressToSpeakPanel paramPressToSpeakPanel)
  {
    this.k = paramPressToSpeakPanel;
    this.k.setUseOnce(this.C);
  }
  
  public void setStatus(int paramInt)
  {
    this.e = paramInt;
    this.l.setStatus(paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.d) {
      this.d = false;
    }
    if (paramInt == 0)
    {
      QQAppInterface localQQAppInterface = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(getCurrentItem());
      ReportController.b(localQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F49", 0, 0, localStringBuilder.toString(), "", "", "");
      if (getCurrentItem() == 0) {
        ReportController.b(this.g, "CliOper", "", "", "changevoice", "0X8006F4C", 0, 0, "0", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel
 * JD-Core Version:    0.7.0.1
 */