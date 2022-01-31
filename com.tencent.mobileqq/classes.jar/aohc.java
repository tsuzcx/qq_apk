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

public class aohc
{
  private Map<String, String> a = new HashMap();
  
  public static aohc a(aogf[] paramArrayOfaogf)
  {
    Object localObject;
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "onParsed error: confFiles is empty");
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      aohc localaohc;
      int i;
      try
      {
        localaohc = new aohc();
        i = 0;
        localObject = localaohc;
        if (i >= paramArrayOfaogf.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaogf[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfaogf[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("apolloSwitch")) {
          localaohc.a.put("apolloConfig", paramArrayOfaogf[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("aioGameTab")) {
          localaohc.a.put("apolloGame", paramArrayOfaogf[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfaogf)
      {
        QLog.e("ApolloConfig_GlobalProcessor", 1, paramArrayOfaogf, new Object[0]);
        return null;
      }
      if (((JSONObject)localObject).has("preDownLoadRes")) {
        localaohc.a.put("apolloPreDownload", paramArrayOfaogf[i].jdField_a_of_type_JavaLangString);
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
        alee.a(new JSONObject(str), "base_script", false);
        akji.a.set(true);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "rollbackConfig e:", localException);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aohc paramaohc)
  {
    if ((paramQQAppInterface == null) || (paramaohc == null) || (paramaohc.a.size() == 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "parseApolloConfBean err params");
      if (!paramBoolean) {
        aohd.c();
      }
    }
    int i;
    do
    {
      return;
      Iterator localIterator = paramaohc.a.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = a(paramBoolean, str1, (String)paramaohc.a.get(str1));
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloConfBean isUpdate:", paramBoolean + ",content:", str2 });
        }
        if ("apolloConfig".equals(str1))
        {
          alee.a(str2, paramQQAppInterface, paramBoolean);
          if (paramBoolean) {
            akji.b(false);
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if ("apolloGame".equals(str1)) {
            alee.b(paramQQAppInterface, str2, paramBoolean);
          } else if ("apolloPreDownload".equals(str1)) {
            alee.b(paramQQAppInterface, str2);
          }
        }
      }
    } while (i == 0);
    aohf.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aohc
 * JD-Core Version:    0.7.0.1
 */