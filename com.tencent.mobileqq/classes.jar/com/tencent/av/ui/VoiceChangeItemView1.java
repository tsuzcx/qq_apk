package com.tencent.av.ui;

import actj;
import ajya;
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
import bavw;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import mln;
import mlp;
import mtp;

public class VoiceChangeItemView1
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView = null;
  mln jdField_a_of_type_Mln = null;
  mlp jdField_a_of_type_Mlp;
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
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131379308));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379313));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379312));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getLayoutParams();
    int i = actj.a(65.0F, getResources());
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setLayoutParams(localLayoutParams);
    setOnClickListener(this);
  }
  
  public void a(int paramInt1, mln parammln, boolean paramBoolean, int paramInt2, mlp parammlp)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Mlp = parammlp;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Mln = parammln;
    if (parammln.jdField_a_of_type_Int == 0)
    {
      parammlp = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getResources();
      if (this.jdField_b_of_type_Int == -16777216)
      {
        parammlp = mtp.a(parammlp, 2130841686, 2131165869);
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammlp);
        label67:
        switch (parammln.jdField_b_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(parammln.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
      setHighlight(paramBoolean);
      setContentDescription(parammln.jdField_a_of_type_JavaLangString + ajya.a(2131716853));
      return;
      parammlp = mtp.a(parammlp, 2130841686, 2131165906);
      break;
      if (TextUtils.isEmpty(parammln.jdField_b_of_type_JavaLangString)) {
        break label67;
      }
      parammlp = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = actj.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165766));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt1, paramInt1);
      parammlp.mRequestWidth = paramInt1;
      parammlp.mRequestHeight = paramInt1;
      parammlp.mFailedDrawable = localGradientDrawable;
      parammlp.mLoadingDrawable = localGradientDrawable;
      parammlp = URLDrawable.getDrawable(parammln.jdField_b_of_type_JavaLangString, parammlp);
      parammlp.setTag(bavw.a(paramInt1, paramInt1));
      parammlp.setDecodeHandler(bavw.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammlp);
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
    if (this.jdField_a_of_type_Mlp != null) {
      this.jdField_a_of_type_Mlp.a(this, this.jdField_a_of_type_Int);
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
    if ((this.jdField_a_of_type_Mln != null) && (this.jdField_a_of_type_Mln.jdField_a_of_type_Int == 0))
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