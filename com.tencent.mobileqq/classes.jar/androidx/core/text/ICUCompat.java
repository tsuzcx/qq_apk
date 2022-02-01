package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat
{
  private static final String TAG = "ICUCompat";
  private static Method sAddLikelySubtagsMethod;
  private static Method sGetScriptMethod;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while (Build.VERSION.SDK_INT >= 24) {
      try
      {
        Class localClass = Class.forName("libcore.icu.ICU");
        if (localClass != null)
        {
          sGetScriptMethod = localClass.getMethod("getScript", new Class[] { String.class });
          sAddLikelySubtagsMethod = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
        }
        return;
      }
      catch (Exception localException1)
      {
        sGetScriptMethod = null;
        sAddLikelySubtagsMethod = null;
        Log.w("ICUCompat", localException1);
        return;
      }
    }
    try
    {
      sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[] { Locale.class });
      return;
    }
    catch (Exception localException2)
    {
      throw new IllegalStateException(localException2);
    }
  }
  
  private static String addLikelySubtags(Locale paramLocale)
  {
    paramLocale = paramLocale.toString();
    try
    {
      if (sAddLikelySubtagsMethod != null)
      {
        String str = (String)sAddLikelySubtagsMethod.invoke(null, new Object[] { paramLocale });
        return str;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.w("ICUCompat", localIllegalAccessException);
      return paramLocale;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.w("ICUCompat", localInvocationTargetException);
      }
    }
  }
  
  private static String getScript(String paramString)
  {
    try
    {
      if (sGetScriptMethod != null)
      {
        paramString = (String)sGetScriptMethod.invoke(null, new Object[] { paramString });
        return paramString;
      }
    }
    catch (IllegalAccessException paramString)
    {
      Log.w("ICUCompat", paramString);
      return null;
    }
    catch (InvocationTargetException paramString)
    {
      for (;;)
      {
        Log.w("ICUCompat", paramString);
      }
    }
  }
  
  @Nullable
  public static String maximizeAndGetScript(Locale paramLocale)
  {
    String str1 = null;
    if (Build.VERSION.SDK_INT >= 24) {
      paramLocale = ULocale.addLikelySubtags(ULocale.forLocale(paramLocale)).getScript();
    }
    String str2;
    do
    {
      return paramLocale;
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          str1 = ((Locale)sAddLikelySubtagsMethod.invoke(null, new Object[] { paramLocale })).getScript();
          return str1;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Log.w("ICUCompat", localInvocationTargetException);
          return paramLocale.getScript();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            Log.w("ICUCompat", localIllegalAccessException);
          }
        }
      }
      str2 = addLikelySubtags(paramLocale);
      paramLocale = localIllegalAccessException;
    } while (str2 == null);
    return getScript(str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.text.ICUCompat
 * JD-Core Version:    0.7.0.1
 */