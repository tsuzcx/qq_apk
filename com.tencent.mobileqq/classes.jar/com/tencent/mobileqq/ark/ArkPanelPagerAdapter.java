package com.tencent.mobileqq.ark;

import actj;
import ajya;
import altg;
import alty;
import altz;
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
import aobo;
import baww;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
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
  aobo jdField_a_of_type_Aobo;
  ArrayList<altg> jdField_a_of_type_JavaUtilArrayList;
  int b = 2;
  private int c;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aobo = new aobo();
    this.c = actj.a(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, alty paramalty)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    paramalty.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.b)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramalty.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        altz localaltz = (altz)localView.getTag();
        int m = n * i1 * paramInt + i;
        altg localaltg;
        label159:
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localaltg = (altg)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localaltz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((m == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (localaltg.jdField_a_of_type_Boolean))
          {
            localaltz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView.getResources().getDrawable(2130838476));
            localaltz.jdField_a_of_type_AndroidWidgetTextView.setText(localaltg.jdField_b_of_type_JavaLangString);
            localObject = localaltz.b;
            if (!localaltg.jdField_b_of_type_Boolean) {
              break label347;
            }
            m = 0;
            label190:
            ((ImageView)localObject).setVisibility(m);
            localaltz.jdField_a_of_type_JavaLangString = localaltg.jdField_a_of_type_JavaLangString;
            localView.setContentDescription(localaltg.jdField_b_of_type_JavaLangString + ajya.a(2131700717));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setEnabled(true);
            baww.a(localView, true);
          }
        }
        for (;;)
        {
          baww.a(localaltz.jdField_a_of_type_AndroidWidgetTextView, false);
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
          localaltz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(localaltg.c, (URLDrawable.URLDrawableOptions)localObject));
          break label159;
          label347:
          m = 8;
          break label190;
          localaltz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localaltz.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          localaltz.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localaltz.b.setVisibility(8);
          localaltz.jdField_a_of_type_JavaLangString = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          baww.a(localView, false);
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
          alty localalty = (alty)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localalty != null) && (paramInt == localalty.jdField_a_of_type_Int))
          {
            a(paramInt, localalty);
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
  
  public void a(ArrayList<altg> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    alty localalty = (alty)paramObject;
    ((ViewGroup)paramView).removeView(localalty);
    localalty.a();
    this.jdField_a_of_type_Aobo.a((View)paramObject);
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
    if (((paramObject instanceof alty)) && (((alty)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkPanelPagerAdapter", 2, "instantiateItem position=" + paramInt);
    }
    alty localalty = (alty)this.jdField_a_of_type_Aobo.a();
    Object localObject;
    if (localalty != null)
    {
      localObject = localalty.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localalty.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Aobo.a();
        localalty = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localalty;
      if (localalty == null) {
        localObject = new alty(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((alty)localObject).a(paramInt);
      a(paramInt, (alty)localObject);
      if ((((alty)localObject).getParent() != paramView) && (paramInt < getCount())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkPanelPagerAdapter
 * JD-Core Version:    0.7.0.1
 */