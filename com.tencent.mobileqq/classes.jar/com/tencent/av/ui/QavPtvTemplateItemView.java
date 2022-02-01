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
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559890, this);
    int k = getResources().getColor(2131167033);
    int j;
    if (!this.jdField_a_of_type_Boolean) {
      j = getResources().getColor(2131165381);
    }
    for (int i = 2130846323;; i = 2130846324)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373980));
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131373815));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373811));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131373818));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373817));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      b(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(1.6F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, k, 100, j);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setOnClickListener(this);
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() instanceof LinearLayout)) {
          ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent()).setGravity(83);
        }
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setDimmedColor(-47980);
      }
      return;
      j = getResources().getColor(2131166077);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IClickCallback paramIClickCallback)
  {
    if (paramItemInfo == null) {}
    do
    {
      return;
      super.a(paramInt, paramIClickCallback);
      setId(paramInt);
      setTag(paramItemInfo);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setTag(paramItemInfo);
      if (!TextUtils.isEmpty(paramItemInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    return;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if ("0".equals(paramItemInfo.jdField_a_of_type_JavaLangString)) {
      if (TextUtils.isEmpty(paramItemInfo.b)) {
        break label405;
      }
    }
    label385:
    label395:
    label405:
    for (paramInt = Integer.valueOf(paramItemInfo.b).intValue();; paramInt = 0)
    {
      if (paramInt > 0)
      {
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageResource(paramInt);
        if ((!paramItemInfo.jdField_a_of_type_Boolean) && (!paramItemInfo.jdField_a_of_type_JavaLangString.equals("0"))) {
          break label374;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        label160:
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
        setDimmed(paramItemInfo.jdField_c_of_type_Boolean);
        setHighlight(paramBoolean1);
        if (!paramItemInfo.d) {
          break label395;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramIClickCallback = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(paramItemInfo.jdField_c_of_type_JavaLangString)) {
          break label385;
        }
      }
      for (paramItemInfo = " ";; paramItemInfo = paramItemInfo.jdField_c_of_type_JavaLangString)
      {
        paramIClickCallback.setText(paramItemInfo);
        return;
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageResource(2130851162);
        break;
        if (TextUtils.isEmpty(paramItemInfo.b)) {
          break;
        }
        paramIClickCallback = URLDrawable.URLDrawableOptions.obtain();
        paramInt = getResources().getDimensionPixelSize(2131297779);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(getResources().getColor(2131165883));
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
        break;
        label374:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break label160;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    if (paramInt % 2 == 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.argb(255, 224, 176, 216));
      if (this.jdField_a_of_type_Boolean) {
        break label106;
      }
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setBackgroundColor(Color.argb(255, 168, 168, 236));
    }
    for (;;)
    {
      if ((paramItemInfo == null) || (!"0".equals(paramItemInfo.jdField_a_of_type_JavaLangString))) {
        break label125;
      }
      setBackgroundColor(-16711681);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.argb(155, 224, 176, 216));
      break;
      label106:
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setBackgroundColor(getResources().getColor(2131166077));
    }
    label125:
    if (paramInt % 2 == 0)
    {
      setBackgroundColor(-7829368);
      return;
    }
    setBackgroundColor(-3355444);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    View localView = findViewById(2131373981);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavPtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */