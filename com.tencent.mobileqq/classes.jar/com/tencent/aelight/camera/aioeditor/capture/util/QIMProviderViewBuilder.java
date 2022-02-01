package com.tencent.aelight.camera.aioeditor.capture.util;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.view.ComboProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.TransitionProviderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QIMProviderViewBuilder
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c;
  public static final int[] d;
  public static final int[] e;
  public static final int[] f;
  private int jdField_a_of_type_Int = 0;
  private ArrayList<int[]> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 106, 2130849985, 2130849985, 2131373981 };
    jdField_b_of_type_ArrayOfInt = new int[] { 101, 2130849986, 2130849986, 2131373982 };
    jdField_c_of_type_ArrayOfInt = new int[] { 103, 2130849988, 2130849988, 2131373984 };
    jdField_d_of_type_ArrayOfInt = new int[] { 104, 2130849987, 2130849987, 2131373983 };
    jdField_e_of_type_ArrayOfInt = new int[] { 108, 2064056675, 2064056675, 2131373986 };
    jdField_f_of_type_ArrayOfInt = new int[] { 104 };
  }
  
  public QIMProviderViewBuilder(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
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
    if (paramInt != 101)
    {
      if (paramInt != 106)
      {
        if (paramInt != 108)
        {
          if (paramInt != 103)
          {
            if (paramInt != 104)
            {
              if (QLog.isColorLevel())
              {
                paramContext = new StringBuilder();
                paramContext.append("bad id=");
                paramContext.append(paramInt);
                QLog.d("ProviderViewBuilder", 2, paramContext.toString());
              }
            }
            else if (this.jdField_f_of_type_Boolean)
            {
              paramContext = new MusicProviderView(paramContext);
              paramContext.setId(2131364293);
              break label177;
            }
          }
          else
          {
            paramContext = new StaticStickerProviderView(paramContext);
            paramContext.setId(2131364294);
            break label177;
          }
        }
        else
        {
          paramContext = new TransitionProviderView(paramContext);
          break label177;
        }
      }
      else if (this.jdField_e_of_type_Boolean)
      {
        paramContext = new ComboProviderView(paramContext);
        paramContext.setId(2131364287);
        break label177;
      }
    }
    else if (this.jdField_c_of_type_Boolean)
    {
      paramContext = new QIMFilterProviderView(paramContext);
      paramContext.setId(2131364288);
      break label177;
    }
    paramContext = null;
    label177:
    if (paramContext != null)
    {
      paramContext.setCaptureScene(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int == 0)
      {
        paramContext.setTabBarPosition(2);
        paramContext.d(206);
        return paramContext;
      }
      paramContext.setTabBarPosition(1);
      if (paramContext.e())
      {
        paramContext.d(213);
        return paramContext;
      }
      paramContext.d(249);
    }
    return paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            break label100;
          }
          if (i != 4) {
            return;
          }
        }
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
        return;
      }
      label100:
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
      }
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
      }
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
      }
      if (this.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      paramInt = ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
      if (paramInt == 101)
      {
        VideoFilterTools.a().a(1, 0, "");
        return;
      }
      if (paramInt == 106) {
        VideoFilterTools.a().a(6, 0, "");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateRedDotHasShow failed out bounds");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" size:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.e("ProviderViewBuilder", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size()) {
        return false;
      }
      paramInt = ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
      if (paramInt == 101) {
        return VideoFilterTools.a(1, 0, "");
      }
      if (paramInt == 106) {
        return VideoFilterTools.a(6, 0, "");
      }
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[2];
    }
    return 0;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b(int paramInt)
  {
    int[] arrayOfInt = jdField_f_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public int c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
    }
    return -1;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.QIMProviderViewBuilder
 * JD-Core Version:    0.7.0.1
 */