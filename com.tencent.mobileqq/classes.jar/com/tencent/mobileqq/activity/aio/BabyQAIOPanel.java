package com.tencent.mobileqq.activity.aio;

import agfw;
import agfx;
import agfy;
import aijm;
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
import antk;
import bdll;
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
  private agfy jdField_a_of_type_Agfy;
  private aijm jdField_a_of_type_Aijm;
  private Context jdField_a_of_type_AndroidContentContext;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<agfw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
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
    antk localantk = (antk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
    int i;
    String str2;
    Object localObject1;
    String str1;
    Object localObject2;
    if ((localantk.jdField_a_of_type_JavaUtilHashMap != null) && (!localantk.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (localantk.jdField_a_of_type_JavaUtilArrayList != null) && (!localantk.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = localantk.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 1;
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = (String[])localantk.jdField_a_of_type_JavaUtilHashMap.get(str2);
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
        localObject1 = new agfw();
        ((agfw)localObject1).jdField_a_of_type_JavaLangString = str2;
        ((agfw)localObject1).jdField_a_of_type_Int = j;
        ((agfw)localObject1).jdField_a_of_type_Boolean = "1".equalsIgnoreCase((String)localObject2);
        ((agfw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = localantk.a(j);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("loadDatas | item.drawable is :");
          if (((agfw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            break label303;
          }
          str1 = "null";
          QLog.d("Q.BabyQ", 2, str1 + ", itemCode : " + j);
        }
        if (((agfw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
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
      if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690674)))
      {
        ((agfw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839140);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690672)))
      {
        ((agfw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839138);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690673)))
      {
        ((agfw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839139);
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
    agfw localagfw = new agfw();
    localagfw.jdField_a_of_type_Boolean = false;
    localagfw.jdField_a_of_type_Int = 1;
    localagfw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690672);
    localagfw.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839138);
    this.jdField_a_of_type_JavaUtilArrayList.add(localagfw);
    localagfw = new agfw();
    localagfw.jdField_a_of_type_Boolean = false;
    localagfw.jdField_a_of_type_Int = 2;
    localagfw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690673);
    localagfw.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839139);
    this.jdField_a_of_type_JavaUtilArrayList.add(localagfw);
    localagfw = new agfw();
    localagfw.jdField_a_of_type_Boolean = false;
    localagfw.jdField_a_of_type_Int = 3;
    localagfw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690674);
    localagfw.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839140);
    this.jdField_a_of_type_JavaUtilArrayList.add(localagfw);
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_Agfy != null) {
      this.jdField_a_of_type_Agfy.notifyDataSetChanged();
    }
  }
  
  public void a(aijm paramaijm)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramaijm.a();
    this.jdField_a_of_type_Aijm = paramaijm;
    setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165623));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131367686));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(2);
    b();
    this.jdField_a_of_type_Agfy = new agfy(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Agfy);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof agfx)))
    {
      localObject = (agfx)paramView.getTag();
      String str = ((agfx)localObject).jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_a_of_type_Aijm.a.append(str);
      this.jdField_a_of_type_Aijm.c();
      antk localantk = (antk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if (localantk.a(str))
      {
        localantk.a(str);
        a();
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806D", "0X800806D", ((agfx)localObject).jdField_a_of_type_Int, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel
 * JD-Core Version:    0.7.0.1
 */