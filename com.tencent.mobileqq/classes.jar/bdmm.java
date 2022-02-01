import android.app.Activity;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class bdmm
{
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        HashMap localHashMap = new HashMap();
        localObject = a(new Class[] { Activity.class });
        if (localObject != null)
        {
          int j = localObject[0].length;
          localStringBuilder.append("\nTotal Count: ").append(j).append("\n");
          i = 0;
          if (i >= j) {
            break label136;
          }
          String str = localObject[0][i].getClass().getName();
          if (!localHashMap.containsKey(str)) {
            localHashMap.put(str, Integer.valueOf(1));
          } else {
            localHashMap.put(str, Integer.valueOf(((Integer)localHashMap.get(str)).intValue() + 1));
          }
        }
      }
      catch (Throwable localThrowable) {}
      for (;;)
      {
        return localStringBuilder.toString();
        label136:
        Iterator localIterator = localThrowable.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          localStringBuilder.append((String)((Map.Entry)localObject).getKey()).append(" : ").append(((Map.Entry)localObject).getValue()).append("\n");
        }
      }
      i += 1;
    }
  }
  
  private static Object[][] a(Class[] paramArrayOfClass)
  {
    try
    {
      paramArrayOfClass = (Object[][])Class.forName("dalvik.system.VMDebug").getDeclaredMethod("getInstancesOfClasses", new Class[] { [Ljava.lang.Class.class, Boolean.TYPE }).invoke(null, new Object[] { paramArrayOfClass, Boolean.valueOf(true) });
      return paramArrayOfClass;
    }
    catch (Throwable paramArrayOfClass) {}
    return (Object[][])null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmm
 * JD-Core Version:    0.7.0.1
 */