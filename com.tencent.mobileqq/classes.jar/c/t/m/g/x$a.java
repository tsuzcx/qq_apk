package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Deflater;

public final class x$a
{
  public static String a;
  
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
      String str2 = b(paramString, m.c());
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
    return cn.a(i, paramInt1, paramInt2, paramInt3);
  }
  
  public static Handler a(String paramString)
  {
    paramString = new HandlerThread("halley_" + m.c() + "_" + paramString, 10);
    paramString.start();
    return new Handler(paramString.getLooper());
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt != 0)
    {
      p.b();
      p.c();
      p.a = paramString;
    }
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
      localObject = az.e();
      paramString = az.a(paramString, paramBoolean, paramMap);
      try
      {
        if (((aq)localObject).b.getAndIncrement() > ((aq)localObject).c) {
          ((aq)localObject).b.decrementAndGet();
        } else {
          new aq.b((aq)localObject, paramString).a(false);
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
    String str1 = bl.a().a(x.b());
    String str2 = ck.a(x.g());
    return cg.d().e().a(paramString, paramInt, m.f(), m.a, str1, str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.x.a
 * JD-Core Version:    0.7.0.1
 */