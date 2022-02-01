package com.tencent.map.sdk.a;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Deflater;

public final class as
{
  public static String b;
  public ThreadPoolExecutor a;
  
  private as()
  {
    StringBuilder localStringBuilder = new StringBuilder("halley_");
    localStringBuilder.append(ac.c());
    localStringBuilder.append("_");
    localStringBuilder.append("BusinessTaskPool");
    this.a = ((ThreadPoolExecutor)Executors.newCachedThreadPool(new ae(localStringBuilder.toString())));
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (paramString.equals("HLDisconnEvent")) {
      return -2;
    }
    int j = 1;
    int i;
    if (paramInt != 0)
    {
      if ((paramInt != -4) && (paramInt != -3) && (paramInt != -288)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        paramString = "self_report_fail_denominator_value";
        break label63;
      }
    }
    paramString = "self_report_succ_denominator_value";
    label63:
    if (paramInt != 0)
    {
      i = j;
      if (paramInt != -4)
      {
        i = j;
        if (paramInt != -3) {
          if (paramInt == -288) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      if (i == 0)
      {
        paramInt = 2;
        break label112;
      }
    }
    paramInt = 100;
    label112:
    return a(paramString, 0, 2147483647, paramInt);
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      String str2 = b(paramString, ac.c());
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = b(paramString, 0);
      }
      i = Integer.parseInt(str1);
    }
    catch (Throwable paramString)
    {
      int i;
      label38:
      break label38;
    }
    i = paramInt3;
    return dg.a(i, paramInt1, paramInt2, paramInt3);
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if (paramInt <= 2147483647)
      {
        bool1 = bool2;
        if (new Random().nextInt(paramInt) == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    if (!paramString.startsWith(":"))
    {
      if (!paramString.contains(":")) {
        return false;
      }
      paramString = paramString.split(":")[0];
    }
    try
    {
      int i = Integer.parseInt(paramString, 16);
      if (i >= 0)
      {
        if (i > 65535) {
          return false;
        }
        if ((i >> 13 ^ 0x1) == 0) {
          return true;
        }
      }
      return false;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  public static boolean a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject;
    if (paramMap != null)
    {
      localObject = paramMap.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    try
    {
      localObject = br.e();
      paramString = br.a(paramString, paramBoolean, paramMap);
      try
      {
        if (((bj)localObject).b.getAndIncrement() > ((bj)localObject).c) {
          ((bj)localObject).b.decrementAndGet();
        } else {
          new bj.b((bj)localObject, paramString).a(false);
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      try
      {
        paramString.printStackTrace();
        return true;
      }
      catch (Throwable paramString) {}
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramArrayOfByte;
      }
      localObject = new ByteArrayOutputStream();
      Deflater localDeflater = new Deflater();
      localDeflater.setInput(paramArrayOfByte);
      localDeflater.finish();
      paramArrayOfByte = new byte[256];
      while (!localDeflater.finished()) {
        ((ByteArrayOutputStream)localObject).write(paramArrayOfByte, 0, localDeflater.deflate(paramArrayOfByte));
      }
      localDeflater.finish();
      localDeflater.end();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    }
    return localObject;
  }
  
  private static String b(String paramString, int paramInt)
  {
    String str1 = cd.a().a(ao.b());
    String str2 = dc.a(ao.g());
    return cy.d().e().a(paramString, paramInt, ac.d(), ac.a, str1, str2);
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.split("\\.");
    if (paramString.length != 4) {
      return false;
    }
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      String str;
      if (i < j) {
        str = paramString[i];
      }
      try
      {
        int k = Integer.parseInt(str);
        if (k >= 0)
        {
          if (k > 255) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return true;
    return false;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool = paramString.contains("::");
    if ((bool) && (paramString.indexOf("::") != paramString.lastIndexOf("::"))) {
      return false;
    }
    if (((paramString.startsWith(":")) && (!paramString.startsWith("::"))) || ((paramString.endsWith(":")) && (!paramString.endsWith("::")))) {
      return false;
    }
    String[] arrayOfString = paramString.split(":");
    Object localObject = arrayOfString;
    if (bool)
    {
      localObject = new ArrayList(Arrays.asList(arrayOfString));
      if (paramString.endsWith("::")) {
        ((List)localObject).add("");
      } else if ((paramString.startsWith("::")) && (!((List)localObject).isEmpty())) {
        ((List)localObject).remove(0);
      }
      localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
    }
    if (localObject.length > 8) {
      return false;
    }
    int k = 0;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (k < localObject.length)
      {
        paramString = localObject[k];
        if (paramString.length() == 0)
        {
          int m = i + 1;
          i = m;
          if (m > 1) {
            return false;
          }
        }
        else
        {
          if ((k == localObject.length - 1) && (paramString.contains(".")))
          {
            if (!b(paramString)) {
              return false;
            }
            j += 2;
            i = 0;
            break label302;
          }
          if (paramString.length() > 4) {
            return false;
          }
        }
      }
      try
      {
        i = Integer.parseInt(paramString, 16);
        if (i >= 0)
        {
          if (i > 65535) {
            return false;
          }
          i = 0;
          j += 1;
          label302:
          k += 1;
        }
        else
        {
          return false;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    if (j <= 8) {
      return (j >= 8) || (bool);
    }
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.as
 * JD-Core Version:    0.7.0.1
 */