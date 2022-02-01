package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.util.AttributeSet;
import bclx;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tjf;
import upe;
import uvd;
import uve;

public class WSTabLayout
  extends TabLayoutCompat
{
  public static float c = bclx.a(22.0F);
  public static float d = bclx.a(15.0F);
  public static float e = bclx.a(2.0F);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private uvd jdField_a_of_type_Uvd;
  
  public WSTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WSTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WSTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private static boolean b(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.0E-013D;
  }
  
  private void c()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  public void a(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("WSTabLayout2", 2, "createTab infos: null");
      }
      upe.a("WSTabLayout2", "initData list: null");
    }
    label196:
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      a();
      label76:
      int i;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 3)
      {
        setTabMode(1);
        setTabGravity(0);
        i = 0;
      }
      for (;;)
      {
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label196;
        }
        paramList = a();
        if (paramList == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("WSTabLayout2", 2, "createTab newTab: null");
          return;
          setTabMode(0);
          setTabGravity(1);
          break label76;
        }
        paramList.a(2131560010);
        uve localuve = new uve(this, paramList.a());
        localuve.a(i);
        paramList.a(localuve);
        localuve.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        d(paramList);
        if (paramInt == i) {
          localuve.a();
        }
        i += 1;
      }
    }
  }
  
  public void setTabContentClickListener(uvd paramuvd)
  {
    this.jdField_a_of_type_Uvd = paramuvd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout
 * JD-Core Version:    0.7.0.1
 */