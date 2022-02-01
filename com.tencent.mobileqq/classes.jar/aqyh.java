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

public class aqyh
{
  private Map<String, String> a = new HashMap();
  
  public static aqyh a(aqxa[] paramArrayOfaqxa)
  {
    Object localObject;
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "onParsed error: confFiles is empty");
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      aqyh localaqyh;
      int i;
      try
      {
        localaqyh = new aqyh();
        i = 0;
        localObject = localaqyh;
        if (i >= paramArrayOfaqxa.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaqxa[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("apolloSwitch")) {
          localaqyh.a.put("apolloConfig", paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("aioGameTab")) {
          localaqyh.a.put("apolloGame", paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfaqxa)
      {
        QLog.e("ApolloConfig_GlobalProcessor", 1, paramArrayOfaqxa, new Object[0]);
        return null;
      }
      if (((JSONObject)localObject).has("preDownLoadRes")) {
        localaqyh.a.put("apolloPreDownload", paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
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
        anjy.a(new JSONObject(str), "base_script", false);
        amme.a.set(true);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "rollbackConfig e:", localException);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aqyh paramaqyh)
  {
    if ((paramQQAppInterface == null) || (paramaqyh == null) || (paramaqyh.a.size() == 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "parseApolloConfBean err params");
      if (!paramBoolean) {
        aqyi.b();
      }
    }
    int i;
    do
    {
      return;
      Iterator localIterator = paramaqyh.a.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = a(paramBoolean, str1, (String)paramaqyh.a.get(str1));
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloConfBean isUpdate:", paramBoolean + ",content:", str2 });
        }
        if ("apolloConfig".equals(str1))
        {
          anjy.a(str2, paramQQAppInterface, paramBoolean);
          if (paramBoolean) {
            amme.b(false);
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if ("apolloGame".equals(str1)) {
            anjy.b(paramQQAppInterface, str2, paramBoolean);
          } else if ("apolloPreDownload".equals(str1)) {
            anjy.c(paramQQAppInterface, str2);
          }
        }
      }
    } while (i == 0);
    aqyk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyh
 * JD-Core Version:    0.7.0.1
 */