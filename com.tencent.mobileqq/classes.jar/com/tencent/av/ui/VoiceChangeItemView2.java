package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;

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
    ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2131559786, this);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131373387));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380977));
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IClickCallback paramIClickCallback)
  {
    super.a(paramInt, paramIClickCallback);
    setId(paramInt);
    setTag(paramItemInfo);
    if (!TextUtils.isEmpty(paramItemInfo.jdField_b_of_type_JavaLangString))
    {
      paramIClickCallback = URLDrawable.URLDrawableOptions.obtain();
      paramInt = AIOUtils.b(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165886));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      paramIClickCallback.mRequestWidth = paramInt;
      paramIClickCallback.mRequestHeight = paramInt;
      paramIClickCallback.mFailedDrawable = localGradientDrawable;
      paramIClickCallback.mLoadingDrawable = localGradientDrawable;
      paramIClickCallback = URLDrawable.getDrawable(paramItemInfo.jdField_b_of_type_JavaLangString, paramIClickCallback);
      paramIClickCallback.setTag(URLDrawableDecodeHandler.a(paramInt, paramInt));
      paramIClickCallback.setDecodeHandler(URLDrawableDecodeHandler.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(paramIClickCallback);
    }
    paramInt = paramItemInfo.jdField_b_of_type_Int;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842383);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842383);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842383);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    setHighlight(paramBoolean1);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = findViewById(2131380975);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    ((View)localObject).setLayoutParams(localLayoutParams);
    if ((this.jdField_a_of_type_ComTencentAvFunchatAVListImageView != null) && (paramInt1 < getResources().getDimensionPixelSize(2131297770)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView2
 * JD-Core Version:    0.7.0.1
 */