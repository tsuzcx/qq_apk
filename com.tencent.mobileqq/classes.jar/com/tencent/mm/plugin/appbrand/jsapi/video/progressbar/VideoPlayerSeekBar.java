package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.wxa.ma.e.b;
import com.tencent.luggage.wxa.qt.c;

public class VideoPlayerSeekBar
  extends a
  implements e.b
{
  protected boolean m = false;
  private c n = new c();
  private int o = -1;
  private int p = -1;
  private int q = -1;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt, c paramc)
  {
    int i = ((FrameLayout.LayoutParams)this.d.getLayoutParams()).leftMargin - getBarPointPaddingLeft();
    paramInt -= i;
    double d1 = paramInt;
    Double.isNaN(d1);
    double d2 = getBarLen();
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = this.i;
    Double.isNaN(d2);
    paramc.a = ((int)(d1 * d2));
    if (paramc.a <= 0)
    {
      paramc.a = 0;
      if (paramInt > i) {
        return paramInt;
      }
      return i;
    }
    if (paramc.a >= this.i)
    {
      paramc.a = this.i;
      paramInt = getBarLen() - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
    }
    return paramInt;
  }
  
  private int getBarPointPaddingLeft()
  {
    if (this.p == -1) {
      this.p = this.e.getPaddingLeft();
    }
    return this.p;
  }
  
  private int getBarPointPaddingRight()
  {
    if (this.q == -1) {
      this.q = this.e.getPaddingRight();
    }
    return this.q;
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.i) {
      paramInt = this.i;
    }
    if (this.j != paramInt)
    {
      this.j = paramInt;
      u();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    setIsPlay(paramBoolean);
  }
  
  protected int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.d.getLayoutParams();
      return 0;
    }
    if (paramInt1 >= this.i) {
      return paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
    }
    double d1 = paramInt1;
    Double.isNaN(d1);
    double d2 = this.i;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = paramInt2;
    Double.isNaN(d2);
    return (int)(d1 * d2);
  }
  
  public void b(int paramInt)
  {
    a(paramInt);
  }
  
  protected int getBarPointWidth()
  {
    if (this.o == -1) {
      this.o = this.e.getWidth();
    }
    return this.o;
  }
  
  protected int getLayoutId()
  {
    return 2131624237;
  }
  
  public ImageView getPlayBtn()
  {
    return this.f;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.g;
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
    this.e.setOnTouchListener(new VideoPlayerSeekBar.1(this));
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    this.m = paramBoolean;
    super.setIsPlay(paramBoolean);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.f != null) {
      this.f.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    this.i = paramInt;
    this.j = 0;
    TextView localTextView = this.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(this.i / 60));
    localStringBuilder.append(":");
    localStringBuilder.append(c(this.i % 60));
    localTextView.setText(localStringBuilder.toString());
    u();
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
    Object localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(this.j / 60));
    localStringBuilder.append(":");
    localStringBuilder.append(c(this.j % 60));
    ((TextView)localObject).setText(localStringBuilder.toString());
    localObject = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    int i = getBarLen();
    ((FrameLayout.LayoutParams)localObject).leftMargin = b(this.j, i);
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    double d1 = this.j;
    Double.isNaN(d1);
    double d2 = this.i;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = i;
    Double.isNaN(d2);
    ((FrameLayout.LayoutParams)localObject).width = ((int)(d1 * d2));
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */