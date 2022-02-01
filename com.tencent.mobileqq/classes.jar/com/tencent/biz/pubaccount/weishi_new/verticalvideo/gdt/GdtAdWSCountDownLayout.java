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
  public final float a;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtAdWSCountDownLayout.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  public final float b;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private final int jdField_d_of_type_Int = 1;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  public GdtAdWSCountDownLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GdtAdWSCountDownLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 128.5F;
    this.jdField_b_of_type_Float = 99.0F;
    LayoutInflater.from(paramContext).inflate(2131559177, this);
    this.jdField_c_of_type_Int = Color.parseColor("#CCFFFFFF");
    this.jdField_b_of_type_Int = Color.parseColor("#FFFFFF");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367570));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367563));
    this.f = ((TextView)findViewById(2131367564));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367565));
    this.g = ((TextView)findViewById(2131367566));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367568));
    this.h = ((TextView)findViewById(2131367569));
    this.e = ((TextView)findViewById(2131367571));
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
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.f.setTextColor(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.g.setTextColor(paramInt);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.h.setTextColor(paramInt);
    this.e.setTextColor(paramInt);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 8640000);
  }
  
  private void d()
  {
    b(this.jdField_b_of_type_Int);
    a(this.jdField_c_of_type_Int);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int < 0)
    {
      setVisibility(8);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((LinearLayout)findViewById(2131367567)).getLayoutParams();
    if (this.jdField_a_of_type_Int < 86400)
    {
      localLayoutParams.width = a(99.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.f.setVisibility(8);
    }
    else
    {
      localLayoutParams.width = a(128.5F);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.f.setVisibility(0);
    }
    setVisibility(0);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Int < 0)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  public int a(float paramFloat)
  {
    return (int)(paramFloat * getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_Int;
    int j = i / 86400;
    int k = i / 3600;
    int m = i / 60;
    long l = i % 60;
    String str1 = a(j);
    String str2 = a(k % 24);
    String str3 = a(m % 60);
    String str4 = a(l);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str3);
    this.e.setText(str4);
  }
  
  public boolean a(int paramInt)
  {
    if (b(paramInt))
    {
      this.jdField_a_of_type_Int = paramInt;
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    QLog.i("GdtAdWSCountDownLayout", 4, "countdown layout is recycled");
  }
  
  public void c()
  {
    QLog.i("GdtAdWSCountDownLayout", 4, "countdown layout is stopped");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    setVisibility(8);
  }
  
  public void setTextViewTextSize(int paramInt1, int paramInt2)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    float f1 = paramInt2;
    localTextView.setTextSize(paramInt1, f1);
    this.f.setTextSize(paramInt1, f1);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(paramInt1, f1);
    this.g.setTextSize(paramInt1, f1);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(paramInt1, f1);
    this.h.setTextSize(paramInt1, f1);
    this.e.setTextSize(paramInt1, f1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramInt1, f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSCountDownLayout
 * JD-Core Version:    0.7.0.1
 */