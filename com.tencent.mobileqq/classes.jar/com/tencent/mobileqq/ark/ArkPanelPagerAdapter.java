package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
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
  ArrayList<ArkAppPanelData> jdField_a_of_type_JavaUtilArrayList;
  int b = 2;
  private int c;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
    this.c = AIOUtils.b(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, ArkPanelPagerAdapter.IconLinearLayout paramIconLinearLayout)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    paramIconLinearLayout.a(paramInt);
    int j = 0;
    int i = 0;
    while (j < this.b)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramIconLinearLayout.getChildAt(j);
      int k = 0;
      while (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        ArkPanelPagerAdapter.ViewHolder localViewHolder = (ArkPanelPagerAdapter.ViewHolder)localView.getTag();
        int i2 = n * i1 * paramInt + i;
        int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
        int m = 8;
        if (i2 < i3)
        {
          ArkAppPanelData localArkAppPanelData = (ArkAppPanelData)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((i2 == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (localArkAppPanelData.jdField_a_of_type_Boolean))
          {
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView.getResources().getDrawable(2130838611));
          }
          else
          {
            localObject = URLDrawable.URLDrawableOptions.obtain();
            Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
            i2 = this.c;
            ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i2;
            ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i2;
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(localArkAppPanelData.c, (URLDrawable.URLDrawableOptions)localObject));
          }
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localArkAppPanelData.jdField_b_of_type_JavaLangString);
          Object localObject = localViewHolder.b;
          if (localArkAppPanelData.jdField_b_of_type_Boolean) {
            m = 0;
          }
          ((ImageView)localObject).setVisibility(m);
          localViewHolder.jdField_a_of_type_JavaLangString = localArkAppPanelData.jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localArkAppPanelData.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131700938));
          localView.setContentDescription(((StringBuilder)localObject).toString());
          localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localView.setEnabled(true);
          AccessibilityUtil.a(localView, true);
        }
        else
        {
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localViewHolder.b.setVisibility(8);
          localViewHolder.jdField_a_of_type_JavaLangString = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          AccessibilityUtil.a(localView, false);
        }
        AccessibilityUtil.a(localViewHolder.jdField_a_of_type_AndroidWidgetTextView, false);
        i += 1;
        k += 1;
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
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
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
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ArrayList<ArkAppPanelData> paramArrayList)
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
    if ((this.jdField_a_of_type_Int != 0) && (this.b != 0))
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (localArrayList != null)
      {
        int i = localArrayList.size();
        int j = this.jdField_a_of_type_Int;
        int k = this.b;
        return (i + j * k - 1) / (j * k);
      }
    }
    return 0;
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("instantiateItem position=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ArkPanelPagerAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (ArkPanelPagerAdapter.IconLinearLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.getScrapView();
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject3 = ((ArkPanelPagerAdapter.IconLinearLayout)localObject2).getTag();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof Integer))
        {
          localObject1 = localObject2;
          if (((Integer)((ArkPanelPagerAdapter.IconLinearLayout)localObject2).getTag()).intValue() != XPanelContainer.d)
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.clearScrapViews();
            localObject1 = null;
          }
        }
      }
    }
    Object localObject3 = (ViewGroup)paramView;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject3);
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArkPanelPagerAdapter.IconLinearLayout(this, this.jdField_a_of_type_AndroidContentContext, null);
    }
    ((ArkPanelPagerAdapter.IconLinearLayout)localObject2).a(paramInt);
    a(paramInt, (ArkPanelPagerAdapter.IconLinearLayout)localObject2);
    if ((((ArkPanelPagerAdapter.IconLinearLayout)localObject2).getParent() != paramView) && (paramInt < getCount())) {
      ((ViewGroup)localObject3).addView((View)localObject2);
    }
    return localObject2;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkPanelPagerAdapter
 * JD-Core Version:    0.7.0.1
 */