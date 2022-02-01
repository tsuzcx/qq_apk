package com.tencent.mobileqq.activity.aio;

import aeyq;
import aeyr;
import aeys;
import afiw;
import amoa;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import bcef;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BabyQAIOPanel
  extends FrameLayout
  implements View.OnClickListener
{
  private aeys jdField_a_of_type_Aeys;
  private afiw jdField_a_of_type_Afiw;
  private Context jdField_a_of_type_AndroidContentContext;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<aeyq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public BabyQAIOPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public BabyQAIOPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    amoa localamoa = (amoa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(53);
    int i;
    String str2;
    Object localObject1;
    String str1;
    Object localObject2;
    if ((localamoa.jdField_a_of_type_JavaUtilHashMap != null) && (!localamoa.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (localamoa.jdField_a_of_type_JavaUtilArrayList != null) && (!localamoa.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = localamoa.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 1;
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = (String[])localamoa.jdField_a_of_type_JavaUtilHashMap.get(str2);
          if ((localObject1 != null) && (localObject1.length == 2))
          {
            str1 = localObject1[0];
            localObject2 = localObject1[1];
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        int j = Integer.parseInt(str1);
        localObject1 = new aeyq();
        ((aeyq)localObject1).jdField_a_of_type_JavaLangString = str2;
        ((aeyq)localObject1).jdField_a_of_type_Int = j;
        ((aeyq)localObject1).jdField_a_of_type_Boolean = "1".equalsIgnoreCase((String)localObject2);
        ((aeyq)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = localamoa.a(j);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("loadDatas | item.drawable is :");
          if (((aeyq)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            break label303;
          }
          str1 = "null";
          QLog.d("Q.BabyQ", 2, str1 + ", itemCode : " + j);
        }
        if (((aeyq)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          break label309;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.BabyQ", 2, "initDatas|get item code error :  " + str1);
      break;
      label303:
      str1 = "not null";
      continue;
      label309:
      if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690714)))
      {
        ((aeyq)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839175);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690712)))
      {
        ((aeyq)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839173);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690713)))
      {
        ((aeyq)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839174);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
        continue;
        if (i != 0) {
          c();
        }
        return;
        c();
        return;
      }
    }
  }
  
  private void c()
  {
    aeyq localaeyq = new aeyq();
    localaeyq.jdField_a_of_type_Boolean = false;
    localaeyq.jdField_a_of_type_Int = 1;
    localaeyq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690712);
    localaeyq.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839173);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaeyq);
    localaeyq = new aeyq();
    localaeyq.jdField_a_of_type_Boolean = false;
    localaeyq.jdField_a_of_type_Int = 2;
    localaeyq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690713);
    localaeyq.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839174);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaeyq);
    localaeyq = new aeyq();
    localaeyq.jdField_a_of_type_Boolean = false;
    localaeyq.jdField_a_of_type_Int = 3;
    localaeyq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690714);
    localaeyq.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839175);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaeyq);
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_Aeys != null) {
      this.jdField_a_of_type_Aeys.notifyDataSetChanged();
    }
  }
  
  public void a(afiw paramafiw)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramafiw.getApp();
    this.jdField_a_of_type_Afiw = paramafiw;
    setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165631));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131367718));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(2);
    b();
    this.jdField_a_of_type_Aeys = new aeys(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Aeys);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof aeyr)))
    {
      localObject = (aeyr)paramView.getTag();
      String str = ((aeyr)localObject).jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_a_of_type_Afiw.input.append(str);
      this.jdField_a_of_type_Afiw.send();
      amoa localamoa = (amoa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(53);
      if (localamoa.a(str))
      {
        localamoa.a(str);
        a();
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806D", "0X800806D", ((aeyr)localObject).jdField_a_of_type_Int, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel
 * JD-Core Version:    0.7.0.1
 */