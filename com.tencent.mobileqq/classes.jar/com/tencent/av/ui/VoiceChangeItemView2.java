package com.tencent.av.ui;

import aciy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import azue;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import lxd;
import lxf;

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
    ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2131494034, this);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131306552));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131313473));
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, lxf paramlxf, lxd paramlxd)
  {
    super.a(paramInt, paramlxd);
    setId(paramInt);
    setTag(paramlxf);
    if (!TextUtils.isEmpty(paramlxf.jdField_b_of_type_JavaLangString))
    {
      paramlxd = URLDrawable.URLDrawableOptions.obtain();
      paramInt = aciy.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131100176));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      paramlxd.mRequestWidth = paramInt;
      paramlxd.mRequestHeight = paramInt;
      paramlxd.mFailedDrawable = localGradientDrawable;
      paramlxd.mLoadingDrawable = localGradientDrawable;
      paramlxd = URLDrawable.getDrawable(paramlxf.jdField_b_of_type_JavaLangString, paramlxd);
      paramlxd.setTag(azue.a(paramInt, paramInt));
      paramlxd.setDecodeHandler(azue.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(paramlxd);
    }
    switch (paramlxf.jdField_b_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      setHighlight(paramBoolean1);
      return;
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
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = findViewById(2131313471);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    ((View)localObject).setLayoutParams(localLayoutParams);
    if ((this.jdField_a_of_type_ComTencentAvFunchatAVListImageView != null) && (paramInt1 < getResources().getDimensionPixelSize(2131166455)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView2
 * JD-Core Version:    0.7.0.1
 */