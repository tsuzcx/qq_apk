import android.content.Context;
import com.tencent.mobileqq.richmedia.capture.view.BeautyProviderView;
import com.tencent.mobileqq.richmedia.capture.view.FilterProviderView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateProviderView;
import com.tencent.mobileqq.richmedia.capture.view.SubtitleProviderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class avtn
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c;
  public static final int[] d;
  private int jdField_a_of_type_Int = 0;
  private ArrayList<int[]> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 101, 2130845079 };
    jdField_b_of_type_ArrayOfInt = new int[] { 102, 2130845082 };
    jdField_c_of_type_ArrayOfInt = new int[] { 103, 2130845078 };
    jdField_d_of_type_ArrayOfInt = new int[] { 104, 2130845085 };
  }
  
  public avtn(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return -1;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
  }
  
  public ProviderView a(Context paramContext, int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramContext = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ProviderViewBuilder", 2, "bad id=" + paramInt);
        paramContext = localObject;
      }
      break;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        if (this.jdField_a_of_type_Int != 0) {
          break;
        }
        paramContext.setTabBarPosition(2);
      }
      return paramContext;
      paramContext = new FilterProviderView(paramContext, this.jdField_a_of_type_Int);
      paramContext.setId(2131363883);
      continue;
      paramContext = new PtvTemplateProviderView(paramContext);
      continue;
      paramContext = new BeautyProviderView(paramContext);
      continue;
      paramContext = new SubtitleProviderView(paramContext);
    }
    paramContext.setTabBarPosition(1);
    if (paramContext.a())
    {
      paramContext.b(213);
      return paramContext;
    }
    paramContext.b(249);
    return paramContext;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    do
    {
      return;
      paramInt = ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
      if (paramInt == 101)
      {
        avsf.a().a(1, 0, "");
        return;
      }
    } while (paramInt != 102);
    avrv.a().a(1, 0, "");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avtn
 * JD-Core Version:    0.7.0.1
 */