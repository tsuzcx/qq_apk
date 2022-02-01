package com.tencent.mobileqq.activity.aio;

import afqc;
import afqd;
import afqe;
import agab;
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
import anqn;
import bdla;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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
  private afqe jdField_a_of_type_Afqe;
  private agab jdField_a_of_type_Agab;
  private Context jdField_a_of_type_AndroidContentContext;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<afqc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
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
    anqn localanqn = (anqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
    int i;
    String str2;
    Object localObject1;
    String str1;
    Object localObject2;
    if ((localanqn.jdField_a_of_type_JavaUtilHashMap != null) && (!localanqn.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (localanqn.jdField_a_of_type_JavaUtilArrayList != null) && (!localanqn.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = localanqn.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 1;
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = (String[])localanqn.jdField_a_of_type_JavaUtilHashMap.get(str2);
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
        localObject1 = new afqc();
        ((afqc)localObject1).jdField_a_of_type_JavaLangString = str2;
        ((afqc)localObject1).jdField_a_of_type_Int = j;
        ((afqc)localObject1).jdField_a_of_type_Boolean = "1".equalsIgnoreCase((String)localObject2);
        ((afqc)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = localanqn.a(j);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("loadDatas | item.drawable is :");
          if (((afqc)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            break label304;
          }
          str1 = "null";
          QLog.d("Q.BabyQ", 2, str1 + ", itemCode : " + j);
        }
        if (((afqc)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          break label310;
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
      label304:
      str1 = "not null";
      continue;
      label310:
      if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690791)))
      {
        ((afqc)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839195);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690789)))
      {
        ((afqc)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839193);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690790)))
      {
        ((afqc)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839194);
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
    afqc localafqc = new afqc();
    localafqc.jdField_a_of_type_Boolean = false;
    localafqc.jdField_a_of_type_Int = 1;
    localafqc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690789);
    localafqc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839193);
    this.jdField_a_of_type_JavaUtilArrayList.add(localafqc);
    localafqc = new afqc();
    localafqc.jdField_a_of_type_Boolean = false;
    localafqc.jdField_a_of_type_Int = 2;
    localafqc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690790);
    localafqc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839194);
    this.jdField_a_of_type_JavaUtilArrayList.add(localafqc);
    localafqc = new afqc();
    localafqc.jdField_a_of_type_Boolean = false;
    localafqc.jdField_a_of_type_Int = 3;
    localafqc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690791);
    localafqc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839195);
    this.jdField_a_of_type_JavaUtilArrayList.add(localafqc);
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_Afqe != null) {
      this.jdField_a_of_type_Afqe.notifyDataSetChanged();
    }
  }
  
  public void a(agab paramagab)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramagab.getApp();
    this.jdField_a_of_type_Agab = paramagab;
    setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165637));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131367854));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(2);
    b();
    this.jdField_a_of_type_Afqe = new afqe(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Afqe);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof afqd)))
    {
      localObject = (afqd)paramView.getTag();
      String str = ((afqd)localObject).jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_a_of_type_Agab.input.append(str);
      this.jdField_a_of_type_Agab.send();
      anqn localanqn = (anqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (localanqn.a(str))
      {
        localanqn.a(str);
        a();
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806D", "0X800806D", ((afqd)localObject).jdField_a_of_type_Int, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel
 * JD-Core Version:    0.7.0.1
 */