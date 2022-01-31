package com.tencent.mobileqq.activity.aio;

import aepw;
import aepx;
import aepy;
import agps;
import alok;
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
import azqs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BabyQAIOPanel
  extends FrameLayout
  implements View.OnClickListener
{
  private aepy jdField_a_of_type_Aepy;
  private agps jdField_a_of_type_Agps;
  private Context jdField_a_of_type_AndroidContentContext;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<aepw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
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
    alok localalok = (alok)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
    int i;
    String str2;
    Object localObject1;
    String str1;
    Object localObject2;
    if ((localalok.jdField_a_of_type_JavaUtilHashMap != null) && (!localalok.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (localalok.jdField_a_of_type_JavaUtilArrayList != null) && (!localalok.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = localalok.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 1;
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = (String[])localalok.jdField_a_of_type_JavaUtilHashMap.get(str2);
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
        localObject1 = new aepw();
        ((aepw)localObject1).jdField_a_of_type_JavaLangString = str2;
        ((aepw)localObject1).jdField_a_of_type_Int = j;
        ((aepw)localObject1).jdField_a_of_type_Boolean = "1".equalsIgnoreCase((String)localObject2);
        ((aepw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = localalok.a(j);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("loadDatas | item.drawable is :");
          if (((aepw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            break label303;
          }
          str1 = "null";
          QLog.d("Q.BabyQ", 2, str1 + ", itemCode : " + j);
        }
        if (((aepw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
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
      if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690807)))
      {
        ((aepw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838966);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690804)))
      {
        ((aepw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838964);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690805)))
      {
        ((aepw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838965);
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
    aepw localaepw = new aepw();
    localaepw.jdField_a_of_type_Boolean = false;
    localaepw.jdField_a_of_type_Int = 1;
    localaepw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690804);
    localaepw.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838964);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaepw);
    localaepw = new aepw();
    localaepw.jdField_a_of_type_Boolean = false;
    localaepw.jdField_a_of_type_Int = 2;
    localaepw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690805);
    localaepw.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838965);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaepw);
    localaepw = new aepw();
    localaepw.jdField_a_of_type_Boolean = false;
    localaepw.jdField_a_of_type_Int = 3;
    localaepw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690807);
    localaepw.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838966);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaepw);
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_Aepy != null) {
      this.jdField_a_of_type_Aepy.notifyDataSetChanged();
    }
  }
  
  public void a(agps paramagps)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramagps.a();
    this.jdField_a_of_type_Agps = paramagps;
    setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165587));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131367311));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(2);
    b();
    this.jdField_a_of_type_Aepy = new aepy(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Aepy);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof aepx)))
    {
      paramView = (aepx)paramView.getTag();
      localObject = paramView.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_a_of_type_Agps.a.append((CharSequence)localObject);
      this.jdField_a_of_type_Agps.c();
      alok localalok = (alok)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if (localalok.a((String)localObject))
      {
        localalok.a((String)localObject);
        a();
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806D", "0X800806D", paramView.jdField_a_of_type_Int, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel
 * JD-Core Version:    0.7.0.1
 */