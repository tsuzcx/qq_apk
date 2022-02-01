package com.tencent.biz.subscribe.widget;

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
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;

public class StatusView
  extends BaseWidgetView
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = getResources().getString(2131701692);
  private int jdField_c_of_type_Int = 18;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int = -16777216;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
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
  
  protected int a()
  {
    return 2131558740;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    a(true);
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376732);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369348));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369412));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379657));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379800));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379916));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379822));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370289));
    paramContext = new StringBuilder();
    paramContext.append(SubscribeUtils.a());
    paramContext.append("/certified_account_feed_error.png");
    setHintImageFilePath(paramContext.toString());
    setBackgroundColor(-1);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(SubscribeUtils.a());
    ((StringBuilder)localObject).append("/certified_account_feeds_empty.png");
    setHintImageFilePath(((StringBuilder)localObject).toString());
    a(HardCodeUtil.a(2131719372), 13, getResources().getColor(2131167250));
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(SubscribeUtils.a());
    ((StringBuilder)localObject).append("/certified_account_feeds_empty.png");
    setHintImageFilePath(((StringBuilder)localObject).toString());
    a(HardCodeUtil.a(2131719375), 13, getResources().getColor(2131167250));
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null)
    {
      ((LinearLayout)localObject).setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener1);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener2);
    }
  }
  
  protected void a(Object paramObject) {}
  
  public void a(String paramString)
  {
    a(paramString, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    setTextHint(paramString, paramInt1, paramInt2);
    a();
  }
  
  public void b(String paramString)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(0);
      if (!paramString.equals(this.jdField_a_of_type_JavaLangString)) {
        try
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130851328);
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130851328);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
          this.jdField_a_of_type_JavaLangString = paramString;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      a(true);
    }
  }
  
  public void c()
  {
    a(false);
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    a(false);
  }
  
  public void setHintImageFilePath(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130851328);
        localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130851328);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getFileDrawable(paramString, localURLDrawableOptions));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setTextHint(String paramString)
  {
    setTextHint(paramString, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  public void setTextHint(String paramString, float paramFloat, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.jdField_b_of_type_JavaLangString;
    }
    paramString = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramString != null)
    {
      paramString.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramFloat);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.StatusView
 * JD-Core Version:    0.7.0.1
 */