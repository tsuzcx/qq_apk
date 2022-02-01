package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar;

import afur;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.ArrayList;
import olu;

public class GameGiftsImageView
  extends FrameLayout
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  
  public GameGiftsImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GameGiftsImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public GameGiftsImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131560185, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368143));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368144));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368145));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131364962));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131364965));
    this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131364968));
  }
  
  private void a(ViewGroup paramViewGroup, ImageView paramImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramViewGroup.setVisibility(0);
    olu.a(paramImageView.getContext(), paramImageView, paramString, 0, afur.a(16.0F, getResources()), -1);
  }
  
  public void setImages(ArrayList<String> paramArrayList)
  {
    int i = 0;
    if (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      if (i == 0) {
        a(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetImageView, str);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 1) {
          a(this.jdField_b_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetImageView, str);
        } else if (i == 2) {
          a(this.jdField_c_of_type_AndroidWidgetFrameLayout, this.jdField_c_of_type_AndroidWidgetImageView, str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.GameGiftsImageView
 * JD-Core Version:    0.7.0.1
 */