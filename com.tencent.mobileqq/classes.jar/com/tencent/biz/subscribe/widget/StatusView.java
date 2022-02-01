package com.tencent.biz.subscribe.widget;

import aaek;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anzj;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class StatusView
  extends BaseWidgetView
{
  private int jdField_a_of_type_Int = 18;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = -16777216;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = getResources().getString(2131700391);
  private TextView c;
  private TextView d;
  
  public StatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (getVisibility() == 0)) {
      setVisibility(8);
    }
    if ((paramBoolean) && (getVisibility() == 8)) {
      setVisibility(0);
    }
  }
  
  public int a()
  {
    return 2131558769;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376841);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369204));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369271));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379816));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379982));
    this.c = ((TextView)paramView.findViewById(2131380115));
    this.d = ((TextView)paramView.findViewById(2131380006));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370219));
    setHintImageFilePath(aaek.a() + "/certified_account_feed_error.png");
    setBackgroundColor(-1);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    setHintImageFilePath(aaek.a() + "/certified_account_feeds_empty.png");
    a(anzj.a(2131718476), 13, getResources().getColor(2131167175));
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    setHintImageFilePath(aaek.a() + "/certified_account_feeds_empty.png");
    a(anzj.a(2131718479), 13, getResources().getColor(2131167175));
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.c.setOnClickListener(paramOnClickListener1);
      this.d.setOnClickListener(paramOnClickListener2);
    }
  }
  
  public void a(Object paramObject) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    setTextHint(paramString, paramInt1, paramInt2);
    c();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    a(true);
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    a(false);
  }
  
  public void d(String paramString)
  {
    a(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void e(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130850895);
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130850895);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getFileDrawable(paramString, localURLDrawableOptions));
      this.jdField_a_of_type_JavaLangString = paramString;
      a(true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setHintImageFilePath(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130850895);
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130850895);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getFileDrawable(paramString, localURLDrawableOptions));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setTextHint(String paramString)
  {
    setTextHint(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void setTextHint(String paramString, float paramFloat, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.jdField_b_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramFloat);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.StatusView
 * JD-Core Version:    0.7.0.1
 */