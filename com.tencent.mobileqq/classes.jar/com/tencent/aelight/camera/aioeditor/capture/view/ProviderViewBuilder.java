package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderViewBuilder
{
  public static final int[] a;
  public static final int[] b = { 101, 2130849992, 2131374010 };
  public static final int[] c = { 102, 2130849991, 2131374009 };
  private int jdField_a_of_type_Int;
  private ArrayList<int[]> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 100, 2130849990, 2131374008 };
  }
  
  public ProviderViewBuilder(int paramInt, List<Integer> paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramInt = ((Integer)paramList.next()).intValue();
        if (paramInt == 100) {
          this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
        } else if (paramInt == 101) {
          this.jdField_a_of_type_JavaUtilArrayList.add(b);
        } else if (paramInt == 102) {
          this.jdField_a_of_type_JavaUtilArrayList.add(c);
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[1];
    }
    return 0;
  }
  
  public ProviderView a(Context paramContext, int paramInt)
  {
    if (paramInt != 100)
    {
      if (paramInt != 101)
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("bad id=");
          paramContext.append(paramInt);
          QLog.d("ProviderViewBuilder", 2, paramContext.toString());
        }
        paramContext = null;
      }
      else
      {
        paramContext = new StaticStickerProviderView(paramContext);
        paramContext.setId(2131364294);
      }
    }
    else
    {
      paramContext = new QIMFilterProviderView(paramContext);
      paramContext.setId(2131364288);
    }
    if (paramContext != null)
    {
      paramContext.setCaptureScene(this.jdField_a_of_type_Int);
      paramContext.setTabBarPosition(2);
      paramContext.d(231);
    }
    return paramContext;
  }
  
  public int b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[2];
    }
    return 0;
  }
  
  public int c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ProviderViewBuilder
 * JD-Core Version:    0.7.0.1
 */