package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.AdapterView;

public class GalleryPageView
  extends AbstractGalleryPageView
{
  TextView a;
  AbstractGalleryScene b;
  public int c = 3;
  Runnable d = new GalleryPageView.3(this);
  AlphaAnimation e = new AlphaAnimation(0.0F, 1.0F);
  AlphaAnimation f = new AlphaAnimation(1.0F, 0.0F);
  private boolean g = true;
  
  public void a(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public void a(Activity paramActivity, AbstractGalleryScene paramAbstractGalleryScene, int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramAbstractGalleryScene.C();
    this.a = new TextView(paramActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, this.c, paramActivity.getResources().getDisplayMetrics()) + paramInt);
    this.a.setTextColor(Color.parseColor("#e6e9e9e9"));
    this.a.setTextSize(2, 15.0F);
    this.a.setId(2131433941);
    localRelativeLayout.addView(this.a, localLayoutParams);
    this.a.setVisibility(4);
    this.e.setDuration(300L);
    this.f.setDuration(300L);
    this.b = paramAbstractGalleryScene;
    this.e.setAnimationListener(new GalleryPageView.1(this));
    this.f.setAnimationListener(new GalleryPageView.2(this));
  }
  
  public void a(AdapterView paramAdapterView, int paramInt)
  {
    if (paramAdapterView.getCount() > 1)
    {
      TextView localTextView = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt + 1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramAdapterView.getCount());
      localTextView.setText(localStringBuilder.toString());
      if (this.a.getVisibility() == 4)
      {
        this.a.setVisibility(0);
        this.a.startAnimation(this.e);
        if (this.g)
        {
          this.a.postDelayed(this.d, 3000L);
          this.g = false;
          return;
        }
        this.a.postDelayed(this.d, 2000L);
        return;
      }
      this.a.removeCallbacks(this.d);
      this.a.clearAnimation();
      this.a.postDelayed(this.d, 2000L);
      return;
    }
    this.a.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.GalleryPageView
 * JD-Core Version:    0.7.0.1
 */