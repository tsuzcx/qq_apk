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

public class aqmj
{
  private Map<String, String> a = new HashMap();
  
  public static aqmj a(aqlg[] paramArrayOfaqlg)
  {
    Object localObject;
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "onParsed error: confFiles is empty");
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      aqmj localaqmj;
      int i;
      try
      {
        localaqmj = new aqmj();
        i = 0;
        localObject = localaqmj;
        if (i >= paramArrayOfaqlg.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaqlg[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfaqlg[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("apolloSwitch")) {
          localaqmj.a.put("apolloConfig", paramArrayOfaqlg[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("aioGameTab")) {
          localaqmj.a.put("apolloGame", paramArrayOfaqlg[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfaqlg)
      {
        QLog.e("ApolloConfig_GlobalProcessor", 1, paramArrayOfaqlg, new Object[0]);
        return null;
      }
      if (((JSONObject)localObject).has("preDownLoadRes")) {
        localaqmj.a.put("apolloPreDownload", paramArrayOfaqlg[i].jdField_a_of_type_JavaLangString);
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
        anca.a(new JSONObject(str), "base_script", false);
        amhd.a.set(true);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "rollbackConfig e:", localException);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aqmj paramaqmj)
  {
    if ((paramQQAppInterface == null) || (paramaqmj == null) || (paramaqmj.a.size() == 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "parseApolloConfBean err params");
      if (!paramBoolean) {
        aqmk.b();
      }
    }
    int i;
    do
    {
      return;
      Iterator localIterator = paramaqmj.a.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = a(paramBoolean, str1, (String)paramaqmj.a.get(str1));
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloConfBean isUpdate:", paramBoolean + ",content:", str2 });
        }
        if ("apolloConfig".equals(str1))
        {
          anca.a(str2, paramQQAppInterface, paramBoolean);
          if (paramBoolean) {
            amhd.b(false);
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if ("apolloGame".equals(str1)) {
            anca.b(paramQQAppInterface, str2, paramBoolean);
          } else if ("apolloPreDownload".equals(str1)) {
            anca.b(paramQQAppInterface, str2);
          }
        }
      }
    } while (i == 0);
    aqmm.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmj
 * JD-Core Version:    0.7.0.1
 */