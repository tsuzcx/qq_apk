package com.tencent.mobileqq.activity.aio;

import acxk;
import acxl;
import acxp;
import ajya;
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
import aobo;
import avps;
import baww;
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
  public SparseArray<List<acxp>> a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  aobo jdField_a_of_type_Aobo = new aobo();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  ArrayList<acxp> jdField_a_of_type_JavaUtilArrayList;
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
  
  private void a(int paramInt, acxk paramacxk)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.jdField_b_of_type_Int;
    paramacxk.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.jdField_b_of_type_Int)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramacxk.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        acxl localacxl = (acxl)localView.getTag();
        int m = n * i1 * paramInt + i;
        acxp localacxp;
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localacxp = (acxp)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localacxl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localacxl.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localacxp.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if ((localacxp.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
          {
            localObject = (URLDrawable)localacxp.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (((URLDrawable)localObject).getStatus() == 2) {
              ((URLDrawable)localObject).restartDownload();
            }
          }
          localacxl.jdField_a_of_type_AndroidWidgetTextView.setText(localacxp.jdField_a_of_type_JavaLangString);
          localacxl.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
          localacxl.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
          if (!TextUtils.isEmpty(localacxp.c))
          {
            localacxl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            localObject = ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10, String.valueOf(localacxp.c));
            if (localObject != null) {
              localacxl.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
            }
            localacxl.jdField_a_of_type_Int = localacxp.jdField_a_of_type_Int;
            localacxl.jdField_b_of_type_JavaLangString = localacxp.e;
            localacxl.jdField_a_of_type_JavaLangString = localacxp.d;
            localacxl.jdField_b_of_type_Int = localacxp.jdField_b_of_type_Int;
            localacxl.c = localacxp.c;
            localacxl.jdField_a_of_type_Boolean = localacxp.jdField_a_of_type_Boolean;
            localView.setContentDescription(localacxp.jdField_a_of_type_JavaLangString + ajya.a(2131707876));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            localView.setEnabled(true);
            baww.a(localView, true);
          }
        }
        for (;;)
        {
          baww.a(localacxl.jdField_a_of_type_AndroidWidgetTextView, false);
          i += 1;
          k += 1;
          break;
          localObject = localacxl.jdField_b_of_type_AndroidWidgetImageView;
          if (localacxp.jdField_a_of_type_Boolean) {}
          for (m = 0;; m = 8)
          {
            ((ImageView)localObject).setVisibility(m);
            break;
          }
          localacxl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localacxl.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          localacxl.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
          localacxl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          localacxl.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localacxl.jdField_a_of_type_Int = 0;
          localacxl.jdField_b_of_type_JavaLangString = "";
          localacxl.jdField_a_of_type_JavaLangString = "";
          localacxl.jdField_b_of_type_Int = 0;
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
  
  public List<acxp> a(int paramInt)
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
          acxk localacxk = (acxk)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localacxk != null) && (paramInt == localacxk.jdField_a_of_type_Int))
          {
            a(paramInt, localacxk);
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
  
  public void a(ArrayList<acxp> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    acxk localacxk = (acxk)paramObject;
    ((ViewGroup)paramView).removeView(localacxk);
    localacxk.a();
    this.jdField_a_of_type_Aobo.a((View)paramObject);
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
    if (((paramObject instanceof acxk)) && (((acxk)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    }
    acxk localacxk = (acxk)this.jdField_a_of_type_Aobo.a();
    Object localObject;
    if (localacxk != null)
    {
      localObject = localacxk.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localacxk.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Aobo.a();
        localacxk = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localacxk;
      if (localacxk == null) {
        localObject = new acxk(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((acxk)localObject).a(paramInt);
      a(paramInt, (acxk)localObject);
      if ((((acxk)localObject).getParent() != paramView) && (paramInt < getCount())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PanelAdapter
 * JD-Core Version:    0.7.0.1
 */