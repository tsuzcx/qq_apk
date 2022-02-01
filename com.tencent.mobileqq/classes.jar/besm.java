import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class besm
{
  private static int jdField_a_of_type_Int = 45;
  private static besm jdField_a_of_type_Besm;
  private static boolean jdField_a_of_type_Boolean;
  private static int b = 135;
  private static int c = 45;
  private static int d = 135;
  private static int e = jdField_a_of_type_Int;
  private static int f = b;
  private static int g = c;
  private static int h = d;
  
  public static int a(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return h;
    }
    return f;
  }
  
  public static besm a()
  {
    if (jdField_a_of_type_Besm == null) {}
    try
    {
      if (jdField_a_of_type_Besm == null) {
        jdField_a_of_type_Besm = new besm();
      }
      return jdField_a_of_type_Besm;
    }
    finally {}
  }
  
  public static void a()
  {
    a().b();
  }
  
  public static int b(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return g;
    }
    return e;
  }
  
  public static int c(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return d;
    }
    return b;
  }
  
  public static int d(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return c;
    }
    return jdField_a_of_type_Int;
  }
  
  public DeviceProfileManager a()
  {
    return DeviceProfileManager.a();
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        String[] arrayOfString = a().a(DeviceProfileManager.DpcNames.aio_pic_thumb_size.name(), "135|135").split("\\|");
        if (arrayOfString.length == 2)
        {
          i = Integer.valueOf(arrayOfString[0]).intValue();
          if ((i >= 45) && (i <= 198)) {
            b = i;
          }
          i = Integer.valueOf(arrayOfString[1]).intValue();
          if ((i >= 45) && (i <= 198)) {
            d = i;
          }
        }
        float f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
        f = (int)(b * f1);
        h = (int)(d * f1);
        e = (int)(jdField_a_of_type_Int * f1);
        g = (int)(f1 * c);
        if (f == 0)
        {
          i = b;
          f = i;
          if (h != 0) {
            break label272;
          }
          i = d;
          h = i;
          if (e != 0) {
            break label279;
          }
          i = jdField_a_of_type_Int;
          e = i;
          if (g != 0) {
            break label286;
          }
          i = c;
          g = i;
          jdField_a_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CommonImgThumbHelper", 2, new Object[] { "thumbMax:", Integer.valueOf(f), ", thumbMin:", Integer.valueOf(h) });
          continue;
        }
        i = f;
      }
      finally {}
      continue;
      label272:
      int i = h;
      continue;
      label279:
      i = e;
      continue;
      label286:
      i = g;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besm
 * JD-Core Version:    0.7.0.1
 */