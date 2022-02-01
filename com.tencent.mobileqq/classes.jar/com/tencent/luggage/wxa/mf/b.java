package com.tencent.luggage.wxa.mf;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.luggage.wxa.mc.a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  public static final int a = Build.VERSION.SDK_INT;
  public static HashMap<String, String> b = new HashMap();
  private static String c = "<html";
  private static final AtomicInteger d = new AtomicInteger(1);
  private static HashMap<String, Boolean> e = new HashMap();
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (String)b.get(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return localObject;
      }
    }
    com.tencent.luggage.wxa.md.b localb = a.a().c();
    Object localObject = localb;
    if (localb == null) {
      localObject = new com.tencent.luggage.wxa.md.c();
    }
    localObject = ((com.tencent.luggage.wxa.md.b)localObject).a(paramString);
    b.put(paramString, localObject);
    return localObject;
  }
  
  public static String a(Throwable paramThrowable)
  {
    return a(paramThrowable, false);
  }
  
  private static String a(Throwable paramThrowable, boolean paramBoolean)
  {
    if (paramThrowable == null) {
      return "";
    }
    Object localObject1 = Thread.currentThread();
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramBoolean)
    {
      localStringBuilder.append("Exception in thread \"");
      localStringBuilder.append(((Thread)localObject1).getName());
      localStringBuilder.append("\"");
      localStringBuilder.append(paramThrowable.toString());
    }
    localObject1 = paramThrowable.getStackTrace();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localStringBuilder.append("\tat ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append("\n");
      i += 1;
    }
    if ((paramThrowable instanceof InvocationTargetException)) {
      paramThrowable = ((InvocationTargetException)paramThrowable).getTargetException();
    } else {
      paramThrowable = paramThrowable.getCause();
    }
    if (paramThrowable != null)
    {
      localStringBuilder.append("caused by: ");
      localStringBuilder.append(paramThrowable.toString());
      localStringBuilder.append("\n");
      localStringBuilder.append(a(paramThrowable, true));
    }
    return localStringBuilder.toString();
  }
  
  public static List<String> a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList((paramString.length() + paramInt - 1) / paramInt);
    int j;
    for (int i = 0; i < paramString.length(); i = j)
    {
      int k = paramString.length();
      j = i + paramInt;
      localArrayList.add(paramString.substring(i, Math.min(k, j)));
    }
    return localArrayList;
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, null);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    Object localObject = paramString2;
    if (paramThrowable != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(a(paramThrowable));
      localObject = ((StringBuilder)localObject).toString();
    }
    if (((String)localObject).length() > 1000)
    {
      a(paramInt, paramString1, a((String)localObject, 1000));
      return;
    }
    paramString2 = a.a().b();
    if (paramString2 == null)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6) {
                return;
              }
              Log.e(paramString1, (String)localObject);
              return;
            }
            Log.w(paramString1, (String)localObject);
            return;
          }
          Log.i(paramString1, (String)localObject);
          return;
        }
        Log.d(paramString1, (String)localObject);
        return;
      }
      Log.v(paramString1, (String)localObject);
      return;
    }
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return;
            }
            paramString2.e(paramString1, (String)localObject);
            return;
          }
          paramString2.d(paramString1, (String)localObject);
          return;
        }
        paramString2.c(paramString1, (String)localObject);
        return;
      }
      paramString2.b(paramString1, (String)localObject);
      return;
    }
    paramString2.a(paramString1, (String)localObject);
  }
  
  public static void a(int paramInt, String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt, paramString, (String)paramList.next());
    }
  }
  
  public static boolean b(String paramString)
  {
    if (e.containsKey(paramString)) {
      return ((Boolean)e.get(paramString)).booleanValue();
    }
    boolean bool;
    if ((!paramString.contains("m3u8")) && (!paramString.contains("m3u"))) {
      bool = false;
    } else {
      bool = true;
    }
    e.put(paramString, Boolean.valueOf(bool));
    return bool;
  }
  
  public static String c(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (paramString.startsWith("/"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file://");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public static boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("file:///android_asset"));
  }
  
  public static boolean e(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("android.resource://"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mf.b
 * JD-Core Version:    0.7.0.1
 */