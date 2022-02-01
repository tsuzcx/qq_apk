package c.t.m.sapp.c;

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.util.List;

public class f
{
  public static DexClassLoader a;
  public static Context b;
  public static f c;
  
  public f(Context paramContext)
  {
    b = paramContext;
    n.a(paramContext).a();
  }
  
  public static f a(Context paramContext)
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new f(paramContext);
        }
      }
      finally {}
    }
    return c;
  }
  
  public DexClassLoader a()
  {
    try
    {
      Object localObject1 = a;
      if (localObject1 != null) {
        return localObject1;
      }
      localObject1 = b;
      if (localObject1 == null) {
        return null;
      }
      d.a((Context)localObject1).b("load_sapp");
      q.e = System.currentTimeMillis();
      a = h.a(b).b();
      if (a != null) {
        e.a(b).a();
      }
      b();
      d.a(b).c("load_sapp");
      localObject1 = a;
      return localObject1;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      Object localObject = b;
      localObject = q.e(q.a((Context)localObject, "__SP_Tencent_Loc_COMP_INFO__sapp_", ""));
      new Thread(new i(b, (List)localObject, false)).start();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void c()
  {
    c = null;
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.f
 * JD-Core Version:    0.7.0.1
 */