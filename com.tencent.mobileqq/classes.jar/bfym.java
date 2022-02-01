import android.content.Context;
import android.content.SharedPreferences;
import java.lang.reflect.Field;

public class bfym
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("android.content.Context");
      i = ((Integer)localClass.getField("MODE_MULTI_PROCESS").get(localClass)).intValue();
      int j = i;
      if (i == -1) {
        j = 0;
      }
      return paramContext.getSharedPreferences(paramString, j);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfym
 * JD-Core Version:    0.7.0.1
 */