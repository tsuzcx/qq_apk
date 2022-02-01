package com.tencent.biz.pubaccount.weishi_new.like;

import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

public class WsSingleClickLikeAnimation
{
  private Animation a;
  private Animation b;
  private Animation c;
  private Animation d;
  private Animation e;
  private AnimationSet f;
  private AnimationSet g;
  private View h;
  private TextView i;
  private View j;
  private stSimpleMetaFeed k;
  
  private void a(boolean paramBoolean)
  {
    View localView = this.h;
    if (localView != null)
    {
      if (this.j == null) {
        return;
      }
      if (paramBoolean)
      {
        localView.setSelected(true);
        this.j.setVisibility(0);
        if (this.a == null) {
          this.a = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772293);
        }
        if (this.c == null)
        {
          this.c = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772295);
          this.c.setStartOffset(40L);
        }
        if (this.b == null)
        {
          this.b = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772294);
          this.b.setStartOffset(250L);
        }
        if (this.d == null)
        {
          this.d = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772296);
          this.d.setStartOffset(290L);
        }
        if (this.f == null)
        {
          this.f = new AnimationSet(true);
          this.f.addAnimation(this.a);
          this.f.addAnimation(this.c);
        }
        if (this.g == null)
        {
          this.g = new AnimationSet(true);
          this.g.addAnimation(this.b);
          this.g.addAnimation(this.d);
        }
        this.h.startAnimation(this.f);
        this.j.startAnimation(this.g);
        return;
      }
      localView.setSelected(false);
      this.j.setVisibility(8);
      if (this.e == null) {
        this.e = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772297);
      }
      this.h.startAnimation(this.e);
    }
  }
  
  public stSimpleMetaFeed a()
  {
    return this.k;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, View paramView1, View paramView2, TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    this.k = paramstSimpleMetaFeed;
    this.h = paramView1;
    this.i = paramTextView;
    this.j = paramView2;
    a(paramBoolean, paramInt);
    a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((View)localObject).setSelected(paramBoolean);
    }
    localObject = this.j;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.i;
    if (localObject != null)
    {
      if (paramInt > 0)
      {
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextView(this.i, paramInt, "0");
        return;
      }
      ((TextView)localObject).setText(HardCodeUtil.a(2131888190));
    }
  }
  
  public View b()
  {
    return this.h;
  }
  
  public TextView c()
  {
    return this.i;
  }
  
  public View d()
  {
    return this.j;
  }
  
  public void e()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      ((AnimationSet)localObject).cancel();
      this.f = null;
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((AnimationSet)localObject).cancel();
      this.g = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((Animation)localObject).cancel();
      this.e = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WsSingleClickLikeAnimation
 * JD-Core Version:    0.7.0.1
 */