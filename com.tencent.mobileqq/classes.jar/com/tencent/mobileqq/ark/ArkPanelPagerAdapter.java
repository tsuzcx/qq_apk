package com.tencent.mobileqq.ark;

import aepi;
import alud;
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
import anoi;
import anpa;
import anpb;
import apxu;
import bczz;
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
  apxu jdField_a_of_type_Apxu;
  ArrayList<anoi> jdField_a_of_type_JavaUtilArrayList;
  int b = 2;
  private int c;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Apxu = new apxu();
    this.c = aepi.a(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, anpa paramanpa)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    paramanpa.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.b)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramanpa.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        anpb localanpb = (anpb)localView.getTag();
        int m = n * i1 * paramInt + i;
        anoi localanoi;
        label159:
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localanoi = (anoi)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localanpb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((m == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (localanoi.jdField_a_of_type_Boolean))
          {
            localanpb.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView.getResources().getDrawable(2130838543));
            localanpb.jdField_a_of_type_AndroidWidgetTextView.setText(localanoi.jdField_b_of_type_JavaLangString);
            localObject = localanpb.b;
            if (!localanoi.jdField_b_of_type_Boolean) {
              break label347;
            }
            m = 0;
            label190:
            ((ImageView)localObject).setVisibility(m);
            localanpb.jdField_a_of_type_JavaLangString = localanoi.jdField_a_of_type_JavaLangString;
            localView.setContentDescription(localanoi.jdField_b_of_type_JavaLangString + alud.a(2131701098));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setEnabled(true);
            bczz.a(localView, true);
          }
        }
        for (;;)
        {
          bczz.a(localanpb.jdField_a_of_type_AndroidWidgetTextView, false);
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
          localanpb.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(localanoi.c, (URLDrawable.URLDrawableOptions)localObject));
          break label159;
          label347:
          m = 8;
          break label190;
          localanpb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localanpb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          localanpb.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localanpb.b.setVisibility(8);
          localanpb.jdField_a_of_type_JavaLangString = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          bczz.a(localView, false);
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
          anpa localanpa = (anpa)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localanpa != null) && (paramInt == localanpa.jdField_a_of_type_Int))
          {
            a(paramInt, localanpa);
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
  
  public void a(ArrayList<anoi> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    anpa localanpa = (anpa)paramObject;
    ((ViewGroup)paramView).removeView(localanpa);
    localanpa.a();
    this.jdField_a_of_type_Apxu.a((View)paramObject);
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
    if (((paramObject instanceof anpa)) && (((anpa)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkPanelPagerAdapter", 2, "instantiateItem position=" + paramInt);
    }
    anpa localanpa = (anpa)this.jdField_a_of_type_Apxu.a();
    Object localObject;
    if (localanpa != null)
    {
      localObject = localanpa.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localanpa.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Apxu.a();
        localanpa = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localanpa;
      if (localanpa == null) {
        localObject = new anpa(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((anpa)localObject).a(paramInt);
      a(paramInt, (anpa)localObject);
      if ((((anpa)localObject).getParent() != paramView) && (paramInt < getCount())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkPanelPagerAdapter
 * JD-Core Version:    0.7.0.1
 */