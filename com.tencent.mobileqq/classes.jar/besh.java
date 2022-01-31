import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;

public class besh
{
  private static Boolean a;
  
  public static boolean a()
  {
    if (a == null) {
      if (Build.VERSION.SDK_INT >= 21) {
        break label28;
      }
    }
    for (a = Boolean.valueOf(false);; a = Boolean.valueOf(Process.is64Bit()))
    {
      return a.booleanValue();
      label28:
      if (Build.VERSION.SDK_INT < 23) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = BaseApplicationImpl.getContext().getClassLoader();
        localObject = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class }).invoke(localObject, new Object[] { "art" });
        if ((localObject == null) || (!((String)localObject).contains("lib64"))) {
          break label124;
        }
        bool = true;
        a = Boolean.valueOf(bool);
      }
      catch (Throwable localThrowable)
      {
        a = Boolean.valueOf(false);
      }
      break;
      label124:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besh
 * JD-Core Version:    0.7.0.1
 */