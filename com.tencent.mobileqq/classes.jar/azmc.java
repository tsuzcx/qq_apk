import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class azmc
{
  private static final SparseArray<int[]> a = new SparseArray();
  private static final SparseArray<azlu> b = new SparseArray();
  
  static
  {
    a.put(101, ahpt.jdField_a_of_type_ArrayOfInt);
    a.put(105, ahpt.e);
    a.put(102, ahpt.l);
    a.put(103, ahpt.s);
    a.put(106, ahpt.w);
    a.put(104, ahpt.B);
  }
  
  private static int a(List<azlu> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((((azlu)paramList.get(i)).jdField_d_of_type_Int == 5) || (((azlu)paramList.get(i)).jdField_d_of_type_Int == 6)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static azlu a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public static azlu a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = (azlu)b.get(paramInt);
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (azlt)aqxe.a().a(496);
        if (localObject != null)
        {
          List localList = ((azlt)localObject).a;
          if (localList.size() > 0)
          {
            int i = 0;
            for (;;)
            {
              if (i >= localList.size()) {
                break label133;
              }
              localObject = (azlu)localList.get(i);
              int[] arrayOfInt = (int[])a.get(((azlu)localObject).jdField_a_of_type_Int);
              if (arrayOfInt != null)
              {
                int j = arrayOfInt[0];
                if (paramInt == j) {
                  break;
                }
              }
              i += 1;
            }
          }
        }
        return null;
      }
      catch (Exception localException)
      {
        QLog.e("PlusPanelUtil", 1, localException, new Object[0]);
      }
    }
  }
  
  public static List<azlu> a(boolean paramBoolean, Context paramContext)
  {
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        Object localObject = (azlt)aqxe.a().a(496);
        if (localObject != null)
        {
          localObject = ((azlt)localObject).a;
          if (((List)localObject).size() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            if (i < ((List)localObject).size())
            {
              azlu localazlu = (azlu)((List)localObject).get(i);
              arrayOfInt = (int[])a.get(localazlu.jdField_a_of_type_Int);
              if (arrayOfInt != null) {
                break label215;
              }
              b.put(localazlu.jdField_a_of_type_Int, localazlu);
              j = 1;
              if (j == 0) {
                break label220;
              }
              k = localazlu.jdField_a_of_type_Int;
              localazlu.jdField_d_of_type_Int = k;
              localazlu.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localazlu.a();
              localazlu.b = localazlu.b();
              if (j == 0) {
                break label229;
              }
              j = 0;
              localazlu.e = j;
              localazlu.jdField_a_of_type_ArrayOfInt = arrayOfInt;
              localArrayList.add(localazlu);
              i += 1;
              continue;
            }
            a(localArrayList);
            a(localArrayList, paramContext);
            return localArrayList;
          }
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("PlusPanelUtil", 1, paramContext, new Object[0]);
      }
      return new ArrayList();
      label215:
      int j = 0;
      continue;
      label220:
      int k = arrayOfInt[0];
      continue;
      label229:
      j = arrayOfInt[3];
    }
  }
  
  private static void a(List<azlu> paramList)
  {
    Collections.sort(paramList);
  }
  
  private static void a(List<azlu> paramList, Context paramContext)
  {
    int i = a(paramList);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PlusPanelUtil", 2, "did not have camera icon");
      }
      return;
    }
    int[] arrayOfInt = ahpt.v;
    azlu localazlu = new azlu();
    localazlu.jdField_d_of_type_Int = 6;
    localazlu.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(arrayOfInt[1]);
    localazlu.e = arrayOfInt[3];
    localazlu.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    if (ShortVideoUtils.needTwoEntrance())
    {
      localazlu.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(arrayOfInt[2]);
      paramList.add(i, localazlu);
      return;
    }
    a.put(103, ahpt.v);
    localazlu.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(ahpt.s[2]);
    paramList.set(i, localazlu);
  }
  
  public static int[] a(int paramInt)
  {
    if (a != null) {
      return (int[])a.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmc
 * JD-Core Version:    0.7.0.1
 */