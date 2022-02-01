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
  
  public static da a()
  {
    try
    {
      if (f == null) {
        try
        {
          f = new da();
        }
        finally {}
      }
      da localda = f;
      return localda;
    }
    finally {}
  }
  
  private final Object a(String paramString, Class<?> paramClass)
  {
    if (!this.i) {
      c();
    }
    Object localObject2;
    if (this.g.containsKey(paramClass))
    {
      localObject2 = (String)this.h.get(paramString);
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
    }
    try
    {
      localObject1 = b((String)localObject2, paramClass);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      label82:
      label99:
      break label82;
    }
    try
    {
      paramString = b((String)e.get(paramString), paramClass);
      return paramString;
    }
    catch (Throwable paramString)
    {
      break label99;
    }
    return this.g.get(paramClass);
    Object localObject1 = new StringBuilder("The property \"");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("\" don't support class type \"");
    ((StringBuilder)localObject1).append(paramClass.toString());
    ((StringBuilder)localObject1).append("\"");
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
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
    if (paramClass == Integer.class) {
      return Integer.valueOf(Integer.parseInt(paramString));
    }
    if (paramClass == Long.class) {
      return Long.valueOf(Long.parseLong(paramString));
    }
    if (paramClass == Boolean.class) {
      return Boolean.valueOf(Boolean.parseBoolean(paramString));
    }
    if (paramClass == Float.class) {
      return Float.valueOf(Float.parseFloat(paramString));
    }
    Object localObject = paramString;
    if (paramClass == Double.class) {
      localObject = Double.valueOf(Double.parseDouble(paramString));
    }
    return localObject;
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
    if (localSharedPreferences == null) {
      return;
    }
    String str = (String)dy.b(localSharedPreferences, "app_version", "");
    if ((c.length() > 0) && (!c.equals(str)))
    {
      StringBuilder localStringBuilder = new StringBuilder("clear sp > pre:");
      localStringBuilder.append(str);
      localStringBuilder.append(",now:");
      localStringBuilder.append(c);
      co.a(localStringBuilder.toString());
      localSharedPreferences.edit().clear().apply();
      dy.a(localSharedPreferences, "app_version", c);
    }
  }
  
  private void f(String paramString)
  {
    if (e.get(paramString) == null) {
      return;
    }
    try
    {
      SharedPreferences localSharedPreferences = db.a().b();
      if (localSharedPreferences != null) {
        this.h.put(paramString, localSharedPreferences.getString(paramString, g(paramString)));
      }
      return;
    }
    catch (Throwable paramString)
    {
      co.b(paramString.toString());
    }
  }
  
  private static String g(String paramString)
  {
    if (e.containsKey(paramString)) {
      return (String)e.get(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder("Not exists property name \"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    throw new NullPointerException(localStringBuilder.toString());
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
    Object localObject = e.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      f((String)((Iterator)localObject).next());
    }
    this.i = true;
    localObject = new StringBuilder("---> read xml:");
    ((StringBuilder)localObject).append(this.h.toString());
    co.a(((StringBuilder)localObject).toString());
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
    if (paramObject == null) {
      paramObservable = null;
    } else {
      paramObservable = (String)paramObject;
    }
    if (paramObservable != null)
    {
      if (paramObservable.length() == 0) {
        return;
      }
      paramObject = new StringBuilder("update [");
      paramObject.append(paramObservable);
      paramObject.append("] : ");
      paramObject.append((String)this.h.get(paramObservable));
      paramObject.append(" --> ");
      paramObject = paramObject.toString();
      f(paramObservable);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramObject);
      localStringBuilder.append((String)this.h.get(paramObservable));
      co.a(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.da
 * JD-Core Version:    0.7.0.1
 */