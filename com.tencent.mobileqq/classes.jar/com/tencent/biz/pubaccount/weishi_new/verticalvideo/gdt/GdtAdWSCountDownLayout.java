package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class GdtAdWSCountDownLayout
  extends RelativeLayout
{
  public final float a = 128.5F;
  public final float b = 99.0F;
  private boolean c = false;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private Handler l = new Handler(Looper.getMainLooper());
  private int m;
  private int n;
  private int o;
  private final int p = 1;
  private Runnable q = new GdtAdWSCountDownLayout.1(this);
  
  public GdtAdWSCountDownLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GdtAdWSCountDownLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2131624932, this);
    this.o = Color.parseColor("#CCFFFFFF");
    this.n = Color.parseColor("#FFFFFF");
    this.d = ((TextView)findViewById(2131434112));
    this.e = ((TextView)findViewById(2131434105));
    this.i = ((TextView)findViewById(2131434106));
    this.f = ((TextView)findViewById(2131434107));
    this.j = ((TextView)findViewById(2131434108));
    this.g = ((TextView)findViewById(2131434110));
    this.k = ((TextView)findViewById(2131434111));
    this.h = ((TextView)findViewById(2131434113));
    d();
  }
  
  private String a(long paramLong)
  {
    if (paramLong <= 9L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(Long.toString(paramLong));
      return localStringBuilder.toString();
    }
    return Long.toString(paramLong);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 8640000);
  }
  
  private void d()
  {
    setTimeTextColor(this.n);
    setRemainderTextColor(this.o);
  }
  
  private void e()
  {
    if (this.m < 0)
    {
      setVisibility(8);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((LinearLayout)findViewById(2131434109)).getLayoutParams();
    if (this.m < 86400)
    {
      localLayoutParams.width = a(99.0F);
      this.e.setVisibility(8);
      this.i.setVisibility(8);
    }
    else
    {
      localLayoutParams.width = a(128.5F);
      this.e.setVisibility(0);
      this.i.setVisibility(0);
    }
    setVisibility(0);
  }
  
  private void f()
  {
    this.l.removeCallbacks(this.q);
    if (this.m < 0)
    {
      this.c = false;
      return;
    }
    this.c = true;
    this.l.postDelayed(this.q, 1000L);
  }
  
  private void setRemainderTextColor(int paramInt)
  {
    this.d.setTextColor(paramInt);
  }
  
  private void setTimeTextColor(int paramInt)
  {
    this.e.setTextColor(paramInt);
    this.i.setTextColor(paramInt);
    this.f.setTextColor(paramInt);
    this.j.setTextColor(paramInt);
    this.g.setTextColor(paramInt);
    this.k.setTextColor(paramInt);
    this.h.setTextColor(paramInt);
  }
  
  public int a(float paramFloat)
  {
    return (int)(paramFloat * getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public void a()
  {
    int i1 = this.m;
    int i2 = i1 / 86400;
    int i3 = i1 / 3600;
    int i4 = i1 / 60;
    long l1 = i1 % 60;
    String str1 = a(i2);
    String str2 = a(i3 % 24);
    String str3 = a(i4 % 60);
    String str4 = a(l1);
    this.e.setText(str1);
    this.f.setText(str2);
    this.g.setText(str3);
    this.h.setText(str4);
  }
  
  public boolean a(int paramInt)
  {
    if (b(paramInt))
    {
      this.m = paramInt;
      f();
      a();
      e();
      return true;
    }
    setVisibility(8);
    return false;
  }
  
  public void b()
  {
    this.l.removeCallbacks(this.q);
    QLog.i("GdtAdWSCountDownLayout", 4, "countdown layout is recycled");
  }
  
  public void c()
  {
    QLog.i("GdtAdWSCountDownLayout", 4, "countdown layout is stopped");
    this.c = false;
    this.l.removeCallbacks(this.q);
    setVisibility(8);
  }
  
  public void setTextViewTextSize(int paramInt1, int paramInt2)
  {
    TextView localTextView = this.e;
    float f1 = paramInt2;
    localTextView.setTextSize(paramInt1, f1);
    this.i.setTextSize(paramInt1, f1);
    this.f.setTextSize(paramInt1, f1);
    this.j.setTextSize(paramInt1, f1);
    this.g.setTextSize(paramInt1, f1);
    this.k.setTextSize(paramInt1, f1);
    this.h.setTextSize(paramInt1, f1);
    this.d.setTextSize(paramInt1, f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSCountDownLayout
 * JD-Core Version:    0.7.0.1
 */