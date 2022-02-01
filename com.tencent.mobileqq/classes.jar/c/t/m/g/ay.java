package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;

public final class ay
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  
  private static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      label6:
      break label6;
    }
    return "null";
  }
  
  public static void a(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a());
    localStringBuffer.append(";Android ");
    localStringBuffer.append(b());
    localStringBuffer.append(",level ");
    localStringBuffer.append(c());
    a = localStringBuffer.toString();
    b = b(paramContext);
    paramContext.getPackageName();
    c = d();
    d = a();
  }
  
  private static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      label6:
      break label6;
    }
    return "null";
  }
  
  private static String b(Context paramContext)
  {
    Object localObject = paramContext.getPackageName();
    try
    {
      paramContext = paramContext.getPackageManager();
      i = 0;
      paramContext = paramContext.getPackageInfo((String)localObject, 0);
      localObject = paramContext.versionName;
      m = paramContext.versionCode;
      if ((localObject == null) || (((String)localObject).trim().length() <= 0)) {
        break label155;
      }
      paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
      localObject = paramContext.toCharArray();
      j = 0;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        int i;
        int m;
        int k;
        label155:
        continue;
        i += 1;
        int j = k;
      }
    }
    if (i < localObject.length)
    {
      k = j;
      if (localObject[i] == '.') {
        k = j + 1;
      }
    }
    else
    {
      if (j >= 3) {
        return paramContext;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(m);
      return ((StringBuilder)localObject).toString();
      return String.valueOf(m);
      return "";
    }
    return paramContext;
  }
  
  private static String c()
  {
    try
    {
      String str = Build.VERSION.SDK;
      return str;
    }
    catch (Throwable localThrowable)
    {
      label6:
      break label6;
    }
    return "null";
  }
  
  private static String d()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      label6:
      break label6;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ay
 * JD-Core Version:    0.7.0.1
 */