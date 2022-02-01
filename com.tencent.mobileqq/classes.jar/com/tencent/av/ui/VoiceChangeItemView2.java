package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import bgxc;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import mil;
import min;

public class VoiceChangeItemView2
  extends QavListItemBase
{
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView = null;
  Context b;
  
  public VoiceChangeItemView2(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2131559839, this);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131373501));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381284));
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, min parammin, mil parammil)
  {
    super.a(paramInt, parammil);
    setId(paramInt);
    setTag(parammin);
    if (!TextUtils.isEmpty(parammin.jdField_b_of_type_JavaLangString))
    {
      parammil = URLDrawable.URLDrawableOptions.obtain();
      paramInt = AIOUtils.dp2px(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165881));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      parammil.mRequestWidth = paramInt;
      parammil.mRequestHeight = paramInt;
      parammil.mFailedDrawable = localGradientDrawable;
      parammil.mLoadingDrawable = localGradientDrawable;
      parammil = URLDrawable.getDrawable(parammin.jdField_b_of_type_JavaLangString, parammil);
      parammil.setTag(bgxc.a(paramInt, paramInt));
      parammil.setDecodeHandler(bgxc.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammil);
    }
    switch (parammin.jdField_b_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      setHighlight(paramBoolean1);
      return;
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
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = findViewById(2131381282);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    ((View)localObject).setLayoutParams(localLayoutParams);
    if ((this.jdField_a_of_type_ComTencentAvFunchatAVListImageView != null) && (paramInt1 < getResources().getDimensionPixelSize(2131297712)))
    {
      localObject = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = paramInt1;
      ((ViewGroup.LayoutParams)localObject).height = paramInt1;
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setHighlight(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView2
 * JD-Core Version:    0.7.0.1
 */