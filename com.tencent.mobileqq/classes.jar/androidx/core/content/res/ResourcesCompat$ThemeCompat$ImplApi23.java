package androidx.core.content.res;

import android.content.res.Resources.Theme;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(23)
class ResourcesCompat$ThemeCompat$ImplApi23
{
  private static Method sRebaseMethod;
  private static boolean sRebaseMethodFetched;
  private static final Object sRebaseMethodLock = new Object();
  
  static void rebase(@NonNull Resources.Theme paramTheme)
  {
    synchronized (sRebaseMethodLock)
    {
      boolean bool = sRebaseMethodFetched;
      if (!bool)
      {
        try
        {
          sRebaseMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
          sRebaseMethod.setAccessible(true);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.i("ResourcesCompat", "Failed to retrieve rebase() method", localNoSuchMethodException);
        }
        sRebaseMethodFetched = true;
      }
      Method localMethod = sRebaseMethod;
      if (localMethod != null)
      {
        try
        {
          sRebaseMethod.invoke(paramTheme, new Object[0]);
        }
        catch (InvocationTargetException paramTheme) {}catch (IllegalAccessException paramTheme) {}
        Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", paramTheme);
        sRebaseMethod = null;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.res.ResourcesCompat.ThemeCompat.ImplApi23
 * JD-Core Version:    0.7.0.1
 */