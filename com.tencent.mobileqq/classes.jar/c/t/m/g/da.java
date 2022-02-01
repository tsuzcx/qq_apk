package c.t.m.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class da
  implements Observer
{
  protected static volatile String a = "";
  protected static volatile String b = "";
  protected static volatile String c = "";
  private static final HashMap<String, String> e = new HashMap();
  private static volatile da f = null;
  volatile ConcurrentHashMap<String, List<du.a>> d = null;
  private HashMap<Class<?>, Object> g = new HashMap();
  private volatile ConcurrentHashMap<String, String> h = null;
  private volatile boolean i = false;
  
  private da()
  {
    this.g.put(String.class, "");
    this.g.put(Integer.class, Integer.valueOf(-2147483648));
    this.g.put(Float.class, Float.valueOf(1.4E-45F));
    this.g.put(Double.class, Double.valueOf(4.9E-324D));
    this.g.put(Long.class, Long.valueOf(-9223372036854775808L));
    this.g.put(Boolean.class, Boolean.FALSE);
    c();
  }
  
  /* Error */
  public static da a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	c/t/m/g/da:f	Lc/t/m/g/da;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 2
    //   11: monitorenter
    //   12: new 2	c/t/m/g/da
    //   15: dup
    //   16: invokespecial 105	c/t/m/g/da:<init>	()V
    //   19: putstatic 43	c/t/m/g/da:f	Lc/t/m/g/da;
    //   22: ldc 2
    //   24: monitorexit
    //   25: getstatic 43	c/t/m/g/da:f	Lc/t/m/g/da;
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   28	5	0	localda	da
    //   34	5	0	localObject1	Object
    //   40	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	25	34	finally
    //   35	38	34	finally
    //   3	12	40	finally
    //   25	29	40	finally
    //   38	40	40	finally
  }
  
  private final Object a(String paramString, Class<?> paramClass)
  {
    if (!this.i) {
      c();
    }
    if (!this.g.containsKey(paramClass)) {
      throw new IllegalStateException("The property \"" + paramString + "\" don't support class type \"" + paramClass.toString() + "\"");
    }
    Object localObject2 = (String)this.h.get(paramString);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = (String)e.get(paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    try
    {
      localObject1 = b((String)localObject2, paramClass);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        paramString = b((String)e.get(paramString), paramClass);
        return paramString;
      }
      catch (Throwable paramString) {}
    }
    return this.g.get(paramClass);
  }
  
  protected static void a(String paramString)
  {
    b = paramString;
  }
  
  protected static void a(String paramString1, String paramString2)
  {
    a = paramString1;
    c = paramString2;
    b("app_version", paramString2);
  }
  
  protected static void a(HashMap<String, String> paramHashMap)
  {
    b("cc_version", "-1");
    b("cc_req_interval", "10800000");
    b("last_pull_time", "0");
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      b(str, (String)paramHashMap.get(str));
    }
  }
  
  private static Object b(String paramString, Class<?> paramClass)
  {
    Object localObject;
    if (paramClass == Integer.class) {
      localObject = Integer.valueOf(Integer.parseInt(paramString));
    }
    do
    {
      return localObject;
      if (paramClass == Long.class) {
        return Long.valueOf(Long.parseLong(paramString));
      }
      if (paramClass == Boolean.class) {
        return Boolean.valueOf(Boolean.parseBoolean(paramString));
      }
      if (paramClass == Float.class) {
        return Float.valueOf(Float.parseFloat(paramString));
      }
      localObject = paramString;
    } while (paramClass != Double.class);
    return Double.valueOf(Double.parseDouble(paramString));
  }
  
  private static void b(String paramString1, String paramString2)
  {
    e.put(paramString1, paramString2);
  }
  
  private void c()
  {
    try
    {
      d();
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      co.a(localThrowable.getMessage(), localThrowable);
    }
  }
  
  private static void d()
  {
    SharedPreferences localSharedPreferences = db.a().b();
    if (localSharedPreferences == null) {}
    String str;
    do
    {
      return;
      str = (String)dy.b(localSharedPreferences, "app_version", "");
    } while ((c.length() <= 0) || (c.equals(str)));
    co.a("clear sp > pre:" + str + ",now:" + c);
    localSharedPreferences.edit().clear().apply();
    dy.a(localSharedPreferences, "app_version", c);
  }
  
  private void f(String paramString)
  {
    if (e.get(paramString) == null) {}
    for (;;)
    {
      return;
      try
      {
        SharedPreferences localSharedPreferences = db.a().b();
        if (localSharedPreferences != null)
        {
          this.h.put(paramString, localSharedPreferences.getString(paramString, g(paramString)));
          return;
        }
      }
      catch (Throwable paramString)
      {
        co.b(paramString.toString());
      }
    }
  }
  
  private static String g(String paramString)
  {
    if (!e.containsKey(paramString)) {
      throw new NullPointerException("Not exists property name \"" + paramString + "\"");
    }
    return (String)e.get(paramString);
  }
  
  public final int b(String paramString)
  {
    return ((Integer)a(paramString, Integer.class)).intValue();
  }
  
  protected final void b()
  {
    if (db.a().b() == null)
    {
      co.a("---> read xml: failed,not init finish!");
      return;
    }
    Iterator localIterator = e.keySet().iterator();
    while (localIterator.hasNext()) {
      f((String)localIterator.next());
    }
    this.i = true;
    co.a("---> read xml:" + this.h.toString());
  }
  
  public final long c(String paramString)
  {
    return ((Long)a(paramString, Long.class)).longValue();
  }
  
  public final boolean d(String paramString)
  {
    return ((Boolean)a(paramString, Boolean.class)).booleanValue();
  }
  
  public final String e(String paramString)
  {
    return (String)a(paramString, String.class);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null)
    {
      paramObservable = null;
      if ((paramObservable != null) && (paramObservable.length() != 0)) {
        break label26;
      }
    }
    for (;;)
    {
      return;
      paramObservable = (String)paramObject;
      break;
      label26:
      paramObject = "update [" + paramObservable + "] : " + (String)this.h.get(paramObservable) + " --> ";
      f(paramObservable);
      co.a(paramObject + (String)this.h.get(paramObservable));
      paramObservable = (List)this.d.get(paramObservable);
      if ((paramObservable != null) && (!paramObservable.isEmpty()))
      {
        paramObservable = paramObservable.iterator();
        while (paramObservable.hasNext()) {
          paramObservable.next();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.da
 * JD-Core Version:    0.7.0.1
 */