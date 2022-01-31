import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class aoll
{
  private Map<String, String> a = new HashMap();
  
  public static aoll a(aoko[] paramArrayOfaoko)
  {
    Object localObject;
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "onParsed error: confFiles is empty");
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      aoll localaoll;
      int i;
      try
      {
        localaoll = new aoll();
        i = 0;
        localObject = localaoll;
        if (i >= paramArrayOfaoko.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaoko[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("apolloSwitch")) {
          localaoll.a.put("apolloConfig", paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("aioGameTab")) {
          localaoll.a.put("apolloGame", paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfaoko)
      {
        QLog.e("ApolloConfig_GlobalProcessor", 1, paramArrayOfaoko, new Object[0]);
        return null;
      }
      if (((JSONObject)localObject).has("preDownLoadRes")) {
        localaoll.a.put("apolloPreDownload", paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
  
  public static String a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!paramBoolean) {}
    return paramString2;
  }
  
  public static void a()
  {
    try
    {
      String str = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getString("sp_key_config_script", "");
      if (!TextUtils.isEmpty(str))
      {
        QLog.d("ApolloConfig_GlobalProcessor", 1, new Object[] { "rollbackConfig scriptConfig:", str });
        alit.a(new JSONObject(str), "base_script", false);
        aknx.a.set(true);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "rollbackConfig e:", localException);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aoll paramaoll)
  {
    if ((paramQQAppInterface == null) || (paramaoll == null) || (paramaoll.a.size() == 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "parseApolloConfBean err params");
      if (!paramBoolean) {
        aolm.c();
      }
    }
    int i;
    do
    {
      return;
      Iterator localIterator = paramaoll.a.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = a(paramBoolean, str1, (String)paramaoll.a.get(str1));
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloConfBean isUpdate:", paramBoolean + ",content:", str2 });
        }
        if ("apolloConfig".equals(str1))
        {
          alit.a(str2, paramQQAppInterface, paramBoolean);
          if (paramBoolean) {
            aknx.b(false);
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if ("apolloGame".equals(str1)) {
            alit.b(paramQQAppInterface, str2, paramBoolean);
          } else if ("apolloPreDownload".equals(str1)) {
            alit.b(paramQQAppInterface, str2);
          }
        }
      }
    } while (i == 0);
    aolo.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoll
 * JD-Core Version:    0.7.0.1
 */