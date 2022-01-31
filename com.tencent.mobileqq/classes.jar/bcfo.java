import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class bcfo
{
  public static int a()
  {
    int j = bcfa.a(bbtm.a().a(), null).a("Common_BusinessReportMaxcount");
    int i = j;
    if (j == 0) {
      i = 20;
    }
    return i;
  }
  
  public static int a(int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      i = bcfa.a(bbtm.a().a(), null).a("Common_ViaSuccessRatioFrequencySuccess");
      paramInt = i;
      if (i == 0) {
        paramInt = 20;
      }
    }
    do
    {
      return paramInt;
      i = bcfa.a(bbtm.a().a(), null).a("Common_ViaSuccessRatioFrequencyFail");
      paramInt = i;
    } while (i != 0);
    return 50;
  }
  
  public static int a(String paramString)
  {
    int j = bcfa.a(bbtm.a().a(), paramString).a("Common_BusinessReportFrequency");
    int i = j;
    if (j == 0) {
      i = 100;
    }
    return i;
  }
  
  public static long a()
  {
    return bbtm.a().a().getSharedPreferences("reportConfig", 0).getLong("lastTime", 0L);
  }
  
  protected static SharedPreferences a()
  {
    return bbtm.a().a().getSharedPreferences("reportConfig", 0);
  }
  
  public static String a()
  {
    if (bbtm.a().a() == null) {
      return "";
    }
    return a().getString("uin", "");
  }
  
  public static void a(long paramLong)
  {
    if (bbtm.a().a() == null) {
      return;
    }
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putLong("lastTime", paramLong);
    localEditor.commit();
  }
  
  public static void a(String paramString)
  {
    if (bbtm.a().a() == null) {
      return;
    }
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putString("uin", paramString);
    localEditor.commit();
  }
  
  public static int b()
  {
    int j = bcfa.a(bbtm.a().a(), null).a("Common_HttpRetryCount");
    int i = j;
    if (j == 0) {
      i = 2;
    }
    return i;
  }
  
  public static long b()
  {
    long l2 = bcfa.a(bbtm.a().a(), null).a("Common_BusinessReportTimeinterval");
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 3600L;
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcfo
 * JD-Core Version:    0.7.0.1
 */