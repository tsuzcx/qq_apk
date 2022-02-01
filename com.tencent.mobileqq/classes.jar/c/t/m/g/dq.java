package c.t.m.g;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

public final class dq
{
  private static HashMap<String, ThreadLocal<SimpleDateFormat>> a = new HashMap();
  
  public static SimpleDateFormat a(String paramString)
  {
    try
    {
      Object localObject2 = (ThreadLocal)a.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ThreadLocal();
        a.put(paramString, localObject1);
      }
      SimpleDateFormat localSimpleDateFormat = (SimpleDateFormat)((ThreadLocal)localObject1).get();
      localObject2 = localSimpleDateFormat;
      if (localSimpleDateFormat == null)
      {
        localObject2 = new SimpleDateFormat(paramString, Locale.ENGLISH);
        ((ThreadLocal)localObject1).set(localObject2);
      }
      return localObject2;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dq
 * JD-Core Version:    0.7.0.1
 */