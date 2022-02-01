package com.tencent.biz.qqcircle.publish.outbox.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class BasePushBanner
  extends Banner
{
  protected LinearLayout e;
  protected LinearLayout f;
  protected TextView g;
  protected ImageView h;
  protected View i;
  protected Animation j;
  
  public BasePushBanner(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public BasePushBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  protected void b()
  {
    setDefaultLayoutParams();
    View localView = LayoutInflater.from(getContext()).inflate(2131626766, this, true);
    this.i = localView.findViewById(2131429298);
    this.f = ((LinearLayout)localView.findViewById(2131443173));
    this.g = ((TextView)localView.findViewById(2131443172));
    this.e = ((LinearLayout)localView.findViewById(2131443171));
    this.h = ((ImageView)localView.findViewById(2131443170));
  }
  
  protected void c() {}
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.banner.BasePushBanner
 * JD-Core Version:    0.7.0.1
 */