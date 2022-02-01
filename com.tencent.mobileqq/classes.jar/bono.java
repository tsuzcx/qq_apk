import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ComboProviderView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.QIMPtvTemplateProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.qq.im.capture.view.TransitionProviderView;
import java.util.ArrayList;

public class bono
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c;
  public static final int[] d;
  public static final int[] e;
  public static final int[] f;
  public static final int[] g = { 108, 2130844492, 2130844492, 2131374120 };
  public static final int[] h = { 104 };
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
    jdField_a_of_type_ArrayOfInt = new int[] { 106, 2130849663, 2130849663, 2131374115 };
    jdField_b_of_type_ArrayOfInt = new int[] { 101, 2130849664, 2130849664, 2131374116 };
    jdField_c_of_type_ArrayOfInt = new int[] { 102, 2130849666, 2130849666, 2131374119 };
    jdField_d_of_type_ArrayOfInt = new int[] { 103, 2130849667, 2130849667, 2131374118 };
    jdField_e_of_type_ArrayOfInt = new int[] { 104, 2130849665, 2130849665, 2131374117 };
    jdField_f_of_type_ArrayOfInt = new int[] { 105, 2130849662, 2130849662, 2131374114 };
  }
  
  public bono(int paramInt)
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
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[1];
  }
  
  public ProviderView a(Context paramContext, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    switch (paramInt)
    {
    case 107: 
    default: 
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ProviderViewBuilder", 2, "bad id=" + paramInt);
        localObject1 = localObject2;
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((ProviderView)localObject1).setCaptureScene(this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Int != 0) {
          break;
        }
        ((ProviderView)localObject1).setTabBarPosition(2);
        ((ProviderView)localObject1).d(206);
      }
      return localObject1;
      localObject1 = localObject2;
      if (this.jdField_e_of_type_Boolean)
      {
        localObject1 = new ComboProviderView(paramContext);
        ((ProviderView)localObject1).setId(2131364283);
        continue;
        localObject1 = localObject2;
        if (this.jdField_c_of_type_Boolean)
        {
          localObject1 = new QIMFilterProviderView(paramContext);
          ((ProviderView)localObject1).setId(2131364285);
          continue;
          localObject1 = new StaticStickerProviderView(paramContext);
          ((ProviderView)localObject1).setId(2131364294);
          continue;
          localObject1 = new QIMPtvTemplateProviderView(paramContext);
          continue;
          localObject1 = localObject2;
          if (this.jdField_f_of_type_Boolean)
          {
            localObject1 = new MusicProviderView(paramContext);
            ((ProviderView)localObject1).setId(2131364293);
            continue;
            localObject1 = localObject2;
            if (this.jdField_b_of_type_Boolean)
            {
              localObject1 = new AdvancedProviderView(paramContext);
              ((ProviderView)localObject1).setNeedTabBar(false);
              continue;
              localObject1 = new TransitionProviderView(paramContext);
            }
          }
        }
      }
    }
    ((ProviderView)localObject1).setTabBarPosition(1);
    if (((ProviderView)localObject1).e())
    {
      ((ProviderView)localObject1).d(213);
      return localObject1;
    }
    ((ProviderView)localObject1).d(249);
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
    case 1: 
    case 3: 
      do
      {
        do
        {
          do
          {
            return;
          } while (!this.jdField_a_of_type_Boolean);
          if (this.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
          }
          if (this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_JavaUtilArrayList.add(jdField_f_of_type_ArrayOfInt);
          }
          if (this.jdField_c_of_type_Boolean) {
            this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
          }
          if (this.jdField_f_of_type_Boolean) {
            this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
          }
        } while (!this.jdField_e_of_type_Boolean);
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
        return;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
    this.jdField_a_of_type_JavaUtilArrayList.add(g);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      if (QLog.isColorLevel()) {
        QLog.e("ProviderViewBuilder", 2, "updateRedDotHasShow failed out bounds" + paramInt + " size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    do
    {
      return;
      paramInt = ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
      if (paramInt == 101)
      {
        bpjt.a().a(1, 0, "");
        return;
      }
    } while (paramInt != 106);
    bpjt.a().a(6, 0, "");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return false;
    }
    paramInt = ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
    if (paramInt == 101) {
      return bpjt.a(1, 0, "");
    }
    if (paramInt == 106) {
      return bpjt.a(6, 0, "");
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[2];
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = h;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public int c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return -1;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public int d(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (paramInt == ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0]) {
        return i;
      }
      i += 1;
    }
    return 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bono
 * JD-Core Version:    0.7.0.1
 */