package com.tencent.mobileqq.ark;

import aekt;
import alpo;
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
import anjz;
import ankr;
import anks;
import aptl;
import bcvq;
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
  aptl jdField_a_of_type_Aptl;
  ArrayList<anjz> jdField_a_of_type_JavaUtilArrayList;
  int b = 2;
  private int c;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aptl = new aptl();
    this.c = aekt.a(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, ankr paramankr)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    paramankr.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.b)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramankr.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        anks localanks = (anks)localView.getTag();
        int m = n * i1 * paramInt + i;
        anjz localanjz;
        label159:
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localanjz = (anjz)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localanks.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((m == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (localanjz.jdField_a_of_type_Boolean))
          {
            localanks.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView.getResources().getDrawable(2130838542));
            localanks.jdField_a_of_type_AndroidWidgetTextView.setText(localanjz.jdField_b_of_type_JavaLangString);
            localObject = localanks.b;
            if (!localanjz.jdField_b_of_type_Boolean) {
              break label347;
            }
            m = 0;
            label190:
            ((ImageView)localObject).setVisibility(m);
            localanks.jdField_a_of_type_JavaLangString = localanjz.jdField_a_of_type_JavaLangString;
            localView.setContentDescription(localanjz.jdField_b_of_type_JavaLangString + alpo.a(2131701086));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setEnabled(true);
            bcvq.a(localView, true);
          }
        }
        for (;;)
        {
          bcvq.a(localanks.jdField_a_of_type_AndroidWidgetTextView, false);
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
          localanks.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(localanjz.c, (URLDrawable.URLDrawableOptions)localObject));
          break label159;
          label347:
          m = 8;
          break label190;
          localanks.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localanks.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
          localanks.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localanks.b.setVisibility(8);
          localanks.jdField_a_of_type_JavaLangString = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          bcvq.a(localView, false);
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
          ankr localankr = (ankr)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localankr != null) && (paramInt == localankr.jdField_a_of_type_Int))
          {
            a(paramInt, localankr);
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
  
  public void a(ArrayList<anjz> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ankr localankr = (ankr)paramObject;
    ((ViewGroup)paramView).removeView(localankr);
    localankr.a();
    this.jdField_a_of_type_Aptl.a((View)paramObject);
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
    if (((paramObject instanceof ankr)) && (((ankr)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkPanelPagerAdapter", 2, "instantiateItem position=" + paramInt);
    }
    ankr localankr = (ankr)this.jdField_a_of_type_Aptl.a();
    Object localObject;
    if (localankr != null)
    {
      localObject = localankr.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localankr.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Aptl.a();
        localankr = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localankr;
      if (localankr == null) {
        localObject = new ankr(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((ankr)localObject).a(paramInt);
      a(paramInt, (ankr)localObject);
      if ((((ankr)localObject).getParent() != paramView) && (paramInt < getCount())) {
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