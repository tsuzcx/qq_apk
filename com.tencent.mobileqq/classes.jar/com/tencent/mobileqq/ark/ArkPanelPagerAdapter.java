package com.tencent.mobileqq.ark;

import agej;
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
import anzj;
import aqce;
import aqcw;
import aqcx;
import asrd;
import bhga;
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
  asrd jdField_a_of_type_Asrd;
  ArrayList<aqce> jdField_a_of_type_JavaUtilArrayList;
  int b = 2;
  private int c;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Asrd = new asrd();
    this.c = agej.a(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, aqcw paramaqcw)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    paramaqcw.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.b)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramaqcw.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        aqcx localaqcx = (aqcx)localView.getTag();
        int m = n * i1 * paramInt + i;
        aqce localaqce;
        label159:
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localaqce = (aqce)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localaqcx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((m == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (localaqce.jdField_a_of_type_Boolean))
          {
            localaqcx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView.getResources().getDrawable(2130838657));
            localaqcx.jdField_a_of_type_AndroidWidgetTextView.setText(localaqce.jdField_b_of_type_JavaLangString);
            localObject = localaqcx.b;
            if (!localaqce.jdField_b_of_type_Boolean) {
              break label347;
            }
            m = 0;
            label190:
            ((ImageView)localObject).setVisibility(m);
            localaqcx.jdField_a_of_type_JavaLangString = localaqce.jdField_a_of_type_JavaLangString;
            localView.setContentDescription(localaqce.jdField_b_of_type_JavaLangString + anzj.a(2131699630));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setEnabled(true);
            bhga.a(localView, true);
          }
        }
        for (;;)
        {
          bhga.a(localaqcx.jdField_a_of_type_AndroidWidgetTextView, false);
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
          localaqcx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(localaqce.c, (URLDrawable.URLDrawableOptions)localObject));
          break label159;
          label347:
          m = 8;
          break label190;
          localaqcx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localaqcx.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          localaqcx.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localaqcx.b.setVisibility(8);
          localaqcx.jdField_a_of_type_JavaLangString = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          bhga.a(localView, false);
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
          aqcw localaqcw = (aqcw)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localaqcw != null) && (paramInt == localaqcw.jdField_a_of_type_Int))
          {
            a(paramInt, localaqcw);
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
  
  public void a(ArrayList<aqce> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    aqcw localaqcw = (aqcw)paramObject;
    ((ViewGroup)paramView).removeView(localaqcw);
    localaqcw.a();
    this.jdField_a_of_type_Asrd.a((View)paramObject);
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
    if (((paramObject instanceof aqcw)) && (((aqcw)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkPanelPagerAdapter", 2, "instantiateItem position=" + paramInt);
    }
    aqcw localaqcw = (aqcw)this.jdField_a_of_type_Asrd.a();
    Object localObject;
    if (localaqcw != null)
    {
      localObject = localaqcw.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localaqcw.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Asrd.a();
        localaqcw = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localaqcw;
      if (localaqcw == null) {
        localObject = new aqcw(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((aqcw)localObject).a(paramInt);
      a(paramInt, (aqcw)localObject);
      if ((((aqcw)localObject).getParent() != paramView) && (paramInt < getCount())) {
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