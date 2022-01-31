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
import org.json.JSONObject;

public class amqf
{
  private Map<String, String> a = new HashMap();
  
  public static amqf a(ampi[] paramArrayOfampi)
  {
    Object localObject;
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "onParsed error: confFiles is empty");
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      amqf localamqf;
      int i;
      try
      {
        localamqf = new amqf();
        i = 0;
        localObject = localamqf;
        if (i >= paramArrayOfampi.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfampi[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfampi[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("apolloSwitch")) {
          localamqf.a.put("apolloConfig", paramArrayOfampi[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("aioGameTab")) {
          localamqf.a.put("apolloGame", paramArrayOfampi[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfampi)
      {
        QLog.e("ApolloConfig_GlobalProcessor", 1, paramArrayOfampi, new Object[0]);
        return null;
      }
      if (((JSONObject)localObject).has("preDownLoadRes")) {
        localamqf.a.put("apolloPreDownload", paramArrayOfampi[i].jdField_a_of_type_JavaLangString);
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
        ajmt.a(new JSONObject(str), "base_script", false);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "rollbackConfig e:", localException);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, amqf paramamqf)
  {
    if ((paramQQAppInterface == null) || (paramamqf == null) || (paramamqf.a.size() == 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "parseApolloConfBean err params");
      if (!paramBoolean) {
        amqg.c();
      }
    }
    int i;
    do
    {
      return;
      Iterator localIterator = paramamqf.a.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = a(paramBoolean, str1, (String)paramamqf.a.get(str1));
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloConfBean isUpdate:", paramBoolean + ",content:", str2 });
        }
        if ("apolloConfig".equals(str1))
        {
          ajmt.a(str2, paramQQAppInterface, paramBoolean);
          if (paramBoolean) {
            airz.b(false);
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if ("apolloGame".equals(str1)) {
            ajmt.b(paramQQAppInterface, str2, paramBoolean);
          } else if ("apolloPreDownload".equals(str1)) {
            ajmt.b(paramQQAppInterface, str2);
          }
        }
      }
    } while (i == 0);
    amqi.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqf
 * JD-Core Version:    0.7.0.1
 */