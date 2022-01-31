package c.t.m.g;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

public final class dp
{
  private static HashMap<String, ThreadLocal<SimpleDateFormat>> a = new HashMap();
  
  public static SimpleDateFormat a(String paramString)
  {
    for (;;)
    {
      try
      {
        ThreadLocal localThreadLocal = (ThreadLocal)a.get(paramString);
        if (localThreadLocal == null)
        {
          localThreadLocal = new ThreadLocal();
          a.put(paramString, localThreadLocal);
          SimpleDateFormat localSimpleDateFormat2 = (SimpleDateFormat)localThreadLocal.get();
          SimpleDateFormat localSimpleDateFormat1 = localSimpleDateFormat2;
          if (localSimpleDateFormat2 == null)
          {
            localSimpleDateFormat1 = new SimpleDateFormat(paramString, Locale.ENGLISH);
            localThreadLocal.set(localSimpleDateFormat1);
          }
          return localSimpleDateFormat1;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.dp
 * JD-Core Version:    0.7.0.1
 */