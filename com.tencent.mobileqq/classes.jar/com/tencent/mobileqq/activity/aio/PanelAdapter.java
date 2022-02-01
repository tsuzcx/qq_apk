package com.tencent.mobileqq.activity.aio;

import agjl;
import agjm;
import agjr;
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
import anzj;
import asrd;
import bbav;
import bhga;
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
  public SparseArray<List<agjr>> a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  asrd jdField_a_of_type_Asrd = new asrd();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  ArrayList<agjr> jdField_a_of_type_JavaUtilArrayList;
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
  
  private void a(int paramInt, agjl paramagjl)
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.jdField_b_of_type_Int;
    paramagjl.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.jdField_b_of_type_Int)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramagjl.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        agjm localagjm = (agjm)localView.getTag();
        int m = n * i1 * paramInt + i;
        agjr localagjr;
        Object localObject;
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localagjr = (agjr)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          localagjm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localagjm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localagjr.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if ((localagjr.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
          {
            localObject = (URLDrawable)localagjr.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (((URLDrawable)localObject).getStatus() == 2) {
              ((URLDrawable)localObject).restartDownload();
            }
          }
          localagjm.jdField_a_of_type_AndroidWidgetTextView.setText(localagjr.jdField_a_of_type_JavaLangString);
          localagjm.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
          localagjm.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
          if (!TextUtils.isEmpty(localagjr.c))
          {
            localagjm.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            localObject = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10, String.valueOf(localagjr.c));
            if (localObject != null) {
              localagjm.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
            }
            localagjm.jdField_a_of_type_Int = localagjr.jdField_a_of_type_Int;
            localagjm.jdField_b_of_type_JavaLangString = localagjr.e;
            localagjm.jdField_a_of_type_JavaLangString = localagjr.d;
            localagjm.jdField_b_of_type_Int = localagjr.jdField_b_of_type_Int;
            localagjm.c = localagjr.c;
            localagjm.jdField_a_of_type_Boolean = localagjr.jdField_a_of_type_Boolean;
            localView.setContentDescription(localagjr.jdField_a_of_type_JavaLangString + anzj.a(2131706746));
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            localView.setEnabled(true);
            bhga.a(localView, true);
          }
        }
        for (;;)
        {
          bhga.a(localagjm.jdField_a_of_type_AndroidWidgetTextView, false);
          i += 1;
          k += 1;
          break;
          localObject = localagjm.jdField_b_of_type_AndroidWidgetImageView;
          if (localagjr.jdField_a_of_type_Boolean) {}
          for (m = 0;; m = 8)
          {
            ((ImageView)localObject).setVisibility(m);
            break;
          }
          localagjm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localagjm.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          localagjm.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
          localagjm.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          localagjm.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localagjm.jdField_a_of_type_Int = 0;
          localagjm.jdField_b_of_type_JavaLangString = "";
          localagjm.jdField_a_of_type_JavaLangString = "";
          localagjm.jdField_b_of_type_Int = 0;
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
  
  public List<agjr> a(int paramInt)
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
          agjl localagjl = (agjl)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localagjl != null) && (paramInt == localagjl.jdField_a_of_type_Int))
          {
            a(paramInt, localagjl);
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
  
  public void a(ArrayList<agjr> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    agjl localagjl = (agjl)paramObject;
    ((ViewGroup)paramView).removeView(localagjl);
    localagjl.a();
    this.jdField_a_of_type_Asrd.a((View)paramObject);
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
    if (((paramObject instanceof agjl)) && (((agjl)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    }
    agjl localagjl = (agjl)this.jdField_a_of_type_Asrd.a();
    Object localObject;
    if (localagjl != null)
    {
      localObject = localagjl.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localagjl.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_Asrd.a();
        localagjl = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localagjl;
      if (localagjl == null) {
        localObject = new agjl(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((agjl)localObject).a(paramInt);
      a(paramInt, (agjl)localObject);
      if ((((agjl)localObject).getParent() != paramView) && (paramInt < getCount())) {
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