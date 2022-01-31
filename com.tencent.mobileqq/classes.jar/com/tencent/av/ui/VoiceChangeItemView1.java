package com.tencent.av.ui;

import actn;
import ajyc;
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
import bavi;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import mlq;
import mls;
import mts;

public class VoiceChangeItemView1
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView = null;
  mlq jdField_a_of_type_Mlq = null;
  mls jdField_a_of_type_Mls;
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
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559604, this);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131379303));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379308));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379307));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getLayoutParams();
    int i = actn.a(65.0F, getResources());
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setLayoutParams(localLayoutParams);
    setOnClickListener(this);
  }
  
  public void a(int paramInt1, mlq parammlq, boolean paramBoolean, int paramInt2, mls parammls)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Mls = parammls;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Mlq = parammlq;
    if (parammlq.jdField_a_of_type_Int == 0)
    {
      parammls = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getResources();
      if (this.jdField_b_of_type_Int == -16777216)
      {
        parammls = mts.a(parammls, 2130841686, 2131165869);
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammls);
        label67:
        switch (parammlq.jdField_b_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(parammlq.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
      setHighlight(paramBoolean);
      setContentDescription(parammlq.jdField_a_of_type_JavaLangString + ajyc.a(2131716842));
      return;
      parammls = mts.a(parammls, 2130841686, 2131165906);
      break;
      if (TextUtils.isEmpty(parammlq.jdField_b_of_type_JavaLangString)) {
        break label67;
      }
      parammls = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = actn.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165766));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt1, paramInt1);
      parammls.mRequestWidth = paramInt1;
      parammls.mRequestHeight = paramInt1;
      parammls.mFailedDrawable = localGradientDrawable;
      parammls.mLoadingDrawable = localGradientDrawable;
      parammls = URLDrawable.getDrawable(parammlq.jdField_b_of_type_JavaLangString, parammls);
      parammls.setTag(bavi.a(paramInt1, paramInt1));
      parammls.setDecodeHandler(bavi.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammls);
      break label67;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841799);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841799);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841799);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Mls != null) {
      this.jdField_a_of_type_Mls.a(this, this.jdField_a_of_type_Int);
    }
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
    if ((this.jdField_a_of_type_Mlq != null) && (this.jdField_a_of_type_Mlq.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setSelected(paramBoolean);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = -15550475;; i = this.jdField_b_of_type_Int)
    {
      localTextView.setTextColor(i);
      return;
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setHighlight(paramBoolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView1
 * JD-Core Version:    0.7.0.1
 */