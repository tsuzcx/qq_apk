package com.tencent.mobileqq.ark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.XPanelContainer;

class ArkPanelPagerAdapter$IconLinearLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  
  public ArkPanelPagerAdapter$IconLinearLayout(ArkPanelPagerAdapter paramArkPanelPagerAdapter, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    int k = paramArkPanelPagerAdapter.a();
    int m = paramArkPanelPagerAdapter.b();
    int n = AIOUtils.a(15.0F, getContext().getResources());
    int i = 0;
    while (i < m)
    {
      paramArkPanelPagerAdapter = new LinearLayout(paramContext);
      int j = (XPanelContainer.jdField_a_of_type_Int - XPanelContainer.d - n) / m;
      paramAttributeSet = new RelativeLayout.LayoutParams(-1, j);
      paramAttributeSet.leftMargin = AIOUtils.a(20.0F, getContext().getResources());
      paramAttributeSet.rightMargin = AIOUtils.a(20.0F, getContext().getResources());
      paramArkPanelPagerAdapter.setOrientation(0);
      if (i == 0) {}
      for (paramAttributeSet.topMargin = (XPanelContainer.d / (m + 1));; paramAttributeSet.topMargin = (j * i + XPanelContainer.d * (i + 2) / (m + 1) / 2))
      {
        j = 0;
        while (j < k)
        {
          Object localObject = new LinearLayout.LayoutParams(-1, -1);
          ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
          if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
            this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
          }
          View localView = LayoutInflater.from(paramContext).inflate(2131558944, null);
          paramArkPanelPagerAdapter.addView(localView, (ViewGroup.LayoutParams)localObject);
          localObject = new ArkPanelPagerAdapter.ViewHolder();
          ((ArkPanelPagerAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368755));
          ((ArkPanelPagerAdapter.ViewHolder)localObject).b = ((ImageView)localView.findViewById(2131367117));
          ((ArkPanelPagerAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379106));
          localView.setTag(localObject);
          j += 1;
        }
      }
      addView(paramArkPanelPagerAdapter, paramAttributeSet);
      i += 1;
    }
    setTag(Integer.valueOf(XPanelContainer.d));
  }
  
  public void a()
  {
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if (localObject != null)
      {
        localObject = (ArkPanelPagerAdapter.ViewHolder)((View)localObject).getTag();
        if ((localObject != null) && (((ArkPanelPagerAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView != null)) {
          ((ArkPanelPagerAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkPanelPagerAdapter.IconLinearLayout
 * JD-Core Version:    0.7.0.1
 */