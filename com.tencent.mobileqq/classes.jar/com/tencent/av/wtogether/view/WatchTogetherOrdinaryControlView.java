package com.tencent.av.wtogether.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
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

public class WatchTogetherOrdinaryControlView
  extends FrameLayout
  implements WatchTogetherUIProxy
{
  private Runnable A = new WatchTogetherOrdinaryControlView.1(this);
  private View.OnTouchListener B = new WatchTogetherOrdinaryControlView.2(this);
  RelativeLayout a = null;
  private int b = 0;
  private int c = 2;
  private int d = 12000;
  private int e = 0;
  private int f = 0;
  private View g;
  private TextView h;
  private ImageView i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private SeekBar m;
  private View n;
  private View o;
  private TextView p;
  private TextView q;
  private ImageView r;
  private ImageView s;
  private ProgressBar t;
  private TextView u;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private WatchTogetherMediaPlayerProxy y;
  private Handler z;
  
  public WatchTogetherOrdinaryControlView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WatchTogetherOrdinaryControlView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WatchTogetherOrdinaryControlView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    b();
    c();
    g();
  }
  
  private void a(long paramLong)
  {
    paramLong /= 1000L;
    TextView localTextView = this.p;
    if (localTextView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/");
      int i1 = (int)paramLong;
      localStringBuilder.append(String.format("%02d:%02d", new Object[] { Integer.valueOf(i1 / 60), Integer.valueOf(i1 % 60) }));
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2131625835, this, true);
    this.g = findViewById(2131445069);
    this.a = ((RelativeLayout)findViewById(2131445071));
    this.h = ((TextView)findViewById(2131448814));
    this.i = ((ImageView)findViewById(2131448815));
    this.r = ((ImageView)findViewById(2131436391));
    this.o = findViewById(2131437579);
    this.t = ((ProgressBar)findViewById(2131436653));
    this.u = ((TextView)findViewById(2131448649));
    this.k = ((ImageView)findViewById(2131448872));
    this.j = ((ImageView)findViewById(2131448706));
    this.s = ((ImageView)findViewById(2131449610));
    this.l = ((ImageView)findViewById(2131448536));
    this.m = ((SeekBar)findViewById(2131449980));
    this.n = findViewById(2131449981);
    this.p = ((TextView)this.o.findViewById(2131448869));
    this.q = ((TextView)this.o.findViewById(2131448868));
  }
  
  private void b(int paramInt)
  {
    n();
    this.u.setVisibility(8);
    this.s.setVisibility(8);
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.y;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.j())) {
      this.t.setVisibility(0);
    } else {
      this.t.setVisibility(8);
    }
    localWatchTogetherMediaPlayerProxy = this.y;
    if (localWatchTogetherMediaPlayerProxy != null) {
      this.h.setText(localWatchTogetherMediaPlayerProxy.k());
    }
    localWatchTogetherMediaPlayerProxy = this.y;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.n()))
    {
      this.o.setVisibility(8);
    }
    else
    {
      localWatchTogetherMediaPlayerProxy = this.y;
      if ((localWatchTogetherMediaPlayerProxy != null) && (!localWatchTogetherMediaPlayerProxy.n())) {
        this.o.setVisibility(0);
      }
    }
    this.g.setBackgroundResource(2131165809);
    c(false);
    setImmersiveEnable(false);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.y;
    int i1 = 8;
    if ((localObject != null) && (((WatchTogetherMediaPlayerProxy)localObject).o()))
    {
      localObject = this.j;
      if (paramBoolean) {
        i1 = 0;
      }
      ((ImageView)localObject).setVisibility(i1);
      return;
    }
    this.j.setVisibility(8);
  }
  
  private void c()
  {
    setOnTouchListener(new WatchTogetherOrdinaryControlView.3(this));
    this.r.setOnTouchListener(this.B);
    this.r.setOnClickListener(new WatchTogetherOrdinaryControlView.4(this));
    this.i.setOnTouchListener(this.B);
    this.i.setOnClickListener(new WatchTogetherOrdinaryControlView.5(this));
    this.j.setOnTouchListener(this.B);
    this.j.setOnClickListener(new WatchTogetherOrdinaryControlView.6(this));
    this.k.setOnTouchListener(this.B);
    this.k.setOnClickListener(new WatchTogetherOrdinaryControlView.7(this));
    this.m.setOnSeekBarChangeListener(new WatchTogetherOrdinaryControlView.8(this));
  }
  
  private void c(int paramInt)
  {
    paramInt /= 1000;
    int i1 = paramInt / 60;
    TextView localTextView = this.q;
    if (localTextView != null) {
      localTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt % 60) }));
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.l.setImageResource(2130843346);
      this.k.setImageResource(2130843350);
      return;
    }
    if (paramInt2 > 0)
    {
      d1 = paramInt2;
      d2 = paramInt1;
      Double.isNaN(d2);
      if (d1 <= d2 * 0.3D)
      {
        this.l.setImageResource(2130843349);
        this.k.setImageResource(2130843336);
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
        this.l.setImageResource(2130843340);
        this.k.setImageResource(2130843336);
        return;
      }
    }
    this.l.setImageResource(2130843339);
    this.k.setImageResource(2130843336);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.w) {
      VideoController.f().e.a(new Object[] { Integer.valueOf(10006), Boolean.valueOf(paramBoolean) });
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 == 4) {
            s();
          }
        }
        else {
          r();
        }
      }
      else {
        b(paramInt2);
      }
    }
    else {
      q();
    }
    this.b = paramInt1;
  }
  
  private void g()
  {
    this.z = new Handler(Looper.getMainLooper());
    h();
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
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    this.e = localWatchTogetherMediaPlayCtrl.C();
    this.f = localWatchTogetherMediaPlayCtrl.D();
    this.m.setMax(this.e);
    this.m.setProgress(this.f);
    c(this.e, this.f);
  }
  
  private void i()
  {
    if ((this.x) && (this.l.getVisibility() == 0))
    {
      this.l.setVisibility(8);
      this.m.setVisibility(8);
      this.n.setVisibility(0);
      return;
    }
    this.l.setVisibility(0);
    this.m.setVisibility(0);
    this.n.setVisibility(8);
    this.i.setVisibility(8);
    this.h.setVisibility(8);
    this.k.setVisibility(8);
    b(false);
    this.o.setVisibility(8);
    this.r.setVisibility(8);
    this.v = false;
    this.x = true;
  }
  
  private void j()
  {
    t();
    Object localObject = this.y;
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
    Activity localActivity = (Activity)this.g.getContext();
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
  
  private void k()
  {
    int i1 = VideoController.f().aA().D();
    if (i1 == this.f) {
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
    if (i1 > this.f) {
      str = "1";
    } else {
      str = "2";
    }
    localObject = String.valueOf(((WTogetherRoom)localObject).c);
    this.f = i1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doVolumeChangeReport roomId = ");
    localStringBuilder.append((String)localObject);
    QLog.d("WatchTogetherOrdinaryControlView", 1, localStringBuilder.toString());
    AVUtil.a("0X800BDB0", 0, 0, str, (String)localObject, "", "");
  }
  
  private void l()
  {
    if ((this.b == 1) && (this.c == 2)) {
      d(0, 2);
    } else if (this.b == 0) {
      d(1, 2);
    }
    m();
  }
  
  private void m()
  {
    if (this.w)
    {
      this.z.removeCallbacks(this.A);
      this.z.postDelayed(this.A, this.d);
      return;
    }
    this.z.removeCallbacks(this.A);
  }
  
  private void n()
  {
    if (this.w) {
      this.i.setVisibility(0);
    }
    this.o.setVisibility(0);
    this.h.setVisibility(0);
    if (QAVConfigUtils.n()) {
      this.k.setVisibility(0);
    }
    b(true);
    this.r.setVisibility(0);
    this.v = true;
    this.l.setVisibility(8);
    this.m.setVisibility(8);
    this.n.setVisibility(0);
    this.x = false;
  }
  
  private void o()
  {
    this.i.setVisibility(8);
    this.h.setVisibility(8);
    this.k.setVisibility(8);
    b(false);
    this.o.setVisibility(8);
    this.r.setVisibility(8);
    this.v = false;
    this.l.setVisibility(8);
    this.m.setVisibility(8);
    this.n.setVisibility(0);
    this.x = false;
  }
  
  private void p()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if (localAVActivity != null)
    {
      if (this.y == null) {
        return;
      }
      if (!this.w)
      {
        localAVActivity.setRequestedOrientation(0);
        QLog.d("WatchTogetherOrdinaryControlView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
      }
      else
      {
        localAVActivity.setRequestedOrientation(1);
        QLog.d("WatchTogetherOrdinaryControlView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
      }
      this.y.a(true);
    }
  }
  
  private void q()
  {
    o();
    this.t.setVisibility(8);
    this.u.setVisibility(8);
    this.s.setVisibility(8);
    this.g.setBackgroundResource(2131167892);
    c(true);
    setImmersiveEnable(true);
  }
  
  private void r()
  {
    this.u.setText(2131893769);
    this.u.setVisibility(0);
    o();
    this.r.setVisibility(0);
    this.h.setVisibility(0);
    this.k.setVisibility(8);
    b(true);
    this.l.setVisibility(8);
    this.m.setVisibility(8);
    this.n.setVisibility(0);
    if (this.w) {
      this.i.setVisibility(0);
    }
    this.g.setBackgroundResource(2131167892);
    c(false);
    setImmersiveEnable(false);
  }
  
  private void s()
  {
    this.u.setText(2131893770);
    this.u.setVisibility(0);
    this.t.setVisibility(8);
    this.g.setBackgroundResource(2131167892);
    o();
    c(false);
    setImmersiveEnable(false);
  }
  
  private void setImmersiveEnable(boolean paramBoolean)
  {
    if (!this.w) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().b();
    if (localSessionInfo == null) {
      return;
    }
    localSessionInfo.c(paramBoolean);
  }
  
  private void t()
  {
    if (getContext() != null) {
      ((AVActivity)getContext()).K.I(-1L);
    }
  }
  
  private void u()
  {
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.y;
    if (localWatchTogetherMediaPlayerProxy != null)
    {
      TextView localTextView = this.h;
      if (localTextView != null) {
        localTextView.setText(localWatchTogetherMediaPlayerProxy.k());
      }
    }
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    this.z.post(new WatchTogetherOrdinaryControlView.10(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.z.post(new WatchTogetherOrdinaryControlView.12(this, paramInt1, paramInt2));
  }
  
  public void a(String paramString)
  {
    this.z.post(new WatchTogetherOrdinaryControlView.9(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.z.post(new WatchTogetherOrdinaryControlView.11(this));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.z.post(new WatchTogetherOrdinaryControlView.13(this));
    return false;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    setOrientationParams(paramConfiguration.orientation);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.b(this);
    }
    this.z.removeCallbacksAndMessages(null);
  }
  
  public void setImmersiveStatus(boolean paramBoolean)
  {
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.y;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.h())) {
      return;
    }
    localWatchTogetherMediaPlayerProxy = this.y;
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
    Object localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
    boolean bool = false;
    if (paramInt == 2)
    {
      this.h.setMaxEms(25);
      this.i.setVisibility(this.r.getVisibility());
      this.r.setImageResource(2130843345);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject).height = -1;
      this.w = true;
      localMarginLayoutParams.topMargin = getResources().getDimensionPixelOffset(2131298719);
      localMarginLayoutParams.leftMargin = getResources().getDimensionPixelOffset(2131298717);
      localMarginLayoutParams.rightMargin = getResources().getDimensionPixelOffset(2131298718);
    }
    else if (paramInt == 1)
    {
      this.h.setMaxEms(12);
      this.i.setVisibility(8);
      this.r.setImageResource(2130843337);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (AIOUtils.b(64.0F, getResources()) + WTogetherUtil.a(getContext()));
      ((ViewGroup.MarginLayoutParams)localObject).height = WTogetherUtil.b();
      this.w = false;
      localMarginLayoutParams.topMargin = getResources().getDimensionPixelOffset(2131298722);
      localMarginLayoutParams.leftMargin = getResources().getDimensionPixelOffset(2131298720);
      localMarginLayoutParams.rightMargin = getResources().getDimensionPixelOffset(2131298721);
    }
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a.setLayoutParams(localMarginLayoutParams);
    m();
    if (this.w)
    {
      localObject = this.y;
      if ((localObject != null) && (((WatchTogetherMediaPlayerProxy)localObject).h()))
      {
        paramInt = 1;
        break label285;
      }
    }
    paramInt = 0;
    label285:
    if ((paramInt == 0) && (this.b == 0)) {
      bool = true;
    }
    c(bool);
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener) {}
  
  public void setWatchTogetherMediaPlayerProxy(WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy)
  {
    this.y = paramWatchTogetherMediaPlayerProxy;
  }
  
  public void setWatchTogetherParams(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.y;
      if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.h()))
      {
        d(3, 2);
      }
      else
      {
        localWatchTogetherMediaPlayerProxy = this.y;
        if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.i())) {
          d(4, 2);
        } else if (!getImmersiveEnable()) {
          d(1, 2);
        } else {
          d(0, 2);
        }
      }
      m();
      setOrientationParams(1);
      setVisibility(0);
      return;
    }
    d(0, 2);
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView
 * JD-Core Version:    0.7.0.1
 */