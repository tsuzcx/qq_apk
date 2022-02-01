package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ZoomControls;

public final class js
  implements gh
{
  public ZoomControls a;
  public jt b = null;
  public ViewGroup c;
  public gh.b d = gh.b.c;
  public lu.a e = null;
  pn f;
  private Context g;
  private int h = 0;
  
  public js(Context paramContext, pn parampn)
  {
    this.g = paramContext;
    this.f = parampn;
    this.b = new jt(paramContext);
    this.b.setVisibility(8);
    parampn = fy.c(fy.b(this.g, "location_enable.png"));
    Bitmap localBitmap1 = fy.c(fy.b(this.g, "location_state_normal.png"));
    Bitmap localBitmap2 = fy.c(fy.b(this.g, "location_state_selected.png"));
    this.b.setScaleType(ImageView.ScaleType.CENTER);
    this.b.setImageBitmap(parampn);
    this.b.a(this.g, localBitmap1, localBitmap2);
    try
    {
      this.a = new ZoomControls(paramContext);
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.a.measure(i, j);
      this.h = this.a.getMeasuredHeight();
      this.a.setVisibility(8);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    paramContext = this.a;
    if (paramContext != null)
    {
      paramContext.setOnZoomInClickListener(new js.1(this));
      this.a.setOnZoomOutClickListener(new js.2(this));
    }
    this.b.setOnClickListener(new js.3(this));
  }
  
  public final void a()
  {
    jt localjt = this.b;
    if (localjt != null)
    {
      localjt.setClickable(false);
      Drawable localDrawable = localjt.getBackground();
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      localjt.setBackgroundDrawable(null);
    }
  }
  
  public final void a(int paramInt1, int paramInt2) {}
  
  public final boolean a(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup != null) && (this.a != null) && (this.b != null))
    {
      this.c = paramViewGroup;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      switch (js.4.a[this.d.ordinal()])
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder("Unknown position:");
        localStringBuilder.append(this.d);
        or.b(localStringBuilder.toString());
        break;
      case 6: 
        localLayoutParams.gravity = 53;
        localLayoutParams.topMargin = 5;
        localLayoutParams.rightMargin = 5;
        break;
      case 5: 
        localLayoutParams.gravity = 49;
        localLayoutParams.topMargin = 5;
        break;
      case 4: 
        localLayoutParams.gravity = 51;
        localLayoutParams.topMargin = 5;
        localLayoutParams.leftMargin = 5;
        break;
      case 3: 
        localLayoutParams.gravity = 85;
        localLayoutParams.bottomMargin = 5;
        localLayoutParams.rightMargin = 5;
        break;
      case 2: 
        localLayoutParams.gravity = 81;
        localLayoutParams.bottomMargin = 5;
        break;
      case 1: 
        localLayoutParams.gravity = 83;
        localLayoutParams.bottomMargin = 5;
        localLayoutParams.leftMargin = 5;
      }
      if (paramViewGroup.indexOfChild(this.a) < 0) {
        paramViewGroup.addView(this.a, localLayoutParams);
      } else {
        paramViewGroup.updateViewLayout(this.a, localLayoutParams);
      }
      localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = (this.h + 5);
      localLayoutParams.rightMargin = 5;
      if (paramViewGroup.indexOfChild(this.b) < 0) {
        paramViewGroup.addView(this.b, localLayoutParams);
      } else {
        paramViewGroup.updateViewLayout(this.b, localLayoutParams);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.js
 * JD-Core Version:    0.7.0.1
 */