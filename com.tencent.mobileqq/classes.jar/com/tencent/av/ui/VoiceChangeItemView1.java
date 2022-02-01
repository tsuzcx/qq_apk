package com.tencent.av.ui;

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
import anvx;
import bgxc;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mmn;
import mmp;
import mux;

public class VoiceChangeItemView1
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView = null;
  mmn jdField_a_of_type_Mmn = null;
  mmp jdField_a_of_type_Mmp;
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
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559838, this);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131381279));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381284));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381283));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getLayoutParams();
    int i = AIOUtils.dp2px(65.0F, getResources());
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setLayoutParams(localLayoutParams);
    setOnClickListener(this);
  }
  
  public void a(int paramInt1, mmn parammmn, boolean paramBoolean, int paramInt2, mmp parammmp)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Mmp = parammmp;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Mmn = parammmn;
    if (parammmn.jdField_a_of_type_Int == 0)
    {
      parammmp = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getResources();
      if (this.jdField_b_of_type_Int == -16777216)
      {
        parammmp = mux.a(parammmp, 2130842225, 2131165991);
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammmp);
        label67:
        switch (parammmn.jdField_b_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(parammmn.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
      setHighlight(paramBoolean);
      setContentDescription(parammmn.jdField_a_of_type_JavaLangString + anvx.a(2131716205));
      return;
      parammmp = mux.a(parammmp, 2130842225, 2131166028);
      break;
      if (TextUtils.isEmpty(parammmn.jdField_b_of_type_JavaLangString)) {
        break label67;
      }
      parammmp = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = AIOUtils.dp2px(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165881));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt1, paramInt1);
      parammmp.mRequestWidth = paramInt1;
      parammmp.mRequestHeight = paramInt1;
      parammmp.mFailedDrawable = localGradientDrawable;
      parammmp.mLoadingDrawable = localGradientDrawable;
      parammmp = URLDrawable.getDrawable(parammmn.jdField_b_of_type_JavaLangString, parammmp);
      parammmp.setTag(bgxc.a(paramInt1, paramInt1));
      parammmp.setDecodeHandler(bgxc.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammmp);
      break label67;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842341);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842341);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842341);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Mmp != null) {
      this.jdField_a_of_type_Mmp.a(this, this.jdField_a_of_type_Int);
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
    if ((this.jdField_a_of_type_Mmn != null) && (this.jdField_a_of_type_Mmn.jdField_a_of_type_Int == 0))
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