package com.tencent.mobileqq.ark;

import aciy;
import ajjy;
import alet;
import alfl;
import alfm;
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
import ankz;
import azve;
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
  ankz jdField_a_of_type_Ankz;
  ArrayList<alet> jdField_a_of_type_JavaUtilArrayList;
  int b = 2;
  private int c;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ankz = new ankz();
    this.c = aciy.a(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, alfl paramalfl)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    paramalfl.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.b)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramalfl.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        alfm localalfm = (alfm)localView.getTag();
        int m = n * i1 * paramInt + i;
        alet localalet;
        label159:
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localalet = (alet)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localalfm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((m == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (localalet.jdField_a_of_type_Boolean))
          {
            localalfm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView.getResources().getDrawable(2130838465));
            localalfm.jdField_a_of_type_AndroidWidgetTextView.setText(localalet.jdField_b_of_type_JavaLangString);
            localObject = localalfm.b;
            if (!localalet.jdField_b_of_type_Boolean) {
              break label347;
            }
            m = 0;
            label190:
            ((ImageView)localObject).setVisibility(m);
            localalfm.jdField_a_of_type_JavaLangString = localalet.jdField_a_of_type_JavaLangString;
            localView.setContentDescription(localalet.jdField_b_of_type_JavaLangString + ajjy.a(2131634922));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setEnabled(true);
            azve.a(localView, true);
          }
        }
        for (;;)
        {
          azve.a(localalfm.jdField_a_of_type_AndroidWidgetTextView, false);
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
          localalfm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(localalet.c, (URLDrawable.URLDrawableOptions)localObject));
          break label159;
          label347:
          m = 8;
          break label190;
          localalfm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localalfm.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          localalfm.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localalfm.b.setVisibility(8);
          localalfm.jdField_a_of_type_JavaLangString = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          azve.a(localView, false);
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
          alfl localalfl = (alfl)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localalfl != null) && (paramInt == localalfl.jdField_a_of_type_Int))
          {
            a(paramInt, localalfl);
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
  
  public void a(ArrayList<alet> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    alfl localalfl = (alfl)paramObject;
    ((ViewGroup)paramView).removeView(localalfl);
    localalfl.a();
    this.jdField_a_of_type_Ankz.a((View)paramObject);
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
    if (((paramObject instanceof alfl)) && (((alfl)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkPanelPagerAdapter", 2, "instantiateItem position=" + paramInt);
    }
    alfl localalfl = (alfl)this.jdField_a_of_type_Ankz.a();
    Object localObject;
    if (localalfl != null)
    {
      localObject = localalfl.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localalfl.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Ankz.a();
        localalfl = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localalfl;
      if (localalfl == null) {
        localObject = new alfl(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((alfl)localObject).a(paramInt);
      a(paramInt, (alfl)localObject);
      if ((((alfl)localObject).getParent() != paramView) && (paramInt < getCount())) {
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