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

public class cy
  implements Observer
{
  protected static String a = "";
  protected static String b = "";
  protected static String c = "";
  private static final HashMap<String, String> d = new HashMap();
  private static cy e = null;
  private HashMap<Class<?>, Object> f = new HashMap();
  private volatile ConcurrentHashMap<String, String> g = null;
  private volatile ConcurrentHashMap<String, List<d>> h = null;
  private volatile boolean i = false;
  
  private cy()
  {
    this.f.put(String.class, "");
    this.f.put(Integer.class, Integer.valueOf(-2147483648));
    this.f.put(Float.class, Float.valueOf(1.4E-45F));
    this.f.put(Double.class, Double.valueOf(4.9E-324D));
    this.f.put(Long.class, Long.valueOf(-9223372036854775808L));
    this.f.put(Boolean.class, Boolean.FALSE);
    d();
  }
  
  /* Error */
  public static cy a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	c/t/m/g/cy:e	Lc/t/m/g/cy;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 2
    //   11: monitorenter
    //   12: new 2	c/t/m/g/cy
    //   15: dup
    //   16: invokespecial 105	c/t/m/g/cy:<init>	()V
    //   19: putstatic 43	c/t/m/g/cy:e	Lc/t/m/g/cy;
    //   22: ldc 2
    //   24: monitorexit
    //   25: getstatic 43	c/t/m/g/cy:e	Lc/t/m/g/cy;
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
    //   28	5	0	localcy	cy
    //   34	5	0	localObject1	Object
    //   40	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	25	34	finally
    //   3	12	40	finally
    //   25	29	40	finally
    //   35	40	40	finally
  }
  
  private final Object a(String paramString, Class<?> paramClass)
  {
    if (!this.i) {
      d();
    }
    if (!this.f.containsKey(paramClass)) {
      throw new IllegalStateException("The property \"" + paramString + "\" don't support class type \"" + paramClass.toString() + "\"");
    }
    Object localObject2 = (String)this.g.get(paramString);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = (String)d.get(paramString);
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
        paramString = b((String)d.get(paramString), paramClass);
        return paramString;
      }
      catch (Throwable paramString) {}
    }
    return this.f.get(paramClass);
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
    throws IllegalStateException
  {
    d.put(paramString1, paramString2);
  }
  
  private void d()
  {
    try
    {
      SharedPreferences localSharedPreferences = cz.a().b();
      if (localSharedPreferences != null)
      {
        String str = localSharedPreferences.getString("app_version", "");
        if ((c.length() > 0) && (!c.equals(str)))
        {
          cu.a("CC_Set", "clear sp > pre:" + str + ",now:" + c);
          localSharedPreferences.edit().clear().apply();
          localSharedPreferences.edit().putString("app_version", c).apply();
        }
      }
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      cu.a("CC_Set", localThrowable.getMessage(), localThrowable);
    }
  }
  
  private void f(String paramString)
  {
    if (d.get(paramString) == null) {}
    SharedPreferences localSharedPreferences;
    ConcurrentHashMap localConcurrentHashMap;
    for (;;)
    {
      return;
      try
      {
        localSharedPreferences = cz.a().b();
        if (localSharedPreferences != null)
        {
          localConcurrentHashMap = this.g;
          if (!d.containsKey(paramString)) {
            throw new NullPointerException("Not exists property name \"" + paramString + "\"");
          }
        }
      }
      catch (Throwable paramString)
      {
        cu.b("CC_Set", paramString.toString());
        return;
      }
    }
    localConcurrentHashMap.put(paramString, localSharedPreferences.getString(paramString, (String)d.get(paramString)));
  }
  
  public final int b(String paramString)
  {
    return ((Integer)a(paramString, Integer.class)).intValue();
  }
  
  protected final void b()
  {
    if (cz.a().b() == null)
    {
      cu.a("CC_Set", "---> read xml: failed,not init finish!");
      return;
    }
    Iterator localIterator = d.keySet().iterator();
    while (localIterator.hasNext()) {
      f((String)localIterator.next());
    }
    this.i = true;
    cu.a("CC_Set", "---> read xml:" + this.g.toString());
  }
  
  public final long c(String paramString)
  {
    return ((Long)a(paramString, Long.class)).longValue();
  }
  
  protected final void c()
  {
    this.h.clear();
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
      paramObject = "update [" + paramObservable + "] : " + (String)this.g.get(paramObservable) + " --> ";
      f(paramObservable);
      cu.a("CC_Set", paramObject + (String)this.g.get(paramObservable));
      paramObservable = (List)this.h.get(paramObservable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cy
 * JD-Core Version:    0.7.0.1
 */