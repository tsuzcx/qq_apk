package com.tencent.gathererga.core.internal.util;

import android.content.Context;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class PermissionUtil
{
  private static final String[] a = new String[0];
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      try
      {
        if (paramContext.getApplicationContext() != null)
        {
          int i = paramContext.getApplicationContext().checkCallingOrSelfPermission(paramString);
          if (i == 0) {
            return true;
          }
        }
      }
      catch (Throwable paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PermissionUtil checkPermission ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" Throwable.");
        GLog.b(localStringBuilder.toString(), paramContext);
      }
    }
    return false;
  }
  
  public static String[] a(Context paramContext, String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (!a(paramContext, str)) {
          localCopyOnWriteArrayList.add(str);
        }
        i += 1;
      }
      if (localCopyOnWriteArrayList.isEmpty()) {
        return a;
      }
      paramContext = new StringBuilder();
      paramContext.append("need requestPermissions ");
      paramContext.append(Arrays.asList(new CopyOnWriteArrayList[] { localCopyOnWriteArrayList }));
      GLog.a(paramContext.toString());
      return (String[])localCopyOnWriteArrayList.toArray(new String[0]);
    }
    GLog.b("no permissions need request");
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.PermissionUtil
 * JD-Core Version:    0.7.0.1
 */