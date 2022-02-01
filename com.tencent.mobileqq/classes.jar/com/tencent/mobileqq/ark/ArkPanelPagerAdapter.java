package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;

public class ArkPanelPagerAdapter
  extends PagerAdapter
{
  int jdField_a_of_type_Int = 4;
  Context jdField_a_of_type_AndroidContentContext;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  PanelRecycleBin jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin;
  ArrayList<ArkAppManagerPanel.ArkAppPanelData> jdField_a_of_type_JavaUtilArrayList;
  int b = 2;
  private int c;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
    this.c = AIOUtils.a(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, ArkPanelPagerAdapter.IconLinearLayout paramIconLinearLayout)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    paramIconLinearLayout.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.b)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramIconLinearLayout.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        ArkPanelPagerAdapter.ViewHolder localViewHolder = (ArkPanelPagerAdapter.ViewHolder)localView.getTag();
        int m = n * i1 * paramInt + i;
        ArkAppManagerPanel.ArkAppPanelData localArkAppPanelData;
        label159:
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localArkAppPanelData = (ArkAppManagerPanel.ArkAppPanelData)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((m == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (localArkAppPanelData.jdField_a_of_type_Boolean))
          {
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView.getResources().getDrawable(2130838766));
            localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localArkAppPanelData.jdField_b_of_type_JavaLangString);
            localObject = localViewHolder.b;
            if (!localArkAppPanelData.jdField_b_of_type_Boolean) {
              break label347;
            }
            m = 0;
            label190:
            ((ImageView)localObject).setVisibility(m);
            localViewHolder.jdField_a_of_type_JavaLangString = localArkAppPanelData.jdField_a_of_type_JavaLangString;
            localView.setContentDescription(localArkAppPanelData.jdField_b_of_type_JavaLangString + HardCodeUtil.a(2131700794));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setEnabled(true);
            AccessibilityUtil.a(localView, true);
          }
        }
        for (;;)
        {
          AccessibilityUtil.a(localViewHolder.jdField_a_of_type_AndroidWidgetTextView, false);
          i += 1;
          k += 1;
          break;
          localObject = URLDrawable.URLDrawableOptions.obtain();
          Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
          m = this.c;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = m;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = m;
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(localArkAppPanelData.c, (URLDrawable.URLDrawableOptions)localObject));
          break label159;
          label347:
          m = 8;
          break label190;
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localViewHolder.b.setVisibility(8);
          localViewHolder.jdField_a_of_type_JavaLangString = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          AccessibilityUtil.a(localView, false);
        }
      }
      j += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    for (;;)
    {
      return;
      if (paramInt >= 0)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
        {
          ArkPanelPagerAdapter.IconLinearLayout localIconLinearLayout = (ArkPanelPagerAdapter.IconLinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localIconLinearLayout != null) && (paramInt == localIconLinearLayout.jdField_a_of_type_Int))
          {
            a(paramInt, localIconLinearLayout);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ArrayList<ArkAppManagerPanel.ArkAppPanelData> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ArkPanelPagerAdapter.IconLinearLayout localIconLinearLayout = (ArkPanelPagerAdapter.IconLinearLayout)paramObject;
    ((ViewGroup)paramView).removeView(localIconLinearLayout);
    localIconLinearLayout.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.addScrapView((View)paramObject);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.b == 0) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return 0;
    }
    return (this.jdField_a_of_type_JavaUtilArrayList.size() + this.jdField_a_of_type_Int * this.b - 1) / (this.jdField_a_of_type_Int * this.b);
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (((paramObject instanceof ArkPanelPagerAdapter.IconLinearLayout)) && (((ArkPanelPagerAdapter.IconLinearLayout)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkPanelPagerAdapter", 2, "instantiateItem position=" + paramInt);
    }
    ArkPanelPagerAdapter.IconLinearLayout localIconLinearLayout = (ArkPanelPagerAdapter.IconLinearLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.getScrapView();
    Object localObject;
    if (localIconLinearLayout != null)
    {
      localObject = localIconLinearLayout.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localIconLinearLayout.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.clearScrapViews();
        localIconLinearLayout = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localIconLinearLayout;
      if (localIconLinearLayout == null) {
        localObject = new ArkPanelPagerAdapter.IconLinearLayout(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((ArkPanelPagerAdapter.IconLinearLayout)localObject).a(paramInt);
      a(paramInt, (ArkPanelPagerAdapter.IconLinearLayout)localObject);
      if ((((ArkPanelPagerAdapter.IconLinearLayout)localObject).getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView((View)localObject);
      }
      return localObject;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkPanelPagerAdapter
 * JD-Core Version:    0.7.0.1
 */