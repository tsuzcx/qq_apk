package com.tencent.mobileqq.activity.aio;

import afzr;
import afzs;
import afzx;
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
import anni;
import asbp;
import baif;
import bgfz;
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
  public SparseArray<List<afzx>> a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  asbp jdField_a_of_type_Asbp = new asbp();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  ArrayList<afzx> jdField_a_of_type_JavaUtilArrayList;
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
  
  private void a(int paramInt, afzr paramafzr)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.jdField_b_of_type_Int;
    paramafzr.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.jdField_b_of_type_Int)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramafzr.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        afzs localafzs = (afzs)localView.getTag();
        int m = n * i1 * paramInt + i;
        afzx localafzx;
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localafzx = (afzx)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localafzs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localafzs.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localafzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if ((localafzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
          {
            localObject = (URLDrawable)localafzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (((URLDrawable)localObject).getStatus() == 2) {
              ((URLDrawable)localObject).restartDownload();
            }
          }
          localafzs.jdField_a_of_type_AndroidWidgetTextView.setText(localafzx.jdField_a_of_type_JavaLangString);
          localafzs.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
          localafzs.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
          if (!TextUtils.isEmpty(localafzx.c))
          {
            localafzs.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            localObject = ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10, String.valueOf(localafzx.c));
            if (localObject != null) {
              localafzs.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
            }
            localafzs.jdField_a_of_type_Int = localafzx.jdField_a_of_type_Int;
            localafzs.jdField_b_of_type_JavaLangString = localafzx.e;
            localafzs.jdField_a_of_type_JavaLangString = localafzx.d;
            localafzs.jdField_b_of_type_Int = localafzx.jdField_b_of_type_Int;
            localafzs.c = localafzx.c;
            localafzs.jdField_a_of_type_Boolean = localafzx.jdField_a_of_type_Boolean;
            localView.setContentDescription(localafzx.jdField_a_of_type_JavaLangString + anni.a(2131706637));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            localView.setEnabled(true);
            bgfz.a(localView, true);
          }
        }
        for (;;)
        {
          bgfz.a(localafzs.jdField_a_of_type_AndroidWidgetTextView, false);
          i += 1;
          k += 1;
          break;
          localObject = localafzs.jdField_b_of_type_AndroidWidgetImageView;
          if (localafzx.jdField_a_of_type_Boolean) {}
          for (m = 0;; m = 8)
          {
            ((ImageView)localObject).setVisibility(m);
            break;
          }
          localafzs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localafzs.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          localafzs.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
          localafzs.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          localafzs.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localafzs.jdField_a_of_type_Int = 0;
          localafzs.jdField_b_of_type_JavaLangString = "";
          localafzs.jdField_a_of_type_JavaLangString = "";
          localafzs.jdField_b_of_type_Int = 0;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          bgfz.a(localView, false);
        }
      }
      j += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List<afzx> a(int paramInt)
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
          afzr localafzr = (afzr)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localafzr != null) && (paramInt == localafzr.jdField_a_of_type_Int))
          {
            a(paramInt, localafzr);
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
  
  public void a(ArrayList<afzx> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    afzr localafzr = (afzr)paramObject;
    ((ViewGroup)paramView).removeView(localafzr);
    localafzr.a();
    this.jdField_a_of_type_Asbp.a((View)paramObject);
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
    if (((paramObject instanceof afzr)) && (((afzr)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    }
    afzr localafzr = (afzr)this.jdField_a_of_type_Asbp.a();
    Object localObject;
    if (localafzr != null)
    {
      localObject = localafzr.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localafzr.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Asbp.a();
        localafzr = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localafzr;
      if (localafzr == null) {
        localObject = new afzr(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((afzr)localObject).a(paramInt);
      a(paramInt, (afzr)localObject);
      if ((((afzr)localObject).getParent() != paramView) && (paramInt < getCount())) {
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PanelAdapter
 * JD-Core Version:    0.7.0.1
 */