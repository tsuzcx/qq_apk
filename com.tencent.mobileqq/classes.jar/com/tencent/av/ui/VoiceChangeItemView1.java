package com.tencent.av.ui;

import aciy;
import ajjy;
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
import azue;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import maz;
import mbb;
import mit;

public class VoiceChangeItemView1
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView = null;
  maz jdField_a_of_type_Maz = null;
  mbb jdField_a_of_type_Mbb;
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
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131494033, this);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131313468));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131313473));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131313472));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getLayoutParams();
    int i = aciy.a(65.0F, getResources());
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setLayoutParams(localLayoutParams);
    setOnClickListener(this);
  }
  
  public void a(int paramInt1, maz parammaz, boolean paramBoolean, int paramInt2, mbb parammbb)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Mbb = parammbb;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Maz = parammaz;
    if (parammaz.jdField_a_of_type_Int == 0)
    {
      parammbb = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getResources();
      if (this.jdField_b_of_type_Int == -16777216)
      {
        parammbb = mit.a(parammbb, 2130841594, 2131100279);
        this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammbb);
        label67:
        switch (parammaz.jdField_b_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(parammaz.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
      setHighlight(paramBoolean);
      setContentDescription(parammaz.jdField_a_of_type_JavaLangString + ajjy.a(2131651051));
      return;
      parammbb = mit.a(parammbb, 2130841594, 2131100316);
      break;
      if (TextUtils.isEmpty(parammaz.jdField_b_of_type_JavaLangString)) {
        break label67;
      }
      parammbb = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = aciy.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131100176));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt1, paramInt1);
      parammbb.mRequestWidth = paramInt1;
      parammbb.mRequestHeight = paramInt1;
      parammbb.mFailedDrawable = localGradientDrawable;
      parammbb.mLoadingDrawable = localGradientDrawable;
      parammbb = URLDrawable.getDrawable(parammaz.jdField_b_of_type_JavaLangString, parammbb);
      parammbb.setTag(azue.a(paramInt1, paramInt1));
      parammbb.setDecodeHandler(azue.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammbb);
      break label67;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841704);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841704);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841704);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Mbb != null) {
      this.jdField_a_of_type_Mbb.a(this, this.jdField_a_of_type_Int);
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
    if ((this.jdField_a_of_type_Maz != null) && (this.jdField_a_of_type_Maz.jdField_a_of_type_Int == 0))
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