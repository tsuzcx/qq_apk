package com.tencent.biz.qqcircle.richframework.part.block.base;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.widgets.QCircleRippleAnimView;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.animation.interpolator.BezierInterpolator;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.richframework.part.IRefreshViewProvider.OnRefreshListener;
import com.tencent.qphone.base.util.QLog;

public class RefreshHeaderView
  extends LinearLayout
  implements IRefreshViewProvider
{
  private static RFWMultiDownloadHelper w = new RFWMultiDownloadHelper();
  private FrameLayout a;
  private LinearLayout b;
  private FrameLayout c;
  private ImageView d;
  private TextView e;
  private ImageView f;
  private TextView g;
  private int h;
  private int i;
  private float j;
  private float k;
  private IRefreshViewProvider.OnRefreshListener l;
  private boolean m;
  private boolean n;
  private String o = null;
  private Handler p;
  private final String q = getResources().getString(2131916805);
  private final String r = getResources().getString(2131916804);
  private final String s = getResources().getString(2131916802);
  private long t;
  private Drawable u;
  private QQAnimationDrawable v;
  private final AnimationDrawableFactory.CreateResultListener x = new RefreshHeaderView.1(this);
  
  static
  {
    w.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip", QCirclePluginConfig.e()));
    w.start();
  }
  
  public RefreshHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RefreshHeaderView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RefreshHeaderView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k();
  }
  
  private void a(int paramInt)
  {
    if (this.v == null)
    {
      QLog.e("RefreshHeaderView", 1, "playDynamicLogoAnim AnimationDrawable is null!");
      return;
    }
    if ((paramInt == 2) || (paramInt == 4))
    {
      this.d.setImageDrawable(this.v);
      this.v.start();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.e;
    int i2 = 0;
    int i1;
    if (!paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    localObject = this.f;
    if (paramBoolean) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((ImageView)localObject).setVisibility(i1);
  }
  
  private boolean a(float paramFloat, boolean paramBoolean)
  {
    return (paramFloat > 0.0F) && (!paramBoolean);
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.l;
    if (localObject != null) {
      this.o = ((IRefreshViewProvider.OnRefreshListener)localObject).c();
    }
    if (this.v == null)
    {
      QLog.d("RefreshHeaderView", 1, "showDynamicLogoView Async fetchAnimDrawable first!");
      if (RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).isFileDownLoaded("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip"))
      {
        QLog.d("RefreshHeaderView", 1, "showDynamicLogoView AnimDrawable already downloaded!");
        localObject = new AnimationDrawableCreateOption.Builder("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip");
        ((AnimationDrawableCreateOption.Builder)localObject).b(67);
        ((AnimationDrawableCreateOption.Builder)localObject).a(2147483647L);
        ((AnimationDrawableCreateOption.Builder)localObject).a(true);
        ((AnimationDrawableCreateOption.Builder)localObject).b(true);
        AnimationDrawableFactory.a().a(hashCode(), ((AnimationDrawableCreateOption.Builder)localObject).a(), this.x);
        return;
      }
      m();
      QLog.d("RefreshHeaderView", 1, "showDynamicLogoView AnimDrawable need download,show static logo first!");
      return;
    }
    QLog.d("RefreshHeaderView", 1, "showUpdateAnim sync!");
    a(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.b;
    int i2 = 0;
    int i1;
    if (!paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((LinearLayout)localObject).setVisibility(i1);
    localObject = this.c;
    if (paramBoolean) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((FrameLayout)localObject).setVisibility(i1);
  }
  
  private void c(int paramInt)
  {
    if (paramInt == getVisibleHeight()) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getVisibleHeight(), paramInt });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new RefreshHeaderView.4(this, paramInt));
    localValueAnimator.start();
  }
  
  private void k()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, 0);
    setLayoutParams(localLayoutParams);
    setPadding(0, 0, 0, 0);
    this.a = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131626954, null));
    addView(this.a, new LinearLayout.LayoutParams(-1, 0));
    this.b = ((LinearLayout)findViewById(2131437544));
    this.c = ((FrameLayout)findViewById(2131433306));
    this.d = ((ImageView)findViewById(2131436405));
    this.e = ((TextView)findViewById(2131448699));
    this.f = ((ImageView)findViewById(2131448698));
    this.g = ((TextView)findViewById(2131448850));
    measure(-2, -2);
    this.h = getMeasuredHeight();
    this.u = getResources().getDrawable(2130845174);
  }
  
  private void l()
  {
    int i1 = getWidth();
    int i2 = getHeight();
    this.g.setText(this.o);
    QCircleRippleAnimView localQCircleRippleAnimView = new QCircleRippleAnimView(getContext());
    localQCircleRippleAnimView.a(getContext().getResources().getColor(2131167059)).c(i1 / 6).b((int)(Math.sqrt(i1 * i1 + i2 * i2) / 2.0D)).a(320L).a(i1 / 2.0F, i2 / 2.0F).a(this.c).a(new BezierInterpolator(0.2F, 0.0F, 0.17F, 1.0F)).a(new RefreshHeaderView.3(this));
    localQCircleRippleAnimView.a();
  }
  
  private void m()
  {
    this.d.setImageDrawable(this.u);
  }
  
  private void n()
  {
    QQAnimationDrawable localQQAnimationDrawable = this.v;
    if (localQQAnimationDrawable == null)
    {
      QLog.e("RefreshHeaderView", 1, "stopDynamicLogoAnim AnimationDrawable is null!");
      return;
    }
    if (localQQAnimationDrawable.isRunning()) {
      this.v.stop();
    }
  }
  
  private boolean o()
  {
    return getParent() != null;
  }
  
  public void a()
  {
    setState(0);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((getVisibleHeight() > 0) || (paramFloat1 > 0.0F))
    {
      setVisibleHeight((int)paramFloat1 + getVisibleHeight());
      if (this.i <= 1)
      {
        if (getVisibleHeight() > this.h)
        {
          b();
          return;
        }
        a();
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.j == -1.0F) {
      this.j = paramMotionEvent.getRawY();
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 2)
      {
        this.j = -1.0F;
        if ((o()) && (!this.m) && (!this.n)) {
          c();
        }
      }
      else
      {
        float f2 = paramMotionEvent.getRawY();
        float f1 = this.j;
        f2 = (f2 - f1) / 2.0F;
        boolean bool;
        if (f1 == 0.0F) {
          bool = true;
        } else {
          bool = false;
        }
        this.j = paramMotionEvent.getRawY();
        this.k += f2;
        if ((o()) && (!this.m) && (!this.n) && (a(f2, bool)))
        {
          a(f2, this.k);
          if (getVisibleHeight() <= 0) {}
        }
      }
    }
    else
    {
      this.j = paramMotionEvent.getRawY();
      this.k = 0.0F;
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    setState(2);
    getMainHandler().postDelayed(new RefreshHeaderView.5(this, paramRecyclerView), 100L);
  }
  
  public void b()
  {
    setState(1);
  }
  
  public boolean c()
  {
    int i1 = getVisibleHeight();
    boolean bool;
    if ((getVisibleHeight() > this.h) && (this.i < 2))
    {
      setState(2);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (this.i == 2)
    {
      int i2 = this.h;
      if (i1 > i2) {
        c(i2);
      }
    }
    if (this.i != 2) {
      c(0);
    }
    i1 = this.i;
    if ((i1 == 2) || (i1 == 5)) {
      c(this.h);
    }
    return bool;
  }
  
  public void d()
  {
    QLog.d("RefreshHeaderView", 1, "refreshComplete");
    int i1;
    if (!TextUtils.isEmpty(this.o)) {
      i1 = 5;
    } else {
      i1 = 3;
    }
    if (i1 == 3)
    {
      long l1 = 1000L - this.t;
      if (l1 > 0L)
      {
        getMainHandler().postDelayed(new RefreshHeaderView.2(this), l1);
        return;
      }
      setState(3);
      return;
    }
    setState(5);
  }
  
  void e()
  {
    this.n = true;
    b(true);
    l();
  }
  
  void f()
  {
    a(true);
    c(0);
  }
  
  void g()
  {
    m();
    a(false);
    this.e.setText(this.r);
  }
  
  public View getHeaderView()
  {
    return this;
  }
  
  public Handler getMainHandler()
  {
    if (this.p == null) {
      this.p = new Handler(Looper.getMainLooper());
    }
    return this.p;
  }
  
  public View getRefreshView()
  {
    return this;
  }
  
  public int getVisibleHeight()
  {
    return ((LinearLayout.LayoutParams)this.a.getLayoutParams()).height;
  }
  
  void h()
  {
    b(false);
    if (this.i == 1) {
      this.d.setImageDrawable(this.u);
    }
    if (this.i == 2) {
      this.d.clearAnimation();
    }
    m();
    a(false);
    this.e.setText(this.s);
  }
  
  public boolean i()
  {
    return this.m;
  }
  
  public void j()
  {
    if (getMainHandler() != null) {
      getMainHandler().removeCallbacksAndMessages(null);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(this.i);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.i == 1) {
      setState(2);
    }
    m();
    n();
  }
  
  void setJustShowRefreshAnimState(int paramInt)
  {
    QLog.d("RefreshHeaderView", 4, "STATE_JUST_SHOW_REFRESH_ANIMATION");
    this.t = System.currentTimeMillis();
    a(true);
    b(paramInt);
    c(this.h);
    setRefreshing(true);
  }
  
  public void setOnRefreshListener(IRefreshViewProvider.OnRefreshListener paramOnRefreshListener)
  {
    this.l = paramOnRefreshListener;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (!paramBoolean) {
      d();
    }
  }
  
  void setRefreshingState(int paramInt)
  {
    this.t = System.currentTimeMillis();
    a(true);
    b(paramInt);
    c(this.h);
    IRefreshViewProvider.OnRefreshListener localOnRefreshListener = this.l;
    if (localOnRefreshListener != null) {
      localOnRefreshListener.b();
    }
  }
  
  public void setState(int paramInt)
  {
    if (paramInt == this.i) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt == 5) {
                e();
              }
            }
            else {
              setJustShowRefreshAnimState(paramInt);
            }
          }
          else {
            f();
          }
        }
        else {
          setRefreshingState(paramInt);
        }
      }
      else {
        g();
      }
    }
    else {
      h();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state:");
    localStringBuilder.append(paramInt);
    QLog.d("RefreshHeaderView", 1, localStringBuilder.toString());
    this.i = paramInt;
  }
  
  public void setVisibleHeight(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.height = i1;
    this.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView
 * JD-Core Version:    0.7.0.1
 */