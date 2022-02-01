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
  public ThreadPoolExecutor a = (ThreadPoolExecutor)Executors.newCachedThreadPool(new ae("halley_" + ac.c() + "_" + "BusinessTaskPool"));
  
  public static int a(String paramString, int paramInt)
  {
    int j = 1;
    if (paramString.equals("HLDisconnEvent")) {
      return -2;
    }
    int i;
    if (paramInt != 0)
    {
      if ((paramInt == -4) || (paramInt == -3) || (paramInt == -288))
      {
        i = 1;
        if (i == 0) {
          break label96;
        }
      }
    }
    else
    {
      paramString = "self_report_succ_denominator_value";
      label46:
      if (paramInt != 0)
      {
        i = j;
        if (paramInt != -4)
        {
          i = j;
          if (paramInt != -3)
          {
            if (paramInt != -288) {
              break label102;
            }
            i = j;
          }
        }
        label75:
        if (i == 0) {
          break label107;
        }
      }
    }
    label96:
    label102:
    label107:
    for (paramInt = 100;; paramInt = 2)
    {
      return a(paramString, 0, 2147483647, paramInt);
      i = 0;
      break;
      paramString = "self_report_fail_denominator_value";
      break label46;
      i = 0;
      break label75;
    }
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
      for (;;)
      {
        int i = paramInt3;
      }
    }
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
    if ((paramString.startsWith(":")) || (!paramString.contains(":"))) {}
    for (;;)
    {
      return false;
      paramString = paramString.split(":")[0];
      try
      {
        int i = Integer.parseInt(paramString, 16);
        if ((i >= 0) && (i <= 65535) && ((i >> 13 ^ 0x1) == 0)) {
          return true;
        }
      }
      catch (NumberFormatException paramString) {}
    }
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
      return true;
    }
    catch (Throwable paramString)
    {
      try
      {
        paramString.printStackTrace();
      }
      catch (Throwable paramString)
      {
        return false;
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    paramArrayOfByte = new byte[256];
    while (!localDeflater.finished()) {
      localByteArrayOutputStream.write(paramArrayOfByte, 0, localDeflater.deflate(paramArrayOfByte));
    }
    localDeflater.finish();
    localDeflater.end();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static String b(String paramString, int paramInt)
  {
    String str1 = cd.a().a(ao.b());
    String str2 = dc.a(ao.g());
    return cy.d().e().a(paramString, paramInt, ac.d(), ac.a, str1, str2);
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = paramString.split("\\.");
      int i;
      String str;
      if (paramString.length == 4)
      {
        int j = paramString.length;
        i = 0;
        if (i < j) {
          str = paramString[i];
        }
      }
      try
      {
        int k = Integer.parseInt(str);
        if ((k >= 0) && (k <= 255)) {
          i += 1;
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
    if ((bool) && (paramString.indexOf("::") != paramString.lastIndexOf("::"))) {}
    label123:
    do
    {
      for (;;)
      {
        return false;
        int j;
        int i;
        if (((!paramString.startsWith(":")) || (paramString.startsWith("::"))) && ((!paramString.endsWith(":")) || (paramString.endsWith("::"))))
        {
          String[] arrayOfString = paramString.split(":");
          Object localObject = arrayOfString;
          int k;
          if (bool)
          {
            localObject = new ArrayList(Arrays.asList(arrayOfString));
            if (paramString.endsWith("::"))
            {
              ((List)localObject).add("");
              localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
            }
          }
          else
          {
            if (localObject.length > 8) {
              continue;
            }
            k = 0;
            j = 0;
            i = 0;
            if (k >= localObject.length) {
              break label295;
            }
            paramString = localObject[k];
            if (paramString.length() != 0) {
              break label230;
            }
            i += 1;
            if (i > 1) {
              continue;
            }
            j += 1;
          }
          for (;;)
          {
            k += 1;
            break label159;
            if ((!paramString.startsWith("::")) || (((List)localObject).isEmpty())) {
              break label123;
            }
            ((List)localObject).remove(0);
            break label123;
            if ((k != localObject.length - 1) || (!paramString.contains("."))) {
              break label265;
            }
            if (!b(paramString)) {
              break;
            }
            j += 2;
            i = 0;
          }
          if (paramString.length() > 4) {}
        }
        try
        {
          i = Integer.parseInt(paramString, 16);
          if ((i >= 0) && (i <= 65535)) {
            i = 0;
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while ((j > 8) || ((j < 8) && (!bool)));
    label159:
    label230:
    return true;
    label265:
    label295:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.as
 * JD-Core Version:    0.7.0.1
 */