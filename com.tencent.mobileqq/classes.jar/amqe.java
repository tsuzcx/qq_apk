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

public class amqe
{
  private Map<String, String> a = new HashMap();
  
  public static amqe a(amph[] paramArrayOfamph)
  {
    Object localObject;
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "onParsed error: confFiles is empty");
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      amqe localamqe;
      int i;
      try
      {
        localamqe = new amqe();
        i = 0;
        localObject = localamqe;
        if (i >= paramArrayOfamph.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfamph[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfamph[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("apolloSwitch")) {
          localamqe.a.put("apolloConfig", paramArrayOfamph[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("aioGameTab")) {
          localamqe.a.put("apolloGame", paramArrayOfamph[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfamph)
      {
        QLog.e("ApolloConfig_GlobalProcessor", 1, paramArrayOfamph, new Object[0]);
        return null;
      }
      if (((JSONObject)localObject).has("preDownLoadRes")) {
        localamqe.a.put("apolloPreDownload", paramArrayOfamph[i].jdField_a_of_type_JavaLangString);
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
        ajmr.a(new JSONObject(str), "base_script", false);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "rollbackConfig e:", localException);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, amqe paramamqe)
  {
    if ((paramQQAppInterface == null) || (paramamqe == null) || (paramamqe.a.size() == 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "parseApolloConfBean err params");
      if (!paramBoolean) {
        amqf.c();
      }
    }
    int i;
    do
    {
      return;
      Iterator localIterator = paramamqe.a.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = a(paramBoolean, str1, (String)paramamqe.a.get(str1));
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloConfBean isUpdate:", paramBoolean + ",content:", str2 });
        }
        if ("apolloConfig".equals(str1))
        {
          ajmr.a(str2, paramQQAppInterface, paramBoolean);
          if (paramBoolean) {
            airx.b(false);
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if ("apolloGame".equals(str1)) {
            ajmr.b(paramQQAppInterface, str2, paramBoolean);
          } else if ("apolloPreDownload".equals(str1)) {
            ajmr.b(paramQQAppInterface, str2);
          }
        }
      }
    } while (i == 0);
    amqh.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqe
 * JD-Core Version:    0.7.0.1
 */