package com.tencent.mobileqq.ark;

import actn;
import ajyc;
import alth;
import altz;
import alua;
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
import aobj;
import bawi;
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
  aobj jdField_a_of_type_Aobj;
  ArrayList<alth> jdField_a_of_type_JavaUtilArrayList;
  int b = 2;
  private int c;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aobj = new aobj();
    this.c = actn.a(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, altz paramaltz)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    paramaltz.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.b)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramaltz.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        alua localalua = (alua)localView.getTag();
        int m = n * i1 * paramInt + i;
        alth localalth;
        label159:
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localalth = (alth)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localalua.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((m == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (localalth.jdField_a_of_type_Boolean))
          {
            localalua.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView.getResources().getDrawable(2130838476));
            localalua.jdField_a_of_type_AndroidWidgetTextView.setText(localalth.jdField_b_of_type_JavaLangString);
            localObject = localalua.b;
            if (!localalth.jdField_b_of_type_Boolean) {
              break label347;
            }
            m = 0;
            label190:
            ((ImageView)localObject).setVisibility(m);
            localalua.jdField_a_of_type_JavaLangString = localalth.jdField_a_of_type_JavaLangString;
            localView.setContentDescription(localalth.jdField_b_of_type_JavaLangString + ajyc.a(2131700706));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setEnabled(true);
            bawi.a(localView, true);
          }
        }
        for (;;)
        {
          bawi.a(localalua.jdField_a_of_type_AndroidWidgetTextView, false);
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
          localalua.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(localalth.c, (URLDrawable.URLDrawableOptions)localObject));
          break label159;
          label347:
          m = 8;
          break label190;
          localalua.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localalua.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          localalua.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localalua.b.setVisibility(8);
          localalua.jdField_a_of_type_JavaLangString = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          bawi.a(localView, false);
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
          altz localaltz = (altz)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localaltz != null) && (paramInt == localaltz.jdField_a_of_type_Int))
          {
            a(paramInt, localaltz);
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
  
  public void a(ArrayList<alth> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    altz localaltz = (altz)paramObject;
    ((ViewGroup)paramView).removeView(localaltz);
    localaltz.a();
    this.jdField_a_of_type_Aobj.a((View)paramObject);
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
    if (((paramObject instanceof altz)) && (((altz)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkPanelPagerAdapter", 2, "instantiateItem position=" + paramInt);
    }
    altz localaltz = (altz)this.jdField_a_of_type_Aobj.a();
    Object localObject;
    if (localaltz != null)
    {
      localObject = localaltz.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localaltz.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Aobj.a();
        localaltz = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localaltz;
      if (localaltz == null) {
        localObject = new altz(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((altz)localObject).a(paramInt);
      a(paramInt, (altz)localObject);
      if ((((altz)localObject).getParent() != paramView) && (paramInt < getCount())) {
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