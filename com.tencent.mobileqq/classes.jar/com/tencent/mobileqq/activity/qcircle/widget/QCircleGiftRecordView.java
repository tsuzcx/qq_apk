package com.tencent.mobileqq.activity.qcircle.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QCircleGiftRecordView
  extends LinearLayout
{
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString;
  
  public QCircleGiftRecordView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleGiftRecordView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleGiftRecordView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131560839, this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367057));
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(-986894);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(ImmersiveUtils.dpToPx(9.0F));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369670));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380386));
  }
  
  public void setGiftCount(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = ("x" + paramInt);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_a_of_type_AndroidWidgetTextView, paramBoolean);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void setIconUrl(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramString);
    }
  }
  
  public void setUIStyle(String paramString1, String paramString2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramString1));
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor(paramString2));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleGiftRecordView", 1, new Object[] { "setUIStyle numColor:", paramString1, ",backColor:", paramString2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleGiftRecordView
 * JD-Core Version:    0.7.0.1
 */