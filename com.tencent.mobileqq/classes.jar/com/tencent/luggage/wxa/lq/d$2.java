package com.tencent.luggage.wxa.lq;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;

class d$2
  implements Runnable
{
  d$2(d paramd, h paramh, boolean paramBoolean1, u paramu, int paramInt1, int paramInt2, boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  private void a(View paramView)
  {
    if (this.f) {
      new d.2.a(this, paramView);
    }
  }
  
  private void b(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131436420);
    paramView = (ProgressBar)paramView.findViewById(2131440726);
    if (this.g.equals("loading"))
    {
      localImageView.setVisibility(8);
      paramView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(0);
    paramView.setVisibility(8);
    PorterDuffColorFilter localPorterDuffColorFilter = null;
    if (!af.c(this.h))
    {
      Bitmap localBitmap = r.a(this.a.q(), this.h);
      paramView = localPorterDuffColorFilter;
      if (localBitmap != null)
      {
        paramView = localPorterDuffColorFilter;
        if (!localBitmap.isRecycled()) {
          paramView = new BitmapDrawable(localImageView.getResources(), localBitmap);
        }
      }
    }
    else if (this.g.equals("error"))
    {
      paramView = this.a.getContext().getResources().getDrawable(2130838685);
      localPorterDuffColorFilter = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      paramView.mutate().setColorFilter(localPorterDuffColorFilter);
    }
    else
    {
      paramView = this.a.getContext().getResources().getDrawable(2130838686);
    }
    if (paramView != null)
    {
      localImageView.setImageDrawable(paramView);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
  
  private void c(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131447463);
    int k = com.tencent.luggage.wxa.qx.a.e(localTextView.getContext(), 18);
    if (!af.c(this.i))
    {
      localTextView.setLineSpacing(0.0F, 1.0F);
      localTextView.setSpannableFactory(new d.2.2(this, k));
      localTextView.setText(this.i, TextView.BufferType.SPANNABLE);
      localTextView.setVisibility(0);
      if (!this.b) {
        paramView.findViewById(2131445915).setPadding(0, com.tencent.luggage.wxa.qx.a.e(localTextView.getContext(), 27), 0, 0);
      }
    }
    else
    {
      localTextView.setVisibility(4);
    }
  }
  
  public void run()
  {
    if (d.a(this.j) != null) {
      d.a(this.j).c();
    }
    if (!this.a.d())
    {
      o.c("MicroMsg.JsApiShowToast", "service is not running");
      return;
    }
    View localView;
    if (this.b) {
      localView = LayoutInflater.from(this.c.getContext()).inflate(2131624230, (ViewGroup)this.c.getContentView(), false);
    } else {
      localView = LayoutInflater.from(this.c.getContext()).inflate(2131624231, (ViewGroup)this.c.getContentView(), false);
    }
    a(localView);
    c(localView);
    if (!this.b) {
      b(localView);
    }
    this.c.X().a();
    this.c.X().a(localView);
    d.a(this.j, new v(Looper.getMainLooper(), new d.2.1(this, localView), false));
    d.a(this.j).a(this.d);
    this.a.a(this.e, this.j.b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.d.2
 * JD-Core Version:    0.7.0.1
 */