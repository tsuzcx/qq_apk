package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.Observable;

class dd
  extends Observable
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private static String a = "cc_c_t_m_l_";
  private static volatile dd b = null;
  private static volatile Context c = null;
  private static volatile SharedPreferences d = null;
  
  private dd()
  {
    if (c != null) {
      d = c.getSharedPreferences(a, 0);
    }
  }
  
  /* Error */
  protected static dd a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 22	c/t/m/g/dd:b	Lc/t/m/g/dd;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 2
    //   11: monitorenter
    //   12: new 2	c/t/m/g/dd
    //   15: dup
    //   16: invokespecial 38	c/t/m/g/dd:<init>	()V
    //   19: putstatic 22	c/t/m/g/dd:b	Lc/t/m/g/dd;
    //   22: ldc 2
    //   24: monitorexit
    //   25: getstatic 22	c/t/m/g/dd:b	Lc/t/m/g/dd;
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
    //   28	5	0	localdd	dd
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
  
  protected static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramContext.getApplicationContext() == null)) {
      throw new NullPointerException("context cannot be null!");
    }
    c = paramContext.getApplicationContext();
    a = "cc_c_t_m_l_".concat(String.valueOf(paramString));
  }
  
  /* Error */
  protected final SharedPreferences b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 24	c/t/m/g/dd:c	Landroid/content/Context;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull +9 -> 16
    //   10: aconst_null
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: getstatic 26	c/t/m/g/dd:d	Landroid/content/SharedPreferences;
    //   19: ifnonnull +16 -> 35
    //   22: getstatic 24	c/t/m/g/dd:c	Landroid/content/Context;
    //   25: getstatic 20	c/t/m/g/dd:a	Ljava/lang/String;
    //   28: iconst_0
    //   29: invokevirtual 36	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   32: putstatic 26	c/t/m/g/dd:d	Landroid/content/SharedPreferences;
    //   35: getstatic 26	c/t/m/g/dd:d	Landroid/content/SharedPreferences;
    //   38: astore_1
    //   39: goto -27 -> 12
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	dd
    //   5	34	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	42	finally
    //   16	35	42	finally
    //   35	39	42	finally
  }
  
  protected final void c()
  {
    try
    {
      if (d != null)
      {
        addObserver(dc.a());
        d.registerOnSharedPreferenceChangeListener(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void d()
  {
    try
    {
      if (d != null)
      {
        d.unregisterOnSharedPreferenceChangeListener(this);
        deleteObserver(dc.a());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    setChanged();
    notifyObservers(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dd
 * JD-Core Version:    0.7.0.1
 */