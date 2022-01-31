package com.tencent.biz.subscribe.widget;

import alpo;
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
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import xxl;

public class StatusView
  extends BaseWidgetView
{
  private int jdField_a_of_type_Int = 18;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = getResources().getString(2131701852);
  private int jdField_c_of_type_Int = -16777216;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
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
    return 2131558705;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375908);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368757));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368815));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378719));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378858));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378965));
    this.d = ((TextView)paramView.findViewById(2131378876));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369678));
    setHintImageFilePath(xxl.a() + "/certified_account_feed_error.png");
    setBackgroundColor(-1);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    setHintImageFilePath(xxl.a() + "/certified_account_feeds_empty.png");
    a(alpo.a(2131720483), 13, getResources().getColor(2131167077));
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    setHintImageFilePath(xxl.a() + "/certified_account_feeds_empty.png");
    a(alpo.a(2131720486), 13, getResources().getColor(2131167077));
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener1);
      this.d.setOnClickListener(paramOnClickListener2);
    }
  }
  
  public void a(Object paramObject) {}
  
  public void a(String paramString)
  {
    a(paramString, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    setTextHint(paramString, paramInt1, paramInt2);
    b();
  }
  
  public ImageView b()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    a(true);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130850187);
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130850187);
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
  
  public void c()
  {
    a(false);
  }
  
  public void d()
  {
    setHintImageFilePath(xxl.a() + "/certified_account_feed_error.png");
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      if (i == 0) {
        break label57;
      }
    }
    label57:
    for (int i = 2131694764;; i = 2131720466)
    {
      a(alpo.a(i));
      return;
      i = 0;
      break;
    }
  }
  
  public void e()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    a(false);
  }
  
  public void setHintImageFilePath(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130850187);
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130850187);
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
    setTextHint(paramString, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.StatusView
 * JD-Core Version:    0.7.0.1
 */