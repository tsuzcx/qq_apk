package com.tencent.magicbrush.handler.glfont;

import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class m
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public static int f = 5;
  public static int g = 6;
  private Map<Integer, String> h = new HashMap();
  
  private void a(RandomAccessFile paramRandomAccessFile)
  {
    int i = paramRandomAccessFile.readShort();
    int k = paramRandomAccessFile.readShort();
    int m = paramRandomAccessFile.readShort();
    int j = 1;
    if (i == 1)
    {
      if (k != 0) {
        return;
      }
      paramRandomAccessFile.seek(12L);
      Object localObject1 = new byte[4];
      m.c localc = new m.c(null);
      k = 0;
      i = 0;
      while (i < m)
      {
        paramRandomAccessFile.read((byte[])localObject1);
        localc.a = new String((byte[])localObject1);
        localc.b = paramRandomAccessFile.readInt();
        localc.c = paramRandomAccessFile.readInt();
        localc.d = paramRandomAccessFile.readInt();
        if ("name".equalsIgnoreCase(localc.a))
        {
          i = j;
          break label160;
        }
        if ((localc.a == null) || (localc.a.length() == 0)) {
          break;
        }
        i += 1;
      }
      i = 0;
      label160:
      if (i == 0) {
        return;
      }
      paramRandomAccessFile.seek(localc.c);
      localObject1 = new m.b(null);
      ((m.b)localObject1).a = paramRandomAccessFile.readShort();
      ((m.b)localObject1).b = paramRandomAccessFile.readShort();
      ((m.b)localObject1).c = paramRandomAccessFile.readShort();
      m.a locala = new m.a(null);
      i = k;
      while (i < ((m.b)localObject1).b)
      {
        locala.a = paramRandomAccessFile.readShort();
        locala.b = paramRandomAccessFile.readShort();
        locala.c = paramRandomAccessFile.readShort();
        locala.d = paramRandomAccessFile.readShort();
        locala.e = paramRandomAccessFile.readShort();
        locala.f = paramRandomAccessFile.readShort();
        long l = paramRandomAccessFile.getFilePointer();
        if (locala.e <= 0) {
          break;
        }
        if (locala.e >= 32767) {
          return;
        }
        Object localObject2 = new byte[locala.e];
        paramRandomAccessFile.seek(localc.c + locala.f + ((m.b)localObject1).c);
        paramRandomAccessFile.read((byte[])localObject2);
        localObject2 = new String((byte[])localObject2, Charset.forName("utf-16"));
        this.h.put(Integer.valueOf(locala.d), localObject2);
        paramRandomAccessFile.seek(l);
        i += 1;
      }
    }
  }
  
  public String a()
  {
    if (this.h.containsKey(Integer.valueOf(b))) {
      return (String)this.h.get(Integer.valueOf(b));
    }
    if (this.h.containsKey(Integer.valueOf(g))) {
      return (String)this.h.get(Integer.valueOf(g));
    }
    return null;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/tencent/magicbrush/handler/glfont/m:h	Ljava/util/Map;
    //   4: invokeinterface 145 1 0
    //   9: aconst_null
    //   10: astore_2
    //   11: new 36	java/io/RandomAccessFile
    //   14: dup
    //   15: aload_1
    //   16: ldc 147
    //   18: invokespecial 150	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore_3
    //   22: aload_0
    //   23: aload_3
    //   24: invokespecial 152	com/tencent/magicbrush/handler/glfont/m:a	(Ljava/io/RandomAccessFile;)V
    //   27: aload_3
    //   28: invokevirtual 155	java/io/RandomAccessFile:close	()V
    //   31: return
    //   32: astore_1
    //   33: ldc 157
    //   35: aload_1
    //   36: ldc 159
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 164	com/tencent/luggage/wxa/gi/c$c:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: return
    //   46: astore_1
    //   47: aload_3
    //   48: astore_2
    //   49: goto +4 -> 53
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 155	java/io/RandomAccessFile:close	()V
    //   57: goto +16 -> 73
    //   60: astore_2
    //   61: ldc 157
    //   63: aload_2
    //   64: ldc 159
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 164	com/tencent/luggage/wxa/gi/c$c:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	m
    //   0	75	1	paramString	String
    //   10	44	2	localObject	Object
    //   60	4	2	localException	java.lang.Exception
    //   21	27	3	localRandomAccessFile	RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   27	31	32	java/lang/Exception
    //   22	27	46	finally
    //   11	22	52	finally
    //   53	57	60	java/lang/Exception
  }
  
  public String toString()
  {
    return this.h.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.m
 * JD-Core Version:    0.7.0.1
 */