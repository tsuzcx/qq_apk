package com.tencent.mobileqq.activity.contacts.pullrefresh;

import aayo;
import ajwc;
import ajwe;
import ajwf;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bhsw;

public class ContactRefreshHeader
  extends RelativeLayout
  implements aayo, ajwe, ajwf
{
  private int jdField_a_of_type_Int = 0;
  public long a;
  private ajwc jdField_a_of_type_Ajwc;
  private Context jdField_a_of_type_AndroidContentContext;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = 0;
  private int h;
  
  public ContactRefreshHeader(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContactRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContactRefreshHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    this.h = getResources().getDimensionPixelOffset(2131298761);
  }
  
  @TargetApi(17)
  public static void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutParams.removeRule(paramInt);
      return;
    }
    paramLayoutParams.addRule(12, 0);
  }
  
  private long b()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Ajwc != null) {
      l = this.jdField_a_of_type_Ajwc.a();
    }
    return l;
  }
  
  private void b(int paramInt)
  {
    if (paramInt >= 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    }
  }
  
  private void d(long paramLong)
  {
    if (paramLong != 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%s%s", new Object[] { this.jdField_a_of_type_AndroidContentContext.getString(2131718363), bhsw.a(paramLong, true, "yyyy-MM-dd") }));
      if (this.f >= 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.f);
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (this.jdField_a_of_type_Int == 0)
    {
      a(localLayoutParams, 10);
      localLayoutParams.addRule(12);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      return;
      a(localLayoutParams, 12);
      localLayoutParams.addRule(10);
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a()
  {
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    Drawable localDrawable = null;
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      Object localObject = str;
      if (localDrawable != null)
      {
        paramInt = (int)this.jdField_a_of_type_AndroidWidgetTextView.getTextSize() + 2;
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        localObject = new SpannableString("[O]" + " " + str);
        ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, "[O]".length(), 17);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      b(this.e);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      localDrawable = getResources().getDrawable(2130849571);
      str = getResources().getString(2131718368);
      continue;
      localDrawable = getResources().getDrawable(2130849569);
      str = getResources().getString(2131718362);
      continue;
      localDrawable = getResources().getDrawable(2130849570);
      str = getResources().getString(2131718362);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    Drawable localDrawable = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Object localObject = paramString;
      if (localDrawable != null)
      {
        paramInt = (int)this.jdField_a_of_type_AndroidWidgetTextView.getTextSize() + 2;
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        localObject = new SpannableString("[O]" + " " + paramString);
        ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, "[O]".length(), 17);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      b(this.e);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      localDrawable = getResources().getDrawable(2130849571);
      continue;
      localDrawable = getResources().getDrawable(2130849569);
      continue;
      localDrawable = getResources().getDrawable(2130849570);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!this.jdField_b_of_type_Boolean))
    {
      if (paramInt <= this.h) {
        break label40;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        b(b());
      }
    }
    label40:
    while ((paramInt >= this.h) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    c(b());
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718364);
      b(this.d);
      label18:
      d(paramLong);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  public void aq_()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      a(0L);
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718367);
    b(this.c);
    d(paramLong);
  }
  
  public void c() {}
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.g == 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849567);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718365);
        b(this.jdField_b_of_type_Int);
        d(paramLong);
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839436);
      }
    }
    if (this.g == 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849568);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718366);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839437);
    }
  }
  
  public void d()
  {
    if (!this.jdField_b_of_type_Boolean) {
      e();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718365);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365046));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131376445));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376442));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376444));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376450));
    if (this.jdField_a_of_type_Int != 0) {
      f();
    }
    if (this.g != 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839438);
    }
    c(0L);
  }
  
  public void setHeaderBgColor(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  @TargetApi(16)
  public void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      setBackground(paramDrawable);
      return;
    }
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setHeaderBgRes(int paramInt)
  {
    setBackgroundResource(paramInt);
  }
  
  public void setPullType(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      f();
    }
  }
  
  public void setRefresh(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setRefreshHeaderUpdateListener(ajwc paramajwc)
  {
    this.jdField_a_of_type_Ajwc = paramajwc;
  }
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader
 * JD-Core Version:    0.7.0.1
 */