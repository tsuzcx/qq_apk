package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.ma.e.d;

public class a
  extends RelativeLayout
{
  protected e.d a = null;
  protected View b = null;
  protected ImageView c;
  protected ImageView d = null;
  protected ImageView e = null;
  protected ImageView f = null;
  protected TextView g;
  protected TextView h;
  protected int i = 0;
  protected int j = 0;
  protected boolean k = false;
  protected float l = 0.0F;
  private int m = 0;
  private int n = 0;
  private int o = -1;
  private int p = -1;
  private int q = -1;
  private int r = -1;
  
  public a(Context paramContext)
  {
    super(paramContext);
    q();
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    q();
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    q();
  }
  
  private int b(int paramInt)
  {
    int i2 = (getBarPointWidth() - this.e.getPaddingLeft() - this.e.getPaddingRight()) / 2;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.d.getLayoutParams();
    int i1;
    if (paramInt < localLayoutParams.leftMargin - this.e.getPaddingLeft() - i2) {
      i1 = localLayoutParams.leftMargin - this.e.getPaddingLeft();
    }
    for (paramInt = i2;; paramInt = this.e.getPaddingLeft())
    {
      return i1 - paramInt;
      if (paramInt <= getBarLen() + localLayoutParams.leftMargin - i2 - this.e.getPaddingLeft()) {
        break;
      }
      i1 = getBarLen() + localLayoutParams.leftMargin - i2;
    }
    return paramInt;
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    u();
  }
  
  public String c(int paramInt)
  {
    if (paramInt < 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  protected int getBarLen()
  {
    if (this.m <= 0) {
      this.m = this.d.getWidth();
    }
    return this.m;
  }
  
  protected int getBarPointWidth()
  {
    if (this.n <= 0) {
      this.n = this.e.getWidth();
    }
    return this.n;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    int i1 = ((FrameLayout.LayoutParams)this.d.getLayoutParams()).leftMargin;
    int i2 = this.e.getPaddingLeft();
    double d1 = ((FrameLayout.LayoutParams)this.e.getLayoutParams()).leftMargin - (i1 - i2) + (getBarPointWidth() - this.e.getPaddingLeft() - this.e.getPaddingRight()) / 2;
    Double.isNaN(d1);
    double d2 = getBarLen();
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = this.i;
    Double.isNaN(d2);
    return Math.max(0, (int)(d1 * d2));
  }
  
  protected int getLayoutId()
  {
    return 2131624236;
  }
  
  public int getVideoTotalTime()
  {
    return this.i;
  }
  
  public int getmPosition()
  {
    return this.j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    t();
    if ((paramInt1 != this.o) || (paramInt2 != this.p) || (paramInt3 != this.q) || (paramInt4 != this.r)) {
      u();
    }
    this.o = paramInt1;
    this.p = paramInt2;
    this.q = paramInt3;
    this.r = paramInt4;
  }
  
  protected void q()
  {
    this.b = View.inflate(getContext(), getLayoutId(), this);
    this.c = ((ImageView)this.b.findViewById(2131440414));
    this.d = ((ImageView)this.b.findViewById(2131440413));
    this.e = ((ImageView)this.b.findViewById(2131440416));
    this.f = ((ImageView)this.b.findViewById(2131440374));
    this.g = ((TextView)this.b.findViewById(2131440379));
    this.h = ((TextView)this.b.findViewById(2131440392));
    this.e.setOnTouchListener(new a.1(this));
    r();
  }
  
  protected void r()
  {
    this.e.post(new a.2(this));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.width = 0;
    this.c.setLayoutParams(localLayoutParams);
  }
  
  public void s()
  {
    TextView localTextView = this.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(this.i / 60));
    localStringBuilder.append(":");
    localStringBuilder.append(c(this.i % 60));
    localTextView.setText(localStringBuilder.toString());
    u();
  }
  
  public void setIplaySeekCallback(e.d paramd)
  {
    this.a = paramd;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setImageResource(2130841675);
      return;
    }
    this.f.setImageResource(2130841676);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.f.setOnClickListener(paramOnClickListener);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    this.i = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new a.3(this));
      return;
    }
    s();
  }
  
  public void t()
  {
    this.m = 0;
  }
  
  public void u()
  {
    if (this.i == 0) {
      return;
    }
    if (this.k) {
      return;
    }
    if (this.e == null) {
      return;
    }
    if (getBarLen() == 0) {
      return;
    }
    int i1 = (getBarPointWidth() - this.e.getPaddingLeft() - this.e.getPaddingRight()) / 2;
    Object localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(this.j / 60));
    localStringBuilder.append(":");
    localStringBuilder.append(c(this.j % 60));
    ((TextView)localObject).setText(localStringBuilder.toString());
    int i2 = ((FrameLayout.LayoutParams)this.d.getLayoutParams()).leftMargin;
    int i3 = this.e.getPaddingLeft();
    localObject = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    double d1 = this.j;
    Double.isNaN(d1);
    double d2 = this.i;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = getBarLen();
    Double.isNaN(d2);
    ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(d1 * d2) + (i2 - i3) - i1);
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    d1 = this.j;
    Double.isNaN(d1);
    d2 = this.i;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = getBarLen();
    Double.isNaN(d2);
    ((FrameLayout.LayoutParams)localObject).width = ((int)(d1 * d2));
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a
 * JD-Core Version:    0.7.0.1
 */