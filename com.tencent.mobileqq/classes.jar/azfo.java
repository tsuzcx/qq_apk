import android.os.Build;
import com.tencent.qphone.base.util.QLog;

public class azfo
{
  public static String[] a = { "Le X620", "Nexus 5X", "ZTE A2017", "PRA-AL00X", "SM-W2015", "Redmi Note 3", "R7Plus", "vivo X6Plus A" };
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceDanceEntryUtil", 2, "isPhoneInBlackList ： phone = " + str + ", result=" + bool1);
        }
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (azfz.g())
    {
      bool1 = bool3;
      if (!a())
      {
        if (!lsa.a(8, 1400000L))
        {
          bool1 = bool2;
          if (!lsa.a(4, 2150000L)) {}
        }
        else
        {
          bool1 = true;
        }
        QLog.d("FaceDanceEntryUtil", 2, "FaceDanceEntryUtil check condition 2 +cpuNumber is" + bool1);
      }
    }
    return bool1;
  }
  
  public static boolean c()
  {
    return (b()) && (azbx.a().e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfo
 * JD-Core Version:    0.7.0.1
 */