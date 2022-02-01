package c.t.m.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.Observable;

class db
  extends Observable
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private static String a = "cc_c_t_m_l_";
  private static volatile db b;
  private static volatile SharedPreferences c;
  
  private db()
  {
    c = dy.a(a);
  }
  
  protected static db a()
  {
    try
    {
      if (b == null) {
        try
        {
          b = new db();
        }
        finally {}
      }
      db localdb = b;
      return localdb;
    }
    finally {}
  }
  
  protected static void a(String paramString)
  {
    a = "cc_c_t_m_l_".concat(String.valueOf(paramString));
  }
  
  protected final SharedPreferences b()
  {
    try
    {
      if (c == null) {
        c = dy.a(a);
      }
      SharedPreferences localSharedPreferences = c;
      return localSharedPreferences;
    }
    finally {}
  }
  
  protected final void c()
  {
    try
    {
      if (c != null)
      {
        addObserver(da.a());
        c.registerOnSharedPreferenceChangeListener(this);
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
      if (c != null)
      {
        c.unregisterOnSharedPreferenceChangeListener(this);
        deleteObserver(da.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.db
 * JD-Core Version:    0.7.0.1
 */