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
import bavi;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.CircleProgress;
import mhu;
import mhw;

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
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559580, this);
    int k = getResources().getColor(2131166854);
    int j;
    if (!this.jdField_a_of_type_Boolean) {
      j = getResources().getColor(2131165297);
    }
    for (int i = 2130845163;; i = 2130845164)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131372413));
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131372250));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372246));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131372253));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372252));
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
      j = getResources().getColor(2131165949);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, mhw parammhw, mhu parammhu)
  {
    if (parammhw == null) {}
    do
    {
      return;
      super.a(paramInt, parammhu);
      setId(paramInt);
      setTag(parammhw);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setTag(parammhw);
      if (!TextUtils.isEmpty(parammhw.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    return;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if ("0".equals(parammhw.jdField_a_of_type_JavaLangString)) {
      if (TextUtils.isEmpty(parammhw.b)) {
        break label405;
      }
    }
    label385:
    label395:
    label405:
    for (paramInt = Integer.valueOf(parammhw.b).intValue();; paramInt = 0)
    {
      if (paramInt > 0)
      {
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageResource(paramInt);
        if ((!parammhw.jdField_a_of_type_Boolean) && (!parammhw.jdField_a_of_type_JavaLangString.equals("0"))) {
          break label374;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        label160:
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
        setDimmed(parammhw.jdField_c_of_type_Boolean);
        setHighlight(paramBoolean1);
        if (!parammhw.d) {
          break label395;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        parammhu = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(parammhw.jdField_c_of_type_JavaLangString)) {
          break label385;
        }
      }
      for (parammhw = " ";; parammhw = parammhw.jdField_c_of_type_JavaLangString)
      {
        parammhu.setText(parammhw);
        return;
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageResource(2130849549);
        break;
        if (TextUtils.isEmpty(parammhw.b)) {
          break;
        }
        parammhu = URLDrawable.URLDrawableOptions.obtain();
        paramInt = getResources().getDimensionPixelSize(2131297544);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(getResources().getColor(2131165766));
        localGradientDrawable.setShape(1);
        localGradientDrawable.setSize(paramInt, paramInt);
        parammhu.mRequestWidth = paramInt;
        parammhu.mRequestHeight = paramInt;
        parammhu.mFailedDrawable = localGradientDrawable;
        parammhu.mLoadingDrawable = localGradientDrawable;
        parammhu = URLDrawable.getDrawable(parammhw.b, parammhu);
        parammhu.setTag(bavi.a(paramInt, paramInt));
        if (paramBoolean2) {
          parammhu.setDecodeHandler(bavi.a);
        }
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammhu);
        break;
        label374:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break label160;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  public void a(mhw parammhw, int paramInt)
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
      if ((parammhw == null) || (!"0".equals(parammhw.jdField_a_of_type_JavaLangString))) {
        break label125;
      }
      setBackgroundColor(-16711681);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.argb(155, 224, 176, 216));
      break;
      label106:
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setBackgroundColor(getResources().getColor(2131165949));
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
    View localView = findViewById(2131372414);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.QavPtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */