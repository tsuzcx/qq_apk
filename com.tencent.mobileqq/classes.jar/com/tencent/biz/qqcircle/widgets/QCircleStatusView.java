package com.tencent.biz.qqcircle.widgets;

import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import tqb;

public class QCircleStatusView
  extends BaseWidgetView
{
  private int jdField_a_of_type_Int = 16;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString = getResources().getString(2131701852);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c = Color.parseColor("#03081A");
  
  public QCircleStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
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
  
  private void e()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
      localMarginLayoutParams.topMargin = (-ImmersiveUtils.a(30.0F));
      setLayoutParams(localMarginLayoutParams);
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackground(null);
    }
  }
  
  public int a()
  {
    return 2131560533;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131375908));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368757));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368815));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378719));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378648));
    setHintImageFilePath(tqb.g + "qcircle_feed_error.png");
  }
  
  public void a(Object paramObject) {}
  
  public void a(String paramString)
  {
    a(paramString, this.jdField_a_of_type_Int, this.c);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    setTextHint(paramString, paramInt1, paramInt2);
    b();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    a(true);
  }
  
  public void b(String paramString)
  {
    setHintImageFilePath(tqb.g + "qcircle_feed_empty.png");
    a(paramString);
  }
  
  public void c()
  {
    a(false);
  }
  
  public void c(String paramString)
  {
    setHintImageFilePath(tqb.g + "qcircle_feed_error.png");
    String str;
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        if (i == 0) {
          break label68;
        }
      }
    }
    label68:
    for (int i = 2131694764;; i = 2131720466)
    {
      str = alpo.a(i);
      a(str);
      return;
      i = 0;
      break;
    }
  }
  
  public void d()
  {
    setHintImageFilePath(tqb.g + "qcircle_feed_empty.png");
    a(alpo.a(2131698290));
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    e();
  }
  
  public void d(String paramString)
  {
    setHintImageFilePath(tqb.g + "qcircle_feed_error.png");
    String str;
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        if (i == 0) {
          break label88;
        }
      }
    }
    label88:
    for (int i = 2131694764;; i = 2131720466)
    {
      str = alpo.a(i);
      a(str);
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      e();
      return;
      i = 0;
      break;
    }
  }
  
  public void setHintImageFilePath(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(getResources().getColor(2131166178));
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getFileDrawable(paramString, localURLDrawableOptions));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setTextHint(String paramString, float paramFloat, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramFloat);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleStatusView
 * JD-Core Version:    0.7.0.1
 */