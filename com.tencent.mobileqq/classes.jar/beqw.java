import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class beqw
{
  private static int jdField_a_of_type_Int = 45;
  private static beqw jdField_a_of_type_Beqw;
  private static int jdField_b_of_type_Int = 135;
  private static boolean jdField_b_of_type_Boolean;
  private static int c = 45;
  private static int d = 135;
  private static int e = jdField_a_of_type_Int;
  private static int f = jdField_b_of_type_Int;
  private static int g = c;
  private static int h = d;
  public boolean a;
  
  public static int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a();
      if (paramBoolean1) {
        return h;
      }
      return f;
    }
    return besm.a(paramBoolean1);
  }
  
  public static beqw a()
  {
    if (jdField_a_of_type_Beqw == null) {}
    try
    {
      if (jdField_a_of_type_Beqw == null) {
        jdField_a_of_type_Beqw = new beqw();
      }
      return jdField_a_of_type_Beqw;
    }
    finally {}
  }
  
  public static void a()
  {
    a().b();
  }
  
  public static int b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a();
      if (paramBoolean1) {
        return g;
      }
      return e;
    }
    return besm.b(paramBoolean1);
  }
  
  public static int c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a();
      if (paramBoolean1) {
        return d;
      }
      return jdField_b_of_type_Int;
    }
    return besm.c(paramBoolean1);
  }
  
  public static int d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a();
      if (paramBoolean1) {
        return c;
      }
      return jdField_a_of_type_Int;
    }
    return besm.d(paramBoolean1);
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = jdField_b_of_type_Boolean;
        if (bool) {
          return;
        }
        float f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
        if (!this.jdField_a_of_type_Boolean)
        {
          arbj localarbj = arbi.a();
          if ((localarbj == null) || (!localarbj.jdField_a_of_type_Boolean)) {
            break label283;
          }
          jdField_a_of_type_Int = localarbj.c;
          jdField_b_of_type_Int = localarbj.jdField_b_of_type_Int;
          c = localarbj.e;
          d = localarbj.d;
          if (f1 > 0.0F)
          {
            i = (int)(jdField_a_of_type_Int * f1);
            e = i;
            if (f1 <= 0.0F) {
              break label262;
            }
            i = (int)(jdField_b_of_type_Int * f1);
            f = i;
            if (f1 <= 0.0F) {
              break label269;
            }
            i = (int)(c * f1);
            g = i;
            if (f1 <= 0.0F) {
              break label276;
            }
            i = (int)(d * f1);
            h = i;
            QLog.d("AIOImgThumbHelper", 1, new Object[] { "maxRatio:", Double.valueOf(localarbj.jdField_a_of_type_Double), ", minRatio:", Double.valueOf(localarbj.jdField_b_of_type_Double) });
          }
        }
        else
        {
          jdField_b_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AIOImgThumbHelper", 2, new Object[] { "thumbMax:", Integer.valueOf(f), ", thumbMin:", Integer.valueOf(h) });
          continue;
        }
        i = jdField_a_of_type_Int;
      }
      finally {}
      continue;
      label262:
      int i = jdField_b_of_type_Int;
      continue;
      label269:
      i = c;
      continue;
      label276:
      i = d;
      continue;
      label283:
      jdField_a_of_type_Int = besm.d(false);
      jdField_b_of_type_Int = besm.c(false);
      c = besm.d(true);
      d = besm.c(true);
      e = besm.b(false);
      f = besm.a(false);
      g = besm.b(true);
      h = besm.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqw
 * JD-Core Version:    0.7.0.1
 */