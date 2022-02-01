package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.widget.CircleProgress;

public class QavPtvTemplateItemView
  extends QavListItemBase
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  public boolean a;
  
  public QavPtvTemplateItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 100)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (paramInt < 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559761, this);
    int k = getResources().getColor(2131167056);
    int i;
    int j;
    if (!this.jdField_a_of_type_Boolean)
    {
      i = getResources().getColor(2131165349);
      j = 2130846196;
    }
    else
    {
      i = getResources().getColor(2131166088);
      j = 2130846197;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373552));
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131373387));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373383));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131373390));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373389));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
    b(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(1.6F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, k, 100, i);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() instanceof LinearLayout)) {
        ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent()).setGravity(83);
      }
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setDimmedColor(-47980);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IClickCallback paramIClickCallback)
  {
    if (paramItemInfo == null) {
      return;
    }
    super.a(paramInt, paramIClickCallback);
    setId(paramInt);
    setTag(paramItemInfo);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setTag(paramItemInfo);
    if (TextUtils.isEmpty(paramItemInfo.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 4) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if ("0".equals(paramItemInfo.jdField_a_of_type_JavaLangString))
    {
      if (!TextUtils.isEmpty(paramItemInfo.b)) {
        paramInt = Integer.valueOf(paramItemInfo.b).intValue();
      } else {
        paramInt = 0;
      }
      if (paramInt > 0) {
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageResource(paramInt);
      } else {
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageResource(2130851078);
      }
    }
    else if (!TextUtils.isEmpty(paramItemInfo.b))
    {
      paramIClickCallback = URLDrawable.URLDrawableOptions.obtain();
      paramInt = getResources().getDimensionPixelSize(2131297770);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165886));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      paramIClickCallback.mRequestWidth = paramInt;
      paramIClickCallback.mRequestHeight = paramInt;
      paramIClickCallback.mFailedDrawable = localGradientDrawable;
      paramIClickCallback.mLoadingDrawable = localGradientDrawable;
      paramIClickCallback = URLDrawable.getDrawable(paramItemInfo.b, paramIClickCallback);
      paramIClickCallback.setTag(URLDrawableDecodeHandler.a(paramInt, paramInt));
      if (paramBoolean2) {
        paramIClickCallback.setDecodeHandler(URLDrawableDecodeHandler.a);
      }
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(paramIClickCallback);
    }
    if ((!paramItemInfo.jdField_a_of_type_Boolean) && (!paramItemInfo.jdField_a_of_type_JavaLangString.equals("0"))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
    setDimmed(paramItemInfo.jdField_c_of_type_Boolean);
    setHighlight(paramBoolean1);
    if (paramItemInfo.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramIClickCallback = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(paramItemInfo.jdField_c_of_type_JavaLangString)) {
        paramItemInfo = " ";
      } else {
        paramItemInfo = paramItemInfo.jdField_c_of_type_JavaLangString;
      }
      paramIClickCallback.setText(paramItemInfo);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    paramInt %= 2;
    if (paramInt == 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.argb(255, 224, 176, 216));
    } else {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.argb(155, 224, 176, 216));
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setBackgroundColor(Color.argb(255, 168, 168, 236));
    } else {
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setBackgroundColor(getResources().getColor(2131166088));
    }
    if ((paramItemInfo != null) && ("0".equals(paramItemInfo.jdField_a_of_type_JavaLangString)))
    {
      setBackgroundColor(-16711681);
      return;
    }
    if (paramInt == 0)
    {
      setBackgroundColor(-7829368);
      return;
    }
    setBackgroundColor(-3355444);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    View localView = findViewById(2131373553);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localView.setLayoutParams(localLayoutParams);
  }
  
  public void setDimmed(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setDimmed(paramBoolean);
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setHighlight(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */