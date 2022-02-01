package com.tencent.av.wtogether.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTogetherRoom;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class WatchTogetherAdminControlView
  extends FrameLayout
  implements WatchTogetherUIProxy, WatchTogetherPlayRatioHelper.OnSelectRatioClickListener
{
  private View A;
  private TextView B;
  private ImageView C;
  private SeekBar D;
  private View E;
  private boolean F;
  private LinearLayout G;
  private TextView H;
  private TextView I;
  private ImageView J;
  private ImageView K;
  private ImageView L;
  private WatchTogetherMediaPlayerProxy M;
  private WatchTogetherPlayRatioHelper N;
  private Handler O;
  private boolean P = false;
  private boolean Q = false;
  private boolean R = false;
  private int S = 0;
  private final Runnable T = new WatchTogetherAdminControlView.1(this);
  private final View.OnTouchListener U = new WatchTogetherAdminControlView.2(this);
  protected TextView a;
  protected TextView b;
  protected ImageView c;
  protected ImageView d;
  protected ImageView e;
  protected ImageView f;
  protected ProgressBar g;
  protected TextView h;
  RelativeLayout i;
  private final HashMap<View, Integer> j = new HashMap();
  private int k = 12000;
  private int l = 200;
  private int m = 300;
  private float n = 14.0F;
  private float o = 12.0F;
  private boolean p = false;
  private int q = 2;
  private int r = 0;
  private int s = 0;
  private ImageView t;
  private SeekBar u;
  private View v;
  private TextView w;
  private View x;
  private View y;
  private View z;
  
  public WatchTogetherAdminControlView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WatchTogetherAdminControlView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WatchTogetherAdminControlView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void A()
  {
    if (getContext() != null) {
      ((AVActivity)getContext()).K.I(-1L);
    }
  }
  
  private void B()
  {
    int i1 = getResources().getDimensionPixelOffset(2131298708);
    int i2 = getResources().getDimensionPixelOffset(2131298710);
    float f1 = this.o;
    Drawable localDrawable1 = getResources().getDrawable(2130843347);
    Drawable localDrawable2 = getResources().getDrawable(2130843348);
    if (this.Q)
    {
      i1 = getResources().getDimensionPixelOffset(2131298707);
      i2 = getResources().getDimensionPixelOffset(2131298709);
      f1 = this.n;
      localDrawable1 = getResources().getDrawable(2130843334);
      localDrawable2 = getResources().getDrawable(2130843335);
    }
    ((ViewGroup.MarginLayoutParams)this.H.getLayoutParams()).rightMargin = i2;
    this.H.setTextSize(f1);
    this.H.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable1, null, null);
    this.H.setCompoundDrawablePadding(i1);
    this.I.setTextSize(f1);
    this.I.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable2, null, null);
    this.I.setCompoundDrawablePadding(i1);
  }
  
  private void C()
  {
    int i1 = getResources().getDimensionPixelOffset(2131298704);
    int i2 = getResources().getDimensionPixelOffset(2131298704);
    if (this.Q)
    {
      i1 = getResources().getDimensionPixelOffset(2131298705);
      i2 = getResources().getDimensionPixelOffset(2131298706);
    }
    this.D.setPadding(i1, 0, i1, 0);
    WTogetherUtil.a(this.D, i1, i1);
    WTogetherUtil.a(this.b, i1, 0);
    WTogetherUtil.a(this.a, 0, i1);
    WTogetherUtil.a(this.w, 0, i2);
  }
  
  private boolean D()
  {
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.M;
    return (localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.d());
  }
  
  private void E()
  {
    if (this.M == null) {
      return;
    }
    if (this.d != null)
    {
      if (D())
      {
        this.M.a();
        return;
      }
      this.M.c();
    }
  }
  
  private void F()
  {
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.M;
    if (localWatchTogetherMediaPlayerProxy != null)
    {
      TextView localTextView = this.B;
      if (localTextView != null) {
        localTextView.setText(localWatchTogetherMediaPlayerProxy.k());
      }
    }
  }
  
  private void G()
  {
    if (!getImmersiveEnable())
    {
      d(1, 1);
      return;
    }
    d(0, 2);
  }
  
  private int a(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    return paramView.getMeasuredWidth();
  }
  
  private void a(long paramLong)
  {
    paramLong /= 1000L;
    TextView localTextView = this.a;
    if (localTextView != null)
    {
      int i1 = (int)paramLong;
      localTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i1 / 60), Integer.valueOf(i1 % 60) }));
    }
  }
  
  private void b(int paramInt)
  {
    b();
    this.N.b();
    this.K.setVisibility(8);
    this.h.setVisibility(8);
    this.L.setVisibility(8);
    this.G.setVisibility(0);
    this.J.setVisibility(8);
    this.x.setBackgroundResource(2131165809);
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.M;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.f())) {
      setPlayRatio(this.M.g());
    } else if (this.M != null) {
      this.w.setText(2131893772);
    }
    localWatchTogetherMediaPlayerProxy = this.M;
    if (localWatchTogetherMediaPlayerProxy != null) {
      this.B.setText(localWatchTogetherMediaPlayerProxy.k());
    }
    localWatchTogetherMediaPlayerProxy = this.M;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.j())) {
      this.g.setVisibility(0);
    } else {
      this.g.setVisibility(8);
    }
    s();
    c(false);
    b(false);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.Q) {
      VideoController.f().e.a(new Object[] { Integer.valueOf(10006), Boolean.valueOf(paramBoolean) });
    }
  }
  
  private void c(int paramInt)
  {
    this.h.setText("");
    this.h.setVisibility(0);
    d(paramInt);
    this.g.setVisibility(8);
    b(false);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.t.setImageResource(2130843346);
      this.e.setImageResource(2130843350);
      return;
    }
    if (paramInt2 > 0)
    {
      d1 = paramInt2;
      d2 = paramInt1;
      Double.isNaN(d2);
      if (d1 <= d2 * 0.3D)
      {
        this.t.setImageResource(2130843349);
        this.e.setImageResource(2130843336);
        return;
      }
    }
    double d1 = paramInt2;
    double d2 = paramInt1;
    Double.isNaN(d2);
    if (d1 > 0.3D * d2)
    {
      Double.isNaN(d2);
      if (d1 <= d2 * 0.6D)
      {
        this.t.setImageResource(2130843340);
        this.e.setImageResource(2130843336);
        return;
      }
    }
    this.t.setImageResource(2130843339);
    this.e.setImageResource(2130843336);
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.M;
    int i1 = 8;
    if ((localObject != null) && (((WatchTogetherMediaPlayerProxy)localObject).o()))
    {
      localObject = this.f;
      if (paramBoolean) {
        i1 = 0;
      }
      ((ImageView)localObject).setVisibility(i1);
      return;
    }
    this.f.setVisibility(8);
  }
  
  private void d(int paramInt)
  {
    this.N.b();
    this.x.setBackgroundResource(2131167892);
    if (paramInt != 3) {
      this.K.setVisibility(0);
    }
    this.L.setVisibility(0);
    this.G.setVisibility(0);
    this.E.setVisibility(8);
    this.e.setVisibility(8);
    a();
    this.I.setVisibility(0);
    this.H.setVisibility(0);
    this.B.setVisibility(0);
    c(false);
    this.t.setVisibility(8);
    this.u.setVisibility(8);
    this.v.setVisibility(0);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 == 4)
            {
              v();
              setImmersiveEnable(false);
            }
          }
          else
          {
            c(paramInt2);
            setImmersiveEnable(false);
          }
        }
        else
        {
          u();
          setImmersiveEnable(false);
        }
      }
      else
      {
        b(paramInt2);
        setImmersiveEnable(false);
      }
    }
    else
    {
      t();
      setImmersiveEnable(true);
    }
    this.S = paramInt1;
  }
  
  private void e(int paramInt)
  {
    paramInt /= 1000;
    int i1 = paramInt / 60;
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt % 60) }));
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    this.D.setMax(paramInt2);
    this.D.setProgress(paramInt1);
  }
  
  private void g()
  {
    h();
    m();
    y();
  }
  
  private boolean getImmersiveEnable()
  {
    SessionInfo localSessionInfo = SessionMgr.a().b();
    if (localSessionInfo == null) {
      return false;
    }
    return localSessionInfo.ct;
  }
  
  private void h()
  {
    LayoutInflater.from(getContext()).inflate(2131625834, this, true);
    i();
    l();
    j();
    k();
  }
  
  private void i()
  {
    this.x = findViewById(2131445069);
    this.a = ((TextView)this.x.findViewById(2131448869));
    this.B = ((TextView)this.x.findViewById(2131448814));
    this.C = ((ImageView)this.x.findViewById(2131448815));
    this.e = ((ImageView)this.x.findViewById(2131448872));
    this.f = ((ImageView)this.x.findViewById(2131448706));
    this.b = ((TextView)this.x.findViewById(2131448868));
    this.c = ((ImageView)this.x.findViewById(2131436391));
    this.z = this.x.findViewById(2131437422);
    this.y = this.x.findViewById(2131437579);
    this.d = ((ImageView)this.x.findViewById(2131436655));
    this.g = ((ProgressBar)this.x.findViewById(2131436653));
    this.h = ((TextView)this.x.findViewById(2131448649));
    this.D = ((SeekBar)this.x.findViewById(2131445502));
    this.E = this.x.findViewById(2131445506);
    this.i = ((RelativeLayout)this.x.findViewById(2131445071));
    this.t = ((ImageView)this.x.findViewById(2131448536));
    this.u = ((SeekBar)this.x.findViewById(2131449980));
    this.v = this.x.findViewById(2131449981);
    this.w = ((TextView)this.x.findViewById(2131448870));
    this.N = new WatchTogetherPlayRatioHelper(this.x.findViewById(2131437596));
    this.N.a(this);
  }
  
  private void j()
  {
    this.G = ((LinearLayout)this.x.findViewById(2131449643));
    this.H = ((TextView)this.x.findViewById(2131449545));
    this.I = ((TextView)this.x.findViewById(2131449705));
    this.J = ((ImageView)this.x.findViewById(2131449610));
    this.K = ((ImageView)this.x.findViewById(2131449702));
    this.L = ((ImageView)this.x.findViewById(2131449461));
  }
  
  private void k()
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    this.r = localWatchTogetherMediaPlayCtrl.C();
    this.s = localWatchTogetherMediaPlayCtrl.D();
    this.u.setMax(this.r);
    this.u.setProgress(this.s);
    c(this.r, this.s);
  }
  
  private void l()
  {
    HashMap localHashMap = this.j;
    View localView = this.z;
    Integer localInteger = Integer.valueOf(0);
    localHashMap.put(localView, localInteger);
    this.j.put(this.d, localInteger);
    if (QAVConfigUtils.n()) {
      this.j.put(this.e, localInteger);
    }
    this.j.put(this.D, localInteger);
    this.j.put(this.c, localInteger);
    this.j.put(this.B, localInteger);
    this.j.put(this.a, localInteger);
    this.j.put(this.b, localInteger);
  }
  
  private void m()
  {
    this.x.setOnTouchListener(new WatchTogetherAdminControlView.3(this));
    this.d.setOnTouchListener(this.U);
    this.d.setOnClickListener(new WatchTogetherAdminControlView.4(this));
    this.c.setOnTouchListener(this.U);
    this.c.setOnClickListener(new WatchTogetherAdminControlView.5(this));
    this.w.setOnTouchListener(this.U);
    this.w.setOnClickListener(new WatchTogetherAdminControlView.6(this));
    this.H.setOnTouchListener(this.U);
    this.H.setOnClickListener(new WatchTogetherAdminControlView.7(this));
    this.I.setOnTouchListener(this.U);
    this.I.setOnClickListener(new WatchTogetherAdminControlView.8(this));
    this.K.setOnTouchListener(this.U);
    this.K.setOnClickListener(new WatchTogetherAdminControlView.9(this));
    this.C.setOnTouchListener(this.U);
    this.C.setOnClickListener(new WatchTogetherAdminControlView.10(this));
    this.L.setOnTouchListener(this.U);
    this.L.setOnClickListener(new WatchTogetherAdminControlView.11(this));
    this.f.setOnTouchListener(this.U);
    this.f.setOnClickListener(new WatchTogetherAdminControlView.12(this));
    this.e.setOnTouchListener(this.U);
    this.e.setOnClickListener(new WatchTogetherAdminControlView.13(this));
    this.u.setOnSeekBarChangeListener(new WatchTogetherAdminControlView.14(this));
    int i1 = a(this.a);
    this.a.setMinimumWidth(i1);
    this.b.setMinimumWidth(i1);
  }
  
  private void n()
  {
    if ((this.R) && (this.t.getVisibility() == 0))
    {
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      this.v.setVisibility(0);
      this.R = false;
      return;
    }
    this.t.setVisibility(0);
    this.u.setVisibility(0);
    this.v.setVisibility(8);
    this.C.setVisibility(8);
    this.z.setVisibility(8);
    Iterator localIterator = this.j.keySet().iterator();
    while (localIterator.hasNext()) {
      ((View)localIterator.next()).setVisibility(8);
    }
    this.I.setVisibility(8);
    this.H.setVisibility(8);
    this.F = false;
    this.R = true;
  }
  
  private void o()
  {
    int i1 = this.S;
    if (i1 == 0) {
      d(1, 2);
    } else if (i1 == 1) {
      d(0, 2);
    } else if (i1 == 2) {
      d(1, 2);
    }
    w();
  }
  
  private void p()
  {
    Object localObject = this.M;
    if (localObject == null) {
      return;
    }
    WTFileInfo localWTFileInfo = ((WatchTogetherMediaPlayerProxy)localObject).l();
    if (localWTFileInfo == null) {
      return;
    }
    localObject = SessionMgr.a().b();
    if (localObject == null) {
      return;
    }
    localObject = ((WTogetherMng)VideoController.f().e.c(17)).b((SessionInfo)localObject);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((WatchTogetherInfo)localObject).g;
    }
    if (localObject == null) {
      return;
    }
    Activity localActivity = (Activity)getContext();
    String str1 = SessionMgr.a().b().s;
    String str2 = VideoController.f().e.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("roomid=");
    localStringBuilder.append(((WTogetherRoom)localObject).c);
    localStringBuilder.append("|");
    localStringBuilder.append("file_id=");
    localStringBuilder.append(localWTFileInfo.d);
    localStringBuilder.append("|");
    localStringBuilder.append("file_uuid=");
    localStringBuilder.append(localWTFileInfo.c);
    WTogetherUtil.a(localActivity, str1, str2, localStringBuilder.toString());
  }
  
  private void q()
  {
    int i1 = VideoController.f().aA().D();
    if (i1 == this.s) {
      return;
    }
    Object localObject = SessionMgr.a().b();
    if (localObject == null) {
      return;
    }
    localObject = ((WTogetherMng)VideoController.f().e.c(17)).b((SessionInfo)localObject);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((WatchTogetherInfo)localObject).g;
    }
    if (localObject == null) {
      return;
    }
    String str;
    if (i1 > this.s) {
      str = "1";
    } else {
      str = "2";
    }
    localObject = String.valueOf(((WTogetherRoom)localObject).c);
    this.s = i1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doVolumeChangeReport roomId = ");
    localStringBuilder.append((String)localObject);
    QLog.d("WatchTogetherVideoPlayView", 1, localStringBuilder.toString());
    AVUtil.a("0X800BDB0", 0, 0, str, (String)localObject, "", "");
  }
  
  private void r()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if (localAVActivity == null) {
      return;
    }
    VideoLayerUI localVideoLayerUI = localAVActivity.L;
    if (localVideoLayerUI == null) {
      return;
    }
    WatchTogetherAdminControlView.15 local15 = new WatchTogetherAdminControlView.15(this);
    int i1 = localVideoLayerUI.F();
    if ((localAVActivity.V == 0) && (i1 != 1))
    {
      localAVActivity.setRequestedOrientation(1);
      this.O.postDelayed(local15, this.l);
      return;
    }
    local15.run();
  }
  
  private void s()
  {
    if (z())
    {
      this.D.setVisibility(8);
      this.w.setVisibility(8);
      this.a.setVisibility(8);
      this.b.setVisibility(8);
      this.E.setVisibility(0);
      return;
    }
    this.D.setVisibility(0);
    this.w.setVisibility(0);
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    this.E.setVisibility(8);
  }
  
  private void setImmersiveEnable(boolean paramBoolean)
  {
    if (!this.Q) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().b();
    if (localSessionInfo == null) {
      return;
    }
    localSessionInfo.c(paramBoolean);
  }
  
  private void setPlayRatio(float paramFloat)
  {
    Object localObject2 = String.format("%.1f", new Object[] { Float.valueOf(paramFloat) });
    Object localObject1 = localObject2;
    if (((String)localObject2).equalsIgnoreCase("1.3")) {
      localObject1 = "1.25";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("x");
    localObject1 = ((StringBuilder)localObject2).toString();
    this.w.setText((CharSequence)localObject1);
  }
  
  private void t()
  {
    a();
    this.N.b();
    this.x.setBackgroundResource(2131167892);
    this.g.setVisibility(8);
    this.K.setVisibility(8);
    this.L.setVisibility(8);
    this.h.setVisibility(8);
    this.G.setVisibility(8);
    this.J.setVisibility(8);
    this.E.setVisibility(8);
    c(false);
    b(true);
  }
  
  private void u()
  {
    a();
    this.h.setVisibility(8);
    this.g.setVisibility(8);
    this.K.setVisibility(8);
    this.L.setVisibility(8);
    this.G.setVisibility(8);
    this.E.setVisibility(8);
    this.x.setBackgroundResource(2131165809);
    this.N.a();
    this.J.setVisibility(8);
    c(false);
    b(false);
  }
  
  private void v()
  {
    this.h.setText("");
    this.h.setVisibility(0);
    a();
    this.G.setVisibility(0);
    this.E.setVisibility(8);
    this.g.setVisibility(8);
    c(false);
    b(false);
  }
  
  private void w()
  {
    QLog.d("WatchTogetherVideoPlayView", 1, "enter");
    if (this.Q)
    {
      this.O.removeCallbacks(this.T);
      this.O.postDelayed(this.T, this.k);
      return;
    }
    this.O.removeCallbacks(this.T);
  }
  
  private void x()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if (localAVActivity != null)
    {
      if (this.M == null) {
        return;
      }
      if (!this.Q)
      {
        localAVActivity.setRequestedOrientation(0);
        QLog.d("WatchTogetherVideoPlayView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
      }
      else
      {
        localAVActivity.setRequestedOrientation(1);
        QLog.d("WatchTogetherVideoPlayView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
      }
      this.M.a(true);
    }
  }
  
  private void y()
  {
    this.O = new Handler(Looper.getMainLooper());
  }
  
  private boolean z()
  {
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.M;
    return (localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.n());
  }
  
  public void a()
  {
    this.C.setVisibility(8);
    this.z.setVisibility(8);
    if ((this.F) && (!this.p))
    {
      Iterator localIterator = this.j.keySet().iterator();
      while (localIterator.hasNext()) {
        ((View)localIterator.next()).setVisibility(8);
      }
      this.F = false;
    }
    this.t.setVisibility(8);
    this.u.setVisibility(8);
    this.v.setVisibility(0);
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    this.O.post(new WatchTogetherAdminControlView.17(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.O.post(new WatchTogetherAdminControlView.23(this, paramInt1, paramInt2));
  }
  
  public void a(String paramString)
  {
    this.O.post(new WatchTogetherAdminControlView.16(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.O.post(new WatchTogetherAdminControlView.26(this, paramBoolean));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.O.post(new WatchTogetherAdminControlView.25(this));
    return false;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void b()
  {
    if (!this.F)
    {
      Object localObject = this.j.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setVisibility(0);
      }
      localObject = this.A;
      if ((localObject != null) && (((View)localObject).getVisibility() == 8)) {
        this.A.setVisibility(0);
      }
      if (this.Q) {
        this.C.setVisibility(0);
      }
      localObject = this.M;
      if (localObject != null)
      {
        ImageView localImageView = this.d;
        int i1;
        if (((WatchTogetherMediaPlayerProxy)localObject).d()) {
          i1 = 2130843341;
        } else {
          i1 = 2130843342;
        }
        localImageView.setImageResource(i1);
      }
      this.N.b();
      this.F = true;
      this.I.setVisibility(0);
      this.H.setVisibility(0);
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      this.v.setVisibility(0);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.O.post(new WatchTogetherAdminControlView.24(this, paramInt1, paramInt2));
  }
  
  public void c()
  {
    d(1, 2);
  }
  
  public void d()
  {
    this.O.post(new WatchTogetherAdminControlView.19(this));
  }
  
  public void e()
  {
    this.O.post(new WatchTogetherAdminControlView.20(this));
  }
  
  public void f() {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    setOrientationParams(paramConfiguration.orientation);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.O.removeCallbacksAndMessages(null);
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.b(this);
    }
  }
  
  public void setImmersiveStatus(boolean paramBoolean)
  {
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.M;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.h())) {
      return;
    }
    localWatchTogetherMediaPlayerProxy = this.M;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.i())) {
      return;
    }
    if (paramBoolean)
    {
      d(0, 2);
      return;
    }
    d(1, 2);
  }
  
  public void setOrientationParams(int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
    boolean bool2 = false;
    if (paramInt == 2)
    {
      this.B.setMaxEms(25);
      this.C.setVisibility(this.B.getVisibility());
      this.c.setImageResource(2130843345);
      this.L.setImageResource(2130843345);
      localMarginLayoutParams1.topMargin = 0;
      localMarginLayoutParams1.height = -1;
      if (this.S == 1) {
        this.C.setVisibility(0);
      }
      this.Q = true;
      localMarginLayoutParams2.topMargin = getResources().getDimensionPixelOffset(2131298719);
      localMarginLayoutParams2.leftMargin = getResources().getDimensionPixelOffset(2131298717);
      localMarginLayoutParams2.rightMargin = getResources().getDimensionPixelOffset(2131298718);
      AVUtil.a("0X800B636", 0, 0, "", "", "", "");
    }
    else if (paramInt == 1)
    {
      this.B.setMaxEms(12);
      this.C.setVisibility(8);
      this.c.setImageResource(2130843337);
      this.L.setImageResource(2130843337);
      localMarginLayoutParams1.topMargin = (AIOUtils.b(64.0F, getResources()) + WTogetherUtil.a(getContext()));
      localMarginLayoutParams1.height = WTogetherUtil.b();
      if (this.S == 1) {
        this.C.setVisibility(8);
      }
      this.Q = false;
      localMarginLayoutParams2.topMargin = getResources().getDimensionPixelOffset(2131298722);
      localMarginLayoutParams2.leftMargin = getResources().getDimensionPixelOffset(2131298720);
      localMarginLayoutParams2.rightMargin = getResources().getDimensionPixelOffset(2131298721);
    }
    B();
    C();
    w();
    if (this.Q)
    {
      WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.M;
      if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.h()))
      {
        i1 = 1;
        break label361;
      }
    }
    int i1 = 0;
    label361:
    boolean bool1 = bool2;
    if (i1 == 0)
    {
      bool1 = bool2;
      if (this.S == 0) {
        bool1 = true;
      }
    }
    b(bool1);
    setLayoutParams(localMarginLayoutParams1);
    this.i.setLayoutParams(localMarginLayoutParams2);
    this.N.a(paramInt);
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener == null)
    {
      this.D.setOnSeekBarChangeListener(null);
      return;
    }
    this.D.setOnSeekBarChangeListener(new WatchTogetherAdminControlView.18(this, paramOnSeekBarChangeListener));
  }
  
  public void setWatchTogetherMediaPlayerProxy(WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy)
  {
    this.M = paramWatchTogetherMediaPlayerProxy;
    this.N.a(this.M);
  }
  
  public void setWatchTogetherParams(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.P = paramBoolean2;
    if (paramBoolean1)
    {
      WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.M;
      if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.h()))
      {
        d(3, 2);
      }
      else
      {
        localWatchTogetherMediaPlayerProxy = this.M;
        if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.i())) {
          d(4, 2);
        } else if (!getImmersiveEnable()) {
          d(1, 2);
        } else {
          d(0, 2);
        }
      }
      w();
      setOrientationParams(1);
      setVisibility(0);
      return;
    }
    d(0, 2);
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView
 * JD-Core Version:    0.7.0.1
 */