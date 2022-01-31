package com.tencent.av.ui;

import aepi;
import alud;
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
import bcyz;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import moh;
import moj;
import mwj;

public class VoiceChangeItemView1
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView = null;
  moh jdField_a_of_type_Moh = null;
  moj jdField_a_of_type_Moj;
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
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559656, this);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131380067));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380072));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380071));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getLayoutParams();
    int i = aepi.a(65.0F, getResources());
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setLayoutParams(localLayoutParams);
    setOnClickListener(this);
  }
  
  public void a(int paramInt1, moh parammoh, boolean paramBoolean, int paramInt2, moj parammoj)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Moj = parammoj;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Moh = parammoh;
    if (parammoh.jdField_a_of_type_Int == 0)
    {
      parammoj = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getResources();
      if (this.jdField_b_of_type_Int == -16777216)
      {
        parammoj = mwj.a(parammoj, 2130841850, 2131165908);
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammoj);
        label67:
        switch (parammoh.jdField_b_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(parammoh.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
      setHighlight(paramBoolean);
      setContentDescription(parammoh.jdField_a_of_type_JavaLangString + alud.a(2131717237));
      return;
      parammoj = mwj.a(parammoj, 2130841850, 2131165945);
      break;
      if (TextUtils.isEmpty(parammoh.jdField_b_of_type_JavaLangString)) {
        break label67;
      }
      parammoj = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = aepi.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165804));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt1, paramInt1);
      parammoj.mRequestWidth = paramInt1;
      parammoj.mRequestHeight = paramInt1;
      parammoj.mFailedDrawable = localGradientDrawable;
      parammoj.mLoadingDrawable = localGradientDrawable;
      parammoj = URLDrawable.getDrawable(parammoh.jdField_b_of_type_JavaLangString, parammoj);
      parammoj.setTag(bcyz.a(paramInt1, paramInt1));
      parammoj.setDecodeHandler(bcyz.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammoj);
      break label67;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841965);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841965);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841965);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Moj != null) {
      this.jdField_a_of_type_Moj.a(this, this.jdField_a_of_type_Int);
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
    if ((this.jdField_a_of_type_Moh != null) && (this.jdField_a_of_type_Moh.jdField_a_of_type_Int == 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView1
 * JD-Core Version:    0.7.0.1
 */