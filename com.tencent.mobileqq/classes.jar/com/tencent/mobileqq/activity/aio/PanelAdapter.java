package com.tencent.mobileqq.activity.aio;

import aeow;
import aeox;
import aepc;
import alpo;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aptl;
import axho;
import bcvq;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PanelAdapter
  extends PagerAdapter
{
  int jdField_a_of_type_Int = 4;
  Context jdField_a_of_type_AndroidContentContext;
  public SparseArray<List<aepc>> a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  aptl jdField_a_of_type_Aptl = new aptl();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  ArrayList<aepc> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  int b;
  public boolean b;
  
  public PanelAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt, aeow paramaeow)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.jdField_b_of_type_Int;
    paramaeow.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.jdField_b_of_type_Int)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramaeow.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        aeox localaeox = (aeox)localView.getTag();
        int m = n * i1 * paramInt + i;
        aepc localaepc;
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localaepc = (aepc)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localaeox.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localaeox.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localaepc.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if ((localaepc.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
          {
            localObject = (URLDrawable)localaepc.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (((URLDrawable)localObject).getStatus() == 2) {
              ((URLDrawable)localObject).restartDownload();
            }
          }
          localaeox.jdField_a_of_type_AndroidWidgetTextView.setText(localaepc.jdField_a_of_type_JavaLangString);
          localaeox.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
          localaeox.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
          if (!TextUtils.isEmpty(localaepc.c))
          {
            localaeox.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            localObject = ((axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10, String.valueOf(localaepc.c));
            if (localObject != null) {
              localaeox.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
            }
            localaeox.jdField_a_of_type_Int = localaepc.jdField_a_of_type_Int;
            localaeox.jdField_b_of_type_JavaLangString = localaepc.e;
            localaeox.jdField_a_of_type_JavaLangString = localaepc.d;
            localaeox.jdField_b_of_type_Int = localaepc.jdField_b_of_type_Int;
            localaeox.c = localaepc.c;
            localaeox.jdField_a_of_type_Boolean = localaepc.jdField_a_of_type_Boolean;
            localView.setContentDescription(localaepc.jdField_a_of_type_JavaLangString + alpo.a(2131708248));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            localView.setEnabled(true);
            bcvq.a(localView, true);
          }
        }
        for (;;)
        {
          bcvq.a(localaeox.jdField_a_of_type_AndroidWidgetTextView, false);
          i += 1;
          k += 1;
          break;
          localObject = localaeox.jdField_b_of_type_AndroidWidgetImageView;
          if (localaepc.jdField_a_of_type_Boolean) {}
          for (m = 0;; m = 8)
          {
            ((ImageView)localObject).setVisibility(m);
            break;
          }
          localaeox.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localaeox.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          localaeox.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
          localaeox.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          localaeox.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localaeox.jdField_a_of_type_Int = 0;
          localaeox.jdField_b_of_type_JavaLangString = "";
          localaeox.jdField_a_of_type_JavaLangString = "";
          localaeox.jdField_b_of_type_Int = 0;
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
  
  public List<aepc> a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    i = this.jdField_b_of_type_Int * i;
    int j = i * paramInt;
    List localList2 = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, null);
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList2 = Collections.emptyList();
      localList1 = localList2;
      if (j >= 0)
      {
        localList1 = localList2;
        if (j < this.jdField_a_of_type_JavaUtilArrayList.size()) {
          localList1 = this.jdField_a_of_type_JavaUtilArrayList.subList(j, Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), i + j));
        }
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localList1);
    }
    return localList1;
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
          aeow localaeow = (aeow)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localaeow != null) && (paramInt == localaeow.jdField_a_of_type_Int))
          {
            a(paramInt, localaeow);
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
  
  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList<aepc> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    aeow localaeow = (aeow)paramObject;
    ((ViewGroup)paramView).removeView(localaeow);
    localaeow.a();
    this.jdField_a_of_type_Aptl.a((View)paramObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return 0;
    }
    return (this.jdField_a_of_type_JavaUtilArrayList.size() + this.jdField_a_of_type_Int * this.jdField_b_of_type_Int - 1) / (this.jdField_a_of_type_Int * this.jdField_b_of_type_Int);
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.jdField_b_of_type_Boolean) {
      return -2;
    }
    if (((paramObject instanceof aeow)) && (((aeow)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    }
    aeow localaeow = (aeow)this.jdField_a_of_type_Aptl.a();
    Object localObject;
    if (localaeow != null)
    {
      localObject = localaeow.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localaeow.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Aptl.a();
        localaeow = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localaeow;
      if (localaeow == null) {
        localObject = new aeow(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((aeow)localObject).a(paramInt);
      a(paramInt, (aeow)localObject);
      if ((((aeow)localObject).getParent() != paramView) && (paramInt < getCount())) {
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PanelAdapter
 * JD-Core Version:    0.7.0.1
 */