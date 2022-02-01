package com.tencent.biz.qqcircle.fragments;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

public class ScrollMoreGuideView
{
  private ViewGroup a;
  private LinearLayout b;
  private AnimatorSet c;
  private volatile boolean d = false;
  private int e = 3;
  private ObjectAnimator f;
  private ObjectAnimator g;
  private ObjectAnimator h;
  private ObjectAnimator i;
  private volatile boolean j = true;
  private View k;
  private URLImageView l;
  private ScrollMoreGuideView.OnFinishListener m;
  
  public ScrollMoreGuideView(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
    c();
  }
  
  private void c()
  {
    this.b = new LinearLayout(this.a.getContext());
    this.b.setGravity(17);
    this.b.setOrientation(1);
    this.b.setBackgroundColor(Color.parseColor("#33000000"));
    e();
    d();
    this.b.setOnClickListener(new ScrollMoreGuideView.1(this));
    this.b.setOnTouchListener(new ScrollMoreGuideView.2(this));
  }
  
  private void d()
  {
    TextView localTextView = new TextView(this.a.getContext());
    localTextView.setTextSize(1, 16.0F);
    localTextView.setText("上下滑动查看更多哟");
    localTextView.setGravity(1);
    this.b.addView(localTextView, new LinearLayout.LayoutParams(-2, -2));
  }
  
  private ImageView e()
  {
    this.l = new URLImageView(this.a.getContext());
    Object localObject = new LinearLayout.LayoutParams(ImmersiveUtils.a(50.0F), ImmersiveUtils.a(165.0F));
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.l.setBackgroundResource(2130853313);
    this.l.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new Option().setUrl("https://qzonestyle.gtimg.cn/aoi/sola/20200228153849_2Ep5Zbq1da.png").setTargetView(this.l).setLoadingDrawable(this.l.getResources().getDrawable(2130853309)).setRequestWidth(this.l.getLayoutParams().width).setRequestHeight(this.l.getLayoutParams().height);
    QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
    this.b.addView(this.l);
    return this.l;
  }
  
  private Interpolator f()
  {
    return PathInterpolatorCompat.create(0.25F, 0.1F, 0.25F, 1.0F);
  }
  
  public void a()
  {
    try
    {
      if (this.a == null) {
        return;
      }
      if (!this.j) {
        return;
      }
      if (this.b == null) {
        c();
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.a.addView(this.b, localLayoutParams);
      this.d = true;
      if (this.c != null)
      {
        this.e -= 1;
        this.c.start();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      this.k = paramRecyclerView.getChildAt(0);
      if (this.k != null)
      {
        URLImageView localURLImageView = this.l;
        if (localURLImageView == null) {
          return;
        }
        this.f = ObjectAnimator.ofFloat(localURLImageView, "alpha", new float[] { 0.0F, 1.0F });
        this.f.setInterpolator(f());
        this.f.setDuration(300L);
        this.g = ObjectAnimator.ofInt(this.k, "scrollY", new int[] { 0, ImmersiveUtils.a(134.0F) });
        this.g.setInterpolator(f());
        this.g.setDuration(800L);
        this.h = ObjectAnimator.ofFloat(this.l, "alpha", new float[] { 1.0F, 0.0F });
        this.h.setInterpolator(f());
        this.h.setDuration(300L);
        this.i = ObjectAnimator.ofInt(this.k, "scrollY", new int[] { ImmersiveUtils.a(134.0F), 0 });
        this.i.setInterpolator(f());
        this.i.setDuration(200L);
        this.c = new AnimatorSet();
        this.c.playSequentially(new Animator[] { this.f, this.g, this.h, this.i });
        this.c.addListener(new ScrollMoreGuideView.3(this, paramRecyclerView));
      }
    }
  }
  
  public void a(ScrollMoreGuideView.OnFinishListener paramOnFinishListener)
  {
    this.m = paramOnFinishListener;
  }
  
  public void b()
  {
    this.d = false;
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null)
    {
      LinearLayout localLinearLayout = this.b;
      if (localLinearLayout != null) {
        localViewGroup.removeView(localLinearLayout);
      }
    }
    if (!this.j) {
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.ScrollMoreGuideView
 * JD-Core Version:    0.7.0.1
 */