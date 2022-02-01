package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.Timer;

public class VideoNextFeedsView
  extends FrameLayout
{
  private final String a = "VideoNextFeedsView";
  private ImageView b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private int f = UIUtils.a(getContext(), 18.0F);
  private boolean g = false;
  private int h = UIUtils.a(getContext(), 331.0F);
  private int i = UIUtils.a(getContext(), 75.0F);
  private int j;
  private int k;
  private CertifiedAccountMeta.StFeed l;
  private View m;
  private Timer n;
  private int o = 5;
  private List<CertifiedAccountMeta.StFeed> p;
  private int q = 0;
  private VideoNextFeedsView.OnCounterListener r;
  private CircleProgress s;
  private TextView t;
  private int u;
  
  public VideoNextFeedsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoNextFeedsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoNextFeedsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void e()
  {
    this.m = LayoutInflater.from(getContext()).inflate(2131624399, null);
    addView(this.m);
    this.c = ((ImageView)this.m.findViewById(2131436474));
    this.e = ((TextView)this.m.findViewById(2131448600));
    this.d = ((TextView)this.m.findViewById(2131448601));
    this.t = ((TextView)this.m.findViewById(2131448359));
    this.b = ((ImageView)this.m.findViewById(2131436475));
    this.s = ((CircleProgress)this.m.findViewById(2131431487));
    this.s.setBgAndProgressColor(30, Color.parseColor("#ffffff"), 100, Color.parseColor("#ffffff"));
    this.s.setStrokeWidth(UIUtils.a(getContext(), 1.0F));
    setVisibility(8);
  }
  
  private boolean f()
  {
    if (this.p == null) {
      return false;
    }
    CertifiedAccountMeta.StFeed localStFeed;
    for (;;)
    {
      localStFeed = null;
      if (this.q >= this.p.size()) {
        break;
      }
      localStFeed = (CertifiedAccountMeta.StFeed)this.p.get(this.q);
      if ((localStFeed != null) && (SubscribeLaucher.a(localStFeed.type.get()))) {
        break;
      }
      this.q += 1;
    }
    if (localStFeed == null)
    {
      QZLog.e("VideoNextFeedsView", "playNextData():no more feed can play!");
      return false;
    }
    ImageView localImageView = this.c;
    String str = localStFeed.poster.icon.get();
    int i1 = UIUtils.a(getContext(), this.f);
    int i2 = UIUtils.a(getContext(), this.f);
    Context localContext = getContext();
    float f1;
    if (this.g) {
      f1 = 10.0F;
    } else {
      f1 = 9.0F;
    }
    UIUtils.a(localImageView, str, i1, i2, UIUtils.a(localContext, f1), ImageUtil.j(), null);
    UIUtils.a(this.b, localStFeed.cover.url.get(), this.j, this.k, getResources().getDrawable(2130839760), null);
    this.e.setText(localStFeed.title.get());
    this.d.setText(localStFeed.poster.nick.get());
    this.l = localStFeed;
    this.q += 1;
    return true;
  }
  
  private void g()
  {
    Timer localTimer = this.n;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.n = null;
      this.o = 5;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.u = this.o;
      g();
      return;
    }
    d();
    this.u = 0;
  }
  
  public boolean a()
  {
    if (f())
    {
      d();
      setVisibility(0);
      return true;
    }
    setVisibility(8);
    return false;
  }
  
  public void b()
  {
    VideoNextFeedsView.OnCounterListener localOnCounterListener = this.r;
    if (localOnCounterListener != null) {
      localOnCounterListener.a(f());
    }
  }
  
  public void c()
  {
    if (getHandler() != null) {
      getHandler().post(new VideoNextFeedsView.1(this));
    }
  }
  
  public void d()
  {
    g();
    int i1 = this.u;
    if (i1 != 0) {
      this.o = i1;
    }
    this.n = new Timer();
    this.n.schedule(new VideoNextFeedsView.2(this), 0L, 1000L);
  }
  
  public CertifiedAccountMeta.StFeed getNextFeed()
  {
    return this.l;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (getHandler() != null) {
      getHandler().removeCallbacksAndMessages(null);
    }
    g();
  }
  
  public void setData(List<CertifiedAccountMeta.StFeed> paramList)
  {
    this.q = 0;
    this.p = paramList;
  }
  
  public void setOnCounterListener(VideoNextFeedsView.OnCounterListener paramOnCounterListener)
  {
    this.r = paramOnCounterListener;
  }
  
  public void setUIState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      i1 = ImmersiveUtils.dpToPx(400.0F);
    }
    else
    {
      double d1 = ImmersiveUtils.getScreenWidth();
      Double.isNaN(d1);
      i1 = (int)(d1 * 0.88D);
    }
    this.g = paramBoolean1;
    float f1;
    if (paramBoolean1) {
      f1 = 14.0F;
    } else {
      f1 = 8.0F;
    }
    int i2 = ImmersiveUtils.dpToPx(f1);
    if (!paramBoolean1) {
      i1 = ImmersiveUtils.dpToPx(331.0F);
    }
    this.h = i1;
    if (paramBoolean1) {
      i1 = ImmersiveUtils.dpToPx(135.0F);
    } else {
      i1 = -2;
    }
    this.i = i1;
    if (paramBoolean1) {
      f1 = 133.0F;
    } else {
      f1 = 75.0F;
    }
    this.j = ImmersiveUtils.dpToPx(f1);
    if (paramBoolean1) {
      f1 = 103.0F;
    } else {
      f1 = 59.0F;
    }
    this.k = ImmersiveUtils.dpToPx(f1);
    if (paramBoolean1) {
      f1 = 20.0F;
    } else {
      f1 = 18.0F;
    }
    this.f = ImmersiveUtils.dpToPx(f1);
    if (paramBoolean1) {
      f1 = 30.0F;
    } else {
      f1 = 10.0F;
    }
    int i1 = ImmersiveUtils.dpToPx(f1);
    this.m.setPadding(i2, i2, i2, i2);
    getLayoutParams().width = this.h;
    getLayoutParams().height = this.i;
    this.c.getLayoutParams().width = this.f;
    this.c.getLayoutParams().height = this.f;
    this.b.getLayoutParams().width = this.j;
    this.b.getLayoutParams().height = this.k;
    this.e.setPadding(0, 0, i1, 0);
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.VideoNextFeedsView
 * JD-Core Version:    0.7.0.1
 */