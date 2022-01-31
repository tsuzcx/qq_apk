package c.t.m.g;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.Deflater;

public final class v
{
  public static String a;
  private final int b = a("black_list_refresh_gap", 60000, 86400000, 3600000);
  private String c = "";
  private List<m> d = new ArrayList();
  private List<m> e = new ArrayList();
  private List<a> f = new ArrayList();
  
  public v(String paramString)
  {
    this.c = paramString;
    cc.a(paramString, "");
    ab.a().b(new w(this), this.b);
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      String str2 = a(paramString, l.c());
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = a(paramString, 0);
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
    return ch.a(i, paramInt1, paramInt2, paramInt3);
  }
  
  private static String a(String paramString, int paramInt)
  {
    String str1 = be.a().a(o.b());
    String str2 = cc.a(o.g());
    return by.c().d().a(paramString, paramInt, l.f(), l.a, str1, str2);
  }
  
  public static boolean a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    try
    {
      at.e().a(paramString, paramBoolean, paramMap);
      return true;
    }
    catch (Throwable paramString)
    {
      try
      {
        paramString.printStackTrace();
      }
      catch (Throwable paramString) {}
    }
    return false;
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
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 197	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 45	c/t/m/g/v:f	Ljava/util/List;
    //   14: invokeinterface 201 1 0
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface 146 1 0
    //   26: ifeq +62 -> 88
    //   29: aload_2
    //   30: invokeinterface 150 1 0
    //   35: checkcast 6	c/t/m/g/v$a
    //   38: astore_3
    //   39: aload_1
    //   40: aload_3
    //   41: getfield 204	c/t/m/g/v$a:a	Lc/t/m/g/m;
    //   44: invokevirtual 208	c/t/m/g/m:a	()Ljava/lang/String;
    //   47: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 214
    //   52: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: getfield 217	c/t/m/g/v$a:b	J
    //   59: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc 222
    //   64: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: goto -48 -> 20
    //   71: astore_1
    //   72: aload_0
    //   73: getfield 36	c/t/m/g/v:c	Ljava/lang/String;
    //   76: ldc 34
    //   78: invokestatic 50	c/t/m/g/cc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokevirtual 161	java/lang/Throwable:printStackTrace	()V
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: aload_0
    //   89: getfield 36	c/t/m/g/v:c	Ljava/lang/String;
    //   92: aload_1
    //   93: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 50	c/t/m/g/cc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: goto -14 -> 85
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	v
    //   9	31	1	localStringBuilder	java.lang.StringBuilder
    //   71	22	1	localThrowable	Throwable
    //   102	4	1	localObject	Object
    //   19	11	2	localIterator	Iterator
    //   38	18	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	20	71	java/lang/Throwable
    //   20	68	71	java/lang/Throwable
    //   88	99	71	java/lang/Throwable
    //   2	20	102	finally
    //   20	68	102	finally
    //   72	85	102	finally
    //   88	99	102	finally
  }
  
  final void a()
  {
    int i = 0;
    try
    {
      this.e.clear();
      this.f.clear();
      localObject1 = cc.b(this.c, "");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool) {
        break label48;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        int j;
        int k;
        cc.a(this.c, "");
        localThrowable.printStackTrace();
      }
    }
    finally {}
    return;
    label48:
    j = a("black_list_outofdate", 60000, 86400000, 7200000);
    localObject1 = ((String)localObject1).split(";");
    k = localObject1.length;
    for (;;)
    {
      if (i < k)
      {
        Object localObject3 = localObject1[i].split("-");
        a locala = localObject3[0];
        long l = Long.parseLong(localObject3[1]);
        if (System.currentTimeMillis() - l < j)
        {
          localObject3 = locala.split(":");
          localObject3 = new m(localObject3[0], Integer.parseInt(localObject3[1]));
          locala = new a((m)localObject3, l);
          this.e.add(localObject3);
          this.f.add(locala);
        }
      }
      else
      {
        c();
        break;
      }
      i += 1;
    }
  }
  
  public final void a(m paramm)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.d.iterator();
        int i;
        if (localIterator.hasNext())
        {
          if (paramm.a((m)localIterator.next()))
          {
            i = 1;
            if (i != 0)
            {
              this.e.add(paramm);
              this.f.add(new a(paramm, System.currentTimeMillis()));
              c();
              return;
            }
            this.d.add(paramm);
          }
        }
        else {
          i = 0;
        }
      }
      finally {}
    }
  }
  
  public final List<m> b()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        localArrayList.add(new m(localm.a, localm.b));
      }
    }
    finally {}
    return localList;
  }
  
  public final void b(m paramm)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.d.iterator();
        if (localIterator.hasNext())
        {
          m localm = (m)localIterator.next();
          if (!paramm.a(localm)) {
            continue;
          }
          paramm = localm;
          if (paramm != null) {
            this.d.remove(paramm);
          }
          return;
        }
      }
      finally {}
      paramm = null;
    }
  }
  
  static final class a
  {
    m a;
    long b;
    
    public a(m paramm, long paramLong)
    {
      this.a = paramm;
      this.b = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.v
 * JD-Core Version:    0.7.0.1
 */