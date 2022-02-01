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
import anvx;
import apyt;
import apzl;
import apzm;
import bgyd;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
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
  ArrayList<apyt> jdField_a_of_type_JavaUtilArrayList;
  int b = 2;
  private int c;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
    this.c = AIOUtils.dp2px(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, apzl paramapzl)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    paramapzl.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.b)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramapzl.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        apzm localapzm = (apzm)localView.getTag();
        int m = n * i1 * paramInt + i;
        apyt localapyt;
        label159:
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localapyt = (apyt)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localapzm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((m == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (localapyt.jdField_a_of_type_Boolean))
          {
            localapzm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView.getResources().getDrawable(2130838698));
            localapzm.jdField_a_of_type_AndroidWidgetTextView.setText(localapyt.jdField_b_of_type_JavaLangString);
            localObject = localapzm.b;
            if (!localapyt.jdField_b_of_type_Boolean) {
              break label347;
            }
            m = 0;
            label190:
            ((ImageView)localObject).setVisibility(m);
            localapzm.jdField_a_of_type_JavaLangString = localapyt.jdField_a_of_type_JavaLangString;
            localView.setContentDescription(localapyt.jdField_b_of_type_JavaLangString + anvx.a(2131700216));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setEnabled(true);
            bgyd.a(localView, true);
          }
        }
        for (;;)
        {
          bgyd.a(localapzm.jdField_a_of_type_AndroidWidgetTextView, false);
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
          localapzm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(localapyt.c, (URLDrawable.URLDrawableOptions)localObject));
          break label159;
          label347:
          m = 8;
          break label190;
          localapzm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localapzm.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          localapzm.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localapzm.b.setVisibility(8);
          localapzm.jdField_a_of_type_JavaLangString = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          bgyd.a(localView, false);
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
          apzl localapzl = (apzl)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localapzl != null) && (paramInt == localapzl.jdField_a_of_type_Int))
          {
            a(paramInt, localapzl);
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
  
  public void a(ArrayList<apyt> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    apzl localapzl = (apzl)paramObject;
    ((ViewGroup)paramView).removeView(localapzl);
    localapzl.a();
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
    if (((paramObject instanceof apzl)) && (((apzl)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkPanelPagerAdapter", 2, "instantiateItem position=" + paramInt);
    }
    apzl localapzl = (apzl)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.getScrapView();
    Object localObject;
    if (localapzl != null)
    {
      localObject = localapzl.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localapzl.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.clearScrapViews();
        localapzl = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localapzl;
      if (localapzl == null) {
        localObject = new apzl(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((apzl)localObject).a(paramInt);
      a(paramInt, (apzl)localObject);
      if ((((apzl)localObject).getParent() != paramView) && (paramInt < getCount())) {
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