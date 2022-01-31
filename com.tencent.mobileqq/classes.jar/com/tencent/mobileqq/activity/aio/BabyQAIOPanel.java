package com.tencent.mobileqq.activity.aio;

import actx;
import acty;
import actz;
import aeom;
import ajsi;
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
import axqy;
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
  private actz jdField_a_of_type_Actz;
  private aeom jdField_a_of_type_Aeom;
  private Context jdField_a_of_type_AndroidContentContext;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<actx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
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
    ajsi localajsi = (ajsi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
    int i;
    String str2;
    Object localObject1;
    String str1;
    Object localObject2;
    if ((localajsi.jdField_a_of_type_JavaUtilHashMap != null) && (!localajsi.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (localajsi.jdField_a_of_type_JavaUtilArrayList != null) && (!localajsi.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = localajsi.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 1;
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = (String[])localajsi.jdField_a_of_type_JavaUtilHashMap.get(str2);
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
        localObject1 = new actx();
        ((actx)localObject1).jdField_a_of_type_JavaLangString = str2;
        ((actx)localObject1).jdField_a_of_type_Int = j;
        ((actx)localObject1).jdField_a_of_type_Boolean = "1".equalsIgnoreCase((String)localObject2);
        ((actx)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = localajsi.a(j);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("loadDatas | item.drawable is :");
          if (((actx)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            break label303;
          }
          str1 = "null";
          QLog.d("Q.BabyQ", 2, str1 + ", itemCode : " + j);
        }
        if (((actx)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
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
      if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690755)))
      {
        ((actx)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838862);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690752)))
      {
        ((actx)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838860);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690753)))
      {
        ((actx)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838861);
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
    actx localactx = new actx();
    localactx.jdField_a_of_type_Boolean = false;
    localactx.jdField_a_of_type_Int = 1;
    localactx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690752);
    localactx.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838860);
    this.jdField_a_of_type_JavaUtilArrayList.add(localactx);
    localactx = new actx();
    localactx.jdField_a_of_type_Boolean = false;
    localactx.jdField_a_of_type_Int = 2;
    localactx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690753);
    localactx.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838861);
    this.jdField_a_of_type_JavaUtilArrayList.add(localactx);
    localactx = new actx();
    localactx.jdField_a_of_type_Boolean = false;
    localactx.jdField_a_of_type_Int = 3;
    localactx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690755);
    localactx.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130838862);
    this.jdField_a_of_type_JavaUtilArrayList.add(localactx);
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_Actz != null) {
      this.jdField_a_of_type_Actz.notifyDataSetChanged();
    }
  }
  
  public void a(aeom paramaeom)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramaeom.a();
    this.jdField_a_of_type_Aeom = paramaeom;
    setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165551));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131367171));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(2);
    b();
    this.jdField_a_of_type_Actz = new actz(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Actz);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof acty)))
    {
      paramView = (acty)paramView.getTag();
      localObject = paramView.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_a_of_type_Aeom.a.append((CharSequence)localObject);
      this.jdField_a_of_type_Aeom.c();
      ajsi localajsi = (ajsi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if (localajsi.a((String)localObject))
      {
        localajsi.a((String)localObject);
        a();
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806D", "0X800806D", paramView.jdField_a_of_type_Int, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel
 * JD-Core Version:    0.7.0.1
 */