package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BundleCompat$BundleCompatBaseImpl
{
  private static final String TAG = "BundleCompatBaseImpl";
  private static Method sGetIBinderMethod;
  private static boolean sGetIBinderMethodFetched;
  private static Method sPutIBinderMethod;
  private static boolean sPutIBinderMethodFetched;
  
  public static IBinder getBinder(Bundle paramBundle, String paramString)
  {
    if (!sGetIBinderMethodFetched)
    {
      try
      {
        sGetIBinderMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
        sGetIBinderMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", localNoSuchMethodException);
      }
      sGetIBinderMethodFetched = true;
    }
    Method localMethod = sGetIBinderMethod;
    if (localMethod != null)
    {
      try
      {
        paramBundle = (IBinder)localMethod.invoke(paramBundle, new Object[] { paramString });
        return paramBundle;
      }
      catch (IllegalArgumentException paramBundle) {}catch (IllegalAccessException paramBundle) {}catch (InvocationTargetException paramBundle) {}
      Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", paramBundle);
      sGetIBinderMethod = null;
    }
    return null;
  }
  
  public static void putBinder(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    if (!sPutIBinderMethodFetched)
    {
      try
      {
        sPutIBinderMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
        sPutIBinderMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", localNoSuchMethodException);
      }
      sPutIBinderMethodFetched = true;
    }
    Method localMethod = sPutIBinderMethod;
    if (localMethod != null)
    {
      try
      {
        localMethod.invoke(paramBundle, new Object[] { paramString, paramIBinder });
        return;
      }
      catch (IllegalArgumentException paramBundle) {}catch (IllegalAccessException paramBundle) {}catch (InvocationTargetException paramBundle) {}
      Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", paramBundle);
      sPutIBinderMethod = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.BundleCompat.BundleCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */