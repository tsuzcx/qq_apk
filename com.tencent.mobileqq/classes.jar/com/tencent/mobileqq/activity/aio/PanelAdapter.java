package com.tencent.mobileqq.activity.aio;

import acmw;
import acmx;
import acmz;
import ajjy;
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
import ankz;
import auqh;
import azve;
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
  public SparseArray<List<acmz>> a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ankz jdField_a_of_type_Ankz = new ankz();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  ArrayList<acmz> jdField_a_of_type_JavaUtilArrayList;
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
  
  private void a(int paramInt, acmw paramacmw)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.jdField_b_of_type_Int;
    paramacmw.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.jdField_b_of_type_Int)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramacmw.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        acmx localacmx = (acmx)localView.getTag();
        int m = n * i1 * paramInt + i;
        acmz localacmz;
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localacmz = (acmz)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localacmx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localacmx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localacmz.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if ((localacmz.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
          {
            localObject = (URLDrawable)localacmz.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (((URLDrawable)localObject).getStatus() == 2) {
              ((URLDrawable)localObject).restartDownload();
            }
          }
          localacmx.jdField_a_of_type_AndroidWidgetTextView.setText(localacmz.jdField_a_of_type_JavaLangString);
          localacmx.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
          localacmx.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
          if (!TextUtils.isEmpty(localacmz.c))
          {
            localacmx.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            localObject = ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10, String.valueOf(localacmz.c));
            if (localObject != null) {
              localacmx.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
            }
            localacmx.jdField_a_of_type_Int = localacmz.jdField_a_of_type_Int;
            localacmx.jdField_b_of_type_JavaLangString = localacmz.e;
            localacmx.jdField_a_of_type_JavaLangString = localacmz.d;
            localacmx.jdField_b_of_type_Int = localacmz.jdField_b_of_type_Int;
            localacmx.c = localacmz.c;
            localacmx.jdField_a_of_type_Boolean = localacmz.jdField_a_of_type_Boolean;
            localView.setContentDescription(localacmz.jdField_a_of_type_JavaLangString + ajjy.a(2131642080));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            localView.setEnabled(true);
            azve.a(localView, true);
          }
        }
        for (;;)
        {
          azve.a(localacmx.jdField_a_of_type_AndroidWidgetTextView, false);
          i += 1;
          k += 1;
          break;
          localObject = localacmx.jdField_b_of_type_AndroidWidgetImageView;
          if (localacmz.jdField_a_of_type_Boolean) {}
          for (m = 0;; m = 8)
          {
            ((ImageView)localObject).setVisibility(m);
            break;
          }
          localacmx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localacmx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          localacmx.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
          localacmx.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          localacmx.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localacmx.jdField_a_of_type_Int = 0;
          localacmx.jdField_b_of_type_JavaLangString = "";
          localacmx.jdField_a_of_type_JavaLangString = "";
          localacmx.jdField_b_of_type_Int = 0;
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
  
  public List<acmz> a(int paramInt)
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
          acmw localacmw = (acmw)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localacmw != null) && (paramInt == localacmw.jdField_a_of_type_Int))
          {
            a(paramInt, localacmw);
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
  
  public void a(ArrayList<acmz> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    acmw localacmw = (acmw)paramObject;
    ((ViewGroup)paramView).removeView(localacmw);
    localacmw.a();
    this.jdField_a_of_type_Ankz.a((View)paramObject);
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
    if (((paramObject instanceof acmw)) && (((acmw)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    }
    acmw localacmw = (acmw)this.jdField_a_of_type_Ankz.a();
    Object localObject;
    if (localacmw != null)
    {
      localObject = localacmw.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localacmw.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Ankz.a();
        localacmw = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localacmw;
      if (localacmw == null) {
        localObject = new acmw(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((acmw)localObject).a(paramInt);
      a(paramInt, (acmw)localObject);
      if ((((acmw)localObject).getParent() != paramView) && (paramInt < getCount())) {
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