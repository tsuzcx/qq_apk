import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig.1;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ammy
{
  static {}
  
  public static int a(String paramString)
  {
    int i = -1;
    SharedPreferences localSharedPreferences = ApolloGameUtil.a();
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt(paramString, -1);
    }
    return i;
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int j = -1;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (amhd)paramQQAppInterface.getManager(153);
      int i;
      if ("aio.city.game".equals(paramString))
      {
        i = j;
        if (paramQQAppInterface != null)
        {
          if (!paramQQAppInterface.d) {
            break label45;
          }
          i = ammz.d;
        }
      }
      label45:
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return i;
              i = -1;
            }
            i = j;
          } while (!"drawer.game".equals(paramString));
          i = j;
        } while (paramQQAppInterface == null);
        i = j;
      } while (!paramQQAppInterface.e);
      return ammz.b;
    }
    QLog.e("ApolloGameConfig", 1, "app is null");
    return -1;
  }
  
  public static String a(String paramString)
  {
    SharedPreferences localSharedPreferences = ApolloGameUtil.a();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString, "");
    }
    return "";
  }
  
  public static void a()
  {
    ThreadManager.post(new ApolloGameConfig.1(), 8, null, true);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = ApolloGameUtil.a();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putInt(paramString, paramInt).apply();
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = ApolloGameUtil.a();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putString(paramString1, paramString2).apply();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammy
 * JD-Core Version:    0.7.0.1
 */