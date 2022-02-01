package com.tencent.gdtad.views.canvas.components.danmaku;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.Pools.SimplePool;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;

public class GdtDanmakuPresenter
  extends RelativeLayout
{
  private final Handler a = new Handler(Looper.getMainLooper());
  private int b = 2;
  private int c = 10;
  private int d = 20;
  private float e = 0.1F;
  private int f = 14;
  private String g = "#FFFFFFFF";
  private String h = "#993C3C3C";
  private int i = 10;
  private int j = 10;
  private int k = -1;
  private Context l;
  private GdtDanmakuModel m = new GdtDanmakuModel();
  private GdtDanmakuPresenter.DanmakuRunnable[] n;
  private boolean o;
  private Pools.SimplePool<GdtDanmakuItemView> p;
  
  public GdtDanmakuPresenter(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GdtDanmakuPresenter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.l = paramContext;
  }
  
  private void a(GdtDanmakuItemView paramGdtDanmakuItemView)
  {
    try
    {
      this.p.release(paramGdtDanmakuItemView);
      return;
    }
    catch (IllegalStateException paramGdtDanmakuItemView) {}
  }
  
  private GdtDanmakuItemView d()
  {
    Object localObject2 = (GdtDanmakuItemView)this.p.acquire();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new GdtDanmakuItemView(this.l);
    }
    ((GdtDanmakuItemView)localObject1).setTextSize(this.f);
    ((GdtDanmakuItemView)localObject1).setClickable(false);
    localObject2 = (GradientDrawable)((GdtDanmakuItemView)localObject1).getBackground();
    ((GradientDrawable)localObject2).setColor(Color.parseColor(this.h));
    if (Build.VERSION.SDK_INT >= 16) {
      ((GdtDanmakuItemView)localObject1).setBackground((Drawable)localObject2);
    } else {
      ((GdtDanmakuItemView)localObject1).setBackgroundDrawable((Drawable)localObject2);
    }
    ((GdtDanmakuItemView)localObject1).setTextColor(Color.parseColor(this.g));
    String str = this.m.b();
    localObject2 = str;
    if (str.length() > this.i)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str.substring(0, this.i));
      ((StringBuilder)localObject2).append("...");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    ((GdtDanmakuItemView)localObject1).setText((CharSequence)localObject2);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ((GdtDanmakuItemView)localObject1).measure(i1, i1);
    i1 = ((GdtDanmakuItemView)localObject1).getMeasuredWidth();
    int i2 = AdUIUtils.dp2px(this.k, getResources());
    localObject2 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { AdUIUtils.dp2px(this.k, getResources()), -i1 });
    ((ObjectAnimator)localObject2).setInterpolator(new LinearInterpolator());
    ((ObjectAnimator)localObject2).addListener(new GdtDanmakuPresenter.1(this, (GdtDanmakuItemView)localObject1));
    ((ObjectAnimator)localObject2).setDuration((int)(AdUIUtils.px2dp(getContext(), i2 + i1) / this.e));
    ((GdtDanmakuItemView)localObject1).a((ObjectAnimator)localObject2);
    return localObject1;
  }
  
  private void e()
  {
    GdtDanmakuPresenter.DanmakuRunnable[] arrayOfDanmakuRunnable = this.n;
    if (arrayOfDanmakuRunnable != null)
    {
      int i2 = arrayOfDanmakuRunnable.length;
      int i1 = 0;
      while (i1 < i2)
      {
        GdtDanmakuPresenter.DanmakuRunnable localDanmakuRunnable = arrayOfDanmakuRunnable[i1];
        this.a.removeCallbacks(localDanmakuRunnable);
        i1 += 1;
      }
    }
    removeAllViews();
    clearDisappearingChildren();
  }
  
  public GdtDanmakuPresenter a(int paramInt, String[] paramArrayOfString)
  {
    this.m.a(paramArrayOfString);
    this.k = AdUIUtils.px2dp(getContext(), paramInt);
    return this;
  }
  
  public boolean a()
  {
    e();
    int i2 = 0;
    this.o = false;
    if (this.m.a()) {
      return false;
    }
    if (this.k == -1) {
      return false;
    }
    if (this.p == null) {
      this.p = new Pools.SimplePool(this.j);
    }
    GdtDanmakuPresenter.DanmakuRunnable[] arrayOfDanmakuRunnable = this.n;
    if (arrayOfDanmakuRunnable != null)
    {
      int i3 = arrayOfDanmakuRunnable.length;
      i1 = 0;
      while (i1 < i3)
      {
        GdtDanmakuPresenter.DanmakuRunnable localDanmakuRunnable = arrayOfDanmakuRunnable[i1];
        this.a.removeCallbacks(localDanmakuRunnable);
        i1 += 1;
      }
    }
    this.n = new GdtDanmakuPresenter.DanmakuRunnable[this.b];
    int i1 = i2;
    while (i1 < this.b)
    {
      this.n[i1] = new GdtDanmakuPresenter.DanmakuRunnable(this, i1);
      this.a.postDelayed(this.n[i1], i1 * 600);
      i1 += 1;
    }
    this.o = true;
    AdLog.i("GdtDanmakuPresenter", "danmaku start");
    return true;
  }
  
  public void b()
  {
    e();
    this.o = false;
    GdtDanmakuModel localGdtDanmakuModel = this.m;
    if (localGdtDanmakuModel != null) {
      localGdtDanmakuModel.c();
    }
    AdLog.i("GdtDanmakuPresenter", "danmaku is stopped");
  }
  
  public boolean c()
  {
    return this.o;
  }
  
  public float getDanmakuInterval()
  {
    return this.d;
  }
  
  public int getMaxCacheSize()
  {
    return this.j;
  }
  
  public int getMaxShownTextNum()
  {
    return this.i;
  }
  
  public float getSpeed()
  {
    return this.e;
  }
  
  public int getTextSize()
  {
    return this.f;
  }
  
  public int getTractInterval()
  {
    return this.c;
  }
  
  public int getTractNum()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuPresenter
 * JD-Core Version:    0.7.0.1
 */