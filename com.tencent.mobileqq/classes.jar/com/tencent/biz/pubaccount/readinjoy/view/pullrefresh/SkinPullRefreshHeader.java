package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import xea;

public class SkinPullRefreshHeader
  extends RelativeLayout
  implements xea
{
  int jdField_a_of_type_Int = Color.parseColor("#f7f7f7");
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { Color.parseColor("#59000000"), 0 });
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  
  public SkinPullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setBackgroundColor(this.jdField_a_of_type_Int);
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
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (this.jdField_b_of_type_Int == 0)
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
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
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
      return;
      localDrawable = getResources().getDrawable(2130848527);
      continue;
      localDrawable = getResources().getDrawable(2130848525);
      continue;
      localDrawable = getResources().getDrawable(2130848526);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      setBackgroundColor(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (!paramBoolean) {
          break label51;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
      }
    }
    return;
    label51:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void ao_()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719804);
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  protected void onAttachedToWindow() {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364691));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131375056));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375057));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375055));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375052);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375058);
    c(0L);
  }
  
  public void setAdTabVisibility(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
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
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      b();
    }
  }
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.SkinPullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */