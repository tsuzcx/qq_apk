import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

public final class bhii
{
  private static ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "KEY_DELAY_LOAD_PROXY", "KEY_ENABLE_MEMORY_LEAK", "KEY_DISABLE_NAVIGATION_BAR" };
  
  public static void a(Context paramContext, boolean paramBoolean, @Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getSharedPreferences("BootOptimize", 0).edit();
      if (paramBoolean)
      {
        paramContext.putLong("_last_crash_time_", System.currentTimeMillis());
        paramString = jdField_a_of_type_ArrayOfJavaLangString;
        int j = paramString.length;
        while (i < j)
        {
          paramThrowable = paramString[i];
          paramContext.putBoolean("8.4.10" + paramThrowable, true);
          i += 1;
        }
      }
      if (TextUtils.isEmpty(paramString))
      {
        paramContext.putBoolean("8.4.10" + paramString, true);
        if (paramThrowable != null)
        {
          while (paramThrowable.getCause() != null) {
            paramThrowable = paramThrowable.getCause();
          }
          StringWriter localStringWriter = new StringWriter();
          paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
          paramContext.putString("8.4.10_crash_because_" + paramString, localStringWriter.getBuffer().toString());
        }
      }
      paramContext.apply();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    long l;
    do
    {
      return true;
      paramContext = paramContext.getSharedPreferences("BootOptimize", 0);
      if ((!TextUtils.isEmpty(paramString)) && (paramContext.getBoolean("8.4.10" + paramString, false))) {
        return false;
      }
      l = paramContext.getLong("_last_crash_time_", 0L);
    } while (System.currentTimeMillis() - l > 1800000L);
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      if (paramContext == null) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("TripleGraySwitchUtil", 2, new Object[] { "call setSwitch, Context=", Boolean.valueOf(bool), " ,key=", paramString, " ,value=", Boolean.valueOf(paramBoolean) });
      if ((paramContext != null) && (!TextUtils.isEmpty(paramString))) {
        break;
      }
      return false;
    }
    paramContext.getSharedPreferences("BootOptimize", 0).edit().putBoolean(paramString, paramBoolean).apply();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(paramBoolean));
    return true;
  }
  
  public static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramContext != null)
      {
        bool = true;
        QLog.d("TripleGraySwitchUtil", 2, new Object[] { "call getSwitch, Context=", Boolean.valueOf(bool), " ,key=", paramString, " judgeSafeMode=", Boolean.valueOf(paramBoolean) });
      }
    }
    else {
      if ((paramContext != null) && (!TextUtils.isEmpty(paramString))) {
        break label74;
      }
    }
    label74:
    do
    {
      return false;
      bool = false;
      break;
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        return ((Boolean)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).booleanValue();
      }
    } while ((paramBoolean) && (!a(paramContext, paramString)));
    paramBoolean = paramContext.getSharedPreferences("BootOptimize", 0).getBoolean(paramString, false);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("TripleGraySwitchUtil", 2, new Object[] { "key=", paramString, " value=", Boolean.valueOf(paramBoolean) });
    }
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhii
 * JD-Core Version:    0.7.0.1
 */