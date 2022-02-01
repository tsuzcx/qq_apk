package com.tencent.av.ui;

import agej;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import bhez;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import mig;
import mii;

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
    ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2131559800, this);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131373372));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381213));
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, mii parammii, mig parammig)
  {
    super.a(paramInt, parammig);
    setId(paramInt);
    setTag(parammii);
    if (!TextUtils.isEmpty(parammii.jdField_b_of_type_JavaLangString))
    {
      parammig = URLDrawable.URLDrawableOptions.obtain();
      paramInt = agej.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165854));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      parammig.mRequestWidth = paramInt;
      parammig.mRequestHeight = paramInt;
      parammig.mFailedDrawable = localGradientDrawable;
      parammig.mLoadingDrawable = localGradientDrawable;
      parammig = URLDrawable.getDrawable(parammii.jdField_b_of_type_JavaLangString, parammig);
      parammig.setTag(bhez.a(paramInt, paramInt));
      parammig.setDecodeHandler(bhez.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(parammig);
    }
    switch (parammii.jdField_b_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      setHighlight(paramBoolean1);
      return;
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
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = findViewById(2131381211);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    ((View)localObject).setLayoutParams(localLayoutParams);
    if ((this.jdField_a_of_type_ComTencentAvFunchatAVListImageView != null) && (paramInt1 < getResources().getDimensionPixelSize(2131297656)))
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