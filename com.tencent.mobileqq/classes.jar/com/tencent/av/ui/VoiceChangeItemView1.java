package com.tencent.av.ui;

import agej;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import bhez;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mmh;
import mmj;
import muq;

public class VoiceChangeItemView1
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView = null;
  mmh jdField_a_of_type_Mmh = null;
  mmj jdField_a_of_type_Mmj;
  int b;
  
  public VoiceChangeItemView1(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public void a()
  {
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559799, this);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131381208));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381213));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381212));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getLayoutParams();
    int i = agej.a(65.0F, getResources());
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setLayoutParams(localLayoutParams);
    setOnClickListener(this);
  }
  
  public void a(int paramInt1, mmh parammmh, boolean paramBoolean, int paramInt2, mmj parammmj)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Mmj = parammmj;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Mmh = parammmh;
    if (parammmh.jdField_a_of_type_Int == 0)
    {
      parammmj = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getResources();
      if (this.jdField_b_of_type_Int == -16777216)
      {
        parammmj = muq.a(parammmj, 2130842169, 2131165964);
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammmj);
        label67:
        switch (parammmh.jdField_b_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(parammmh.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
      setHighlight(paramBoolean);
      setContentDescription(parammmh.jdField_a_of_type_JavaLangString + anzj.a(2131715623));
      return;
      parammmj = muq.a(parammmj, 2130842169, 2131166001);
      break;
      if (TextUtils.isEmpty(parammmh.jdField_b_of_type_JavaLangString)) {
        break label67;
      }
      parammmj = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = agej.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165854));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt1, paramInt1);
      parammmj.mRequestWidth = paramInt1;
      parammmj.mRequestHeight = paramInt1;
      parammmj.mFailedDrawable = localGradientDrawable;
      parammmj.mLoadingDrawable = localGradientDrawable;
      parammmj = URLDrawable.getDrawable(parammmh.jdField_b_of_type_JavaLangString, parammmj);
      parammmj.setTag(bhez.a(paramInt1, paramInt1));
      parammmj.setDecodeHandler(bhez.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammmj);
      break label67;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842285);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842285);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842285);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Mmj != null) {
      this.jdField_a_of_type_Mmj.a(this, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.dispatchTouchEvent(paramMotionEvent);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    TextView localTextView;
    if ((this.jdField_a_of_type_Mmh != null) && (this.jdField_a_of_type_Mmh.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setSelected(paramBoolean);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (int i = -15550475;; i = this.jdField_b_of_type_Int)
    {
      localTextView.setTextColor(i);
      return;
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setHighlight(paramBoolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView1
 * JD-Core Version:    0.7.0.1
 */